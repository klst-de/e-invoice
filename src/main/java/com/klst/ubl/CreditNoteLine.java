package com.klst.ubl;

import java.util.List;

import com.klst.un.unece.uncefact.Amount;
import com.klst.un.unece.uncefact.Quantity;
import com.klst.un.unece.uncefact.UnitPriceAmount;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.QuantityType;

public class CreditNoteLine extends CreditNoteLineType {

	public CreditNoteLine() {
		super();
	}

	// copy ctor
	public CreditNoteLine(CreditNoteLineType line) {
		this();
		super.setID(line.getID());
		super.setCreditedQuantity(line.getCreditedQuantity());
		super.setLineExtensionAmount(line.getLineExtensionAmount());
		super.setPrice(line.getPrice());
		super.setItem(line.getItem());
		
		List<OrderLineReferenceType> olReferences = super.getOrderLineReference();
		List<OrderLineReferenceType> orderLineReferences = line.getOrderLineReference();
		orderLineReferences.forEach(orderLineReference -> {
			olReferences.add(orderLineReference);
		});
	}

	/*
	 * mandatory elements // Doku fehlt, daher wie INVOICE LINE
	 * 
	 * @param identifier : a unique identifier for the individual line within the Invoice.
	 * @param quantity : UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * @param lineNetAmount : the total amount of the Invoice line.
	 * @param priceAmt : item net price (mandatory part in PRICE DETAILS)
	 * @param itemName : a name for an item (mandatory part in ITEM INFORMATION)
	 * @param vatCategory : VAT category code and rate for the invoiced item. (mandatory part in LINE VAT INFORMATION)
	 */
	public CreditNoteLine(String identifier, Quantity quantity, Amount lineNetAmount, UnitPriceAmount priceAmt
			, String itemName, VatCategory vatCategory) {
		this();
		IDType lineID = new IDType();
		lineID.setValue(identifier);
		super.setID(lineID);
		
		setQuantity(quantity);
		
		setLineNetAmount(lineNetAmount);
		
		setItemNetPrice(priceAmt);
		
		ItemType item = getItemInformation(); // ITEM INFORMATION, creates new if necessary
		setItemName(itemName);
		
		List<TaxCategoryType> taxCategories = item.getClassifiedTaxCategory();
	}
	
	public String getId() {
		return super.getID().getValue();
	}
	//public void setId(String identifier); // use ctor
	
	public Quantity getQuantity() {
		QuantityType quantity = super.getCreditedQuantity();
		return new Quantity(quantity.getUnitCode(), quantity.getValue());
	}
	private void setQuantity(Quantity quantity) {
		CreditedQuantityType creditedQuantity = new CreditedQuantityType();
		creditedQuantity.setUnitCode(quantity.getUnitCode());
		creditedQuantity.setValue(quantity.getValue());
		super.setCreditedQuantity(creditedQuantity);
	}

	public Amount getLineNetAmount() {
		LineExtensionAmountType amount = super.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}
	private void setLineNetAmount(Amount amount) {
		LineExtensionAmountType lineExtensionAmount = new LineExtensionAmountType();
		amount.copyTo(lineExtensionAmount);
		super.setLineExtensionAmount(lineExtensionAmount);
	}

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

	public String getItemName() {
		return getItemInformation().getName().getValue();
	}
	private void setItemName(String itemName) {
		NameType name = new NameType();
		name.setValue(itemName);
		ItemType item = getItemInformation();
		item.setName(name);
	}

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

}
