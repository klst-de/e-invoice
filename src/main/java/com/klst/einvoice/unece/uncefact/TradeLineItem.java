package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CoreInvoiceLine;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.DocumentLineDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeAgreementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeDeliveryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ProductClassificationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeLineItemType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePriceType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeProductType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementLineMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
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

	private static final Logger LOG = Logger.getLogger(TradeLineItem.class.getName());

	public TradeLineItem() {
		super();
	}
	
	// copy ctor
	public TradeLineItem(SupplyChainTradeLineItemType line) {
		this();
		associatedDocumentLineDocument = line.getAssociatedDocumentLineDocument();
		specifiedTradeProduct = line.getSpecifiedTradeProduct();
		specifiedLineTradeAgreement = line.getSpecifiedLineTradeAgreement();
		specifiedLineTradeDelivery = line.getSpecifiedLineTradeDelivery(); // 0..1
		specifiedLineTradeSettlement = line.getSpecifiedLineTradeSettlement();

		TradeTaxType tradeTax = specifiedLineTradeSettlement.getApplicableTradeTax().get(0);
		PercentType percent = tradeTax.getRateApplicablePercent();
//		LOG.info("specifiedLineTradeSettlement:"+specifiedLineTradeSettlement + " tradeTax.getCategoryCode()="+tradeTax.getCategoryCode() 
//		+ "\n TaxCategoryCode:"+TaxCategoryCode.valueOf(tradeTax.getCategoryCode())
//		);
		init( associatedDocumentLineDocument.getLineID().getValue()
			, new Quantity(specifiedLineTradeDelivery.getBilledQuantity().getUnitCode(), specifiedLineTradeDelivery.getBilledQuantity().getValue())
			, new Amount(specifiedLineTradeSettlement.getSpecifiedTradeSettlementLineMonetarySummation().getLineTotalAmount().get(0).getValue())
			, new UnitPriceAmount(specifiedLineTradeAgreement.getNetPriceProductTradePrice().getChargeAmount().get(0).getValue())
			, specifiedTradeProduct.getName().get(0).getValue()
			, TaxCategoryCode.valueOf(tradeTax.getCategoryCode())
			, percent==null ? null : percent.getValue()
			);
	}

	public TradeLineItem(String id, Quantity quantity, Amount lineTotalAmount, UnitPriceAmount priceAmount, String itemName
			, TaxCategoryCode codeEnum, BigDecimal percent) {
		this();
		associatedDocumentLineDocument = new DocumentLineDocumentType();
		specifiedTradeProduct = new TradeProductType();
		specifiedLineTradeAgreement = new LineTradeAgreementType();
		specifiedLineTradeDelivery = new LineTradeDeliveryType(); // 0..1, aber BT-129 ist mandatory 
		specifiedLineTradeSettlement = new LineTradeSettlementType();
		
		init(id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent);
	}
	
	/**
	 * mandatory elements of INVOICE LINE
	 * 
	 * @param BT-126 identifier : a unique identifier for the individual line within the Invoice.
	 * @param BT-129+BT-130 quantity : UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * @param BT-131 lineTotalAmount : the total amount of the Invoice line.
	 * @param BT-146 priceAmt : item net price (mandatory part in PRICE DETAILS)
	 * @param BT-153 itemName : a name for an item (mandatory part in ITEM INFORMATION)
	 * @param BG-30.BT-151 codeEnum 1..1 VAT category code
	 * @param BG-30.BT-152 percent  0..1 VAT rate
	 */
	void init(String id, Quantity quantity, Amount lineTotalAmount, UnitPriceAmount priceAmount, String itemName
			, TaxCategoryCode codeEnum, BigDecimal percent) {
		setId(id);
		setQuantity(quantity);
		setLineTotalAmount(lineTotalAmount);
		setUnitPriceAmount(priceAmount);
		setItemName(itemName);
		setTaxCategoryAndRate(codeEnum, percent==null ? null : new Percent(percent));
	}
	
	// 1 .. 1 LineID BT-126
	void setId(String id) {
		associatedDocumentLineDocument.setLineID(CrossIndustryInvoice.newIDType(id, null)); // null : No identification scheme is to be used.
		super.setAssociatedDocumentLineDocument(associatedDocumentLineDocument);
	}

	@Override
	public String getId() {
		return associatedDocumentLineDocument.getLineID().getValue();
	}

	@Override // 0 .. n IncludedNote.Content BT-127
	public void setNoteText(String text) {
		if(text==null) return;
		NoteType note = new NoteType();
		note.getContent().add(CrossIndustryInvoice.newTextType(text)); // Kardinalität: 1 .. 1 TODO test
		associatedDocumentLineDocument.getIncludedNote().add(note);
		super.setAssociatedDocumentLineDocument(associatedDocumentLineDocument);
	}

	@Override 
	public String getNoteText() {
		if(associatedDocumentLineDocument.getIncludedNote().isEmpty()) return null;
		List<TextType> textList = associatedDocumentLineDocument.getIncludedNote().get(0).getContent();
		return textList.isEmpty() ? null : textList.get(0).getValue();
	}

	// 1 .. 1 SpecifiedTradeProduct.Name BT-153
	void setItemName(String text) {
		specifiedTradeProduct.getName().add(CrossIndustryInvoice.newTextType(text));
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getItemName() {
		return specifiedTradeProduct.getName().get(0).getValue();
	}

	@Override // 0 .. 1 SpecifiedTradeProduct.Description BT-154 Bsp: <ram:Description>Zeitschrift Inland</ram:Description>
	public void setDescription(String text) {
		if(text==null) return;
		specifiedTradeProduct.setDescription(CrossIndustryInvoice.newTextType(text));
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getDescription() {
		return specifiedTradeProduct.getDescription()==null ? null : specifiedTradeProduct.getDescription().getValue();
	}

	// TODO BT-128  IssuerAssignedID
/*
       TODO
                <ram:BillingSpecifiedPeriod>
                    <ram:StartDateTime>
                        <udt:DateTimeString format="102">20160101</udt:DateTimeString>
                    </ram:StartDateTime>
                    <ram:EndDateTime>
                        <udt:DateTimeString format="102">20161231</udt:DateTimeString>
                    </ram:EndDateTime>
                </ram:BillingSpecifiedPeriod>

 */
	@Override // 0 .. 1 BT-155 Bsp: <ram:SellerAssignedID>246</ram:SellerAssignedID>
	public void setSellerAssignedID(String id) {
		if(id==null) return;
		specifiedTradeProduct.setSellerAssignedID(CrossIndustryInvoice.newIDType(id, null)); // null : No identification scheme is to be used.
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getSellerAssignedID() {
		return specifiedTradeProduct.getSellerAssignedID()==null ? null : specifiedTradeProduct.getSellerAssignedID().getValue();
	}

	@Override // 0 .. 1 BT-156
	public void setBuyerAssignedID(String id) {
		if(id==null) return;
		specifiedTradeProduct.setBuyerAssignedID(CrossIndustryInvoice.newIDType(id, null)); // null : No identification scheme is to be used.
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getBuyerAssignedID() {
		return specifiedTradeProduct.getBuyerAssignedID()==null ? null : specifiedTradeProduct.getBuyerAssignedID().getValue();
	}

	/*
	 * GlobalID Kennung eines Artikels nach registriertem Schema
	 * CII:
	 * BG-31    1 .. 1   SpecifiedTradeProduct
	 * BT-157   0 .. 1   GlobalID
	 * BT-157-1          required schemeID
	 * Codeliste: ISO 6523 :
	 * 0021 : SWIFT 
	 * 0088 : EAN 
	 * 0060 : DUNS 
	 * 0177 : ODETTE 
	 */
	@Override // 0 .. 1 BT-157
	public void setStandardID(String id, String schemeID) {
		if(id==null) return;
		specifiedTradeProduct.setGlobalID(CrossIndustryInvoice.newIDType(id, schemeID));
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getStandardID() { // ohne schemeID! TODO
		return specifiedTradeProduct.getGlobalID()==null ? null : specifiedTradeProduct.getGlobalID().getValue();
	}

/*
	0 .. n DesignatedProductClassification Detailinformationen zur Produktklassifikation xs:sequence 
	1 .. 1 ClassCode Kennung der Artikelklassifizierung                                              BT-158 
	       required listID Kennung des Schemas                                                       BT-158-1 
	       optional listVersionID Version des Schemas                                                BT-158-2 
Bsp.
                <ram:DesignatedProductClassification>
                    <ram:ClassCode listID="IB">0721-880X</ram:ClassCode>
                </ram:DesignatedProductClassification>

 */
	@Override // 0 .. n BT-158
	public void addClassificationID(String id, String schemeID, String schemeVersion) {
		if(id==null) return;
		CodeType code = new CodeType();
		code.setValue(id);
		code.setListID(schemeID);
		code.setListVersionID(schemeVersion);
		ProductClassificationType productClassification = new ProductClassificationType();
		productClassification.setClassCode(code);
		specifiedTradeProduct.getDesignatedProductClassification().add(productClassification);
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public List<Object> getClassificationList() {
		List<ProductClassificationType> productClassificatioList = specifiedTradeProduct.getDesignatedProductClassification();
		List<Object> resList = new ArrayList<Object>(productClassificatioList.size());
		productClassificatioList.forEach(productClassification -> {
			resList.add(productClassification);
		});
		return resList;
	}

	// BT-129+BT-130
	void setQuantity(Quantity quantity) { 
		QuantityType qt = new QuantityType();
		quantity.copyTo(qt);
		specifiedLineTradeDelivery.setBilledQuantity(qt);
		super.setSpecifiedLineTradeDelivery(specifiedLineTradeDelivery);
	}

	@Override
	public Quantity getQuantity() {
		return new Quantity(specifiedLineTradeDelivery.getBilledQuantity().getUnitCode(), specifiedLineTradeDelivery.getBilledQuantity().getValue());
	}

	// BT-131
	void setLineTotalAmount(Amount amount) {
		TradeSettlementLineMonetarySummationType tradeSettlementLineMonetarySummation = new TradeSettlementLineMonetarySummationType();
		AmountType lineTotalAmt = new AmountType();
		amount.copyTo(lineTotalAmt);
		tradeSettlementLineMonetarySummation.getLineTotalAmount().add(lineTotalAmt);
		specifiedLineTradeSettlement.setSpecifiedTradeSettlementLineMonetarySummation(tradeSettlementLineMonetarySummation);
		super.setSpecifiedLineTradeSettlement(specifiedLineTradeSettlement);
	}

	@Override
	public Amount getLineTotalAmount() {
		return new Amount(specifiedLineTradeSettlement.getSpecifiedTradeSettlementLineMonetarySummation().getLineTotalAmount().get(0).getValue());
	}

	/*
Bsp. CII 01.01a-INVOICE_uncefact.xml :
            <ram:SpecifiedLineTradeAgreement>
                <ram:BuyerOrderReferencedDocument>
                    <ram:LineID>6171175.1</ram:LineID>
                </ram:BuyerOrderReferencedDocument>
     UBL
        <cac:OrderLineReference>
            <cbc:LineID>6171175.1</cbc:LineID>
        </cac:OrderLineReference>

	 */
	@Override // BT-132 0..1
	public void setOrderLineID(String id) {
		if(id==null) return;
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		referencedDocument.setLineID(CrossIndustryInvoice.newIDType(id, null)); // null : No identification scheme is to be used.
		specifiedLineTradeAgreement.setBuyerOrderReferencedDocument(referencedDocument);
		super.setSpecifiedLineTradeAgreement(specifiedLineTradeAgreement);
	}

	@Override
	public String getOrderLineID() {
		ReferencedDocumentType referencedDocument = specifiedLineTradeAgreement.getBuyerOrderReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getLineID().getValue();
	}

	// 1 .. 1 ChargeAmount BT-146
	void setUnitPriceAmount(UnitPriceAmount unitPriceAmount) {
		setUnitPriceAmountAndQuantity(unitPriceAmount, null);
	}

	// 1 .. 1 ChargeAmount BT-146 , BaseQuantity BT-149-0 + BT-150-0 optional
	public void setUnitPriceAmountAndQuantity(UnitPriceAmount unitPriceAmount, Quantity quantity) {
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
	public UnitPriceAmount getUnitPriceAmount() {
		return new UnitPriceAmount(specifiedLineTradeAgreement.getNetPriceProductTradePrice().getChargeAmount().get(0).getValue());
	}

	@Override // optional BaseQuantity : BT-149-0 QuantityType 0..1 + BT-150-0 required
	public Quantity getBaseQuantity() {
		QuantityType qt = specifiedLineTradeAgreement.getNetPriceProductTradePrice().getBasisQuantity();
		return qt==null ? null : new Quantity(qt.getValue());
	}

/*

1 .. n ApplicableTradeTax Umsatzsteuerinformationen auf der Ebene der Rechnungsposition BG-30 xs:sequence 
0 .. 1 CalculatedAmount Steuerbetrag 
1 .. 1 TypeCode Steuerart (Code)                                                        BT-151-0 
0 .. 1 ExemptionReason Grund der Steuerbefreiung (Freitext) 
1 .. 1 CategoryCode Code der Umsatzsteuerkategorie des in Rechnung gestellten Artikels  BT-151

 */
	/*
	 * TypeCode Steuerart (Code) Datentyp: qdt:TaxTypeCodeType 
	 * Hinweis: Fester Wert = "VAT" Kardinalität: 1 .. 1 EN16931-ID: BT-151-0
	 */
	static final TaxTypeCodeType VAT() {
		TaxTypeCodeType taxTypeCode = new TaxTypeCodeType();
		taxTypeCode.setValue("VAT");
		return taxTypeCode;
	}
	
	/*
	 * 
	 * @param codeEnum 1..1 EN16931-ID: BT-151
	 * @param percent 0..1 EN16931-ID: BT-152
	 */
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, Percent percent) {
		TaxCategoryCodeType taxCategoryCode = new TaxCategoryCodeType();
		taxCategoryCode.setValue(codeEnum.getValue());

		TradeTaxType tradeTax = new TradeTaxType();
		tradeTax.setCategoryCode(taxCategoryCode);
		tradeTax.setTypeCode(VAT());
		
		if(percent!=null) {
			tradeTax.setRateApplicablePercent(percent);
		}
		
		specifiedLineTradeSettlement.getApplicableTradeTax().add(tradeTax);
		super.setSpecifiedLineTradeSettlement(specifiedLineTradeSettlement);		
	}
	
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, BigDecimal percent) {
		setTaxCategoryAndRate(codeEnum, percent==null ? null : new Percent(percent));
	}

	void setTaxCategory(TaxCategoryCode codeEnum) {
		setTaxCategoryAndRate(codeEnum, (Percent)null);
	}

	@Override
	public TaxCategoryCode getTaxCategory() {
		TradeTaxType tradeTax = specifiedLineTradeSettlement.getApplicableTradeTax().get(0); // Kardinalität: 1..n
		return TaxCategoryCode.valueOf(tradeTax.getCategoryCode());
	}

	public BigDecimal getTaxRate() {
		TradeTaxType tradeTax = specifiedLineTradeSettlement.getApplicableTradeTax().get(0); // Kardinalität: 1..n
		PercentType percent = tradeTax.getRateApplicablePercent();
		return percent==null ? null : percent.getValue();
	}

/**
1 .. 1 SpecifiedLineTradeSettlement Gruppierung von Angaben zur Abrechnung auf Positionsebene
0 .. n AdditionalReferencedDocument Objektkennung auf Ebene der Rechnungsposition xs:sequence 
0 .. 1 IssuerAssignedID Objektkennung auf Ebene der Rechnungsposition, Wert                      BT-128 
1 .. 1 TypeCode Typ der Kennung für einen Gegenstand, auf dem die Rechnungsposition basiert      BT-128-0 
0 .. 1 ReferenceTypeCode Kennung des Schemas                                                     BT-128-1

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
