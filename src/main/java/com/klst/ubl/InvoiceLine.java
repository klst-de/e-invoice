package com.klst.ubl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.un.unece.uncefact.Amount;
import com.klst.un.unece.uncefact.Quantity;
import com.klst.un.unece.uncefact.UnitPriceAmount;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
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
                                                                               | R17, R23, R27                                                                               | R40
 */
public class InvoiceLine extends InvoiceLineType {

	private static final Logger LOG = Logger.getLogger(InvoiceLine.class.getName());
	
	public InvoiceLine() {
		super();
	}
	
	// copy ctor
	public InvoiceLine(InvoiceLineType invoiceLine) {
		this();
		super.setID(invoiceLine.getID());
		super.setInvoicedQuantity(invoiceLine.getInvoicedQuantity());
		super.setLineExtensionAmount(invoiceLine.getLineExtensionAmount());
		super.setPrice(invoiceLine.getPrice());
		super.setItem(invoiceLine.getItem());
		
		List<OrderLineReferenceType> olReferences = super.getOrderLineReference();
		List<OrderLineReferenceType> orderLineReferences = invoiceLine.getOrderLineReference();
		orderLineReferences.forEach(orderLineReference -> {
			olReferences.add(orderLineReference);
		});
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
		IDType lineID = new IDType();
		lineID.setValue(identifier);
		super.setID(lineID);
		
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
		
		ItemType item = getItemInformation(); // ITEM INFORMATION, creates new if necessary
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
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BT-126
	 * <br>Req.ID: R44
	 *  
	 * @return Identifier
	 */
	public String getId() {
		return super.getID().getValue();
	}
	//public void setId(String identifier); // use ctor
	
	/**
	 * UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BT-129, BT-130
	 * <br>Req.ID: R39, R56, R14
	 *  
	 * @return Quantity
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
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BT-131 
	 * <br>Req.ID: R39, R40, R56
	 * 
	 * @return Amount
	 */
	public Amount getLineNetAmount() {
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
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BG-29, BT-146 
	 * <br>Req.ID: R14
	 * 
	 * @return Unit price amount
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

	/**
	 * Item name (mandatory part in ITEM INFORMATION)
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BG-31, BT-153 
	 * <br>Req.ID: R20, R56, R25, R26
	 * 
	 * @return Text
	 */
	public String getItemName() {
		return getItemInformation().getName().getValue();
	}
	private void setItemName(String itemName) {
		NameType name = new NameType();
		name.setValue(itemName);
		ItemType item = getItemInformation();
		item.setName(name);
	}
	
	/* ITEM INFORMATION
	 * A group of business terms providing information about the goods and services invoiced.
	 * Cardinality: 1..1 (mandatory)
	 * Req.ID: R20, R56, R25, R26
	 */
	private ItemType getItemInformation() {
		ItemType item = super.getItem();
		if(item!=null) {
			return item;
		}
		// add empty item to this:
		item = new ItemType();
		super.setItem(item);
		return item;
	}

	/* nicht implementiert optionale ITEM INFORMATION Teile TODO:
BT-155 +++ 0..1 Item Seller's identifier
BT-156 +++ 0..1 Item Buyer's identifier
BT-157 +++ 0..1 Item standard identifier + identification scheme identifier of the Item standard identifier
BT-158 +++ 0..n Item classification identifier
BT-159 +++ 0..1 Item country of origin
BG-32  +++ 0..n ITEM ATTRIBUTES
	 */
	
	/**
	 * Item description (optional part in ITEM INFORMATION)
	 * <p>
	 * A description for an item. The Item description allows for describing the item 
	 * and its features in more detail than the Item name.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BG-31, BT-154 
	 * <br>Req.ID: R20, R56
	 * @return Text
	 */
	public List<String> getItemDescriptions() {
		List<DescriptionType> descriptions = getItemInformation().getDescription();
		List<String> result = new ArrayList<String>(descriptions.size());
		descriptions.forEach(description -> {
			// DescriptionType extends TextType extends un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.TextType
			result.add(description.getValue());
		});
		return result;
	}
	public void addItemDescription(String descriptionText) {
		List<DescriptionType> descriptions = getItemInformation().getDescription();
		DescriptionType description = new DescriptionType();
		description.setValue(descriptionText);
		descriptions.add(description);
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
		List<TaxCategoryType> taxCategories = getItemInformation().getClassifiedTaxCategory();
		List<VatCategory> result = new ArrayList<VatCategory>(taxCategories.size());
		taxCategories.forEach(taxCategory -> {
			result.add(new VatCategory(taxCategory));
		});
		return result;
	}

}
