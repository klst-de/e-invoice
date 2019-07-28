package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.DocumentTotals;
import com.klst.einvoice.IContact;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuyerReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
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
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

// subklassen: CommercialInvoice , Partial invoice , Corrected invoice , Self-billed invoice
// Credit note nicht weil es dafür ein extra ubl gibt: CreditNoteType
// Beispiel: https://www.erechnung.gv.at/files/xml/example-peppol-ubl.xml
//           https://www.erechnung.gv.at/files/xml/example-peppol-ubl-creditnote.xml
// Quelle: https://www.erechnung.gv.at/erb?p=info_download#tabs-tec
/*

Name                                        ID    Semantischer Datentyp Anz. 
Invoice number                              BT-1  Identifier            1 
Invoice issue date                          BT-2  Date                  1 
Invoice type code                           BT-3  Code                  1
Invoice currency code                       BT-5  Code                  1
VAT accounting currency code                BT-6  Code                  0..1
Value added tax point date                  BT-7  Date                  0..1
Value added tax point date code             BT-8  Code                  0..1
Payment due date                            BT-9  Date                  0..1
Buyer reference                             BT-10 Text                  1
...
INVOICE NOTE                                BG-1                        0..*
PROCESS CONTROL                             BG-2                        1
PRECEDING INVOICE REFERENCE                 BG-3                        0..*
SELLER                                      BG-4                        1
BUYER                                       BG-7                        1
...
PAYMENT INSTRUCTIONS                        BG-16                       1
DOCUMENT LEVEL ALLOWANCES                   BG-20                       0..*
Eine Gruppe von Informationselementen, die Informationen über Nachlässe liefern, die für die Rechnung als Ganzes gelten.
Anmerkung: Abzüge, wie z. B. einbehaltene Steuern, können auch in dieser Gruppe ausgewiesen werden.
DOCUMENT LEVEL CHARGES                      BG-21                       0..*
Eine Gruppe von Informationselementen, die Informationen über Kosten, Zuschläge, und Steuern – ausgenommen
die Umsatzsteuer – enthalten, die für die Rechnung als Ganzes gelten.
DOCUMENT TOTALS                             BG-22                       1
VAT BREAKDOWN                               BG-23                       1..*
ADDITIONAL SUPPORTING DOCUMENTS             BG-24                       0..*
Eine Gruppe von Informationselementen mit Informationen über rechnungsbegründende Unterlagen, 
die Belege für die in der Rechnung gestellten Ansprüche enthalten.
Anmerkung: Die Gruppe kann verwendet werden, um auf eine dem Erwerber bekannte Dokumentennummer oder ein externes Dokument 
(referenziert über eine URL als separat herunterladbare Ressource) oder ein eingebettetes Dokument 
(wie z. B. ein Leistungsnachweis als pdf) zu referenzieren. 
Von der Möglichkeit der Trennung von Rechnung und rechnungsbegründenden Unterlagen kann insbesondere im Fall großer Anlagen 
oder sensibler Daten Gebrauch gemacht werden.
INVOICE LINE                                BG-25                       1..*
 */
public class Invoice extends InvoiceType implements CoreInvoice, DocumentTotals {

	/*
		customizationIDType.setValue("urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_1.2");
                                      EU                                DE
@see http://docs.peppol.eu/poacc/billing/3.0/bis/#prof-01
                 <cbc:CustomizationID>urn:cen.eu:en16931:2017#compliant#urn:fdc:peppol.eu:2017:poacc:billing:3.0</cbc:CustomizationID>
                                      EU                                peppol
ProfileID: BT-23 Geschäfts¬prozesstyp                                      
                                                                        urn:fdc:peppol.eu:2017:poacc:billing:01:1.0
                                      
	 */
	private static final Logger LOG = Logger.getLogger(Invoice.class.getName());
	
	private static final String NOT_IMPEMENTED = "NOT IMPEMENTED";
	
	Invoice() {
		super();
	}
	
	public Invoice(String customization, DocumentNameCode documentNameCode) {
		this(customization, null, documentNameCode);
	}
	
	public Invoice(String customization, String profile, DocumentNameCode code) {
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
	Invoice(InvoiceType doc) {
		this(getCustomization(doc), getProfile(doc), getTypeCode(doc));
		
//		taxTotalFirst = doc.getTaxTotal().get(0);
//		addVATBreakDown(taxTotalFirst);
		
		setId(getId(doc));
		setIssueDate(getIssueDateAsTimestamp(doc));
		setDocumentCurrency(getDocumentCurrency(doc));
		setTaxCurrency(getTaxCurrency(doc)); // optional
		setTaxPointDate(getTaxPointDateAsTimestamp(doc)); // optional
		setPaymentTermsAndDate(getPaymentTerm(doc), getDueDateAsTimestamp(doc)); // optional
//		setDueDate(getDueDateAsTimestamp(doc)); // optional
		setBuyerReference(getBuyerReferenceValue(doc)); // optional
		setOrderReferenceID(getOrderReferenceID(doc)); // optional
//		addPaymentTerms(doc);
		addNotes(doc);	
		setSellerParty(getSellerParty(doc));
		setBuyerParty(getBuyerParty(doc));
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
	}
	
	/* Invoice number                              BT-1  Identifier            1 (mandatory) 
	 * Eine eindeutige Kennung der Rechnung, die diese im System des Verkäufers identifiziert.
	 * Anmerkung: Es ist kein „identification scheme“ zu verwenden.
	 */
	/**
	 * Invoice number   - A unique identification of the Invoice.
	 * <p>
	 * The sequential number required in Article 226(2) of the directive 2006/112/EC [2],
	 * to uniquely identify the Invoice within the business context, time-frame, operating systems and records of the Seller. 
	 * It may be based on one or more series of numbers, which may include alphanumeric characters. 
	 * No identification scheme is to be used.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BT-1
	 * <br>Req.ID: R56
	 * 
	 * @param id Identifier
	 */
	@Override
	public void setId(String id) {
		this.setID(newIDType(id, null)); // null : No identification scheme is to be used.
	}
	
	@Override
	public String getId() {
		return getId(this);
	}
	static String getId(InvoiceType doc) {
		return doc.getID().getValue();
	}

	/* Invoice issue date                          BT-2  Date                  1 (mandatory) 
	 * Das Datum, an dem die Rechnung ausgestellt wurde.
	 */
	/**
	 * Invoice issue date
	 * <p>
	 * The date when the Invoice was issued
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BT-2
	 * <br>Req.ID: R56
	 * 
	 * @param ymd Date
	 */
	@Override
	public void setIssueDate(String ymd) {	
		setIssueDate(DateTimeFormats.ymdToTs(ymd));
	}
	@Override
	public void setIssueDate(Timestamp ts) {
		IssueDateType issueDate = new IssueDateType();
		issueDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		super.setIssueDate(issueDate);
	}
	
	@Override
	public Timestamp getIssueDateAsTimestamp() {  // bei gleichen Namen getIssueDate() kann es nicht abgeleitet sein
		return getIssueDateAsTimestamp(this);
	}
	static Timestamp getIssueDateAsTimestamp(InvoiceType doc) {
		IssueDateType issueDate = doc.getIssueDate();
		return DateTimeFormats.xmlGregorianCalendarToTs(issueDate.getValue());
	}
	
	/**
	 * Invoice type code - A code specifying the functional type of the Invoice.
	 * <p>
	 * Commercial invoices and credit notes are defined according the entries in UNTDID 1001.
	 * Other entries of UNTDID 1001 with specific invoices or credit notes may be used if applicable.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BT-3
	 * <br>Req.ID: R44
	 * 
	 * @param code
	 */
	@Override // use only via ctor
	public void setTypeCode(DocumentNameCode code) {
		InvoiceTypeCodeType typeCode = new InvoiceTypeCodeType();
		typeCode.setValue(code.getValueAsString());
		super.setInvoiceTypeCode(typeCode);
	}
	
	@Override
	public DocumentNameCode getTypeCode() {
		return getTypeCode(this);
	}
	static DocumentNameCode getTypeCode(InvoiceType doc) {
		return DocumentNameCode.valueOf(doc.getInvoiceTypeCode());
	}

	/* Die Währung, in der alle Rechnungsbeträge angegeben werden, 
	 * ausgenommen ist der Umsatzsteuer-Gesamtbetrag, der in der Abrechnungswährung anzugeben ist.
	 */
	/**
	 * Invoice currency code
	 * <p>
	 * The currency in which all Invoice amounts are given, 
	 * except for the Total VAT amount in accounting currency.
	 * Only one currency shall be used in the Invoice, 
	 * except for the Invoice total VAT amount in accounting currency (BT-111) 
	 * in accordance with article 230 of Directive 2006/112/EC on VAT.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BT-5
	 * <br>Req.ID: R54, R47
	 * 
	 * @param code, The lists of valid currencies are registered with the ISO 4217 
	 * Maintenance Agency “Codes for the representation of currencies and funds”.
	 */
	@Override
	public void setDocumentCurrency(String isoCurrencyCode) {
		DocumentCurrencyCodeType documentCurrencyCode = new DocumentCurrencyCodeType();
		documentCurrencyCode.setValue(isoCurrencyCode);
		this.setDocumentCurrencyCode(documentCurrencyCode);
	}
	
	@Override
	public String getDocumentCurrency() {
		return getDocumentCurrency(this);
	}
	static String getDocumentCurrency(InvoiceType doc) {
		DocumentCurrencyCodeType code = doc.getDocumentCurrencyCode();
		return code==null ? null : code.getValue();
	}
	
	/* Die für die Umsatzsteuer-Abrechnungs- und -Meldezwecke verwendete Währung, 
	 * die im Land des Verkäufers gültig ist oder verlangt wird.
	 */
	/**
	 * VAT accounting currency code
	 * <p>
	 * The currency used for VAT accounting and reporting purposes as accepted or required in the country of the Seller.
	 * Shall be used in combination with the Invoice total VAT amount in accounting currency (BT-111) 
	 * when the VAT accounting currency code differs from the Invoice currency code.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-6
	 * <br>Req.ID: R54
	 * 
	 * @param code, The lists of valid currencies are registered with the ISO 4217 
	 * Maintenance Agency “Codes for the representation of currencies and funds”.
	 */
	@Override
	public void setTaxCurrency(String isoCurrencyCode) {
//		LOG.info("isoCurrencyCode="+isoCurrencyCode);
		if(isoCurrencyCode==null) return;
		PaymentCurrencyCodeType paymentCurrencyCode = new PaymentCurrencyCodeType();
		paymentCurrencyCode.setValue(isoCurrencyCode); 
		this.setPaymentCurrencyCode(paymentCurrencyCode);
	}
	
	@Override
	public String getTaxCurrency() {
		return getTaxCurrency(this);
	}
	static String getTaxCurrency(InvoiceType doc) {
		PaymentCurrencyCodeType code = doc.getPaymentCurrencyCode();
		return code==null ? null : code.getValue();
	}

	/* Das Datum, zu dem die Umsatzsteuer für den Verkäufer und für den Erwerber abrechnungsrelevant wird.
	 * Die Anwendung von BT-7 und BT-8 schließen sich gegenseitig aus.
	 * 
	 * Anwendung: In Deutschland wird dieses nicht verwendet. 
	 *            Statt dessen ist das Liefer- und Leistungsdatum anzugeben.
	 */
	/**
	 * Value added tax point date
	 * <p>
	 * The date when the VAT becomes accountable for the Seller and for the Buyer in so far 
	 * as that date can be determined and differs from the date of issue of the invoice, according to the VAT directive.
	 * The tax point is usually the date goods were supplied or services completed (the 'basic tax point'). 
	 * There are some variations.
	 * Please refer to Article 226 (7) of the Council Directive 2006/112/EC [2] for more information.
	 * This element is required if the Value added tax point date is different from the Invoice issue date.
	 * Both Buyer and Seller should use the Tax Point Date when provided by the Seller. 
	 * The use of BT-7 and BT-8 is mutually exclusive.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-7
	 * <br>Req.ID: R45 R46
	 * 
	 * @param ymd Date
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
		super.setTaxPointDate(taxPointDate);
	}
	
	@Override
	public Timestamp getTaxPointDateAsTimestamp() {
		return getTaxPointDateAsTimestamp(this);
	}
	static Timestamp getTaxPointDateAsTimestamp(InvoiceType doc) {
		TaxPointDateType taxPointDate = doc.getTaxPointDate();
		return taxPointDate==null ? null : DateTimeFormats.xmlGregorianCalendarToTs(taxPointDate.getValue());
	}
	
	// BT-8 Value added tax point date code - in ubl nicht definiert ???
	public void setTaxPointDateCode(String code) {
		LOG.warning(NOT_IMPEMENTED);
	}
	
	/**
	 * Payment due date 
	 * <p>
	 * The date when the payment is due.
	 * <br>
	 * The payment due date reflects the due date of the net payment. 
	 * For partial payments it states the first net due date. 
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-9
	 * <br>Rule ID: 	BR-CO-25
	 * <br>Request ID: 	R60
	 * 
	 * @param ts Date, optional: can be null
	 */
//	@Override
//	public void setDueDate(String ymd) {
//		setDueDate(DateTimeFormats.ymdToTs(ymd));
//	}
//	@Override
	void setDueDate(Timestamp ts) {
		if(ts==null) return; // optional
		DueDateType dueDate = new DueDateType();
		dueDate.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		super.setDueDate(dueDate);
	}
	
	@Override
	public Timestamp getDueDateAsTimestamp() {
		return getDueDateAsTimestamp(this);
	}
	static Timestamp getDueDateAsTimestamp(InvoiceType doc) {
		DueDateType dueDate = doc.getDueDate();
		return dueDate==null ? null : DateTimeFormats.xmlGregorianCalendarToTs(dueDate.getValue());
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


	/* Buyer reference                             BT-10 Text                  1 (mandatory in XRechnung) 
	 * Ein vom Erwerber zugewiesener und für interne Lenkungszwecke benutzter Bezeichner / Leitweg-ID
	 */
	/**
	 * Buyer reference - An identifier assigned by the Buyer used for internal routing purposes.
	 * <p>
	 * The identifier is defined by the Buyer (e.g. contact ID, department, office id, project code), 
	 * but provided by the Seller in the Invoice.
	 * <p>
	 * Cardinality: 0..1 (optional), but mandatory due to BR-DE-15
	 * <br>ID: BT-10
	 * <br>Req.ID: R8
	 * 
	 * @param Text
	 */
	public void setBuyerReference(String reference) {
		if(reference==null) return; // optional
		BuyerReferenceType buyerReference = new BuyerReferenceType();
		buyerReference.setValue(reference);
		this.setBuyerReference(buyerReference);
	}
	public String getBuyerReferenceValue() {
		return getBuyerReferenceValue(this);
	}
	static String getBuyerReferenceValue(InvoiceType doc) {
		return doc.getBuyerReference()==null ? null : doc.getBuyerReference().getValue();
	}

	// BT-11 Project reference 
	public void setProjectReferenceID(String docRefId) {
		LOG.warning(NOT_IMPEMENTED);
	}

	// BT-12 Contract reference 
	public void setContractReferenceID(String docRefId) {
		LOG.warning(NOT_IMPEMENTED);
	}

	// BT-13 Purchase order reference 
	public void setPurchaseOrderReferenceID(String docRefId) {
		LOG.warning(NOT_IMPEMENTED);
	}

	// Eine vom Verkäufer ausgegebene Kennung für einen referenzierten Auftrag.
	/**
	 * Sales order reference
	 * <p>
	 * An identifier of a referenced sales order, issued by the Seller.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-14
	 * <br>Req.ID: R41
	 * 
	 * @param Document reference
	 */
	@Override
	public void setOrderReferenceID(String docRefId) {
		if(docRefId==null) return; // optional
		OrderReferenceType orderReference = new OrderReferenceType();
		orderReference.setID(newIDType(docRefId, null)); // null : No identification scheme
		this.setOrderReference(orderReference);
	}
	@Override
	public String getOrderReferenceID() {
		return getOrderReferenceID(this);
	}
	static String getOrderReferenceID(InvoiceType doc) {
		OrderReferenceType orderRef = doc.getOrderReference();
		if(orderRef==null) return null;
		return orderRef.getID().getValue();
	}

	// BT-15 Receiving advice reference 
	public void setReceivingAdviceReferenceID(String docRefId) {
		LOG.warning(NOT_IMPEMENTED);
	}
	
	// BT-16 Despatch advice reference 
	public void setDespatchAdviceReferenceID(String docRefId) {
		LOG.warning(NOT_IMPEMENTED);
	}

	// BT-17 Tender or lot reference 
	public void setTenderReferenceID(String docRefId) {
		LOG.warning(NOT_IMPEMENTED);
	}

	// BT-18 Invoiced object identifier - in ubl nicht definiert ???
	public void setInvoicedOjectID(String id) {
		LOG.warning(NOT_IMPEMENTED);
	}

	// BT-19 Buyer accounting reference
	public void setBuyerAccountingD(String text) {
		LOG.warning(NOT_IMPEMENTED);
	}

	/* Eine Textbeschreibung der Zahlungsbedingungen, die für den fälligen Zahlungsbetrag gelten 
	 * (einschließlich Beschreibung möglicher Skonto- und Verzugsbedingungen).
	 */
	/**
	 * Payment terms
	 * <p>
	 * A textual description of the payment terms that apply to the amount due for payment (Including description of possible penalties).
	 * This element may contain multiple lines and multiple terms.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-20
	 * <br>Rule ID: 	BR-CO-25
	 * <br>Request ID: 	R60
	 */
	@Override
	public String getPaymentTerm() {
		List<PaymentTerms> ptList = getPaymentTermList();
		if(ptList.isEmpty()) return null;
		return ptList.get(0).getFirstNote(); // da Cardinality 0..1
	}

	public String getPaymentTerm(InvoiceType doc) {
		List<PaymentTerms> ptList = getPaymentTermList(this);
		if(ptList.isEmpty()) return null;
		return ptList.get(0).getFirstNote(); // da Cardinality 0..1
	}
	
	List<PaymentTerms> getPaymentTermList() {
		return getPaymentTermList(this);
	}
	
	static List<PaymentTerms> getPaymentTermList(InvoiceType doc) {
		List<PaymentTermsType> paymentTermsList = doc.getPaymentTerms();
		List<PaymentTerms> result = new ArrayList<PaymentTerms>(paymentTermsList.size());
		paymentTermsList.forEach(paymentTerms -> {
			result.add(new PaymentTerms(paymentTerms));
		});
		return result;
	}
	
	List<PaymentTermsType> addPaymentTerms(InvoiceType doc) {
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

	/* INVOICE NOTE                                BG-1                        0..*
	 * Eine Gruppe von Informationselementen für rechnungsrelevante Erläuterungen mit Hinweisen auf den Rechnungsbetreff.
	 * 

Invoice note subject code BT-21 Code 0..1 56  ???? finde ich nicht in UBL
Der Betreff für den nachfolgenden Textvermerk zur Rechnung.
Anmerkung: Die Auswahl erfolgt aus UNTDID 4451a.

Invoice note BT-22 Text 1 58
Ein Textvermerk, der unstrukturierte Informationen enthält, die für die Rechnung als Ganzes maßgeblich sind. 
Erforderlichenfalls können Angaben zur Aufbewahrungspflicht gem. § 14 Abs. 4 UStG hier aufgenommen werden.
Anmerkung: Im Falle einer bereits fakturierten Rechnung kann hier z. B. der Grund der Korrektur angegeben werden

	 */
	@Override
	public void setNote(String subjectCode, String content) {
		setNote(content);
	}
	@Override
	public void setNote(String content) {
		addNote(content);
	}
	List<NoteType> addNote(String invoiceNote) {
		List<NoteType> notes = this.getNote();
		NoteType note = new NoteType();
		note.setValue(invoiceNote);
		notes.add(note);
		return notes;
	}
	
	@Override
	public List<String> getNotes() {
		return getNotes(this);
	}
	static List<String> getNotes(InvoiceType doc) {
		List<NoteType> notes = doc.getNote();
		List<String> res = new ArrayList<String>(notes.size());
		notes.forEach(note -> res.add(note.getValue()));
		return res;
	}
	List<NoteType> addNotes(InvoiceType doc) {
		List<NoteType> notes = doc.getNote();
		List<NoteType> n = this.getNote();
		notes.forEach(note -> {
			n.add(note);
			LOG.fine(note.getValue() +" "+n.size());
		});
		LOG.fine(this.getNote().size() +" "+n.size());
		return n;
	}
	
	/* PROCESS CONTROL                             BG-2                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, 
	 * die Informationen über den Geschäftsprozess und für die Rechnung geltende Regeln liefern.
	 */
	/**
	 * PROCESS CONTROL
	 * <p>
	 * A group of business terms providing information on the business process and rules applicable to the Invoice document.
	 * Contains ProfileID (BT-23 0..1) and CustomizationID/Specification identifier (BT-24 1..1)
	 * <br>
	 * ProfileID identifies what business process a given message is part of, 
	 * and CustomizationID identifies the kind of message and the rules applied.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BG-2 , BT-23 , BT-24
	 * <br>Req.ID: R44
	 * <p>
	 * ProfileID/Business process type - Identifies the business process context in which the transaction appears, 
	 * to enable the Buyer to process the Invoice in an appropriate way.
	 * <p>
	 * Specification identifier - An identification of the specification containing the total set of rules regarding semantic content,
	 * cardinalities and business rules to which the data contained in the instance document conforms.
	 * This identifies compliance or conformance to this document. 
	 * Compliant invoices specify: urn:cen.eu:en16931:2017. Invoices, compliant to a user specification may identify that user specification here.
	 * No identification scheme is to be used.
	 * 
	 * @param customization, not null
	 * @param profile (optional)
	 */
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
		return getCustomization(this);
	}
	static String getCustomization(InvoiceType doc) {
		CustomizationIDType customizationID = doc.getCustomizationID();
		LOG.info("getSchemeAgencyID:"+customizationID.getSchemeAgencyID() +
				" SchemeAgencyName:"+customizationID.getSchemeAgencyName() +
				" Value:"+customizationID.getValue()
				);
		return customizationID.getValue();
	}
	
	public String getProfile() {
		return getProfile(this);
	}
	static String getProfile(InvoiceType doc) {
		ProfileIDType profileID = doc.getProfileID();
		return profileID==null ? null : profileID.getValue();
	}

	/* PRECEDING INVOICE REFERENCE                 BG-3                        0..*
	 * Eine Gruppe von Informationselementen, die Informationen über eine vorausgegangene Rechnung liefern, 
	 * die berichtigt oder gutgeschrieben werden soll. 
	 * 
	 * Preceding Invoice reference  BT-25 Document Reference
	 * Preceding Invoice issue date BT-26 Date
	 */
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

	
	/* SELLER                                      BG-4                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, die Informationen über den Verkäufer liefern.
	 * 

Name                                        ID    Semantischer Datentyp Anz. 
Seller name                                 BT-27 Text                  1
Der vollständige Name, unter dem der Verkäufer im nationalen Register für juristische Personen oder als steuerpflichtige
Person eingetragen ist oder anderweitig als Person(en) handelt (Firma).

Seller trading name                         BT-28 Text                  0..1
Ein Name, unter dem der Verkäufer bekannt ist, sofern abweichend vom Namen des Verkäufers.

Seller identifier                           BT-29 Identifier            0..*
Eine (i. d. R. vom Erwerber vergebene) Kennung des Verkäufers, wie z. B. die Kreditorennummer für das Mittelbewirtschaftungsverfahren
oder die Lieferantennummer für das Bestellsystem.

Seller identifier/Scheme identifier                                     0..1
Die Kennung des Bildungsschemas für das Element „Seller identifier“ (BT-29).
Anmerkung: Wenn das Element verwendet wird, ist die Kennung aus den Einträgen der von der ISO/IEC 6523
maintenance agency veröffentlichten Liste zu wählen.

Seller legal registration identifier        BT-30 Identifier            0..1
Eine von einer offiziellen Registrierstelle ausgegebene Kennung, die den Verkäufer als Rechtsträger oder juristische
Person identifiziert.

Seller legal registration identifier/Scheme       identifier            0..1
Das für das Element Seller legal registration identifier geltende Schema.
Anmerkung: Wenn ein Schema verwendet wird, ist es aus der Liste der ISO/IEC 6523 Maintenance Agency zu wählen.

Seller VAT identifier                       BT-31 Identifier            0..1
Die Umsatzsteuer-Identifikationsnummer des Verkäufers. Verfügt der Verkäufer über eine solche, ist sie hier anzugeben,
sofern nicht Angaben zum Seller tax representative gemacht werden.

Seller tax registration identifier          BT-32 Identifier            0..1 
Eine örtliche steuerrechtliche Kennung des Verkäufers (bestimmt durch dessen Adresse) oder ein Verweis auf
seinen eingetragenen Steuerstatus. (Hier ist ggf. die Angabe „Steuerschuldnerschaft des Leistungsempfängers“
oder die USt-Befreiung des Rechnungsstellers einzutragen.)
Seller additional legal information         BT-33 Text                  0..1
Weitere rechtliche Informationen, die für den Verkäufer maßgeblich sind (wie z. B. Grundkapital).
Seller electronic address                   BT-34 Identifier            0..1 
Gibt die elektronische Adresse des Verkäufers an, an die die Antwort der Anwendungsebene auf eine Rechnung
gesendet werden kann.
Seller electronic address/Scheme identifier 1
Das Bildungsschema für Seller electronic address.
Anmerkung: Das Bildungsschema soll aus der von der Connecting Europe Facility unterhaltenen Liste gewählt werden.
SELLER POSTAL ADDRESS                       BG-5                        1
Eine Gruppe von Informationselementen, die Informationen über die Verkäuferanschrift liefern.

SELLER CONTACT                              BG-6                        1

 */
	/**
	 * Seller (AccountingSupplierParty)
	 * Seller is mandatory information and provided in ubl element cac:AccountingSupplierParty
	 * 
	 * @param registrationName mandatory BT-27 : The full formal name by which the Seller is registered 
	 *        in the national registry of legal entities or as a Taxable person or otherwise trades as a person or persons.
	 * @param postalAddress mandatory group BG-5/R53 : A group of business terms providing information about the address of the Seller.
              Sufficient components of the address are to be filled to comply with legal requirements.
	 * @param contact mandatory group BG-6/R57 : A group of business terms providing contact information about the Seller.
	 * @param companyId optional / Seller legal registration identifier, BT-30/R52
	 * @param companyLegalForm optional / Seller additional legal information, BT-33/R47
	 */
	public void setSeller(String registrationName, Address address, Contact contact, String companyId, String companyLegalForm) {
		Party party = new Party(registrationName, address, contact, companyId, companyLegalForm);
		setSellerParty(party);
	}
	
	/* Die Umsatzsteuer-Identifikationsnummer des Verkäufers. 
	 * Verfügt der Verkäufer über eine solche, ist sie hier anzugeben, sofern nicht Angaben zum Seller tax representative gemacht werden.
	 */
	/**
	 * set optional taxCompanyId  / Seller VAT identifier, BT-31, R52
	 * 
	 * @param taxCompany Identifier
	 */
	public void setSellerTaxCompanyId(String taxCompanyId) {
		Party party = getSellerParty();
		party.addPartyTaxID(taxCompanyId);
	}
	
	/**
	 * SELLER 
	 * <p>
	 * A group of business terms providing information about the Seller.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BG-4
	 * <br>Req.ID: R48
	 * 
	 * @param SELLER party
	 */
	public void setSellerParty(Party party) {
		SupplierPartyType supplierParty = new SupplierPartyType();
		supplierParty.setParty(party);
		this.sellerParty = party;
		super.setAccountingSupplierParty(supplierParty);
	}
	
	public Party getSellerParty() {
		return this.sellerParty==null ? getSellerParty(this) : sellerParty;
	}
	
	static Party getSellerParty(InvoiceType doc) {
		SupplierPartyType supplierParty = doc.getAccountingSupplierParty();
		return supplierParty==null ? null : new Party(supplierParty.getParty());
	}

	/* BUYER                                       BG-7                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, die Informationen über den Erwerber liefern.

Name                                        ID    Semantischer Datentyp Anz. 
Buyer name                                  BT-44 Text                  1
Der vollständige Name des Erwerbers.

Buyer trading name                          BT-45 Text                  0..1
Ein Name, unter dem der Erwerber bekannt ist, sofern abweichend vom Namen des Erwerbers.

Buyer identifier                            BT-46 Identifier            0..1
Eine (i. d. R. vom Verkäufer vergebene) Kennung des Erwerbers, wie z. B. die Debitorennummer für die Buchhaltung
oder die Kundennnummer für die Auftragsverwaltung.
Anmerkung: Für die Bildung des Buyer Identifier ist kein einheitliches Schema erforderlich.

Buyer identifier/Scheme                           identifier            0..1
Die Kennung des Bildungsschemas für den „Buyer identifier“.
Anmerkung: Wenn das Element verwendet wird, ist der Eintrag aus der von der ISO/IEC 6523 maintenance agency veröffentlichten Liste zu wählen.

Buyer legal registration identifier         BT-47 Identifier            0..1
Ein von einer offiziellen Registrierstelle ausgegebener Bezeichner, der den Erwerber als Rechtsträger oder juristische
Person identifiziert. Z. B. Handelsregister-Eintrag, Vereinsregister etc.

Buyer legal registration identifier/Scheme        identifier            0..1
Die Kennung des Bildungsschemas für den „Buyer legal registration identifier“.
Anmerkung: Wenn das Element verwendet wird, ist der Eintrag aus der von der ISO/IEC 6523 maintenance agency
veröffentlichten Liste zu wählen.

Buyer VAT identifier                        BT-48 Identifier            0..1
Die Umsatzsteuer-Identifikationsnummer des Erwerbers.

Buyer electronic address                    BT-49 Identifier            0..1
Gibt eine elektronische Adresse des Erwerbers an, an die eine Rechnung gesendet werden sollte.

Buyer electronic address/Scheme identifier                              1
Das Bildungsmuster für Buyer electronic address.
Anmerkung: Es sollte ein Bildungsmuster aus der von der Connecting Europe Facility unterhaltenen Liste gewählt werden.

	@see https://www.xoev.de/die_standards/xrechnung/xrechnung_versionen-14747 unten
 
	Für BT-49 und BT-34 (Sellers and Buyers Electronic address identifiers) schreibt die EN 16931 die Verwendung einer Codeliste vor, 
	die durch CEF (Connecting Europe Facility) herausgegeben und betrieben wird. 
	Eine solche Liste liegt derzeit nicht vor. 
	Zudem berücksichtigen die derzeit vorliegenden Validierungsartefakte der Norm die betreffenden BTs nicht.
	
	Inzwischen ist sie da: https://ec.europa.eu/cefdigital/wiki/display/CEFDIGITAL2018/Code+lists
	https://ec.europa.eu/cefdigital/wiki/download/attachments/80184624/Electronic%20Address%20Scheme%20code%20list%20%28EAS%29%20-%20version%201_0.xlsx?version=2&modificationDate=1542204730758&api=v2
	in de: siehe Die Leitweg ID

BUYER POSTAL ADDRESS                        BG-8                        1
Eine Gruppe von Informationselementen, die Informationen über die Anschrift des Erwerbers liefern.
Anmerkung: Es ist eine gültige vollständige Anschrift anzugeben.

BUYER CONTACT                               BG-9                        0..1
Eine Gruppe von Informationselementen, die Angaben zum Ansprechpartner oder der Kontaktstelle beim Erwerber liefern.
	 */
	/**
	 *  Buyer (AccountingCustomerParty)
	 *  Buyer is mandatory information and provided in element cac:AccountingCustomerParty
	 * 
	 * @param registrationName mandatory, BT-44, R57
	 * @param BUYER POSTAL ADDRESS mandatory, BG-8, R53
	 * @param BUYER CONTACT optional, BG-9, R57
	 */
	public void setBuyer(String registrationName, Address address, Contact contact) {
		Party party = new Party(registrationName, address, contact, null, null); 
		setBuyerParty(party);
	}

	/**
	 * Buyer VAT identifier - The Buyer's VAT identifier (also known as Buyer VAT identification number).
	 * <p>
	 * VAT number prefixed by a country code based on EN ISO 3166-1 "Codes for the representation of names of countries and their subdivisions"
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-48
	 * <br>Req.ID: R45, R52, R57
	 * 
	 * @param taxCompany Identifier
	 */
	public void setBuyerTaxCompanyId(String taxCompanyId) {
		Party party = getBuyerParty();
		party.addPartyTaxID(taxCompanyId);
	}
	
	/**
	 * BUYER
	 * <p>
	 *  A group of business terms providing information about the Buyer.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>ID: BG-7
	 * <br>Req.ID: R57
	 * 
	 * @param BUYER party
	 */
	public void setBuyerParty(Party party) {
		CustomerPartyType customerparty = new CustomerPartyType();
		customerparty.setParty(party);
		this.buyerParty = party;
		setAccountingCustomerParty(customerparty);
	}
	
	public Party getBuyerParty() {
		return this.buyerParty==null ? getBuyerParty(this) : buyerParty;
	}
	static Party getBuyerParty(InvoiceType doc) {
		CustomerPartyType customerparty = doc.getAccountingCustomerParty();
		return customerparty==null ? null : new Party(customerparty.getParty());
	}
	
	/* PAYEE                                       BG-10                       0..1
	 * Eine Gruppe von Informationselementen, die Informationen über den Zahlungsempfänger liefern. 
	 * Die Gruppe wird genutzt, wenn der Zahlungsempfänger nicht mit dem Verkäufer identisch ist.
	 */
	public void setPayeeParty(Party party) {
		LOG.warning(NOT_IMPEMENTED);
	}
	
	/* SELLER TAX REPRESENTATIVE PARTY             BG-11                       0..1
	 * Eine Gruppe von Informationselementen, die Informationen über den Steuervertreter des Verkäufers liefern.
	 */
	public void setSellerTaxRepresentativeParty(Party party) {
		LOG.warning(NOT_IMPEMENTED);
	}

	/* DELIVERY INFORMATION                        BG-13                       0..1
	 * Eine Gruppe von Informationselementen, die Informationen darüber liefern, 
	 * wo und wann die in Rechnung gestellten Waren und Dienstleistungen geliefert bzw. erbracht werden.
	 */
	/**
	 * DELIVERY INFORMATION
	 * <p>
	 * A group of business terms providing information about where and when the goods and services invoiced are delivered.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BG-13
	 * <br>Req.ID: R31, R32, R57
	 */
	public List<Delivery> getDeliveries() {
		List<DeliveryType> deliveryList = this.getDelivery();
		List<Delivery> result = new ArrayList<Delivery>(deliveryList.size());
		deliveryList.forEach(delivery -> {
			result.add(new Delivery(delivery));
		});
		return result;
	}
	List<DeliveryType> addDeliveries(InvoiceType doc) {
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
		return deliveryList;
	}

	/* PAYMENT INSTRUCTIONS                        BG-16                       1 (mandatory) 
	 * Eine Gruppe von Informationselementen, die Informationen darüber liefern, wie die Zahlung erfolgen soll.

Name                                        ID    Semantischer Datentyp Anz. 
Payment means type code                     BT-81 Code                  1 
Payment means text                          BT-82 Text                  0..1
Remittance information                      BT-83 Text                  0..1
Ein Textwert, der zur Verknüpfung der Zahlung mit der vom Verkäufer ausgestellten Rechnung verwendet wird.
Anmerkung: Die Angabe eines Verwendungszwecks hilft dem Verkäufer bei der Zuweisung einer eingehenden
Zahlung zum jeweiligen Zahlungsprozess. Wenn Remittance information in der Rechnung übermittelt wurde, sollte
diese daher bei der Zahlung genutzt werden.

CREDIT TRANSFER                             BG-17                       0..*
Eine Gruppe von Informationselementen, die Informationen über das Bankkonto geben, auf das die Überweisung
zu leisten ist. Die Gruppe ist alternativ zu „PAYMENT CARD INFORMATION“ (BG-18) oder zu „DIRECT DEBIT“
(BG-19) anzugeben, wenn eine Zahlung per Überweisung erfolgen soll.

PAYMENT CARD INFORMATION                    BG-18                       0..1
Eine Gruppe von Informationselementen, die Informationen über die für die Zahlung genutzte Karte liefern. Die Gruppe
ist alternativ zu „DIRECT DEBIT“ (BG-19) (Lastschrift mit Vorliegen einer Mandatsreferenz) oder zu „CREDIT
TRANSFER“ (BG-17) (Überweisung) anzugeben, wenn eine Zahlung per Zahlungskarte/Kreditkarte erfolgte.

DIRECT DEBIT                                BG-19                       0..1 
Eine Gruppe von Informationselementen, die spezifische Informationen über die vorgesehene Lastschrift geben.
Die Gruppe ist alternativ zu „CREDIT TRANSFER“ (BG-17) oder zu „PAYMENT CARD INFORMATION“ (BG-18)
anzugeben, wenn ein Mandat erteilt wurde und der Rechnungsbetrag per Lastschrift beglichen werden soll.

Bsp: 01.01a-INVOICE_ubl.xml :
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>
        <cac:PayeeFinancialAccount>
            <cbc:ID>DE12345678912345678912</cbc:ID>
        </cac:PayeeFinancialAccount>
    </cac:PaymentMeans>

Bsp: ubl004.xml :
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>		<!-- CreditTransfer 	(30), -->
        <cbc:PaymentID>Deb. 10202 + Fact. 12115118</cbc:PaymentID>
        <cac:PayeeFinancialAccount>
            <cbc:ID>NL57 RABO 0107307510</cbc:ID>
        </cac:PayeeFinancialAccount>
    </cac:PaymentMeans>
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>
        <cbc:PaymentID>Deb. 10202 / Fact. 12115118</cbc:PaymentID>
        <cac:PayeeFinancialAccount>
            <cbc:ID>NL03 INGB 0004489902</cbc:ID>
        </cac:PayeeFinancialAccount>
    </cac:PaymentMeans>

Bsp: example-peppol-ubl-creditnote.xml :
  <cac:PaymentMeans>
    <!-- Kontoverbindung -->
    <cbc:PaymentMeansCode>31</cbc:PaymentMeansCode>         <!-- DebitTransfer 		(31), -->
    <cbc:PaymentChannelCode>IBAN</cbc:PaymentChannelCode>
    <cac:PayeeFinancialAccount>
      <cbc:ID schemeID="IBAN">AT611904300234573201</cbc:ID>
      <cac:FinancialInstitutionBranch>
        <cac:FinancialInstitution>
          <cbc:ID schemeID="BIC">TUVTAT21</cbc:ID>
        </cac:FinancialInstitution>
      </cac:FinancialInstitutionBranch>
    </cac:PayeeFinancialAccount>
  </cac:PaymentMeans>

	 */
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
//		return PaymentMeans.getCreditTransfer(super.getPaymentMeans().get(0));
		LOG.info("PaymentMeans.Class:"+super.getPaymentMeans().get(0).getClass());
//		return new FinancialAccount(super.getPaymentMeans().get(0).getPayerFinancialAccount());
		PaymentMeans pm = (PaymentMeans)super.getPaymentMeans().get(0);
		return pm.getCreditTransfer();
	}
/* wo die factory?
public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic); // SEPA Überweisung
 */

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
	
	/* DOCUMENT LEVEL ALLOWANCES                   BG-20                       0..*
	 * Eine Gruppe von Informationselementen, die Informationen über Nachlässe liefern, die für die Rechnung als Ganzes gelten.
	 */
	public void setDocumentLevelAllowence(Object todo) {
		LOG.warning(NOT_IMPEMENTED);
	}

	/* DOCUMENT LEVEL CHARGES                      BG-21                       0..*
	 * Eine Gruppe von Informationselementen, die Informationen über Kosten, Zuschläge, und Steuern 
	 * – ausgenommen die Umsatzsteuer – enthalten, die für die Rechnung als Ganzes gelten.
	 */
	public void setDocumentLevelCharges(Object todo) {
		LOG.warning(NOT_IMPEMENTED);
	}

	/* DOCUMENT TOTALS                             BG-22                       1 (mandatory)
	 * Eine Gruppe von Informationselementen, die die monetären Gesamtbeträge der Rechnung liefern.
	 * 

       Sum of Invoice line net amount              BT-106 Amount               1
Summe aller Rechnungspositionen-Nettobeträge der Rechnung.
       Sum of allowances on document level         BT-107 Amount               0..1
Summe aller in der Rechnung enthaltenen Nachlässe der Dokumentenebene.
       Sum of charges on document level            BT-108 Amount               0..1
Summe aller in der Rechnung enthaltenen Abgaben der Dokumentenebene.
       Invoice total amount without VAT            BT-109 Amount               1
Der Gesamtbetrag der Rechnung ohne Umsatzsteuer.
       Invoice total VAT amount                    BT-110 Amount               0..1
Der Gesamtbetrag der Umsatzsteuer für die Rechnung.
       Invoice total VAT amount in accounting currency BT-111 Amount           0..1
Der Umsatzsteuergesamtbetrag, angegeben in der Abrechnungswährung, die im Land des Verkäufers gültig ist oder verlangt wird.
       Invoice total amount with VAT               BT-112 Amount               1
Der Gesamtbetrag der Rechnung mit Umsatzsteuer.
       Paid amount                                 BT-113 Amount               0..1
Summe bereits gezahlter Beträge.
       Rounding amount                             BT-114 Amount               0..1
Der Betrag, um den der Rechnungsbetrag gerundet wurde.
       Amount due for payment                      BT-115 Amount               1
Der ausstehende Betrag. Dies ist der Rechnungsbetrag inkl. Umsatzsteuer abzüglich des bereits gezahlten Betrags.
Dieser Betrag ist der Rechnungsgesamtbetrag einschließlich Umsatzsteuer abzüglich der Summe bereits gezahlter
Beträge. Im Falle einer vollständig beglichenen Rechnung ist dieser Betrag gleich null. Der Betrag ist negativ, falls
der gezahlte Betrag größer als der Rechnungsgesamtbetrag einschließlich Umsatzsteuer ist.

	 */ 
	
	/**
	 * mandatory total amounts of the invoice
	 * 
	 * @param lineExtension : Sum of Invoice line net amount, BT-106
	 * @param taxExclusive : Invoice total amount without VAT, BT-109
	 * @param taxInclusive : Invoice total amount with VAT, BT-112
	 * @param payable : Amount due for payment, BT-115
	 */
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
	
	static Amount getInvoiceLineNetTotal(InvoiceType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		return getInvoiceLineNetTotal(monetaryTotal);
	}
	private static Amount getInvoiceLineNetTotal(MonetaryTotalType monetaryTotal) {
		LineExtensionAmountType amount = monetaryTotal.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getInvoiceTotalTaxExclusive(InvoiceType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		return getInvoiceTotalTaxExclusive(monetaryTotal);
	}
	private static Amount getInvoiceTotalTaxExclusive(MonetaryTotalType monetaryTotal) {
		TaxExclusiveAmountType amount = monetaryTotal.getTaxExclusiveAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getInvoiceTotalTaxInclusive(InvoiceType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		return getInvoiceTotalTaxInclusive(monetaryTotal);
	}
	private static Amount getInvoiceTotalTaxInclusive(MonetaryTotalType monetaryTotal) {
		TaxInclusiveAmountType amount = monetaryTotal.getTaxInclusiveAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getDuePayable(InvoiceType doc) {
		MonetaryTotalType monetaryTotal = doc.getLegalMonetaryTotal();
		return getDuePayable(monetaryTotal);
	}
	private static Amount getDuePayable(MonetaryTotalType monetaryTotal) {
		PayableAmountType amount = monetaryTotal.getPayableAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	void setDocumentTotals(InvoiceType doc) {
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
	
	static Amount getInvoiceTax(InvoiceType doc) {
		TaxTotalType taxTotal = doc.getTaxTotal().get(0); // getFirstTaxTotal(doc);
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
			LOG.info("taxAmount "+taxAmount);
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
		return this.getTaxTotal().get(0);
	}
	
	/* VAT BREAKDOWN                               BG-23                       1..* (mandatory)
	 * Eine Gruppe von Informationselementen, die Informationen über die Umsatzsteueraufschlüsselung in verschiedene Kategorien liefern.
	 * 
	 */
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
/*
    <cac:TaxTotal>
        <cbc:TaxAmount currencyID="EUR">22.04</cbc:TaxAmount>
        <cac:TaxSubtotal>                           ---- VatBreakdown extends TaxSubtotalType
            <cbc:TaxableAmount currencyID="EUR">314.86</cbc:TaxableAmount>
            <cbc:TaxAmount currencyID="EUR">22.04</cbc:TaxAmount>
            <cac:TaxCategory>
                <cbc:ID>S</cbc:ID>
                <cbc:Percent>7</cbc:Percent>
                <cac:TaxScheme>
                    <cbc:ID>VAT</cbc:ID>
                </cac:TaxScheme>
            </cac:TaxCategory>
        </cac:TaxSubtotal>
    </cac:TaxTotal>

    <cac:TaxTotal>
        <cbc:TaxAmount currencyID="EUR">20.73</cbc:TaxAmount>
        <cac:TaxSubtotal>
            <cbc:TaxableAmount currencyID="EUR">183.23</cbc:TaxableAmount>
            <cbc:TaxAmount currencyID="EUR">10.99</cbc:TaxAmount>
            <cac:TaxCategory>
                <cbc:ID>S</cbc:ID>
                <cbc:Percent>6</cbc:Percent>
                <cac:TaxScheme>
                    <cbc:ID>VAT</cbc:ID>
                </cac:TaxScheme>
            </cac:TaxCategory>
        </cac:TaxSubtotal>
        <cac:TaxSubtotal>
        <!-- 37,9 -->
            <cbc:TaxableAmount currencyID="EUR">46.37</cbc:TaxableAmount>
            <cbc:TaxAmount currencyID="EUR">9.74</cbc:TaxAmount>
            <cac:TaxCategory>
                <cbc:ID>S</cbc:ID>
                <cbc:Percent>21</cbc:Percent>
                <cac:TaxScheme>
                    <cbc:ID>VAT</cbc:ID>
                </cac:TaxScheme>
            </cac:TaxCategory>
        </cac:TaxSubtotal>
    </cac:TaxTotal>
 
 */
		TaxTotalType taxTotal = getFirstTaxTotal();
		
		TaxSubtotalType taxSubtotal = new VatBreakdown(taxableAmount, tax, taxCategoryCode, taxRate);
		taxTotal.getTaxSubtotal().add(taxSubtotal);
	}
	public List<VatBreakdown> getVATBreakDowns() {
		return getVATBreakDowns(this);
	}
	static List<VatBreakdown> getVATBreakDowns(InvoiceType doc) {
		TaxTotalType taxTotal = doc.getTaxTotal().get(0);
		List<TaxSubtotalType> taxSuptotalList = taxTotal.getTaxSubtotal();
		List<VatBreakdown> result = new ArrayList<VatBreakdown>(taxSuptotalList.size()); // VatBreakdown extends TaxSubtotalType
		taxSuptotalList.forEach(vbd -> {
			VatBreakdown taxSubtotal = new VatBreakdown(vbd);
			result.add(taxSubtotal);
		});	
		return result;
	}
	
	/* ADDITIONAL SUPPORTING DOCUMENTS             BG-24                       0..* (optional)
	 * Eine Gruppe von Informationselementen mit Informationen über rechnungsbegründende Unterlagen, 
	 * die Belege für die in der Rechnung gestellten Ansprüche enthalten.
	 */
	public List<DocumentReferenceType> addAdditionalSupportingDocument(DocumentReferenceType asd) {
		List<DocumentReferenceType> documentReferenceList = this.getAdditionalDocumentReference();
		documentReferenceList.add(asd);
		return documentReferenceList;
	}
	
	public List<DocumentReferenceType> addAdditionalSupportingDocuments(InvoiceType doc) {
		List<DocumentReferenceType> documentReferenceList = doc.getAdditionalDocumentReference();
		List<DocumentReferenceType> resultList = this.getAdditionalDocumentReference();
		documentReferenceList.forEach(document -> {
			resultList.add(document);
		});
		return resultList;
	}
	
	public List<DocumentReferenceType> getAdditionalSupportingDocuments() {
		return getAdditionalSupportingDocuments(this);
	}

	static List<DocumentReferenceType> getAdditionalSupportingDocuments(InvoiceType doc) {
		List<DocumentReferenceType> documentReferenceList = doc.getAdditionalDocumentReference();
		List<DocumentReferenceType> resultList = new ArrayList<DocumentReferenceType>(documentReferenceList.size());
		documentReferenceList.forEach(document -> {
			resultList.add(new AdditionalSupportingDocument(document));
		});
		return resultList;
	}
	
	/* INVOICE LINE                                BG-25                       1..* (mandatory)
	 * Eine Gruppe von Informationselementen, die Informationen über einzelne Rechnungspositionen liefern.
	 */
	/**
	 * Adds a mandatory invoice line element
	 * 
	 * @param line
	 */
	@Override
	public void addLine(CoreInvoiceLine line) {
		List<InvoiceLineType> lines = this.getInvoiceLine();
		lines.add((InvoiceLineType)line);
	}

	public List<InvoiceLineType> addLines(InvoiceType doc) {
		List<InvoiceLineType> lines = doc.getInvoiceLine();
		List<InvoiceLineType> resultLines = this.getInvoiceLine();
		lines.forEach(line -> {
			resultLines.add(line);
		});
		return resultLines;
	}
	
	public List<InvoiceLine> getLines() {
		return getLines(this);
	}

	static List<InvoiceLine> getLines(InvoiceType doc) {
		List<InvoiceLineType> lines = doc.getInvoiceLine();
		List<InvoiceLine> resultLines = new ArrayList<InvoiceLine>(lines.size());
		lines.forEach(line -> {
			resultLines.add(new InvoiceLine(line));
		});
		return resultLines;
	}

// ----------------------------------
	public List<Map<Object,String>> getSellerTaxSchemes() {
		Party party = getSellerParty();
		return party.getTaxSchemes();
	}

	public List<Map<Object,String>> getBuyerTaxSchemes() { 
		Party party = getBuyerParty();
		return party.getTaxSchemes();
	}

	// Address
	public void setSellerPostalAddress(Address address) {
		Party party = getSellerParty();
		party.setAddress(address);
	}
	
	public Address getSellerPostalAddress() {
		Party party = getSellerParty();
		return party.getAddress();
	}
	
	public void setBuyerrPostalAddress(Address address) {
		Party party = getBuyerParty();
		party.setAddress(address);
	}
	
	public Address getBuyerPostalAddress() {
		Party party = getBuyerParty();
		return party.getAddress();
	}
		
	// Contact
	public void setSellerContact(Contact contact) {
		Party party = getSellerParty();
		party.setContact(contact);
	}
	
	public IContact getSellerContact() {
		Party party = getSellerParty();
		return party.getIContact();
	}
	
	public void setBuyerContact(Contact contact) {
		Party party = getBuyerParty();
		party.setContact(contact);
	}
	
	public IContact getBuyerContact() {
		Party party = getBuyerParty();
		return party.getIContact();
	}
	
	static IDType newIDType(String value, String schemeID) {
		IDType ID = new IDType();
		ID.setValue(value);
		ID.setSchemeID(schemeID);
		return ID;
	}

}
