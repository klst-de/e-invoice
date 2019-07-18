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

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CommodityClassificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ItemClassificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
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
 */
public class InvoiceLine extends InvoiceLineType implements CoreInvoiceLine {

	private static final Logger LOG = Logger.getLogger(InvoiceLine.class.getName());
	
	private static final String NOT_IMPEMENTED = "NOT IMPEMENTED";

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
		TaxCategoryCode taxCategoryCode = TaxCategoryCode.valueOf(classifiedTaxCategory);
		PercentType taxRatePercent = classifiedTaxCategory.getPercent();

		init( line.getID().getValue()
			, new Quantity(line.getInvoicedQuantity().getUnitCode(), line.getInvoicedQuantity().getValue())
			, new Amount(line.getLineExtensionAmount().getCurrencyID(), line.getLineExtensionAmount().getValue())
			, new UnitPriceAmount(price.getPriceAmount().getCurrencyID(), price.getPriceAmount().getValue())
			, item.getName().getValue()
			, taxCategoryCode
			, taxRatePercent==null ? null : taxRatePercent.getValue()
			);
		
		List<NoteType> noteList = line.getNote();
		noteList.forEach(note -> {
			setNoteText(note.getValue()); // opt 
		});
		
		List<DescriptionType> descriptionList = item.getDescription();
		if(descriptionList.isEmpty()) {
			// optional
		} else {
			if(descriptionList.size()>1) {
				LOG.warning("descriptionList.size="+descriptionList.size() + " !!!!!!!!!!!!!!!!!!!!!!!" );
			}
			setDescription(descriptionList.get(0).getValue()); 
		}

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
	 * @param identifier  BT-126          : a unique identifier for the individual line within the Invoice.
	 * @param quantity    BT-130+BT.129   : UoM and quantity of goods or services that is charged in the Invoice line.
	 * @param totalAmount BT-131          : the total amount of the Invoice line.
	 * @param priceAmount BG-29.BT-146    : item net price (mandatory part in PRICE DETAILS)
	 * @param itemName    BT-153          : a name for an item (mandatory part in ITEM INFORMATION)
	 * @param codeEnum    BG-30.BT-151 1..1 VAT category code
	 * @param percent     BG-30.BT-152 0..1 VAT rate
	 */
	public InvoiceLine(String id, Quantity quantity, Amount totalAmount, UnitPriceAmount priceAmount, String itemName
			, TaxCategoryCode codeEnum, BigDecimal percent) {
		this();
		item = new ItemType();
		price = new PriceType();
		init(id, quantity, totalAmount, priceAmount, itemName, codeEnum, percent);
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

	/* BT-126 1..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getId()
	 */
 	@Override
	public String getId() {
		return super.getID().getValue();
	}
 	/**
 	 * non public - use ctor
 	 * 
 	 * @param id
 	 */
	void setId(String id) {
		super.setID(Invoice.newIDType(id, null)); // null : No identification scheme 
	}

	/* BT-127 0..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getNoteText()
	 */
	@Override
	public String getNoteText() {
		List<String> noteList = getNotes();
		return noteList.isEmpty() ? null : noteList.get(0); // wg. 0..1
	}
	// public wg. test
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
	
	/* BT-128 0..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getIssuerAssignedID()
	 */
	public String getIssuerAssignedID() {
		LOG.warning(NOT_IMPEMENTED); // TODO
		return null;
	}
	public void setIssuerAssignedID(String id, String schemeID) {
		LOG.warning(NOT_IMPEMENTED); // TODO
	}

	/* BT-130, BT.129 1..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getQuantity()
	 */
 	@Override
	public Quantity getQuantity() {
		InvoicedQuantityType quantity = super.getInvoicedQuantity();
		return new Quantity(quantity.getUnitCode(), quantity.getValue());
	}
 	/**
 	 * non public - use ctor
 	 * 
 	 * @param quantity
 	 */
	void setQuantity(Quantity quantity) {
		InvoicedQuantityType invoicedQuantity = new InvoicedQuantityType();
		invoicedQuantity.setUnitCode(quantity.getUnitCode());
		invoicedQuantity.setValue(quantity.getValue());
		super.setInvoicedQuantity(invoicedQuantity);
	}

	/* BT-131 1..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getLineTotalAmount()
	 */
 	@Override
	public Amount getLineTotalAmount() {
		LineExtensionAmountType amount = super.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}
 	/**
 	 * non public - use ctor
 	 * 
 	 * @param amount
 	 */
	void setLineTotalAmount(Amount amount) {
		LineExtensionAmountType lineExtensionAmount = new LineExtensionAmountType();
		amount.copyTo(lineExtensionAmount);
		super.setLineExtensionAmount(lineExtensionAmount);
	}

	/* BT-132 0..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getOrderLineID()
	 */
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
	@Override
	public void setOrderLineID(String lineReference) {
		LineIDType lineID = new LineIDType();
		lineID.setValue(lineReference);
		OrderLineReferenceType orderLineReference = new OrderLineReferenceType();
		orderLineReference.setLineID(lineID);
		super.getOrderLineReference().add(orderLineReference);
	}

	/* BT-133 0..1
	 * Invoice line Buyer accounting reference
	 * http://docs.peppol.eu/poacc/billing/3.0/syntax/ubl-invoice/tree/
	 */
// TODO	@Override
	public String getBuyerAccounting() {
		return super.getAccountingCost()==null ? null : super.getAccountingCost().getValue();
	}
// TODO	@Override
	public void setBuyerAccounting(String text) {
		if(text==null) return;
		AccountingCostType accountingCost = new AccountingCostType();
		accountingCost.setValue(text);
		super.setAccountingCost(accountingCost);
	}

	/*
	 * BG-26 0..1 INVOICE LINE PERIOD
	 * A group of business terms providing information about the period relevant for the Invoice line.
	 * Is also called Invoice line delivery period. 
	 * R30
	 */
	
	/*
	 * BT-134 0..1 Invoice line period start date
	 * BT-135 0..1 Invoice line period end date
	 */
// TODO	@Override
	public String getInvoiceStartDate() {
		List<PeriodType> periodList = super.getInvoicePeriod();
		return periodList.isEmpty() ? null : "TODO"; //periodList.get(0).getStartDate().getValue(); // XMLGregorian...
	}
	
	/*
	 * BG-27 0..n INVOICE LINE ALLOWANCES
	 * TODO Komplett
	 */
	
	/* 
	 * BG-28 ++ 0..n INVOICE LINE CHARGES
	 * TODO Komplett
	 */
	
	/*
	 * BG-29 1..1 PRICE DETAILS
	 */
	
	/* BG-29.BT-146 1..1 (mandatory part in PRICE DETAILS) aka Item net price
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getItemNetPrice()
	 */
	@Override
	public UnitPriceAmount getUnitPriceAmount() {
		PriceAmountType priceAmount = price.getPriceAmount();
		return new UnitPriceAmount(priceAmount.getCurrencyID(), priceAmount.getValue());
	}
	/**
	 * non public - use ctor
	 * 
	 * @param unitPriceAmount
	 */
	void setUnitPriceAmount(UnitPriceAmount unitPriceAmount) {
		setUnitPriceAmountAndQuantity(unitPriceAmount, null);
	}

	// BT-147 +++ 0..1 Item price discount          TODO
	// BT-148 +++ 0..1 Item gross price             TODO
	
	/* BT-149-0 0..1 , BT-150-0 required
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getBaseQuantity()
	 */
	@Override
	public Quantity getBaseQuantity() {
		BaseQuantityType baseQuantity = price.getBaseQuantity();
		String unit = baseQuantity.getUnitCode();
		return baseQuantity==null ? null : (unit==null ? new Quantity(baseQuantity.getValue()) : new Quantity(unit, baseQuantity.getValue()));
	}
	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#setUnitPriceAmountAndQuantity(com.klst.einvoice.unece.uncefact.UnitPriceAmount, com.klst.einvoice.unece.uncefact.Quantity)
	 */
	@Override
	public void setUnitPriceAmountAndQuantity(UnitPriceAmount unitPriceAmount, Quantity quantity) {
		PriceAmountType priceAmount = new PriceAmountType();
		unitPriceAmount.copyTo(priceAmount);
		PriceType price = new PriceType();
		price.setPriceAmount(priceAmount);
		
		if(quantity!=null) {
			BaseQuantityType baseQuantity = new BaseQuantityType();
			baseQuantity.setUnitCode(quantity.getUnitCode());
			baseQuantity.setValue(quantity.getValue());
			price.setBaseQuantity(baseQuantity);
		}
		
		super.setPrice(price);
	}

	/*
	 * BG-30 1..1 LINE VAT INFORMATION
	 */

	/* BG-30.BT-151 1..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getTaxCategory()
	 */
	@Override
	public TaxCategoryCode getTaxCategory() {
		TaxCategoryType taxCategory = item.getClassifiedTaxCategory().get(0); // wg. 1..1
		return TaxCategoryCode.valueOf(taxCategory); // S
	}
	/* BG-30.BT-152 0..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getTaxRate()
	 */
	@Override
	public BigDecimal getTaxRate() {
		TaxCategoryType taxCategory = item.getClassifiedTaxCategory().get(0); // wg. 1..1
		PercentType percent = taxCategory.getPercent();
		return percent==null ? null : percent.getValue();
	}
	/**
	 * non public - use ctor
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
	
	/*
	 * BG-31 1..1 ITEM INFORMATION
	 */
	
	/* BG-31.BT-153 1..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getItemName()
	 */
 	@Override
	public String getItemName() {
		ItemType item = super.getItem();
		return item.getName()==null ? null : item.getName().getValue();
	}
 	/**
 	 * non public - use ctor
 	 * 
 	 * @param itemName
 	 */
	void setItemName(String itemName) {
		NameType name = new NameType();
		name.setValue(itemName);
		ItemType item = super.getItem();
		item.setName(name);
	}

	/* BG-31.BT-154 0..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getDescription()
	 */
	@Override
	public String getDescription() {
		if(item.getDescription().isEmpty()) return null;
		return item.getDescription().get(0).getValue(); // get(0) wg ..1
	}
	@Override
	public void setDescription(String text) {
		addItemDescription(text);	
	}
	void addItemDescription(String text) {
		if(text==null) return;
		DescriptionType description = new DescriptionType();
		description.setValue(text);
		item.getDescription().add(description);
		super.setItem(item);
	}

	public List<String> getItemDescriptions() { // public wg. test
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
	
	/* BG-31.BT-155 0..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getSellerAssignedID()
	 */
 	@Override
	public String getSellerAssignedID() {
		ItemIdentificationType itemIdentification = item.getSellersItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : itemIdentification.getID().getValue();
	}
 	@Override
	public void setSellerAssignedID(String id) {
 		if(id==null) return;
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(Invoice.newIDType(id, null));
		item.setSellersItemIdentification(itemIdentification);
		super.setItem(item);
	}
	
 	/* BG-31.BT-156 0..1
 	 * (non-Javadoc)
 	 * @see com.klst.einvoice.CoreInvoiceLine#getBuyerAssignedID()
 	 */
	@Override
	public String getBuyerAssignedID() {
		ItemIdentificationType itemIdentification = item.getBuyersItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : itemIdentification.getID().getValue();
	}
	@Override
	public void setBuyerAssignedID(String id) {
 		if(id==null) return;
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(Invoice.newIDType(id, null));
		item.setBuyersItemIdentification(itemIdentification);
		super.setItem(item);
	}

	/* BG-31.BT-157 0..1 (optional) , BT-157-1 required
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#setStandardID(java.lang.String, java.lang.String)
	 */
	@Override
	public void setStandardID(String id, String schemeID) {
 		if(id==null) return;
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(Invoice.newIDType(id, schemeID));
		item.setBuyersItemIdentification(itemIdentification);
		super.setItem(item);
	}
	@Override
	public String getStandardID() { // ohne schemeID! TODO
		ItemIdentificationType itemIdentification = item.getStandardItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : itemIdentification.getID().getValue();
	}

	/* BG-31.BT-158 0..n (optional) , BT-158-1 1..1 , BT-158-2 0..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#addClassificationID(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void addClassificationID(String id, String schemeID, String schemeVersion) {
		if(id==null) return;
		ItemClassificationCodeType itemClassificationCode = new ItemClassificationCodeType();
		itemClassificationCode.setValue(id);
		itemClassificationCode.setListID(schemeID);
		itemClassificationCode.setListVersionID(schemeVersion);
		CommodityClassificationType commodityClassification = new CommodityClassificationType();
		commodityClassification.setItemClassificationCode(itemClassificationCode);
		item.getCommodityClassification().add(commodityClassification);
		super.setItem(item);
	}

	@Override
	public List<Object> getClassificationList() {
		List<CommodityClassificationType> commodityClassificationList = item.getCommodityClassification();
		List<Object> resList = new ArrayList<Object>(commodityClassificationList.size());
		commodityClassificationList.forEach(productClassification -> {
			resList.add(productClassification);
		});
		return resList;
	}

}
