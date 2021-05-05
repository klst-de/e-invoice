package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.klst.edoc.api.IAmount;
import com.klst.edoc.api.IPeriod;
import com.klst.edoc.api.IQuantity;
import com.klst.edoc.api.Identifier;
import com.klst.edoc.untdid.DateTimeFormats;
import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.edoc.untdid.TaxCategoryCode;
import com.klst.edoc.untdid.TaxTypeCode;
import com.klst.einvoice.api.AllowancesAndCharges;
import com.klst.einvoice.api.CoreInvoice;
import com.klst.einvoice.api.CoreInvoiceLine;
import com.klst.einvoice.api.GlobalIdentifier;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CommodityClassificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemPropertyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ItemClassificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.QuantityType;

public class GenericLine<T> implements CoreInvoiceLine {

	@Override
	public CoreInvoiceLine createInvoiceLine(String id, IQuantity quantity, IAmount lineTotalAmount,
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent) {
		return create(this.invoice, id, (Quantity)quantity, (Amount)lineTotalAmount, priceAmount, itemName, codeEnum, percent);
	}
	
	private static final Logger LOG = Logger.getLogger(GenericLine.class.getName());
	
	private CoreInvoice invoice; // Invoice or CreditNote this line belongs to
	T t;
	boolean isInvoiceLineType = false;
	InvoiceLineType iLine = null;
	CreditNoteLineType cnLine = null;
	
	// factory
	static CoreInvoiceLine create(CoreInvoice invoice, String id, Quantity quantity, Amount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent) {
		if(invoice.getTypeCode()==DocumentNameCode.CreditNote) {
			CreditNoteLineType cnl = new CreditNoteLineType();
			GenericLine<CreditNoteLineType> gl = new GenericLine<CreditNoteLineType>(cnl);
			gl.init(invoice, id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent);
			return gl;
		} else {
			InvoiceLineType il = new InvoiceLineType();
			GenericLine<InvoiceLineType> gl = new GenericLine<InvoiceLineType>(il);
			gl.init(invoice, id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent);
			return gl;
		}
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
		if(getId()!=null) LOG.config("copy ctor "+this);
	}
	
	T get() {
		return this.t;
	}

	private void init(CoreInvoice invoice, String id, Quantity quantity, Amount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal taxRate) {
		this.invoice = invoice;
		ItemType item = new ItemType();
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
		setTaxCategoryAndRate(codeEnum, taxRate);
		LOG.config("ctor "+this);
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
		if(isInvoiceLineType) {
			iLine.setID(new ID(id)); // No identification scheme 
		} else {
			cnLine.setID(new ID(id)); 
		}
	}

	@Override
	public String getId() {
		IDType id = isInvoiceLineType ? iLine.getID() : cnLine.getID();
		return id==null ? null : id.getValue();
	}

	// BG-25.BT-127 0..1 Invoice line note
	@Override
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

	@Override
	public String getNote() {
		List<NoteType> noteList = isInvoiceLineType ? iLine.getNote() : cnLine.getNote();
		return noteList.isEmpty() ? null : noteList.get(0).getValue(); // wg. 0..1
	}

	// BG-25.BT-128 0..1 Invoice line object identifier
	@Override
	public void setLineObjectID(String id, String typeCode, String schemeCode) {
 		if(id==null) return;
 		DocumentReference docRef = DocumentReference.create(id, schemeCode, typeCode);
		
		if(isInvoiceLineType) {
			iLine.getDocumentReference().add(docRef);
		} else {
			cnLine.getDocumentReference().add(docRef);
		}	
	}

	public void setLineObjectID(String id, String schemeID) {
		setLineObjectID(id, schemeID, null);
	}
	@Override
	public void setLineObjectID(String id) {
		setLineObjectID(id, null, null);
	}

	@Override
	public void setLineObjectIdentifier(GlobalIdentifier id) {
		if(id==null) return;
		setLineObjectID(id.getContent(), id.getSchemeIdentifier(), id.getSchemeVersion());
	}

	@Override
	public GlobalIdentifier getLineObjectIdentifier() {
		List<DocumentReferenceType> documentReference = isInvoiceLineType ? iLine.getDocumentReference() : cnLine.getDocumentReference();
		return documentReference.isEmpty() ? null : new ID(documentReference.get(0).getID()); // get(0) wg. 0..1
	}

	// BG-25.BT-129 1..1 Invoiced quantity
	// BG-25.BT-130 1..1 Invoiced quantity unit of measure code
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
	public IQuantity getQuantity() {
		QuantityType quantity = (QuantityType)(isInvoiceLineType ? iLine.getInvoicedQuantity() : cnLine.getCreditedQuantity());	
		return new Quantity(quantity.getUnitCode(), quantity.getValue());
	}

	// BG-25.BT-131 1..1 Invoice line net amount
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

	/* BG-25.BT-132 0..1 Referenced purchase order line reference

Bsp. UBL 01.01a :
        <cac:OrderLineReference>
            <cbc:LineID>6171175.1</cbc:LineID>
        </cac:OrderLineReference>

	 */
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

	// BG-25.BT-133 0..1 Invoice line Buyer accounting reference
	@Override
	public void setBuyerAccountingReference(String text) {
		if(text==null) return;
		AccountingCostType accountingCost = new AccountingCostType();
		accountingCost.setValue(text);
		if(isInvoiceLineType) {
			iLine.setAccountingCost(accountingCost);
		} else {
			cnLine.setAccountingCost(accountingCost);
		}	
	}
	@Override
	public String getBuyerAccountingReference() {
		AccountingCostType accountingCost = isInvoiceLineType ? iLine.getAccountingCost() : cnLine.getAccountingCost();
		return accountingCost==null ? null : accountingCost.getValue();
	}

	// BG-26 0..1 INVOICE LINE PERIOD
//	@Override // comment to show the java-doc
	/**
	 * factory method to create BG-26 INVOICE LINE PERIOD 
	 * 
	 * @param start - The date is the first day of the period.
	 * @param end - The date is the last day of the period.
	 * @return IPeriod - aka delivery period
	 * 
	 * @see com.klst.einvoice.api.BG26_InvoiceLinePeriod
	 * @see com.klst.edoc.api.IPeriod
	 */
	public IPeriod createPeriod(Timestamp start, Timestamp end) {
		return Period.create(start, end);
	}
	List<PeriodType> periodList = null;
	PeriodType getPeriod0() {
		if(periodList==null) {
			periodList = isInvoiceLineType ? iLine.getInvoicePeriod() : cnLine.getInvoicePeriod();
			if(periodList.isEmpty()) {
				LOG.fine("BG-26 0..1 INVOICE LINE PERIOD isEmpty");
				PeriodType period = new PeriodType();
				periodList.add(period);
			}
		} 
		return periodList.get(0);
	}
	@Override
	public IPeriod getLineDeliveryPeriod() {
		return Period.create(getPeriod0());
	}
	@Override
	public void setLineDeliveryPeriod(IPeriod period) {
		setStartDate(period.getStartDateAsTimestamp());
		setEndDate(period.getEndDateAsTimestamp());
	}
	// BG-26.BT-134 0..1 Invoice line period start date / Das Datum, an dem der Rechnungszeitraum der betreffenden Rechnungsposition beginnt.
	private void setStartDate(Timestamp ts) {
		if(ts==null) return; // optional
		StartDateType date = new StartDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		PeriodType period = getPeriod0();
		period.setStartDate(date);
	}
	
	// BG-26.BT-135 0..1 Invoice line period end date
	private void setEndDate(Timestamp ts) {
		if(ts==null) return; // optional
		EndDateType date = new EndDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		PeriodType period = getPeriod0();
		period.setEndDate(date);
	}

	/*
	 * BG-27 0..n INVOICE LINE ALLOWANCES
	 * BG-28 0..n INVOICE LINE CHARGES
	 */
	@Override
	public AllowancesAndCharges createAllowance(IAmount amount, IAmount baseAmount, BigDecimal percentage) {
		return AllowanceCharge.create(AllowancesAndCharges.ALLOWANCE, amount, baseAmount, percentage);
	}
	@Override
	public AllowancesAndCharges createCharge(IAmount amount, IAmount baseAmount, BigDecimal percentage) {
		return AllowanceCharge.create(AllowancesAndCharges.CHARGE, amount, baseAmount, percentage);
	}
	@Override
	public void addAllowanceCharge(AllowancesAndCharges allowanceOrCharge) {
		if(allowanceOrCharge==null) return; // optional
		if(isInvoiceLineType) {
			iLine.getAllowanceCharge().add((AllowanceChargeType)allowanceOrCharge);
		} else {
			cnLine.getAllowanceCharge().add((AllowanceChargeType)allowanceOrCharge);
		}
	}

	@Override
	public List<AllowancesAndCharges> getAllowancesAndCharges() {
		List<AllowanceChargeType> allowanceChargeList = isInvoiceLineType ? iLine.getAllowanceCharge() : cnLine.getAllowanceCharge();
		List<AllowancesAndCharges> resList = new ArrayList<AllowancesAndCharges>(allowanceChargeList.size());
		allowanceChargeList.forEach(doc -> {
			resList.add(AllowanceCharge.create(doc));
		});
		return resList;
	}

	// BG-29        1..1 PRICE DETAILS
	// BG-29.BT-146 1..1 Item net price
	@Override
	public UnitPriceAmount getUnitPriceAmount() {
		Price price = Price.create( isInvoiceLineType ? iLine.getPrice() : cnLine.getPrice());
		return price.getUnitPriceAmount();
	}
	
	// BG-29.BT-147 0..1 Item price discount
	@Override
	public UnitPriceAmount getPriceDiscount() {
		Price price = Price.create( isInvoiceLineType ? iLine.getPrice() : cnLine.getPrice());
		IAmount amount = price.getPriceDiscount();
		return amount==null ? null : new UnitPriceAmount(amount.getCurrencyID(), amount.getValue());		
	}
	
	// BG-29.BT-148 +++ 0..1 Item gross price
	@Override
	public UnitPriceAmount getGrossPrice() {
		Price price = Price.create( isInvoiceLineType ? iLine.getPrice() : cnLine.getPrice());
		IAmount amount = price.getGrossPrice();
		return amount==null ? null : new UnitPriceAmount(amount.getCurrencyID(), amount.getValue());		
	}
	
	// optional UnitPriceQuantity : BT-149-0 QuantityUnit 0..1 + BT-150-0 Quantity required
	@Override
	public Quantity getUnitPriceQuantity() {
		Price price = Price.create( isInvoiceLineType ? iLine.getPrice() : cnLine.getPrice());
		return price.getUnitPriceQuantity();
	}

	private void setPrice(Price price) {
		if(isInvoiceLineType) {
			iLine.setPrice(price);
		} else {
			cnLine.setPrice(price);
		}		
	}
	
	// BG-29.BT-146 1..1 UnitPriceAmount
	private void setUnitPriceAmount(UnitPriceAmount unitPriceAmount) {
		Price price = Price.create( isInvoiceLineType ? iLine.getPrice() : cnLine.getPrice());
		price.setUnitPriceAmount(unitPriceAmount);
		setPrice(price);
	}

	private void setUnitPriceQuantity(Quantity quantity) {
		if(quantity!=null) {
			Price price = Price.create( isInvoiceLineType ? iLine.getPrice() : cnLine.getPrice() );
			price.setUnitPriceQuantity(quantity);
			setPrice(price);
		}
	}
	
	@Override
	public void setUnitPriceAmountAndQuantity(UnitPriceAmount unitPriceAmount, Quantity quantity) {
		setUnitPriceAmount(unitPriceAmount);
		setUnitPriceQuantity(quantity);
	}

	@Override
	public void setUnitPriceAllowance(UnitPriceAmount priceDiscount, UnitPriceAmount grossPrice) {
		if(priceDiscount==null && grossPrice==null) return;
//		setPriceDiscount(priceDiscount);
//		setGrossPrice(grossPrice);
		Price price = Price.create( isInvoiceLineType ? iLine.getPrice() : cnLine.getPrice() );
		price.setPriceDiscount(priceDiscount, grossPrice);
		setPrice(price);
	}

	// BG-30 1..1 LINE VAT INFORMATION
	// BG-30.BT-151 1..1 Invoiced item VAT category code
	// BG-30.BT-152 0..1 Invoiced item VAT rate
	/**
	 * not public - use factory
	 * 
	 * @param codeEnum 1..1 EN16931-ID: BT-151
	 * @param percent 0..1 EN16931-ID: BT-152
	 */
	void setTaxCategoryAndRate(TaxCategoryCode taxCode, BigDecimal taxRate) {
		TaxCategory taxCategory = TaxCategory.create(TaxTypeCode.ValueAddedTax, taxCode, taxRate);
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
		return TaxCategory.create(taxCategory).getTaxCategoryCode();
//		if(taxCategory==null) return null;
//		return taxCategory.getID()==null ? null : TaxCategoryCode.getEnum(taxCategory.getID().getValue()); // S
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
		itemIdentification.setID(new ID(id));
		
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
		itemIdentification.setID(new ID(id));
		
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

	// BG-31.BT-157 0..1 Item standard identifier
	@Override
	public void setStandardIdentifier(Identifier id) {
 		if(id==null) return;
 		setStandardID(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void setStandardID(String id, String schemeID) {
 		if(id==null) return;
		ItemIdentificationType itemIdentification = new ItemIdentificationType();
		itemIdentification.setID(new ID(id, schemeID));
		
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
	public GlobalIdentifier getStandardIdentifier() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		ItemIdentificationType itemIdentification = item.getStandardItemIdentification();
		if(itemIdentification==null) return null;
		return itemIdentification.getID()==null ? null : new ID(itemIdentification.getID().getValue(), itemIdentification.getID().getSchemeID());
	}
	
	// BG-31.BT-158 +++ 0..n Item classification identifier
	@Override
	public void addClassificationID(GlobalIdentifier id) {
		addClassificationID(id.getContent(), id.getSchemeIdentifier(), id.getSchemeVersion());
	}
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

/*
      <cac:CommodityClassification>
        <cbc:ItemClassificationCode listID="IB">0721-880X</cbc:ItemClassificationCode>
      </cac:CommodityClassification>
 */
	// BT-158 +++ 0..n Item classification identifier
	// BT-158-1   1..1 Scheme identifier
	// BT-158-2   0..1 Scheme version identifier
	@Override
	public List<GlobalIdentifier> getClassifications() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		List<CommodityClassificationType> commodityClassifications = item.getCommodityClassification();
		List<GlobalIdentifier> result = new ArrayList<GlobalIdentifier>(commodityClassifications.size());
		commodityClassifications.forEach(cc -> {
			if(cc.getItemClassificationCode()!=null) {
				GlobalIdentifier id = new ID(cc.getItemClassificationCode().getValue(), cc.getItemClassificationCode().getListID()
						, cc.getItemClassificationCode().getListVersionID());
				result.add(id);
			}
		});
		return result;
	}

	// BG-31.BT-159 +++ 0..1 Item country of origin
	@Override
	public void setCountryOfOrigin(String code) {
 		if(code==null) return;
 		IdentificationCodeType identificationCode = new IdentificationCodeType();
 		identificationCode.setValue(code);
 		CountryType country = new CountryType();
 		country.setIdentificationCode(identificationCode);
		
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			item.setOriginCountry(country);
			iLine.setItem(item);
		} else {
			ItemType item = cnLine.getItem();
			item.setOriginCountry(country);
			cnLine.setItem(item);
		}	
	}

	@Override
	public String getCountryOfOrigin() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		CountryType country = item.getOriginCountry();
		if(country==null) return null;
		IdentificationCodeType identificationCode = country.getIdentificationCode();
		return identificationCode==null ? null : identificationCode.getValue();
	}

	// BG-32.BT-160 + BT-161 0..n
	@Override
	public void addItemAttribute(String name, String value) {
		if(name==null) return; // darf nicht sein, denn BT-160 + BT-161 sind mandatory TODO exception

		NameType nameText = new NameType();
		nameText.setValue(name);
		ValueType valueText = new ValueType(); //class ValueType extends TextType extends un.unece.uncefact...TextType
		valueText.setValue(value);
		
		ItemPropertyType itemProperty = new ItemPropertyType();
		itemProperty.setName(nameText);
		itemProperty.setValue(valueText);
		
		if(isInvoiceLineType) {
			ItemType item = iLine.getItem();
			item.getAdditionalItemProperty().add(itemProperty);
			iLine.setItem(item);
		} else {
			ItemType item = cnLine.getItem();
			item.getAdditionalItemProperty().add(itemProperty);
			cnLine.setItem(item);
		}	
	}
	@Override
	public Properties getItemAttributes() {
		ItemType item = isInvoiceLineType ? iLine.getItem() : cnLine.getItem();
		List<ItemPropertyType> itemProperties = item.getAdditionalItemProperty();
		Properties result = new Properties();
		itemProperties.forEach(ip -> {
			result.put(ip.getName().getValue(), ip.getValue().getValue());
		});
		return result;
	}

}
