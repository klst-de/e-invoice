package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.klst.edoc.api.BusinessParty;
import com.klst.edoc.api.ContactInfo;
import com.klst.edoc.api.IAmount;
import com.klst.edoc.api.IPeriod;
import com.klst.edoc.api.IQuantity;
import com.klst.edoc.api.Identifier;
import com.klst.edoc.api.PostalAddress;
import com.klst.edoc.api.Reference;
import com.klst.edoc.untdid.DateTimeFormats;
import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.edoc.untdid.PaymentMeansEnum;
import com.klst.edoc.untdid.TaxCategoryCode;
import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.InvoiceNote;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.PrecedingInvoice;
import com.klst.einvoice.SupportingDocument;
import com.klst.einvoice.VatBreakdown;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.BillingReferenceType;
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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AccountingCostType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuyerReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeTotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditNoteTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionCodeType;
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

public class GenericInvoice <T> implements CoreInvoice  {

	private static final Logger LOG = Logger.getLogger(GenericInvoice.class.getName());
	
	T t;
	boolean isInvoiceType = false;
	InvoiceType invoice = null;
	CreditNoteType creditNote = null;
	
	// factory
	public static CoreInvoice getFactory() {
		return new GenericInvoice<InvoiceType>((InvoiceType)null);
	}
	@Override
	public CoreInvoice createInvoice(String profile, String processType, DocumentNameCode code) {
		if(DocumentNameCode.CreditNote==code) {
			return createCreditNote(profile, processType, code);
		}
		return create(profile, processType, code);
	}
	@Override
	public CoreInvoiceLine createInvoiceLine(String id, IQuantity quantity, IAmount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent) {
		return GenericLine.create(this, id, (Quantity)quantity, (Amount)lineTotalAmount, priceAmount, itemName, codeEnum, percent);
//		if(isInvoiceType) {
//			return GenericLine.createIL(id, (Quantity)quantity, (Amount)lineTotalAmount, priceAmount, itemName, codeEnum, percent);
//		} else {
//			return GenericLine.createCNL(id, (Quantity)quantity, (Amount)lineTotalAmount, priceAmount, itemName, codeEnum, percent);
//		}
	}

	static CoreInvoice create(String profile, String processType, DocumentNameCode code) {
		InvoiceType invoice = new InvoiceType();
		GenericInvoice<InvoiceType> gi = new GenericInvoice<InvoiceType>(invoice);
		gi.init(profile, processType, code);
		return gi;
	}
	static CoreInvoice createCreditNote(String profile, String processType, DocumentNameCode code) {
		CreditNoteType cn = new CreditNoteType();
		GenericInvoice<CreditNoteType> gi = new GenericInvoice<CreditNoteType>(cn);
		gi.init(profile, processType, code);
		return gi;
	}
	
	// ctor mit type parameter
	public GenericInvoice(T t) {
		if(t!=null) {
			this.t = t;
			isInvoiceType = this.t instanceof InvoiceType;
			if(isInvoiceType) {
				invoice = (InvoiceType)t;
			} else {
				creditNote = (CreditNoteType)t;
			}
			if(getId()!=null) LOG.config("copy ctor "+this);
		}
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
		return isInvoiceType ? DocumentNameCode.valueOf(invoice.getInvoiceTypeCode())
				             : DocumentNameCode.valueOf(creditNote.getCreditNoteTypeCode());
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
		if(isInvoiceType) {
			invoice.setTaxCurrencyCode(taxCurrencyCode);
		} else {
			creditNote.setTaxCurrencyCode(taxCurrencyCode);
		}
	}
	
	@Override
	public String getTaxCurrency() {
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

	// BT-8 0..1 Value added tax point date code
	/* Folgende Codes aus der Codeliste UNTDID 2005 werden verwendet:
	 *   3 (Invoice document issue date time)
	 *  35 (Delivery date/time, actual)
	 * 432 (Paid to date)
	 * see a567a52 in ConnectingEurope/eInvoicing-EN16931
	 * 
	 * Das Informationselement „Value added tax point date code“ (BT-8) wird verwendet, 
	 * wenn das Informationselement „Value added tax point date“ (BT-7) zum Zeitpunkt der Rechnungsstellung noch nicht bekannt ist.
	 * Die Anwendung von BT-7 und 8 schließen sich gegenseitig aus.
	 * 
CII:
0 .. 1 DueDateTypeCode Code für das Datum der Steuerfälligkeit BT-8 Values: 5 29 72 aus UNTDID 2475
-  5: Ausstellungsdatum des Rechnungsbelegs
- 29: Liefertermin, Ist-Zustand
- 72: Bis heute bezahlt

	 */
	// In Deutschland ist das Liefer- und Leistungsdatum maßgebend (BT-72)
	// keine Beispiele in kosit
	@Override
	public void setTaxPointDateCode(String code) {
		if(code==null) return; // optional
		DescriptionCodeType descriptionCode = new DescriptionCodeType();
		descriptionCode.setValue(code);
		PeriodType period = getPeriod0();
		period.getDescriptionCode().add(descriptionCode);
	}
	@Override
	public String getTaxPointDateCode() {
		List<PeriodType> list = isInvoiceType ? invoice.getInvoicePeriod() : creditNote.getInvoicePeriod();
		if(list.isEmpty()) return null;
		List<DescriptionCodeType> dcList = list.get(0).getDescriptionCode();
		if(dcList.isEmpty()) return null;
		return dcList.get(0).getValue();
	}
	
	// BT-9 + 0..1 Payment due date
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
	
	// BT-17 0..1 Tender or lot reference
	@Override
	public void setTenderOrLotReference(String docRefId) {
		if(docRefId==null) return;
		addOriginatorDocumentReference(DocumentReference.create(docRefId, (String)null, null));
	}
	@Override
	public String getTenderOrLotReference() {
		List<DocumentReferenceType> additionalDocumentReferenceList;
		if(isInvoiceType) {
			additionalDocumentReferenceList = invoice.getOriginatorDocumentReference();
		} else {
			additionalDocumentReferenceList = creditNote.getOriginatorDocumentReference();
		}
		List<DocumentReference> resList = new ArrayList<DocumentReference>(additionalDocumentReferenceList.size());
		additionalDocumentReferenceList.forEach(doc -> {
			resList.add(DocumentReference.create(doc));
		});
		return resList.isEmpty() ? null : resList.get(0).getDocumentReference().getContent();	
	}
	
	// BT-18 0..1 Invoiced object identifier
	@Override
	public void setInvoicedObjectIdentifier(Identifier id) {
		if(id==null) return; // optional
		setInvoicedObject(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void setInvoicedObject(String name) {
		setInvoicedObject(name, null);
	}
	@Override
	public void setInvoicedObject(String name, String schemeID) {
		if(name==null) return;
		DocumentReference docRef = DocumentReference.create(name, DocumentNameCode.InvoicingDataSheet.getValueAsString(), schemeID);
		addSupportigDocument(docRef);
	}
	@Override
	public String getInvoicedObject() {
		Identifier id = getInvoicedObjectIdentifier();
		return id==null ? null : id.getContent();
	}
	@Override
	public Identifier getInvoicedObjectIdentifier() {
		List<DocumentReferenceType> additionalDocumentReferenceList;
		if(isInvoiceType) {
			additionalDocumentReferenceList = invoice.getAdditionalDocumentReference();
		} else {
			additionalDocumentReferenceList = creditNote.getAdditionalDocumentReference();
		}
		List<DocumentReference> resList = new ArrayList<DocumentReference>(additionalDocumentReferenceList.size());
		additionalDocumentReferenceList.forEach(doc -> {
			DocumentReference docRef = DocumentReference.create(doc);
			if(docRef.isInvoicingDataSheet()) {
				// das sind BT-18 docs
				resList.add(docRef);
			}
		});
		return resList.isEmpty() ? null : resList.get(0).getDocumentReference();
	}
	
	// BT-19 + 0..1 Buyer accounting reference
/* keine kosit Beispiele, dafür https://github.com/ConnectingEurope/eInvoicing-EN16931/issues/270

ubl-tc434-example2.xml :
    <cbc:AccountingCost>Project cost code 123</cbc:AccountingCost>

 */
	public void setBuyerAccountingReference(Reference reference) {
		if(reference==null) return;
		AccountingCostType accountingCost = new AccountingCostType();
		accountingCost.setValue(reference.getContent());
		if(isInvoiceType) {
			invoice.setAccountingCost(accountingCost);
		} else {
			creditNote.setAccountingCost(accountingCost);
		}
	}
	public Reference getBuyerAccountingReference() {
		AccountingCostType accountingCost = isInvoiceType ? invoice.getAccountingCost() : creditNote.getAccountingCost();
		return accountingCost==null ? null : new ID(accountingCost.getValue());
	}
	
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
	public void addNote(InvoiceNote note) {
		if(note==null) return; // optional
		if(isInvoiceType) {
			invoice.getNote().add((NoteType)note);
		} else {
			creditNote.getNote().add((NoteType)note);
		}
	}

	@Override
	public List<InvoiceNote> getInvoiceNotes() {
		// delegieren:
		return isInvoiceType ? Note.getInvoiceNotes(invoice.getNote()) : Note.getInvoiceNotes(creditNote.getNote());
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
		// Test in 02.01a, etwas verwirrend: UBL ProfileIDType enthält nicht BG2_ProcessControl.PROFILE_XXX
		ProfileIDType profileID = isInvoiceType ? invoice.getProfileID() : creditNote.getProfileID();
		return profileID==null ? null : profileID.getValue();
	}

	// BG-3 0..n PRECEDING INVOICE REFERENCE
	// BG-3.BT-25 1..1 Preceding Invoice reference
	// BG-3.BT-26 0..1 Preceding Invoice issue date
	
	// implements BG3_PrecedingInvoiceReference factory
	@Override
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		return DocumentReference.create(docRefId, ts);
	}
	@Override // add aka set
	public void addPrecedingInvoice(PrecedingInvoice precedingInvoice) {
		if(precedingInvoice==null) return;
		DocumentReferenceType docRef = (DocumentReference)precedingInvoice;
		BillingReferenceType billingReference = new BillingReferenceType();
		billingReference.setInvoiceDocumentReference(docRef);
		List<BillingReferenceType> billingReferenceList = isInvoiceType ? invoice.getBillingReference() : creditNote.getBillingReference();
		billingReferenceList.add(billingReference);
	}
	@Override // get
	public List<PrecedingInvoice> getPrecedingInvoices() {
		List<BillingReferenceType> billingReferenceList = isInvoiceType ? invoice.getBillingReference() : creditNote.getBillingReference();
		List<PrecedingInvoice> docRefList = new ArrayList<PrecedingInvoice>();
		billingReferenceList.forEach(billingRef -> {
			DocumentReferenceType docRef = billingRef.getInvoiceDocumentReference();
			docRefList.add(DocumentReference.create(docRef));
		});
		return docRefList;
	}

	
	// BG-4 + 1..1 SELLER
	@Override
	public void setSeller(String name, PostalAddress address, ContactInfo contact, String companyId, String companyLegalForm) {
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
	public BusinessParty getSeller() {
		SupplierPartyType supplierParty = isInvoiceType ? invoice.getAccountingSupplierParty() : creditNote.getAccountingSupplierParty();
		return supplierParty==null ? null : Party.create(supplierParty.getParty());
	}
	
	// BG-7 + 1..1 BUYER
	@Override
	public void setBuyer(String name, PostalAddress address, ContactInfo contact) {
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
	public BusinessParty getBuyer() {
		CustomerPartyType customerparty = isInvoiceType ? invoice.getAccountingCustomerParty() : creditNote.getAccountingCustomerParty();
		if(customerparty==null) return null;
		Party buyer = Party.create(customerparty.getParty());
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
		return party==null ? null : Party.create(party);
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
		return party==null ? null : Party.create(party);
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
		return Delivery.create(deliveryList.get(0));
	}

	// BG-14 0..1 INVOICING PERIOD
//	@Override // comment to show the java-doc
	/**
	 * factory method to create BG-14 INVOICING PERIOD
	 * 
	 * @param start - The initial date of delivery of goods or services.
	 * @param end - The date on which the delivery of goods or services was completed.
	 * @return IPeriod - aka delivery period
	 * 
	 * @see com.klst.einvoice.BG14_InvoicingPeriod
	 * @see com.klst.edoc.api.IPeriod
	 */
	public IPeriod createPeriod(Timestamp start, Timestamp end) {
		return Period.create(start, end);
	}
	private List<PeriodType> periodList = null;
	private PeriodType getPeriod0() {
		if(periodList==null) {
			periodList = isInvoiceType ? invoice.getInvoicePeriod() : creditNote.getInvoicePeriod();
			if(periodList.isEmpty()) {
				LOG.fine("BT-8 0..1 TaxPointDateCode / BG-14 0..1 INVOICING PERIOD isEmpty");
				PeriodType period = new PeriodType();
				periodList.add(period);
			}
		} 
		return periodList.get(0);
	}
	@Override
	public IPeriod getDeliveryPeriod() {
		return Period.create(getPeriod0());
	}
	@Override
	public void setDeliveryPeriod(IPeriod period) {
		setStartDate(period.getStartDateAsTimestamp());
		setEndDate(period.getEndDateAsTimestamp());
	}
	// BG-14.BT-73 0..1 Invoicing period start date
	private void setStartDate(Timestamp ts) {
		if(ts==null) return; // optional
		StartDateType date = new StartDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		PeriodType period = getPeriod0();
		period.setStartDate(date);
	}
	
	// BG-14.BT-74 0..1 Invoicing period end date
	private void setEndDate(Timestamp ts) {
		if(ts==null) return; // optional
		EndDateType date = new EndDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		PeriodType period = getPeriod0();
		period.setEndDate(date);
	}
	
	// BG-16 + 0..1 PAYMENT INSTRUCTIONS / Zahlungsanweisungen
	// factory delegate to PaymentMeans
	@Override
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransferList, PaymentCard paymentCard, DirectDebit directDebit) {

		LOG.config("creditTransferList:"+creditTransferList + " paymentCard:"+paymentCard + " directDebit:"+directDebit);	
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
		LOG.config("paymentMeans:"+paymentMeans);
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
// TODO	
//	private void mergePaymentInstructions(PaymentMeans pmToMerge) {
//		List<PaymentMeansType> list = isInvoiceType ? invoice.getPaymentMeans() : creditNote.getPaymentMeans();
//		if(list==null) return;
//		if(list.isEmpty()) return;
//		PaymentMeansType pm = (PaymentMeansType)(list.get(0));
//		PaymentMeansEnum pmCode = PaymentMeans.getPaymentMeansEnum(pm);
//		if(PaymentMeansEnum.isCreditTransfer(pmCode)) {
//			LOG.info("merge to "+list.size()+" elements paymentMeans:"+pmToMerge);
//			list.add(pmToMerge); // TODO funktioniert nicht richtig
//		}
//	}
	private void removePaymentInstructions() {
		List<PaymentMeansType> list = isInvoiceType ? invoice.getPaymentMeans() : creditNote.getPaymentMeans();
		if(list==null) return;
		if(list.isEmpty()) return;
		PaymentMeansType pm = (PaymentMeansType)(list.get(0));
		PaymentMeansEnum pmCode = PaymentMeans.getPaymentMeansEnum(pm);
		if(PaymentMeansEnum.isCreditTransfer(pmCode)) {
			LOG.info("remove "+list.size()+" paymentMeans:"+pmCode);
			list.clear();
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
		// create bei get? : wegen der 0..n Beziehung zwischen BG-16 und BG-17 in EN16931!
		// UBL kann nur 0..1 darstellen: set/get PayeeFinancialAccount
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
		creditTransferList.add(fa); // diese fa hat kein pm!
		PaymentInstructions pi = getPaymentInstructions();
		if(pi==null) {
			pi = createPaymentInstructions(bic==null? PaymentMeansEnum.CreditTransfer : PaymentMeansEnum.SEPACreditTransfer, null, null
					, creditTransferList, null, null);
			fa.paymentMeans = (PaymentMeans)pi;
		}
		((PaymentMeans)pi).addCreditTransfer(fa);
//		this.setPaymentInstructions(pi); // damit wird auch ein BG-16 PI erstellt
		return fa;
	}
	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
		FinancialAccount fa = new FinancialAccount(accountId, accountName, bic);
		List<CreditTransfer> creditTransferList = new ArrayList<CreditTransfer>();
		creditTransferList.add(fa);
		PaymentInstructions pi = getPaymentInstructions();
		if(pi==null) {
			pi = createPaymentInstructions(PaymentMeansEnum.CreditTransfer, null, null
					, creditTransferList, null, null);
			fa.paymentMeans = (PaymentMeans)pi;
		}
		((PaymentMeans)pi).addCreditTransfer(fa);
//		this.setPaymentInstructions(pi); // damit wird auch ein BG-16 PI erstellt
		return fa;
	}
	@Override
	public CreditTransfer addCreditTransfer(IBANId iban, String accountName, BICId bic) {
		PaymentMeansEnum code = bic==null ? PaymentMeansEnum.SEPACreditTransfer : PaymentMeansEnum.CreditTransfer;
		FinancialAccount fa = new FinancialAccount(iban, accountName, bic);
		return this.addFinancialAccount(fa, code);
	}
	@Override
	public CreditTransfer addCreditTransfer(String accountId, String accountName, BICId bic) {
		FinancialAccount fa = new FinancialAccount(accountId, accountName, bic);
		return this.addFinancialAccount(fa, PaymentMeansEnum.CreditTransfer);
	}
	private CreditTransfer addFinancialAccount(FinancialAccount fa, PaymentMeansEnum code) {
		// 3 Fälle:
		// - PI existiert nicht
		// - PI existiert , keine CTs
		// - PI existiert , mehrere CTs (z.B. 2 in 01.05a
		List<CreditTransfer> creditTransferList = new ArrayList<CreditTransfer>(Arrays.asList(fa));
		PaymentInstructions pi = getPaymentInstructions();
		if(pi==null) { // Fall 1
			pi = createPaymentInstructions(code, null, null, creditTransferList, null, null);
			fa.paymentMeans = (PaymentMeans)pi;
			((PaymentMeans)pi).addCreditTransfer(fa);
			this.setPaymentInstructions(pi);
			return fa;
		}
		
		if(pi.getCreditTransfer().isEmpty()) { // Fall 2
			LOG.warning("NO CreditTransfers in PaymentInstructions "+pi);
			// TODO wenn code OK fa einfügen
			return null;
		}

		PaymentInstructions newPi = null;
		if(pi.getPaymentMeansEnum()==code) { // Fall 3
			newPi = createPaymentInstructions(code, null, null, creditTransferList, null, null);
			fa.paymentMeans = (PaymentMeans)newPi;
			((PaymentMeans)newPi).pmList = ((PaymentMeans)pi).pmList;
			((PaymentMeans)newPi).addCreditTransfer(fa);
			LOG.info("FinancialAccount inserted into "+newPi);
			
			this.removePaymentInstructions();
			this.setPaymentInstructions(newPi);
//			this.mergePaymentInstructions((PaymentMeans)newPi); // TODO
			return fa;
		} else {
			LOG.warning("Cannot mix "+code+" Payment means type code with "+pi.getPaymentMeansEnum());
		}
		return null;
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

	// BG-20 + 0..n DOCUMENT LEVEL ALLOWANCES / ABSCHLÄGE
	// BG-21 + 0..n DOCUMENT LEVEL CHARGES / ZUSCHLÄGE
	@Override
	public AllowancesAndCharges createAllowance(Amount amount, Amount baseAmount, BigDecimal percentage) {
		return AllowanceCharge.create(AllowancesAndCharges.ALLOWANCE, amount, baseAmount, percentage);
	}
	@Override
	public AllowancesAndCharges createCharge(Amount amount, Amount baseAmount, BigDecimal percentage) {
		return AllowanceCharge.create(AllowancesAndCharges.CHARGE, amount, baseAmount, percentage);
	}

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
			resList.add(AllowanceCharge.create(doc));
		});
		return resList;
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
	
	@Override
	public VatBreakdown createVATBreakDown(IAmount taxableAmount, IAmount taxAmount, TaxCategoryCode code, BigDecimal percent) {
		return TaxSubtotal.create(taxableAmount, taxAmount, code, percent);
	}

	// BG-23 + 1..n VAT BREAKDOWN
	public void addVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		VatBreakdown taxSubtotal = createVATBreakDown(taxableAmount, tax, taxCategoryCode, taxRate);
		addVATBreakDown(taxSubtotal);
	}

	@Override
	public void addVATBreakDown(VatBreakdown vatBreakdown) {
		taxTotalFirst = getTaxTotalFirst();
		taxTotalFirst.getTaxSubtotal().add((TaxSubtotal)vatBreakdown);
	}

	public List<VatBreakdown> getVATBreakDowns() {
//		List<TaxTotalType> taxTotalList = isInvoiceType ? invoice.getTaxTotal() : creditNote.getTaxTotal();
		taxTotalFirst = getTaxTotalFirst();
		List<TaxSubtotalType> taxSuptotalList = taxTotalFirst.getTaxSubtotal();
		List<VatBreakdown> result = new ArrayList<VatBreakdown>(taxSuptotalList.size());
		taxSuptotalList.forEach(vbd -> {
			result.add(TaxSubtotal.create(vbd));
		});	
		return result;
	}

	// BG-24 0..n ADDITIONAL SUPPORTING DOCUMENTS
	@Override
	public SupportingDocument createSupportigDocument(String docRefId, Reference lineId, String description, Timestamp ts, String uri) {
		DocumentReference doc = DocumentReference.create(docRefId, lineId, description);
		doc.setExternalDocumentLocation(uri);
		return doc;
	}
	@Override
	public SupportingDocument createSupportigDocument(String docRefId, Reference lineId, String description, Timestamp ts
			, byte[] content, String mimeCode, String filename) {
		DocumentReference doc = DocumentReference.create(docRefId, lineId, description);
		doc.setAttachedDocument(content, mimeCode, filename);
		return doc;
	}
	@Override
	public void addSupportigDocument(SupportingDocument asDoc) {
		if(isInvoiceType) {
			invoice.getAdditionalDocumentReference().add((DocumentReference)asDoc);
		} else {
			creditNote.getAdditionalDocumentReference().add((DocumentReference)asDoc);
		}
	}
	private void addOriginatorDocumentReference(DocumentReference asDoc) {
		if(isInvoiceType) {
			invoice.getOriginatorDocumentReference().add(asDoc);
		} else {
			creditNote.getOriginatorDocumentReference().add(asDoc);
		}
	}

	@Override
	public List<SupportingDocument> getAdditionalSupportingDocuments() {
		List<DocumentReferenceType> additionalDocumentReferenceList;
		if(isInvoiceType) {
			additionalDocumentReferenceList = invoice.getAdditionalDocumentReference();
		} else {
			additionalDocumentReferenceList = creditNote.getAdditionalDocumentReference();
		}
		List<SupportingDocument> resList = new ArrayList<SupportingDocument>(additionalDocumentReferenceList.size());
		additionalDocumentReferenceList.forEach(doc -> {
			DocumentReference dr = DocumentReference.create(doc);
			if(dr.isValidatedPricedTender()) {
				// das sind BT-17 docs
			} else if(dr.isInvoicingDataSheet()) {
				// das sind BT-18 docs
			} else if(dr.isRelatedDocument()) {
				resList.add(dr);
			} else {
				resList.add(dr);
			}
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
				resultLines.add(new GenericLine<InvoiceLineType>(line));
			});
		} else {
			List<CreditNoteLineType> lines = creditNote.getCreditNoteLine();
			resultLines = new ArrayList<CoreInvoiceLine>(lines.size());
			lines.forEach(line -> {
				resultLines.add(new GenericLine<CreditNoteLineType>(line));
			});
		}
		return resultLines;
	}

	// ----------------- factories to delegate
	// BG-5 , BG-8 : POSTAL ADDRESS
	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		Party factory = Party.create();
		return factory.createAddress(countryCode, postalCode, city);
	}

	// BG-6 , BG-9 CONTACT
	@Override
	public ContactInfo createContactInfo(String contactName, String contactTel, String contactMail) {
		Party factory = Party.create();
		return factory.createContactInfo(contactName, contactTel, contactMail);
	}

	// BG-4 , BG-7 , BG-10 , BG-11 , BG-13 : SELLER, BUYER, ...
	@Override
	public BusinessParty createParty(String name, String tradingName, PostalAddress address, ContactInfo contact) {
		Party factory = Party.create();
		return factory.createParty(name, tradingName, address, contact);
	}

}
