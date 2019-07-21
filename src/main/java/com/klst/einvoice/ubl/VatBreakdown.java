package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.util.List;

import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;

public class VatBreakdown extends TaxSubtotalType implements CoreInvoiceVatBreakdown {

	VatBreakdown() {
		super();
	}

	// copy ctor
	public VatBreakdown(TaxSubtotalType tradeTax) {
		this();
		List<TaxExemptionReasonType> taxExemptionReasonList = tradeTax.getTaxCategory().getTaxExemptionReason();
		TaxExemptionReasonCodeType tec = tradeTax.getTaxCategory().getTaxExemptionReasonCode();
		init( new Amount(tradeTax.getTaxableAmount().getCurrencyID(), tradeTax.getTaxableAmount().getValue())
			, new Amount(tradeTax.getTaxAmount().getCurrencyID(), tradeTax.getTaxAmount().getValue())
			, TaxCategoryCode.valueOf(tradeTax.getTaxCategory())
			, tradeTax.getTaxCategory().getPercent()==null ? null : tradeTax.getTaxCategory().getPercent().getValue()
			, taxExemptionReasonList.isEmpty() ? null : taxExemptionReasonList.get(0).getValue()
			, tec==null ? null : tec.getValue()
			);
	}

	public VatBreakdown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal percent, String exemptionText, String exemptionCode) {
		this();
		init(taxableAmount, taxAmount, codeEnum, percent, exemptionText, exemptionCode);
	}

	/**
	 * mandatory elements of VAT BREAKDOWN BG-23
	 * 
	 * @param taxableAmount BT-116 BasisAmount
	 * @param taxAmount     BT-117 CalculatedAmount
	 * @param codeEnum      BT-118 CategoryCode
	 * @param taxRate       BT-119 RateApplicablePercent
	 * @param exemptionText BT-120
	 * @param exemptionCode BT-121
	 */
	void init(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal taxRate, String exemptionText, String exemptionCode) {
		setTaxBaseAmount(taxableAmount);
		setCalculatedTaxAmount(taxAmount);
//		setTaxCategoryCodeAndRate(codeEnum, taxRate);
		setTaxCategoryAndRate(codeEnum, CoreInvoiceVatBreakdown.VAT, taxRate==null ? null : new Percent(taxRate)
				, exemptionText, exemptionCode);
	}

	@Override
	public void setTaxBaseAmount(Amount taxBaseAmount) {
		TaxableAmountType amount = new TaxableAmountType();
		taxBaseAmount.copyTo(amount);
		super.setTaxableAmount(amount);
	}

	@Override
	public Amount getTaxBaseAmount() {
		return new Amount(super.getTaxableAmount().getValue());
	}

	@Override
	public void setCalculatedTaxAmount(Amount taxAmount) {
		TaxAmountType amount = new TaxAmountType();
		taxAmount.copyTo(amount);
		super.setTaxAmount(amount);
	}

	@Override
	public Amount getCalculatedTaxAmount() {
		return new Amount(super.getTaxAmount().getValue());
	}

	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, String vat, Percent taxRate, String exemptionText, String exemptionCode) {
		TaxCategoryType taxCategory = new TaxCategoryType();
		taxCategory.setID(Invoice.newIDType(codeEnum.getValue(), null));
		
		TaxSchemeType taxScheme = new TaxSchemeType();
		taxScheme.setID(Invoice.newIDType(vat, null)); // USt/VAT
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
	 * non public - use ctor
	 * 
 	 * set tax category code and rate
	 * 
	 * @param codeEnum BT-118
	 * @param percent  BT-119
	 */
// TODO raus	@Override
	public void setTaxCategoryCodeAndRate(TaxCategoryCode codeEnum, BigDecimal taxRate) {
		setTaxCategoryAndRate(codeEnum, CoreInvoiceVatBreakdown.VAT, taxRate==null ? null : new Percent(taxRate), null, null);
	}

// TODO raus	@Override
	public void setTaxCategoryCode(TaxCategoryCode code) {
		setTaxCategoryCodeAndRate(code, null);	
	}

	@Override
	public TaxCategoryCode getTaxCategoryCode() {
		return TaxCategoryCode.valueOf(super.getTaxCategory());
	}

// TODO raus	@Override
	public void setTaxCategoryRate(BigDecimal taxableAmount) {
		// use ctor
	}

	@Override
	public BigDecimal getTaxCategoryRate() {
		PercentType percent = super.getTaxCategory().getPercent();
		return percent==null ? null : percent.getValue();
	}

	/* ABER es muss mit cac:TaxCategory ==> als param zu setTaxCategoryCodeAndRate ==> ctor
        <cac:TaxSubtotal>   ----------------------- ein VatBreakdown
            <cbc:TaxableAmount currencyID="EUR">120</cbc:TaxableAmount>  --------- gehört nicht zu VatBreakdown
            <cbc:TaxAmount currencyID="EUR">0</cbc:TaxAmount>
            
            <cac:TaxCategory>      
                <cbc:ID>O</cbc:ID>
                <cbc:Percent>0</cbc:Percent>
                <cbc:TaxExemptionReason>als gemeinnützig anerkannt</cbc:TaxExemptionReason>
                <cac:TaxScheme>
                    <cbc:ID>VAT</cbc:ID>
                </cac:TaxScheme>
            </cac:TaxCategory>
            
        </cac:TaxSubtotal>
 
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceVatBreakdown#setTaxExemption(java.lang.String, java.lang.String)
	 */
// raus 	@Override
	public void setTaxExemption(String text, String code) {
		if(text!=null) {
			// TODO   === ctor
		}
		
	}

	@Override
	public String getTaxExemptionReasonText() { // TODO TaxCategory ID == ServicesOutsideScope oder Percent==0 suchen
		List<TaxExemptionReasonType> list = super.getTaxCategory().getTaxExemptionReason();
		if(list.isEmpty()) return null;
		if(list.size()==1) return list.get(0)==null ? null : list.get(0).getValue();
		// TODO TaxCategory ID == ServicesOutsideScope oder Percent==0 suchen
		return null;
	}

	@Override
	public String getTaxExemptionReasonCode() {
		TaxExemptionReasonCodeType tec = super.getTaxCategory().getTaxExemptionReasonCode();
		return tec==null ? null : tec.getValue();
	}

}
