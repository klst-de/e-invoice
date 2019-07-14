package com.klst.cius;

import com.klst.un.unece.uncefact.Amount;
import com.klst.un.unece.uncefact.Quantity;
import com.klst.un.unece.uncefact.UnitPriceAmount;

/**
 * BG-25 + 1..n INVOICE LINE
A group of business terms providing
information on individual Invoice
lines.
R17
R23
R27

CII:
0 .. n IncludedSupplyChainTradeLineItem Rechnungsposition                                        BG-25
1 .. 1 AssociatedDocumentLineDocument Gruppierung von allgemeinen Positionsangaben xs:sequence 
1 .. 1 LineID Kennung der Rechnungsposition                                                      BT-126 
0 .. 1 LineStatusCode Typ der Rechnungsposition (Code) 
0 .. 1 LineStatusReasonCode Untertyp der Rechnungsposition 
0 .. n IncludedNote Detailinformationen zum Freitext zur Position xs:sequence 
0 .. 1 ContentCode Freitext zur Position (Code zum Inhalt) 
1 .. 1 Content Freitext zur Rechnungsposition                                                    BT-127 
0 .. 1 SubjectCode Freitext zur Position (Code zur Art) 
1 .. 1 SpecifiedTradeProduct Artikelinformationen                                                BG-31
0 .. 1 GlobalID Kennung eines Artikels nach registriertem Schema                                 BT-157 
       required schemeID Kennung des Schemas                                                     BT-157-1 
0 .. 1 SellerAssignedID Artikelnummer des Verkäufers                                             BT-155 
0 .. 1 BuyerAssignedID Artikelnummer des Käufers                                                 BT-156 
1 .. 1 Name Artikelname                                                                          BT-153 
0 .. 1 Description Artikelbeschreibung                                                           BT-154 
0 .. n ApplicableProductCharacteristic Artikelattribute                                          BG-32 xs:sequence 
0 .. 1 TypeCode Art der Produkteigenschaft (Code) 
1 .. 1 Description Artikelattributname                                                           BT-160 
0 .. 1 ValueMeasure Wert der Produkteigenschaft (numerische Messgröße) required unitCode Maßeinheit 
1 .. 1 Value Artikelattributwert                                                                 BT-161 
0 .. n DesignatedProductClassification Detailinformationen zur Produktklassifikation xs:sequence 
1 .. 1 ClassCode Kennung der Artikelklassifizierung                                              BT-158 
       required listID Kennung des Schemas                                                       BT-158-1 
       optional listVersionID Version des Schemas                                                BT-158-2 
0 .. 1 ClassName Klassifikationsname 
0 .. 1 OriginTradeCountry Detailinformationen zur Produktherkunft xs:sequence 
1 .. 1 ID Artikelherkunftsland                                                                   BT-159
...
1 .. 1 SpecifiedLineTradeAgreement Detailinformationen zum Preis                                 BG-29 xs:sequence 
0 .. 1 BuyerOrderReferencedDocument Detailangaben zur zugehörigen Bestellung xs:sequence 
0 .. 1 IssuerAssignedID Bestellnummer 
0 .. 1 LineID Referenz zur Bestellposition                                                       BT-132
...
0 .. 1 GrossPriceProductTradePrice Detailinformationen zum Bruttopreis des Artikels xs:sequence 
1 .. 1 ChargeAmount Bruttopreis des Artikels                                                     BT-148 
0 .. 1 BasisQuantity Basismenge zum Artikelpreis                                                 BT-149 
       required unitCode Code der Maßeinheit der Basismenge zum Artikelpreis                     BT-150
0 .. n AppliedTradeAllowanceCharge Detailinformationen zu Zu- und Abschlägen xs:sequence 
0 .. 1 ChargeIndicator Schalter für Zu-/Abschlag xs:choice 
1 .. 1 Indicator Schalter für Zu-/Abschlag, Wert 
0 .. 1 CalculationPercent Rabatt in Prozent 
0 .. 1 BasisAmount Basisbetrag des Rabatts 
1 .. 1 ActualAmount Nachlass auf den Artikelpreis                                                BT-147 
1 .. 1 Reason Grund des Zu-/Abschlags (Freitext) 
1 .. 1 NetPriceProductTradePrice Detailinformationen zum Nettopreis des Artikels xs:sequence 
1 .. 1 ChargeAmount Nettopreis des Artikels                                                      BT-146 
0 .. 1 BasisQuantity Basismenge zum Artikelpreis                                                 BT-149-0 
       required unitCode Code der Maßeinheit der Basismenge zum Artikelpreis                     BT-150-0
...
0 .. n AppliedTradeAllowanceCharge Detailinformationen zu Zu- und Abschlägen xs:sequence 
0 .. 1 ChargeIndicator Schalter für Zu-/Abschlag xs:choice 
1 .. 1 Indicator Schalter für Zu-/Abschlag, Wert 
0 .. 1 CalculationPercent Rabatt in Prozent 
0 .. 1 BasisAmount Basisbetrag des Rabatts 
1 .. 1 ActualAmount Nachlass auf den Artikelpreis                                                BT-147 
1 .. 1 Reason Grund des Zu-/Abschlags (Freitext) 
1 .. 1 NetPriceProductTradePrice Detailinformationen zum Nettopreis des Artikels xs:sequence 
1 .. 1 ChargeAmount Nettopreis des Artikels                                                      BT-146 
0 .. 1 BasisQuantity Basismenge zum Artikelpreis                                                 BT-149-0 
       required unitCode Code der Maßeinheit der Basismenge zum Artikelpreis                     BT-150-0
...
 *
 */
public interface CoreInvoiceLine {

	/**
	 * Invoice line identifier
	 * <p>
	 * A unique identifier for the individual line within the Invoice.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-126
	 * <br>Rule ID: 	BR-21
	 * <br>Request ID: 	R44
	 * 
	 * @param id Identifier
	 */
	public void setId(String id);
	public String getId();

	/**
	 * Invoice line note
	 * <p>
	 * A textual note that gives unstructured information that is relevant to the Invoice line.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-127
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R28
	 * 
	 * @param text Text
	 */
	public void setNote(String text);
	public String getNote();

	// 1 .. 1 SpecifiedTradeProduct Artikelinformationen                                                BG-31
	// 0 .. 1 GlobalID Kennung eines Artikels nach registriertem Schema                                 BT-157 
    //        required schemeID Kennung des Schemas                                                     BT-157-1 
	// 0 .. 1 SellerAssignedID Artikelnummer des Verkäufers                                             BT-155 
	// 0 .. 1 BuyerAssignedID Artikelnummer des Käufers                                                 BT-156 
	// 1 .. 1 Name Artikelname                                                                          BT-153 

	/**
	 * Item name (mandatory part in 1..1 BG-31 ITEM INFORMATION)
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-153 
	 * <br>Rule ID: 	BR-25
	 * <br>Request ID: 	R20, R56
	 * 
	 * @param text Text
	 */
	public void setItemName(String text);
	public String getItemName();

	/**
	 * Billed quantity and UoM of items (goods or services) that is charged in the Invoice line.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-129 BT-130  
	 * <br>Rule ID: 	BR-22
	 * <br>Request ID: 	R14, R39, R56
	 * 
	 * @param Quantity
	 */
	public void setQuantity(Quantity quantity);
	public Quantity getQuantity();

	/**
	 * Invoice line net amount 
	 * <p>
	 * The total amount of the Invoice line. The amount is “net” without VAT, i.e.
	 * inclusive of line level allowances and charges as well as other relevant taxes.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-131
	 * <br>Rule ID: 	BR-24
	 * <br>Request ID: 	R39, R56, R14
	 * 
	 * @param Amount
	 */
	public void setLineTotalAmount(Amount amount);
	public Amount getLineTotalAmount();

	/**
	 * Item net price (mandatory part in PRICE DETAILS), exclusive of VAT, after subtracting item price discount.
	 * <p>
	 * The Item net price has to be equal with the Item gross price less the Item price discount.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-29, BT-146 
	 * <br>Rule ID: 	BR-27
	 * <br>Request ID: 	R14
	 * 
	 */
	public void setUnitPriceAmount(UnitPriceAmount unitPriceAmount);
	public UnitPriceAmount getItemNetPrice();

}
