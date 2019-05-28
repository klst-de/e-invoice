package com.klst.ubl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.klst.cius.DocumentTotals;
import com.klst.cius.IContact;
import com.klst.cius.PostalAddress;
import com.klst.un.unece.uncefact.Amount;
import com.klst.un.unece.uncefact.IBANId;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.OrderReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyLegalEntityType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyTaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuyerReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyLegalFormType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineExtensionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PayableAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxExemptionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxInclusiveAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxableAmountType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.IdentifierType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.TextType;

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
public class Invoice extends InvoiceType implements DocumentTotals {

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
	
	Invoice() {
		super();
	}
	
	public Invoice(String customization, DocumentNameCode documentNameCode) {
		this(customization, null, documentNameCode);
	}
	
	public Invoice(String customization, String profile, DocumentNameCode documentNameCode) {
		this();
		setProcessControl(customization, profile);
			
		// Invoice type code                           BT-3
		// Ein Code, der den Funktionstyp der Rechnung angibt.
		InvoiceTypeCodeType itc = new InvoiceTypeCodeType();
		itc.setValue(documentNameCode.getValueAsString());
		this.setInvoiceTypeCode(itc);		
	}
	
	// copy-ctor
	Invoice(InvoiceType invoice) {
		this(getCustomizationID(invoice), getProfileID(invoice), getDocumentNameCode(invoice));
		setId(getId(invoice));
		setIssueDate(getIssueDateAsTimestamp(invoice));
		addNotes(invoice);
		setPaymentCurrencyCode(getPaymentCurrency(invoice));
		setDocumentCurrencyCode(getDocumentCurrency(invoice));
		setBuyerReference(getBuyerReferenceValue(invoice));
		setOrderReferenceID(getOrderReferenceID(invoice));
		addSellerLegalEntities(invoice);
		addBuyerLegalEntities(invoice);
		addSellerTaxSchemes(invoice);
		addSellerPartyNames(invoice);
		setSellerPostalAddress(getSellerPostalAddress(invoice));
		setBuyerPostalAddress(getBuyerPostalAddress(invoice));
		setSellerContact(getSellerContact(invoice));
		setBuyerContact(getBuyerContact(invoice));
		setDocumentTotals(invoice);
		setInvoiceTax(getInvoiceTax(invoice));
		addPaymentInstructions(invoice);
		addPaymentTerms(invoice);
		addVATBreakDown(invoice);
		addInvoiceLines(invoice);
	}
	
	public DocumentNameCode getDocumentNameCode() {
		return getDocumentNameCode(this);
	}
	static DocumentNameCode getDocumentNameCode(InvoiceType invoice) {
		return DocumentNameCode.valueOf(invoice.getInvoiceTypeCode());
	}

	/* PROCESS CONTROL                             BG-2                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, 
	 * die Informationen über den Geschäftsprozess und für die Rechnung geltende Regeln liefern.
	 */
	/**
	 * mandatory group PROCESS CONTROL
	 * contains ProfileID and CustomizationID. 
	 * 
	 * ProfileID identifies what business process a given message is part of, 
	 * and CustomizationID identifies the kind of message and the rules applied.
	 * 
	 * @param customization, not null
	 * @param profile (optional)
	 */
	void setProcessControl(String customization, String profile) {
		CustomizationIDType customizationID = new CustomizationIDType();
		customizationID.setValue(customization);
//		customizationID.setSchemeID("XRECHNUNG");
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
	static String getCustomizationID(InvoiceType invoice) {
		CustomizationIDType customizationID =invoice.getCustomizationID();
		LOG.info("getSchemeAgencyID:"+customizationID.getSchemeAgencyID() +
				" SchemeAgencyName:"+customizationID.getSchemeAgencyName() +
				" Value:"+customizationID.getValue()
				);
		return customizationID.getValue();
	}
	
	public String getProfile() {
		return getProfileID(this);
	}
	static String getProfileID(InvoiceType invoice) {
		ProfileIDType profileID = invoice.getProfileID();
		if(profileID==null) {
			return null;
		}
		return profileID.getValue();
	}

	/* Invoice number                              BT-1  Identifier            1 (mandatory) 
	 * Eine eindeutige Kennung der Rechnung, die diese im System des Verkäufers identifiziert.
	 * Anmerkung: Es ist kein „identification scheme“ zu verwenden.
	 */
	public void setId(String id) {
		IDType mID = new IDType();
		mID.setValue(id);
		this.setID(mID);
	}
	public String getId() {
		return getId(this);
	}
	static String getId(InvoiceType invoice) {
		return invoice.getID().getValue();
	}

	/* Invoice issue date                          BT-2  Date                  1 (mandatory) 
	 * Das Datum, an dem die Rechnung ausgestellt wurde.
	 */
	public void setIssueDate(String ymd) {	
		Timestamp ts = null;
		try {
			//Timestamp.valueOf("yyyy-[m]m-[d]d hh:mm:ss[.f...]"); // JDBC timestamp escape format
			ts = Timestamp.valueOf(ymd);
		} catch (IllegalArgumentException e) {
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				ts = new Timestamp(((java.util.Date)df.parse(ymd)).getTime());
			} catch (ParseException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		setIssueDate(ts);
	}
	public void setIssueDate(Timestamp ts) {
        LocalDateTime ldt = ts.toLocalDateTime();
        XMLGregorianCalendar cal = null;
		try {
			cal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cal.setYear(ldt.getYear());
        cal.setMonth(ldt.getMonthValue());
        cal.setDay(ldt.getDayOfMonth());
        cal.setHour(ldt.getHour());
        cal.setMinute(ldt.getMinute());
        cal.setSecond(ldt.getSecond());
		IssueDateType issueDate = new IssueDateType();
		issueDate.setValue(cal); //XMLGregorianCalendar
		this.setIssueDate(issueDate);
	}
	public Timestamp getIssueDateAsTimestamp() {  // bei gleichen Namen getIssueDate() kann es nicht abgeleitet sein
		return getIssueDateAsTimestamp(this);
	}
	static Timestamp getIssueDateAsTimestamp(InvoiceType invoice) {
		IssueDateType issueDate = invoice.getIssueDate();
		XMLGregorianCalendar cal = issueDate.getValue();
		long timeInMillis = cal.toGregorianCalendar().getTimeInMillis();
		return new Timestamp(timeInMillis);
	}
	
	/* INVOICE NOTE                                BG-1                        0..*
	 * Eine Gruppe von Informationselementen für rechnungsrelevante Erläuterungen mit Hinweisen auf den Rechnungsbetreff.
	 * 

Invoice note subject code BT-21 Code 0..1 56  ???? TODO finde ich nicht in UBL
Der Betreff für den nachfolgenden Textvermerk zur Rechnung.
Anmerkung: Die Auswahl erfolgt aus UNTDID 4451a.

Invoice note BT-22 Text 1 58
Ein Textvermerk, der unstrukturierte Informationen enthält, die für die Rechnung als Ganzes maßgeblich sind. 
Erforderlichenfalls können Angaben zur Aufbewahrungspflicht gem. § 14 Abs. 4 UStG hier aufgenommen werden.
Anmerkung: Im Falle einer bereits fakturierten Rechnung kann hier z. B. der Grund der Korrektur angegeben werden

	 */
	/**
	 * Adds an optional INVOICE NOTE 
	 * 
	 * @param invoiceNote
	 * @return noteList
	 */
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
	static List<String> getNotes(InvoiceType invoice) {
		List<NoteType> notes = invoice.getNote();
		List<String> res = new ArrayList<String>(notes.size());
		notes.forEach(note -> res.add(note.getValue()));
		return res;
	}
	List<NoteType> addNotes(InvoiceType invoice) {
		List<NoteType> notes = invoice.getNote();
		List<NoteType> n = this.getNote();
		notes.forEach(note -> {
			n.add(note);
			LOG.info(note.getValue() +" "+n.size());
			});
		LOG.info(this.getNote().size() +" "+n.size());
		return n;
	}
	
	/* Invoice currency code                       BT-5  Code                  1 (mandatory) 
	 * Die Währung, in der alle Rechnungsbeträge angegeben werden, 
	 * ausgenommen ist der Umsatzsteuer-Gesamtbetrag, der in der Abrechnungswährung anzugeben ist.
	 * Anmerkung: Nur eine Währung ist in der Rechnung zu verwenden, 
	 * der „Invoice total VAT amount in accounting currency“ (BT-111) ist in der Abrechnungswährung auszuweisen. 
	 * Die gültigen Währungen sind bei der ISO 4217 „Codes for the representation of currencies and funds“ registriert.
	 * 
	 * in 01.01a-INVOICE_ubl.xml nicht definiert obwohl mandatory! 
	 * ist damit also DocumentCurrencyCode gemeint?
	 */
	public void setPaymentCurrencyCode(String isoCurrencyCode) {
		PaymentCurrencyCodeType paymentCurrencyCode = new PaymentCurrencyCodeType();
		paymentCurrencyCode.setValue(isoCurrencyCode); 
		this.setPaymentCurrencyCode(paymentCurrencyCode);
	}
	public String getPaymentCurrency() {
		return getPaymentCurrency(this);
	}
	static String getPaymentCurrency(InvoiceType invoice) {
		PaymentCurrencyCodeType code = invoice.getPaymentCurrencyCode();
		if(code==null) {
			return null;
		}
		return code.getValue();
	}

	// nicht in XRechnung-v1-2-0.pdf dokumentiert, also optional
	public void setDocumentCurrencyCode(String isoCurrencyCode) {
		DocumentCurrencyCodeType documentCurrencyCode = new DocumentCurrencyCodeType();
		documentCurrencyCode.setValue(isoCurrencyCode);
		this.setDocumentCurrencyCode(documentCurrencyCode);
	}
	public String getDocumentCurrency() {
		return getDocumentCurrency(this);
	}
	static String getDocumentCurrency(InvoiceType invoice) {
		DocumentCurrencyCodeType code = invoice.getDocumentCurrencyCode();
		if(code==null) {
			return null;
		}
		return code.getValue();
	}
	
	/* Buyer reference                             BT-10 Text                  1 (mandatory) 
	 * Ein vom Erwerber zugewiesener und für interne Lenkungszwecke benutzter Bezeichner
	 */
	public void setBuyerReference(String reference) {
		BuyerReferenceType buyerReference = new BuyerReferenceType();
		buyerReference.setValue(reference);
		this.setBuyerReference(buyerReference);
	}
	public String getBuyerReferenceValue() {
		return getBuyerReferenceValue(this);
	}
	static String getBuyerReferenceValue(InvoiceType invoice) {
		return invoice.getBuyerReference().getValue();
	}

	// TODO raus oder deprecated
	public String getSellerRegistrationName() {
		return getOrderReferenceID(this);
	}
	
	// nicht in XRechnung-v1-2-0.pdf beschrieben
	public void setOrderReferenceID(String id) {
		OrderReferenceType orderReference = new OrderReferenceType();
		IDType mID = new IDType();
		mID.setValue(id);
		orderReference.setID(mID);
		this.setOrderReference(orderReference);
	}
	public String getOrderReferenceID() {
		return getOrderReferenceID(this);
	}
	static String getOrderReferenceID(InvoiceType invoice) {
		OrderReferenceType id = invoice.getOrderReference();
		if(id==null) {
			return null;
		}
		return id.getID().getValue();
	}
	
	/* PRECEDING INVOICE REFERENCE                 BG-3                        0..*
	 * Eine Gruppe von Informationselementen, die Informationen über eine vorausgegangene Rechnung liefern, 
	 * die berichtigt oder gutgeschrieben werden soll. 
	 */
	void setPrecedingInvoiceReference(String customization, String profile) {
		// TODO
		LOG.warning("NOT implemented");
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
	 * Seller is mandatory information and provided in element cac:AccountingSupplierParty
	 * 
	 * @param sellerRegistrationName mandatory
	 * @param postalAddress mandatory group
	 * @param contact mandatory group
	 * @param taxCompanyId optional / Seller VAT identifier, BT-31
	 * @param companyId optional / Seller legal registration identifier, BT-30
	 * @param companyLegalForm optional / Seller additional legal information, BT-33
	 */
	public void setSeller(String sellerRegistrationName, PostalAddress postalAddress, IContact contact, 
			String taxCompanyId, String companyId, String companyLegalForm) {
		PartyType party = new PartyType();
		
		addLegalEntities(party, sellerRegistrationName, companyId, companyLegalForm);
		addPartyTaxScheme(party, taxCompanyId);
		
		party.setPostalAddress((AddressType)postalAddress);
		party.setContact(new Contact(contact));
		
//		List<PersonType> persons = party.getPerson(); // TODO, nicht in XRechnung-v1-2-0.pdf dokumentiert
		
		SupplierPartyType supplierParty = new SupplierPartyType();
		supplierParty.setParty(party);
		this.setAccountingSupplierParty(supplierParty);
	}

	// wg. [BR-DE-16] In der Rechnung muss mindestens eines der Elemente "Seller VAT identifier" (BT-31), 
	//                "Seller tax registration identifier" (BT-32) 
	//                oder "SELLER TAX REPRESENTATIVE PARTY" (BG-11) übermittelt werden. 
	// Die Umsatzsteuer-Identifikationsnummer des Verkäufers.
	private void addPartyTaxScheme(PartyType party, String companyId)  {
		if(companyId==null) return;
		List<PartyTaxSchemeType> partyTaxSchemeList = party.getPartyTaxScheme();
		PartyTaxSchemeType partyTaxScheme = new PartyTaxSchemeType();
		CompanyIDType companyID = new CompanyIDType();
		companyID.setValue(companyId);
		partyTaxScheme.setCompanyID(companyID);
		
		TaxSchemeType taxScheme = VatCategory.getVatScheme("DE"); // wg. https://github.com/klst-de/e-invoice/issues/1
		partyTaxScheme.setTaxScheme(taxScheme);
		partyTaxSchemeList.add(partyTaxScheme);	
	}
	
	public List<Map<Object,String>> getSellerTaxSchemes() { 
		return getSellerTaxSchemes(this);
	}

	static List<Map<Object,String>> getSellerTaxSchemes(InvoiceType invoice) { 
		PartyType party = invoice.getAccountingSupplierParty().getParty();
		if(party==null) {
			return new ArrayList<Map<Object,String>>();
		}
		return getTaxSchemes(party);
	}
	
	public List<Map<Object,String>> getBuyerTaxSchemes() { 
		return getBuyerTaxSchemes(this);
	}

	static List<Map<Object,String>> getBuyerTaxSchemes(InvoiceType invoice) { 
		PartyType party = invoice.getAccountingCustomerParty().getParty();
		if(party==null) {
			return new ArrayList<Map<Object,String>>();
		}
		return getTaxSchemes(party);
	}
	
	private static List<Map<Object,String>> getTaxSchemes(PartyType party) { 
		LOG.info("party:"+party);
		List<PartyTaxSchemeType> partyTaxSchemes = party.getPartyTaxScheme();
		List<Map<Object,String>> resultList = new ArrayList<Map<Object,String>>(partyTaxSchemes.size());
		LOG.info("partyTaxSchemes#:"+partyTaxSchemes.size() + " resultList#:"+resultList.size());
		partyTaxSchemes.forEach(partyTaxScheme -> {
			Map<Object,String> map = new HashMap<Object,String>();
			TaxSchemeType taxScheme = partyTaxScheme.getTaxScheme();
			IdentifierType taxSchemeID = null;
			if(taxScheme!=null) {
				taxSchemeID = taxScheme.getID();
			}	
			map.put(TaxSchemeType.class, taxSchemeID.getValue());
			resultList.add(map);
			IdentifierType companyID = partyTaxScheme.getCompanyID();
			map.put(CompanyIDType.class, companyID.getValue());
			resultList.add(map);
		});
		LOG.info("resultList#:"+resultList.size());
		return resultList;
	}
	
	List<PartyTaxSchemeType> addSellerTaxSchemes(InvoiceType invoice) {
		SupplierPartyType supplierParty = invoice.getAccountingSupplierParty();
		PartyType party = null;
		if(supplierParty!=null) {
			party = supplierParty.getParty();
		}
		PartyType myParty = getSupplierParty();
		LOG.info("SupplierParty:"+myParty);
		return addPartyTaxSchemes(myParty.getPartyTaxScheme(), party);
	}
	
	private List<PartyTaxSchemeType> addPartyTaxSchemes(List<PartyTaxSchemeType> myPartyTaxSchemes, PartyType party) {
		if(party==null) {
			return myPartyTaxSchemes;
		}
		List<PartyTaxSchemeType> partyTaxSchemes = party.getPartyTaxScheme();
		partyTaxSchemes.forEach(partyTaxScheme -> {
			myPartyTaxSchemes.add(partyTaxScheme);
			IdentifierType companyID = partyTaxScheme.getCompanyID();
			String companyIDvalue = companyID==null ? "null" : companyID.getValue();
			TaxSchemeType taxScheme = partyTaxScheme.getTaxScheme();
			IdentifierType taxSchemeID = null;
			if(taxScheme!=null) {
				taxSchemeID = taxScheme.getID();
			}	
			String taxSchemeIDValue = taxSchemeID==null ? "null" : taxSchemeID.getValue();
			LOG.info("TaxSchemeID:"+taxSchemeIDValue +" CompanyID:"+companyIDvalue +" "+myPartyTaxSchemes.size());
		});
		LOG.info(this.getAccountingSupplierParty().getParty() +" "+myPartyTaxSchemes.size());
		return myPartyTaxSchemes;
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

	public void setSellerContact(Contact contact) {
		PartyType party = getSupplierParty();
		party.setContact((ContactType)contact);
	}
	
	public Contact getSellerContact() {
		return getSellerContact(this);
	}
	
	static Contact getSellerContact(InvoiceType invoice) {
		SupplierPartyType supplierParty = invoice.getAccountingSupplierParty();
		PartyType party = supplierParty==null ? null : supplierParty.getParty();
		return getPartyContact(party);
	}
	
	public void setBuyerContact(Contact contact) {
		PartyType party = getCustomerParty();
		party.setContact((ContactType)contact);
	}
	
	public Contact getBuyerContact() {
		return getBuyerContact(this);
	}
	
	static Contact getBuyerContact(InvoiceType invoice) {
		CustomerPartyType customerParty = invoice.getAccountingCustomerParty();
		PartyType party = customerParty==null ? null : customerParty.getParty();
		return getPartyContact(party);
	}
	
	static Contact getPartyContact(PartyType party) {
		ContactType contact = party.getContact();
		if(contact==null) { // BuyerContact ist optional
			return null;
		}
		return new Contact(contact);
	}

	public void addSellerPartyName(String name) {
		PartyType party = getSupplierParty();
		PartyNameType partyName = new PartyNameType();
		NameType n = new NameType();
		n.setValue(name);
		partyName.setName(n);
		party.getPartyName().add(partyName);
	}
	
	List<PartyNameType> addSellerPartyNames(InvoiceType invoice) {
		SupplierPartyType supplierParty = invoice.getAccountingSupplierParty();
		PartyType party = null;
		if(supplierParty!=null) {
			party = supplierParty.getParty();
		}
		PartyType myParty = getSupplierParty();
		return addSellerPartyNames(myParty.getPartyName(), party);
	}

	private List<PartyNameType> addSellerPartyNames(List<PartyNameType> myPartyNames, PartyType party) {
		if(party==null) {
			return myPartyNames;
		}
		List<PartyNameType> partyNames = party.getPartyName();
		partyNames.forEach(partyName -> {
			myPartyNames.add(partyName);
		});
		return myPartyNames;
	}

	public List<String> getSellerPartyNames() {
		return getSellerPartyNames(this);
	}
	
	static List<String> getSellerPartyNames(InvoiceType invoice) {
		SupplierPartyType supplierParty = invoice.getAccountingSupplierParty();
		PartyType party = supplierParty==null ? null : supplierParty.getParty();
		List<PartyNameType> partyNames = party.getPartyName();
		List<String> result = new ArrayList<String>(partyNames.size());
		partyNames.forEach(partyName -> {
			result.add(partyName.getName().getValue());
		});
		return result;
	}
	
	public void setSellerPostalAddress(Address address) {
		PartyType party = getSupplierParty();
		party.setPostalAddress((AddressType)address);
	}
	
	public Address getSellerPostalAddress() {
		return getSellerPostalAddress(this);
	}
	
	static Address getSellerPostalAddress(InvoiceType invoice) {
		SupplierPartyType supplierParty = invoice.getAccountingSupplierParty();
		PartyType party = supplierParty==null ? null : supplierParty.getParty();
		return getPartyPostalAddress(party);
	}
	
	public void setBuyerPostalAddress(Address address) {
		PartyType party = getCustomerParty();
		party.setPostalAddress((AddressType)address);
	}
	
	public Address getBuyerPostalAddress() {
		return getBuyerPostalAddress(this);
	}
	
	static Address getBuyerPostalAddress(InvoiceType invoice) {
		CustomerPartyType customerParty = invoice.getAccountingCustomerParty();
		PartyType party = customerParty==null ? null : customerParty.getParty();
		return getPartyPostalAddress(party);
	}
	
	static Address getPartyPostalAddress(PartyType party) {
		AddressType address = party.getPostalAddress();
		return new Address(address);
	}

	/**
	 * add LegalEntities for seller or buyer
	 * 
	 * @param party, seller or buyer
	 * @param registrationName mandatory
	 * @param companyId optional / legal registration identifier, BT-30
	 * @param companyLegalForm optional / additional legal information, BT-33
	 */
	private void addLegalEntities(PartyType party, String name, String companyId, String companyLegalForm)  {
		List<PartyLegalEntityType> partyLegalEntities = party.getPartyLegalEntity();
		PartyLegalEntityType partyLegalEntity = new PartyLegalEntityType();
		RegistrationNameType registrationName = new RegistrationNameType();
		registrationName.setValue(name);
		partyLegalEntity.setRegistrationName(registrationName);
		if(companyId!=null) {
			CompanyIDType companyID = new CompanyIDType();
			companyID.setValue(companyId);
			partyLegalEntity.setCompanyID(companyID);
		}
		if(companyLegalForm!=null) {
			CompanyLegalFormType clf = new CompanyLegalFormType();
			clf.setValue(companyLegalForm);
			partyLegalEntity.setCompanyLegalForm(clf);
		}
		partyLegalEntities.add(partyLegalEntity);
	}
	
	public List<Map<Object,String>> getSellerLegalEntities() { 
		return getSellerLegalEntities(this);
	}
	
	public List<Map<Object,String>> getBuyerLegalEntities() { 
		return getBuyerLegalEntities(this);
	}
	
	static List<Map<Object,String>> getSellerLegalEntities(InvoiceType invoice) { 
		PartyType party = invoice.getAccountingSupplierParty().getParty();
		if(party==null) {
			return new ArrayList<Map<Object,String>>();
		}
		return getPartyLegalEntities(party);
	}
	
	static List<Map<Object,String>> getBuyerLegalEntities(InvoiceType invoice) { 
		PartyType party = invoice.getAccountingCustomerParty().getParty();
		if(party==null) {
			return new ArrayList<Map<Object,String>>();
		}
		return getPartyLegalEntities(party);
	}
	
	private static List<Map<Object,String>> getPartyLegalEntities(PartyType party) { 
		List<PartyLegalEntityType> partyLegalEntities = party.getPartyLegalEntity();
		SupplierPartyType supplierParty = new SupplierPartyType();
		PartyType myParty = new PartyType();
		supplierParty.setParty(myParty);
		List<PartyLegalEntityType> myPartyLegalEntities = myParty.getPartyLegalEntity(); // nur wg info TODO raus
		List<Map<Object,String>> result = new ArrayList<Map<Object,String>>(partyLegalEntities.size());
		partyLegalEntities.forEach(partyLegalEntity -> {
			Map<Object,String> map = new HashMap<Object,String>();
			myPartyLegalEntities.add(partyLegalEntity);
			RegistrationNameType registrationName = partyLegalEntity.getRegistrationName();
			String name = registrationName==null ? "null" : registrationName.getValue();
			map.put(RegistrationNameType.class, name);
			IdentifierType companyID = partyLegalEntity.getCompanyID();
			String companyIDvalue = companyID==null ? "null" : companyID.getValue();
			map.put(CompanyIDType.class, companyIDvalue);			
			TextType companyLegalForm = partyLegalEntity.getCompanyLegalForm();
			String companyLegalFormValue = companyLegalForm==null ? "null" : companyLegalForm.getValue();
			map.put(CompanyLegalFormType.class, companyLegalFormValue);	
			LOG.info("getPartyLegalEntities RegistrationName:"+name +" CompanyID:"+companyIDvalue +" CompanyLegalForm:"+companyLegalFormValue +" "+myPartyLegalEntities.size());
			result.add(map);
		});
		return result;
	}
	
	List<PartyLegalEntityType> addSellerLegalEntities(InvoiceType invoice) {
		SupplierPartyType supplierParty = invoice.getAccountingSupplierParty();
		PartyType party = null;
		if(supplierParty!=null) {
			party = supplierParty.getParty();
		}
		PartyType myParty = getSupplierParty();
		LOG.info("SupplierParty:"+myParty);
		return addPartyLegalEntities(myParty.getPartyLegalEntity(), party);
	}
	
	List<PartyLegalEntityType> addBuyerLegalEntities(InvoiceType invoice) {
		CustomerPartyType customerParty = invoice.getAccountingCustomerParty();
		PartyType party = null;
		if(customerParty!=null) {
			party = customerParty.getParty();
		}
		PartyType myParty = getCustomerParty();
		return addPartyLegalEntities(myParty.getPartyLegalEntity(), party);
	}
	
	private PartyType getSupplierParty() {
		SupplierPartyType supplierParty = this.getAccountingSupplierParty();
		if(supplierParty!=null) {
			return supplierParty.getParty();
		}
		// add empty supplierParty and party to this:
		supplierParty = new SupplierPartyType();
		PartyType party = new PartyType();
		supplierParty.setParty(party);
		this.setAccountingSupplierParty(supplierParty);
		return party;
	}
	
	private PartyType getCustomerParty() {
		CustomerPartyType customerParty = this.getAccountingCustomerParty();
		if(customerParty!=null) {
			return customerParty.getParty();
		}
		// add empty customerParty and party to this:
		customerParty = new CustomerPartyType();
		PartyType party = new PartyType();
		customerParty.setParty(party);
		this.setAccountingCustomerParty(customerParty);
		return party;
	}

	
	private List<PartyLegalEntityType> addPartyLegalEntities(List<PartyLegalEntityType> myPartyLegalEntities, PartyType party) {
		if(party==null) {
			return myPartyLegalEntities;
		}
		List<PartyLegalEntityType> partyLegalEntities = party.getPartyLegalEntity();
		partyLegalEntities.forEach(partyLegalEntity -> {
			myPartyLegalEntities.add(partyLegalEntity);
			RegistrationNameType registrationName = partyLegalEntity.getRegistrationName();
			String name = registrationName==null ? "null" : registrationName.getValue();
			IdentifierType companyID = partyLegalEntity.getCompanyID();
			String companyIDvalue = companyID==null ? "null" : companyID.getValue();
			TextType companyLegalForm = partyLegalEntity.getCompanyLegalForm();
			String companyLegalFormValue = companyLegalForm==null ? "null" : companyLegalForm.getValue();
			LOG.info("addPartyLegalEntities RegistrationName:"+name +" CompanyID:"+companyIDvalue +" CompanyLegalForm:"+companyLegalFormValue +" "+myPartyLegalEntities.size());
		});
		LOG.info(this.getAccountingSupplierParty().getParty() +" "+myPartyLegalEntities.size());
		return myPartyLegalEntities;
	}

	/**
	 *  Buyer (AccountingCustomerParty)
	 *  Buyer is mandatory information and provided in element cac:AccountingCustomerParty
	 *  
	 * @param buyerName mandatory - !!! so ist es dokumentiert, BT-44 meint aber registrationName!
	 * @param postalAddress mandatory
	 * @param contact optional
	 */
	public void setBuyer(String buyerName, PostalAddress postalAddress, IContact contact) {
		PartyType party = new PartyType();
		
		addLegalEntities(party, buyerName, null, null); // ohne String companyId, String companyLegalForm
		
		// BT-46:
//		List<PartyIdentificationType> partyIdentifications = party.getPartyIdentification();
//		PartyIdentificationType partyIdentification = new PartyIdentificationType();
//		IDType buyerID = new IDType();
//		buyerID.setValue(buyerId);
//		partyIdentification.setID(buyerID);
//		partyIdentifications.add(partyIdentification);
		
		// => TODO name ist optional : buyerTradingName                          BT-45
		
		party.setPostalAddress((AddressType)postalAddress);
		if(contact!=null) { // optional
			party.setContact(new Contact(contact));
		}

		CustomerPartyType customerParty = new CustomerPartyType();
		customerParty.setParty(party);
		
		this.setAccountingCustomerParty(customerParty);
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
	
	static Amount getInvoiceTax(InvoiceType invoice) {
		TaxTotalType taxTotal = getFirstTaxTotal(invoice);
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
	
	// TODO Bauselle - die mandatories:
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
	
	static Amount getInvoiceLineNetTotal(InvoiceType invoice) {
		MonetaryTotalType monetaryTotal = invoice.getLegalMonetaryTotal();
		return getInvoiceLineNetTotal(monetaryTotal);
	}
	private static Amount getInvoiceLineNetTotal(MonetaryTotalType monetaryTotal) {
		LineExtensionAmountType amount = monetaryTotal.getLineExtensionAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getInvoiceTotalTaxExclusive(InvoiceType invoice) {
		MonetaryTotalType monetaryTotal = invoice.getLegalMonetaryTotal();
		return getInvoiceTotalTaxExclusive(monetaryTotal);
	}
	private static Amount getInvoiceTotalTaxExclusive(MonetaryTotalType monetaryTotal) {
		TaxExclusiveAmountType amount = monetaryTotal.getTaxExclusiveAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getInvoiceTotalTaxInclusive(InvoiceType invoice) {
		MonetaryTotalType monetaryTotal = invoice.getLegalMonetaryTotal();
		return getInvoiceTotalTaxInclusive(monetaryTotal);
	}
	private static Amount getInvoiceTotalTaxInclusive(MonetaryTotalType monetaryTotal) {
		TaxInclusiveAmountType amount = monetaryTotal.getTaxInclusiveAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	static Amount getDuePayable(InvoiceType invoice) {
		MonetaryTotalType monetaryTotal = invoice.getLegalMonetaryTotal();
		return getDuePayable(monetaryTotal);
	}
	private static Amount getDuePayable(MonetaryTotalType monetaryTotal) {
		PayableAmountType amount = monetaryTotal.getPayableAmount();
		return new Amount(amount.getCurrencyID(), amount.getValue());		
	}
	
	void setDocumentTotals(InvoiceType invoice) {
		MonetaryTotalType monetaryTotal = invoice.getLegalMonetaryTotal();
		Amount lineExtension = getInvoiceLineNetTotal(monetaryTotal);
		Amount taxExclusive = getInvoiceTotalTaxExclusive(monetaryTotal);
		Amount taxInclusive = getInvoiceTotalTaxInclusive(monetaryTotal);
		Amount payable = getDuePayable(monetaryTotal);
		setDocumentTotals(lineExtension, taxExclusive, taxInclusive, payable);
	}
	
	/**
	 * mandatory total amounts of the invoice
	 * 
	 * @param lineExtension : Sum of Invoice line net amount
	 * @param taxExclusive : Invoice total amount without VAT
	 * @param taxInclusive : Invoice total amount with VAT
	 * @param payable : Amount due for payment 
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

	 */
	/**
	 * Adds a mandatory PAYMENT INSTRUCTIONS Group with ibanlAccount as CREDIT TRANSFER
	 * 
	 * @param enum paymentMeansCode, use PaymentMeansCode.CreditTransfer or PaymentMeansCode.SEPACreditTransfer
	 * @param String iban to create ibanlAccount element
	 * @param String remittanceInformation optional
	 * @return paymentMeansList with minimum 1 element
	 */
	public List<PaymentMeansType> addPaymentInstructions(PaymentMeansCode paymentMeansCode, IBANId iban, String remittanceInformation) {
		FinancialAccountType ibanlAccount = new CreditTransfer(iban);
		return addPaymentInstructions(paymentMeansCode, ibanlAccount, remittanceInformation);
	}
	
	public List<PaymentInstruction> getPaymentInstructions() {
		return getPaymentInstructions(this);
	}
	static List<PaymentInstruction> getPaymentInstructions(InvoiceType invoice) {
		List<PaymentMeansType> paymentMeansList = invoice.getPaymentMeans();
		List<PaymentInstruction> result = new ArrayList<PaymentInstruction>(paymentMeansList.size());
		paymentMeansList.forEach(paymentMeans -> {
			result.add(new PaymentInstruction(paymentMeans));
		});
		return result;
	}
	
	public List<PaymentMeansType> addPaymentInstructions(InvoiceType invoice) {
		List<PaymentMeansType> myPaymentMeansList = this.getPaymentMeans();
		List<PaymentMeansType> paymentMeansList = invoice.getPaymentMeans();
		LOG.info("invoice.PaymentMeansList#:"+paymentMeansList.size());
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
		LOG.info("PaymentMeansCode="+paymentMeans.getPaymentMeansCode() + 
				", PayeeFinancialAccount="+paymentMeans.getPayeeFinancialAccount() + 
				", paymentIDs#:"+paymentIDs.size());
		paymentIDs.forEach(paymentID -> {
			myPaymentIDs.add(paymentID);  // darin remittanceInformation
			LOG.info("remittanceInformation:"+paymentID.getValue());
		});
		myPaymentMeansList.add(myPaymentMeans);
		return myPaymentMeansList;
	}

	/**
	 * Adds a mandatory PAYMENT INSTRUCTIONS Group
	 * 
	 * @param enum paymentMeansCode
	 * @param financialAccount
	 * @param remittanceInformation optional
	 * @return paymentMeansList with minimum 1 element
	 */
	public List<PaymentMeansType> addPaymentInstructions(PaymentMeansCode paymentMeansCode, FinancialAccountType financialAccount, String remittanceInformation) {
		List<PaymentMeansType> paymentMeansList = this.getPaymentMeans();
		LOG.info("paymentMeansCode:"+paymentMeansCode.toString() + ", paymentMeansList size="+paymentMeansList.size()); // == 0 beim ersten mal	
		PaymentMeansType paymentMeans = new PaymentInstruction(paymentMeansCode, financialAccount, remittanceInformation);
//		PaymentMeansType paymentMeans = new PaymentMeansType();
//		
//		PaymentMeansCodeType paymentMeansCodeValue = new PaymentMeansCodeType();
//		// Payment means type code                     BT-81 Code                  1 (mandatory)
//		//  Das als Code ausgedrückte erwartete oder genutzte Zahlungsmittel:
//		paymentMeansCodeValue.setValue(paymentMeansCode.getValueAsString());
//		// Payment means text                          BT-82 Text                  0..1 optional
//		//  Das in Textform ausgedrückte erwartete oder genutzte Zahlungsmittel:
//// der Validator https://peppol.helger.com/public/locale-en_US/menuitem-validation-bis2 akzeptiert es nicht:
////		paymentMeansCodeValue.setName(paymentMeansCode.toString());
//		paymentMeans.setPaymentMeansCode(paymentMeansCodeValue);
//		
//		// Remittance information                      BT-83 Text                  0..1 optional
//		// Ein Textwert, der zur Verknüpfung der Zahlung mit der vom Verkäufer ausgestellten Rechnung verwendet wird.
//		if(remittanceInformation!=null) {
//			List<PaymentIDType> paymentIDs = paymentMeans.getPaymentID();
//			PaymentIDType paymentID = new PaymentIDType();
//			paymentID.setValue(remittanceInformation);
//			paymentIDs.add(paymentID);
//		}
//		
//		paymentMeans.setPayeeFinancialAccount(financialAccount);
	
		paymentMeansList.add(paymentMeans);
		return paymentMeansList;
	}
	
/* 
  <cac:PaymentTerms>
    <!-- Skonto-Einträge - optional -->
    <!-- Payment terms for discount - optional -->
    <cbc:ID>1</cbc:ID>
    <cbc:Note>3% Skonto bei Zahlung in 5 Tagen/3% discount when paid in 5 days</cbc:Note>
    <cbc:SettlementDiscountPercent>3.00</cbc:SettlementDiscountPercent>
    <cac:SettlementPeriod>
      <cbc:StartDate>2018-01-01</cbc:StartDate>
      <cbc:EndDate>2018-12-30</cbc:EndDate>
    </cac:SettlementPeriod>
  </cac:PaymentTerms>    		
  ...
    <cbc:Note>#SKONTO#TAGE=7#PROZENT=2.00#
#SKONTO#TAGE=14#PROZENT=1.00#
#SKONTO#TAGE=30#PROZENT=0.00#</cbc:Note>
 */
	public List<PaymentTerms> getPaymentTermList() {
		return getPaymentTermList(this);
	}
	
	static List<PaymentTerms> getPaymentTermList(InvoiceType invoice) {
		List<PaymentTermsType> paymentTermsList = invoice.getPaymentTerms();
		List<PaymentTerms> result = new ArrayList<PaymentTerms>(paymentTermsList.size());
		paymentTermsList.forEach(paymentTerms -> {
			result.add(new PaymentTerms(paymentTerms));
		});
		return result;
	}
	
	List<PaymentTermsType> addPaymentTerms(InvoiceType invoice) {
		List<PaymentTermsType> paymentTermsList = invoice.getPaymentTerms();
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

//	List<DeliveryType> deliveryList = this.getDelivery();   // TODO
	public List<DeliveryType> addDelivery() {
		List<DeliveryType> deliveryList = this.getDelivery();
/* TODO
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


	// Gruppe CREDIT TRANSFER
/*

Name                                        ID    Semantischer Datentyp Anz. 
Payment account identifier                  BT-84 Identifier            1 
Die Kennung des Kontos, auf das die Zahlung erfolgen soll: 
 IBAN für Zahlungen im SEPA-Raum, 
 Kontonummer oder IBAN im Falle von Auslandszahlungen.
Payment account name                        BT-85 Text                  0..1
Name des Kontos bei einem Zahlungsdienstleister, auf das die Zahlung erfolgen soll. (z. B. Kontoinhaber)
Payment service provider identifier         BT-86 Identifier            0..1
Die Kennung des Konto führenden Kreditinstitutes, ergibt sich bei Zahlungen im SEPA-Raum im Regelfall aus IBAN;
für Auslandszahlungen, bei denen um BIC ergänzt werden muss:

• für alle Zahlungen an Bankverbindungen des SEPA-Raumes als SCT (Code 31 des „Payment means type code“
(BT-81)) oder SDD (Code 49 des „Payment means type code“ (BT-81)) mit Ausnahme der nachstehenden Ausnahmen,
reicht die Angabe der IBAN, die in der Länge variiert; BIC nicht erforderlich. Ausnahmen: z. B. San
Marino, Monaco, Schweiz, Saint Pierre und Miquelon, wobei die Länge der IBAN variiert, aber immer 1. und 2.
Stelle = Ländercode nach ISO, 3. und 4. Stelle = Prüfziffer; Angabe des BIC ist neben der Angabe der IBAN
zwingend erforderlich
• für alle Zahlungen an Bankverbindungen außerhalb des SEPA-Raumes (Code 42 des „Payment means type
code“ (BT-81)) sind, abhängig vom empfangenden Institut, IBAN bzw. Kontonummer und BIC nötig

@see die zwei ctor in Klasse : CreditTransfer extends FinancialAccountType
 */	
	
	/* VAT BREAKDOWN                               BG-23                       1..* (mandatory)
	 * Eine Gruppe von Informationselementen, die Informationen über die Umsatzsteueraufschlüsselung in verschiedene Kategorien liefern.
	 * 
VAT category taxable amount BT-116 Amount 1 55
Summe aller zu versteuernden Beträge, für die ein bestimmter Code der Umsatzsteuerkategorie und ein bestimmter
Umsatzsteuersatz gelten (falls ein kategoriespezifischer Umsatzsteuersatz gilt).
VAT category tax amount BT-117 Amount 1 55
Der für die betreffende Umsatzsteuerkategorie zu entrichtende Gesamtbetrag.
Anmerkung: Die Berechnung erfolgt durch Multiplikation des VAT category taxable amount mit der VAT category
rate der jeweiligen VAT category.
VAT category code BT-118 Code 1 56
Codierte Bezeichnung einer Umsatzsteuerkategorie.
Anmerkung: Folgende Codes aus der Codeliste UNTDID 5305 werden verwendet:
VAT category rate BT-119 Percentage 1 58
Der Umsatzsteuersatz, angegeben als für die betreffende Umsatzsteuerkategorie geltender Prozentsatz.
Sofern die Rechnung von der Umsatzsteuer ausgenommen ist, ist der Wert „0“ zu übermitteln.
Anmerkung: VAT category code und VAT category rate müssen konsistent sein.
VAT exemption reason text BT-120 Text 0..1 58
In Textform angegebener Grund für die Ausnahme des Betrages von der Umsatzsteuerpflicht. Sofern die Umsatzsteuerkategorie
„AE“ für die Rechnung gilt, ist hier der Text „Umkehrung der Steuerschuldnerschaft“ oder der entsprechende
Normtext in der für die Rechnung gewählten Sprache anzugeben.
VAT exemption reason code BT-121 Code 0..1 56
Ein Code für den Grund für die Ausnahme des Betrages von der Umsatzsteuerpflicht. Die Code-Liste wird von der
Connecting Europe Facility gepflegt und herausgegeben
	 */
	/**
	 * VAT BREAKDOWN
	 * 
	 * @param mandatory taxableAmount : VAT category taxable amount
	 * @param mandatory tax : VAT category tax amount
	 * @param mandatory vatCategory : VAT category code and rate
// TODO	 * optional : VAT exemption reason text
// TODO	 * optional : VAT exemption reason code
	 */
//	public void addVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
	public void addVATBreakDown(Amount taxableAmount, Amount tax, VatCategory vatCategory) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		TaxSubtotalType taxSubtotal = new TaxSubtotalType();
		
		TaxableAmountType taxableAmt = new TaxableAmountType();
		taxableAmount.copyTo(taxableAmt);
		taxSubtotal.setTaxableAmount(taxableAmt);

		TaxAmountType taxAmount = new TaxAmountType();
		tax.copyTo(taxAmount);
		taxSubtotal.setTaxAmount(taxAmount);
		
//		taxSubtotal.setTaxCategory(new VatCategory(taxCategoryCode, taxRate));
		taxSubtotal.setTaxCategory(vatCategory);

		List<TaxSubtotalType> taxSubtotals = taxTotal.getTaxSubtotal(); // VAT BREAKDOWN: in XRechnung-v1-2-0.pdf dokumentiert
		taxSubtotals.add(taxSubtotal);
	}

	public void addVATBreakDown(InvoiceType invoice) {
		TaxTotalType myTaxTotal = getFirstTaxTotal();
		List<TaxSubtotalType> myTaxSubtotals = myTaxTotal.getTaxSubtotal();
		TaxTotalType taxTotal = getFirstTaxTotal(invoice);
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
	List<Map<Object,Object>> getVATBreakDown(InvoiceType invoice) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		return getVATBreakDown(taxTotal);
	}
	private static List<Map<Object,Object>> getVATBreakDown(TaxTotalType taxTotal) {
		List<TaxSubtotalType> taxSubtotals = taxTotal.getTaxSubtotal();
		List<Map<Object,Object>> resultList = new ArrayList<Map<Object,Object>>(taxSubtotals.size());
		taxSubtotals.forEach(taxSubtotal -> {
			Map<Object,Object> map = new HashMap<Object,Object>();
			
			TaxableAmountType taxableAmount = taxSubtotal.getTaxableAmount(); // mandatory
			map.put(TaxableAmountType.class, new Amount(taxableAmount));
			resultList.add(map);
			
			TaxAmountType taxAmount = taxSubtotal.getTaxAmount(); // mandatory
			map.put(TaxAmountType.class, new Amount(taxAmount));
			resultList.add(map);
			
			TaxCategoryType taxCategory = taxSubtotal.getTaxCategory(); // mandatory
			VatCategory vatCategory = new VatCategory(taxCategory);
			map.put(VatCategory.class, vatCategory);
			
			// die optionalen "VAT exemption reason text" und "VAT exemption reason code"
			List<TaxExemptionReasonType> taxExemptionReasons = taxCategory.getTaxExemptionReason();
			taxExemptionReasons.forEach(taxExemptionReason -> {
				vatCategory.addTaxExemptionReason(taxExemptionReason.getValue());
			});
			
			TaxExemptionReasonCodeType taxExemptionReasonCode = taxCategory.getTaxExemptionReasonCode();
			if(taxExemptionReasonCode!=null) {
				vatCategory.setTaxExemptionReasonCode(taxExemptionReasonCode.getValue());
			}
		});
		return resultList;
	}
		
	// so nicht in XRechnung-v1-2-0.pdf dokumentiert
	void addInvioceTax(Amount taxSum) {
		TaxTotalType taxTotal = getFirstTaxTotal();
		TaxAmountType taxAmount = new TaxAmountType();
		taxSum.copyTo(taxAmount);
		taxTotal.setTaxAmount(taxAmount);
	}
	
	// wg. Ungültiger Content wurde beginnend mit Element 'cac:TaxSubtotal' gefunden. '{"urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2":TaxAmount}' wird erwartet.
	private TaxTotalType getFirstTaxTotal() {
		return getFirstTaxTotal(this);
	}
	// das garantiert nur ein taxTotal element
	static private TaxTotalType getFirstTaxTotal(InvoiceType invoice) {
		List<TaxTotalType> taxTotals = invoice.getTaxTotal();
		if(taxTotals.isEmpty()) {
			TaxTotalType taxTotal = new TaxTotalType();
			taxTotals.add(taxTotal);
		}
		return taxTotals.get(0);
	}
	
	/* INVOICE LINE                                BG-25                       1..* (mandatory)
	 * Eine Gruppe von Informationselementen, die Informationen über einzelne Rechnungspositionen liefern.
	 */
	/**
	 * Adds a mandatory invoice line element
	 * 
	 * @param invoiceLine
	 * @return
	 */
	public List<InvoiceLineType> addInvoiceLine(InvoiceLineType invoiceLine) {
		List<InvoiceLineType> invoiceLines = this.getInvoiceLine();
		invoiceLines.add(invoiceLine);
		return invoiceLines;
	}

	public List<InvoiceLineType> addInvoiceLines(InvoiceType invoice) {
		List<InvoiceLineType> invoiceLines = invoice.getInvoiceLine();
		List<InvoiceLineType> resultLines = this.getInvoiceLine();
		invoiceLines.forEach(invoiceLine -> {
			resultLines.add(invoiceLine);
		});
		return resultLines;
	}
	
	public List<InvoiceLineType> addInvoiceLine(InvoiceLine invoiceLine) {
		List<InvoiceLineType> resultLines = this.getInvoiceLine();
		resultLines.add(invoiceLine);
		return resultLines;
	}
	
	public List<InvoiceLine> getInvoiceLines() {
		return getInvoiceLines(this);
	}

	static List<InvoiceLine> getInvoiceLines(InvoiceType invoice) {
		List<InvoiceLineType> invoiceLines = invoice.getInvoiceLine();
		List<InvoiceLine> resultLines = new ArrayList<InvoiceLine>(invoiceLines.size());
		invoiceLines.forEach(invoiceLine -> {
			resultLines.add(new InvoiceLine(invoiceLine));
		});
		return resultLines;
	}

}
