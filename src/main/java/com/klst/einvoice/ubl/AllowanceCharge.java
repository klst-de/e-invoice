package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceChargeReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceChargeReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MultiplierFactorNumericType;

/*

Bsp 02.01:
  <cac:AllowanceCharge>
    <cbc:ChargeIndicator>true</cbc:ChargeIndicator>                    <!-- true : ZUSCHLAG / CHARGES -->
    <cbc:AllowanceChargeReasonCode>TAC</cbc:AllowanceChargeReasonCode> <!-- TAC : kein gültiger Cade -->
    <cbc:AllowanceChargeReason>Testing</cbc:AllowanceChargeReason>
    <cbc:MultiplierFactorNumeric>0</cbc:MultiplierFactorNumeric>
    <cbc:Amount currencyID="EUR">0</cbc:Amount>
    <cbc:BaseAmount currencyID="EUR">0</cbc:BaseAmount>
    <cac:TaxCategory>
      <cbc:ID>E</cbc:ID>
      <cbc:Percent>0</cbc:Percent>
      <cac:TaxScheme>
        <cbc:ID>VAT</cbc:ID>
      </cac:TaxScheme>
    </cac:TaxCategory>
  </cac:AllowanceCharge>
  <cac:AllowanceCharge>
    <cbc:ChargeIndicator>false</cbc:ChargeIndicator>                   <!-- false : ABSCHLAG / ALLOWANCE -->
    <cbc:AllowanceChargeReasonCode>102</cbc:AllowanceChargeReasonCode> <!-- Fixed long term -->
    <cbc:AllowanceChargeReason>Fixed long term</cbc:AllowanceChargeReason>
    <cbc:MultiplierFactorNumeric>0</cbc:MultiplierFactorNumeric>
    <cbc:Amount currencyID="EUR">0</cbc:Amount>
    <cbc:BaseAmount currencyID="EUR">0</cbc:BaseAmount>
    <cac:TaxCategory>
      <cbc:ID>E</cbc:ID>
      <cbc:Percent>0</cbc:Percent>
      <cac:TaxScheme>
        <cbc:ID>VAT</cbc:ID>
      </cac:TaxScheme>
    </cac:TaxCategory>
  </cac:AllowanceCharge>


 */
public class AllowanceCharge extends AllowanceChargeType implements AllowancesAndCharges {

	private static final Logger LOG = Logger.getLogger(AllowanceCharge.class.getName());
	
	// das erste element der Liste taxCategory aus super
	TaxCategory taxCategory = null;
	
	// copy ctor
	AllowanceCharge(AllowanceChargeType doc) {
		super();
		this.setChargeIndicator(doc.getChargeIndicator());
		this.setAmountWithoutTax(getAmountWithoutTax(doc));
		this.setAssessmentBase(getAssessmentBase(doc));
		this.setPercentage(getPercentage(doc));
		
		List<TaxCategoryType> list = doc.getTaxCategory();
		list.forEach(el -> {
			taxCategory = TaxCategory.createTaxCategory(el);
			LOG.fine("add taxCategory:"+taxCategory);
			super.getTaxCategory().add(taxCategory);
		});
		this.setReasonText(getReasonText(doc));
		this.setReasoncode(getReasoncode(doc));
	}

	@Override
	public void setChargeIndicator(boolean indicator) {
		ChargeIndicatorType chargeIndicator = new ChargeIndicatorType();
		chargeIndicator.setValue(indicator);
		super.setChargeIndicator(chargeIndicator);
	}

	@Override
	public boolean isAllowance() {
		return AllowancesAndCharges.ALLOWANCE==super.getChargeIndicator().isValue();
	}

	@Override
	public boolean isCharge() {
		return AllowancesAndCharges.CHARGE==super.getChargeIndicator().isValue();
	}

	@Override
	public void setAmountWithoutTax(Amount amount) {
		AmountType amt = new AmountType();
		amount.copyTo(amt);
		super.setAmount(amt);
	}

	@Override
	public Amount getAmountWithoutTax() {
		return getAmountWithoutTax(this);
	}
	private static Amount getAmountWithoutTax(AllowanceChargeType doc) {
		AmountType amount = doc.getAmount();
		return amount==null? null : new Amount(amount.getCurrencyID(), amount.getValue());	
	}

	@Override
	public void setAssessmentBase(Amount amount) {
		BaseAmountType baseAmount = new BaseAmountType();
		amount.copyTo(baseAmount);
		super.setBaseAmount(baseAmount);
	}

	@Override
	public Amount getAssessmentBase() {
		return getAssessmentBase(this);
	}
	private static Amount getAssessmentBase(AllowanceChargeType doc) {
		BaseAmountType amount = doc.getBaseAmount();
		return amount==null? null : new Amount(amount.getCurrencyID(), amount.getValue());	
	}

	@Override
	public void setPercentage(BigDecimal percentage) {
		if(percentage==null) return;
		MultiplierFactorNumericType factor = new MultiplierFactorNumericType();
		factor.setValue(percentage);
		super.setMultiplierFactorNumeric(factor);
	}

	@Override
	public BigDecimal getPercentage() {
		return getPercentage(this);
	}
	private static BigDecimal getPercentage(AllowanceChargeType doc) {
		MultiplierFactorNumericType factor = doc.getMultiplierFactorNumeric();
		return factor==null? null : factor.getValue();
	}

	@Override
	public void setTaxType(String code) {
		taxCategory.setTaxType(code);
	}

	@Override
	public String getTaxType() {
		return taxCategory.getTaxType();
	}

	@Override
	public void setTaxCategoryCode(String code) {
		taxCategory.setTaxCategoryCode(code);
	}

	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		taxCategory.setTaxCategoryCode(code);
	}

	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		return taxCategory.getTaxCategoryCode();
	}

	@Override
	public void setTaxPercentage(BigDecimal percentage) {
		taxCategory.setTaxPercentage(percentage);
	}

	@Override
	public BigDecimal getTaxPercentage() {
		return taxCategory.getTaxPercentage();
	}

	@Override
	public void setReasonText(String text) {
		if(text==null) return;
		AllowanceChargeReasonType allowanceChargeReason = new AllowanceChargeReasonType();
		allowanceChargeReason.setValue(text);
		super.getAllowanceChargeReason().add(allowanceChargeReason);
	}

	@Override
	public String getReasonText() {
		return getReasonText(this);
	}
	private static String getReasonText(AllowanceChargeType doc) {
		List<AllowanceChargeReasonType> list = doc.getAllowanceChargeReason();
		return list.isEmpty()? null : list.get(0).getValue();
	}

	@Override
	public void setReasoncode(String code) {
		if(code==null) return;
		AllowanceChargeReasonCodeType allowanceChargeReasonCode = new AllowanceChargeReasonCodeType();
		allowanceChargeReasonCode.setValue(code);
		super.setAllowanceChargeReasonCode(allowanceChargeReasonCode);
	}

	@Override
	public String getReasoncode() {
		return getReasoncode(this);
	}
	private static String getReasoncode(AllowanceChargeType doc) {
		AllowanceChargeReasonCodeType code = doc.getAllowanceChargeReasonCode();
		return code==null? null : code.getValue();
	}

}
