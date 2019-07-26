package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DocumentTotals;
import com.klst.einvoice.PaymentInstructions;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansCode;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.FormattedDateTimeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.DocumentContextParameterType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ExchangedDocumentContextType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ExchangedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeAgreementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeDeliveryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeLineItemType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeTransactionType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementHeaderMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

// @see https://www.unece.org/fileadmin/DAM/cefact/rsm/RSM_CrossIndustryInvoice_v2.0.pdf
//      https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=2ahUKEwijlav-gPjhAhUGU1AKHSv2CIoQFjAAegQIARAC&url=https%3A%2F%2Fwww.unece.org%2Ffileadmin%2FDAM%2Fcefact%2Frsm%2FRSM_CrossIndustryInvoice_v2.0.pdf&usg=AOvVaw0yPVFpbRqJ50xaDMUaYm62
// ZUGFeRD 2.0 Spezifikation - Technischer Anhang : ZUGFeRD-2.0-Spezifikation-TA.pdf
public class CrossIndustryInvoice extends CrossIndustryInvoiceType implements CoreInvoice, DocumentTotals {

	private static final Logger LOG = Logger.getLogger(CrossIndustryInvoice.class.getName());
	
/*
1 .. 1 ExchangedDocumentContext Prozesssteuerung BG-2 xs:sequence 
0 .. 1 TestIndicator Testkennzeichen                  xs:choice 
1 .. 1 Indicator Testkennzeichen, Wert
0 .. 1 BusinessProcessSpecifiedDocumentContextParameter Gruppierung der Geschäftsprozessinformationen xs:sequence 
0 .. 1 ID Geschäftsprozesstyp                    BT-23 
1 .. 1 GuidelineSpecifiedDocumentContextParameter Gruppierung der Anwendungsempfehlungsinformationen xs:sequence 
1 .. 1 ID Spezifikationskennung                  BT-24

1 .. 1 ExchangedDocument Gruppierung der Eigenschaften, die das gesamte Dokument betreffen. xs:sequence 
1 .. 1 ID Rechnungsnummer                        BT-1 
0 .. 1 Name Dokumentenart (Freitext) 
1 .. 1 TypeCode Code für den Rechnungstyp        BT-3 
1 .. 1 IssueDateTime Rechnungsdatum xs:choice 
1 .. 1 DateTimeString Rechnungsdatum             BT-2 required format Datum, Format BT-2-0 
0 .. 1 CopyIndicator xs:choice 
1 .. 1 Indicator 
0 .. 1 LanguageID Sprachkennzeichen 
0 .. n IncludedNote Freitext zur Rechnung        BG-1 xs:sequence
0 .. 1 ContentCode Freitext auf Dokumentenebene 
1 .. 1 Content Freitext zur Rechnung             BT-22 
0 .. 1 SubjectCode Code zur Qualifizierung des Freitextes zur Rechnung BT-21 
0 .. 1 EffectiveSpecifiedPeriod Vertragliches Fälligkeitsdatum der Rechnung xs:sequence 
1 .. 1 CompleteDateTime Vertragliches Fälligkeitsdatum der Rechnung xs:choice 
1 .. 1 DateTimeString Vertragliches Fälligkeitsdatum der Rechnung, Wert required format Datum, Format
 */
	CrossIndustryInvoice() {
		super();
	}

	ApplicableHeaderTradeSettlement applicableHeaderTradeSettlement;
	
	public CrossIndustryInvoice(String customization, DocumentNameCode documentNameCode) {
		this(customization, null, documentNameCode);
	}
	
	public CrossIndustryInvoice(String customization, String profile, DocumentNameCode documentNameCode) {
		this();
		setProcessControl(customization, profile);
		supplyChainTradeTransaction = new SupplyChainTradeTransactionType();
		
		applicableHeaderTradeSettlement = new ApplicableHeaderTradeSettlement(); // class ApplicableHeaderTradeSettlement extends HeaderTradeSettlementType
		supplyChainTradeTransaction.setApplicableHeaderTradeSettlement(applicableHeaderTradeSettlement);
		
		ExchangedDocumentType ed = new ExchangedDocumentType();
		DocumentCodeType documentCode = new DocumentCodeType();
		documentCode.setValue(documentNameCode.getValueAsString());
		ed.setTypeCode(documentCode);
		super.setExchangedDocument(ed);
	}

	// copy-ctor
	public CrossIndustryInvoice(CrossIndustryInvoiceType doc) {
		this(getCustomization(doc), getProfile(doc), getTypeCode(doc));
		supplyChainTradeTransaction = new SupplyChainTradeTransactionType();
		applicableHeaderTradeSettlement = new ApplicableHeaderTradeSettlement(doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement());
		setId(getId(doc));
		setIssueDate(getIssueDateAsTimestamp(doc));
		setDocumentCurrency(getDocumentCurrency(doc));
		setTaxCurrency(getTaxCurrency(doc)); // optional
		setTaxPointDate(getTaxPointDateAsTimestamp(doc)); // optional
		setPaymentTermsAndDate(getPaymentTerm(doc), getDueDateAsTimestamp(doc)); // optional
		setBuyerReference(getBuyerReferenceValue(doc)); // optional
		setOrderReferenceID(getOrderReferenceID(doc)); // optional
//		addPaymentTerms(doc);
		addNotes(doc);	
		setSellerParty(getSellerParty(doc));
		setBuyerParty(getBuyerParty(doc));
//		addDeliveries(doc);
//		addPaymentInstructions(doc);		
//		setDocumentTotals(doc);
//		setInvoiceTax(getInvoiceTax(doc));
		addVATBreakDown(getVATBreakDowns(doc));
		addLines(doc);
	}


	/* Invoice number                              BT-1  Identifier            1 (mandatory) 
	 * Eine eindeutige Kennung der Rechnung, die diese im System des Verkäufers identifiziert.
	 * Anmerkung: Es ist kein „identification scheme“ zu verwenden.

ID Spezifikationskennung . 
Datentyp: udt:IDType . 
Beschreibung: Eine Kennung der Spezifikation, die das gesamte Regelwerk zum semantischen Inhalt, zu den Kardinalitäten und den Geschäftsregeln enthält und zu denen die im Instanzdokument enthaltenen Daten conformant sind . 
Hinweis: In diesem wird die Compliance oder Conformance der Instanz mit diesem Dokument angegeben. Rechnungen, die compliant sind, geben folgendes an: urn:cen.eu:en16931:2017. Rechnungen, die compliant mit einer Benutzerspezifikation sind, dürfen diese Benutzerspezifikation an dieser Stelle angeben. Es ist kein Identifikationsschema zu verwenden. . 
Synonym: Anwendungsempfehlung . 
Kardinalität: 1 .. 1 . 
EN16931-ID: BT-24 . 
Anwendung: Profil EXTENDED: urn:cen.eu:EN16931:2017#conformant#urn:zugferd.de:2p0:extended 
           Profil EN 16931 (COMFORT): urn:cen.eu:EN16931:2017 
           Profil BASIC: urn:cen.eu:EN16931:2017#compliant#urn:zugferd.de:2p0:basic 
           Profil BASIC WL: urn:zugferd.de:2p0:basicwl 
           Profil MINIMUM: urn:zugferd.de:2p0:minimum . 
Geschäftsregel: BR-1 Prozesssteuerung Eine Rechnung muss eine Spezifikationskennung (BT-24) haben.

	 */
	@Override
	public void setId(String id) {
		ExchangedDocumentType ed = this.getExchangedDocument();
		ed.setID(newIDType(id, null)); // null : No identification scheme is to be used.
	}
	
	@Override
	public String getId() {
		return getId(this);
	}
	static String getId(CrossIndustryInvoiceType doc) {
		return doc.getExchangedDocument().getID().getValue();
	}

	/* Invoice issue date                          BT-2  Date                  1 (mandatory) 
	 * Das Datum, an dem die Rechnung ausgestellt wurde.
	 */
	@Override
	public void setIssueDate(String ymd) {	
		setIssueDate(DateTimeFormats.ymdToTs(ymd));
	}
	
	@Override
	public void setIssueDate(Timestamp ts) {
		DateTimeType dateTime = newDateTime(ts);
		this.getExchangedDocument().setIssueDateTime(dateTime);
	}

	@Override
	public Timestamp getIssueDateAsTimestamp() {
		return getIssueDateAsTimestamp(this);
	}
	static Timestamp getIssueDateAsTimestamp(CrossIndustryInvoiceType doc) {
		DateTimeType dateTime = doc.getExchangedDocument().getIssueDateTime();
		return DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());
	}

	@Override
	public void setTypeCode(DocumentNameCode code) {
		ExchangedDocumentType ed = this.getExchangedDocument();
		DocumentCodeType documentCode = new DocumentCodeType();
		documentCode.setValue(code.getValueAsString());
		ed.setTypeCode(documentCode);
	}

	@Override
	public DocumentNameCode getTypeCode() {
		return getTypeCode(this);
	}
	static DocumentNameCode getTypeCode(CrossIndustryInvoiceType doc) {
		return DocumentNameCode.valueOf(doc.getExchangedDocument().getTypeCode());
	}

	// 1 .. 1 InvoiceCurrencyCode Code für die Rechnungswährung BT-5
	@Override
	public void setDocumentCurrency(String isoCurrencyCode) {
		CurrencyCodeType currencyCode = new CurrencyCodeType();
		currencyCode.setValue(isoCurrencyCode);
		applicableHeaderTradeSettlement.setInvoiceCurrencyCode(currencyCode);
	}

	@Override
	public String getDocumentCurrency() {
		return applicableHeaderTradeSettlement.getInvoiceCurrencyCode().getValue();
	}
	static String getDocumentCurrency(CrossIndustryInvoiceType doc) {
		return doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement().getInvoiceCurrencyCode().getValue();
	}

	// 0..1 (optional) BT-6
	@Override
	public void setTaxCurrency(String isoCurrencyCode) {
		if(isoCurrencyCode==null) return;  // optional
		CurrencyCodeType currencyCode = new CurrencyCodeType();
		currencyCode.setValue(isoCurrencyCode);
		applicableHeaderTradeSettlement.setTaxCurrencyCode(currencyCode);
	}

	@Override
	public String getTaxCurrency() {
		CurrencyCodeType currencyCode = applicableHeaderTradeSettlement.getTaxCurrencyCode();
		return currencyCode==null ? null : currencyCode.getValue();
	}
	static String getTaxCurrency(CrossIndustryInvoiceType doc) {
		CurrencyCodeType currencyCode = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement().getTaxCurrencyCode();
		return currencyCode==null ? null : currencyCode.getValue();
	}

	/*
1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. n ApplicableTradeTax Umsatzsteueraufschlüsselung BG-23

0 .. 1 TaxPointDate Datum der Steuerfälligkeit xs:choice 
1 .. 1 DateString Datum der Steuerfälligkeit, Wert BT-7 
required format Datum, Format BT-7-0

Anwendung: In Deutschland wird dieses nicht verwendet. 
Statt dessen ist das Liefer- und Leistungsdatum anzugeben.
	 */
	@Override
	public void setTaxPointDate(String ymd) {
		setTaxPointDate(DateTimeFormats.ymdToTs(ymd));
	}

	// 0..1 (optional) BT-7 BT-7-0
	@Override
	public void setTaxPointDate(Timestamp ts) {
		if(ts==null) return;  // optional
		TradeTaxType tradeTax = new TradeTaxType();
		tradeTax.setTaxPointDate(newDateType(ts));
		applicableHeaderTradeSettlement.getApplicableTradeTax().add(tradeTax);
	}

	DateType newDateType(Timestamp ts) {
		if(ts==null) return null;
		
		DateType dateTime = new DateType();
		DateType.DateString dts = new DateType.DateString(); // DateString ist inner class in DateType
		dts.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		dts.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		dateTime.setDateString(dts);
		return dateTime;
	}

	@Override
	public Timestamp getTaxPointDateAsTimestamp() {
		return getTaxPointDateAsTimestamp(applicableHeaderTradeSettlement);
	}
	static Timestamp getTaxPointDateAsTimestamp(HeaderTradeSettlementType headerTradeSettlement) {
		List<TradeTaxType> tradeTaxList = headerTradeSettlement.getApplicableTradeTax();
		if(tradeTaxList.isEmpty()) return null;
		
		List<Timestamp> results = new ArrayList<Timestamp>(tradeTaxList.size());
		tradeTaxList.forEach(tradeTax -> {
			DateType date = tradeTax.getTaxPointDate();
			if(date==null) {
				LOG.warning("getTaxPointDateAsTimestamp(doc) TaxPointDate is null");
			} else if(DateTimeFormats.CCYYMMDD_QUALIFIER.equals(date.getDateString().getFormat())) {
				results.add(DateTimeFormats.ymdToTs(date.getDateString().getValue()));
			} else {
				LOG.warning("not CCYYMMDD-Format:"+date.getDateString().getFormat() + " value:"+date.getDateString().getValue());
			}		
		});
		if(results.isEmpty()) return null;
		if(results.size()>1) {
			LOG.warning("results.size()>1:"+results.size());
		}
		return results.get(0);
	}
	static Timestamp getTaxPointDateAsTimestamp(CrossIndustryInvoiceType doc) {
		HeaderTradeSettlementType applicableHeaderTradeSettlement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement();
		return getTaxPointDateAsTimestamp(applicableHeaderTradeSettlement);
	}

	/*
DueDateDateTime Fälligkeitsdatum

1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. n SpecifiedTradePaymentTerms Detailinformationen zu Zahlungsbedingungen xs:sequence 
0 .. 1 Description Zahlungsbedingungen BT-20 
0 .. 1 DueDateDateTime Fälligkeitsdatum xs:choice 
1 .. 1 DateTimeString Fälligkeitsdatum der Zahlung BT-9 
       required format Datum, Format BT-9-0

	 */
	
	@Override
	public Timestamp getDueDateAsTimestamp() {
		return getDueDateAsTimestamp(this);
	}
	static Timestamp getDueDateAsTimestamp(CrossIndustryInvoiceType doc) {
		return null; // TODO
	}

	@Override
	public void setPaymentTermsAndDate(String description, String ymd) {
		setPaymentTermsAndDate(description, DateTimeFormats.ymdToTs(ymd));
	}

//	public void setPaymentTerms(String paymentTerms) { // BT-20 + 0..1 Payment terms
//		if(paymentTerms==null) return;
//		TradePaymentTermsType tradePaymentTerm = new TradePaymentTermsType(); 
//		tradePaymentTerm.getDescription().add(CrossIndustryInvoice.newTextType(paymentTerms));
//		applicableHeaderTradeSettlement.getSpecifiedTradePaymentTerms().add(tradePaymentTerm);
//	}
//	public String getPaymentTerms() {
//		if(applicableHeaderTradeSettlement.getSpecifiedTradePaymentTerms().isEmpty()) return null;
//		List<TextType> descriptionList = applicableHeaderTradeSettlement.getSpecifiedTradePaymentTerms().get(0).getDescription();
//		return descriptionList==null ? null : descriptionList.get(0).getValue();
//	}
//

	@Override
	public void setPaymentTermsAndDate(String description, Timestamp ts) {
		TradePaymentTermsType tradePaymentTerms = new TradePaymentTermsType();
		if(description==null) {
			LOG.warning("text==null");
		} else {
			tradePaymentTerms.getDescription().add(newTextType(description)); // returns List<TextType>
		}
		if(ts==null) {
			LOG.warning("Timestamp ts==null");
		} else {
			tradePaymentTerms.setDueDateDateTime(newDateTime(ts));
		}
		
		applicableHeaderTradeSettlement.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
	}
	
	DateTimeType newDateTime(Timestamp ts) {
		if(ts==null) return null;
		
		DateTimeType dateTime = new DateTimeType();
		DateTimeType.DateTimeString dts = new DateTimeType.DateTimeString(); // DateTimeString ist inner class in DateTimeType
		dts.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		dts.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		dateTime.setDateTimeString(dts);
		return dateTime;
	}

	@Override
	public String getPaymentTerm() {
		return getPaymentTerm(applicableHeaderTradeSettlement);
	}
	static String getPaymentTerm(HeaderTradeSettlementType headerTradeSettlement) {
		List<TradePaymentTermsType> tradePaymentTermsList = headerTradeSettlement.getSpecifiedTradePaymentTerms();
		if(tradePaymentTermsList.isEmpty()) return null;
		
		TradePaymentTermsType tradePaymentTerms = tradePaymentTermsList.get(0); // da Cardinality 0..1 kann es nur einen geben
		List<TextType> textList = tradePaymentTerms.getDescription();
		return textList.isEmpty() ? null : textList.get(0).getValue();
	}
	static String getPaymentTerm(CrossIndustryInvoiceType doc) {
		HeaderTradeSettlementType applicableHeaderTradeSettlement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement();
		return getPaymentTerm(applicableHeaderTradeSettlement);
	}

	/* EN16931-ID: 	BT-10
	 * (non-Javadoc)
	 * @see com.klst.cius.CoreInvoice#setBuyerReference(java.lang.String)
	 */
	@Override
	public void setBuyerReference(String reference) {
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setBuyerReference(newTextType(reference));
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	@Override
	public String getBuyerReferenceValue() {
		return getBuyerReferenceValue(this);
	}
	static String getBuyerReferenceValue(CrossIndustryInvoiceType doc) {
		HeaderTradeAgreementType headerTradeAgreement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		TextType text = headerTradeAgreement.getBuyerReference();
		return text==null ? null : text.getValue();
	}

/* IssuerAssignedID Verkaufsauftragsreferenz
	1 .. 1 ApplicableHeaderTradeAgreement Gruppierung der Vertragsangaben
	0 .. 1 SellerOrderReferencedDocument Detailangaben zur zugehörigen Auftragsbestätigung xs:sequence 
	1 .. 1 IssuerAssignedID Verkaufsauftragsreferenz BT-14 
	0 .. 1 FormattedIssueDateTime Details zum Auftragsbestätigungsdatum xs:sequence 
	1 .. 1 DateTimeString Auftragsbestätigungsdatum, Wert required format Datum, Format
 */
	@Override
	public void setOrderReferenceID(String docRefId) {
		if(docRefId==null) return; // optional
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		referencedDocument.setIssuerAssignedID(newIDType(docRefId, null)); // null : No identification scheme
		
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setSellerOrderReferencedDocument(referencedDocument);

		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}
	@Override
	public String getOrderReferenceID() {
		return getOrderReferenceID(this);
	}
	static String getOrderReferenceID(CrossIndustryInvoiceType doc) {
		HeaderTradeAgreementType headerTradeAgreement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		ReferencedDocumentType referencedDocument = headerTradeAgreement.getSellerOrderReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getIssuerAssignedID().getValue();
		
	}

	/* INVOICE NOTE                                BG-1                        0..*
	 * Eine Gruppe von Informationselementen für rechnungsrelevante Erläuterungen mit Hinweisen auf den Rechnungsbetreff.
	 * 

1 .. 1 ExchangedDocument Gruppierung der Eigenschaften, die das gesamte Dokument betreffen. xs:sequence 
1 .. 1 ID Rechnungsnummer                        BT-1 
0 .. 1 Name Dokumentenart (Freitext) 
1 .. 1 TypeCode Code für den Rechnungstyp        BT-3 
1 .. 1 IssueDateTime Rechnungsdatum xs:choice 
1 .. 1 DateTimeString Rechnungsdatum             BT-2 required format Datum, Format BT-2-0 
0 .. 1 CopyIndicator xs:choice 
1 .. 1 Indicator 
0 .. 1 LanguageID Sprachkennzeichen 
0 .. n IncludedNote Freitext zur Rechnung        BG-1 xs:sequence
0 .. 1 ContentCode Freitext auf Dokumentenebene 
1 .. 1 Content Freitext zur Rechnung             BT-22 
0 .. 1 SubjectCode Code zur Qualifizierung des Freitextes zur Rechnung BT-21 

	 */
	@Override
	public void setNote(String subjectCode, String content) {
		addNote(subjectCode, content);
	}
	@Override
	public void setNote(String content) {
		setNote(null, content);
	}
	List<NoteType> addNote(String subjectCode, String noteContent) {
		ExchangedDocumentType ed = this.getExchangedDocument();
		List<NoteType> noteList = ed.getIncludedNote();
		NoteType note = new NoteType();
		if(subjectCode!=null) {
			CodeType code = new CodeType();
			code.setValue(subjectCode);
			note.setSubjectCode(code); //  z.B ADU
		}
		List<TextType> textList = note.getContent();
		textList.add(newTextType(noteContent));
		noteList.add(note);
		return noteList;
	}
	/*

        <ram:IncludedNote>
            <ram:Content>[Invoice note]</ram:Content>
            <ram:SubjectCode>ADU</ram:SubjectCode>                  <============ wird weggelassen bei get
        </ram:IncludedNote>


	 */
	List<NoteType> addNotes(CrossIndustryInvoiceType doc) {
		List<String> noteContentList = getNotes(doc);
		noteContentList.forEach(noteContent -> {
			this.addNote(null, noteContent);
		});
		return this.getExchangedDocument().getIncludedNote();
	}

	@Override
	public List<String> getNotes() {
		return getNotes(this);
	}
	static List<String> getNotes(CrossIndustryInvoiceType doc) {
		ExchangedDocumentType ed = doc.getExchangedDocument();
		List<NoteType> noteList = ed.getIncludedNote();
		List<String> res = new ArrayList<String>(noteList.size());
		noteList.forEach(note -> {
			CodeType code = note.getSubjectCode();
			if(code!=null) LOG.warning("---SubjectCode:"+code.getValue() + "(wird weggelassen), Content:"+note.getContent().get(0).getValue());
			res.add(note.getContent().get(0).getValue());
		});
		return res;
	}

	/* PROCESS CONTROL                             BG-2                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, 
	 * die Informationen über den Geschäftsprozess und für die Rechnung geltende Regeln liefern.
	 */
	/**
	 * mandatory group PROCESS CONTROL BG-2
	 * contains ProfileID and CustomizationID. 
	 * 
	 * ProfileID identifies what business process a given message is part of, 
	 * and CustomizationID identifies the kind of message and the rules applied.
	 * 
	 * @param customization, not null
	 * @param profile (optional)
	 */
	void setProcessControl(String customization, String profile) {
		ExchangedDocumentContextType exchangedDocumentContext = new ExchangedDocumentContextType();
		List<DocumentContextParameterType> documentContextParameterList = exchangedDocumentContext.getGuidelineSpecifiedDocumentContextParameter();
		DocumentContextParameterType documentContextParameter = new DocumentContextParameterType();
		documentContextParameter.setID(newIDType(customization, "XRECHNUNG"));

		documentContextParameterList.add(documentContextParameter);
		if(profile==null) {
			// profileIDType ist optional
		} else { 
			List<DocumentContextParameterType> dcpList = exchangedDocumentContext.getBusinessProcessSpecifiedDocumentContextParameter();
			DocumentContextParameterType dcp = new DocumentContextParameterType();
			dcp.setID(newIDType(profile, null)); // null : No identification scheme
			dcpList.add(dcp);
		}
		this.setExchangedDocumentContext(exchangedDocumentContext);
	}

	@Override
	public String getCustomization() {
		return getCustomization(this);
	}
	static String getCustomization(CrossIndustryInvoiceType doc) {
		List<DocumentContextParameterType> documentContextParameterList = doc.getExchangedDocumentContext().getGuidelineSpecifiedDocumentContextParameter();
		LOG.info("documentContextParameterList.size()="+documentContextParameterList.size());
		List<String> res = new ArrayList<String>(documentContextParameterList.size());
		documentContextParameterList.forEach(documentContextParameter -> {
			res.add(documentContextParameter.getID().getValue());
		});
		return res.isEmpty() ? null : res.get(0);
	}
	public String getProfile() {
		return getProfile(this);
	}
	static String getProfile(CrossIndustryInvoiceType doc) {
		List<DocumentContextParameterType> documentContextParameterList = doc.getExchangedDocumentContext().getBusinessProcessSpecifiedDocumentContextParameter();
		List<String> res = new ArrayList<String>(documentContextParameterList.size());
		documentContextParameterList.forEach(documentContextParameter -> {
			res.add(documentContextParameter.getID().getValue());
		});
		return res.isEmpty() ? null : res.get(0);
	}

	/* PRECEDING INVOICE REFERENCE                 BG-3                        0..* (optional)
	 * Eine Gruppe von Informationselementen, die Informationen über eine vorausgegangene Rechnung liefern, 
	 * die berichtigt oder gutgeschrieben werden soll.
	 * 
	 * Anmerkung: Das Informationselement ist zu verwenden, wenn eine vorangegangene Rechnung korrigiert wird, 
	 * eine Abschlussrechnung auf vorangegangene Teilrechnungen Bezug nimmt 
	 * oder eine Abschlussrechnung auf vorangegangene Vorauszahlungsrechnungen Bezug nimmt.

1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. 1 InvoiceReferencedDocument Referenz auf die vorausgegangene Rechnungen BG-3 xs:sequence      <============
1 .. 1 IssuerAssignedID Nummer der vorausgegangenen Rechnung BT-25 
0 .. 1 FormattedIssueDateTime Rechnungsdatum xs:sequence 
1 .. 1 DateTimeString Rechnungsdatum der vorausgegangenen Rechnung BT-26 
       required format Datum, Format BT-26-0
 */
	@Override
	public void setPrecedingInvoiceReference(String docRefId, String ymd) {
		setPrecedingInvoiceReference(docRefId, DateTimeFormats.ymdToTs(ymd));
	}
	@Override
	public void setPrecedingInvoiceReference(String docRefId) {
		setPrecedingInvoiceReference(docRefId, (Timestamp)null);
	}
	// 0..n (optional) BG-3 , BT-25,BT-26,BT-26-0
	@Override
	public void setPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		referencedDocument.setIssuerAssignedID(newIDType(docRefId, null)); // null : No identification scheme
		FormattedDateTimeType dateTime = newFormattedDateTimeType(ts);
		if(dateTime!=null) referencedDocument.setFormattedIssueDateTime(dateTime);

		applicableHeaderTradeSettlement.setInvoiceReferencedDocument(referencedDocument);
	}

	@Override
	public String getPrecedingInvoiceReference() {
		ReferencedDocumentType referencedDocument =  applicableHeaderTradeSettlement.getInvoiceReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getLineID().getValue();
	}
	static String getPrecedingInvoiceReference(CrossIndustryInvoiceType doc) {
		ReferencedDocumentType referencedDocument =  doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement().getInvoiceReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getLineID().getValue();
	}

	FormattedDateTimeType newFormattedDateTimeType(Timestamp ts) {
		if(ts==null) return null;
		
		FormattedDateTimeType dateTime = new FormattedDateTimeType();
		FormattedDateTimeType.DateTimeString dts = new FormattedDateTimeType.DateTimeString(); // DateTimeString ist inner class in FormattedDateTimeType
		dts.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		dts.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		dateTime.setDateTimeString(dts);
		return dateTime;
	}

	/* SELLER                                      BG-4                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, die Informationen über den Verkäufer liefern.
	 */
	/**
	 * Seller (AccountingSupplierParty)
	 * Seller is mandatory information and provided in cii element SellerTradeParty
	 * 
	 * @param registrationName mandatory BT-27 : The full formal name by which the Seller is registered 
	 *        in the national registry of legal entities or as a Taxable person or otherwise trades as a person or persons.
	 * @param postalAddress mandatory group BG-5/R53 : A group of business terms providing information about the address of the Seller.
              Sufficient components of the address are to be filled to comply with legal requirements.
	 * @param contact mandatory group BG-6/R57 : A group of business terms providing contact information about the Seller.
	 * @param companyId optional / Seller legal registration identifier, BT-30/R52
	 * @param companyLegalForm optional / Seller additional legal information, BT-33/R47
	 */
	public void setSeller(String registrationName, TradeAddress address, TradeContact contact, 
			String companyId, String companyLegalForm) {
		                                  // BT-27        , BG-5   , BG-6   , BT-30    , BT-33
		TradeParty party = new TradeParty(registrationName, address, contact, companyId, companyLegalForm);
		setSellerParty(party);
	}
	
	public void setSellerParty(TradeParty party) {
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setSellerTradeParty(party);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	public TradeParty getSellerParty() {
		return getSellerParty(this);
	}
	static TradeParty getSellerParty(CrossIndustryInvoiceType doc) {
		HeaderTradeAgreementType headerTradeAgreement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		TradePartyType sellerParty = headerTradeAgreement.getSellerTradeParty();
		return sellerParty==null ? null : new TradeParty(sellerParty);
	}

	/* BUYER                                       BG-7                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, die Informationen über den Erwerber liefern.
	 */
	public void setBuyer(String registrationName, TradeAddress address, TradeContact contact) {
		TradeParty party = new TradeParty(registrationName, address, contact, null, null); // BT-44, BG-8, BG-9, BT-45 optional, BT-46 optional
		setSellerParty(party);
	}
	public void setBuyerParty(TradeParty party) {
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setBuyerTradeParty(party);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	public TradeParty getBuyerParty() {
		return getBuyerParty(this);
	}
	static TradeParty getBuyerParty(CrossIndustryInvoiceType doc) {
		HeaderTradeAgreementType headerTradeAgreement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		TradePartyType buyerParty = headerTradeAgreement.getBuyerTradeParty();
		return buyerParty==null ? null : new TradeParty(buyerParty);
	}

	/**
1 .. 1 ApplicableHeaderTradeAgreement Gruppierung der Vertragsangaben xs:sequence 
0 .. 1 BuyerReference Referenz des Käufers                              BT-10 
1 .. 1 SellerTradeParty Verkäufer                                       BG-4  xs:sequence 
0 .. 1 ID Kennung des Verkäufers                                        BT-29 
0 .. n GlobalID Globaler Identifier des Verkäufers                      BT-29-0 
      required schemeID Kennung des Schemas                             BT-29-1 
1 .. 1 Name Name des Verkäufers                                         BT-27 
0 .. 1 Description Sonstige rechtliche Informationen des Verkäufers     BT-33 
0 .. 1 SpecifiedLegalOrganization Details zur Organisation xs:sequence 
0 .. 1 ID Kennung der rechtlichen Registrierung des Verkäufers          BT-30 
       required schemeID Kennung des Schemas                            BT-30-1
1 .. 1 TradingBusinessName Handelsname des Verkäufers                   BT-28 
0 .. 1 PostalTradeAddress Detailinformationen zur Geschäftsanschrift des Verkäufers xs:sequence 
0 .. 1 PostcodeCode Postleitzahl 
0 .. 1 LineOne Adresszeile 1 
0 .. 1 LineTwo Adresszeile 2 
0 .. 1 LineThree Adresszeile 3 
0 .. 1 CityName Ort 
1 .. 1 CountryID Land (Code) 
0 .. 1 DefinedTradeContact Kontaktdaten des Verkäufers                  BG-6 xs:sequence SELLER CONTACT 
0 .. 1 PersonName Kontaktstelle des Verkäufers                          BT-41 
0 .. 1 DepartmentName Kontaktstelle des Verkäufers                      BT-41-0 
0 .. 1 TelephoneUniversalCommunication Detailinformationen zur Telefonnummer des Verkäufers xs:sequence 
1 .. 1 CompleteNumber Telefonnummer des Verkäufers                      BT-42       
0 .. 1 FaxUniversalCommunication Detailinformationen zur Faxnummer des Verkäufers xs:sequence 
1 .. 1 CompleteNumber Faxnummer des Verkäufers 
0 .. 1 EmailURIUniversalCommunication Detailinformationen zur Emailadresse des Verkäufers xs:sequence 
1 .. 1 URIID E-Mailadresse des Verkäufers                               BT-43 
1 .. 1 PostalTradeAddress Postanschrift des Verkäufers                  BG-5 xs:sequence SELLER POSTAL ADDRESS 
0 .. 1 PostcodeCode Postleitzahl der Verkäuferanschrift                 BT-38 
0 .. 1 LineOne Zeile 1 der Verkäuferanschrift                           BT-35 
0 .. 1 LineTwo Zeile 2 der Verkäuferanschrift                           BT-36 
0 .. 1 LineThree Zeile 3 der Verkäuferanschrift                         BT-162 
0 .. 1 CityName Stadt der Verkäuferanschrift                            BT-37 
1 .. 1 CountryID Ländercode der Verkäuferanschrift                      BT-40 
0 .. 1 CountrySubDivisionName Bundesland                                BT-39 
0 .. 1 URIUniversalCommunication Details zur elektronischen Adresse xs:sequence 
1 .. 1 URIID Elektronischen Adresse des Verkäufers                      BT-34 
       required schemeID Kennung des Schemas                            BT-34-1
0 .. n SpecifiedTaxRegistration Detailinformationen zu Steuerangaben des Verkäufers
1 .. 1 ID Steuernummer des Verkäufers                                   BT-31,
       Umsatzsteueridentnummer des Verkäufers                           BT-32 
       required schemeID Art der Steuernummer des Verkäufers          BT-31-0, BT-32-0
       
1 .. 1 BuyerTradeParty Käufer                                           BG-7 xs:sequence 
0 .. 1 ID Kennung des Käufers                                           BT-46
...       
       headerTradeAgreement.setSellerTradeParty(tradeParty);
                           .setBuyerTradeParty(tradeParty);

	 */

	/* PAYEE                                       BG-10                       0..1
	 * Eine Gruppe von Informationselementen, die Informationen über den Zahlungsempfänger liefern. 
	 * Die Gruppe wird genutzt, wenn der Zahlungsempfänger nicht mit dem Verkäufer identisch ist.
	 */
	public void setPayeeParty(TradeParty party) {
// TODO		LOG.warning(NOT_IMPEMENTED); 
	}
	
	/* SELLER TAX REPRESENTATIVE PARTY             BG-11                       0..1
	 * Eine Gruppe von Informationselementen, die Informationen über den Steuervertreter des Verkäufers liefern.
	 */
	public void setSellerTaxRepresentativeParty(TradeParty party) {
// TODO		LOG.warning(NOT_IMPEMENTED);
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
	public void setDelivery(Object delivery) { // TODO setDelivery(Delivery delivery)
		HeaderTradeDeliveryType value = new HeaderTradeDeliveryType(); // TODO
		supplyChainTradeTransaction.setApplicableHeaderTradeDelivery(value);
	}
	
// --------------------------------
	/** 
	 * mandatory Group BG-16 PAYMENT INSTRUCTIONS with ibanlAccount as BG-17 CREDIT TRANSFER
	 * 
	 * @param enum paymentMeansCode, BT-81 use PaymentMeansCode.CreditTransfer or PaymentMeansCode.SEPACreditTransfer
	 * @param String iban to create ibanlAccount element
	 * TODO BT-82 ++ 0..1 Payment means text
	 * @param String remittanceInformation BT-83 optional
//	 * @return paymentMeansList with minimum 1 element
	 */
/*
0 .. n SpecifiedTradeSettlementPaymentMeans Zahlungsanweisungen               BG-16 xs:sequence 
1 .. 1 TypeCode Code für die Zahlungsart                                      BT-81 
0 .. 1 Information Text zur Zahlungsart                                       BT-82 
0 .. 1 ApplicableTradeSettlementFinancialCard Informationen zur Zahlungskarte BG-18 xs:sequence 
1 .. 1 ID Zahlungskartennummer                                                BT-87 
0 .. 1 CardholderName Name des Zahlungskarteninhabers                         BT-88 
0 .. 1 PayerPartyDebtorFinancialAccount Bankinstitut des Käufers xs:sequence 
1 .. 1 IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos         BG-19/ BT-91 
0 .. 1 PayeePartyCreditorFinancialAccount Überweisung                         BG-17 xs:sequence 
0 .. 1 IBANID Kennung des Zahlungskontos                                      BT-84 
0 .. 1 AccountName Name des Zahlungskontos                                    BT-85 
0 .. 1 ProprietaryID Nationale Kontonummer (nicht für SEPA)                   BT-84-0 
0 .. 1 PayeeSpecifiedCreditorFinancialInstitution Bankinstitut des Verkäufers xs:sequence 
1 .. 1 BICID Kennung des Zahlungsdienstleisters                               BT-86

0 .. 1 SupplyChainTradeTransaction Gruppierung der Informationen zum Geschäftsvorfall
1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich xs:sequence 
0 .. 1 CreditorReferenceID Kennung des Gläubigers                             BG-19/ BT-90 
0 .. 1 PaymentReference Verwendungszweck                                      BT-83   <============== nicht unter SpecifiedTradeSettlementPaymentMeans

    <ram:ApplicableHeaderTradeSettlement>
        <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>
        <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>  <<======== setPaymentCurrencyCode
        <ram:SpecifiedTradeSettlementPaymentMeans>              <<======== addPaymentInstructions SpecifiedTradeSettlementPaymentMeans
            <ram:TypeCode>30</ram:TypeCode>
            <ram:PayeePartyCreditorFinancialAccount>
                <ram:IBANID>DE12345678912345678912</ram:IBANID>
            </ram:PayeePartyCreditorFinancialAccount>
        </ram:SpecifiedTradeSettlementPaymentMeans>
        <ram:ApplicableTradeTax>
            <ram:CalculatedAmount>22.04</ram:CalculatedAmount>
            <ram:TypeCode>VAT</ram:TypeCode>
            <ram:BasisAmount>314.86</ram:BasisAmount>
            <ram:CategoryCode>S</ram:CategoryCode>
            <ram:RateApplicablePercent>7</ram:RateApplicablePercent>
        </ram:ApplicableTradeTax>
        <ram:SpecifiedTradePaymentTerms>                                        TDO
            <ram:Description>Zahlbar sofort ohne Abzug.</ram:Description>
        </ram:SpecifiedTradePaymentTerms>
        <ram:SpecifiedTradeSettlementHeaderMonetarySummation>
            <ram:LineTotalAmount>314.86</ram:LineTotalAmount>
            <ram:TaxBasisTotalAmount>314.86</ram:TaxBasisTotalAmount>
            <ram:TaxTotalAmount currencyID="EUR">22.04</ram:TaxTotalAmount>
            <ram:GrandTotalAmount>336.9</ram:GrandTotalAmount>
            <ram:DuePayableAmount>336.9</ram:DuePayableAmount>
        </ram:SpecifiedTradeSettlementHeaderMonetarySummation>
    </ram:ApplicableHeaderTradeSettlement>
*/

//	CreditorFinancialAccountType makeCreditTransfer(IBANId iban) {
//		CreditorFinancialAccountType financialAccount = new CreditorFinancialAccountType();
//		financialAccount.setIBANID(newIDType(iban.getValue(), iban.getSchemeID()));
//		return financialAccount;
//	}
//	public CreditorFinancialAccountType makeCreditTransfer(String account, String accountName, BICId bic) {
//			CreditorFinancialAccountType financialAccount = new CreditorFinancialAccountType();
//			financialAccount.setIBANID(newIDType(account, null)); // null : No identification scheme
//			financialAccount.setAccountName(newTextType(accountName));
//			financialAccount.setProprietaryID(newIDType(bic.getValue(), bic.getSchemeID()));
//			return financialAccount;
//		}
	
		/*

EN16931 sagt: BG-16 0..1 PAYMENT INSTRUCTIONS
	die Kardinalität ist 0..1, wg. BR-DE-1 (1..1 this cius rule makes it mandatory)
	ich implemetierte setXXX so, dass PaymentInstructions null sein darf

		 */
	PaymentInstructions createPaymentInstructions(PaymentMeansCode code, String paymentMeansText, String remittanceInformation) {
		// ohne remittanceInformation:
		return this.applicableHeaderTradeSettlement.createPaymentInstructions(code, paymentMeansText);
	}
	/**
	 * group PAYMENT INSTRUCTIONS, BG-16 Cardinality 0..1
	 * 
	 * @param code                   mandatory BT-81
	 * @param paymentMeansText       optional  BT-82 (can be null)
	 * @param remittanceInformation  optional  BT-83
	 */
	public void setPaymentInstructions(PaymentMeansCode code, String paymentMeansText, String remittanceInformation) {
		PaymentInstructions pi = createPaymentInstructions(code, paymentMeansText, remittanceInformation);
		this.applicableHeaderTradeSettlement.setBG16(pi);
		this.applicableHeaderTradeSettlement.setRemittanceInformation(remittanceInformation);
	}
	public PaymentMeansCode getPaymentMeansCode() {
		return this.applicableHeaderTradeSettlement.getPaymentMeansCode();
	}
	// BG-16.BT-83 - 0..1/0..1
	public String getRemittanceInformation() {
		return this.applicableHeaderTradeSettlement.getRemittanceInformation();
	}
	
	public CreditTransfer getCreditTransfer() {
		return this.applicableHeaderTradeSettlement.getCreditTransfer();
	}
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		return this.applicableHeaderTradeSettlement.createCreditTransfer(iban, accountName, bic);
	}

	// TODO Bauselle
	@Override
	public Amount getInvoiceLineNetTotal() {
		return null;	
	}
	@Override
	public Amount getInvoiceTotalTaxExclusive() {
		return null;	
	}
	@Override
	public Amount getInvoiceTotalTaxInclusive() {
		return null;	
	}
	@Override
	public Amount getDuePayable() {
		return null;	
	}
	@Override
	public Amount getInvoiceTax() {
		return null;	
	}
	
	/**
	 * mandatory total amounts of the invoice
	 * 
	 * @param lineExtension : Sum of Invoice line net amount
	 * @param taxExclusive : Invoice total amount without VAT
	 * @param taxInclusive : Invoice total amount with VAT
	 * @param payable : Amount due for payment 
	 */
/*
            <ram:SpecifiedTradeSettlementHeaderMonetarySummation>
                <ram:LineTotalAmount>314.86</ram:LineTotalAmount>
                <ram:TaxBasisTotalAmount>314.86</ram:TaxBasisTotalAmount>
                <ram: TaxTotalAmount currencyID="EUR">22.04</ram:TaxTotalAmount>  TODO
                <ram:GrandTotalAmount>336.9</ram:GrandTotalAmount>
                <ram:DuePayableAmount>336.9</ram:DuePayableAmount>
            </ram:SpecifiedTradeSettlementHeaderMonetarySummation>

 */
	@Override
	public void setDocumentTotals(Amount lineExtension, Amount taxExclusive, Amount taxInclusive, Amount payable) {
		TradeSettlementHeaderMonetarySummationType tradeSettlementHeaderMonetarySummationType = getTradeSettlementHeaderMonetarySummation(applicableHeaderTradeSettlement);

		AmountType lineTotalAmt = new AmountType();
		lineExtension.copyTo(lineTotalAmt);
		tradeSettlementHeaderMonetarySummationType.getLineTotalAmount().add(lineTotalAmt); // add to list
		
		AmountType taxBasisTotalAmt = new AmountType();
		taxExclusive.copyTo(taxBasisTotalAmt);
		tradeSettlementHeaderMonetarySummationType.getTaxBasisTotalAmount().add(taxBasisTotalAmt); // add to list
		
		AmountType taxTotalAmt = new AmountType();
		taxInclusive.copyTo(taxTotalAmt);

		taxTotalAmt.setCurrencyID(taxInclusive.getCurrencyID()); // wg. validation 
		tradeSettlementHeaderMonetarySummationType.getGrandTotalAmount().add(taxTotalAmt); // add to list
		
		AmountType payableAmt = new AmountType();
		payable.copyTo(payableAmt);
		tradeSettlementHeaderMonetarySummationType.getDuePayableAmount().add(payableAmt); // add to list
		
		applicableHeaderTradeSettlement.setSpecifiedTradeSettlementHeaderMonetarySummation(tradeSettlementHeaderMonetarySummationType);
	}

	/**
	 * optional total amount of the invoice
	 * 
	 * @param taxTotalAmount : Invoice total VAT amount
	 */
	@Override
	public void setInvoiceTax(Amount taxTotalAmount) {
		TradeSettlementHeaderMonetarySummationType tradeSettlementHeaderMonetarySummationType = getTradeSettlementHeaderMonetarySummation(applicableHeaderTradeSettlement);
		
		AmountType taxTotalAmt = new AmountType();
		taxTotalAmount.copyTo(taxTotalAmt);
		tradeSettlementHeaderMonetarySummationType.getTaxTotalAmount().add(taxTotalAmt); // add to list
				
		applicableHeaderTradeSettlement.setSpecifiedTradeSettlementHeaderMonetarySummation(tradeSettlementHeaderMonetarySummationType);
	}
	
	@Override
	public void setInvoiceTaxInAccountingCurrency(Amount amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllowancesTotal(Amount amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setChargesTotal(Amount amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPaid(Amount amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRounding(Amount amount) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * VAT BREAKDOWN

1 .. 1 SupplyChainTradeTransaction Gruppierung der Informationen zum Geschäftsvorfall
1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. n ApplicableTradeTax Umsatzsteueraufschlüsselung                                                 BG-23 xs:sequence 

       VatBreakdown extends ApplicableTradeTax

	 */
	/**
	 * Adds a mandatory VAT BREAKDOWN element
	 * 
	 * @param vatBreakdown
	 */
	@Override
	public void addVATBreakDown(CoreInvoiceVatBreakdown vatBreakdown) {
		List<TradeTaxType> tradeTaxes = applicableHeaderTradeSettlement.getApplicableTradeTax();
		tradeTaxes.add((VatBreakdown)vatBreakdown);
	}
	public void addVATBreakDown(List<VatBreakdown> vatBreakdowns) {
		List<TradeTaxType> tradeTaxes = applicableHeaderTradeSettlement.getApplicableTradeTax();
		vatBreakdowns.forEach(vbd -> {
			tradeTaxes.add(vbd);
		});	
	}
	public void addVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		VatBreakdown vatBreakdown = new VatBreakdown(taxableAmount, tax, taxCategoryCode, taxRate);
		addVATBreakDown(vatBreakdown);
	}
	public List<VatBreakdown> getVATBreakDowns() {
		if(applicableHeaderTradeSettlement==null) return null;
		List<TradeTaxType> list = applicableHeaderTradeSettlement.getApplicableTradeTax();
		List<VatBreakdown> result = new ArrayList<VatBreakdown>(list.size()); // VatBreakdown extends TradeTaxType
		list.forEach(vbd -> {
			result.add(new VatBreakdown(vbd));
		});
		return result;
	}
	static List<VatBreakdown> getVATBreakDowns(CrossIndustryInvoiceType doc) {
		SupplyChainTradeTransactionType supplyChainTradeTransaction = doc.getSupplyChainTradeTransaction();
		if(supplyChainTradeTransaction==null) return null;
		HeaderTradeSettlementType applicableHeaderTradeSettlement = supplyChainTradeTransaction.getApplicableHeaderTradeSettlement();
		if(applicableHeaderTradeSettlement==null) return null;
		List<TradeTaxType> list = applicableHeaderTradeSettlement.getApplicableTradeTax();
		List<VatBreakdown> result = new ArrayList<VatBreakdown>(list.size()); // VatBreakdown extends TradeTaxType
		list.forEach(vbd -> {
			result.add(new VatBreakdown(vbd));
		});
		return result;
	
	}
	
	/* INVOICE LINE                                BG-25                       1..* (mandatory)
	 * Eine Gruppe von Informationselementen, die Informationen über einzelne Rechnungspositionen liefern.
	 * 

1 .. 1 SupplyChainTradeTransaction Gruppierung der Informationen zum Geschäftsvorfall xs:sequence 
0 .. n IncludedSupplyChainTradeLineItem Rechnungsposition BG-25 xs:sequence 

	 */
	
	/**
	 * Adds a mandatory invoice line element
	 * 
	 * @param line
	 */
	@Override
	public void addLine(CoreInvoiceLine line) {
		LOG.info("CoreInvoiceLine line:"+line + " - Class:"+line.getClass() + " - TaxCategory:"+line.getTaxCategory());
		supplyChainTradeTransaction.getIncludedSupplyChainTradeLineItem().add((TradeLineItem)line);
		/*
TODO
    <rsm:SupplyChainTradeTransaction>
        <ram:IncludedSupplyChainTradeLineItem>
        ...
            <ram:SpecifiedLineTradeSettlement>
                <ram:ApplicableTradeTax>
                    <ram:TypeCode>VAT</ram:TypeCode>
                    <ram:CategoryCode>S</ram:CategoryCode>                       <============= fehlt/gelöst OK
                    <ram:RateApplicablePercent>7</ram:RateApplicablePercent>
                </ram:ApplicableTradeTax>
                <ram:BillingSpecifiedPeriod>                                     <============= Block fehlt TODO
                    <ram:StartDateTime>
                        <udt:DateTimeString format="102">20160101</udt:DateTimeString>
                    </ram:StartDateTime>
                    <ram:EndDateTime>
                        <udt:DateTimeString format="102">20161231</udt:DateTimeString>
                    </ram:EndDateTime>
                </ram:BillingSpecifiedPeriod>
                <ram:SpecifiedTradeSettlementLineMonetarySummation>
                    <ram:LineTotalAmount>288.79</ram:LineTotalAmount>
                </ram:SpecifiedTradeSettlementLineMonetarySummation>
            </ram:SpecifiedLineTradeSettlement>



		 */
	}
	
	public void addLine(SupplyChainTradeLineItemType line) {
		supplyChainTradeTransaction.getIncludedSupplyChainTradeLineItem().add(line);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);
	}

	public void addLines(CrossIndustryInvoiceType doc) {
		List<TradeLineItem> tradeLineItemList = getLines(doc);
//		LOG.info(">>>>>>>>>>>>>> tradeLineItemList#:"+tradeLineItemList.size());
		tradeLineItemList.forEach(line -> {
			CoreInvoiceLine invoiceLine = new TradeLineItem(line); // TradeLineItem implements CoreInvoiceLine
			addLine(invoiceLine);
		});
	}

	public List<TradeLineItem> getLines() {
		List<SupplyChainTradeLineItemType> lines = supplyChainTradeTransaction.getIncludedSupplyChainTradeLineItem();
		List<TradeLineItem> resultLines = new ArrayList<TradeLineItem>(lines.size());
		lines.forEach(line -> {
			resultLines.add(new TradeLineItem(line));
		});
		return resultLines;
	}
	static List<TradeLineItem> getLines(CrossIndustryInvoiceType doc) {
		List<SupplyChainTradeLineItemType> lines = doc.getSupplyChainTradeTransaction().getIncludedSupplyChainTradeLineItem();
		List<TradeLineItem> resultLines = new ArrayList<TradeLineItem>(lines.size());
		lines.forEach(line -> {
			resultLines.add(new TradeLineItem(line));
		});
		return resultLines;
	}

// -----------------------------------------------------------
	
	private TradeSettlementHeaderMonetarySummationType getTradeSettlementHeaderMonetarySummation(HeaderTradeSettlementType applicableHeaderTradeSettlement) {
		TradeSettlementHeaderMonetarySummationType tradeSettlementHeaderMonetarySummationType = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation();
		if(tradeSettlementHeaderMonetarySummationType==null) {
			tradeSettlementHeaderMonetarySummationType = new TradeSettlementHeaderMonetarySummationType();
			LOG.info("new TradeSettlementHeaderMonetarySummationType:"+tradeSettlementHeaderMonetarySummationType);
		}
		return tradeSettlementHeaderMonetarySummationType;
	}

	private HeaderTradeAgreementType getApplicableHeaderTradeAgreement() {
		return getApplicableHeaderTradeAgreement(this.getSupplyChainTradeTransaction());
	}
	private HeaderTradeAgreementType getApplicableHeaderTradeAgreement(SupplyChainTradeTransactionType supplyChainTradeTransaction) {
		HeaderTradeAgreementType headerTradeAgreement = supplyChainTradeTransaction.getApplicableHeaderTradeAgreement();
		if(headerTradeAgreement==null) {
			headerTradeAgreement = new HeaderTradeAgreementType();
			LOG.info("new HeaderTradeAgreementType:"+headerTradeAgreement);
		}
		return headerTradeAgreement;
	}	

	// ----------------- gemeinsam mit TradeParty
	static IDType newIDType(IBANId iban) {
		return newIDType(iban.getValue(), iban.getSchemeID());
	}
	
	static IDType newIDType(BICId bic) {
		return newIDType(bic.getValue(), bic.getSchemeID());
	}
	
	static IDType newIDType(String value, String schemeID) {
		IDType ID = new IDType();
		ID.setValue(value);
		ID.setSchemeID(schemeID);
		return ID;
	}

	static TextType newTextType(String value) {
		TextType text = new TextType();
		text.setValue(value);
		return text;
	}

}
