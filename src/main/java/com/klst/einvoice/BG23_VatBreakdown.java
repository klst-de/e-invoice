package com.klst.einvoice;

import java.math.BigDecimal;

import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.untdid.codelist.TaxCategoryCode;

/**
 * VAT BREAKDOWN
 * <p>
 * A group of business terms providing information about VAT breakdown by different 
 * categories, rates and exemption reasons
 * <p>
 * Cardinality: 1..n (mandatory)
 * <br>EN16931-ID: 	BG-23
 * <br>Rule ID: 	BR-CO-18 
 * <br>Request ID: 	R38, R45, R47, R48, R49
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/* (de) rules / Geschäftsregel:
 * 
 * BR-CO-17 Umsatzsteueraufschlüsselung : 
 * Kategoriespezifischer Steuerbetrag (BT-117) = kategoriespezifischer Steuerbasisbetrag (BT-116) x (kategoriespezifischer Umsatzsteuersatz (BT-119)/100), 
 * gerundet auf zwei Dezimalstellen.
 * 
 * BR-CO-18 Umsatzsteueraufschlüsselung :
 * Eine Rechnung muss mindestens eine Umsatzsteueraufschlüsselungsgruppe (BG-23) haben.
 * 
 * BR-45 Umsatzsteueraufschlüsselung  : 
 * Jede Umsatzsteueraufschlüsselung (BG-23) muss einen kategoriespezifischen Steuerbasisbetrag (BT-116) ausweisen.
 * 
 * BR-47 Umsatzsteueraufschlüsselung : 
 * Jede Umsatzsteueraufschlüsselung (BG-23) muss durch einen Code für die Umsatzsteuerkategorie (BT-118) bestimmt werden.
 * 
 * BR-48 Umsatzsteueraufschlüsselung :
 * Jede Umsatzsteueraufschlüsselung (BG-23) muss einen kategoriespezifischen Umsatzsteuersatz (BT-119) haben, 
 * es sei denn, die Rechnung unterliegt nicht der Umsatzsteuer.
 * 
 * BR-DE-14 Kategoriespezifischer Umsatzsteuersatz :
 * Das Element „VAT category rate“ (BT-119) muss übermittelt werden.
 */
public interface CoreInvoiceVatBreakdown {

	/**
	 * VAT category taxable amount
	 * <p>
	 * Sum of all taxable amounts subject to a specific VAT category code and VAT category rate 
	 * (if the VAT category rate is applicable).
	 * <p>
	 * The sum of Invoice line net amount minus allowances plus charges on document level which are subject 
	 * to a specific VAT category code and VAT category rate (if the VAT category rate is applicable).
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-116
	 * <br>Rule ID: 	BR-45
	 * <br>Request ID: 	R50
	 * 
	 * @param Amount
	 */
	// BT-116 1..1 BasisAmount Steuerbasisbetrag
	public void setTaxBaseAmount(Amount taxBaseAmount); // use ctor
	public Amount getTaxBaseAmount();

	/**
	 * VAT category tax amount
	 * <p>
	 * The total VAT amount for a given VAT category.
	 * <p>
	 * Calculated by multiplying the VAT category taxable amount 
	 * with the VAT category rate for the relevant VAT category.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-117
	 * <br>Rule ID: 	BR-CO-17
	 * <br>Request ID: 	R49
	 * 
	 * @param Amount
	 */
	// BT-117 1..1 CalculatedAmount Kategoriespezifischer Steuerbetrag
	public void setCalculatedTaxAmount(Amount taxAmount); // use ctor
	public Amount getCalculatedTaxAmount();
	
	/**
	 * Value added tax. 
	 * <p>
	 * Code according to <A HREF="http://www.unece.org/trade/untdid/d13b/tred/tred5153.htm">UN/EDIFACT 5153</A>  
	 * <p>
	 * A tax on domestic or imported goods applied to the value added 
	 * at each stage in the production/distribution cycle.
	 * 
	 * <br>EN16931-ID: 	BT-118-0
	 */
	// BT-118-0 TypeCode Code der Umsatzsteuerkategorie, Hinweis: Fester Wert = "VAT"
	// wird auch als default für BT-31-0, BT-32-0 TaxRegistrationId.schemeID verwendet, in CII steht "VA"
	public static final String VAT = "VAT";

	/**
	 * set tax category code and rate
	 * 
	 * @param codeEnum BT-118
	 * @param percent  BT-119
	 */
	public void setTaxCategoryCodeAndRate(TaxCategoryCode codeEnum, BigDecimal percent); // use ctor
	
	/**
	 * VAT category code 
	 * <p>
	 * Coded identification of a VAT category, entries of UNTDID 5305
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-118
	 * <br>Rule ID: 	BR-47
	 * <br>Request ID: 	R38, R45, R49
	 * 
	 * @param Code
	 */
	// BT-118   CategoryCode Codierte Bezeichnung einer Umsatzsteuerkategorie
	// BT-118-0 TypeCode Code der Umsatzsteuerkategorie, Hinweis: Fester Wert = "VAT"
	public void setTaxCategoryCode(TaxCategoryCode code); // use ctor
	public TaxCategoryCode getTaxCategoryCode();
	
	/**
	 * VAT category rate
	 * <p>
	 * The VAT rate, represented as percentage that applies for the relevant VAT category.
	 *  The VAT category code and the VAT category rate shall be consistent.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-119
	 * <br>Rule ID: 	BR-48 , BR-DE-14 (mandatory)
	 * <br>Request ID: 	R38, R49
	 * 
	 * @param Percentage
	 */
	/* BT-119 RateApplicablePercent Kategoriespezifischer Umsatzsteuersatz
	 * Besonderheit der XRechnung :
	 * Geschäftsregel: BR-DE-14 Das Element „VAT category rate“ (BT-119) muss übermittelt werden.
	 */
	// 
	public void setTaxCategoryRate(BigDecimal taxableAmount); // use ctor
	public BigDecimal getTaxCategoryRate();

	/**
	 * VAT exemption reason text and code
	 * 
	 * @param text BT-120 0..1 (optional, therefore can be null)
	 * @param code BT-121 0..1 (optional, therefore can be null)
	 */
	public void setTaxExemption(String text, String code);
	/**
	 * VAT exemption reason text
	 * <p>
	 * A textual statement of the reason why the amount is exempted from VAT
	 *  or why no VAT is being charged Articles 226 items 11 to 15 Directive 2006/112/EC.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-120
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R48, R49, R51
	 * 
	 * @return Text
	 * 
	 * @see <a href="http://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:02006L0112-20150101">COUNCIL DIRECTIVE. 2006/112/EC</a> 
	 *  of 28 November 2006 on the common system of value added tax – last version: 2006L0112 - EN - 01.01.2015
	 */
	// BT-120 ExemptionReason Grund der Steuerbefreiung (Freitext)
	public String getTaxExemptionReasonText();
	/**
	 * VAT exemption reason code
	 * <p>
	 * A coded statement of the reason for why the amount is exempted from VAT.
	 * Code list issued and maintained by the Connecting Europe Facility.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-121
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R48, R49, R51 R55
	 * 
	 * @return Code
	 */
	// BT-121 ExemptionReasonCode Code für den Umsatzsteuerbefreiungsgrund
	// Hinweis: Codeliste von der Connecting Europe Facility ausgegeben und geführt.
	public String getTaxExemptionReasonCode();

}
