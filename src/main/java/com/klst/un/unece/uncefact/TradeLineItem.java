package com.klst.un.unece.uncefact;

import java.util.List;

import com.klst.cius.CoreInvoiceLine;

import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.DocumentLineDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeAgreementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeDeliveryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeLineItemType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePriceType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeProductType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementLineMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

/**
 * INVOICE LINE
 * <p>
 * A group of business terms providing information on individual Invoice lines.
 * <p>
 * Cardinality: 1..n (mandatory)
 * <br>EN16931-ID: 	BG-25
 * <br>Rule ID: 	BR-16 
 * <br>Request ID: 	R17 R23 R27
 */
/*
 * BR-16 Eine Rechnung muss mindestens eine Rechnungsposition (BG-25) haben.
 */
public class TradeLineItem extends SupplyChainTradeLineItemType implements CoreInvoiceLine {

	public TradeLineItem() {
		super();
	}
	
//	DocumentLineDocumentType documentLineDocument;
//	TradeProductType tradeProduct;
//	LineTradeAgreementType lineTradeAgreement;
//	LineTradeDeliveryType lineTradeDelivery;
//	LineTradeSettlementType lineTradeSettlement;
	
	// copy ctor
	public TradeLineItem(SupplyChainTradeLineItemType line) {
		this();
		associatedDocumentLineDocument = line.getAssociatedDocumentLineDocument();
		specifiedTradeProduct = line.getSpecifiedTradeProduct();
		specifiedLineTradeAgreement = line.getSpecifiedLineTradeAgreement();
		specifiedLineTradeDelivery = line.getSpecifiedLineTradeDelivery(); // 0..1
		specifiedLineTradeSettlement = line.getSpecifiedLineTradeSettlement();
	}

	/**
	 * mandatory elements of INVOICE LINE
	 * 
	 * @param BT-126 identifier : a unique identifier for the individual line within the Invoice.
	 * @param BT-129+BT-130 quantity : UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * @param BT-131 lineTotalAmount : the total amount of the Invoice line.
	 * @param BT-146 priceAmt : item net price (mandatory part in PRICE DETAILS)
	 * @param BT-153 itemName : a name for an item (mandatory part in ITEM INFORMATION)
	 * @param BT-151 vatCategory : VAT category code and rate for the invoiced item. (mandatory part in LINE VAT INFORMATION) !!! ubl
	 */
	public TradeLineItem(String id, Quantity quantity, Amount lineTotalAmount, UnitPriceAmount priceAmount
			, String itemName //, VatCategory vatCategory
			) {
		this();
		associatedDocumentLineDocument = new DocumentLineDocumentType();
		specifiedTradeProduct = new TradeProductType();
		specifiedLineTradeAgreement = new LineTradeAgreementType();
		specifiedLineTradeDelivery = new LineTradeDeliveryType(); // 0..1, aber BT-129 ist mandatory 
		specifiedLineTradeSettlement = new LineTradeSettlementType();
		setId(id);
		setQuantity(quantity);
		setLineTotalAmount(lineTotalAmount);
		setUnitPriceAmount(priceAmount);
		setItemName(itemName);
	}
	
	@Override // 1 .. 1 LineID BT-126
	public void setId(String id) {
		associatedDocumentLineDocument.setLineID(CrossIndustryInvoice.newIDType(id, null)); // null : No identification scheme is to be used.
		super.setAssociatedDocumentLineDocument(associatedDocumentLineDocument);
	}

	@Override
	public String getId() {
		return associatedDocumentLineDocument.getLineID().getValue();
	}

	@Override // 0 .. n IncludedNote.Content BT-127
	public void setNote(String text) {
		if(text==null) return;
		NoteType note = new NoteType();
		note.getContent().add(CrossIndustryInvoice.newTextType(text)); // Kardinalität: 1 .. 1 TODO test
		associatedDocumentLineDocument.getIncludedNote().add(note);
		super.setAssociatedDocumentLineDocument(associatedDocumentLineDocument);
	}

	@Override 
	public String getNote() {
		if(associatedDocumentLineDocument.getIncludedNote().isEmpty()) return null;
		List<TextType> textList = associatedDocumentLineDocument.getIncludedNote().get(0).getContent();
		return textList.isEmpty() ? null : textList.get(0).getValue();
	}

	@Override // 1 .. 1 SpecifiedTradeProduct.Name BT-153
	public void setItemName(String text) {
		specifiedTradeProduct.setTradeName(CrossIndustryInvoice.newTextType(text));
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getItemName() {
		return specifiedTradeProduct.getTradeName().getValue();
	}

	@Override // BT-129+BT-130
	public void setQuantity(Quantity quantity) { 
		QuantityType qt = new QuantityType();
		quantity.copyTo(qt);
		specifiedLineTradeDelivery.setBilledQuantity(qt);
		super.setSpecifiedLineTradeDelivery(specifiedLineTradeDelivery);
	}

	@Override
	public Quantity getQuantity() {
		return new Quantity(specifiedLineTradeDelivery.getBilledQuantity().getUnitCode(), specifiedLineTradeDelivery.getBilledQuantity().getValue());
	}

	@Override // BT-131
	public void setLineTotalAmount(Amount amount) { // Amount extends un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.AmountType
		TradeSettlementLineMonetarySummationType tradeSettlementLineMonetarySummation = new TradeSettlementLineMonetarySummationType();
		AmountType lineTotalAmt = new AmountType();
		amount.copyTo(lineTotalAmt);
		// un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType
		tradeSettlementLineMonetarySummation.getLineTotalAmount().add(lineTotalAmt);
		specifiedLineTradeSettlement.setSpecifiedTradeSettlementLineMonetarySummation(tradeSettlementLineMonetarySummation);
		super.setSpecifiedLineTradeSettlement(specifiedLineTradeSettlement);
	}

	@Override
	public Amount getLineTotalAmount() {
		return new Amount(specifiedLineTradeSettlement.getSpecifiedTradeSettlementLineMonetarySummation().getLineTotalAmount().get(0).getValue());
	}

	@Override // 1 .. 1 ChargeAmount BT-146
	public void setUnitPriceAmount(UnitPriceAmount unitPriceAmount) {
		setUnitPriceAmount(unitPriceAmount, null);
	}

	// 1 .. 1 ChargeAmount BT-146 , BaseQuantity BT-149-0 + BT-150-0 optional
	public void setUnitPriceAmount(UnitPriceAmount unitPriceAmount, Quantity quantity) {
		AmountType chargeAmount = new AmountType();
		unitPriceAmount.copyTo(chargeAmount);
		TradePriceType tradePrice = new TradePriceType();
		tradePrice.getChargeAmount().add(chargeAmount);
		
		if(quantity!=null) {
			QuantityType qt = new QuantityType();
			quantity.copyTo(qt);
			tradePrice.setBasisQuantity(qt); 
		}

		specifiedLineTradeAgreement.setNetPriceProductTradePrice(tradePrice);
		super.setSpecifiedLineTradeAgreement(specifiedLineTradeAgreement);
	}

	@Override
	public UnitPriceAmount getItemNetPrice() {
		return new UnitPriceAmount(specifiedLineTradeAgreement.getNetPriceProductTradePrice().getChargeAmount().get(0).getValue());
	}

//	@Override // optional BaseQuantity : BT-149-0 QuantityType 0..1 + BT-150-0 required
	public Quantity getBaseQuantity() {
		QuantityType qt = specifiedLineTradeAgreement.getNetPriceProductTradePrice().getBasisQuantity();
		return qt==null ? null : new Quantity(qt.getValue());
	}

// TODO Baustelle
	private void taxxxx() {
		TradeTaxType tradeTax = new TradeTaxType();
		tradeTax.getTypeCode();
		
		TaxTypeCodeType taxTypeCode = new TaxTypeCodeType();
		taxTypeCode.setValue("VAT");
		/*
		 * TypeCode Steuerart (Code) Datentyp: qdt:TaxTypeCodeType 
		 * Hinweis: Fester Wert = "VAT" Kardinalität: 1 .. 1 EN16931-ID: BT-151-0
		 */
		TaxCategoryCodeType taxCategoryCode = new TaxCategoryCodeType(); // Kardinalität: 1 .. 1 EN16931-ID: BT-151
		tradeTax.setCategoryCode(taxCategoryCode);
		
		PercentType percent = tradeTax.getRateApplicablePercent(); // Kardinalität: 0 .. 1 EN16931-ID: BT-152
		
		specifiedLineTradeSettlement.getApplicableTradeTax(); // List<TradeTaxType>  Kardinalität: 1 .. unbounded . EN16931-ID: BG-30
	}
/**

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

}
