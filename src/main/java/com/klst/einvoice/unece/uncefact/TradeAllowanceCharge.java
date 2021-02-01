package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.AllowanceChargeReasonCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAllowanceChargeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IndicatorType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;

/*

CII: ApplicableHeaderTradeSettlement ...
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

 */
public class TradeAllowanceCharge extends TradeAllowanceChargeType implements AllowancesAndCharges {

	private static final Logger LOG = Logger.getLogger(TradeAllowanceCharge.class.getName());

	// copy ctor
	TradeAllowanceCharge(TradeAllowanceChargeType tradeAllowanceCharge) {
		super();
		if(tradeAllowanceCharge!=null) {
			CopyCtor.invokeCopy(this, tradeAllowanceCharge);
			if(getCategoryTradeTax().isEmpty()) {
				LOG.warning("CategoryTradeTax is empty, expected one element.");
			}
		}
		LOG.fine("copy ctor:"+this);
	}
	
	@Override
	public void setChargeIndicator(boolean value) {
		IndicatorType indicator = new IndicatorType();
		indicator.setIndicator(value);
		super.setChargeIndicator(indicator);
	}
	
	@Override
	public boolean isAllowance() {
		return isAllowance(this);
	}
	static boolean isAllowance(TradeAllowanceChargeType tradeAllowanceCharge) {
		IndicatorType indicator = tradeAllowanceCharge.getChargeIndicator();
		IndicatorType allowance = new IndicatorType();
		allowance.setIndicator(AllowancesAndCharges.ALLOWANCE);
		return indicator.equals(allowance);
	}

	@Override
	public boolean isCharge() {
		return isCharge(this);
	}
	static boolean isCharge(TradeAllowanceChargeType tradeAllowanceCharge) {
		IndicatorType indicator = tradeAllowanceCharge.getChargeIndicator();
		IndicatorType charge = new IndicatorType();
		charge.setIndicator(AllowancesAndCharges.CHARGE);
		return indicator.equals(charge);
	}

	// BT-92, BT-99 (mandatory) Document level allowance/charge amount
	@Override
	public void setAmountWithoutTax(Amount amount) {
		AmountType actualAmt = new AmountType();
		amount.copyTo(actualAmt);
		super.getActualAmount().add(actualAmt);
	}

	@Override
	public Amount getAmountWithoutTax() {
		return getAmountWithoutTax(this);
	}
	static Amount getAmountWithoutTax(TradeAllowanceChargeType tradeAllowanceCharge) {
		List<AmountType> list = tradeAllowanceCharge.getActualAmount();
		if(list.isEmpty()) return null; // sollte nicht vorkommen, da mandatory
		// nur das erste Element holen und kopieren:
		AmountType amount = list.get(0);
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}

	// BT-93, BT100 (optional) Document level allowance/charge base amount
	@Override
	public void setAssessmentBase(Amount amount) {
		if(amount==null) return;
		AmountType baseAmt = new AmountType();
		amount.copyTo(baseAmt);
		super.setBasisAmount(baseAmt);
	}

	@Override
	public Amount getAssessmentBase() {
		return getAssessmentBase(this);
	}
	static Amount getAssessmentBase(TradeAllowanceChargeType tradeAllowanceCharge) {
		AmountType amount = tradeAllowanceCharge.getBasisAmount();
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
		return getPercentage(this);
	}
	static BigDecimal getPercentage(TradeAllowanceChargeType tradeAllowanceCharge) {
		PercentType percent = tradeAllowanceCharge.getCalculationPercent();
		return percent==null ? null : percent.getValue();
	}

	// null or first Element, because of 1..1 CategoryTradeTax
	private static TradeTax getFirstCategoryTradeTax(TradeAllowanceChargeType tradeAllowanceCharge) {
		List<TradeTaxType> categoryTradeTax = tradeAllowanceCharge.getCategoryTradeTax();
		if(categoryTradeTax.isEmpty()) return null; // sollte nicht vorkommen, da mandatory
		
		// nur das erste Element holen:
		TradeTaxType tradeTax = categoryTradeTax.get(0);
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(tradeTax instanceof TradeTaxType && tradeTax.getClass()!=TradeTaxType.class) {
			// tradeTax an instance of a subclass of TradeTaxType, but not TradeTaxType itself
			return (TradeTax)tradeTax;
		}
		// copy ctor:
		return new TradeTax(tradeTax);
	}
	
	// BT-95-0, BT-102-0
	@Override
	public void setTaxType(String type) {
		TradeTax tradeTax = getFirstCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.warning("tradeTax==null, expected one element.");
		}
		tradeTax.setTaxType(type);
	}

	@Override // liefert immer "VAT"
	public String getTaxType() {
		return getTaxType(this);
	}
	static String getTaxType(TradeAllowanceChargeType tradeAllowanceCharge) {
		TradeTax tradeTax = getFirstCategoryTradeTax(tradeAllowanceCharge);
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
			LOG.warning("tradeTax==null, expected one element.");
		}
		tradeTax.setTaxCategoryCode(category);
	}

	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		return getTaxCategoryCode(this);
	}
	static TaxCategoryCode getTaxCategoryCode(TradeAllowanceChargeType tradeAllowanceCharge) {
		TradeTax tradeTax = getFirstCategoryTradeTax(tradeAllowanceCharge);
		return tradeTax==null? null : tradeTax.getTaxCategoryCode();
	}

	// BT-96, BT103 0..1 Document level allowance/charge VAT rate
	@Override
	public void setTaxPercentage(BigDecimal percentage) {
		if(percentage==null) return;
		TradeTax tradeTax = getFirstCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.warning("tradeTax==null, expected one element.");
		}
		tradeTax.setTaxPercentage(percentage);
	}

	@Override
	public BigDecimal getTaxPercentage() {
		return getTaxPercentage(this);
	}
	static BigDecimal getTaxPercentage(TradeAllowanceChargeType tradeAllowanceCharge) {
		TradeTax tradeTax = getFirstCategoryTradeTax(tradeAllowanceCharge);
		return tradeTax==null? null : tradeTax.getTaxPercentage();
	}

	// BT-97, BT-104 0..1 Document level allowance/charge reason
	@Override
	public void setReasonText(String text) {
		if(text==null) return;		
		Text allowanceChargeReasonCode = new Text(text);
		super.setReason(allowanceChargeReasonCode);
	}

	@Override
	public String getReasonText() {
		return getReasonText(this);
	}
	static String getReasonText(TradeAllowanceChargeType tradeAllowanceCharge) {
		return tradeAllowanceCharge.getReason()==null? null : tradeAllowanceCharge.getReason().getValue();
	}

	// BT-98, BT-103 0..1 Document level allowance/charge reason code
	@Override
	public void setReasoncode(String code) {
		if(code==null) return; 
		AllowanceChargeReasonCodeType allowanceChargeReasonCode = new AllowanceChargeReasonCodeType();
		allowanceChargeReasonCode.setValue(code);
		super.setReasonCode(allowanceChargeReasonCode);
	}

	@Override
	public String getReasoncode() {
		return getReasoncode(this);
	}
	static String getReasoncode(TradeAllowanceChargeType tradeAllowanceCharge) {
		return tradeAllowanceCharge.getReasonCode()==null? null : tradeAllowanceCharge.getReasonCode().getValue();
	}

}
