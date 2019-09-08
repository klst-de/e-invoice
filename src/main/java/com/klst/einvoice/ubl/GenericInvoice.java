package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.BG4_Seller;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.CreditTransferFactory;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.DirectDebitFactory;
import com.klst.einvoice.IContact;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentCardFactory;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ProjectReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuyerReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditNoteTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionNoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxInclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxPointDateType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.DateType;

public class GenericInvoice <T> implements CoreInvoice, CreditTransferFactory, PaymentCardFactory, DirectDebitFactory  {

	private static final Logger LOG = Logger.getLogger(GenericInvoice.class.getName());
	
	private static final String NOT_IMPEMENTED = "NOT IMPEMENTED";
	
	T t;
	boolean isInvoiceType = false;
	InvoiceType invoice = null;
	CreditNoteType creditNote = null;
	
	// factory
	public static GenericInvoice<InvoiceType> createInvoice(String customization, String profile, DocumentNameCode code) {
		InvoiceType invoice = new InvoiceType();
		GenericInvoice<InvoiceType> gi = new GenericInvoice<InvoiceType>(invoice);
//		LOG.info("vor gi.init(customization:"+customization);
		gi.init(customization, profile, code);
		return gi;
	}
	
	public static GenericInvoice<CreditNoteType> createCreditNote(String customization, String profile, DocumentNameCode code) {
		CreditNoteType cn = new CreditNoteType();
		GenericInvoice<CreditNoteType> gi = new GenericInvoice<CreditNoteType>(cn);
//		LOG.info("vor gi.init(customization:"+customization);
		gi.init(customization, profile, code);
		return gi;
	}
	
	// ctor mit type parameter
	public GenericInvoice(T t) {
		this.t = t;
		isInvoiceType = this.t instanceof InvoiceType;
		if(isInvoiceType) {
			invoice = (InvoiceType)t;
		} else {
			creditNote = (CreditNoteType)t;
		}
		if(getId()!=null) LOG.info("copy ctor "+this);
	}
	
	public T get() {
		return this.t;
	}

	void init(String customization, String profile, DocumentNameCode code) {
		setProcessControl(customization, profile); // BG-2
		setTypeCode(code); // BT-3	
		LOG.info("ctor "+this);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append("ID:"+getId());
		stringBuilder.append(", IssueDate:"+getIssueDateAsTimestamp());
		stringBuilder.append(", TypeCode:"+getTypeCode());
		stringBuilder.append(", Customization:"+getCustomization());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	// BT-1 + 1..1 Invoice number
	public void setId(String id) {
		if(isInvoiceType) {
			invoice.setID(Invoice.newIDType(id, null)); // null : No identification scheme 
		} else {
			creditNote.setID(Invoice.newIDType(id, null)); // null : No identification scheme 
		}
	}
	
	public String getId() {
		IDType id = isInvoiceType ? invoice.getID() : creditNote.getID();
		return id==null ? null : id.getValue();
	}
	
	// BT-2 + 1..1 Invoice issue date
	@Override
	public void setIssueDate(String ymd) {
		setIssueDate(DateTimeFormats.ymdToTs(ymd));
	}

	@Override
	public void setIssueDate(Timestamp ts) {
		IssueDateType issueDate = new IssueDateType();
		issueDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		if(isInvoiceType) {
			invoice.setIssueDate(issueDate);
		} else {
			creditNote.setIssueDate(issueDate);
		}
	}
	
	@Override
	public Timestamp getIssueDateAsTimestamp() {
		IssueDateType issueDate = isInvoiceType ? invoice.getIssueDate() : creditNote.getIssueDate();
		if(issueDate==null) return null; // bei init
		return DateTimeFormats.xmlGregorianCalendarToTs(issueDate.getValue());
	}
	
	// BT-3 + 1..1 Invoice/CreditNoteType type code
	@Override // use only via ctor
	public void setTypeCode(DocumentNameCode code) {
		if(isInvoiceType) {
			InvoiceTypeCodeType typeCode = new InvoiceTypeCodeType();
			typeCode.setValue(code.getValueAsString());
			invoice.setInvoiceTypeCode(typeCode);
		} else {
			CreditNoteTypeCodeType typeCode = new CreditNoteTypeCodeType();
			typeCode.setValue(code.getValueAsString());
			creditNote.setCreditNoteTypeCode(typeCode);
		}
	}
	
	@Override
	public DocumentNameCode getTypeCode() {
		return isInvoiceType ? DocumentNameCode.valueOf(invoice.getInvoiceTypeCode()) : DocumentNameCode.valueOf(creditNote.getCreditNoteTypeCode());
	}

	// BT-4 ist nicht definiert
	
	// BT-5 + 1..1 Invoice currency code
	@Override
	public void setDocumentCurrency(String isoCurrencyCode) {
		DocumentCurrencyCodeType documentCurrencyCode = new DocumentCurrencyCodeType();
		documentCurrencyCode.setValue(isoCurrencyCode);
		if(isInvoiceType) {
			invoice.setDocumentCurrencyCode(documentCurrencyCode);
		} else {
			creditNote.setDocumentCurrencyCode(documentCurrencyCode);
		}
	}
	
	@Override
	public String getDocumentCurrency() {
		DocumentCurrencyCodeType code = isInvoiceType ? invoice.getDocumentCurrencyCode() : creditNote.getDocumentCurrencyCode();
		return code==null ? null : code.getValue();
	}

	// BT-6 + 0..1 VAT accounting currency code
	@Override
	public void setTaxCurrency(String isoCurrencyCode) {
		if(isoCurrencyCode==null) return;
		PaymentCurrencyCodeType paymentCurrencyCode = new PaymentCurrencyCodeType();
		paymentCurrencyCode.setValue(isoCurrencyCode); 
		if(isInvoiceType) {
			invoice.setPaymentCurrencyCode(paymentCurrencyCode);
		} else {
			creditNote.setPaymentCurrencyCode(paymentCurrencyCode);
		}
	}
	
	@Override
	public String getTaxCurrency() {
		PaymentCurrencyCodeType code = isInvoiceType ? invoice.getPaymentCurrencyCode() : creditNote.getPaymentCurrencyCode();
		return code==null ? null : code.getValue();
	}

	// BT-7 + 0..1 Value added tax point date
	/* Das Datum, zu dem die Umsatzsteuer für den Verkäufer und für den Erwerber abrechnungsrelevant wird.
	 * Die Anwendung von BT-7 und BT-8 schließen sich gegenseitig aus.
	 * 
	 * Anwendung: In Deutschland wird dieses nicht verwendet. 
	 *            Statt dessen ist das Liefer- und Leistungsdatum anzugeben.
	 *       Bsp: ubl-tc434-example2.xml ==> <cbc:TaxPointDate>2013-06-30</cbc:TaxPointDate>
	 */
	@Override
	public void setTaxPointDate(String ymd) {	
		setTaxPointDate(DateTimeFormats.ymdToTs(ymd));
	}
	@Override
	public void setTaxPointDate(Timestamp ts) {
		if(ts==null) return; // optional
		TaxPointDateType taxPointDate = new TaxPointDateType();
		taxPointDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		if(isInvoiceType) {
			invoice.setTaxPointDate(taxPointDate);
		} else {
			creditNote.setTaxPointDate(taxPointDate);
		}
	}
	
	@Override
	public Timestamp getTaxPointDateAsTimestamp() {
		TaxPointDateType taxPointDate = isInvoiceType ? invoice.getTaxPointDate() : creditNote.getTaxPointDate();
		return taxPointDate==null ? null : DateTimeFormats.xmlGregorianCalendarToTs(taxPointDate.getValue());
	}

	// BT-8 + 0..1 Value added tax point date code
	/* Folgende Codes aus der Codeliste UNTDID 2005 werden verwendet:
	 *   3 (Invoice document issue date time)
	 *  35 (Delivery date/time, actual)
	 * 432 (Paid to date)
	 * Das Informationselement „Value added tax point date code“ (BT-8) wird verwendet, 
	 * wenn das Informationselement „Value added tax point date“ (BT-7) zum Zeitpunkt der Rechnungsstellung noch nicht bekannt ist.
	 * Die Anwendung von BT-7 und 8 schließen sich gegenseitig aus.
	 * 
0 .. n ApplicableTradeTax Umsatzsteueraufschlüsselung BG-23
0 .. 1 DueDateTypeCode Code für das Datum der Steuerfälligkeit BT-8
	 */
	// In Deutschland ist das Liefer- und Leistungsdatum maßgebend (BT-72)
	// keine Beispiele 
	@Override
	public void setTaxPointDateCode(String code) {
		LOG.warning(NOT_IMPEMENTED); // TODO in ubl nicht definiert ???
	}
	@Override
	public String getTaxPointDateCode() {
		LOG.warning(NOT_IMPEMENTED); // TODO
		return null;	
	}
	
	// BT-9 + 0..1 Payment due date
	@Override
	public void setDueDate(String ymd) {
		setDueDate(DateTimeFormats.ymdToTs(ymd));
	}
	@Override
	public void setDueDate(Timestamp ts) {
		if(ts==null) return; // optional
		DueDateType dueDate = new DueDateType();
		dueDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		if(isInvoiceType) {
			invoice.setDueDate(dueDate);
		} else {
			// nothing
//			creditNore.setDueDate(dueDate);
		}
	}
	@Override
	public Timestamp getDueDateAsTimestamp() {
		DueDateType dueDate = isInvoiceType ? invoice.getDueDate() : null;
		return dueDate==null ? null : DateTimeFormats.xmlGregorianCalendarToTs(dueDate.getValue());		
	}
	
	// BT-10 + 0..1 Buyer reference
	@Override
	public void setBuyerReference(String reference) {
		if(reference==null) return; // optional
		BuyerReferenceType buyerReference = new BuyerReferenceType();
		buyerReference.setValue(reference);
		if(isInvoiceType) {
			invoice.setBuyerReference(buyerReference);
		} else {
			creditNote.setBuyerReference(buyerReference);
		}
	}
	@Override
	public String getBuyerReferenceValue() {
		BuyerReferenceType buyerReference = isInvoiceType ? invoice.getBuyerReference() : creditNote.getBuyerReference();
		return buyerReference==null ? null : buyerReference.getValue();
	}

	// BT-11 + 0..1 Project reference
/*
test daten in 05 13 15
CII: 01.05a-INVOICE_uncefact.xml :
            </ram:BuyerTradeParty>
            <ram:SpecifiedProcuringProject>
                <ram:ID>PR456789</ram:ID>
                <ram:Name>Project reference</ram:Name>
            </ram:SpecifiedProcuringProject>
UBL:
    <cac:ProjectReference>
        <cbc:ID>PR456789</cbc:ID>
    </cac:ProjectReference>

 */
	@Override
	public void setProjectReference(String id, String schemeID) {
		if(id==null) return; // optional
		ProjectReferenceType projectReference = new ProjectReferenceType();
		projectReference.setID(Invoice.newIDType(id, schemeID));
		if(isInvoiceType) {
			invoice.getProjectReference().add(projectReference);
		} else {
			// undefined in creditNore
		}
	}

	@Override
	public String getProjectReferenceValue() { // ohne schemeID     TODO umbennenen in ProjectReferenceId
		// creditNore.getProjectReference() undefined
		List<ProjectReferenceType> list = isInvoiceType ? invoice.getProjectReference() : new ArrayList<ProjectReferenceType>();
		return list.isEmpty() ? null : list.get(0).getID().getValue(); // wg. 0..1
	}
	
	// BT-12 + 0..1 Contract reference
/*
test daten in 03 06 08 15
CII: 01.03a-INVOICE_uncefact.xml :
            <ram:ContractReferencedDocument>
                <ram:IssuerAssignedID>CR987654</ram:IssuerAssignedID>
            </ram:ContractReferencedDocument>UBL:
UBL: 
    <cac:ContractDocumentReference>
        <cbc:ID>CR987654</cbc:ID>
    </cac:ContractDocumentReference>
 */
//	@Override
	public void setContractReference(String id, String schemeID) {
		if(id==null) return; // optional
		DocumentReferenceType reference = new DocumentReferenceType();
		reference.setID(Invoice.newIDType(id, schemeID));
		if(isInvoiceType) {
			invoice.getContractDocumentReference().add(reference);
		} else {
			creditNote.getContractDocumentReference().add(reference);
		}
	}

//	@Override
	public String getContractReferenceId() {
		List<DocumentReferenceType> list = isInvoiceType ? invoice.getContractDocumentReference() : creditNote.getContractDocumentReference();
		return list.isEmpty() ? null : list.get(0).getID().getValue(); // wg. 0..1
	}

	// BT-13 + 0..1 Purchase order reference
	// BT-14 + 0..1 Sales order reference
	@Override
	public void setOrderReferenceID(String docRefId) {
		if(docRefId==null) return; // optional
		OrderReferenceType orderReference = new OrderReferenceType();
		orderReference.setID(Invoice.newIDType(docRefId, null)); // null : No identification scheme
		
		if(isInvoiceType) {
			invoice.setOrderReference(orderReference);
		} else {
			creditNote.setOrderReference(orderReference);
		}
	}

	@Override
	public String getOrderReferenceID() {
		OrderReferenceType orderRef = isInvoiceType ? invoice.getOrderReference() : creditNote.getOrderReference();
		if(orderRef==null) return null;
		return orderRef.getID().getValue();
	}

	// BT-15 + 0..1 Receiving advice reference
	// BT-16 + 0..1 Despatch advice reference
	// BT-17 + 0..1 Tender or lot reference
	// BT-18 + 0..1 Invoiced object identifier
	// BT-19 + 0..1 Buyer accounting reference
	
	// BT-20 + 0..1 Payment terms
//	@Override
	void setPaymentTerm(String text) {
		if(text==null) return; // optional
		PaymentTerms paymentTerms = new PaymentTerms(text);
		if(isInvoiceType) {
			invoice.getPaymentTerms().add(paymentTerms);
		} else {
			creditNote.getPaymentTerms().add(paymentTerms);
		}
	}
	@Override
	public String getPaymentTerm() {
		List<PaymentTermsType> list = isInvoiceType ? invoice.getPaymentTerms() : creditNote.getPaymentTerms();
		return list.isEmpty() ? null : list.get(0).getNote().get(0).getValue();
	}
	
	@Override
	public void setPaymentTermsAndDate(String description, String ymd) {
		setPaymentTermsAndDate(description, DateTimeFormats.ymdToTs(ymd));
	}
	@Override
	public void setPaymentTermsAndDate(String description, Timestamp ts) {
		setPaymentTerm(description); // BT-20 optional
		setDueDate(ts); // BT-9 optional	
	}

	// BG-1 + 0..n INVOICE NOTE
	// BG-1.BT-21 ++ 0..1 Invoice note subject code
	// BG-1.BT-22 ++ 1..1 Invoice note /aka content
	@Override
	public void setNote(String subjectCode, String content) {
		if(content==null) return; // optional
		NoteType note = new NoteType();
		note.setValue(content);
		if(isInvoiceType) {
			invoice.getNote().add(note);
		} else {
			creditNote.getNote().add(note);
		}
	}
	@Override
	public void setNote(String content) {
		setNote(null, content);
	}

	@Override
	public List<Object> getNotes() {
		List<NoteType> list = isInvoiceType ? invoice.getNote() : creditNote.getNote();
		List<Object> res = new ArrayList<Object>(list.size());
		list.forEach(note -> res.add(note));
		return res;
	}

	// BG-2 + 1..1 PROCESS CONTROL
	// BG-2.BT-23 ++ 0..1 Business process type / aka profile
	// BG-2.BT-24 ++ 1..1 Specification identifier / aka Customization
	void setProcessControl(String customization, String profile) {
		CustomizationIDType customizationID = new CustomizationIDType();
		customizationID.setValue(customization);
		
		if(isInvoiceType) {
			invoice.setCustomizationID(customizationID);
		} else {
			creditNote.setCustomizationID(customizationID);
		}
		
		if(profile==null) {
			// profileID ist optional
		} else {
			ProfileIDType profileID = new ProfileIDType();
			profileID.setValue(profile);
			if(isInvoiceType) {
				invoice.setProfileID(profileID);
			} else {
				creditNote.setProfileID(profileID);
			}
		}	
	}
	
	@Override
	public String getCustomization() {
		CustomizationIDType customizationID = isInvoiceType ? invoice.getCustomizationID() : creditNote.getCustomizationID();
		LOG.info("SchemeAgencyID:"+customizationID.getSchemeAgencyID() +
				" SchemeAgencyName:"+customizationID.getSchemeAgencyName() +
				" Value:"+customizationID.getValue()
				);
		return customizationID.getValue();
	}

	@Override
	public String getProfile() {
		ProfileIDType profileID = isInvoiceType ? invoice.getProfileID() : creditNote.getProfileID();
		return profileID==null ? null : profileID.getValue();
	}

	// BG-3 + 0..n PRECEDING INVOICE REFERENCE
	// BG-3.BT-25 ++ 1..1 Preceding Invoice reference
	// BG-3.BT-26 ++ 0..1 Preceding Invoice issue date
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
		// es fehlen testdaten
		List<DocumentReferenceType> originatorDocumentReferenceList = isInvoiceType ? invoice.getOriginatorDocumentReference() : creditNote.getOriginatorDocumentReference();
		if(originatorDocumentReferenceList.isEmpty()) return null;
		originatorDocumentReferenceList.get(0).getIssueDate(); // das optionale datum
		return originatorDocumentReferenceList.get(0).getID().getValue();	
	}
	
	// BG-4 + 1..1 SELLER
	public void setSeller(String name, PostalAddress address, IContact contact, String companyId, String companyLegalForm) {
		BusinessParty party = createParty(name, address, contact); 
		party.setCompanyId(companyId);
		party.setCompanyLegalForm(companyLegalForm);
		setSeller(party);
	}
	public void setSeller(BusinessParty party) {
		SupplierPartyType supplierParty = new SupplierPartyType();
		supplierParty.setParty((PartyType) party);
		if(isInvoiceType) {
			invoice.setAccountingSupplierParty(supplierParty);
		} else {
			creditNote.setAccountingSupplierParty(supplierParty);
		}
	}
	
	public BG4_Seller getSeller() {
		SupplierPartyType supplierParty = isInvoiceType ? invoice.getAccountingSupplierParty() : creditNote.getAccountingSupplierParty();
		return supplierParty==null ? null : new Party(supplierParty.getParty());
	}
	
	// BG-7 + 1..1 BUYER
	public void setBuyer(String name, PostalAddress address, IContact contact) {
		BusinessParty party = createParty(name, address, contact); 
		setBuyer(party);
	}
	public void setBuyer(BusinessParty party) {
		CustomerPartyType customerparty = new CustomerPartyType();
		customerparty.setParty((PartyType)party);
		if(isInvoiceType) {
			invoice.setAccountingCustomerParty(customerparty);
		} else {
			creditNote.setAccountingCustomerParty(customerparty);
		}
	}
	
	public BG7_Buyer getBuyer() {
		CustomerPartyType customerparty = isInvoiceType ? invoice.getAccountingCustomerParty() : creditNote.getAccountingCustomerParty();
		return customerparty==null ? null : new Party(customerparty.getParty());
	}
	
	// BG-10 + 0..1 PAYEE
	public void setPayee(String name, String id, String companyLegalForm) {
		BusinessParty party = createParty(null, null, null);
		party.setBusinessName(name);  // !!!!!
		party.setCompanyLegalForm(companyLegalForm);
		party.setId(id);
		setPayee(party);
	}
	public void setPayee(BusinessParty party) {
		if(isInvoiceType) {
			invoice.setPayeeParty((PartyType)party);
		} else {
			creditNote.setPayeeParty((PartyType)party);
		}
	}
	
	public BusinessParty getPayee() {
		PartyType party = isInvoiceType ? invoice.getPayeeParty() : creditNote.getPayeeParty();
		return party==null ? null : new Party(party);
	}

	// BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY
	public void setTaxRepresentative(String registrationName, PostalAddress address, String taxRegistrationName, String taxRegistrationSchemaID) {
		BusinessParty party = createParty(registrationName, address, null);
		party.setTaxRegistrationId(taxRegistrationName, taxRegistrationSchemaID);
		setTaxRepresentative(party);
	}
	public void setTaxRepresentative(BusinessParty party) {
		if(isInvoiceType) {
			invoice.setTaxRepresentativeParty((PartyType)party);
		} else {
			creditNote.setTaxRepresentativeParty((PartyType)party);
		}
	}
	
	public BusinessParty getTaxRepresentative() {
		PartyType party = isInvoiceType ? invoice.getTaxRepresentativeParty() : creditNote.getTaxRepresentativeParty();
		return party==null ? null : new Party(party);
	}
	
	// BG-13 + 0..1 DELIVERY INFORMATION
/* Testdaten                                  01.02a-INVOICE_ubl.xml - nur cbc:ActualDeliveryDate
 *                                            01.05a-INVOICE_ubl.xml - cac:DeliveryLocation + DeliveryParty
 *                                            01.06a-INVOICE_ubl.xml 
 *                                            01.10a-INVOICE_ubl.xml
 *                                            01.14a-INVOICE_ubl.xml
  <cac:Delivery>
    <!-- Details zur Lieferung -->
    <!-- Delivery details -->
    <cbc:ActualDeliveryDate>2012-11-18</cbc:ActualDeliveryDate>
    <cac:DeliveryLocation>
      <cac:Address>
        <cbc:StreetName>Hintere Zollamtsstraße</cbc:StreetName>
        <cbc:BuildingNumber>4</cbc:BuildingNumber>
        <cbc:CityName>Wien</cbc:CityName>
        <cbc:PostalZone>1030</cbc:PostalZone>
        <cac:Country>
          <cbc:IdentificationCode>AT</cbc:IdentificationCode>
        </cac:Country>
      </cac:Address>
    </cac:DeliveryLocation>
  </cac:Delivery>
*/
	public List<DeliveryType> addDelivery(Delivery delivery) {
		List<DeliveryType> deliveryList;
		if(isInvoiceType) {
			deliveryList = invoice.getDelivery();
		} else {
			deliveryList = creditNote.getDelivery();
		}
		deliveryList.add(delivery);
		return deliveryList;
	}
	public List<DeliveryType> addDelivery(List<Delivery> deliveryList) {
		deliveryList.forEach(delivery -> {
			this.addDelivery(delivery);
		});
		if(isInvoiceType) {
			return invoice.getDelivery();
		} else {
			return creditNote.getDelivery();
		}
	}

	public List<Delivery> getDeliveries() {
		List<DeliveryType> deliveryList = isInvoiceType ? invoice.getDelivery() : creditNote.getDelivery();
		List<Delivery> result = new ArrayList<Delivery>(deliveryList.size());
		deliveryList.forEach(delivery -> {
			result.add(new Delivery(delivery));
		});
		return result;
	}
	
	// BG-14 ++ 0..1 INVOICING PERIOD
	// BG-14.BT-73 +++ 0..1 Invoicing period start date
//	@Override
	public void setStartDate(String ymd) {	
		setStartDate(DateTimeFormats.ymdToTs(ymd));
	}
//	@Override
	public void setStartDate(Timestamp ts) {
		StartDateType date = new StartDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		PeriodType period = new PeriodType();
		period.setStartDate(date);
		if(isInvoiceType) {
			invoice.getInvoicePeriod().add(period);
		} else {
			creditNote.getInvoicePeriod().add(period);
		}
	}
	
//	@Override
	public Timestamp getStartDateAsTimestamp() {
		List<PeriodType> list = isInvoiceType ? invoice.getInvoicePeriod() : creditNote.getInvoicePeriod();
		if(list.isEmpty()) return null;
		DateType date = (DateType)list.get(0).getStartDate();
		return DateTimeFormats.xmlGregorianCalendarToTs(date.getValue());
	}
	
	// BG-14.BT-74 +++ 0..1 Invoicing period end date
//	@Override
	public void setEndDate(String ymd) {	
		setEndDate(DateTimeFormats.ymdToTs(ymd));
	}
//	@Override
	public void setEndDate(Timestamp ts) {
		EndDateType date = new EndDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		PeriodType period = new PeriodType();
		period.setEndDate(date);
		if(isInvoiceType) {
			invoice.getInvoicePeriod().add(period);
		} else {
			creditNote.getInvoicePeriod().add(period);
		}
	}
	
//	@Override
	public Timestamp getEndDateAsTimestamp() {
		List<PeriodType> list = isInvoiceType ? invoice.getInvoicePeriod() : creditNote.getInvoicePeriod();
		if(list.isEmpty()) return null;
		DateType date = (DateType)list.get(0).getEndDate();
		return DateTimeFormats.xmlGregorianCalendarToTs(date.getValue());
	}
	
	// BG-16 + 0..1 PAYMENT INSTRUCTIONS
	// BG-16.BT-81 ++ 1..1 Payment means type code
	// BG-16.BT-82 ++ 0..1 Payment means text
	// BG-16.BT-83 ++ 0..1 Remittance information
	// BG-16.BG-17 ++ 0..n CREDIT TRANSFER
	// BG-16.BG-18 ++ 0..1 PAYMENT CARD INFORMATION
	// BG-16.BG-19 ++ 0..1 DIRECT DEBIT
	public void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, CreditTransfer creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		List<CreditTransfer> ctList = new ArrayList<CreditTransfer>();
		if(creditTransfer!=null) ctList.add(creditTransfer);
		setPaymentInstructions(code, paymentMeansText, remittanceInformation, ctList, paymentCard, directDebit);
	}
	public void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransferList, PaymentCard paymentCard, DirectDebit directDebit) {
		// TODO in ubl gibt ex keine List<CreditTransfer> !!! ABER mehrere PaymentMeans , siehe pepol
		PaymentMeansType paymentMeans = new PaymentMeans(code, paymentMeansText, remittanceInformation, creditTransferList, paymentCard, directDebit);
		if(isInvoiceType) {
			invoice.getPaymentMeans().add(paymentMeans);
		} else {
			creditNote.getPaymentMeans().add(paymentMeans);
		}
	}

	PaymentMeansType getPaymentMeans0() {
		List<PaymentMeansType> list = isInvoiceType ? invoice.getPaymentMeans() : creditNote.getPaymentMeans();
		if(list.isEmpty()) return null;
		LOG.info("PaymentMeans.Class:"+list.get(0).getClass());
		return list.get(0);
	}
	
	// TODO umbenennen in getPaymentMeansCode, bzw PaymentMeans.getPaymentMeansEnum()
	public PaymentMeansEnum getPaymentMeansEnum() {
		PaymentMeansType pm = getPaymentMeans0();
		if(pm==null) return null;
		return PaymentMeans.getPaymentMeansEnum(pm);
	}
	
	// BG-16.BT-82 ++ 0..1 Payment means text , TODO PaymentMeans.getPaymentMeansText()
	public String getPaymentMeansText() {
		PaymentMeansType pm = getPaymentMeans0();
		if(pm==null) return null;
//		return pm.getID()==null ? null : pm.getID().getValue(); // nein, siehe Bsp: ubl-tc434-example5.xml
		List<InstructionNoteType> inList = pm.getInstructionNote();
		if(inList.isEmpty()) return null;
		return inList.get(0).getValue();
	}
	
	// BG-16.BT-83 ++ 0..1 Remittance information , siehe PaymentMeans.getPaymentRemittanceInformation()
	public String getPaymentRemittanceInformation() {
		PaymentMeansType pm = getPaymentMeans0();
		if(pm==null) return null;
		return pm.getPaymentID().isEmpty() ? null : pm.getPaymentID().get(0).getValue();
	}
	
	public List<CreditTransfer> getCreditTransfer() {
//		List<PaymentMeansType> list = isInvoiceType ? invoice.getPaymentMeans() : creditNote.getPaymentMeans();
//		if(list.isEmpty()) return null;
//		LOG.info("PaymentMeans.Class:"+list.get(0).getClass());
		PaymentMeansType pm = getPaymentMeans0();
		if(pm==null) return null;
		PaymentMeans paymentMeans = new PaymentMeans(pm);
		return paymentMeans.getCreditTransfer();
	}

	// TODO getPaymentCard
	/*  die factories hier und nicht in class FinancialAccount
	 */
	@Override
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		return new FinancialAccount(iban, accountName, bic);
	}

	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
		return new FinancialAccount(accountId, accountName, bic);
	}

	@Override
	public PaymentCard createPaymentCard(String cardAccountID, String cardHolderName) {
		LOG.warning(NOT_IMPEMENTED); // TODO
		return null;
	}
	
	// BG-16.BG-19 ++ 0..1 DIRECT DEBIT
	@Override
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, IBANId iban) {
		return PaymentMandate.createDirectDebit(mandateID, bankAssignedCreditorID, iban);
	}

	@Override
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, String debitedAccountID) {
		return PaymentMandate.createDirectDebit(mandateID, bankAssignedCreditorID, debitedAccountID);
	}

	public DirectDebit getDirectDebit() {
		PaymentMeansType pm = getPaymentMeans0();
		if(pm==null) return null;
		PaymentMeans paymentMeans = new PaymentMeans(pm);
		return paymentMeans.getDirectDebit();
	}
	
	// BG-20 + 0..n DOCUMENT LEVEL ALLOWANCES                          TODO
	public void setDocumentLevelAllowence(Object todo) {
		LOG.warning(NOT_IMPEMENTED);
	}

	// BG-21 + 0..n DOCUMENT LEVEL CHARGES                             TODO
	public void setDocumentLevelCharges(Object todo) {
		LOG.warning(NOT_IMPEMENTED);
	}
	
	// BG-22 + 1..1 DOCUMENT TOTALS
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
		
		if(isInvoiceType) {
			invoice.setLegalMonetaryTotal(monetaryTotal);
		} else {
			creditNote.setLegalMonetaryTotal(monetaryTotal);
		}
	}

	// BG-22.BT-106 ++ 1..1 Sum of Invoice line net amount
	@Override
	public Amount getInvoiceLineNetTotal() {
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		return getInvoiceLineNetTotal(monetaryTotal);
	}
	private static Amount getInvoiceLineNetTotal(MonetaryTotalType monetaryTotal) {
		LineExtensionAmountType amount = monetaryTotal.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	@Override
	public void setAllowancesTotal(Amount taxTotalAmount) {
		// TODO Summe aller in der Rechnung enthaltenen Nachlässe der Dokumentenebene.
	}

	@Override
	public void setChargesTotal(Amount taxTotalAmount) {
		// TODO Summe aller in der Rechnung enthaltenen Abgaben der Dokumentenebene.
	}

	// BG-22.BT-109 ++ 1..1 Invoice total amount without VAT
	@Override
	public Amount getInvoiceTotalTaxExclusive() {
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		return getInvoiceTotalTaxExclusive(monetaryTotal);
	}
	private static Amount getInvoiceTotalTaxExclusive(MonetaryTotalType monetaryTotal) {
		TaxExclusiveAmountType amount = monetaryTotal.getTaxExclusiveAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	// BG-22.BT-110/BT-111
	@Override
	public void setInvoiceTax(Amount amount) {
		TaxAmountType taxAmount = new TaxAmountType();
		amount.copyTo(taxAmount);
		taxTotalFirst = getTaxTotalFirst();
		taxTotalFirst.setTaxAmount(taxAmount);
//		if(isInvoiceType) {
//			invoice.getTaxTotal().add(0, taxTotal);
//		} else {
//			creditNore.getTaxTotal().add(0, taxTotal);
//		}
	}

	TaxTotalType getTaxTotal(boolean sameCurrency) {
		List<TaxTotalType> list = isInvoiceType ? invoice.getTaxTotal() : creditNote.getTaxTotal();
		if(list.isEmpty()) return null;
		for(int i=0; i<list.size(); i++) {
			TaxTotalType taxTotal = list.get(i);
//			TaxAmountType amount = taxTotal.getTaxAmount();
			if(sameCurrency && (this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
//				LOG.info("i:"+i+"/"+list.size() + " sameCurrency "+ this.getDocumentCurrency()+"=?="+this.getTaxCurrency() + " amount:"+amount);
				return taxTotal;
			} else if(!sameCurrency && !(this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
//				LOG.info("i:"+i+"/"+list.size() + " !sameCurrency "+ this.getDocumentCurrency()+"=?="+this.getTaxCurrency());
				return taxTotal;
			}
		}
		return null;
	}
	Amount getInvoiceTax(boolean sameCurrency) {
		TaxTotalType taxTotal = getTaxTotal(sameCurrency);
		if(taxTotal==null) return null;
		TaxAmountType amount = taxTotal.getTaxAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}
	
	// BG-22.BT-110 ++ 0..1 Invoice total VAT amount
	// Der Gesamtbetrag der Umsatzsteuer für die Rechnung.
	@Override
	public Amount getInvoiceTax() {
		return getInvoiceTax(true);
	}
	
	// BG-22.BT-111 ++ 0..1 Invoice total VAT amount in accounting currency
	// Der Umsatzsteuergesamtbetrag, angegeben in der Abrechnungswährung, die im Land des Verkäufers gültig ist oder verlangt wird.
	// Zu verwenden, wenn der Code für die Währung der Umsatzsteuerbuchung (BT-6) nach Artikel 230 der Richtlinie 2006/112/EG über Umsatzsteuer 
	// vom Code für die Rechnungswährung (BT-5) abweicht.
	@Override
	public void setInvoiceTaxInAccountingCurrency(Amount amount) {
		// TODO assert
		if(this.getDocumentCurrency().equals(this.getTaxCurrency())) {
			LOG.warning("Document currency is "+getDocumentCurrency() + " equals to Tax Currency!");
		}
		setInvoiceTax(amount);		
	}

	@Override
	public Amount getInvoiceTaxInAccountingCurrency() {
		return getInvoiceTax(false);
	}

	// BG-22.BT-112 ++ 1..1 Invoice total amount with VAT
	@Override
	public Amount getInvoiceTotalTaxInclusive() {
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		return getInvoiceTotalTaxInclusive(monetaryTotal);
	}
	private static Amount getInvoiceTotalTaxInclusive(MonetaryTotalType monetaryTotal) {
		TaxInclusiveAmountType amount = monetaryTotal.getTaxInclusiveAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	@Override
	public void setPaid(Amount taxTotalAmount) {
		// TODO Summe bereits gezahlter Beträge.
	}
	
	@Override
	public void setRounding(Amount taxTotalAmount) {
		// TODO Der Betrag, um den der Rechnungsbetrag gerundet wurde.
	}

	// BG-22.BT-115 ++ 1..1 Amount due for payment
	@Override
	public Amount getDuePayable() {
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		return getDuePayable(monetaryTotal);
	}
	private static Amount getDuePayable(MonetaryTotalType monetaryTotal) {
		PayableAmountType amount = monetaryTotal.getPayableAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}

	private TaxTotalType taxTotalFirst = null;
	private TaxTotalType getTaxTotalFirst() {
		if(taxTotalFirst==null) {
			List<TaxTotalType> list;
			if(isInvoiceType) {
				list = invoice.getTaxTotal();
			} else {
				list = creditNote.getTaxTotal();
			}
//			taxTotalFirst = list.isEmpty() ? new TaxTotalType() : list.get(0);	
			if(list.isEmpty()) list.add(new TaxTotalType());
			taxTotalFirst = list.get(0);	
		}
		return taxTotalFirst;
	}
	
	// BG-23 + 1..n VAT BREAKDOWN
	public void addVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		TaxSubtotalType taxSubtotal = new VatBreakdown(taxableAmount, tax, taxCategoryCode, taxRate);
		
		taxTotalFirst = getTaxTotalFirst();
		taxTotalFirst.getTaxSubtotal().add(taxSubtotal);
//		
//		if(isInvoiceType) {
//			invoice.getTaxTotal().add(0, taxTotal);
//		} else {
//			creditNore.getTaxTotal().add(0, taxTotal);
//		}
	}

	@Override
	public void addVATBreakDown(CoreInvoiceVatBreakdown vatBreakdown) {
		taxTotalFirst = getTaxTotalFirst();
		taxTotalFirst.getTaxSubtotal().add((VatBreakdown)vatBreakdown);
	}
	public void addVATBreakDown(List<VatBreakdown> vatBreakdowns) {
		taxTotalFirst = getTaxTotalFirst();
//		LOG.info("anfügen #"+vatBreakdowns.size());
		vatBreakdowns.forEach(vbd -> {
			taxTotalFirst.getTaxSubtotal().add(vbd);
		});	
	}

	public List<VatBreakdown> getVATBreakDowns() {
		List<TaxTotalType> taxTotalList = isInvoiceType ? invoice.getTaxTotal() : creditNote.getTaxTotal();
		LOG.info("List<TaxTotalType> taxTotalList size="+taxTotalList.size());
		taxTotalFirst = getTaxTotalFirst();
		List<TaxSubtotalType> taxSuptotalList = taxTotalFirst.getTaxSubtotal();
		List<VatBreakdown> result = new ArrayList<VatBreakdown>(taxSuptotalList.size()); // VatBreakdown extends TaxSubtotalType
		taxSuptotalList.forEach(vbd -> {
			VatBreakdown taxSubtotal = new VatBreakdown(vbd);
			result.add(taxSubtotal);
		});	
		return result;
	}

	// BG-24 + 0..n ADDITIONAL SUPPORTING DOCUMENTS                     TODO
	public List<DocumentReferenceType> addAdditionalSupportingDocument(DocumentReferenceType asd) {
		List<DocumentReferenceType> documentReferenceList = getAdditionalSupportingDocuments();
		documentReferenceList.add(asd);
		return documentReferenceList;
	}
	
	public List<DocumentReferenceType> getAdditionalSupportingDocuments() {
		List<DocumentReferenceType> documentReferenceList;
		if(isInvoiceType) {
			documentReferenceList = invoice.getAdditionalDocumentReference();
		} else {
			documentReferenceList = creditNote.getAdditionalDocumentReference();
		}
		return documentReferenceList;
	}

	// BG-25 + 1..n INVOICE LINE
	@Override
	public void addLine(CoreInvoiceLine line) {
		if(line instanceof GenericLine<?>) {
			addLine((GenericLine<?>)line);
		}
	}

	void addLine(GenericLine<?> line) {
		if(isInvoiceType) {
			InvoiceLineType l = (InvoiceLineType)line.get();
			invoice.getInvoiceLine().add(l);
		} else {
			CreditNoteLineType l = (CreditNoteLineType)line.get();
			creditNote.getCreditNoteLine().add(l);
		}
	}
	
	public List<GenericLine<?>> getLines() {
		List<GenericLine<?>> resultLines;
		if(isInvoiceType) {
			List<InvoiceLineType> lines = invoice.getInvoiceLine();
			resultLines = new ArrayList<GenericLine<?>>(lines.size());
			lines.forEach(line -> {
				GenericLine<InvoiceLineType> gil = new GenericLine<InvoiceLineType>(line);
				resultLines.add(gil);
			});
		} else {
			List<CreditNoteLineType> lines = creditNote.getCreditNoteLine();
			resultLines = new ArrayList<GenericLine<?>>(lines.size());
			lines.forEach(line -> {
				GenericLine<CreditNoteLineType> gil = new GenericLine<CreditNoteLineType>(line);
				resultLines.add(gil);
			});
		}
		return resultLines;
	}

	// -------------------------------------------------------
	// BG-5 , BG-8 : POSTAL ADDRESS
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

	// BG-6 , BG-9 CONTACT
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

	// BG-4 , BG-7 , BG-10 , BG-11 , BG-13 : SELLER, BUYER, ...
	@Override
	public BusinessParty createParty(String name, PostalAddress address, IContact contact) {
		return new Party(name, address, contact); 
	}

	@Override
	public BusinessParty createParty(BusinessParty party) {
		return new Party((PartyType)party);
	}

}
