package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.Identifier;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.TaxCategoryCode;
import com.klst.untdid.codelist.TaxTypeCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.CountryIDType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.ReferenceCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.DocumentLineDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeAgreementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeDeliveryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ProductCharacteristicType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ProductClassificationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SpecifiedPeriodType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeLineItemType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAccountingAccountType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAllowanceChargeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeCountryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePriceType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeProductType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementLineMonetarySummationType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;

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

	static CoreInvoiceLine createInvoiceLine(String id, Quantity quantity, Amount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent) {
		return new TradeLineItem(id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent);
	}

	// copy factory
	static TradeLineItem create(SupplyChainTradeLineItemType object) {
		if(object instanceof SupplyChainTradeLineItemType && object.getClass()!=SupplyChainTradeLineItemType.class) {
			// object is instance of a subclass of SupplyChainTradeLineItemType, but not SupplyChainTradeLineItemType itself
			return (TradeLineItem)object;
		} else {
			return new TradeLineItem(object); 
		}
	}

	private static final Logger LOG = Logger.getLogger(TradeLineItem.class.getName());

	// copy ctor
	private TradeLineItem(SupplyChainTradeLineItemType line) {
		super();
		if(line!=null) {
			CopyCtor.invokeCopy(this, line);
			//LOG.fine("copy ctor:"+this);
		}
		if(specifiedLineTradeSettlement.getApplicableTradeTax().isEmpty()) {
			tradeTax = null; //TradeTax.create();
		} else {
			tradeTax = TradeTax.create(specifiedLineTradeSettlement.getApplicableTradeTax().get(0));
		}
	}

	// BG-30 ++ 1..1 UMSATZSTEUERINFORMATIONEN AUF DER EBENE DER RECHNUNGSPOSITION
	TradeTax tradeTax = null;

	private TradeLineItem(String id, Quantity quantity, Amount lineTotalAmount, UnitPriceAmount priceAmount, String itemName
			, TaxCategoryCode codeEnum, BigDecimal percent) {
		super();
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
	 * @param BG-30.BT-151 taxCode 1..1 VAT category code
	 * @param BG-30.BT-152 percent  0..1 VAT rate
	 */
	private void init(String id, Quantity quantity, Amount lineTotalAmount, UnitPriceAmount priceAmount, String itemName
			, TaxCategoryCode taxCode, BigDecimal taxRate) {
		setId(id);
		setQuantity(quantity);
		setLineTotalAmount(lineTotalAmount);
		setUnitPriceAmount(priceAmount);
		setItemName(itemName);
		setTaxCategoryAndRate(taxCode, taxRate);
	}
	
	// 1 .. 1 LineID BT-126
	void setId(String id) {
		associatedDocumentLineDocument.setLineID(new ID(id)); // No identification scheme is to be used.
		super.setAssociatedDocumentLineDocument(associatedDocumentLineDocument);
	}

	@Override
	public String getId() {
		return associatedDocumentLineDocument.getLineID().getValue();
	}

	@Override // 0 .. n IncludedNote.Content BT-127
	public void setNote(String text) {
		if(text==null) return;
//		NoteType note = new NoteType();
//		note.getContent().add(new Text(text)); // Kardinalität: 1 .. 1 TODO test
		associatedDocumentLineDocument.getIncludedNote().add(Note.create(text));
		super.setAssociatedDocumentLineDocument(associatedDocumentLineDocument);
	}

	@Override 
	public String getNote() {
		if(associatedDocumentLineDocument.getIncludedNote().isEmpty()) return null;
		List<NoteType> list = associatedDocumentLineDocument.getIncludedNote();
		return list.isEmpty() ? null : Note.getNote(list.get(0));
	}

	// 0..1 BT-128  IssuerAssignedID
	@Override
	public void setLineObjectID(String id, String schemeID, String schemeCode) {
		if(id==null) return;
		ReferencedDocumentType rd = new ReferencedDocumentType();
		rd.setIssuerAssignedID(new ID(id));
		if(schemeID!=null) {
			DocumentCodeType documentCode = new DocumentCodeType();
			documentCode.setValue(schemeID);
			rd.setTypeCode(documentCode);
		}
		if(schemeCode!=null) {
			ReferenceCodeType referenceCode = new ReferenceCodeType();
			referenceCode.setValue(schemeCode);
			rd.setReferenceTypeCode(referenceCode);
		}
		specifiedLineTradeSettlement.getAdditionalReferencedDocument().add(rd);
		super.setAssociatedDocumentLineDocument(associatedDocumentLineDocument);
	}

	@Override
	public void setLineObjectID(String id) {
		setLineObjectID(id, null, null);
	}

	@Override
	public void setLineObjectID(String id, String schemeID) {
		setLineObjectID(id, schemeID, null);
	}

	@Override
	public void setLineObjectIdentifier(Identifier id) {
		if(id==null) return;
		setLineObjectID(id.getContent(), id.getSchemeIdentifier(), id.getSchemeVersion());
	}

	@Override
	public Identifier getLineObjectIdentifier() {
		List<ReferencedDocumentType> rds = specifiedLineTradeSettlement.getAdditionalReferencedDocument();
		if(rds.isEmpty()) return null;
		ReferencedDocumentType rd = rds.get(0);
		return new ID(rd.getIssuerAssignedID().getValue(), rd.getTypeCode()==null ? null : rd.getTypeCode().getValue()
				, rd.getReferenceTypeCode()==null ? null : rd.getReferenceTypeCode().getValue());
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
		referencedDocument.setLineID(new ID(id)); // No identification scheme is to be used.
		specifiedLineTradeAgreement.setBuyerOrderReferencedDocument(referencedDocument);
		super.setSpecifiedLineTradeAgreement(specifiedLineTradeAgreement);
	}

	@Override
	public String getOrderLineID() {
		ReferencedDocumentType referencedDocument = specifiedLineTradeAgreement.getBuyerOrderReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getLineID().getValue();
	}

	@Override  // BT-133 0..1
	public void setBuyerAccountingReference(String text) {
		if(text==null) return;
		TradeAccountingAccountType taa = new TradeAccountingAccountType();
		taa.setID(new ID(text));

		specifiedLineTradeSettlement.getReceivableSpecifiedTradeAccountingAccount().add(taa);
		super.setAssociatedDocumentLineDocument(associatedDocumentLineDocument);
	}

	@Override
	public String getBuyerAccountingReference() {
		List<TradeAccountingAccountType> rds = specifiedLineTradeSettlement.getReceivableSpecifiedTradeAccountingAccount();
		if(rds.isEmpty()) return null;
		return rds.get(0).getID().getValue();
	}

	// BT-134 +++ 0..1 Invoice line period start date
	@Override
	public void setStartDate(Timestamp ts) {
		if(ts==null) return;
		DateTimeType dateTime = DateTimeFormatStrings.toDateTime(ts);
		if(specifiedLineTradeSettlement.getBillingSpecifiedPeriod()==null) {
//			LOG.info("creating SpecifiedPeriodType and setBillingSpecifiedPeriod");
			SpecifiedPeriodType sp = new SpecifiedPeriodType();
			sp.setStartDateTime(dateTime);
			specifiedLineTradeSettlement.setBillingSpecifiedPeriod(sp);
		} else {
			specifiedLineTradeSettlement.getBillingSpecifiedPeriod().setStartDateTime(dateTime);
		}
	}

	@Override
	public Timestamp getStartDateAsTimestamp() {
		return getStartDateAsTimestamp(specifiedLineTradeSettlement);
	}
	static Timestamp getStartDateAsTimestamp(LineTradeSettlementType lts) {
		SpecifiedPeriodType specifiedPeriod = lts.getBillingSpecifiedPeriod();
		if(specifiedPeriod==null) return null;
		DateTimeType dateTime = specifiedPeriod.getStartDateTime();
		return dateTime==null ? null : DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());		
	}

	@Override
	public void setEndDate(Timestamp ts) {
		if(ts==null) return;
		DateTimeType dateTime = DateTimeFormatStrings.toDateTime(ts);
		if(specifiedLineTradeSettlement.getBillingSpecifiedPeriod()==null) {
			SpecifiedPeriodType sp = new SpecifiedPeriodType();
			sp.setStartDateTime(dateTime);
			specifiedLineTradeSettlement.setBillingSpecifiedPeriod(sp);			
		} else {
			specifiedLineTradeSettlement.getBillingSpecifiedPeriod().setEndDateTime(dateTime);
		}
	}

	@Override
	public Timestamp getEndDateAsTimestamp() {
		return getEndDateAsTimestamp(specifiedLineTradeSettlement);
	}
	static Timestamp getEndDateAsTimestamp(LineTradeSettlementType lts) {
		SpecifiedPeriodType specifiedPeriod = lts.getBillingSpecifiedPeriod();
		if(specifiedPeriod==null) return null;
		DateTimeType dateTime = specifiedPeriod.getEndDateTime();
		return dateTime==null ? null : DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());
	}

	/*
	 * BG-27 0..n INVOICE LINE ALLOWANCES
	 * BG-28 0..n INVOICE LINE CHARGES
	 */
	
	@Override
	public void addAllowanceCharge(AllowancesAndCharges allowanceOrCharge) {
		if(allowanceOrCharge==null) return; // optional
		// The method add(TradeAllowanceChargeType) in the type List<TradeAllowanceChargeType> 
		// is not applicable for the arguments (AllowancesAndCharges)
		// specifiedLineTradeSettlement.getSpecifiedTradeAllowanceCharge().add(allowanceOrCharge);
		// TradeAllowanceCharge extends TradeAllowanceChargeType implements AllowancesAndCharges !!!
		specifiedLineTradeSettlement.getSpecifiedTradeAllowanceCharge().add((TradeAllowanceCharge)allowanceOrCharge);
	}

	@Override
	public List<AllowancesAndCharges> getAllowancesAndCharges() {
		List<TradeAllowanceChargeType> allowanceChargeList = specifiedLineTradeSettlement.getSpecifiedTradeAllowanceCharge();
		List<AllowancesAndCharges> res = new ArrayList<AllowancesAndCharges>(allowanceChargeList.size());
		allowanceChargeList.forEach(stac -> {
			res.add(TradeAllowanceCharge.create(stac));
		});
		return res;
	}

	// 1 .. 1 SpecifiedTradeProduct.Name BT-153
	void setItemName(String text) {
		specifiedTradeProduct.getName().add(new Text(text));
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getItemName() {
		return specifiedTradeProduct.getName().get(0).getValue();
	}

	@Override // 0 .. 1 SpecifiedTradeProduct.Description BT-154 Bsp: <ram:Description>Zeitschrift Inland</ram:Description>
	public void setDescription(String text) {
		if(text==null) return;
		specifiedTradeProduct.setDescription(new Text(text));
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getDescription() {
		return specifiedTradeProduct.getDescription()==null ? null : specifiedTradeProduct.getDescription().getValue();
	}

	@Override // 0 .. 1 BT-155 Bsp: <ram:SellerAssignedID>246</ram:SellerAssignedID>
	public void setSellerAssignedID(String id) {
		if(id==null) return;
		specifiedTradeProduct.setSellerAssignedID(new ID(id)); // No identification scheme is to be used.
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getSellerAssignedID() {
		return specifiedTradeProduct.getSellerAssignedID()==null ? null : specifiedTradeProduct.getSellerAssignedID().getValue();
	}

	@Override // 0 .. 1 BT-156
	public void setBuyerAssignedID(String id) {
		if(id==null) return;
		specifiedTradeProduct.setBuyerAssignedID(new ID(id)); // No identification scheme is to be used.
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
	public void setStandardIdentifier(Identifier id) {
		if(id==null) return;
		setStandardID(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void setStandardID(String id) {
		setStandardID(id, null);
	}
	@Override
	public void setStandardID(String id, String schemeID) {
		if(id==null) return;
		specifiedTradeProduct.setGlobalID(new ID(id, schemeID));
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public Identifier getStandardIdentifier() {
		return specifiedTradeProduct.getGlobalID()==null ? null : new ID(specifiedTradeProduct.getGlobalID().getValue(), specifiedTradeProduct.getGlobalID().getSchemeID());
	}
	@Override
	public String getStandardID() {
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
	public void addClassificationID(Identifier id) {
		addClassificationID(id.getContent(), id.getSchemeIdentifier(), id.getSchemeVersion());
	}
	@Override
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
	public List<Identifier> getClassifications() {
		List<ProductClassificationType> productClassifications = specifiedTradeProduct.getDesignatedProductClassification();
		List<Identifier> result = new ArrayList<Identifier>(productClassifications.size());
		productClassifications.forEach(pc -> {
			CodeType code = pc.getClassCode();
			if(code!=null) {
				Identifier id = new ID(code.getValue(), code.getListID(), code.getListVersionID());
				result.add(id);
			}
		});
		return result;
	}

	// BG-31.BT-159 +++ 0..1 Item country of origin
	@Override
	public void setCountryOfOrigin(String code) {
		if(code==null) return;
		CountryIDType countryID = new CountryIDType();
		countryID.setValue(code);
		TradeCountryType tradeCountry = new TradeCountryType();
		tradeCountry.setID(countryID);
		specifiedTradeProduct.setOriginTradeCountry(tradeCountry);
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public String getCountryOfOrigin() {
		TradeCountryType tradeCountry = specifiedTradeProduct.getOriginTradeCountry()==null ? null : specifiedTradeProduct.getOriginTradeCountry();
		return tradeCountry==null ? null : 
			tradeCountry.getID()==null ? null : tradeCountry.getID().getValue();
	}

	// 0..n BG-32.BT-160 + BT-161 (both terms mandatory)
	@Override
	public void addItemAttribute(String name, String value) {
		if(name==null) return; // darf nicht sein, denn BT-160 + BT-161 sind mandatory 
		ProductCharacteristicType productCharacteristics = new ProductCharacteristicType();
		productCharacteristics.getDescription().add(new Text(name)); //nur eine wg. 1..1
		productCharacteristics.getValue().add(new Text(value)); //nur eine wg. 1..1
		specifiedTradeProduct.getApplicableProductCharacteristic().add(productCharacteristics);
		super.setSpecifiedTradeProduct(specifiedTradeProduct);
	}

	@Override
	public Properties getItemAttributes() {
		List<ProductCharacteristicType> productCharacteristics = specifiedTradeProduct.getApplicableProductCharacteristic();
		Properties result = new Properties();
		productCharacteristics.forEach(pc -> {
			result.put(pc.getDescription().get(0).getValue(), pc.getValue().get(0).getValue());			
		});
		return result;
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
	 * 
	 * @param codeEnum 1..1 EN16931-ID: BT-151
	 * @param percent 0..1 EN16931-ID: BT-152
	 */	
	void setTaxCategoryAndRate(TaxCategoryCode code, BigDecimal taxRate) {
		if(tradeTax==null) {
			tradeTax = TradeTax.create(TaxTypeCode.ValueAddedTax, code, taxRate);
			specifiedLineTradeSettlement.getApplicableTradeTax().add(tradeTax);
		} else {
			tradeTax = TradeTax.create(TaxTypeCode.ValueAddedTax, code, taxRate);
			LOG.info("replaces BG-30 LINE VAT INFORMATION with "+tradeTax);
			specifiedLineTradeSettlement.getApplicableTradeTax().set(0, tradeTax);
		}
	}

	@Override
	public TaxCategoryCode getTaxCategory() {
		return tradeTax==null ? null : tradeTax.getTaxCategoryCode();
	}

	public BigDecimal getTaxRate() {
		return tradeTax==null ? null : tradeTax.getTaxPercentage();
	}

}
