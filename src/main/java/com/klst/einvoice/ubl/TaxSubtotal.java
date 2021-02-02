package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.BG23_VatBreakdown;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.untdid.codelist.TaxCategoryCode;
import com.klst.untdid.codelist.TaxTypeCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;

public class TaxSubtotal extends TaxSubtotalType implements BG23_VatBreakdown {

	// factory for VatBreakdown
	static BG23_VatBreakdown createVATBreakDown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode taxCode, BigDecimal taxRate) {
		return new TaxSubtotal(taxableAmount, taxAmount, taxCode, taxRate);
	}

	private static final Logger LOG = Logger.getLogger(TaxSubtotal.class.getName());

	// copy ctor
	public TaxSubtotal(TaxSubtotalType doc) {
		super();
		if(doc!=null) {
			CopyCtor.invokeCopy(this, doc);
		}
		LOG.info("copy ctor: getTaxBaseAmount="+this.getTaxBaseAmount());	
	}

	// TODO toString
	
	private TaxSubtotal(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal percent) {
		super();
		init(taxableAmount, taxAmount, codeEnum, percent);
	}

	/**
	 * mandatory elements of VAT BREAKDOWN BG-23
	 * 
	 * @param taxableAmount BT-116 BasisAmount
	 * @param taxAmount     BT-117 CalculatedAmount
	 * @param codeEnum      BT-118 CategoryCode
	 * @param taxRate       BT-119 RateApplicablePercent
//	 * @param exemptionText BT-120 optional
//	 * @param exemptionCode BT-121 optional
	 */
	void init(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal taxRate) {
		init(taxableAmount, taxAmount, codeEnum, taxRate, null, null);
	}
	void init(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal taxRate, String exemptionText, String exemptionCode) {
		setTaxBaseAmount(taxableAmount);
		setCalculatedTaxAmount(taxAmount);
//		setTaxCategoryCodeAndRate(codeEnum, taxRate);
		setTaxCategoryAndRate(codeEnum, TaxTypeCode.VAT, taxRate==null ? null : new Percent(taxRate)
				, exemptionText, exemptionCode);
	}

	// BG-23.BT-116 taxBaseAmount aka taxableAmount aka basisAmount
	@Override
	public void setTaxBaseAmount(Amount taxBaseAmount) {
		TaxableAmountType amount = new TaxableAmountType();
		taxBaseAmount.copyTo(amount);
		super.setTaxableAmount(amount);
	}
	@Override
	public Amount getTaxBaseAmount() {
		if(super.getTaxableAmount()==null) return null;
		return new Amount(super.getTaxableAmount().getCurrencyID(), super.getTaxableAmount().getValue());
	}
	
	// BG-23.BT-117 calculatedTaxAmount aka taxAmount
	@Override
	public void setCalculatedTaxAmount(Amount taxAmount) {
		TaxAmountType amount = new TaxAmountType();
		taxAmount.copyTo(amount);
		super.setTaxAmount(amount);
	}

	@Override
	public Amount getCalculatedTaxAmount() {
		if(super.getTaxAmount()==null) return null;
		return new Amount(super.getTaxAmount().getCurrencyID(), super.getTaxAmount().getValue());
	}

	// BG-23.BT-118-0
	@Override
	public void setTaxType(String type) {
//		TaxSchemeType taxScheme = new TaxSchemeType();
//		taxScheme.setID(Identifier.newIDType(type, null)); // USt/VAT
//		taxCategory.setTaxScheme(taxScheme);
	}
	@Override
	public String getTaxType() {
		// TODO Auto-generated method stub
		return null;
	}

	// BG-23.BT-118
	@Override
	public void setTaxCategoryCode(String code) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		setTaxCategoryCodeAndRate(code, null);	
	}
	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		return TaxCategoryCode.valueOf(super.getTaxCategory());
	}


// TODO TaxCategory class extends TaxCategoryType verwenden
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, String vat, Percent taxRate, String exemptionText, String exemptionCode) {
		TaxCategoryType taxCategory = new TaxCategoryType();
		taxCategory.setID(new ID(codeEnum.getValue()));
		
		TaxSchemeType taxScheme = new TaxSchemeType();
		taxScheme.setID(new ID(vat)); // USt/VAT
		taxCategory.setTaxScheme(taxScheme);
		
		if(taxRate!=null) {
			taxCategory.setPercent(taxRate);
		}
		
		if(exemptionText!=null) {
			TaxExemptionReasonType taxExemptionReason = new TaxExemptionReasonType();
			taxExemptionReason.setValue(exemptionText);
			taxCategory.getTaxExemptionReason().add(taxExemptionReason);
		}
		
		if(exemptionCode!=null) {
			TaxExemptionReasonCodeType taxExemptionReasonCode = new TaxExemptionReasonCodeType();
			taxExemptionReasonCode.setValue(exemptionCode);
			taxCategory.setTaxExemptionReasonCode(taxExemptionReasonCode);
		}
            
		super.setTaxCategory(taxCategory);
	}

	/**
	 * non really public - use factory
	 * 
 	 * set tax category code and rate
	 * 
	 * @param codeEnum BT-118
	 * @param percent  BT-119
	 */
	@Override
	public void setTaxCategoryCodeAndRate(TaxCategoryCode codeEnum, BigDecimal taxRate) {
		setTaxCategoryAndRate(codeEnum, TaxTypeCode.VAT, taxRate==null ? null : new Percent(taxRate), null, null);
	}

	@Override
	public void setTaxPercentage(BigDecimal taxableAmount) {
		// use ctor
	}

	@Override
	public BigDecimal getTaxPercentage() {
		PercentType percent = super.getTaxCategory().getPercent();
		return percent==null ? null : percent.getValue();
	}

	/**
	 * VAT exemption reason text and code
	 * 
	 * @see com.klst.einvoice.BG23_VatBreakdown#setTaxExemption(java.lang.String, java.lang.String)
	 */
 	@Override
	public void setTaxExemption(String text, String code) {
 		TaxCategoryType taxCategory = super.getTaxCategory();
		if(text!=null) {
			TaxExemptionReasonType taxExemptionReason = new TaxExemptionReasonType();
			taxExemptionReason.setValue(text);
			taxCategory.getTaxExemptionReason().add(taxExemptionReason);
		}
		if(code!=null) {
			TaxExemptionReasonCodeType taxExemptionReasonCode = new TaxExemptionReasonCodeType();
			taxExemptionReasonCode.setValue(code);
			taxCategory.setTaxExemptionReasonCode(taxExemptionReasonCode);
		}
	}

	@Override
	public String getTaxExemptionReasonText() { // TODO TaxCategory ID == ServicesOutsideScope oder Percent==0 suchen
		List<TaxExemptionReasonType> list = super.getTaxCategory().getTaxExemptionReason();
		return list.isEmpty() ? null : list.get(0).getValue();
//		if(list.isEmpty()) return null;
//		if(list.size()==1) return list.get(0)==null ? null : list.get(0).getValue();
//		// TODO TaxCategory ID == ServicesOutsideScope oder Percent==0 suchen
//		return null;
	}

	@Override
	public String getTaxExemptionReasonCode() {
		TaxExemptionReasonCodeType tec = super.getTaxCategory().getTaxExemptionReasonCode();
		return tec==null ? null : tec.getValue();
	}

}
