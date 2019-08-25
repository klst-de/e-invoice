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
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.PostalAddress;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;
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
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ProcuringProjectType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeLineItemType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeTransactionType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementHeaderMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
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
public class CrossIndustryInvoice extends CrossIndustryInvoiceType implements CoreInvoice {

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

	HeaderTradeSettlementType applicableHeaderTradeSettlement;
	HeaderTradeDeliveryType applicableHeaderTradeDelivery;
	
	public CrossIndustryInvoice(String customization, DocumentNameCode documentNameCode) {
		this(customization, null, documentNameCode);
	}
	
	public CrossIndustryInvoice(String customization, String profile, DocumentNameCode documentNameCode) {
		this();
		setProcessControl(customization, profile);
		supplyChainTradeTransaction = new SupplyChainTradeTransactionType();
		
		applicableHeaderTradeDelivery = new ApplicableHeaderTradeDelivery();
		supplyChainTradeTransaction.setApplicableHeaderTradeDelivery(applicableHeaderTradeDelivery);
		
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
		LOG.info("Customization:"+getCustomization() + ", Profile:"+getProfile() + ", TypeCode:"+getTypeCode());
		supplyChainTradeTransaction = new SupplyChainTradeTransactionType();
		
		Object ahtd = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeDelivery();
		LOG.info("ApplicableHeaderTradeDelivery ahtd:"+ahtd);
		if(ahtd==null) {
			LOG.info("ahtd==null");
		} else {
			HeaderTradeDeliveryType htd = (HeaderTradeDeliveryType)ahtd;
			applicableHeaderTradeDelivery = new ApplicableHeaderTradeDelivery(htd);
			supplyChainTradeTransaction.setApplicableHeaderTradeDelivery(applicableHeaderTradeDelivery);
		}

		applicableHeaderTradeSettlement = new ApplicableHeaderTradeSettlement(doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement());
		setPaymentTermsAndDate(getPaymentTerm(applicableHeaderTradeSettlement), getDueDateAsTimestamp(applicableHeaderTradeSettlement)); // optional
		
		setId(getId(doc));
		setIssueDate(getIssueDateAsTimestamp(doc));
		setDocumentCurrency(getDocumentCurrency(doc));
		setTaxCurrency(getTaxCurrency(doc)); // optional
		setTaxPointDate(getTaxPointDateAsTimestamp(doc)); // optional
		setBuyerReference(getBuyerReferenceValue(doc)); // optional
		setOrderReferenceID(getOrderReferenceID(doc)); // optional
//		addPaymentTerms(doc);
		addNotes(doc);	
		LOG.info("\n SellerParty:");;
		setSellerParty(getSellerParty(doc));
		LOG.info("\n BuyerParty:");;
		setBuyerParty(getBuyerParty(doc));
		LOG.info("\n PayeeParty:");;
		setPayeeParty(getPayeeParty(doc));
		LOG.info("\n SellerTaxRepresentativeParty:");;
		setTaxRepresentativeParty(getTaxRepresentativeParty(doc)); // optional
		LOG.info("\n ...");
		
//		addPaymentInstructions(doc);		
		setDocumentTotals(getInvoiceLineNetTotal(doc), getInvoiceTotalTaxExclusive(doc), getInvoiceTotalTaxInclusive(doc), getDuePayable(doc));
		setInvoiceTax(getInvoiceTax(doc));
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

	// BT-9 0..1 DueDateDateTime Fälligkeitsdatum
	@Override
	public Timestamp getDueDateAsTimestamp() {
		return getDueDateAsTimestamp(applicableHeaderTradeSettlement);
	}
	static Timestamp getDueDateAsTimestamp(HeaderTradeSettlementType headerTradeSettlement) {
		if(headerTradeSettlement==null) return null;
		List<TradePaymentTermsType> tradePaymentTermsList = headerTradeSettlement.getSpecifiedTradePaymentTerms(); // 0 .. n
		// tradePaymentTermsList / Detailinformationen zu Zahlungsbedingungen
		if(tradePaymentTermsList.isEmpty()) return null;
		DateTimeType dateTime = tradePaymentTermsList.get(0).getDueDateDateTime();
		if(dateTime==null) return null;
		return DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue(), dateTime.getDateTimeString().getFormat());
	}

	@Override
	public void setPaymentTermsAndDate(String description, String ymd) {
		setPaymentTermsAndDate(description, DateTimeFormats.ymdToTs(ymd));
	}

	// BT-9 & BT-20 : Payment terms & Payment due date
	@Override
	public void setPaymentTermsAndDate(String description, Timestamp ts) {
		LOG.info("Payment terms description:"+description + " & Payment due date Timestamp:"+ts);
		TradePaymentTermsType tradePaymentTerms = new TradePaymentTermsType();
		if(description==null) {
//			LOG.warning("text==null");
		} else {
			tradePaymentTerms.getDescription().add(newTextType(description)); // returns List<TextType>
		}
		if(ts==null) {
//			LOG.warning("Timestamp ts==null");
		} else {
			tradePaymentTerms.setDueDateDateTime(newDateTime(ts));
		}
		
		applicableHeaderTradeSettlement.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
	}
	
	static DateTimeType newDateTime(Timestamp ts) {
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
	
	@Override
	public void setProjectReference(String docRefId, String name) {
		if(docRefId==null) return; // optional
		ProcuringProjectType procuringProject = new ProcuringProjectType();
		procuringProject.setID(CrossIndustryInvoice.newIDType(docRefId, null));
		procuringProject.setName(CrossIndustryInvoice.newTextType(name));
		
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setSpecifiedProcuringProject(procuringProject);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	@Override
	public String getProjectReferenceValue() {
		// TODO Auto-generated method stub
		return null;
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
		DocumentContextParameterType documentContextParameter = new DocumentContextParameterType();
		documentContextParameter.setID(newIDType(customization, null)); // null : No identification scheme

		exchangedDocumentContext.getGuidelineSpecifiedDocumentContextParameter().add(documentContextParameter);
		if(profile==null) {
			// profileIDType ist optional
		} else { 
			DocumentContextParameterType dcp = new DocumentContextParameterType();
			dcp.setID(newIDType(profile, null)); // null : No identification scheme
			exchangedDocumentContext.getBusinessProcessSpecifiedDocumentContextParameter().add(dcp);
		}
		this.setExchangedDocumentContext(exchangedDocumentContext);
	}

	@Override
	public String getCustomization() {
		return getCustomization(this);
	}
	static String getCustomization(CrossIndustryInvoiceType doc) {
		List<DocumentContextParameterType> documentContextParameterList = doc.getExchangedDocumentContext().getGuidelineSpecifiedDocumentContextParameter();
//		LOG.info("documentContextParameterList.size()="+documentContextParameterList.size());
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
	 * @param name mandatory BT-27 : The full formal name by which the Seller is registered 
	 *        in the national registry of legal entities or as a Taxable person or otherwise trades as a person or persons.
	 * @param postalAddress mandatory group BG-5/R53 : A group of business terms providing information about the address of the Seller.
              Sufficient components of the address are to be filled to comply with legal requirements.
	 * @param contact mandatory group BG-6/R57 : A group of business terms providing contact information about the Seller.
	 * @param companyId optional / Seller legal registration identifier, BT-30/R52
	 * @param companyLegalForm optional / Seller additional legal information, BT-33/R47
	 */
	public void setSeller(String name, PostalAddress address, TradeContact contact, 
			String companyId, String companyLegalForm) {
		                                  // BT-27        , BG-5   , BG-6   , BT-30    , BT-33
		TradeParty party = new TradeParty(name, address, contact, companyId, companyLegalForm);
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

//	/**
//	 * set optional taxCompanyId  / Seller VAT identifier, BG-4.BT-31, R52
//	 * 
//	 * @param taxCompany Identifier
//	 */
//	@Deprecated // use Party
//	public void setSellerTaxCompanyId(String taxCompanyId) {
//		if(taxCompanyId==null) return;
//		TaxRegistrationType taxRegistration = new TaxRegistrationType();
//		taxRegistration.setID(newIDType(taxCompanyId, null));
//		TradeParty party = getSellerParty();
////		party.getSpecifiedTaxRegistration().add(taxRegistration);
//		party.addPartyTaxID(taxCompanyId); //, schemeID); 
//	}
//	@Deprecated // use Party
//	public String getSellerTaxCompanyId() { // ohne Schema!
//		TradeParty party = getSellerParty();
//		List<TaxRegistrationType> taxRegistrationList = party.getSpecifiedTaxRegistration();
//		if(taxRegistrationList.isEmpty()) return null;
//		return taxRegistrationList.get(0).getID().getValue();
//	}

	/* BUYER                                       BG-7                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, die Informationen über den Erwerber liefern.
	 */
	public void setBuyer(String name, PostalAddress address, TradeContact contact) {
		TradeParty party = new TradeParty(name, address, contact, null, null); // BT-44, BG-8, BG-9, BT-45 optional, BT-46 optional
		setBuyerParty(party);
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

	/* PAYEE                                       BG-10                       0..1
	 * Eine Gruppe von Informationselementen, die Informationen über den Zahlungsempfänger liefern. 
	 * Die Gruppe wird genutzt, wenn der Zahlungsempfänger nicht mit dem Verkäufer identisch ist.
	 *
   01.02a-INVOICE_uncefact.xml :
        <ram:ApplicableHeaderTradeSettlement>
            <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
            <ram:PayeeTradeParty>
                <ram:Name>VSB - Verlagsservice Braunschweig GmbH</ram:Name>
            </ram:PayeeTradeParty>
            
   01.14a-INVOICE_uncefact.xml :
           <ram:ApplicableHeaderTradeSettlement>
            <ram:PaymentReference>Deb. 12345 / Fact. 9876543</ram:PaymentReference>
            <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
            <ram:PayeeTradeParty>
                <ram:ID>74</ram:ID>
                <ram:Name>[Payee name]</ram:Name>
            </ram:PayeeTradeParty>
 */
	public void setPayee(String name, String id, String companyLegalForm) {
		TradeParty party = new TradeParty(name, null, null, null, companyLegalForm);
		party.setId(id);
		setPayeeParty(party);
	}
	public void setPayeeParty(TradeParty party) {
		applicableHeaderTradeSettlement.setPayeeTradeParty(party);
	}

	public TradeParty getPayeeParty() {
		TradePartyType payeeParty = applicableHeaderTradeSettlement.getPayeeTradeParty();
		return payeeParty==null ? null : new TradeParty(payeeParty);
	}

	static TradeParty getPayeeParty(CrossIndustryInvoiceType doc) {
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(doc);
		if(applicableHeaderTradeSettlement==null) return null; // 1..1 : darf nicht null sein
		TradePartyType party = applicableHeaderTradeSettlement.getPayeeTradeParty();
		return party==null ? null : new TradeParty(party);
	}
	
	/* SELLER TAX REPRESENTATIVE PARTY             BG-11                       0..1
	 * Eine Gruppe von Informationselementen, die Informationen über den Steuervertreter des Verkäufers liefern.
	 */
	// BT-62 ++ 1..1 Seller tax representative name
	
	// BT-63 ++ 1..1 Seller tax representative VAT identifier
	public void setTaxRepresentative(String name, PostalAddress address, String taxRegistrationName, String taxRegistrationSchemaID) {
		TradeParty party = new TradeParty(name, address, null, null, null);
		party.setTaxRegistrationId(taxRegistrationName, taxRegistrationSchemaID);
		setTaxRepresentativeParty(party);
	}
	public void setTaxRepresentativeParty(TradeParty party) {
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setSellerTaxRepresentativeTradeParty(party);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	public TradeParty getTaxRepresentativeParty() {
		return getTaxRepresentativeParty(this);
	}
	static TradeParty getTaxRepresentativeParty(CrossIndustryInvoiceType doc) {
		HeaderTradeAgreementType headerTradeAgreement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		TradePartyType party = headerTradeAgreement.getSellerTaxRepresentativeTradeParty();
		return party==null ? null : new TradeParty(party);
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
	public void setDeliveryInformation(String businessName, Timestamp ts, PostalAddress address, String locationId) {
		applicableHeaderTradeDelivery = new ApplicableHeaderTradeDelivery(businessName, ts, address, locationId);
		supplyChainTradeTransaction.setApplicableHeaderTradeDelivery(applicableHeaderTradeDelivery);
	}
	
	public void setDeliveryInformation(HeaderTradeDeliveryType headerTradeDelivery) {
		applicableHeaderTradeDelivery = headerTradeDelivery;
		supplyChainTradeTransaction.setApplicableHeaderTradeDelivery(applicableHeaderTradeDelivery);
	}
	
	public HeaderTradeDeliveryType getDeliveryInformation() {
//		return getDeliveryInformation(this);
		HeaderTradeDeliveryType headerTradeDelivery = supplyChainTradeTransaction.getApplicableHeaderTradeDelivery();
		if(headerTradeDelivery==null) return null;
		return headerTradeDelivery;
	}
//	static HeaderTradeDeliveryType getDeliveryInformation(CrossIndustryInvoiceType doc) {
//		HeaderTradeDeliveryType headerTradeDelivery = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeDelivery();
//		LOG.info("HeaderTradeDeliveryType headerTradeDelivery:"+headerTradeDelivery);
//		if(headerTradeDelivery==null) return null;
//		LOG.info("HeaderTradeDeliveryType headerTradeDelivery.getShipToTradeParty():"+headerTradeDelivery.getShipToTradeParty());
//		return new ApplicableHeaderTradeDelivery(headerTradeDelivery);
////		return headerTradeDelivery==null ? null : new ApplicableHeaderTradeDelivery(headerTradeDelivery);
//	}
	
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
	PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation) {
		// ohne remittanceInformation:
		return ((ApplicableHeaderTradeSettlement)applicableHeaderTradeSettlement).createPaymentInstructions(code, paymentMeansText);
	}
	/**
	 * group PAYMENT INSTRUCTIONS, BG-16 Cardinality 0..1
	 * 
	 * @param code                   mandatory BT-81
	 * @param paymentMeansText       optional  BT-82 (can be null)
	 * @param remittanceInformation  optional  BT-83
	 */
	public void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation) {
		PaymentInstructions pi = createPaymentInstructions(code, paymentMeansText, remittanceInformation);
		((ApplicableHeaderTradeSettlement)applicableHeaderTradeSettlement).setBG16(pi);
		((ApplicableHeaderTradeSettlement)applicableHeaderTradeSettlement).setRemittanceInformation(remittanceInformation);
	}
	public List<TradeSettlementPaymentMeans> getTradeSettlementPaymentMeansList() {
		List<TradeSettlementPaymentMeansType> tspmList = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementPaymentMeans();
		List<TradeSettlementPaymentMeans> result = new ArrayList<TradeSettlementPaymentMeans>(tspmList.size());
		tspmList.forEach(tspm -> { // public TradeSettlementPaymentMeans(TradeSettlementPaymentMeansType tspm)
			result.add(new TradeSettlementPaymentMeans(tspm));
		});
		return result;
	}
	// BG-16.BT-81 - 0..1/1..1
	public PaymentMeansEnum getPaymentMeansCode() {
		List<TradeSettlementPaymentMeansType> tspmList = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementPaymentMeans();
		if(tspmList.isEmpty()) return null;
		TradeSettlementPaymentMeans res = new TradeSettlementPaymentMeans(tspmList.get(0));
		return res.getPaymentMeansEnum();
//		List<TradeSettlementPaymentMeans> result = new ArrayList<TradeSettlementPaymentMeans>(tspmList.size());
//		tspmList.forEach(tspm -> { // public TradeSettlementPaymentMeans(TradeSettlementPaymentMeansType tspm)
//			result.add(new TradeSettlementPaymentMeans(tspm));
//		});
//		return result.isEmpty() ? null : result.get(0).getPaymentMeansEnum();
	}
	// BG-16.BT-83 - 0..1/0..1
	public String getRemittanceInformation() {
		return ((ApplicableHeaderTradeSettlement)applicableHeaderTradeSettlement).getRemittanceInformation();
	}
	
	public CreditTransfer getCreditTransfer() {
		return ((ApplicableHeaderTradeSettlement)applicableHeaderTradeSettlement).getCreditTransfer();
	}
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		return ((ApplicableHeaderTradeSettlement)applicableHeaderTradeSettlement).createCreditTransfer(iban, accountName, bic);
	}

	// BG-22.BT-106 - 1..1/1..1
	@Override
	public Amount getInvoiceLineNetTotal() {
		return new Amount(applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation().getLineTotalAmount().get(0).getValue());
	}
	static Amount getInvoiceLineNetTotal(CrossIndustryInvoiceType doc) {
		TradeSettlementHeaderMonetarySummationType stshms = getSpecifiedTradeSettlementHeaderMonetarySummation(doc); // 1..1
		return new Amount(stshms.getLineTotalAmount().get(0).getValue());
	}
	// BG-22.BT-109 - 1..1/1..1
	@Override
	public Amount getInvoiceTotalTaxExclusive() {
		return new Amount(applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxBasisTotalAmount().get(0).getValue());
	}
	static Amount getInvoiceTotalTaxExclusive(CrossIndustryInvoiceType doc) {
		TradeSettlementHeaderMonetarySummationType stshms = getSpecifiedTradeSettlementHeaderMonetarySummation(doc); // 1..1
		return new Amount(stshms.getTaxBasisTotalAmount().get(0).getValue());
	}
	// BG-22.BT-112 - 1..1/1..1
	@Override
	public Amount getInvoiceTotalTaxInclusive() {
		return new Amount(applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation().getGrandTotalAmount().get(0).getValue());
	}
	static Amount getInvoiceTotalTaxInclusive(CrossIndustryInvoiceType doc) {
		TradeSettlementHeaderMonetarySummationType stshms = getSpecifiedTradeSettlementHeaderMonetarySummation(doc); // 1..1
		return new Amount(stshms.getGrandTotalAmount().get(0).getValue());
	}
	// BG-22.BT-115 - 1..1/1..1
	@Override
	public Amount getDuePayable() {
		return new Amount(applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation().getDuePayableAmount().get(0).getValue());
	}
	static Amount getDuePayable(CrossIndustryInvoiceType doc) {
		TradeSettlementHeaderMonetarySummationType stshms = getSpecifiedTradeSettlementHeaderMonetarySummation(doc); // 1..1
		return new Amount(stshms.getDuePayableAmount().get(0).getValue());
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

	private Amount getInvoiceTax(boolean sameCurrency) {
		List<AmountType> list = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxTotalAmount();
		if(list.isEmpty()) return null;
		for(int i=0; i<list.size(); i++) {
			if(sameCurrency && (this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
//				return new Amount(list.get(i).getValue());
				return list.get(i).getCurrencyID()==null ? new Amount(list.get(i).getValue()) : new Amount(list.get(i).getCurrencyID(), list.get(i).getValue());
			} else if(!sameCurrency && !(this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
				return new Amount(list.get(i).getCurrencyID(), list.get(i).getValue());
			}
		}
		return null;
	}
	// BG-22.BT-110/BT-111 - 1..1/0..2
	/* zu BT-111: getTaxCurrency() BT-6 getDocumentCurrency() BT-5
	 * Zu verwenden, wenn der Code für die Währung der Umsatzsteuerbuchung (BT-6) nach Artikel 230 der Richtlinie 2006/112/EG über Umsatzsteuer 
	 * vom Code für die Rechnungswährung (BT-5) abweicht.
	 */
	@Override
	public Amount getInvoiceTax() {
		return getInvoiceTax(true);
	}
	@Override
	public Amount getInvoiceTaxInAccountingCurrency() {
		return getInvoiceTax(false);
	}

	static HeaderTradeSettlementType getApplicableHeaderTradeSettlement(CrossIndustryInvoiceType doc) {
		SupplyChainTradeTransactionType supplyChainTradeTransaction = doc.getSupplyChainTradeTransaction();
		if(supplyChainTradeTransaction==null) return null;
		return supplyChainTradeTransaction.getApplicableHeaderTradeSettlement(); // 1..1 : darf nicht null sein
	}
	static TradeSettlementHeaderMonetarySummationType getSpecifiedTradeSettlementHeaderMonetarySummation(CrossIndustryInvoiceType doc) {
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(doc);
		if(applicableHeaderTradeSettlement==null) return null; // 1..1 : darf nicht null sein
		return applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation(); // 1..1 : darf nicht null sein
	}
	static Amount getInvoiceTax(CrossIndustryInvoiceType doc) {
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(doc);
		if(applicableHeaderTradeSettlement==null) return null;
		List<AmountType> list = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxTotalAmount();
		if(list.isEmpty()) return null;
		for(int i=0; i<list.size(); i++) {
			if(getTaxCurrency(doc)==null || getDocumentCurrency(doc).equals(getTaxCurrency(doc))) {
				return list.get(i).getCurrencyID()==null ? new Amount(list.get(i).getValue()) : new Amount(list.get(i).getCurrencyID(), list.get(i).getValue());
//			} else if(!sameCurrency && !(this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
//				return new Amount(list.get(i).getCurrencyID(), list.get(i).getValue());
			}
		}
		return null;	
	}
	/**
	 * optional total VAT amount of the invoice
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
		// TODO assert:
		if(this.getDocumentCurrency().equals(this.getTaxCurrency())) {
			LOG.warning("Document currency is "+getDocumentCurrency() + " equals to Tax Currency!");
		}
		setInvoiceTax(amount);	
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
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(doc);
		if(applicableHeaderTradeSettlement==null) return null; // 1..1 : darf nicht null sein
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
