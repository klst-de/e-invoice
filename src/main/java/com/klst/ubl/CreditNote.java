package com.klst.ubl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.klst.cius.CoreInvoice;
import com.klst.cius.DocumentTotals;
import com.klst.un.unece.uncefact.Amount;
import com.klst.un.unece.uncefact.IBANId;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuyerReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditNoteTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxInclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxPointDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;

public class CreditNote extends CreditNoteType implements CoreInvoice, DocumentTotals {

	private static final Logger LOG = Logger.getLogger(CreditNote.class.getName());
	
	private static final String NOT_IMPEMENTED = "NOT IMPEMENTED";
	
	CreditNote() {
		super();
	}
	
	public CreditNote(String customization, String profile, DocumentNameCode code) {
		this();
		setProcessControl(customization, profile);
		setTypeCode(code); // BT-3		
	}

	// cache:
	Party sellerParty;
	Party buyerParty;
	
	// copy-ctor
	public CreditNote(CreditNoteType doc) {
		this(getCustomizationID(doc), getProfileID(doc), getTypeCode(doc));
		setId(getId(doc));
		setIssueDate(getIssueDateAsTimestamp(doc));
		setDocumentCurrency(getDocumentCurrency(doc));
		setTaxCurrency(getTaxCurrency(doc)); // optional
		setTaxPointDate(getTaxPointDateAsTimestamp(doc)); // optional
		setPaymentTermsAndDate(getPaymentTerm(doc), (Timestamp)null); // optional, DueDateAsTimestamp==null
		setBuyerReference(getBuyerReferenceValue(doc)); // optional
		setOrderReferenceID(getOrderReferenceID(doc)); // optional
//		addPaymentTerms(doc);
		addNotes(doc);
		setSellerParty(getSellerParty(doc));
		setBuyerParty(getBuyerParty(doc));
		addDeliveries(doc);
		addPaymentInstructions(doc);
		setDocumentTotals(doc);
		setInvoiceTax(getInvoiceTax(doc));
		addVATBreakDown(doc);
		addLines(doc);
	}
	
	// wie BT-1  Identifier
	public void setId(String id) {
		this.setID(Invoice.newIDType(id, null)); // null : No identification scheme is to be used.
	}
	public String getId() {
		return getId(this);
	}
	static String getId(CreditNoteType doc) {
		return doc.getID().getValue();
	}

	// wie BT-2  Date
	public void setIssueDate(String ymd) {	
		setIssueDate(DateTimeFormats.ymdToTs(ymd));
	}
	public void setIssueDate(Timestamp ts) {
		IssueDateType issueDate = new IssueDateType();
		issueDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		super.setIssueDate(issueDate);
	}
	public Timestamp getIssueDateAsTimestamp() {  // bei gleichen Namen getIssueDate() kann es nicht abgeleitet sein
		return getIssueDateAsTimestamp(this);
	}
	static Timestamp getIssueDateAsTimestamp(CreditNoteType doc) {
		IssueDateType issueDate = doc.getIssueDate();
		return DateTimeFormats.xmlGregorianCalendarToTs(issueDate.getValue());
	}
	
	// wie BT-3  Code
	public void setTypeCode(DocumentNameCode code) {
		CreditNoteTypeCodeType typeCode = new CreditNoteTypeCodeType();
		typeCode.setValue(code.getValueAsString());
		super.setCreditNoteTypeCode(typeCode);
	}
	public DocumentNameCode getTypeCode() {
		return getTypeCode(this);
	}
	static DocumentNameCode getTypeCode(CreditNoteType doc) {
		return DocumentNameCode.valueOf(doc.getCreditNoteTypeCode());
	}
	
	// wie BT-5  Code
	public void setDocumentCurrency(String isoCurrencyCode) {
		DocumentCurrencyCodeType documentCurrencyCode = new DocumentCurrencyCodeType();
		documentCurrencyCode.setValue(isoCurrencyCode);
		this.setDocumentCurrencyCode(documentCurrencyCode);
	}
	public String getDocumentCurrency() {
		return getDocumentCurrency(this);
	}
	static String getDocumentCurrency(CreditNoteType doc) {
		DocumentCurrencyCodeType code = doc.getDocumentCurrencyCode();
		return code==null ? null : code.getValue();
	}

	// wie BT-6  Code
	public void setTaxCurrency(String isoCurrencyCode) {
		if(isoCurrencyCode==null) return;
		PaymentCurrencyCodeType paymentCurrencyCode = new PaymentCurrencyCodeType();
		paymentCurrencyCode.setValue(isoCurrencyCode); 
		this.setPaymentCurrencyCode(paymentCurrencyCode);
	}
	public String getTaxCurrency() {
		return getTaxCurrency(this);
	}
	static String getTaxCurrency(CreditNoteType doc) {
		PaymentCurrencyCodeType code = doc.getPaymentCurrencyCode();
		return code==null ? null : code.getValue();
	}

	// wie BT-7  Date / Anwendung: In Deutschland wird dieses nicht verwendet.
	public void setTaxPointDate(String ymd) {	
		setTaxPointDate(DateTimeFormats.ymdToTs(ymd));
	}
	public void setTaxPointDate(Timestamp ts) {
		if(ts==null) return; // optional
		TaxPointDateType taxPointDate = new TaxPointDateType();
		taxPointDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		super.setTaxPointDate(taxPointDate);
	}
	public Timestamp getTaxPointDateAsTimestamp() {
		return getIssueDateAsTimestamp(this);
	}
	static Timestamp getTaxPointDateAsTimestamp(CreditNoteType doc) {
		TaxPointDateType taxPointDate = doc.getTaxPointDate();
		return taxPointDate==null ? null : DateTimeFormats.xmlGregorianCalendarToTs(taxPointDate.getValue());
	}

	// wie BT-9  Payment due date
//	public void setDueDate(String ymd) {
//		setDueDate(DateTimeFormats.ymdToTs(ymd));
//	}
	public void setDueDate(Timestamp ts) {
		if(ts==null) return; // optional
		return; // TODO not implemented
	}
	public Timestamp getDueDateAsTimestamp() {
		return null; // TODO not implemented
	}

	@Override // wie BT-9  Payment due date & BT-20 Payment terms
	public void setPaymentTermsAndDate(String description, String ymd) {
		setPaymentTermsAndDate(description, DateTimeFormats.ymdToTs(ymd));
	}

	@Override
	public void setPaymentTermsAndDate(String description, Timestamp ts) {
		addPaymentTerms(description); // BT-20 optional
		setDueDate(ts); // BT-9 optional
	}

	// wie BT-10  Text
	public void setBuyerReference(String reference) {
		if(reference==null) return; // optional
		BuyerReferenceType buyerReference = new BuyerReferenceType();
		buyerReference.setValue(reference);
		this.setBuyerReference(buyerReference);
	}
	public String getBuyerReferenceValue() {
		return getBuyerReferenceValue(this);
	}
	static String getBuyerReferenceValue(CreditNoteType doc) {
		return doc.getBuyerReference()==null ? null : doc.getBuyerReference().getValue();
	}

	// wie BT-14  Document reference
	public void setOrderReferenceID(String docRefId) {
		if(docRefId==null) return; // optional
		OrderReferenceType orderReference = new OrderReferenceType();
		orderReference.setID(Invoice.newIDType(docRefId, null)); // null : No identification scheme
		this.setOrderReference(orderReference);
	}
	public String getOrderReferenceID() {
		return getOrderReferenceID(this);
	}
	static String getOrderReferenceID(CreditNoteType doc) {
		OrderReferenceType orderRef = doc.getOrderReference();
		if(orderRef==null) return null;
		return orderRef.getID().getValue();
	}

	// wie BT-20  PaymentTerms
	@Override
	public String getPaymentTerm() {
		List<PaymentTerms> ptList = getPaymentTermList();
		if(ptList.isEmpty()) return null;
		return ptList.get(0).getFirstNote(); // da Cardinality 0..1
	}

	public String getPaymentTerm(CreditNoteType doc) {
		List<PaymentTerms> ptList = getPaymentTermList(this);
		if(ptList.isEmpty()) return null;
		return ptList.get(0).getFirstNote(); // da Cardinality 0..1
	}
	
	public List<PaymentTerms> getPaymentTermList() {
		return getPaymentTermList(this);
	}
	
	static List<PaymentTerms> getPaymentTermList(CreditNoteType doc) {
		List<PaymentTermsType> paymentTermsList = doc.getPaymentTerms();
		List<PaymentTerms> result = new ArrayList<PaymentTerms>(paymentTermsList.size());
		paymentTermsList.forEach(paymentTerms -> {
			result.add(new PaymentTerms(paymentTerms));
		});
		return result;
	}
	
	List<PaymentTermsType> addPaymentTerms(CreditNoteType doc) {
		List<PaymentTermsType> paymentTermsList = doc.getPaymentTerms();
		List<PaymentTermsType> result = this.getPaymentTerms();
		paymentTermsList.forEach(paymentTerms -> {
			result.add(new PaymentTerms(paymentTerms));
		});
		return result;
	}
	
	public List<PaymentTermsType> addPaymentTerms(String paymentTermsNote) {
		PaymentTermsType paymentTerms = new PaymentTerms(paymentTermsNote);
		List<PaymentTermsType> paymentTermsList = this.getPaymentTerms();
		paymentTermsList.add(paymentTerms);
		return paymentTermsList;
	}

	// wie BG-1  INVOICE NOTE
	@Override
	public void setNote(String subjectCode, String content) {
		setNote(content);
	}
	@Override
	public void setNote(String content) {
		addNote(content);
	}
	public List<NoteType> addNote(String invoiceNote) {
		List<NoteType> notes = this.getNote();
		NoteType note = new NoteType();
		note.setValue(invoiceNote);
		notes.add(note);
		return notes;
	}
	public List<String> getNotes() {
		return getNotes(this);
	}
	static List<String> getNotes(CreditNoteType doc) {
		List<NoteType> notes = doc.getNote();
		List<String> res = new ArrayList<String>(notes.size());
		notes.forEach(note -> res.add(note.getValue()));
		return res;
	}
	List<NoteType> addNotes(CreditNoteType doc) {
		List<NoteType> notes = doc.getNote();
		List<NoteType> n = this.getNote();
		notes.forEach(note -> {
			n.add(note);
//			LOG.fine(note.getValue() +" "+n.size());
			});
//		LOG.fine(this.getNote().size() +" "+n.size());
		return n;
	}

	// wie BG-2  PROCESS CONTROL
	void setProcessControl(String customization, String profile) {
		CustomizationIDType customizationID = new CustomizationIDType();
		customizationID.setValue(customization);
		this.setCustomizationID(customizationID);
		if(profile==null) {
			// profileID ist optional
		} else {
			ProfileIDType profileID = new ProfileIDType();
			profileID.setValue(profile);
			this.setProfileID(profileID);
		}
	}
	
	public String getCustomization() {
		return getCustomizationID(this);
	}
	static String getCustomizationID(CreditNoteType doc) {
		CustomizationIDType customizationID =doc.getCustomizationID();
		LOG.info("getSchemeAgencyID:"+customizationID.getSchemeAgencyID() +
				" SchemeAgencyName:"+customizationID.getSchemeAgencyName() +
				" Value:"+customizationID.getValue()
				);
		return customizationID.getValue();
	}
	
	public String getProfile() {
		return getProfileID(this);
	}
	static String getProfileID(CreditNoteType doc) {
		ProfileIDType profileID = doc.getProfileID();
		return profileID==null ? null : profileID.getValue();
	}

	// wie BG-3  PRECEDING INVOICE REFERENCE
	@Override
	public void setPrecedingInvoiceReference(String docRefId, String ymd) {
		setPrecedingInvoiceReference(docRefId, DateTimeFormats.ymdToTs(ymd));
	}
	@Override
	public void setPrecedingInvoiceReference(String docRefId) {
		setPrecedingInvoiceReference(docRefId, (Timestamp)null); // Date is optional
	}
	@Override
	public void setPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		LOG.warning(NOT_IMPEMENTED);
	}
	
	@Override
	public String getPrecedingInvoiceReference() {
		LOG.warning(NOT_IMPEMENTED);
		return null;
	}

	// wie BG-4  SELLER
	public void setSeller(String sellerRegistrationName, Address address, Contact contact, String companyId, String companyLegalForm) {
		Party party = new Party(sellerRegistrationName, address, contact, companyId, companyLegalForm);
		setSellerParty(party);
	}
	
	public void setSellerTaxCompanyId(String taxCompanyId) {
		Party party = getSellerParty();
		party.addPartyTaxID(taxCompanyId);
	}
	
	public void setSellerParty(Party party) {
		SupplierPartyType supplierParty = new SupplierPartyType();
		supplierParty.setParty(party);
		this.sellerParty = party;
		super.setAccountingSupplierParty(supplierParty);
	}
	
	public Party getSellerParty() {
		return this.sellerParty==null ? getSellerParty(this) : sellerParty;
	}
	
	static Party getSellerParty(CreditNoteType doc) {
		SupplierPartyType supplierParty = doc.getAccountingSupplierParty();
		return supplierParty==null ? null : new Party(supplierParty.getParty());
	}

	// wie BG-7  BUYER
	public void setBuyer(String byuerRegistrationName, Address address, Contact contact) {
		Party party = new Party(byuerRegistrationName, address, contact, null, null); 
		setBuyerParty(party);
	}

	public void setBuyerTaxCompanyId(String taxCompanyId) {
		Party party = getBuyerParty();
		party.addPartyTaxID(taxCompanyId);
	}
	public void setBuyerParty(Party party) {
		CustomerPartyType customerparty = new CustomerPartyType();
		customerparty.setParty(party);
		this.buyerParty = party;
		setAccountingCustomerParty(customerparty);
	}
	
	public Party getBuyerParty() {
		return this.buyerParty==null ? getBuyerParty(this) : buyerParty;
	}
	static Party getBuyerParty(CreditNoteType doc) {
		CustomerPartyType customerparty = doc.getAccountingCustomerParty();
		return customerparty==null ? null : new Party(customerparty.getParty());
	}

	// wie BG-13  DELIVERY INFORMATION
	public List<Delivery> getDeliveries() {
		List<DeliveryType> deliveryList = this.getDelivery();
		List<Delivery> result = new ArrayList<Delivery>(deliveryList.size());
		deliveryList.forEach(delivery -> {
			result.add(new Delivery(delivery));
		});
		return result;
	}
	List<DeliveryType> addDeliveries(CreditNoteType doc) {
		List<DeliveryType> deliveryList = doc.getDelivery();
		List<DeliveryType> result = this.getDelivery();
		deliveryList.forEach(delivery -> {
			result.add(new Delivery(delivery));
		});
		return result;
	}
	public List<DeliveryType> addDelivery(List<Delivery> deliveryList) {
		deliveryList.forEach(delivery -> {
			this.addDelivery(delivery);
		});
		return this.getDelivery();
	}
	public List<DeliveryType> addDelivery(Delivery delivery) {
		this.getDelivery().add(delivery);
		List<DeliveryType> deliveryList = this.getDelivery();
		return deliveryList;
	}

	public List<PaymentMeansType> addPaymentInstructions(PaymentMeansCode paymentMeansCode, IBANId iban, String remittanceInformation) {
		FinancialAccountType ibanlAccount = new FinancialAccount(iban);
		return addPaymentInstructions(paymentMeansCode, ibanlAccount, remittanceInformation);
	}
	
	// wie BG-16  PAYMENT INSTRUCTIONS
	public List<PaymentMeansType> addPaymentInstructions(PaymentMeansCode paymentMeansCode, FinancialAccountType financialAccount, String remittanceInformation) {
		List<PaymentMeansType> paymentMeansList = this.getPaymentMeans();
//		LOG.info("paymentMeansCode:"+paymentMeansCode.toString() + ", paymentMeansList size="+paymentMeansList.size()); // == 0 beim ersten mal	
		PaymentMeansType paymentMeans = new PaymentMeans(paymentMeansCode, financialAccount, remittanceInformation);
		paymentMeansList.add(paymentMeans);
		return paymentMeansList;
	}

	public List<PaymentMeans> getPaymentInstructions() {
		return getPaymentInstructions(this);
	}
	static List<PaymentMeans> getPaymentInstructions(CreditNoteType doc) {
		List<PaymentMeansType> paymentMeansList = doc.getPaymentMeans();
		List<PaymentMeans> result = new ArrayList<PaymentMeans>(paymentMeansList.size());
		paymentMeansList.forEach(paymentMeans -> {
			result.add(new PaymentMeans(paymentMeans));
		});
		return result;
	}
	
	public List<PaymentMeansType> addPaymentInstructions(CreditNoteType doc) {
		List<PaymentMeansType> myPaymentMeansList = this.getPaymentMeans();
		List<PaymentMeansType> paymentMeansList = doc.getPaymentMeans();
//		LOG.info("invoice.PaymentMeansList#:"+paymentMeansList.size());
		paymentMeansList.forEach(paymentMeans -> {
			addPaymentInstructions(myPaymentMeansList, paymentMeans); // nicht direkt, da noch eine iteration:
		});
		return myPaymentMeansList;
	}
	private List<PaymentMeansType> addPaymentInstructions(List<PaymentMeansType> myPaymentMeansList, PaymentMeansType paymentMeans) {
		PaymentMeansType myPaymentMeans = new PaymentMeansType();
		myPaymentMeans.setPaymentMeansCode(paymentMeans.getPaymentMeansCode());  // PaymentMeansCode
		myPaymentMeans.setPayeeFinancialAccount(paymentMeans.getPayeeFinancialAccount());  // financialAccount, zB ibanlAccount
		List<PaymentIDType> myPaymentIDs = myPaymentMeans.getPaymentID();
		List<PaymentIDType> paymentIDs = paymentMeans.getPaymentID();
//		LOG.info("PaymentMeansCode="+paymentMeans.getPaymentMeansCode() + 
//				", PayeeFinancialAccount="+paymentMeans.getPayeeFinancialAccount() + 
//				", paymentIDs#:"+paymentIDs.size());
		paymentIDs.forEach(paymentID -> {
			myPaymentIDs.add(paymentID);  // darin remittanceInformation
//			LOG.info("remittanceInformation:"+paymentID.getValue());
		});
		myPaymentMeansList.add(myPaymentMeans);
		return myPaymentMeansList;
	}

	// wie BG-22  DOCUMENT TOTALS
	@Override
	public void setDocumentTotals(Amount lineExtension, Amount taxExclusive, Amount taxInclusive, Amount payable) {
		// Sum of Invoice line net amount / BT-106 / Amount / 1 / Summe aller Rechnungspositionen-Nettobeträge der Rechnung
		LineExtensionAmountType lineExtensionAmount = new LineExtensionAmountType();
		lineExtension.copyTo(lineExtensionAmount);
		
		// Invoice total amount without VAT / BT-109 / Amount / 1 / Der Gesamtbetrag der Rechnung ohne Umsatzsteuer.
		TaxExclusiveAmountType taxExclusiveAmount = new TaxExclusiveAmountType();
		taxExclusive.copyTo(taxExclusiveAmount);
		
		// Invoice total amount with VAT / BT-112 / Amount / 1 / Der Gesamtbetrag der Rechnung mit Umsatzsteuer.		
		TaxInclusiveAmountType taxInclusiveAmount = new TaxInclusiveAmountType();
		taxInclusive.copyTo(taxInclusiveAmount);
		
		// Amount due for payment / BT-115 / Amount / 1 / Der ausstehende Betrag. 
		PayableAmountType payableAmount = new PayableAmountType();
		payable.copyTo(payableAmount);
		
		MonetaryTotalType monetaryTotal = new MonetaryTotalType();
		monetaryTotal.setLineExtensionAmount(lineExtensionAmount);
		monetaryTotal.setTaxExclusiveAmount(taxExclusiveAmount);
		monetaryTotal.setTaxInclusiveAmount(taxInclusiveAmount);
		monetaryTotal.setPayableAmount(payableAmount);
		this.setLegalMonetaryTotal(monetaryTotal);
	}

	@Override
	public Amount getInvoiceLineNetTotal() {
		return getInvoiceLineNetTotal(this);
	}
	@Override
	public Amount getInvoiceTotalTaxExclusive() {
		return getInvoiceTotalTaxExclusive(this);
	}
	@Override
	public Amount getInvoiceTotalTaxInclusive() {
		return getInvoiceTotalTaxInclusive(this);
	}
	@Override
	public Amount getDuePayable() {
		return getDuePayable(this);
	}
	
	static Amount getInvoiceLineNetTotal(CreditNoteType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		return getInvoiceLineNetTotal(monetaryTotal);
	}
	private static Amount getInvoiceLineNetTotal(MonetaryTotalType monetaryTotal) {
		LineExtensionAmountType amount = monetaryTotal.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getInvoiceTotalTaxExclusive(CreditNoteType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		return getInvoiceTotalTaxExclusive(monetaryTotal);
	}
	private static Amount getInvoiceTotalTaxExclusive(MonetaryTotalType monetaryTotal) {
		TaxExclusiveAmountType amount = monetaryTotal.getTaxExclusiveAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getInvoiceTotalTaxInclusive(CreditNoteType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		return getInvoiceTotalTaxInclusive(monetaryTotal);
	}
	private static Amount getInvoiceTotalTaxInclusive(MonetaryTotalType monetaryTotal) {
		TaxInclusiveAmountType amount = monetaryTotal.getTaxInclusiveAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getDuePayable(CreditNoteType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		return getDuePayable(monetaryTotal);
	}
	private static Amount getDuePayable(MonetaryTotalType monetaryTotal) {
		PayableAmountType amount = monetaryTotal.getPayableAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	void setDocumentTotals(CreditNoteType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		Amount lineExtension = getInvoiceLineNetTotal(monetaryTotal);
		Amount taxExclusive = getInvoiceTotalTaxExclusive(monetaryTotal);
		Amount taxInclusive = getInvoiceTotalTaxInclusive(monetaryTotal);
		Amount payable = getDuePayable(monetaryTotal);
		setDocumentTotals(lineExtension, taxExclusive, taxInclusive, payable);
	}

	@Override
	public void setInvoiceTaxInAccountingCurrency(Amount amount) {
		// TODO Der Umsatzsteuergesamtbetrag, angegeben in der Abrechnungswährung, die im Land des Verkäufers gültig ist oder verlangt wird.
	}

	@Override
	public void setAllowancesTotal(Amount taxTotalAmount) {
		// TODO Summe aller in der Rechnung enthaltenen Nachlässe der Dokumentenebene.
	}
	@Override
	public void setChargesTotal(Amount taxTotalAmount) {
		// TODO Summe aller in der Rechnung enthaltenen Abgaben der Dokumentenebene.
	}
	@Override
	public void setPaid(Amount taxTotalAmount) {
		// TODO Summe bereits gezahlter Beträge.
	}
	@Override
	public void setRounding(Amount taxTotalAmount) {
		// TODO Der Betrag, um den der Rechnungsbetrag gerundet wurde.
	}

	/**
	 * Invoice total VAT amount in accounting currency
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>Amount: BT-111
	 * <br>Req.ID: R54
	 * 
	 * <p>Usage Note:
	 * To be used when the VAT accounting currency (BT-6) differs from the Invoice currency code (BT-5) 
	 * in accordance with article 230 of Directive 2006/112 / EC on VAT.
	 * The VAT amount in accounting currency is not used in the calculation of the Invoice totals.
	 * 
	 * @param taxTotalAmount : The VAT total amount expressed in the accounting currency accepted or required in the country of the Seller.
	 */
	@Override
	public void setInvoiceTax(Amount taxTotalAmount) {
		// Der Gesamtbetrag der Umsatzsteuer für die Rechnung.
		this.addInvioceTax(taxTotalAmount);
	}
	
	static Amount getInvoiceTax(CreditNoteType doc) {
		TaxTotalType taxTotal = getFirstTaxTotal(doc);
		TaxAmountType amount = taxTotal.getTaxAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}

	@Override
	public Amount getInvoiceTax() {
		// der durchlauf nur zur info, eingentlich darf es nur ein el geben
		List<TaxTotalType> taxTotals = super.getTaxTotal();
		taxTotals.forEach(taxTotal -> {
			TaxAmountType amount = taxTotal.getTaxAmount();
			Amount taxAmount = new Amount(amount.getCurrencyID(), amount.getValue());
//			LOG.info("taxAmount "+taxAmount);
		});
		if(taxTotals.size()>1) {
			LOG.warning("inkonsistent: taxTotals.size="+taxTotals.size() + " darf maximal 1 sein" );
		}
		
		TaxTotalType taxTotal = getFirstTaxTotal();
		TaxAmountType amount = taxTotal.getTaxAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}	

	// so nicht in XRechnung-v1-2-0.pdf dokumentiert
	void addInvioceTax(Amount taxSum) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		TaxAmountType taxAmount = new TaxAmountType();
		taxSum.copyTo(taxAmount);
		taxTotal.setTaxAmount(taxAmount);
	}
	private TaxTotalType getFirstTaxTotal() {
		return getFirstTaxTotal(this);
	}
	// das garantiert nur ein taxTotal element
	static private TaxTotalType getFirstTaxTotal(CreditNoteType doc) {
		List<TaxTotalType> taxTotals = doc.getTaxTotal();
		if(taxTotals.isEmpty()) {
			TaxTotalType taxTotal = new TaxTotalType();
			taxTotals.add(taxTotal);
		}
		return taxTotals.get(0);
	}

	// TODO BG-23  VAT BREAKDOWN
	public void addVATBreakDown(Amount taxableAmount, Amount tax, VatCategory vatCategory) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		TaxSubtotalType taxSubtotal = new TaxSubtotalType();
		
		TaxableAmountType taxableAmt = new TaxableAmountType();
		taxableAmount.copyTo(taxableAmt);
		taxSubtotal.setTaxableAmount(taxableAmt);

		TaxAmountType taxAmount = new TaxAmountType();
		tax.copyTo(taxAmount);
		taxSubtotal.setTaxAmount(taxAmount);
		
		taxSubtotal.setTaxCategory(vatCategory);

		List<TaxSubtotalType> taxSubtotals = taxTotal.getTaxSubtotal();
		taxSubtotals.add(taxSubtotal);
	}

	public void addVATBreakDown(CreditNoteType doc) {
		TaxTotalType myTaxTotal = getFirstTaxTotal();
		List<TaxSubtotalType> myTaxSubtotals = myTaxTotal.getTaxSubtotal();
		TaxTotalType taxTotal = getFirstTaxTotal(doc);
		List<TaxSubtotalType> taxSubtotals = taxTotal.getTaxSubtotal();
		taxSubtotals.forEach(taxSubtotal -> {
			myTaxSubtotals.add(taxSubtotal);
		});
	}

	// key TaxableAmountType.class ... oder TaxCategory
	// val amount ... oder TaxCategory-Objekt%
	public List<Map<Object,Object>> getVATBreakDown() {
		return getVATBreakDown(this);
	}
	List<Map<Object,Object>> getVATBreakDown(CreditNoteType doc) {
		TaxTotalType taxTotal = getFirstTaxTotal(doc);
		return Invoice.getVATBreakDown(taxTotal);
	}

	// TODO BG-24  ADDITIONAL SUPPORTING DOCUMENTS
	
	// wie BG-25  INVOICE LINE
	public List<CreditNoteLineType> addLine(CreditNoteLineType line) {
		List<CreditNoteLineType> lines = this.getCreditNoteLine();
		lines.add(line);
		return lines;
	}

	public List<CreditNoteLineType> addLines(CreditNoteType doc) {
		List<CreditNoteLineType> lines = doc.getCreditNoteLine();
		List<CreditNoteLineType> resultLines = super.getCreditNoteLine();
		lines.forEach(line -> {
			resultLines.add(line);
		});
		return resultLines;
	}
	
	public List<CreditNoteLine> getLines() {
		return getLines(this);
	}

	static List<CreditNoteLine> getLines(CreditNoteType doc) {
		List<CreditNoteLineType> lines = doc.getCreditNoteLine();
		List<CreditNoteLine> resultLines = new ArrayList<CreditNoteLine>(lines.size());
		lines.forEach(line -> {
			resultLines.add(new CreditNoteLine(line));
		});
		return resultLines;
	}

}
