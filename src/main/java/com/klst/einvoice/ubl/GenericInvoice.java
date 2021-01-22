package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BG23_VatBreakdown;
import com.klst.einvoice.BG24_AdditionalSupportingDocs;
import com.klst.einvoice.BG4_Seller;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.IContact;
import com.klst.einvoice.Identifier;
import com.klst.einvoice.InvoiceNote;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.Reference;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ProjectReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuyerReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditNoteTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableRoundingAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrepaidAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SalesOrderIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxInclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxPointDateType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.DateType;

public class GenericInvoice <T> implements CoreInvoice  {

	private static final Logger LOG = Logger.getLogger(GenericInvoice.class.getName());
	
	private static final String NOT_IMPEMENTED = "NOT IMPEMENTED";
	
	T t;
	boolean isInvoiceType = false;
	InvoiceType invoice = null;
	CreditNoteType creditNote = null;
	
	// factory
	public static CoreInvoice createInvoice(String customization, String processType, DocumentNameCode code) {
		InvoiceType invoice = new InvoiceType();
		GenericInvoice<InvoiceType> gi = new GenericInvoice<InvoiceType>(invoice);
		gi.init(customization, processType, code);
		return gi;
	}
	// TODO createGenericInvoice
	public static CoreInvoice createCreditNote(String customization, String processType, DocumentNameCode code) {
		CreditNoteType cn = new CreditNoteType();
		GenericInvoice<CreditNoteType> gi = new GenericInvoice<CreditNoteType>(cn);
		gi.init(customization, processType, code);
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
		if(getId()!=null) LOG.config("copy ctor "+this);
	}
	
	public T get() {
		return this.t;
	}

	void init(String customization, String processType, DocumentNameCode code) {
		setProcessControl(customization, processType); // BG-2
		setTypeCode(code); // BT-3	
		LOG.config("ctor "+this);
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
			invoice.setID(new ID(id));
		} else {
			creditNote.setID(new ID(id));
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
		TaxCurrencyCodeType taxCurrencyCode = new TaxCurrencyCodeType();
		taxCurrencyCode.setValue(isoCurrencyCode);
//		PaymentCurrencyCodeType paymentCurrencyCode = new PaymentCurrencyCodeType();
//		paymentCurrencyCode.setValue(isoCurrencyCode); 
		if(isInvoiceType) {
			invoice.setTaxCurrencyCode(taxCurrencyCode);
//			invoice.setPaymentCurrencyCode(paymentCurrencyCode);
		} else {
			creditNote.setTaxCurrencyCode(taxCurrencyCode);
//			creditNote.setPaymentCurrencyCode(paymentCurrencyCode);
		}
	}
	
	@Override
	public String getTaxCurrency() {
//		PaymentCurrencyCodeType code = isInvoiceType ? invoice.getPaymentCurrencyCode() : creditNote.getPaymentCurrencyCode();
		TaxCurrencyCodeType code = isInvoiceType ? invoice.getTaxCurrencyCode() : creditNote.getTaxCurrencyCode();
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
		LOG.warning(NOT_IMPEMENTED); // in ubl nicht definiert
	}
	@Override
	public String getTaxPointDateCode() {
		LOG.warning(NOT_IMPEMENTED); // in ubl nicht definiert
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
	public void setProjectReference(Reference ref) {
		if(ref==null) return; // optional
		setProjectReference(ref.getID(), ref.getName());
	}
	@Override
	public void setProjectReference(String id) {
		setProjectReference(id, null);
	}
	@Override
	public void setProjectReference(String id, String name) { // Name wird nicht genutzt
		if(id==null) return; // optional
		ProjectReferenceType projectReference = new ProjectReferenceType();
		projectReference.setID(new ID(id));
		if(isInvoiceType) {
			invoice.getProjectReference().add(projectReference);
		} else {
			// undefined in creditNore
		}
	}

	@Override
	public Reference getProjectReference() {
		// creditNote.getProjectReference() undefined
		List<ProjectReferenceType> list = isInvoiceType ? invoice.getProjectReference() : new ArrayList<ProjectReferenceType>();
		if(list.isEmpty()) return null; // wg. 0..1
		IDType id = list.get(0).getID();
		return new ID("", id.getValue());
	}
	
	// BT-12 + 0..1 Contract reference
/*
test daten in 03 06 08 15
CII: 01.03a-INVOICE_uncefact.xml :
            <ram:ContractReferencedDocument>
                <ram:IssuerAssignedID>CR987654</ram:IssuerAssignedID>
            </ram:ContractReferencedDocument>
CII: 02.01a-INVOICE_uncefact.xml :
            <ram:SellerOrderReferencedDocument>
                <ram:IssuerAssignedID>ABC123456789</ram:IssuerAssignedID> <!-- BT-14 + 0..1 Verkaufsauftragsreferenz -->
            </ram:SellerOrderReferencedDocument>
            <ram:BuyerOrderReferencedDocument>
                <ram:IssuerAssignedID>65002278</ram:IssuerAssignedID>     <!-- BT-13 + 0..1 Bestellreferenz -->
            </ram:BuyerOrderReferencedDocument>
            <ram:ContractReferencedDocument>
                <ram:IssuerAssignedID>0000000752</ram:IssuerAssignedID>   <!-- BT-12 + 0..1 Vertragsreferenz -->
            </ram:ContractReferencedDocument>
            ...
            <ram:AdditionalReferencedDocument>
                <ram:IssuerAssignedID>ANG987654321</ram:IssuerAssignedID> <!-- BT-17 -->
                <ram:TypeCode>50</ram:TypeCode>
            </ram:AdditionalReferencedDocument>
            <ram:AdditionalReferencedDocument>
                <ram:IssuerAssignedID>Test</ram:IssuerAssignedID>         <!-- BT-18 eigentest -->
                <ram:TypeCode>130</ram:TypeCode>
                <ram:ReferenceTypeCode>AAA</ram:ReferenceTypeCode>
            </ram:AdditionalReferencedDocument>
            
UBL: 
    <cac:ContractDocumentReference>
        <cbc:ID>CR987654</cbc:ID>
    </cac:ContractDocumentReference>
    
  <cac:OrderReference>
    <cbc:ID>65002278</cbc:ID>                          <!-- BT-13 + 0..1 -->
    <cbc:SalesOrderID>ABC123456789</cbc:SalesOrderID>  <!-- BT-14 + 0..1 -->
  </cac:OrderReference>
  <cac:OriginatorDocumentReference>
    <cbc:ID>ANG987654321</cbc:ID>                      <!-- BT-17 -->
  </cac:OriginatorDocumentReference>
  <cac:ContractDocumentReference>
    <cbc:ID>0000000752</cbc:ID>                        <!-- BT-12 + 0..1 -->
  </cac:ContractDocumentReference>

 */
	@Override
	public void setContractReference(String id) {
		if(id==null) return; // optional
		DocumentReferenceType reference = new DocumentReferenceType();
		reference.setID(new ID(id));
		if(isInvoiceType) {
			invoice.getContractDocumentReference().add(reference);
		} else {
			creditNote.getContractDocumentReference().add(reference);
		}
	}

	@Override
	public String getContractReference() {
		List<DocumentReferenceType> list = isInvoiceType ? invoice.getContractDocumentReference() : creditNote.getContractDocumentReference();
		return list.isEmpty() ? null : list.get(0).getID().getValue(); // wg. 0..1
	}

	private void setOrderReference(OrderReferenceType orderReference, ID id, SalesOrderIDType salesOrderID) {
		if(id==null && salesOrderID==null) return;
		if(orderReference==null) orderReference = new OrderReferenceType();
		if(id!=null) orderReference.setID(id);
		if(salesOrderID!=null) orderReference.setSalesOrderID(salesOrderID);
		
		if(isInvoiceType) {
			invoice.setOrderReference(orderReference);
		} else {
			creditNote.setOrderReference(orderReference);
		}
	}

	// BT-13 + 0..1 Purchase order reference
	@Override
	public void setPurchaseOrderReference(String docRefId) {
		if(docRefId==null) return; // optional
		setOrderReference(isInvoiceType? invoice.getOrderReference() : creditNote.getOrderReference(), new ID(docRefId), null);
	}
	@Override
	public String getPurchaseOrderReference() {
		OrderReferenceType orderRef = isInvoiceType ? invoice.getOrderReference() : creditNote.getOrderReference();
		if(orderRef==null) return null;
		return orderRef.getID().getValue();
	}
	
	// BT-14 + 0..1 Sales order reference
	@Override
	public void setOrderReference(String docRefId) {
		if(docRefId==null) return; // optional
		SalesOrderIDType salesOrderID = new SalesOrderIDType();
		salesOrderID.setValue(docRefId);
		setOrderReference(isInvoiceType? invoice.getOrderReference() : creditNote.getOrderReference(), null, salesOrderID);
	}

	@Override
	public String getOrderReference() {
		OrderReferenceType orderRef = isInvoiceType ? invoice.getOrderReference() : creditNote.getOrderReference();
		if(orderRef==null) return null;
		return orderRef.getSalesOrderID()==null? null : orderRef.getSalesOrderID().getValue();
	}

	// BT-15 + 0..1 Receiving advice reference / Referenz auf die Wareneingangsmeldung
	@Override
	public void setReceiptReference(String docRefId) {
		if(docRefId==null) return; // optional
		DocumentReferenceType documentReference = new DocumentReferenceType();
		documentReference.setID(new ID(docRefId));
		List<DocumentReferenceType> documentReferenceList = isInvoiceType ? invoice.getReceiptDocumentReference() : creditNote.getReceiptDocumentReference();
		documentReferenceList.add(documentReference);
	}

	@Override
	public String getReceiptReference() {
		List<DocumentReferenceType> documentReferenceList = isInvoiceType ? invoice.getReceiptDocumentReference() : creditNote.getReceiptDocumentReference();
		if(documentReferenceList.isEmpty()) return null;
		return documentReferenceList.get(0).getID().getValue();
	}
	
	// BT-16 + 0..1 Despatch advice reference / Lieferavisreferenz
	@Override
	public void setDespatchAdviceReference(String docRefId) {
		if(docRefId==null) return; // optional
		DocumentReferenceType documentReference = new DocumentReferenceType();
		documentReference.setID(new ID(docRefId));
		List<DocumentReferenceType> documentReferenceList = isInvoiceType ? invoice.getDespatchDocumentReference() : creditNote.getDespatchDocumentReference();
		documentReferenceList.add(documentReference);
	}

	@Override
	public String getDespatchAdviceReference() {
		List<DocumentReferenceType> documentReferenceList = isInvoiceType ? invoice.getDespatchDocumentReference() : creditNote.getDespatchDocumentReference();
		if(documentReferenceList.isEmpty()) return null;
		return documentReferenceList.get(0).getID().getValue();
	}
	
	// BT-17 + 0..1 Tender or lot reference
	@Override
	public void setTenderOrLotReference(String docRefId) {
		if(docRefId==null) return; // optional
		DocumentReferenceType documentReference = new DocumentReferenceType();
		documentReference.setID(new ID(docRefId));
		List<DocumentReferenceType> documentReferenceList = isInvoiceType ? invoice.getOriginatorDocumentReference() : creditNote.getOriginatorDocumentReference();
		documentReferenceList.add(documentReference);
	}

	@Override
	public String getTenderOrLotReference() {
		List<DocumentReferenceType> documentReferenceList = isInvoiceType ? invoice.getOriginatorDocumentReference() : creditNote.getOriginatorDocumentReference();
		if(documentReferenceList.isEmpty()) return null;
		return documentReferenceList.get(0).getID().getValue();
	}
	
	// BT-18 + 0..1 Invoiced object identifier
	@Override
	public void setInvoicedObject(String name, String schemeID) {
		LOG.warning(NOT_IMPEMENTED); // TODO
	}
	@Override
	public void setInvoicedObjectIdentifier(Identifier id) {
		LOG.warning(NOT_IMPEMENTED);
	}
	@Override
	public void setInvoicedObject(String name) {
		LOG.warning(NOT_IMPEMENTED);
	}
	@Override
	public String getInvoicedObject() {
		LOG.warning(NOT_IMPEMENTED);
		return null;
	}
	@Override
	public Identifier getInvoicedObjectIdentifier() {
		LOG.warning(NOT_IMPEMENTED);
		return null;
	}
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
	// factory methods
	@Override
	public InvoiceNote createNote(String subjectCode, String content) {
		// delegieren:
		return Note.create(subjectCode, content);
	}
	@Override
	public InvoiceNote createNote(String content) {
		return createNote(null, content);
	}
	
	@Override
	public void addNote(InvoiceNote note) {
		if(note==null) return; // optional
		if(isInvoiceType) {
			invoice.getNote().add((NoteType)note);
		} else {
			creditNote.getNote().add((NoteType)note);
		}
	}
	@Override
	public void addNote(String subjectCode, String content) {
		addNote(createNote(subjectCode, content));
	}
	@Override
	public void addNote(String content) {
		addNote(createNote(content));
	}

	@Deprecated
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
	@Deprecated
	@Override
	public void setNote(String content) {
		setNote(null, content);
	}

	// ersetzt List<Object> getNotes()
	@Override
	public List<InvoiceNote> getInvoiceNotes() {
		// delegieren:
		return isInvoiceType ? Note.getInvoiceNotes(invoice) : Note.getInvoiceNotes(creditNote);
	}
	@Deprecated
	@Override
	public List<Object> getNotes() {
		List<NoteType> list = isInvoiceType ? invoice.getNote() : creditNote.getNote();
		List<Object> res = new ArrayList<Object>(list.size());
		list.forEach(note -> res.add(note));
		return res;
	}

	// BG-2 + 1..1 PROCESS CONTROL
	// BG-2.BT-23 ++ 0..1 Business process type / aka UBL profile
	// BG-2.BT-24 ++ 1..1 Specification identifier / aka Customization
	void setProcessControl(String customization, String profile) {
		CustomizationIDType customizationID = new CustomizationIDType();
		customizationID.setValue(customization);
		
		if(isInvoiceType) {
			invoice.setCustomizationID(customizationID);
		} else {
			creditNote.setCustomizationID(customizationID);
		}
		
		if(profile!=null) {
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
		LOG.config("SchemeAgencyID:"+customizationID.getSchemeAgencyID() +
				" SchemeAgencyName:"+customizationID.getSchemeAgencyName() +
				" Value:"+customizationID.getValue()
				);
		return customizationID.getValue();
	}

	// BG-2.BT-23 ++ 0..1 Business process type
	@Override
	public String getProcessType() {
		// Test in 02.01a
		ProfileIDType profileID = isInvoiceType ? invoice.getProfileID() : creditNote.getProfileID();
		return profileID==null ? null : profileID.getValue();
	}
	@Deprecated
	public String getProfile() {
		return getProcessType();
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
	@Override
	public void setSeller(String name, PostalAddress address, IContact contact, String companyId, String companyLegalForm) {
		BusinessParty party = createParty(name, address, contact); 
		party.setCompanyId(companyId);
		party.setCompanyLegalForm(companyLegalForm);
		setSeller(party);
	}
	@Override
	public void setSeller(BusinessParty party) {
		SupplierPartyType supplierParty = new SupplierPartyType();
		supplierParty.setParty((PartyType) party);
		if(isInvoiceType) {
			invoice.setAccountingSupplierParty(supplierParty);
		} else {
			creditNote.setAccountingSupplierParty(supplierParty);
		}
	}
	
	@Override
	public BG4_Seller getSeller() {
		SupplierPartyType supplierParty = isInvoiceType ? invoice.getAccountingSupplierParty() : creditNote.getAccountingSupplierParty();
		return supplierParty==null ? null : new Party(supplierParty.getParty());
	}
	
	// BG-7 + 1..1 BUYER
	@Override
	public void setBuyer(String name, PostalAddress address, IContact contact) {
		BusinessParty party = createParty(name, address, contact); 
		setBuyer(party);
	}
	@Override
	public void setBuyer(BusinessParty party) {
		CustomerPartyType customerparty = new CustomerPartyType();
		customerparty.setParty((PartyType)party);
		if(isInvoiceType) {
			invoice.setAccountingCustomerParty(customerparty);
		} else {
			creditNote.setAccountingCustomerParty(customerparty);
		}
	}
	
	@Override
	public BG7_Buyer getBuyer() {
		CustomerPartyType customerparty = isInvoiceType ? invoice.getAccountingCustomerParty() : creditNote.getAccountingCustomerParty();
		if(customerparty==null) return null;
		Party buyer = new Party(customerparty.getParty());
		// BG-7.BT-46 0..1 Buyer identifier                    + 0..1 Scheme identifier
		// BG-7.BT-47 0..1 Buyer legal registration identifier + 0..1 Scheme identifier
		List<PartyLegalEntityType> partyLegalEntityList = customerparty.getParty().getPartyLegalEntity();
		if(!partyLegalEntityList.isEmpty()) {
			CompanyIDType companyID = partyLegalEntityList.get(0).getCompanyID();
			if(companyID!=null) {
				LOG.fine("BG7_Buyer companyID="+companyID.getValue() + " SchemeID="+companyID.getSchemeID());
			}
		}
		
		return buyer;
	}
	
	// BG-10 + 0..1 PAYEE
	@Override
	public void setPayee(String businessName, String id, String companyId) {
		BusinessParty party = createParty(null, businessName, null, null);
		party.setId(id);
		party.setCompanyId(companyId);
		setPayee(party);
	}
	@Override
	public void setPayee(BusinessParty party) {
		if(isInvoiceType) {
			invoice.setPayeeParty((PartyType)party);
		} else {
			creditNote.setPayeeParty((PartyType)party);
		}
	}
	
	@Override
	public BusinessParty getPayee() {
		PartyType party = isInvoiceType ? invoice.getPayeeParty() : creditNote.getPayeeParty();
		return party==null ? null : new Party(party);
	}

	// BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY
	@Override
	public void setTaxRepresentative(String registrationName, PostalAddress address, String taxRegistrationName, String taxRegistrationSchemaID) {
		BusinessParty party = createParty(registrationName, address, null);
		party.addTaxRegistrationId(taxRegistrationName, taxRegistrationSchemaID);
		setTaxRepresentative(party);
	}
	@Override
	public void setTaxRepresentative(BusinessParty party) {
		if(isInvoiceType) {
			invoice.setTaxRepresentativeParty((PartyType)party);
		} else {
			creditNote.setTaxRepresentativeParty((PartyType)party);
		}
	}
	
	@Override
	public BusinessParty getTaxRepresentative() {
		PartyType party = isInvoiceType ? invoice.getTaxRepresentativeParty() : creditNote.getTaxRepresentativeParty();
		return party==null ? null : new Party(party);
	}
	
	// BG-13 + 0..1 DELIVERY INFORMATION
	public void setDelivery(String name, Timestamp ts, PostalAddress address, String locationId, String schemeId) {
		Delivery delivery = new Delivery(name, ts, address, locationId); // TODO für schemeId fehlen Beispiele
		setDelivery(delivery);
	}
	@Override
	public void setDelivery(BG13_DeliveryInformation delivery) {
		List<DeliveryType> deliveryList;
		if(isInvoiceType) {
			deliveryList = invoice.getDelivery();
		} else {
			deliveryList = creditNote.getDelivery();
		}
		deliveryList.add((DeliveryType) delivery);
	}

	@Override
	public BG13_DeliveryInformation getDelivery() {
		List<DeliveryType> deliveryList = isInvoiceType ? invoice.getDelivery() : creditNote.getDelivery();
		if(deliveryList.isEmpty()) return null;
		return new Delivery(deliveryList.get(0));
	}

	// BG-14 ++ 0..1 INVOICING PERIOD
	List<PeriodType> periodList = null;
	PeriodType getPeriod0() {
		if(periodList==null) {
			periodList = isInvoiceType ? invoice.getInvoicePeriod() : creditNote.getInvoicePeriod();
			if(periodList.isEmpty()) {
				LOG.fine("BG-14 0..1 INVOICING PERIOD isEmpty");
				PeriodType period = new PeriodType();
				periodList.add(period);
			}
		} 
		return periodList.get(0);
	}
	// BG-14.BT-73 +++ 0..1 Invoicing period start date
	@Override
	public void setStartDate(String ymd) {	
		setStartDate(DateTimeFormats.ymdToTs(ymd));
	}
	@Override
	public void setStartDate(Timestamp ts) {
		if(ts==null) return; // optional
		StartDateType date = new StartDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		PeriodType period = getPeriod0();
		period.setStartDate(date);
	}
	
	@Override
	public Timestamp getStartDateAsTimestamp() {
		List<PeriodType> list = isInvoiceType ? invoice.getInvoicePeriod() : creditNote.getInvoicePeriod();
		if(list.isEmpty()) return null;
		DateType date = (DateType)list.get(0).getStartDate();
		if(date==null) return null;
		return DateTimeFormats.xmlGregorianCalendarToTs(date.getValue());
	}
	
	// BG-14.BT-74 +++ 0..1 Invoicing period end date
	@Override
	public void setEndDate(String ymd) {	
		setEndDate(DateTimeFormats.ymdToTs(ymd));
	}
	@Override
	public void setEndDate(Timestamp ts) {
		if(ts==null) return; // optional
		EndDateType date = new EndDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		PeriodType period = getPeriod0();
		period.setEndDate(date);
	}
	
	@Override
	public Timestamp getEndDateAsTimestamp() {
		List<PeriodType> list = isInvoiceType ? invoice.getInvoicePeriod() : creditNote.getInvoicePeriod();
		if(list.isEmpty()) return null;
		DateType date = (DateType)list.get(0).getEndDate();
		if(date==null) return null;
		return DateTimeFormats.xmlGregorianCalendarToTs(date.getValue());
	}
	
	// BG-16 + 0..1 PAYMENT INSTRUCTIONS / Zahlungsanweisungen
	// factory delegate to PaymentMeans
	@Override
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransferList, PaymentCard paymentCard, DirectDebit directDebit) {

		LOG.info("creditTransferList:"+creditTransferList + " paymentCard:"+paymentCard + " directDebit:"+directDebit);	
		return PaymentMeans.create(code, paymentMeansText, remittanceInformation, creditTransferList, paymentCard, directDebit);
	}
	// BG-16.BT-81 ++ 1..1 Payment means type code
	// BG-16.BT-82 ++ 0..1 Payment means text
	// BG-16.BT-83 ++ 0..1 Remittance information
	// BG-16.BG-17 ++ 0..n CREDIT TRANSFER
	// BG-16.BG-18 ++ 0..1 PAYMENT CARD INFORMATION
	// BG-16.BG-19 ++ 0..1 DIRECT DEBIT
	@Override
	public void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransferList, PaymentCard paymentCard, DirectDebit directDebit) {
		
		PaymentMeansType paymentMeans 
		= new PaymentMeans(code, paymentMeansText, remittanceInformation, creditTransferList, paymentCard, directDebit);
		if(isInvoiceType) {
			invoice.getPaymentMeans().add(paymentMeans);
		} else {
			creditNote.getPaymentMeans().add(paymentMeans);
		}
	}

	@Override
	public void setPaymentInstructions(PaymentInstructions paymentInstructions) {
		PaymentMeans paymentMeans = (PaymentMeans)paymentInstructions;
		LOG.info("paymentMeans:"+paymentMeans);
		if(isInvoiceType) {
			if(paymentMeans.isCreditTransfer()) {
				paymentMeans.pmList.forEach(pm -> {
//					int i = paymentMeans.pmList.indexOf(pm);
//					LOG.info("i="+i +" add:"+((PaymentMeans)pm).getFinancialAccount());
					invoice.getPaymentMeans().add(pm);
				});
			} else { // assert paymentMeans==paymentMeans.pmList.get(0)
				invoice.getPaymentMeans().add(paymentMeans); 
			}
		} else {
			if(paymentMeans.isCreditTransfer()) {
				paymentMeans.pmList.forEach(pm -> {
					creditNote.getPaymentMeans().add(pm);
				});
			} else {
				creditNote.getPaymentMeans().add(paymentMeans); 
			}
		}
	}

	// BG-16 (DE CIUS mandatory) PAYMENT INSTRUCTIONS
	@Override
	public PaymentInstructions getPaymentInstructions() {
		List<PaymentMeansType> list = isInvoiceType ? invoice.getPaymentMeans() : creditNote.getPaymentMeans();
		if(list==null) return null;
		if(list.isEmpty()) return null;
		PaymentMeansType pm = (PaymentMeansType)(list.get(0));
		PaymentMeansEnum pmCode = PaymentMeans.getPaymentMeansEnum(pm);
		if(PaymentMeansEnum.isCreditTransfer(pmCode)) {
			return PaymentMeans.create(list); // BG-17
		} else if(PaymentMeansEnum.isBankCard(pmCode)) {
			PaymentMeans.create(pm); // BG-18
		} else if(PaymentMeansEnum.isDirectDebit(pmCode)) {
			PaymentMeans.create(pm); // BG-19
		}
		LOG.warning("BG-16 (DE CIUS mandatory) PAYMENT INSTRUCTIONS");
		return PaymentMeans.create(pm);
	}

	//  die factories sind in class FinancialAccount, aber ich brauche noch ein BG-16 PaymentInstructions
	@Override
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		FinancialAccount fa = new FinancialAccount(iban, accountName, bic);
		List<CreditTransfer> creditTransferList = new ArrayList<CreditTransfer>();
		creditTransferList.add(fa); // dieset fa hat kein pm!
		PaymentInstructions pi = getPaymentInstructions();
		if(pi==null) {
			pi = createPaymentInstructions(PaymentMeansEnum.SEPACreditTransfer, null, null, null, null, null);
			fa.paymentMeans = (PaymentMeans)pi;
		}
		((PaymentMeans)pi).addCreditTransfer(fa);
		this.setPaymentInstructions(pi);
		return fa;
	}
	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
		FinancialAccount fa = new FinancialAccount(accountId, accountName, bic);
		List<CreditTransfer> creditTransferList = new ArrayList<CreditTransfer>();
		creditTransferList.add(fa);
		PaymentInstructions pi = getPaymentInstructions();
		if(pi==null) {
			pi = createPaymentInstructions(PaymentMeansEnum.SEPACreditTransfer, null, null, null, null, null);
			fa.paymentMeans = (PaymentMeans)pi;
		}
		((PaymentMeans)pi).addCreditTransfer(fa);
		this.setPaymentInstructions(pi);
		return fa;
	}
	
	@Override // implements interface PaymentCardFactory
	public PaymentCard createPaymentCard(String cardAccountID, String cardHolderName) {
		return CardAccount.create(cardAccountID, cardHolderName);
	}
	
	// BG-16.BG-19 ++ 0..1 DIRECT DEBIT
	@Override
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, IBANId iban) {
		return PaymentMandate.create(mandateID, bankAssignedCreditorID, iban);
	}

	@Override
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, String debitedAccountID) {
		return PaymentMandate.create(mandateID, bankAssignedCreditorID, debitedAccountID);
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
	
	// BG-22.BT-107 ++ 0..1 Sum of all allowances on document level in the In.voice
	// Summe aller in der Rechnung enthaltenen Nachlässe der Dokumentenebene.
	@Override
	public void setAllowancesTotal(Amount allowancesTotalAmount) {
		if(allowancesTotalAmount==null) return;
		AllowanceTotalAmountType amount = new AllowanceTotalAmountType();
		allowancesTotalAmount.copyTo(amount);
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		monetaryTotal.setAllowanceTotalAmount(amount);
	}
	@Override
	public Amount getAllowancesTotal() {
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		return getAllowancesTotal(monetaryTotal);
	}
	private static Amount getAllowancesTotal(MonetaryTotalType monetaryTotal) {
		AllowanceTotalAmountType amount = monetaryTotal.getAllowanceTotalAmount();
		return amount==null? null : new Amount(amount.getCurrencyID(), amount.getValue());		
	}

	// BG-22.BT-108 ++ 0..1 Sum of all charges on document level in the Invoice
	// Summe aller in der Rechnung enthaltenen Abgaben der Dokumentenebene.
	@Override
	public void setChargesTotal(Amount chargesTotalAmount) {
		if(chargesTotalAmount==null) return;
 		ChargeTotalAmountType amount = new ChargeTotalAmountType();
		chargesTotalAmount.copyTo(amount);
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		monetaryTotal.setChargeTotalAmount(amount);
	}
	@Override
	public Amount getChargesTotal() {
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		return getChargesTotal(monetaryTotal);
	}
	private static Amount getChargesTotal(MonetaryTotalType monetaryTotal) {
		ChargeTotalAmountType amount = monetaryTotal.getChargeTotalAmount();
		return amount==null? null : new Amount(amount.getCurrencyID(), amount.getValue());		
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
	
	// 0..1 BG-22.BT-110/BT-111
	@Override
	public void setInvoiceTax(Amount amount) {
		TaxAmountType taxAmount = new TaxAmountType();
		amount.copyTo(taxAmount);
		taxTotalFirst = getTaxTotalFirst();
		taxTotalFirst.setTaxAmount(taxAmount);
	}

	TaxTotalType getTaxTotal(boolean sameCurrency) {
		List<TaxTotalType> list = isInvoiceType ? invoice.getTaxTotal() : creditNote.getTaxTotal();
		if(list.isEmpty()) return null;
		LOG.config("TaxTotal listsize="+list.size()+ " sameCurrency="+sameCurrency + " TaxCurrency="+getTaxCurrency() + " DocumentCurrency="+getDocumentCurrency());
		if(sameCurrency && (this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
			return list.get(0);
		} else if(!sameCurrency && !(this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
			return list.get(1);
		}
		
		return list.get(0);
	}
	Amount getInvoiceTax(boolean sameCurrency) {
		TaxTotalType taxTotal = getTaxTotal(sameCurrency);
		if(taxTotal==null) return null;
		TaxAmountType amount = taxTotal.getTaxAmount();
		return sameCurrency? new Amount(amount.getCurrencyID(), amount.getValue())
				: new Amount(this.getTaxCurrency(), amount.getValue());
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
		// als 2tes el hinzu:
		List<TaxTotalType> list;
		if(isInvoiceType) {
			list = invoice.getTaxTotal();
		} else {
			list = creditNote.getTaxTotal();
		}
		LOG.fine("***sollte 1 sein*** List<TaxTotalType> size="+list.size());
		if(list.size()==1) {
			TaxAmountType taxAmount = new TaxAmountType();
			amount.copyTo(taxAmount);
			TaxTotalType tt = new TaxTotalType();
			tt.setTaxAmount(taxAmount);
			list.add(tt);
		} else {
			LOG.warning("***nicht 1 !!!*** List<TaxTotalType> size="+list.size());			
		}
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
	
	// BG-22.BT-113 0..1 (optional) The sum of amounts which have been paid in advance.
	// Summe bereits gezahlter Beträge.
	@Override
	public Amount getPrepaid() {
		if(isInvoiceType) {
			MonetaryTotalType monetaryTotal = invoice.getLegalMonetaryTotal();
			return getPrepaidAmount(monetaryTotal);
		}
		return null;
	}
	private static Amount getPrepaidAmount(MonetaryTotalType monetaryTotal) {
		PrepaidAmountType amount = monetaryTotal.getPrepaidAmount();
		return amount==null? null : new Amount(amount.getCurrencyID(), amount.getValue());		
	}

	@Override
	public void setPrepaid(Amount amount) {
		if(amount==null) return;
		MonetaryTotalType monetaryTotal = invoice.getLegalMonetaryTotal();
		PrepaidAmountType prepaidAmount = new PrepaidAmountType();
		amount.copyTo(prepaidAmount);
		monetaryTotal.setPrepaidAmount(prepaidAmount);
	}
	
	// BG-22.BT-114 0..1 (optional) Rounding
	// Der Betrag, um den der Rechnungsbetrag gerundet wurde.
	@Override
	public Amount getRounding() {
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		return getRounding(monetaryTotal);
	}
	private static Amount getRounding(MonetaryTotalType monetaryTotal) {
		PayableRoundingAmountType amount = monetaryTotal.getPayableRoundingAmount();
		return amount==null? null : new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	@Override
	public void setRounding(Amount rounding) {
		if(rounding==null) return;
		PayableRoundingAmountType amount = new PayableRoundingAmountType();
		rounding.copyTo(amount);
		MonetaryTotalType monetaryTotal = isInvoiceType ? invoice.getLegalMonetaryTotal() : creditNote.getLegalMonetaryTotal();
		monetaryTotal.setPayableRoundingAmount(amount);
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
	
	// BG-20 + 0..n DOCUMENT LEVEL ALLOWANCES / ABSCHLÄGE
	// BG-21 + 0..n DOCUMENT LEVEL CHARGES / ZUSCHLÄGE
	@Override
	public void addAllowanceCharge(AllowancesAndCharges allowanceOrCharge) {
		if(isInvoiceType) {
			invoice.getAllowanceCharge().add((AllowanceChargeType)allowanceOrCharge);
		} else {
			creditNote.getAllowanceCharge().add((AllowanceChargeType)allowanceOrCharge);
		}
	}
	@Override
	public List<AllowancesAndCharges> getAllowancesAndCharges() {
		List<AllowanceChargeType> allowanceChargeList;
		if(isInvoiceType) {
			allowanceChargeList = invoice.getAllowanceCharge();
		} else {
			allowanceChargeList = creditNote.getAllowanceCharge();
		}
		List<AllowancesAndCharges> resList = new ArrayList<AllowancesAndCharges>(allowanceChargeList.size());
		allowanceChargeList.forEach(doc -> {
			resList.add(new AllowanceCharge(doc));
		});
		return resList;
	}

	@Override
	public BG23_VatBreakdown createVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode code, BigDecimal percent) {
		return new TaxSubtotal(taxableAmount, tax, code, percent);
	}

	// BG-23 + 1..n VAT BREAKDOWN
	public void addVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		TaxSubtotalType taxSubtotal = new TaxSubtotal(taxableAmount, tax, taxCategoryCode, taxRate);
		
		taxTotalFirst = getTaxTotalFirst();
		taxTotalFirst.getTaxSubtotal().add(taxSubtotal);
	}

	@Override
	public void addVATBreakDown(BG23_VatBreakdown vatBreakdown) {
		taxTotalFirst = getTaxTotalFirst();
		taxTotalFirst.getTaxSubtotal().add((TaxSubtotal)vatBreakdown);
	}
	public void addVATBreakDown(List<TaxSubtotal> vatBreakdowns) {
		taxTotalFirst = getTaxTotalFirst();
//		LOG.info("anfügen #"+vatBreakdowns.size());
		vatBreakdowns.forEach(vbd -> {
			taxTotalFirst.getTaxSubtotal().add(vbd);
		});	
	}

	public List<TaxSubtotal> getVATBreakDowns() {
		List<TaxTotalType> taxTotalList = isInvoiceType ? invoice.getTaxTotal() : creditNote.getTaxTotal();
		LOG.fine("List<TaxTotalType> taxTotalList size="+taxTotalList.size());
		taxTotalFirst = getTaxTotalFirst();
		List<TaxSubtotalType> taxSuptotalList = taxTotalFirst.getTaxSubtotal();
		List<TaxSubtotal> result = new ArrayList<TaxSubtotal>(taxSuptotalList.size()); // VatBreakdown extends TaxSubtotalType
		taxSuptotalList.forEach(vbd -> {
			TaxSubtotal taxSubtotal = new TaxSubtotal(vbd);
			result.add(taxSubtotal);
		});	
		return result;
	}

	// BG-24 + 0..n ADDITIONAL SUPPORTING DOCUMENTS
	@Override
	public void addSupportigDocument(String docRefId, String description, byte[] content, String mimeCode, String filename) {
		addSupportigDocument(new AdditionalSupportingDocument(docRefId, description, content, mimeCode, filename));
	}
	@Override
	public void addSupportigDocument(String docRefId, String description, String url) {
		if(docRefId!=null && description==null && url==null) {
			addOriginatorDocumentReference(new AdditionalSupportingDocument(docRefId, description, url));
		} else {
			addSupportigDocument(new AdditionalSupportingDocument(docRefId, description, url));
		}
	}
	void addSupportigDocument(AdditionalSupportingDocument asDoc) {
		if(isInvoiceType) {
			invoice.getAdditionalDocumentReference().add(asDoc);
		} else {
			creditNote.getAdditionalDocumentReference().add(asDoc);
		}
	}
	void addOriginatorDocumentReference(AdditionalSupportingDocument asDoc) {
		if(isInvoiceType) {
			invoice.getOriginatorDocumentReference().add(asDoc);
		} else {
			creditNote.getOriginatorDocumentReference().add(asDoc);
		}
	}

	@Override
	public List<BG24_AdditionalSupportingDocs> getAdditionalSupportingDocuments() {
		List<DocumentReferenceType> additionalDocumentReferenceList;
		if(isInvoiceType) {
			additionalDocumentReferenceList = invoice.getAdditionalDocumentReference();
		} else {
			additionalDocumentReferenceList = creditNote.getAdditionalDocumentReference();
		}
		List<BG24_AdditionalSupportingDocs> resList = new ArrayList<BG24_AdditionalSupportingDocs>(additionalDocumentReferenceList.size());
		additionalDocumentReferenceList.forEach(doc -> {
			resList.add(new AdditionalSupportingDocument(doc));
		});
		return resList;
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
	
	public List<CoreInvoiceLine> getLines() {
		List<CoreInvoiceLine> resultLines;
		if(isInvoiceType) {
			List<InvoiceLineType> lines = invoice.getInvoiceLine();
			resultLines = new ArrayList<CoreInvoiceLine>(lines.size());
			lines.forEach(line -> {
				GenericLine<InvoiceLineType> gil = new GenericLine<InvoiceLineType>(line);
				resultLines.add(gil);
			});
		} else {
			List<CreditNoteLineType> lines = creditNote.getCreditNoteLine();
			resultLines = new ArrayList<CoreInvoiceLine>(lines.size());
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
	public BusinessParty createParty(String name, String tradingName, PostalAddress address, IContact contact) {
		return new Party(name, tradingName, address, contact); 
	}

	@Override
	public BusinessParty createParty(BusinessParty party) {
		return new Party((PartyType)party);
	}

}
