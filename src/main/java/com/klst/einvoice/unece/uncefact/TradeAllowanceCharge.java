package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.IAmount;
import com.klst.edoc.untdid.TaxCategoryCode;
import com.klst.einvoice.api.AllowancesAndCharges;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAllowanceChargeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;

/*
Bsp 02.01:
   ApplicableHeaderTradeSettlement ...
            <ram:SpecifiedTradeAllowanceCharge>
                <ram:ChargeIndicator>
                    <udt:Indicator>true</udt:Indicator>
                </ram:ChargeIndicator>
                <ram:CalculationPercent>0</ram:CalculationPercent>
                <ram:BasisAmount>0</ram:BasisAmount>
                <ram:ActualAmount>0</ram:ActualAmount>
                <ram:ReasonCode>TAC</ram:ReasonCode>
                <ram:Reason>Testing</ram:Reason>
                <ram:CategoryTradeTax>
                    <ram:TypeCode>VAT</ram:TypeCode>
                    <ram:CategoryCode>E</ram:CategoryCode>
                    <ram:RateApplicablePercent>0</ram:RateApplicablePercent>
                </ram:CategoryTradeTax>
            </ram:SpecifiedTradeAllowanceCharge>
            <ram:SpecifiedTradeAllowanceCharge>
                <ram:ChargeIndicator>
                    <udt:Indicator>false</udt:Indicator>
                </ram:ChargeIndicator>
                <ram:CalculationPercent>0</ram:CalculationPercent>
                <ram:BasisAmount>0</ram:BasisAmount>
                <ram:ActualAmount>0</ram:ActualAmount>
                <ram:ReasonCode>102</ram:ReasonCode>
                <ram:Reason>Fixed long term</ram:Reason>
                <ram:CategoryTradeTax>
                    <ram:TypeCode>VAT</ram:TypeCode>
                    <ram:CategoryCode>E</ram:CategoryCode>
                    <ram:RateApplicablePercent>0</ram:RateApplicablePercent>
                </ram:CategoryTradeTax>
            </ram:SpecifiedTradeAllowanceCharge>

0 .. n SpecifiedTradeAllowanceCharge Zu- und Abschläge auf Dokumentenebene           BG-20, BG-21
 1 .. 1 ChargeIndicator Schalter für Zu-/Abschlag                                     BG-20-0 , BG-21-0  xs:choice
  1 .. 1 Indicator Schalter für Zu-/Abschlag, Wert                                     BG-20-00, BG-21-00
 0 .. 1 SequenceNumeric Berechnungsreihenfolge
 0 .. 1 CalculationPercent Prozentualer Zu- oder Abschlag auf Dokumentenebene         BT-94, BT-101
 0 .. 1 BasisAmount Grundbetrag des Zu- oder Abschlags auf Dokumentenebene            BT-93, BT-100
 0 .. 1 BasisQuantity Basismenge des Rabatts required unitCode Einheit der Preisbasismenge
 1 .. 1 ActualAmount Betrag des Zu- oder Abschlags auf Dokumentenebene                BT-92, BT-99
 0 .. 1 ReasonCode Code für den Grund für den Zu- oder Abschlag auf Dokumentenebene   BT-98, BT-105
 0 .. 1 Reason Grund für den Zu- oder Abschlag auf Dokumentenebene                    BT-97, BT-104
 1 .. 1 CategoryTradeTax Detailinformationen zu Steuerangaben                                       xs:sequence
  1 .. 1 TypeCode Code für die Umsatzsteuerkategorie 
          des Zu- oder Abschlages auf Dokumentenebene                                  BT-95-0, BT-102-0
  1 .. 1 CategoryCode Code für die Umsatzsteuerkategorie 
          des Zu- oder Abschlages auf Dokumentenebene                                  BT-95  , BT-102
  0 .. 1 RateApplicablePercent Umsatzsteuersatz 
          für den Zu- oder Abschlag auf Dokumentenebene                                BT-96  , BT-103

 */
public class TradeAllowanceCharge extends TradeAllowanceChargeType implements AllowancesAndCharges {

	private static final String NO_TRADETAX_ELEMENT = "No TradeTax. Expected one element.";
	private static final String CREATE_TRADETAX_ELEMENT = " Create TradeTax silently.";
	private static final Logger LOG = Logger.getLogger(TradeAllowanceCharge.class.getName());

	// factory:
	@Override
	public AllowancesAndCharges createAllowance(IAmount amount, IAmount baseAmount, BigDecimal percentage) {
		return create(AllowancesAndCharges.ALLOWANCE, amount, baseAmount, percentage);
	}
	@Override
	public AllowancesAndCharges createCharge(IAmount amount, IAmount baseAmount, BigDecimal percentage) {
		return create(AllowancesAndCharges.CHARGE, amount, baseAmount, percentage);
	}

	/*
	 * used in TradeLineItem
	 * @see TradeLineItem#setUnitPriceAllowance
	 */
	static TradeAllowanceCharge create(boolean chargeIndicator, IAmount amount, IAmount baseAmount, BigDecimal percentage) {
		return new TradeAllowanceCharge(chargeIndicator, amount, baseAmount, percentage);
	}
	static TradeAllowanceCharge create() {
		return new TradeAllowanceCharge(null);
	}
	// copy factory
	static TradeAllowanceCharge create(TradeAllowanceChargeType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof TradeAllowanceChargeType && object.getClass()!=TradeAllowanceChargeType.class) {
			// tt is instance of a subclass of TradeAllowanceChargeType, but not TradeAllowanceChargeType itself
			return (TradeAllowanceCharge)object;
		} else {
			return new TradeAllowanceCharge(object); 
		}
	}

	private TradeAllowanceCharge(boolean chargeIndicator, IAmount amount, IAmount baseAmount, BigDecimal percentage) {
		super();
		setChargeIndicator(chargeIndicator);
		setAmountWithoutTax(amount);
		setAssessmentBase(baseAmount);
		setPercentage(percentage);
	}
	// copy ctor
	private TradeAllowanceCharge(TradeAllowanceChargeType tradeAllowanceCharge) {
		super();
		if(tradeAllowanceCharge!=null) {
			SCopyCtor.getInstance().invokeCopy(this, tradeAllowanceCharge);
			if(getCategoryTradeTax().isEmpty()) {
				LOG.warning(NO_TRADETAX_ELEMENT);
			}
			LOG.fine("copy ctor:"+this);
		}
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder().append("[");
		if(isAllowance()) stringBuilder.append("ALLOWANCE");
		if(isCharge()) stringBuilder.append("CHARGE"); // BG-21
		
		stringBuilder.append(", AmountWithoutTax:"); // BT-99
		stringBuilder.append(getAmountWithoutTax()==null ? "null" : getAmountWithoutTax());
		stringBuilder.append(", AssessmentBase:");   // BT-100
		stringBuilder.append(getAssessmentBase()==null ? "null" : getAssessmentBase());
		stringBuilder.append(", %rate:");            // BT-101
		stringBuilder.append(getPercentage()==null ? "null" : getPercentage());
		
		stringBuilder.append(", tax:");   // BT-102-0
		stringBuilder.append(getTaxType()==null ? "null" : getTaxType());
		stringBuilder.append("/");        // BT-102
		stringBuilder.append(getTaxCategoryCode()==null ? "null" : getTaxCategoryCode());
		stringBuilder.append(", tax%:");  // BT-103
		stringBuilder.append(getTaxPercentage()==null ? "null" : getTaxPercentage());
		
		stringBuilder.append(", Reasoncode:"); // BT-104
		stringBuilder.append(getReasoncode()==null ? "null" : getReasoncode());
		stringBuilder.append(", ReasonText:"); // BT-105
		stringBuilder.append(getReasonText()==null ? "null" : getReasonText());
		
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@Override
	public void setChargeIndicator(boolean value) {
		SCopyCtor.getInstance().set(this, "chargeIndicator", value);
	}
	
	@Override
	public boolean isAllowance() {
		IndicatorType indicator = super.getChargeIndicator();
		return indicator!=null && indicator.isIndicator().equals(AllowancesAndCharges.ALLOWANCE);
	}

	@Override
	public boolean isCharge() {
		IndicatorType indicator = super.getChargeIndicator();
		return indicator!=null && indicator.isIndicator().equals(AllowancesAndCharges.CHARGE);
	}

	// BT-92, BT-99 (mandatory) Document level allowance/charge amount
	@Override
	public void setAmountWithoutTax(IAmount amount) {
		AmountType actualAmt = new AmountType();
		((Amount)amount).copyTo(actualAmt);
		super.getActualAmount().add(actualAmt);
	}

	@Override
	public IAmount getAmountWithoutTax() {
		List<AmountType> list = super.getActualAmount();
		if(list.isEmpty()) return null; // sollte nicht vorkommen, da mandatory
		// nur das erste Element holen und kopieren:
		AmountType amount = list.get(0);
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}

	// BT-93, BT100 (optional) Document level allowance/charge base amount
	@Override
	public void setAssessmentBase(IAmount amount) {
		SCopyCtor.getInstance().set(this, "basisAmount", (Amount)amount);
	}

	@Override
	public IAmount getAssessmentBase() {
		AmountType amount = super.getBasisAmount();
		return amount==null? null : new Amount(amount.getCurrencyID(), amount.getValue());
	}

	// BT-94, BT101 (optional) Document level allowance/charge percentage
	@Override
	public void setPercentage(BigDecimal percentage) {
		if(percentage==null) return;
		super.setCalculationPercent(new Percent(percentage));
	}

	@Override
	public BigDecimal getPercentage() {
		PercentType percent = super.getCalculationPercent();
		return percent==null ? null : percent.getValue();
	}

	// null or first Element, because of 1..1 CategoryTradeTax
	private static TradeTax getFirstCategoryTradeTax(TradeAllowanceChargeType tradeAllowanceCharge) {
		List<TradeTaxType> categoryTradeTax = tradeAllowanceCharge.getCategoryTradeTax();
		if(categoryTradeTax.isEmpty()) return null; // sollte nicht vorkommen, da mandatory
		
		// nur das erste Element holen:
		TradeTaxType tradeTax = categoryTradeTax.get(0);
		return TradeTax.create(tradeTax);
	}
	
	// BT-95-0, BT-102-0
	@Override
	public void setTaxType(String type) {
		TradeTax tradeTax = getFirstCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.warning(NO_TRADETAX_ELEMENT + CREATE_TRADETAX_ELEMENT);
			tradeTax = TradeTax.create();
			tradeTax.setTaxType(type);
			super.getCategoryTradeTax().add(tradeTax);
		} else {
			tradeTax.setTaxType(type);
		}
	}

	@Override // liefert immer "VAT"
	public String getTaxType() {
		TradeTax tradeTax = getFirstCategoryTradeTax(this);
		return tradeTax==null? null : tradeTax.getTaxType();
	}

	// BT-95, BT-102 1..1 (mandatory) Document level allowance/charge VAT category code
	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		setTaxCategoryCode(code.getValue());
	}

	@Override
	public void setTaxCategoryCode(String category) {
		TradeTax tradeTax = getFirstCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.warning(NO_TRADETAX_ELEMENT + CREATE_TRADETAX_ELEMENT);
			tradeTax = TradeTax.create();
			tradeTax.setTaxCategoryCode(category);
			super.getCategoryTradeTax().add(tradeTax);
		} else {
			tradeTax.setTaxCategoryCode(category);
		}
	}

	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		TradeTax tradeTax = getFirstCategoryTradeTax(this);
		return tradeTax==null? null : tradeTax.getTaxCategoryCode();
	}

	// BT-96, BT-103 0..1 Document level allowance/charge VAT rate
	@Override
	public void setTaxPercentage(BigDecimal percentage) {
		if(percentage==null) return;
		TradeTax tradeTax = getFirstCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.warning(NO_TRADETAX_ELEMENT + CREATE_TRADETAX_ELEMENT);
			tradeTax = TradeTax.create();
			tradeTax.setTaxPercentage(percentage);
			super.getCategoryTradeTax().add(tradeTax);
		} else {
			tradeTax.setTaxPercentage(percentage);
		}
	}

	@Override
	public BigDecimal getTaxPercentage() {
		TradeTax tradeTax = getFirstCategoryTradeTax(this);
		return tradeTax==null? null : tradeTax.getTaxPercentage();
	}

	// BT-97, BT-104 0..1 Document level allowance/charge reason
	@Override
	public void setReasonText(String text) {
		SCopyCtor.getInstance().set(this, "reason", text);
	}

	@Override
	public String getReasonText() {
		return super.getReason()==null? null : getReason().getValue();
	}

	// BT-98, BT-103 0..1 Document level allowance/charge reason code
	@Override
	public void setReasoncode(String code) {
		SCopyCtor.getInstance().set(this, "reasonCode", code);
	}

	@Override
	public String getReasoncode() {
		return super.getReasonCode()==null? null : getReasonCode().getValue();
	}

}
