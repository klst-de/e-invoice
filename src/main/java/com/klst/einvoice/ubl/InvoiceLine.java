package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;

/* @see XRechnung-v1-2-0.pdf : 11.16. Gruppe INVOICE LINE

Dieses Informationselement (ID: BG-25, Anz. 1..*) ist ein direkter Bestandteil des Wurzelelements „INVOICE“
Eine Gruppe von Informationselementen, die Informationen über einzelne Rechnungspositionen liefern.

mandatory:
Invoice line identifier BT-126 Identifier 1 / Eindeutige Bezeichnung für die betreffende Rechnungsposition
Invoiced quantity       BT-129 Quantity   1 / Die Menge zu dem in der betreffenden Zeile in Rechnung gestellten Einzelposten (Waren oder Dienstleistungen)
Invoiced quantity unit of measure code BT-130 Code 1 / Die für die in Rechnung gestellte Menge geltende Maßeinheit.
Invoice line net amount BT-131 Amount     1 / Der Gesamtbetrag der Rechnungsposition. Dies ist der Betrag ohne Umsatzsteuer, aber einschließlich 
                                              aller für die Rechnungsposition geltenden Nachlässe und Abgaben sowie sonstiger anfallender Steuern.
PRICE DETAILS           BG-29             1
LINE VAT INFORMATION    BG-30             1
ITEM INFORMATION        BG-31             1

 */
/* @see European standard EN 16931-1:2017
 * 
 * 
ID    | Level | Cardinality | Business Term         | Description | Usage Note | Req.ID   | Semantic data type
BG-25 | +     | 1..n        | INVOICE LINE          | A group of business terms providing information on individual Invoice lines.
                                                                               | R17, R23, R27  
                                                                               
 TODO
 01.01a-INVOICE_ubl.xml :                                                                                                                                                            
        <cac:InvoicePeriod>
            <cbc:StartDate>2016-01-01+01:00</cbc:StartDate>
            <cbc:EndDate>2016-12-31+01:00</cbc:EndDate>
        </cac:InvoicePeriod>
 ...
         <cac:OrderLineReference>
            <cbc:LineID>6171175.1</cbc:LineID>
        </cac:OrderLineReference>
...
        <cac:Item>
...
            <cac:CommodityClassification>
                <cbc:ItemClassificationCode listID="IB">0721-880X</cbc:ItemClassificationCode>
            </cac:CommodityClassification>
                                                                                                                                                          | R40
 */
public class InvoiceLine extends InvoiceLineType implements CoreInvoiceLine {

	private static final Logger LOG = Logger.getLogger(InvoiceLine.class.getName());
	
	public InvoiceLine() {
		super();
	}
	
	// copy ctor
	public InvoiceLine(InvoiceLineType line) {
		this();
		item = line.getItem();
		price = line.getPrice();
		
		TaxCategoryType classifiedTaxCategory = null;
		List<TaxCategoryType> taxCategories = item.getClassifiedTaxCategory();
		if(taxCategories.size()==1) {
			classifiedTaxCategory = taxCategories.get(0);
		} else if(taxCategories.size()==0) {
			LOG.warning("inkonsistent: taxCategories.size="+taxCategories.size() + " muss 1 sein" );
		} else {
			LOG.info("taxCategories.size="+taxCategories.size() + " muss 1 sein!" );
			classifiedTaxCategory = taxCategories.get(0);
		}
		VatCategory vatCategory = new VatCategory(classifiedTaxCategory);

		init( line.getID().getValue()
			, new Quantity(line.getInvoicedQuantity().getUnitCode(), line.getInvoicedQuantity().getValue())
			, new Amount(line.getLineExtensionAmount().getCurrencyID(), line.getLineExtensionAmount().getValue())
			, new UnitPriceAmount(price.getPriceAmount().getCurrencyID(), price.getPriceAmount().getValue())
			, item.getName().getValue()
			, vatCategory.getTaxCategoryCode() // TaxCategoryCode.valueOf(tradeTax.getCategoryCode())
			, vatCategory.getTaxRate()         // percent==null ? null : percent.getValue()
			);

		
		if(line.getOrderLineReference().isEmpty()) { // opt BT-132 0..1
			// nix, da optional
		} else {
			super.getOrderLineReference().add(line.getOrderLineReference().get(0));
		}
//		line.getInvoicePeriod() // List TODO
		
	}
	
	/**
	 * mandatory elements of INVOICE LINE
	 * 
	 * @param identifier : a unique identifier for the individual line within the Invoice.
	 * @param quantity : UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * @param lineNetAmount : the total amount of the Invoice line.
	 * @param priceAmt : item net price (mandatory part in PRICE DETAILS)
	 * @param itemName : a name for an item (mandatory part in ITEM INFORMATION)
//	 * @param vatCategory : VAT category code and rate for the invoiced item. (mandatory part in LINE VAT INFORMATION)
	 * @param BG-30.BT-151 codeEnum 1..1 VAT category code
	 * @param BG-30.BT-152 percent  0..1 VAT rate
	 */
	public InvoiceLine(String id, Quantity quantity, Amount lineTotalAmount, UnitPriceAmount priceAmount, String itemName
			, TaxCategoryCode codeEnum, BigDecimal percent) {
		this();
		item = new ItemType();
		price = new PriceType();
		init(id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent);
	}

	void init(String id, Quantity quantity, Amount lineTotalAmount, UnitPriceAmount priceAmount, String itemName
			, TaxCategoryCode codeEnum, BigDecimal percent) {
		setId(id);
		setQuantity(quantity);
		setLineTotalAmount(lineTotalAmount);
		setUnitPriceAmount(priceAmount);
		setItemName(itemName);
		setTaxCategoryAndRate(codeEnum, percent==null ? null : new Percent(percent));
	}

	// 1 .. 1 LineID BT-126  ------------ use ctor
	public void setId(String id) {
		super.setID(Invoice.newIDType(id, null)); // null : No identification scheme 
	}
	
	/**
	 * Invoice line identifier - a unique identifier for the individual line within the Invoice.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-126
	 * <br>Rule ID: 	BR-21
	 * <br>Request ID: 	R44
	 *  
	 */
 	@Override
	public String getId() {
		return super.getID().getValue();
	}
	
	/*
	 * 
	 * @param codeEnum 1..1 EN16931-ID: BT-151
	 * @param percent 0..1 EN16931-ID: BT-152
	 */
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, Percent percent) {
		VatCategory taxCategory = new VatCategory(codeEnum, percent);
		item.getClassifiedTaxCategory().add(taxCategory);
	}
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, BigDecimal percent) {
		setTaxCategoryAndRate(codeEnum, percent==null ? null : new Percent(percent));
	}
	
	/**
	 * UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-130, BT.129
	 * <br>Rule ID: 	BR-23, BR-22
	 * <br>Request ID: 	R39, R56, R14
	 *  
	 */
 	@Override
	public Quantity getQuantity() {
		InvoicedQuantityType quantity = super.getInvoicedQuantity();
		return new Quantity(quantity.getUnitCode(), quantity.getValue());
	}
	void setQuantity(Quantity quantity) {
		InvoicedQuantityType invoicedQuantity = new InvoicedQuantityType();
		invoicedQuantity.setUnitCode(quantity.getUnitCode());
		invoicedQuantity.setValue(quantity.getValue());
		super.setInvoicedQuantity(invoicedQuantity);
	}

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
	 */
 	@Override
	public Amount getLineTotalAmount() {
		LineExtensionAmountType amount = super.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}
	void setLineTotalAmount(Amount amount) {
		LineExtensionAmountType lineExtensionAmount = new LineExtensionAmountType();
		amount.copyTo(lineExtensionAmount);
		super.setLineExtensionAmount(lineExtensionAmount);
	}

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
	public UnitPriceAmount getUnitPriceAmount() {
		PriceAmountType priceAmount = super.getPrice().getPriceAmount();
		return new UnitPriceAmount(priceAmount.getCurrencyID(), priceAmount.getValue());
	}
	public void setUnitPriceAmount(UnitPriceAmount priceAmt) {
		PriceAmountType priceAmount = new PriceAmountType();
		priceAmt.copyTo(priceAmount);
		PriceType price = new PriceType();
		price.setPriceAmount(priceAmount);
		super.setPrice(price);
	}

	@Override
	public String getNoteText() {
		List<String> noteList = getNotes();
		return noteList.isEmpty() ? null : noteList.get(0); // wg. 0..1
	}

	/*
BT-127 ++ 0..1 Invoice line note
A textual note that gives unstructured information that is relevant to the Invoice line.
R28 Text
	 */
	public List<String> getNotes() {
		List<NoteType> noteList = super.getNote();
		List<String> result = new ArrayList<String>(noteList.size());
		noteList.forEach(note -> {
			result.add(note.getValue());
		});
		return result;
	}
 	@Override
	public void setNoteText(String text) {
		NoteType note = new NoteType();
		note.setValue(text);
		super.getNote().add(note);
	}
	
	@Override
	public void setOrderLineID(String lineReference) {
		LineIDType lineID = new LineIDType();
		lineID.setValue(lineReference);
		OrderLineReferenceType orderLineReference = new OrderLineReferenceType();
		orderLineReference.setLineID(lineID);
		super.getOrderLineReference().add(orderLineReference);
	}

	@Override
	public String getOrderLineID() {
		List<String> list = getOrderLineIDs();
		return list.isEmpty() ? null : list.get(0); // wg. 0..1
	}
	
	/* test
BT-132 ++ 0..1 Referenced purchase order line reference
An identifier for a referenced line within a purchase order, issued by the Buyer.
The purchase order identifier is referenced on document level. 
R6 Document reference	 
*/
	public List<String> getOrderLineIDs() { // public wg.Test
		List<OrderLineReferenceType> orderLineRefList = super.getOrderLineReference();
		List<String> result = new ArrayList<String>(orderLineRefList.size());
		orderLineRefList.forEach(orderLineRef -> {
			result.add(orderLineRef.getLineID().getValue());
		});
		return result;
	}

	
	/* BG-31 ITEM INFORMATION
	 * A group of business terms providing information about the goods and services invoiced

1 .. 1 SpecifiedTradeProduct Artikelinformationen                 BG-31 xs:sequence
0 .. 1 GlobalID Kennung eines Artikels nach registriertem Schema  BT-157      TODO 
       required schemeID Kennung des Schemas                      BT-157-1 
0 .. 1 SellerAssignedID Artikelnummer des Verkäufers              BT-155
0 .. 1 BuyerAssignedID Artikelnummer des Käufers                  BT-156      TODO 
1 .. 1 Name Artikelname                                           BT-153 
0 .. 1 Description Artikelbeschreibung                            BT-154
0 .. n ApplicableProductCharacteristic Artikelattribute           BG-32 xs:sequence 
0 .. 1 TypeCode Art der Produkteigenschaft (Code) 
1 .. 1 Description Artikelattributname                            BT-160 
0 .. 1 ValueMeasure Wert der Produkteigenschaft (numerische Messgröße) 
       required unitCode Maßeinheit 
1 .. 1 Value Artikelattributwert                                  BT-161 
0 .. n DesignatedProductClassification Detailinformationen zur Produktklassifikation xs:sequence 
1 .. 1 ClassCode Kennung der Artikelklassifizierung               BT-158      TODO 
       required listID Kennung des Schemas                        BT-158-1 
       optional listVersionID Version des Schemas                 BT-158-2 
0 .. 1 ClassName Klassifikationsname 
0 .. 1 OriginTradeCountry Detailinformationen zur Produktherkunft xs:sequence 
1 .. 1 ID Artikelherkunftsland                                    BT-159      TODO
...
1 .. 1 SpecifiedLineTradeAgreement Detailinformationen zum Preis  BG-29 xs:sequence 
0 .. 1 BuyerOrderReferencedDocument Detailangaben zur zugehörigen Bestellung xs:sequence 
0 .. 1 IssuerAssignedID Bestellnummer 
0 .. 1 LineID Referenz zur Bestellposition                        BT-132      TODO

nicht implementiert optionale ITEM INFORMATION Teile TODO:
BT-156 +++ 0..1 Item Buyer's identifier
BT-157 +++ 0..1 Item standard identifier + identification scheme identifier of the Item standard identifier
BT-158 +++ 0..n Item classification identifier
BT-159 +++ 0..1 Item country of origin
BG-32  +++ 0..n ITEM ATTRIBUTES
BT-132 ++  0..1 Referenced purchase order line reference

	 */
	/**
	 * Item name (mandatory part in BG-31 ITEM INFORMATION)
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-153 
	 * <br>Rule ID: 	BR-25
	 * <br>Request ID: 	R20, R56
	 * 
	 */
 	@Override
	public String getItemName() {
		ItemType item = super.getItem();
		return item.getName()==null ? null : item.getName().getValue();
	}
	void setItemName(String itemName) {
		NameType name = new NameType();
		name.setValue(itemName);
		ItemType item = super.getItem();
		item.setName(name);
	}

	/**
	 * Item description (optional part in ITEM INFORMATION)
	 * <p>
	 * A description for an item. The Item description allows for describing the item 
	 * and its features in more detail than the Item name.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-154 
	 * <br>Rule ID:
	 * <br>Request ID: 	R20, R56
	 * 
	 */
	public List<String> getItemDescriptions() {
		return getItemDescriptions(this);
	}
	static List<String> getItemDescriptions(InvoiceLineType line) {
		ItemType item = line.getItem();
		if(item==null) {
			return new ArrayList<String>();
		}
		List<DescriptionType> descriptionList = item.getDescription();
		List<String> result = new ArrayList<String>(descriptionList.size());
		descriptionList.forEach(description -> {
			result.add(description.getValue());
		});
		return result;
	}
	public void addItemDescription(String descriptionText) {
		LOG.info("descriptionText:"+descriptionText);
		ItemType item = super.getItem();
		DescriptionType description = new DescriptionType();
		description.setValue(descriptionText);
		item.getDescription().add(description);
	}
	
	/**
	 * SellerAssignedID (optional part in ITEM INFORMATION)
	 * <p>
	 * An identifier, assigned by the Seller, for the item. 
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-155 
	 * <br>Rule ID:
	 * <br>Request ID: 	R21, R56
	 * 
	 */
 	@Override
	public String getSellerAssignedID() {
		ItemType item = super.getItem();
		ItemIdentificationType itemIdentification = item.getSellersItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : itemIdentification.getID().getValue();
	}
 	@Override
	public void setSellerAssignedID(String id) {
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(Invoice.newIDType(id, null));
		ItemType item = super.getItem();
		item.setSellersItemIdentification(itemIdentification);
	}
	
	
	public VatCategory getVatCategory() { // TODO public nur wg test
		List<VatCategory> taxCategories = getVatCategories();
		if(taxCategories.size()!=1) {
			LOG.warning("inkonsistent: taxCategories.size="+taxCategories.size() + " muss 1 sein" );
		}
		return taxCategories.get(0);
	}
	/*
	 * mandatory elements in LINE VAT INFORMATION
	 * @return List of LINE VAT INFORMATION
	 * 
	 * BG-30 ++ 1..1 LINE VAT INFORMATION ------------ hiernach gibt es nur ein Eintrag in der Liste
	 */
	private List<VatCategory> getVatCategories() {
		ItemType item = super.getItem();
		List<TaxCategoryType> taxCategories = item.getClassifiedTaxCategory();
		List<VatCategory> result = new ArrayList<VatCategory>(taxCategories.size());
		taxCategories.forEach(taxCategory -> {
			result.add(new VatCategory(taxCategory));
		});
		return result;
	}

	@Override
	public void setDescription(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitPriceAmount getItemNetPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUnitPriceAmountAndQuantity(UnitPriceAmount unitPriceAmount, Quantity quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Quantity getBaseQuantity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaxCategoryCode getTaxCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getTaxRate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBuyerAssignedID(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBuyerAssignedID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStandardID(String id, String schemeID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStandardID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addClassificationID(String id, String schemeID, String schemeVersion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> getClassificationList() {
		// TODO Auto-generated method stub
		return null;
	}

}
