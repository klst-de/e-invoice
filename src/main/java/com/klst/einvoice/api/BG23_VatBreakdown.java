package com.klst.einvoice.api;

import java.util.List;

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
public interface BG23_VatBreakdown extends VatBreakdownFactory {

// to create use factory:
//	public VatBreakdown createVATBreakDown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode code, BigDecimal percent);

//	// VAT BREAKDOWN BG-23 1..* (mandatory)
	public void addVATBreakDown(VatBreakdown vatBreakdown);
	public List<VatBreakdown> getVATBreakDowns();

}
