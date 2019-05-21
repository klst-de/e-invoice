package com.klst.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonType;

/**
 * VatCategory contains elements used in Group VAT BREAKDOWN (BG-23) and VAT INFORMATION (BG-30)
 * <p> 
 * BG-23 : VAT BREAKDOWN - A group of business terms providing information about VAT breakdown
 * by different categories, rates and exemption reasons
 * <br>Cardinality: 1..n (mandatory)
 * <br>Req.ID: R38, R45, R47, R48, R49
 * <p> 
 * BG-30 : LINE VAT INFORMATION - A group of business terms providing information about the VAT
 * applicable for the goods and services invoiced on the Invoice line.
 * <br>Cardinality: 1..1 (mandatory)
 * <br>Req.ID: R45, R48
 */
public class VatCategory extends TaxCategoryType {

	/**
	 * Value added tax. 
	 * <p>
	 * Code according to <A HREF="http://www.unece.org/trade/untdid/d13b/tred/tred5153.htm">UN/EDIFACT 5153</A>  
	 * <p>
	 * A tax on domestic or imported goods applied to the value added 
	 * at each stage in the production/distribution cycle.
	 */
	public static final String VAT = "VAT";
	
	public VatCategory() {
		super();
	}
	
	public VatCategory(TaxCategoryType taxCategory) {
		this();
		super.setPercent(taxCategory.getPercent());
		super.setID(taxCategory.getID());
		super.setTaxScheme(taxCategory.getTaxScheme());
	}
	
	public VatCategory(TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		this();
		
		IDType taxID = new IDType();
		taxID.setValue(taxCategoryCode.getValue());
		
		PercentType percentType = new PercentType();
		percentType.setValue(taxRate);
			
		TaxSchemeType taxScheme = new TaxSchemeType();
		IDType taxSchemeID = new IDType();
		taxSchemeID.setValue(VAT); // const
		taxScheme.setID(taxSchemeID);
		
		TaxCategoryType taxCategory = new TaxCategoryType();
		taxCategory.setTaxScheme(taxScheme);
		taxCategory.setID(taxID);
		taxCategory.setPercent(percentType);
	}

	/**
	 * Coded identification of a VAT category. Entries of UNTDID 5305 are used.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BT-118, BT-151 
	 * <br>Req.ID: R38, R45, R49; R37, R45, R48, R55
	 * 
	 * @return Code
	 */
	public String getTaxCategoryCode() {
		return getID().getValue();
	}
	
	/**
	 * The VAT rate, represented as percentage that applies to the VAT category.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-119, BT-152
	 * <br>Req.ID: R38, R49; R37, R45, R48
	 * 
	 * @return Percent
	 */
	public BigDecimal getTaxRate() {
		PercentType percent = this.getPercent();
		return percent==null ? null : percent.getValue();
	}
	
	private String getTaxRateAsString() {
		BigDecimal rate = getTaxRate();
		return rate==null ? "" : rate.toString()+"%";
	}
	
	/**
	 * VAT exemption reason text
	 * <p>
	 * A textual statement of the reason why the amount is exempted from VAT or why no VAT is being charged
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-120
	 * <br>Req.ID: R48, R49, R51
	 * 
	 * @return List<String>
	 */
	public List<String> getTaxExemptionReasons() {
		List<TaxExemptionReasonType> taxExemptionReasons = this.getTaxExemptionReason();
		List<String> resultList = new ArrayList<String>(taxExemptionReasons.size());
		taxExemptionReasons.forEach(taxExemptionReason -> {
			resultList.add(taxExemptionReason.getValue());
		});
		return resultList;
	}

	public void addTaxExemptionReason(String reasonText) {
		TaxExemptionReasonType taxExemptionReason = new TaxExemptionReasonType();
		taxExemptionReason.setValue(reasonText);
		this.getTaxExemptionReason().add(taxExemptionReason);
	}
	
	/**
	 * VAT exemption reason code
	 * <p>
	 * A coded statement of the reason for why the amount is exempted from VAT.
	 * Code list issued and maintained by the Connecting Europe Facility.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-121
	 * <br>Req.ID: R48, R49, R51, R55
	 * 
	 * @return List<String>
	 */
	public String getTaxExemptionReasonCodeAsString() {
		TaxExemptionReasonCodeType taxExemptionReasonCode = this.getTaxExemptionReasonCode();	
		return taxExemptionReasonCode==null ? null : taxExemptionReasonCode.getValue();
	}

	public void setTaxExemptionReasonCode(String reasonCode) {
		TaxExemptionReasonCodeType taxExemptionReasonCode = new TaxExemptionReasonCodeType();
		taxExemptionReasonCode.setValue(reasonCode);
		super.setTaxExemptionReasonCode(taxExemptionReasonCode);
	}

	@Override
	public String toString() {
		// TODO json
		List<String> reasonTexts = getTaxExemptionReasons();
		String joined = String.join("], [", reasonTexts);
		if(!joined.isEmpty()) {
			joined = " + ["+joined+"]";
		}
		return this.getID().getValue() + " " + getTaxRateAsString()+" - " + VAT + joined;
	}
}
