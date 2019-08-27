package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.IContact;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxInclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxPointDateType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;

/*
 
TODO
    <cac:Price>
      <cbc:PriceAmount currencyID="EUR">1085.00</cbc:PriceAmount>
      <cbc:BaseQuantity unitCode="LH">8</cbc:BaseQuantity>              <================ fehlt
    </cac:Price>
 
         <cac:TaxSubtotal>
            <cbc:TaxableAmount currencyID="EUR">135.63</cbc:TaxableAmount>
            <cbc:TaxAmount currencyID="EUR">27.13</cbc:TaxAmount>
            <cac:TaxCategory>
              <cbc:ID schemeAgencyID="6" schemeID="UN/ECE 5305">S</cbc:ID>   <============== IST <cbc:ID>S</cbc:ID>
              <cbc:Percent>20</cbc:Percent>
              <cac:TaxScheme>
                <cbc:ID schemeAgencyID="6" schemeID="UN/ECE 5153">VAT</cbc:ID> <================= IST <cbc:ID>VAT</cbc:ID>
              </cac:TaxScheme>
           </cac:TaxCategory>
        </cac:TaxSubtotal>

 
 */
public class CreditNote extends CreditNoteType implements CoreInvoice {

	private static final Logger LOG = Logger.getLogger(CreditNote.class.getName());
	
	private static final String NOT_IMPEMENTED = "NOT IMPEMENTED";
	
	CreditNote() {
		super();
	}
	
	public CreditNote(String customization, String profile, DocumentNameCode code) {
		this();
		taxTotalFirst = new TaxTotalType();
		super.getTaxTotal().add(taxTotalFirst); // garantiert ein elem in List<TaxTotalType> 
		setProcessControl(customization, profile);
		setTypeCode(code); // BT-3		
		sellerParty = null;
		buyerParty = null;		
	}

	// cache:
	Party sellerParty;
	Party buyerParty;
	TaxTotalType taxTotalFirst;
	
	// copy-ctor
	public CreditNote(CreditNoteType doc) {
		this(getCustomizationID(doc), getProfileID(doc), getTypeCode(doc));
		setId(getId(doc));
		setIssueDate(getIssueDateAsTimestamp(doc));
		setDocumentCurrency(getDocumentCurrency(doc));
		LOG.info("alle mandatories - jetzt die optionalen:");
		setTaxCurrency(getTaxCurrency(doc)); // optional
		setTaxPointDate(getTaxPointDateAsTimestamp(doc)); // optional
		setPaymentTermsAndDate(getPaymentTerm(doc), (Timestamp)null); // optional, DueDateAsTimestamp==null
		setBuyerReference(getBuyerReferenceValue(doc)); // optional
		setOrderReferenceID(getOrderReferenceID(doc)); // optional
		LOG.info("alle optionalen.");
//		addPaymentTerms(doc);
		addNotes(doc);
		setSellerParty(getSellerParty(doc));
		setBuyerParty(getBuyerParty(doc));
		setPayeeParty(getPayeeParty(doc));
		setTaxRepresentativeParty(getTaxRepresentativeParty(doc));
		addDeliveries(doc);
		
		List<PaymentMeansType> pmList = doc.getPaymentMeans();
		if(pmList.isEmpty()) {
			// LOG
		} else {
			super.getPaymentMeans().add(new PaymentMeans(pmList.get(0)));
		}
		
		setDocumentTotals(doc);
		setInvoiceTax(getInvoiceTax(doc));
		addVATBreakDown(getVATBreakDowns(doc));
		addLines(doc);
		LOG.info("ctor ENDE.");
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
	void setDueDate(Timestamp ts) {
//		if(ts==null) return; // optional
//		DueDateType dueDate = new DueDateType();
//		dueDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
//		super.setDueDate(dueDate);
	}
	
	@Override
	public Timestamp getDueDateAsTimestamp() {
		return getDueDateAsTimestamp(this);
	}
	static Timestamp getDueDateAsTimestamp(CreditNoteType doc) {
		return null;
//		DueDateType dueDate = doc.getDueDate();
//		return dueDate==null ? null : DateTimeFormats.xmlGregorianCalendarToTs(dueDate.getValue());
	}
	
	@Override
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

	@Override
	public void setProjectReference(String reference, String schemeID) {
		LOG.warning(NOT_IMPEMENTED);
		
	}
	@Override
	public String getProjectReferenceValue() {
		LOG.warning(NOT_IMPEMENTED);
		return null;
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
	
	List<PaymentTermsType> addPaymentTerms(String paymentTermsNote) {
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
	public void setSeller(String name, PostalAddress address, IContact contact, String companyId, String companyLegalForm) {
		Party party = new Party(name, address, contact);
		party.setCompanyId(companyId);
		party.setCompanyLegalForm(companyLegalForm);
		setSellerParty(party);
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
	public void setBuyer(String byuerRegistrationName, PostalAddress address, IContact contact) {
		Party party = new Party(byuerRegistrationName, address, contact); 
		setBuyerParty(party);
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

	// wie BG-10  PAYEE
	public void setPayee(String name, String id, String companyLegalForm) {
		Party party = new Party(null, null, null);
		party.setBusinessName(name);  // !!!!!
		party.setCompanyLegalForm(companyLegalForm);
		party.setId(id);
		setPayeeParty(party);
	}
	public void setPayeeParty(Party party) {
		super.setPayeeParty(party);
	}

	public Party getPayeeParty() {
		PartyType party = super.getPayeeParty();
		return party==null ? null : new Party(party);
	}
	static Party getPayeeParty(CreditNoteType doc) {
		PartyType party = doc.getPayeeParty();
		return party==null ? null : new Party(party);
	}

	// wie BG-11  SELLER TAX REPRESENTATIVE PARTY
	public void setTaxRepresentative(String registrationName, PostalAddress address, String taxRegistrationName, String taxRegistrationSchemaID) {
		Party party = new Party(registrationName, address, null);
		party.setTaxRegistrationId(taxRegistrationName, taxRegistrationSchemaID);
		setTaxRepresentativeParty(party);
	}
	public void setTaxRepresentativeParty(Party party) {
		super.setTaxRepresentativeParty(party);
	}
	
	public Party getTaxRepresentativeParty() {
		PartyType party = super.getTaxRepresentativeParty();
		return party==null ? null : new Party(party);
	}
	static Party getTaxRepresentativeParty(CreditNoteType doc) {
		PartyType party = doc.getTaxRepresentativeParty();
		return party==null ? null : new Party(party);
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

	// wie BG-16  PAYMENT INSTRUCTIONS
	/**
	 * group PAYMENT INSTRUCTIONS, BG-16 Cardinality 0..1
	 * 
	 * @param code                   mandatory BT-81
	 * @param paymentMeansText       optional  BT-82 (can be null)
	 * @param remittanceInformation  optional  BT-83 (can be null)
	 * @param creditTransfer         optional  BG-17 0..n, can be CreditTransfer object or List<CreditTransfer>
	 * @param paymentCard            optional  BG-18 0..1
	 * @param directDebit            optional  BG-19 0..1
	 */
	public void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, CreditTransfer creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		List<CreditTransfer> ctList = new ArrayList<CreditTransfer>();
		if(creditTransfer!=null) ctList.add(creditTransfer);
		setPaymentInstructions(code, paymentMeansText, remittanceInformation, ctList, paymentCard, directDebit);
	}
	
	public List<CreditTransfer> getCreditTransfer() {
		if(super.getPaymentMeans().isEmpty()) return null;
		LOG.info("PaymentMeans.Class:"+super.getPaymentMeans().get(0).getClass());
		PaymentMeans pm = (PaymentMeans)super.getPaymentMeans().get(0);
		return pm.getCreditTransfer();
	}

	public void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransferList, PaymentCard paymentCard, DirectDebit directDebit) {
		// TODO in ubl gibt ex keine List<CreditTransfer> !!!
		PaymentMeansType paymentMeans = new PaymentMeans(code, paymentMeansText, remittanceInformation, creditTransferList, paymentCard, directDebit);
		super.getPaymentMeans().add(paymentMeans);
	}
	
	public PaymentMeansEnum getPaymentMeansEnum() {
		if(super.getPaymentMeans().isEmpty()) return null;
		return PaymentMeans.getPaymentMeansEnum(super.getPaymentMeans().get(0));
	}
	
	public String getPaymentMeansText() {
		return null; // TODO
//		if(super.getPaymentMeans().isEmpty()) return null;
//		return PaymentMeans.getPaymentMeansText(super.getPaymentMeans().get(0));
	}
	
	public String getRemittanceInformation() {
		if(super.getPaymentMeans().isEmpty()) return null;
		return PaymentMeans.getRemittanceInformation(super.getPaymentMeans().get(0));
	}
	
//	public void setPaymentInstructions(PaymentMeansEnum paymentMeansCode, IBANId iban, String remittanceInformation, String accountName) {
//		FinancialAccountType ibanAccount = new FinancialAccount(iban); 
//		setPaymentInstructions(paymentMeansCode, ibanAccount, remittanceInformation, accountName);
//	}
//	public void setPaymentInstructions(PaymentMeansEnum paymentMeansCode, FinancialAccountType financialAccount, String remittanceInformation, String accountName) {
//		addPaymentInstructions(paymentMeansCode, financialAccount, remittanceInformation, accountName);
//	}
//	List<PaymentMeansType> addPaymentInstructions(PaymentMeansEnum paymentMeansCode, FinancialAccountType financialAccount, 
//			String remittanceInformation, String accountName) {
//		List<PaymentMeansType> paymentMeansList = super.getPaymentMeans();
//		LOG.info("paymentMeansCode:"+paymentMeansCode.toString() + ", (TODO)accountName:"+accountName + // TODO
//				", paymentMeansList size="+paymentMeansList.size()); // == 0 beim ersten mal	
//		PaymentMeansType paymentMeans = new PaymentMeans(paymentMeansCode, financialAccount, remittanceInformation);
//		paymentMeansList.add(paymentMeans);
//		return paymentMeansList;
//	}
//
//	public List<PaymentMeans> getPaymentInstructions() {
//		return getPaymentInstructions(this);
//	}
//	static List<PaymentMeans> getPaymentInstructions(CreditNoteType doc) {
//		List<PaymentMeansType> paymentMeansList = doc.getPaymentMeans();
//		List<PaymentMeans> result = new ArrayList<PaymentMeans>(paymentMeansList.size());
//		paymentMeansList.forEach(paymentMeans -> {
//			result.add(new PaymentMeans(paymentMeans));
//		});
//		return result;
//	}
//
//	List<PaymentMeansType> addPaymentInstructions(CreditNoteType doc) {
//		List<PaymentMeansType> result = this.getPaymentMeans();
//		List<PaymentMeansType> paymentMeansList = doc.getPaymentMeans();
//		LOG.info(" VOR doc.PaymentMeansList#:"+paymentMeansList.size() + " result.List#:"+result.size());
//		paymentMeansList.forEach(paymentMeans -> {
//			PaymentMeansCodeType pmc = paymentMeans.getPaymentMeansCode();
//			if(pmc==null) {
//				LOG.info("pmc==null");
//			} else {
//				LOG.info("pmc:"+pmc.getValue());
//			}
//			addPaymentInstructions(result, paymentMeans); // nicht direkt, da noch eine iteration:
//		});
//		LOG.info("NACH doc.PaymentMeansList#:"+paymentMeansList.size() + " result.List#:"+result.size());
//		result.forEach(pmt -> {
//			PaymentMeans pm = (PaymentMeans)pmt;
//			LOG.info("result pm:"+pm.toString());
//		});
//		return result;
//	}
//	private List<PaymentMeansType> addPaymentInstructions(List<PaymentMeansType> result, PaymentMeansType paymentMeans) {
//		PaymentMeansType resPaymentMeans = new PaymentMeans(paymentMeans);
//		result.add(resPaymentMeans);
//		return result;
//	}


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
	public Amount getInvoiceTaxInAccountingCurrency() {
		// TODO Auto-generated method stub
		return null;
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
		TaxTotalType taxTotal = doc.getTaxTotal().get(0); // getFirstTaxTotal(doc);
		TaxAmountType amount = taxTotal.getTaxAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}

	@Override
	public Amount getInvoiceTax() {
		// der durchlauf nur zur info, eingentlich darf es nur ein el geben
		List<TaxTotalType> taxTotals = super.getTaxTotal();
//		taxTotals.forEach(taxTotal -> {
//			TaxAmountType amount = taxTotal.getTaxAmount();
//			Amount taxAmount = new Amount(amount.getCurrencyID(), amount.getValue());
//			LOG.info("taxAmount "+taxAmount);
//		});
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
		return this.getTaxTotal().get(0);
	}

	// BG-23  VAT BREAKDOWN
	/**
	 * Adds a mandatory VAT BREAKDOWN element
	 * 
	 * @param vatBreakdown
	 */
	@Override
	public void addVATBreakDown(CoreInvoiceVatBreakdown vatBreakdown) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		taxTotal.getTaxSubtotal().add((VatBreakdown)vatBreakdown);
	}
	public void addVATBreakDown(List<VatBreakdown> vatBreakdowns) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		
		vatBreakdowns.forEach(vbd -> {
			taxTotal.getTaxSubtotal().add(vbd);
		});	
	}
	public void addVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		
		TaxSubtotalType taxSubtotal = new VatBreakdown(taxableAmount, tax, taxCategoryCode, taxRate);
		taxTotal.getTaxSubtotal().add(taxSubtotal);
	}
	public void addVATBreakDown(VatBreakdown vatBreakdown) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		taxTotal.getTaxSubtotal().add(vatBreakdown);
	}
	public List<VatBreakdown> getVATBreakDowns() {
		return getVATBreakDowns(this);
	}
	static List<VatBreakdown> getVATBreakDowns(CreditNoteType doc) {
		TaxTotalType taxTotal = doc.getTaxTotal().get(0);
		List<TaxSubtotalType> taxSuptotalList = taxTotal.getTaxSubtotal();
		List<VatBreakdown> result = new ArrayList<VatBreakdown>(taxSuptotalList.size()); // VatBreakdown extends TaxSubtotalType
		taxSuptotalList.forEach(vbd -> {
			VatBreakdown taxSubtotal = new VatBreakdown(vbd);
			result.add(taxSubtotal);
		});	
		return result;
	}

	// TODO BG-24  ADDITIONAL SUPPORTING DOCUMENTS
	
	// wie BG-25  INVOICE LINE
	/**
	 * Adds a mandatory invoice line element
	 * 
	 * @param line
	 */
	@Override
	public void addLine(CoreInvoiceLine line) {
		List<CreditNoteLineType> lines = this.getCreditNoteLine();
		lines.add((CreditNoteLineType)line);
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

	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		Party party = new Party();
		return party.createAddress(countryCode, postalCode, city);
	}

	@Override
	public PostalAddress createAddress(PostalAddress address) {
		Party party = new Party();
		return party.createAddress(address);
	}

	@Override
	public IContact createContact(String contactName, String contactTel, String contactMail) {
		Party party = new Party();
		return party.createContact(contactName, contactTel, contactMail);
	}

	@Override
	public IContact createContact(IContact contact) {
		Party party = new Party();
		return party.createContact(contact);
	}

}
