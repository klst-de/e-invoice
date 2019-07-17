package com.klst.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.QuantityType;

public class CreditNoteLine extends CreditNoteLineType {

	private static final Logger LOG = Logger.getLogger(CreditNoteLine.class.getName());
	
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
	public CreditNoteLine(String identifier, Quantity quantity, Amount lineNetAmount, UnitPriceAmount priceAmt, String itemName) {
		this();
		super.setID(Invoice.newIDType(identifier, null)); // null : No identification scheme 
		
		setQuantity(quantity);
		
		setLineNetAmount(lineNetAmount);
		
		setItemNetPrice(priceAmt);
		
		item = new ItemType();
		super.setItem(item);

		setItemName(itemName);

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
//	@Override TODO
	public void setTaxCategoryAndRate(TaxCategoryCode codeEnum, BigDecimal percent) {
		setTaxCategoryAndRate(codeEnum, percent==null ? null : new Percent(percent));
	}
	
//	 * <br>Request ID: 	R44
	//public void setId(String identifier); // use ctor
	public String getId() {
		return super.getID().getValue();
	}
	
//	 * <br>EN16931-ID: 	BT-130, BT.129
	public Quantity getQuantity() {
		QuantityType quantity = super.getCreditedQuantity();
		return quantity==null ? null : new Quantity(quantity.getUnitCode(), quantity.getValue());
	}
	private void setQuantity(Quantity quantity) {
		if(quantity==null) return;
		CreditedQuantityType creditedQuantity = new CreditedQuantityType();
		creditedQuantity.setUnitCode(quantity.getUnitCode());
		creditedQuantity.setValue(quantity.getValue());
		super.setCreditedQuantity(creditedQuantity);
	}

//	 * <br>EN16931-ID: 	BT-131
	public Amount getLineNetAmount() {
		LineExtensionAmountType amount = super.getLineExtensionAmount();
		return amount==null ? null : new Amount(amount.getCurrencyID(), amount.getValue());
	}
	private void setLineNetAmount(Amount amount) {
		if(amount==null) return;
		LineExtensionAmountType lineExtensionAmount = new LineExtensionAmountType();
		amount.copyTo(lineExtensionAmount);
		super.setLineExtensionAmount(lineExtensionAmount);
	}

//	 * <br>EN16931-ID: 	BG-29, BT-146 
	public UnitPriceAmount getItemNetPrice() {
		if(super.getPrice()==null) return null;
		PriceAmountType priceAmount = super.getPrice().getPriceAmount();
		return priceAmount==null ? null : new UnitPriceAmount(priceAmount.getCurrencyID(), priceAmount.getValue());
	}
	private void setItemNetPrice(UnitPriceAmount priceAmt) {
		if(priceAmt==null) return;
		PriceAmountType priceAmount = new PriceAmountType();
		priceAmt.copyTo(priceAmount);
		PriceType price = new PriceType();
		price.setPriceAmount(priceAmount);
		super.setPrice(price);
	}

//	 * <br>EN16931-ID: 	BG-31, BT-153 
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

//	 * <br>EN16931-ID: 	BT-154
	public List<String> getItemDescriptions() {
		return getItemDescriptions(this);
	}
	static List<String> getItemDescriptions(CreditNoteLineType line) {
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
