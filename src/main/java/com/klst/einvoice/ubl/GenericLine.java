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
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ItemClassificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.QuantityType;

//ohne von T abzuleiten habe ich keinen Zugtiff auf die protected Member:
//protected IDType id;
//...
//protected ItemType item;
//protected PriceType price;
public class GenericLine<T> implements CoreInvoiceLine {

	private static final Logger LOG = Logger.getLogger(GenericLine.class.getName());
	
	private static final String NOT_IMPEMENTED = "NOT IMPEMENTED";
	
	T t;
	boolean isInvoiceLineType = false;
	InvoiceLineType iLine = null;
	CreditNoteLineType cnLine = null;
	
	// factory
	public static GenericLine<InvoiceLineType> createInvoiceLine(String id, Quantity quantity, Amount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent) {
		InvoiceLineType il = new InvoiceLineType();
		GenericLine<InvoiceLineType> gl = new GenericLine<InvoiceLineType>(il);
//		LOG.info("vor gl.init(id:"+id);
		gl.init(id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent);
		return gl;
	}
	
	public static GenericLine<CreditNoteLineType> createCreditNoteLine(String id, Quantity quantity, Amount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent) {
		CreditNoteLineType cnl = new CreditNoteLineType();
		GenericLine<CreditNoteLineType> gl = new GenericLine<CreditNoteLineType>(cnl);
//		LOG.info("vor gl.init(id:"+id);
		gl.init(id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent);
		return gl;
	}
	
	// ctor mit type parameter
	GenericLine(T t) {
		this.t = t;
		isInvoiceLineType = this.t instanceof InvoiceLineType;
		if(isInvoiceLineType) {
			iLine = (InvoiceLineType)t;
		} else {
			cnLine = (CreditNoteLineType)t;
		}
//		LOG.info("copy ctor isInvoiceLineType:"+isInvoiceLineType);
		if(getId()!=null) LOG.info("copy ctor "+this);
	}
	
	T get() {
		return this.t;
	}

	void init(String id, Quantity quantity, Amount lineTotalAmount, UnitPriceAmount priceAmount, String itemName
			, TaxCategoryCode codeEnum, BigDecimal percent) {
		ItemType item = new ItemType();
//		PriceType price = new PriceType();
		if(isInvoiceLineType) {
			iLine.setItem(item);
		} else {
			cnLine.setItem(item);
		}
		
		setId(id);
		setQuantity(quantity);
		setLineTotalAmount(lineTotalAmount);
		setUnitPriceAmount(priceAmount);
		setItemName(itemName);
		setTaxCategoryAndRate(codeEnum, percent==null ? null : new Percent(percent));
		LOG.info("ctor "+this);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append("ID:"+getId());
		stringBuilder.append(", Quantity:"+getQuantity());
		stringBuilder.append(", LineTotalAmount:"+getLineTotalAmount());
		stringBuilder.append(", ItemName:"+getItemName());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	// BT-126 ++ 1..1 Invoice line identifier
	void setId(String id) {
//		LOG.info("isInvoiceLineType:"+isInvoiceLineType + " id:"+id);
		if(isInvoiceLineType) {
			iLine.setID(Invoice.newIDType(id, null)); // null : No identification scheme 
		} else {
			cnLine.setID(Invoice.newIDType(id, null)); // null : No identification scheme 
		}
	}

	@Override
	public String getId() {
		IDType id = isInvoiceLineType ? iLine.getID() : cnLine.getID();
		return id==null ? null : id.getValue();
	}

	// BT-127 ++ 0..1 Invoice line note
	@Override // TODO umbenennen in setNote
	public void setNote(String text) {
		if(text==null) return;
		NoteType note = new NoteType();
		note.setValue(text);
		if(isInvoiceLineType) {
			iLine.getNote().add(note);
		} else {
			cnLine.getNote().add(note);
		}	
	}

	@Override // TODO umbenennen in getNote
	public String getNote() {
		List<NoteType> noteList = isInvoiceLineType ? iLine.getNote() : cnLine.getNote();
		return noteList.isEmpty() ? null : noteList.get(0).getValue(); // wg. 0..1
	}

	/* BT-128 ++ 0..1 Invoice line object identifier
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

	// BT-129 ++ 1..1 Invoiced quantity
	// BT-130 ++ 1..1 Invoiced quantity unit of measure code
 	/**
 	 * non public - use ctor
 	 * 
 	 * @param quantity
 	 */
	void setQuantity(Quantity quantity) {
		QuantityType qty = isInvoiceLineType ? new InvoicedQuantityType() : new CreditedQuantityType();
		qty.setUnitCode(quantity.getUnitCode());
		qty.setValue(quantity.getValue());
		if(isInvoiceLineType) {
			iLine.setInvoicedQuantity((InvoicedQuantityType)qty);
		} else {
			cnLine.setCreditedQuantity((CreditedQuantityType)qty);
		}	
	}
	@Override
	public Quantity getQuantity() {
		QuantityType quantity = (QuantityType)(isInvoiceLineType ? iLine.getInvoicedQuantity() : cnLine.getCreditedQuantity());	
		return new Quantity(quantity.getUnitCode(), quantity.getValue());
	}

	// BT-131 ++ 1..1 Invoice line net amount
 	/**
 	 * non public - use ctor
 	 * 
 	 * @param amount
 	 */
	void setLineTotalAmount(Amount amount) {
		LineExtensionAmountType lineExtensionAmount = new LineExtensionAmountType();
		amount.copyTo(lineExtensionAmount);
		if(isInvoiceLineType) {
			iLine.setLineExtensionAmount(lineExtensionAmount);
		} else {
			cnLine.setLineExtensionAmount(lineExtensionAmount);
		}	
	}

	@Override
	public Amount getLineTotalAmount() {
		LineExtensionAmountType amount = isInvoiceLineType ? iLine.getLineExtensionAmount() : cnLine.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}

	// BT-132 ++ 0..1 Referenced purchase order line reference
	@Override
	public void setOrderLineID(String lineReference) {
		if(lineReference==null) return;
		LineIDType lineID = new LineIDType();
		lineID.setValue(lineReference);
		OrderLineReferenceType orderLineReference = new OrderLineReferenceType();
		orderLineReference.setLineID(lineID);
		if(isInvoiceLineType) {
			iLine.getOrderLineReference().add(orderLineReference);
		} else {
			cnLine.getOrderLineReference().add(orderLineReference);
		}	
	}

	@Override
	public String getOrderLineID() {
		List<OrderLineReferenceType> list = isInvoiceLineType ? iLine.getOrderLineReference() : cnLine.getOrderLineReference();
		return list.isEmpty() ? null : list.get(0).getLineID().getValue(); // wg. 0..1
	}

	// BT-133 ++ 0..1 Invoice line Buyer accounting reference
// TODO	@Override
	public void setBuyerAccounting(String text) {
		if(text==null) return;
		AccountingCostType accountingCost = new AccountingCostType();
		accountingCost.setValue(text);
		if(isInvoiceLineType) {
			iLine.setAccountingCost(accountingCost);
		} else {
			cnLine.setAccountingCost(accountingCost);
		}	
	}
// TODO	@Override
	public String getBuyerAccounting() {
		AccountingCostType accountingCost = isInvoiceLineType ? iLine.getAccountingCost() : cnLine.getAccountingCost();
		return accountingCost==null ? null : accountingCost.getValue();
	}

	// BG-26 ++ 0..1 INVOICE LINE PERIOD      TODO
	// BG-27 ++ 0..n INVOICE LINE ALLOWANCES  TODO
	
	/*
	 * BG-27 0..n INVOICE LINE ALLOWANCES
	 * TODO Komplett
	 */
	
	/* 
	 * BG-28 ++ 0..n INVOICE LINE CHARGES
	 * TODO Komplett
	 */
	
	// BG-29 ++ 1..1 PRICE DETAILS
	// BG-29.BT-146 +++ 1..1 Item net price
	@Override
	public UnitPriceAmount getUnitPriceAmount() {
		PriceAmountType priceAmount = isInvoiceLineType ? iLine.getPrice().getPriceAmount() : cnLine.getPrice().getPriceAmount();
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
		
		if(isInvoiceLineType) {
			iLine.setPrice(price);
		} else {
			cnLine.setPrice(price);
		}	
	}

	// BT-147 +++ 0..1 Item price discount          TODO
	// BT-148 +++ 0..1 Item gross price             TODO
	
	/* BT-149-0 0..1 , BT-150-0 required
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getBaseQuantity()
	 */
	@Override
	public Quantity getBaseQuantity() {
		BaseQuantityType baseQuantity = isInvoiceLineType ? iLine.getPrice().getBaseQuantity() : cnLine.getPrice().getBaseQuantity();
		String unit = baseQuantity.getUnitCode();
		return baseQuantity==null ? null : (unit==null ? new Quantity(baseQuantity.getValue()) : new Quantity(unit, baseQuantity.getValue()));
	}
	
	// BG-30 ++ 1..1 LINE VAT INFORMATION
	// BG-30.BT-151 +++ 1..1 Invoiced item VAT category code
	// BG-30.BT-152 +++ 0..1 Invoiced item VAT rate
	/**
	 * non public - use ctor
	 * 
	 * @param codeEnum 1..1 EN16931-ID: BT-151
	 * @param percent 0..1 EN16931-ID: BT-152
	 */
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, Percent percent) {
		VatCategory taxCategory = new VatCategory(codeEnum, percent);
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			item.getClassifiedTaxCategory().add(taxCategory);
			iLine.setItem(item);
		} else {
			ItemType item = cnLine.getItem();
			item.getClassifiedTaxCategory().add(taxCategory);
			cnLine.setItem(item);
		}	
	}
	void setTaxCategoryAndRate(TaxCategoryCode codeEnum, BigDecimal percent) {
		setTaxCategoryAndRate(codeEnum, percent==null ? null : new Percent(percent));
	}
	
	@Override
	public TaxCategoryCode getTaxCategory() {
		TaxCategoryType taxCategory = null;
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			taxCategory = item.getClassifiedTaxCategory().get(0); // wg. 1..1
		} else {
			ItemType item = cnLine.getItem();
			taxCategory = item.getClassifiedTaxCategory().get(0); // wg. 1..1
		}	
		return TaxCategoryCode.valueOf(taxCategory); // S
	}


	@Override
	public BigDecimal getTaxRate() {
		TaxCategoryType taxCategory = null;
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			taxCategory = item.getClassifiedTaxCategory().get(0); // wg. 1..1
		} else {
			ItemType item = cnLine.getItem();
			taxCategory = item.getClassifiedTaxCategory().get(0); // wg. 1..1
		}	
		PercentType percent = taxCategory.getPercent();
		return percent==null ? null : percent.getValue();
	}

	/*
	 * BG-31 1..1 ITEM INFORMATION
	 */
	
	/* BG-31.BT-153 1..1
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CoreInvoiceLine#getItemName()
	 */
 	/**
 	 * non public - use ctor
 	 * 
 	 * @param itemName
 	 */
	void setItemName(String itemName) {
		NameType name = new NameType();
		name.setValue(itemName);
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		item.setName(name);
	}

	@Override
	public String getItemName() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		return item.getName()==null ? null : item.getName().getValue();
	}

	// BG-31.BT-154 +++ 0..1 Item description
	@Override
	public void setDescription(String text) {
		if(text==null) return;
		DescriptionType description = new DescriptionType();
		description.setValue(text);
		
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			item.getDescription().add(description);
			iLine.setItem(item);
		} else {
			ItemType item = cnLine.getItem();
			item.getDescription().add(description);
			cnLine.setItem(item);
		}	
	}

	@Override
	public String getDescription() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		if(item.getDescription().isEmpty()) return null;
		return item.getDescription().get(0).getValue(); // get(0) wg ..1
	}

	// BG-31.BT-155 +++ 0..1 Item Seller's identifier
	@Override
	public void setSellerAssignedID(String id) {
 		if(id==null) return;
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(Invoice.newIDType(id, null));
		
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			item.setSellersItemIdentification(itemIdentification);
			iLine.setItem(item);
		} else {
			ItemType item = cnLine.getItem();
			item.setSellersItemIdentification(itemIdentification);
			cnLine.setItem(item);
		}	
	}

	@Override
	public String getSellerAssignedID() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		ItemIdentificationType itemIdentification = item.getSellersItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : itemIdentification.getID().getValue();
	}

	// BG-31.BT-156 +++ 0..1 Item Buyer's identifier
	@Override
	public void setBuyerAssignedID(String id) {
 		if(id==null) return;
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(Invoice.newIDType(id, null));
		
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			item.setBuyersItemIdentification(itemIdentification);
			iLine.setItem(item);
		} else {
			ItemType item = cnLine.getItem();
			item.setBuyersItemIdentification(itemIdentification);
			cnLine.setItem(item);
		}	
	}

	@Override
	public String getBuyerAssignedID() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		ItemIdentificationType itemIdentification = item.getBuyersItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : itemIdentification.getID().getValue();
	}

	// BG-31.BT-157 +++ 0..1 Item standard identifier
	@Override
	public void setStandardID(String id, String schemeID) {
 		if(id==null) return;
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(Invoice.newIDType(id, schemeID));
		
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			item.setStandardItemIdentification(itemIdentification);
			iLine.setItem(item);
		} else {
			ItemType item = cnLine.getItem();
			item.setStandardItemIdentification(itemIdentification);
			cnLine.setItem(item);
		}	
	}

	@Override
	public String getStandardID() {  // ohne schemeID! TODO
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		ItemIdentificationType itemIdentification = item.getStandardItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : itemIdentification.getID().getValue();
	}
	
	// BG-31.BT-158 +++ 0..n Item classification identifier
	@Override
	public void addClassificationID(String id, String schemeID, String schemeVersion) {
		if(id==null) return;
		ItemClassificationCodeType itemClassificationCode = new ItemClassificationCodeType();
		itemClassificationCode.setValue(id);
		itemClassificationCode.setListID(schemeID);
		itemClassificationCode.setListVersionID(schemeVersion);
		CommodityClassificationType commodityClassification = new CommodityClassificationType();
		commodityClassification.setItemClassificationCode(itemClassificationCode);
		
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			item.getCommodityClassification().add(commodityClassification);
			iLine.setItem(item);
		} else {
			ItemType item = cnLine.getItem();
			item.getCommodityClassification().add(commodityClassification);
			cnLine.setItem(item);
		}	
	}

	@Override
	public List<Object> getClassificationList() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		List<CommodityClassificationType> commodityClassificationList = item.getCommodityClassification();
		List<Object> resList = new ArrayList<Object>(commodityClassificationList.size());
		commodityClassificationList.forEach(productClassification -> {
			resList.add(productClassification);
		});
		return resList;
	}

}
