package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.ITaxCategory;
import com.klst.einvoice.VatBreakdown;
import com.klst.einvoice.VatBreakdownFactory;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.untdid.codelist.TaxCategoryCode;
import com.klst.untdid.codelist.TaxTypeCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;

public class TaxSubtotal extends TaxSubtotalType implements VatBreakdown, VatBreakdownFactory {

	/**
	 * {@inheritDoc}
	 */
	// implements VatBreakdownFactory
	@Override
	public VatBreakdown createVATBreakDown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode taxCode, BigDecimal taxRate) {
		return create(taxableAmount, taxAmount, taxCode, taxRate);
	}
	// factory for VatBreakdown
	static VatBreakdown create(Amount taxableAmount, Amount taxAmount, TaxCategoryCode taxCode, BigDecimal taxRate) {
		return new TaxSubtotal(taxableAmount, taxAmount, taxCode, taxRate);
	}

	private static final Logger LOG = Logger.getLogger(TaxSubtotal.class.getName());

	// copy ctor
	public TaxSubtotal(TaxSubtotalType doc) {
		super();
		if(doc!=null) {
			CopyCtor.invokeCopy(this, doc);
			LOG.fine("copy ctor:"+this);	
		}
	}

	private TaxSubtotal(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal taxRate) {
		super();
		setTaxBaseAmount(taxableAmount);
		setCalculatedTaxAmount(taxAmount);
		setTaxCategoryCodeAndRate(codeEnum, taxRate);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[TaxBaseAmount=");
		stringBuilder.append(super.getTaxableAmount()==null ? "null" : getTaxBaseAmount());
		stringBuilder.append(", CalculatedTaxAmount=");
		stringBuilder.append(super.getTaxAmount()==null ? "null" : getCalculatedTaxAmount());
		stringBuilder.append(", TaxCategory=");
		stringBuilder.append(getITaxCategory()==null ? "null" : getITaxCategory());
		stringBuilder.append("]");
		return stringBuilder.toString();
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

	private ITaxCategory getITaxCategory() {
		TaxCategoryType tc = super.getTaxCategory();
		if(tc==null) return null;
		if(tc instanceof TaxCategoryType && tc.getClass()!=TaxCategoryType.class) {
			// tc is instance of a subclass of TaxCategoryType, but not TaxCategoryType itself
			return (TaxCategory)tc;
		} else {
			return new TaxCategory(tc); 
		}
	}
	
	// BG-23.BT-118-0
	@Override
	public void setTaxType(String type) {
		//if(super.getTaxCategory()==null) super.setTaxCategory(new TaxCategory(null));
		// oder kurz:
		super.setTaxCategory(new TaxCategory(super.getTaxCategory()));
		// delegieren:
		((TaxCategory)getTaxCategory()).setTaxType(type);
	}
	@Override
	public String getTaxType() {
		return super.getTaxCategory()==null ? null : ((TaxCategory)getTaxCategory()).getTaxType();
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
	public void setTaxCategoryCodeAndRate(TaxCategoryCode taxCode, BigDecimal taxRate) {
		super.setTaxCategory(TaxCategory.create(TaxTypeCode.ValueAddedTax, taxCode, taxRate));
	}

	// BG-23.BT-118
	@Override
	public void setTaxCategoryCode(String code) {
		super.setTaxCategory(new TaxCategory(super.getTaxCategory()));
		((TaxCategory)getTaxCategory()).setTaxCategoryCode(code);
	}
	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		super.setTaxCategory(new TaxCategory(super.getTaxCategory()));
		((TaxCategory)getTaxCategory()).setTaxCategoryCode(code);
	}
	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		return TaxCategoryCode.valueOf(super.getTaxCategory());
	}

	// BG-23.BT-119
	@Override
	public void setTaxPercentage(BigDecimal taxRate) {
//		if(taxRate==null) return;
//		super.setPercent(new Percent(taxRate));
		super.setTaxCategory(new TaxCategory(super.getTaxCategory()));
		((TaxCategory)getTaxCategory()).setTaxPercentage(taxRate);
	}

	@Override
	public BigDecimal getTaxPercentage() {
//		PercentType percent = super.getTaxCategory().getPercent();
//		return percent==null ? null : percent.getValue();
		if(super.getTaxCategory()==null) return null;
		super.setTaxCategory(new TaxCategory(super.getTaxCategory()));
		return ((TaxCategory)getTaxCategory()).getTaxPercentage();
	}

	/**
	 * VAT exemption reason text and code
	 * 
	 * @see com.klst.einvoice.VatBreakdown#setTaxExemption(java.lang.String, java.lang.String)
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
