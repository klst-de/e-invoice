package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;

import un.unece.uncefact.data.standard.qualifieddatatype._100.AllowanceChargeReasonCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
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

	TradeAllowanceCharge() {
		super();
	}
	
	// copy ctor
	TradeAllowanceCharge(TradeAllowanceChargeType tradeAllowanceCharge) {
		this();
		super.setChargeIndicator(tradeAllowanceCharge.getChargeIndicator());
		this.setAmount(getAmount(tradeAllowanceCharge));
		this.setBaseAmount(getAmount(tradeAllowanceCharge));
		this.setPercentage(getPercentage(tradeAllowanceCharge));
		this.setVAT(getVATCode(tradeAllowanceCharge), getVATCategory(tradeAllowanceCharge)
				, getVATPercentage(tradeAllowanceCharge));
		this.setReasonText(getReasonText(tradeAllowanceCharge));
		this.setReasoncode(getReasoncode(tradeAllowanceCharge));
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
	public void setAmount(Amount amount) {
		AmountType actualAmt = new AmountType();
		amount.copyTo(actualAmt);
		super.getActualAmount().add(actualAmt);
	}

	@Override
	public Amount getAmount() {
		return getAmount(this);
	}
	static Amount getAmount(TradeAllowanceChargeType tradeAllowanceCharge) {
		List<AmountType> list = tradeAllowanceCharge.getActualAmount();
		if(list.isEmpty()) return null; // sollte nicht vorkommen, da mandatory
		// nur das erste Element holen und kopieren:
		AmountType amount = list.get(0);
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}

	// BT-93, BT100 (optional) Document level allowance/charge base amount
	@Override
	public void setBaseAmount(Amount amount) {
		if(amount==null) return;
		AmountType baseAmt = new AmountType();
		amount.copyTo(baseAmt);
		super.setBasisAmount(baseAmt);
	}

	@Override
	public Amount getBaseAmount() {
		return getBaseAmount(this);
	}
	static Amount getBaseAmount(TradeAllowanceChargeType tradeAllowanceCharge) {
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

	void setVAT(String code, String category, BigDecimal percentage) {
		TradeTaxType tradeTax = getCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.info("tradeTax==null, expected one element. Create it.");
			tradeTax = new TradeTaxType();
			super.getCategoryTradeTax().add(tradeTax);
		}
		TaxTypeCodeType taxTypeCode = new TaxTypeCodeType();
		taxTypeCode.setValue(code);
		tradeTax.setTypeCode(taxTypeCode);
		
		TaxCategoryCodeType taxCategoryCode = new TaxCategoryCodeType();
		taxCategoryCode.setValue(category);
		tradeTax.setCategoryCode(taxCategoryCode);

		if(percentage==null) return;
		tradeTax.setRateApplicablePercent(new Percent(percentage));
	}
	
	// null or first Element, because of 1..1 CategoryTradeTax
	private static TradeTaxType getCategoryTradeTax(TradeAllowanceChargeType tradeAllowanceCharge) {
		List<TradeTaxType> categoryTradeTax = tradeAllowanceCharge.getCategoryTradeTax();
		if(categoryTradeTax.isEmpty()) return null; // sollte nicht vorkommen, da mandatory
		// nur das erste Element holen:
		return categoryTradeTax.get(0);
	}
	
	// BT-95-0, BT-102-0
	@Override
	public void setVATCode(String code) {
		TradeTaxType tradeTax = getCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.warning("tradeTax==null, expected one element.");
		}
		TaxTypeCodeType taxTypeCode = new TaxTypeCodeType();
		taxTypeCode.setValue(code);
		tradeTax.setTypeCode(taxTypeCode);
	}

	@Override // liefert immer "VAT"
	public String getVATCode() {
		return getVATCode(this);
	}
	static String getVATCode(TradeAllowanceChargeType tradeAllowanceCharge) {
		TradeTaxType tradeTax = getCategoryTradeTax(tradeAllowanceCharge);
		return tradeTax==null? null : tradeTax.getTypeCode().getValue();
	}

	// BT-95, BT-102 1..1 (mandatory) Document level allowance/charge VAT category code
	@Override
	public void setVATCategory(String category) {
		TradeTaxType tradeTax = getCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.warning("tradeTax==null, expected one element.");
		}
		TaxCategoryCodeType taxCategoryCode = new TaxCategoryCodeType();
		taxCategoryCode.setValue(category);
		tradeTax.setCategoryCode(taxCategoryCode);
	}

	@Override
	public String getVATCategory() {
		return getVATCategory(this);
	}
	static String getVATCategory(TradeAllowanceChargeType tradeAllowanceCharge) {
		TradeTaxType tradeTax = getCategoryTradeTax(tradeAllowanceCharge);
		return tradeTax==null? null : tradeTax.getCategoryCode().getValue();
	}

	// BT-96, BT103 0..1 Document level allowance/charge VAT rate
	@Override
	public void setVATPercentage(BigDecimal percentage) {
		if(percentage==null) return;
		TradeTaxType tradeTax = getCategoryTradeTax(this);
		if(tradeTax==null) {
			LOG.warning("tradeTax==null, expected one element.");
		}
		tradeTax.setRateApplicablePercent(new Percent(percentage));
	}

	@Override
	public BigDecimal getVATPercentage() {
		return getVATPercentage(this);
	}
	static BigDecimal getVATPercentage(TradeAllowanceChargeType tradeAllowanceCharge) {
		TradeTaxType tradeTax = getCategoryTradeTax(tradeAllowanceCharge);
		PercentType percent = tradeTax==null? null : tradeTax.getRateApplicablePercent();
		return percent==null ? null : percent.getValue();
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
