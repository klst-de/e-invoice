package com.klst.ubl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.un.unece.uncefact.Amount;
import com.klst.un.unece.uncefact.Quantity;
import com.klst.un.unece.uncefact.UnitPriceAmount;

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
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.QuantityType;

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
public class InvoiceLine extends InvoiceLineType {

	private static final Logger LOG = Logger.getLogger(InvoiceLine.class.getName());
	
	public InvoiceLine() {
		super();
	}
	
	// copy ctor
	public InvoiceLine(InvoiceLineType line) {
		this();
		super.setID(line.getID());
		super.setInvoicedQuantity(line.getInvoicedQuantity());
		super.setLineExtensionAmount(line.getLineExtensionAmount());
		super.setPrice(line.getPrice());
		super.setItem(line.getItem());
		
		List<NoteType> noteList = line.getNote(); // optional BT-127
		noteList.forEach(note -> {
			LOG.info("line.noteList.size:"+noteList.size() + " note:"+note.getValue());
			setNote(note.getValue());
		});
		
		List<OrderLineReferenceType> orderLineReferences = line.getOrderLineReference();
		orderLineReferences.forEach(orderLineReference -> {
			LOG.info("line.OrderLineReference.size:"+orderLineReferences.size() + " LineID:"+orderLineReference.getLineID().getValue());
			setOrderLineID(orderLineReference.getLineID().getValue());
		});
		
//		item = new ItemType();
//		super.setItem(item);
//		ItemType item = line.getItem();
//		if(item!=null) {
//			ItemIdentificationType itemIdentification = item.getSellersItemIdentification();
//			if(itemIdentification==null) {
//				//
//			} else {
//				this.setSellerAssignedID(itemIdentification.getID()==null ? null : itemIdentification.getID().getValue()) ;
//			}
//			List<String> descriptionList = getItemDescriptions(line);
//			LOG.info("Zeile 105 descriptionList.size:"+descriptionList.size());
//			descriptionList.forEach(description -> {
//				LOG.info("Zeile 107 description:"+description);
//				addItemDescription(description);
//			});
//		} else {
//			LOG.warning("line.item!=null !!!!!!!!!!!!!!!!!!!!!!!!!!");
//		}
	}
	
	/**
	 * mandatory elements of INVOICE LINE
	 * 
	 * @param identifier : a unique identifier for the individual line within the Invoice.
	 * @param quantity : UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * @param lineNetAmount : the total amount of the Invoice line.
	 * @param priceAmt : item net price (mandatory part in PRICE DETAILS)
	 * @param itemName : a name for an item (mandatory part in ITEM INFORMATION)
	 * @param vatCategory : VAT category code and rate for the invoiced item. (mandatory part in LINE VAT INFORMATION)
	 */
	public InvoiceLine(String identifier, Quantity quantity, Amount lineNetAmount, UnitPriceAmount priceAmt
			, String itemName, VatCategory vatCategory) {
		this();
		super.setID(Invoice.newIDType(identifier, null)); // null : No identification scheme 
		
		setQuantity(quantity);
		
		setLineNetAmount(lineNetAmount);
		
		setItemNetPrice(priceAmt);
		
		/*
	    <cac:OrderLineReference>                                             TODO optional
	      <!-- Bestellpositionsnummer für dies Rechnungszeile: -->
	      <!-- Order position number for this invoice line: -->
	      <cbc:LineID>10</cbc:LineID>
	    </cac:OrderLineReference>
//		invoiceLine.getOrderLineReference()
*/
		
//		ItemType item = getItemInformation(); // ITEM INFORMATION, creates new if necessary
		item = new ItemType();
		super.setItem(item);

		setItemName(itemName);
//		ItemType item = new ItemType();
//		NameType name = new NameType();
//		name.setValue(itemName);
//		item.setName(name);
		
		List<TaxCategoryType> taxCategories = item.getClassifiedTaxCategory();
//		taxCategories.add(new TaxCategory(taxCategoryCode, taxRate));
		taxCategories.add(vatCategory);
		
//		super.setItem(item);
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
	//public void setId(String identifier); // use ctor
	public String getId() {
		return super.getID().getValue();
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
	public Quantity getQuantity() {
		QuantityType quantity = super.getInvoicedQuantity();
		return new Quantity(quantity.getUnitCode(), quantity.getValue());
	}
	private void setQuantity(Quantity quantity) {
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
	public Amount getLineNetAmount() { // Umbenennen in LineTotalAmount
		LineExtensionAmountType amount = super.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}
	private void setLineNetAmount(Amount amount) {
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
	public UnitPriceAmount getItemNetPrice() {
		PriceAmountType priceAmount = super.getPrice().getPriceAmount();
		return new UnitPriceAmount(priceAmount.getCurrencyID(), priceAmount.getValue());
	}
	private void setItemNetPrice(UnitPriceAmount priceAmt) {
		PriceAmountType priceAmount = new PriceAmountType();
		priceAmt.copyTo(priceAmount);
		PriceType price = new PriceType();
		price.setPriceAmount(priceAmount);
		super.setPrice(price);
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
	public void setNote(String text) {
		NoteType note = new NoteType();
		note.setValue(text);
		super.getNote().add(note);
	}
	
	/* TODO test
BT-132 ++ 0..1 Referenced purchase order line reference
An identifier for a referenced line within a purchase order, issued by the Buyer.
The purchase order identifier is referenced on document level. 
R6 Document reference	 
*/
	public List<String> getOrderLineID() {
		List<OrderLineReferenceType> orderLineRefList = super.getOrderLineReference();
		List<String> result = new ArrayList<String>(orderLineRefList.size());
		orderLineRefList.forEach(orderLineRef -> {
			result.add(orderLineRef.getLineID().getValue());
		});
		return result;
	}
	public void setOrderLineID(String id) {
		LineIDType lineID = new LineIDType();
		lineID.setValue(id);
		OrderLineReferenceType orderLineReference = new OrderLineReferenceType();
		orderLineReference.setLineID(lineID);
		super.getOrderLineReference().add(orderLineReference);
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
	public String getItemName() {
		ItemType item = super.getItem();
		return item.getName()==null ? null : item.getName().getValue();
	}
	private void setItemName(String itemName) {
		NameType name = new NameType();
		name.setValue(itemName);
		ItemType item = super.getItem();
		item.setName(name);
	}
//	private ItemType getItemInformation() {
//		ItemType item = super.getItem();
//		if(item!=null) {
//			return item;
//		}
//		// add empty item to this: causes getItemInformation in lambda!!!
//		item = new ItemType();
//		super.setItem(item);
//		return item;
//	}

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
	public String getSellerAssignedID() {
		ItemType item = super.getItem();
		ItemIdentificationType itemIdentification = item.getSellersItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : itemIdentification.getID().getValue();
	}
	public void setSellerAssignedID(String id) {
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(Invoice.newIDType(id, null));
		ItemType item = super.getItem();
		item.setSellersItemIdentification(itemIdentification);
	}
	
	
	public VatCategory getVatCategory() {
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

}
