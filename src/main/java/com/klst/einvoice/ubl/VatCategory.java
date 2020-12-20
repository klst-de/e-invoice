package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import com.klst.einvoice.BG23_VatBreakdown;
import com.klst.untdid.codelist.TaxCategoryCode;
import com.klst.untdid.codelist.TaxTypeCode;

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

//	private static final Logger LOG = Logger.getLogger(VatCategory.class.getName());
	
/* beim Test von 01.04a-INVOICE_ubl.xml bekommt man @see https://github.com/klst-de/e-invoice/issues/1
Pos 	Code 	Adj. Grad (Grad) 	Text
val-sch.1.1 	BR-O-02 	error 	[BR-O-02]-An Invoice that contains an Invoice line (BG-25) where the Invoiced item VAT category code 
                                    (BT-151) is “Not subject to VAT” shall not contain the Seller VAT identifier (BT-31), 
                                    the Seller tax representative VAT identifier (BT-63) or the Buyer VAT identifier (BT-46).
                                    Pfad: /ubl:Invoice
val-sch.1.2 	BR-CO-09 	error 	[BR-CO-09]-The Seller VAT identifier (BT-31), the Seller tax representative VAT identifier (BT-63) 
                                    and the Buyer VAT identifier (BT-48) shall have a prefix in accordance with ISO code ISO 3166-1 alpha-2 
                                    by which the country of issue may be identified. Nevertheless, Greece may use the prefix ‘EL’.
                                    Pfad: /ubl:Invoice/cac:AccountingSupplierParty[1]/cac:Party[1]/cac:PartyTaxScheme[1]

daher diese Methode, so zu verwenden: VatCategory.getVatScheme("DE")
 */
	static TaxSchemeType getVatScheme(String code) {
		TaxSchemeType taxScheme = new TaxSchemeType();
		IDType taxSchemeID = new IDType();
		taxSchemeID.setValue(code);
		taxScheme.setID(taxSchemeID);
		return taxScheme;
	}

	static TaxSchemeType getVatScheme() {
		return getVatScheme(TaxTypeCode.VAT);
	}

	public VatCategory() {
		super();
	}
	
	public VatCategory(TaxCategoryType taxCategory) {
		this();
		if(taxCategory.getPercent()==null) {
			// nix, da optional
		} else {
			super.setPercent(taxCategory.getPercent());
		}
		super.setID(taxCategory.getID());
		super.setTaxScheme(taxCategory.getTaxScheme());
	}
	
	public VatCategory(TaxCategoryCode taxCategoryCode, Percent taxRate) {
		this();
		
		IDType taxID = new IDType();
		taxID.setValue(taxCategoryCode.getValue());
		
			
		TaxSchemeType taxScheme = getVatScheme();
		
		TaxCategoryType taxCategory = new TaxCategoryType();
		taxCategory.setTaxScheme(taxScheme);
		taxCategory.setID(taxID);
		if(taxRate!=null) {
			taxCategory.setPercent(taxRate);
			super.setPercent(taxRate);
		}
		super.setID(taxCategory.getID());
		super.setTaxScheme(taxCategory.getTaxScheme());
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
	@Deprecated
	public String getTaxCategoryCodeDeprecated() {
		return getID().getValue();
	}
	public TaxCategoryCode getTaxCategoryCode() {
		return TaxCategoryCode.valueOf(this);
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
	
	private static final int SCALE = 2;
	public BigDecimal getTaxRate(RoundingMode roundingMode) {
		BigDecimal rate = this.getTaxRate();
		if(rate==null) return rate;
		return rate.setScale(SCALE, roundingMode);
	}

	private String getTaxRateAsString() {
		BigDecimal rate = getTaxRate(RoundingMode.HALF_UP);
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
//		LOG.warning("ID:"+getID());
//		LOG.warning("getTaxRateAsString:"+getTaxRateAsString());
//		LOG.warning("joined:"+joined);
		String id = getID()==null ? "'noID'" : getID().getValue();
		return id + " " + getTaxRateAsString()+" - " + TaxTypeCode.VAT + joined;
	}
}
