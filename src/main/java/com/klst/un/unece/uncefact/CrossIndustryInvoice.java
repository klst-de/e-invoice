package com.klst.un.unece.uncefact;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.cius.CoreInvoice;
import com.klst.cius.DocumentTotals;
import com.klst.cius.IContact;
import com.klst.cius.PostalAddress;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansCode;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentMeansCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxTypeCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.CreditorFinancialAccountType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.DocumentContextParameterType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.DocumentLineDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ExchangedDocumentContextType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ExchangedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeAgreementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeAgreementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeDeliveryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LineTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeLineItemType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeTransactionType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TaxRegistrationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAddressType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeContactType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePriceType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeProductType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementHeaderMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementLineMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType;
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

	public CrossIndustryInvoice(String customization, DocumentNameCode documentNameCode) {
		this(customization, null, documentNameCode);
	}
	
	public CrossIndustryInvoice(String customization, String profile, DocumentNameCode documentNameCode) {
		this();
		setProcessControl(customization, profile);

		// Invoice type code                           BT-3
		// Ein Code, der den Funktionstyp der Rechnung angibt.
/*
    <rsm:ExchangedDocument>
        <ram:ID>123456XX</ram:ID>
        <ram:TypeCode>380</ram:TypeCode>
        <ram:IssueDateTime>
            <udt:DateTimeString format="102">20160404</udt:DateTimeString>
        </ram:IssueDateTime>
        <ram:IncludedNote>
            <ram:Content>Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden.</ram:Content>
            <ram:SubjectCode>ADU</ram:SubjectCode>
        </ram:IncludedNote>
    </rsm:ExchangedDocument>

 */		
		ExchangedDocumentType ed = new ExchangedDocumentType();
		DocumentCodeType documentCode = new DocumentCodeType();
		documentCode.setValue(documentNameCode.getValueAsString());
		ed.setTypeCode(documentCode);
		this.setExchangedDocument(ed);
	}

	// copy-ctor
	public CrossIndustryInvoice(CrossIndustryInvoiceType doc) {
		this(getCustomization(doc), getProfile(doc), getTypeCode(doc));
		setId(getId(doc));
		setIssueDate(getIssueDateAsTimestamp(doc));
		setDocumentCurrency(getDocumentCurrency(doc));
		setTaxCurrency(getTaxCurrency(doc)); // optional
		setTaxPointDate(getTaxPointDateAsTimestamp(doc)); // optional
		setPaymentTermsAndDate(getPaymentTerm(doc), getDueDateAsTimestamp(doc)); // optional
//		setBuyerReference(getBuyerReferenceValue(doc)); // optional
//		setOrderReferenceID(getOrderReferenceID(doc)); // optional
//		addPaymentTerms(doc);
//		addNotes(doc);	
//		setSellerParty(getSellerParty(doc));
//		setBuyerParty(getBuyerParty(doc));
//		addDeliveries(doc);
//		addPaymentInstructions(doc);		
//		setDocumentTotals(doc);
//		setInvoiceTax(getInvoiceTax(doc));
//		addVATBreakDown(doc);
//		addLines(doc);
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
		IDType mID = new IDType();
		mID.setValue(id);
		ed.setID(mID);
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

	@Override
	public void setDocumentCurrency(String isoCurrencyCode) {
		// SupplyChainTradeTransaction
		// ApplicableHeaderTradeSettlement
		// 1 .. 1 InvoiceCurrencyCode Code für die Rechnungswährung BT-5
		CurrencyCodeType currencyCode = new CurrencyCodeType();
		currencyCode.setValue(isoCurrencyCode);
		HeaderTradeSettlementType headerTradeSettlement = getApplicableHeaderTradeSettlement();
		headerTradeSettlement.setInvoiceCurrencyCode(currencyCode);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeSettlement(headerTradeSettlement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);
	}

	@Override
	public String getDocumentCurrency() {
		return getDocumentCurrency(this);
	}
	static String getDocumentCurrency(CrossIndustryInvoiceType doc) {
		return doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement().getInvoiceCurrencyCode().getValue();
	}

	@Override // internal use only
	public SupplyChainTradeTransactionType getSupplyChainTradeTransaction() {
		SupplyChainTradeTransactionType supplyChainTradeTransaction = super.getSupplyChainTradeTransaction();
		if(supplyChainTradeTransaction==null) {
			supplyChainTradeTransaction = new SupplyChainTradeTransactionType();
			LOG.info("new SupplyChainTradeTransactionType:"+supplyChainTradeTransaction);
		}
		return supplyChainTradeTransaction;
	}
	
	@Override
	public void setTaxCurrency(String isoCurrencyCode) {
		if(isoCurrencyCode==null) return;  // optional
		CurrencyCodeType currencyCode = new CurrencyCodeType();
		currencyCode.setValue(isoCurrencyCode);
		HeaderTradeSettlementType headerTradeSettlement = getApplicableHeaderTradeSettlement();
		headerTradeSettlement.setTaxCurrencyCode(currencyCode);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeSettlement(headerTradeSettlement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);
	}

	@Override
	public String getTaxCurrency() {
		return getTaxCurrency(this);
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

	@Override
	public void setTaxPointDate(Timestamp ts) {
		if(ts==null) return;  // optional
		HeaderTradeSettlementType headerTradeSettlement = getApplicableHeaderTradeSettlement();
//		List<TradeTaxType> tradeTaxList = headerTradeSettlement.getApplicableTradeTax();
		
		DateType.DateString dateString = new DateType.DateString(); // DateString ist inner class in DateType
		dateString.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		dateString.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		
		DateType date = new DateType();
		date.setDateString(dateString);
		
		TradeTaxType tradeTax = new TradeTaxType();
		tradeTax.setTaxPointDate(date);
		
//		tradeTaxList.add(tradeTax);
		headerTradeSettlement.getApplicableTradeTax().add(tradeTax);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeSettlement(headerTradeSettlement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);
	}

	@Override
	public Timestamp getTaxPointDateAsTimestamp() {
		return getTaxPointDateAsTimestamp(this);
	}
	static Timestamp getTaxPointDateAsTimestamp(CrossIndustryInvoiceType doc) {
		HeaderTradeSettlementType headerTradeSettlement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement();
		List<TradeTaxType> tradeTaxList = headerTradeSettlement.getApplicableTradeTax();
		if(tradeTaxList.isEmpty()) return null;
		
		List<Timestamp> results = new ArrayList<Timestamp>(tradeTaxList.size());
		tradeTaxList.forEach(tradeTax -> {
			DateType date = tradeTax.getTaxPointDate();
			if(date==null) {
				LOG.warning("TaxPointDate is null");
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

	/*
DueDateDateTime Fälligkeitsdatum

1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. n SpecifiedTradePaymentTerms Detailinformationen zu Zahlungsbedingungen xs:sequence 
0 .. 1 Description Zahlungsbedingungen BT-20 
0 .. 1 DueDateDateTime Fälligkeitsdatum xs:choice 
1 .. 1 DateTimeString Fälligkeitsdatum der Zahlung BT-9 
       required format Datum, Format BT-9-0

	 */
	
////	@Override
//	public void setDueDate(String ymd) {
//		setDueDate(DateTimeFormats.ymdToTs(ymd));
//	}
////	@Override
//	public void setDueDate(Timestamp ts) { // TODO zusammen mit BT20
//		if(ts==null) return;  // optional
//		HeaderTradeSettlementType headerTradeSettlement = getApplicableHeaderTradeSettlement();
////		List<TradePaymentTermsType> tradePaymentTermsList = headerTradeSettlement.getSpecifiedTradePaymentTerms();
//		
//		TradePaymentTermsType tradePaymentTerms = new TradePaymentTermsType();
//		// TODO befüllen:
////		List<TextType> textList = tradePaymentTerms.getDescription(); // Liste Zahlungsbedingungen BT-20
//		DateTimeType dateTime = new DateTimeType();
//		DateTimeType.DateTimeString dts = new DateTimeType.DateTimeString(); // DateTimeString ist inner class in DateTimeType
//		dts.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
//		dts.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
//		dateTime.setDateTimeString(dts);
//		tradePaymentTerms.setDueDateDateTime(dateTime);
//		
////		tradePaymentTermsList.add(tradePaymentTerms);
//		headerTradeSettlement.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
//		
//		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
//		supplyChainTradeTransaction.setApplicableHeaderTradeSettlement(headerTradeSettlement);
//		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
//	}

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

	@Override
	public void setPaymentTermsAndDate(String description, Timestamp ts) {
		TradePaymentTermsType tradePaymentTerms = new TradePaymentTermsType();
		if(description==null) {
			LOG.warning("text==null");
		} else {
			TextType text = new TextType();
			text.setValue(description);
			tradePaymentTerms.getDescription().add(text); // returns List<TextType>
		}
		if(ts==null) {
			LOG.warning("Timestamp ts==null");
		} else {
			tradePaymentTerms.setDueDateDateTime(newDateTime(ts));
		}
		
		HeaderTradeSettlementType headerTradeSettlement = getApplicableHeaderTradeSettlement();
		headerTradeSettlement.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeSettlement(headerTradeSettlement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
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
		return getPaymentTerm(this);
	}
	static String getPaymentTerm(CrossIndustryInvoiceType doc) {
		HeaderTradeSettlementType headerTradeSettlement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement();
		List<TradePaymentTermsType> tradePaymentTermsList = headerTradeSettlement.getSpecifiedTradePaymentTerms();
		if(tradePaymentTermsList.isEmpty()) return null;
		
		TradePaymentTermsType tradePaymentTerms = tradePaymentTermsList.get(0); // da Cardinality 0..1 kann es nur einen geben
		List<TextType> textList = tradePaymentTerms.getDescription();
		return textList.isEmpty() ? null : textList.get(0).getValue();
	}

/*

1 .. 1 SupplyChainTradeTransaction Gruppierung der Informationen zum Geschäftsvorfall
1 .. 1 ApplicableHeaderTradeAgreement Gruppierung der Vertragsangaben
0 .. 1 BuyerReference Referenz des Käufers BT-10
 
 */
	@Override
	public void setBuyerReference(String reference) {
		TextType text = new TextType();
		text.setValue(reference);
		
		// headerTradeAgreement cachen wg SellerTradeParty , ...
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setBuyerReference(text);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	@Override
	public String getBuyerReferenceValue() {
		// TODO Auto-generated method stub
		return null;
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
		TextType text = new TextType();
		text.setValue(noteContent);
		textList.add(text);
		noteList.add(note);
		return noteList;
	}
	public List<String> getNotes() {
		return getNotes(this);
	}
	static List<String> getNotes(CrossIndustryInvoiceType doc) {
		ExchangedDocumentType ed = doc.getExchangedDocument();
		List<NoteType> noteList = ed.getIncludedNote();
		List<String> res = new ArrayList<String>(noteList.size());
		noteList.forEach(note -> res.add(note.getContent().get(0).getValue()));
		return res;
	}

	/* PROCESS CONTROL                             BG-2                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, 
	 * die Informationen über den Geschäftsprozess und für die Rechnung geltende Regeln liefern.

    <rsm:ExchangedDocumentContext>
        <ram:GuidelineSpecifiedDocumentContextParameter>
            <ram:ID>urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_1.2</ram:ID>
        </ram:GuidelineSpecifiedDocumentContextParameter>
    </rsm:ExchangedDocumentContext>


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
		IDType iDTyp = new IDType();
		iDTyp.setValue(customization);
		iDTyp.setSchemeID("XRECHNUNG");
		documentContextParameter.setID(iDTyp);
		documentContextParameterList.add(documentContextParameter);
		this.setExchangedDocumentContext(exchangedDocumentContext);
		if(profile==null) {
			// profileIDType ist optional, nicht in cii
		} else { // BusinessProcessSpecifiedDocumentContextParameter
//			ProfileIDType profileIDType = new ProfileIDType();
//			profileIDType.setValue(profile);
//			this.setProfileID(profileIDType);
		}
	}

	public String getCustomization() {
		return getCustomization(this);
	}
	static String getCustomization(CrossIndustryInvoiceType doc) {
		List<DocumentContextParameterType> documentContextParameterList = doc.getExchangedDocumentContext().getGuidelineSpecifiedDocumentContextParameter();
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


// --------------------------------
	// nicht in XRechnung-v1-2-0.pdf beschrieben
	public void setOrderReference(String id) {
		LOG.warning("für cii nicht implementiert");
//		OrderReferenceType orderReference = new OrderReferenceType();
//		IDType mID = new IDType();
//		mID.setValue(id);
//		orderReference.setID(mID);
//		this.setOrderReference(orderReference);
	}

	/**
	 * Adds a mandatory PAYMENT INSTRUCTIONS Group with ibanlAccount as CREDIT TRANSFER
	 * 
	 * @param enum paymentMeansCode, use PaymentMeansCode.CreditTransfer or PaymentMeansCode.SEPACreditTransfer
	 * @param String iban to create ibanlAccount element
	 * @param String remittanceInformation optional
	 * @return paymentMeansList with minimum 1 element
	 */
/*
    <ram:ApplicableHeaderTradeSettlement>
        <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>
        <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>  <<======== setPaymentCurrencyCode
        <ram:SpecifiedTradeSettlementPaymentMeans>              <<======== addPaymentInstructions
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

	CreditorFinancialAccountType makeCreditTransfer(IBANId iban) {
//	FinancialAccountType makeCreditTransfer(IbanId iban) {
		CreditorFinancialAccountType financialAccount = new CreditorFinancialAccountType();
		
		IDType ibanID = new IDType();
		ibanID.setValue(iban.getValue());
		ibanID.setSchemeID(iban.getSchemeID()); // so nicht in XRechnung-v1-2-0.pdf dokumentiert
		financialAccount.setIBANID(ibanID);
		
		return financialAccount;
	}
	public CreditorFinancialAccountType makeCreditTransfer(String account, String accountName, BICId bic) {
			CreditorFinancialAccountType financialAccount = new CreditorFinancialAccountType();
			
			IDType ibanID = new IDType();
			ibanID.setValue(account);
			financialAccount.setIBANID(ibanID);
			
			TextType name = new TextType();
			name.setValue(accountName);
			financialAccount.setAccountName(name);
			
			IDType bicID = new IDType();
			bicID.setValue(bic.getValue());
			bicID.setSchemeID(bic.getSchemeID());
			financialAccount.setProprietaryID(bicID);
			return financialAccount;
		}
	
	/**
	 * Adds a mandatory PAYMENT INSTRUCTIONS Group with ibanlAccount as CREDIT TRANSFER
	 * 
	 * @param enum paymentMeansCode, use PaymentMeansCode.CreditTransfer or PaymentMeansCode.SEPACreditTransfer
	 * @param IBANId iban to create ibanlAccount element
	 * @param String remittanceInformation optional
	 * @return List with minimum 1 element
	 */
	public List<TradeSettlementPaymentMeansType> addPaymentInstructions(PaymentMeansCode paymentMeansCode, IBANId iban, String remittanceInformation) {
//	public List<PaymentMeansType> addPaymentInstructions(PaymentMeansCode paymentMeansCode, IbanId iban, String remittanceInformation) {
		CreditorFinancialAccountType creditorFinancialAccount = makeCreditTransfer(iban);
		return addPaymentInstructions(paymentMeansCode, creditorFinancialAccount, remittanceInformation);
	}

	/**
	 * Adds a mandatory PAYMENT INSTRUCTIONS Group
	 * 
	 * @param enum paymentMeansCode
	 * @param financialAccount
	 * @param remittanceInformation optional
	 * @return paymentMeansList with minimum 1 element
	 */
	public List<TradeSettlementPaymentMeansType> addPaymentInstructions(PaymentMeansCode paymentMeansCode, CreditorFinancialAccountType financialAccount, String remittanceInformation) {
		SupplyChainTradeTransactionType supplyChainTradeTransaction = getSupplyChainTradeTransaction();
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(supplyChainTradeTransaction);
		
		TradeSettlementPaymentMeansType tradeSettlementPaymentMeans = new TradeSettlementPaymentMeansType();
		PaymentMeansCodeType pmc = new PaymentMeansCodeType(); 
		pmc.setValue(paymentMeansCode.getValueAsString());
		tradeSettlementPaymentMeans.setTypeCode(pmc);
		
		List<TextType> informationList = tradeSettlementPaymentMeans.getInformation();
		TextType text = new TextType();
		text.setValue(remittanceInformation);
		informationList.add(text);

		tradeSettlementPaymentMeans.setPayeePartyCreditorFinancialAccount(financialAccount);
		List<TradeSettlementPaymentMeansType> tradeSettlementPaymentMeansList = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementPaymentMeans();
		tradeSettlementPaymentMeansList.add(tradeSettlementPaymentMeans);
		return tradeSettlementPaymentMeansList;
	}

	/*
wg. val-sch.1.1 	BR-CO-25 	error 	
[BR-CO-25]-In case the Amount due for payment (BT-115) is positive, 
either the Payment due date (BT-9) or the Payment terms (BT-20) shall be present. 
	 */
	public void addPaymentTerms(String paymentTerms) {
		SupplyChainTradeTransactionType supplyChainTradeTransaction = getSupplyChainTradeTransaction();
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(supplyChainTradeTransaction);
		
		TradePaymentTermsType tradePaymentTerm = new TradePaymentTermsType(); 
		TextType text = new TextType();
		text.setValue(paymentTerms);
		tradePaymentTerm.getDescription().add(text);
		applicableHeaderTradeSettlement.getSpecifiedTradePaymentTerms().add(tradePaymentTerm);
	}

	/**
	 *  Buyer (AccountingCustomerParty)
	 *  Buyer is mandatory information and provided in element cac:AccountingCustomerParty
	 *  
	 * @param buyerName mandatory
	 * @param postalAddress mandatory
	 * @param contact optinal
	 */
	public void setBuyer(String buyerName, PostalAddress postalAddress, IContact contact) {
		SupplyChainTradeTransactionType supplyChainTradeTransaction = getSupplyChainTradeTransaction();
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement(supplyChainTradeTransaction);
		
		TradePartyType tradePartyType = new TradePartyType();
		TextType text = new TextType();
		text.setValue(buyerName);
		tradePartyType.setName(text);
 
		tradePartyType.setPostalTradeAddress((TradeAddressType)postalAddress);
		
		if(contact!=null) { // optional
			List<TradeContactType> contacts = tradePartyType.getDefinedTradeContact();
			contacts.add(new TradeContact(contact));
		}
		
//		List<PartyIdentificationType> partyIdentifications = party.getPartyIdentification();
//		PartyIdentificationType partyIdentification = new PartyIdentificationType();
//		IDType buyerID = new IDType();
//		buyerID.setValue("BuyerID");                                                 // TODO 
//		partyIdentification.setID(buyerID);
//		partyIdentifications.add(partyIdentification);
		
/*
         <element name="ID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
         <element name="GlobalID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/>
         <element name="Name" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" minOccurs="0"/>
         <element name="RoleCode" type="{urn:un:unece:uncefact:data:standard:QualifiedDataType:100}PartyRoleCodeType" maxOccurs="unbounded" minOccurs="0"/>
         <element name="Description" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/>
         <element name="SpecifiedLegalOrganization" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}LegalOrganizationType" minOccurs="0"/>
         <element name="DefinedTradeContact" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeContactType" maxOccurs="unbounded" minOccurs="0"/>
         <element name="PostalTradeAddress" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TradeAddressType" minOccurs="0"/>
         <element name="URIUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" maxOccurs="unbounded" minOccurs="0"/>
         <element name="SpecifiedTaxRegistration" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}TaxRegistrationType" maxOccurs="unbounded" minOccurs="0"/>
         <element name="EndPointURIUniversalCommunication" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}UniversalCommunicationType" minOccurs="0"/>
         <element name="LogoAssociatedSpecifiedBinaryFile" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedBinaryFileType" maxOccurs="unbounded" minOccurs="0"/>
 */
		headerTradeAgreement.setBuyerTradeParty(tradePartyType);
		
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction); 
	}

	/**
	 * Seller (AccountingSupplierParty)
	 * Seller is mandatory information and provided in element cac:AccountingSupplierParty
	 * 
	 * @param sellerName mandatory
	 * @param postalAddress mandatory group
	 * @param contact mandatory group
 	 * @param sellerVATid optional
	 */
	public void setSeller(String sellerName, PostalAddress postalAddress, IContact contact, String sellerVATid) {
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = getSupplyChainTradeTransaction();
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement(supplyChainTradeTransaction);
		
		TradePartyType tradeParty = new TradePartyType();
		TextType text = new TextType();
		text.setValue(sellerName);
		tradeParty.setName(text);
		
		if(sellerVATid!=null) {
			TaxRegistrationType taxRegistration = new TaxRegistrationType();
			IDType id = new IDType();
			id.setValue(sellerVATid);
			id.setSchemeID("VAT");
			taxRegistration.setID(id);
			tradeParty.getSpecifiedTaxRegistration().add(taxRegistration);
		}
		
		tradeParty.setPostalTradeAddress((TradeAddressType)postalAddress); // cast!
		tradeParty.getDefinedTradeContact().add(new TradeContact(contact));
		
		headerTradeAgreement.setSellerTradeParty(tradeParty);
		
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction); 
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
		SupplyChainTradeTransactionType supplyChainTradeTransaction = getSupplyChainTradeTransaction();
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(supplyChainTradeTransaction);
		TradeSettlementHeaderMonetarySummationType tradeSettlementHeaderMonetarySummationType = getTradeSettlementHeaderMonetarySummation(applicableHeaderTradeSettlement);
		
		AmountType lineTotalAmt = new AmountType();
		lineExtension.copyTo(lineTotalAmt);
		tradeSettlementHeaderMonetarySummationType.getLineTotalAmount().add(lineTotalAmt); // add to list
		
		AmountType taxBasisTotalAmt = new AmountType();
//		taxBasisTotalAmt.setCurrencyID(taxExclusive.getCurrencyID());
//		taxBasisTotalAmt.setValue(taxExclusive.getValue(RoundingMode.HALF_UP));
		taxExclusive.copyTo(taxBasisTotalAmt);
		tradeSettlementHeaderMonetarySummationType.getTaxBasisTotalAmount().add(taxBasisTotalAmt); // add to list
		
		AmountType taxTotalAmt = new AmountType();
//		taxTotalAmt.setValue(taxInclusive.getValue(RoundingMode.HALF_UP));
		taxInclusive.copyTo(taxTotalAmt);
/*
wg. val-sch.1.1 	BR-CO-15 	error 	[BR-CO-15]-
Invoice total amount with VAT (BT-112) = Invoice total amount without VAT (BT-109) + Invoice total VAT amount (BT-110). 
 */
		taxTotalAmt.setCurrencyID(taxInclusive.getCurrencyID()); // wg. validation 
		tradeSettlementHeaderMonetarySummationType.getGrandTotalAmount().add(taxTotalAmt); // add to list
		
		AmountType payableAmt = new AmountType();
//		payableAmt.setCurrencyID(payable.getCurrencyID());
//		payableAmt.setValue(payable.getValue(RoundingMode.HALF_UP));
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
		SupplyChainTradeTransactionType supplyChainTradeTransaction = getSupplyChainTradeTransaction();
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(supplyChainTradeTransaction);
		TradeSettlementHeaderMonetarySummationType tradeSettlementHeaderMonetarySummationType = getTradeSettlementHeaderMonetarySummation(applicableHeaderTradeSettlement);
		
		AmountType taxTotalAmt = new AmountType();
//		taxTotalAmt.setCurrencyID(taxTotalAmount.getCurrencyID());
//		taxTotalAmt.setValue(taxTotalAmount.getValue(RoundingMode.HALF_UP));
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

	/**
	 * VAT BREAKDOWN
	 * 
	 * @param mandatory taxableAmount : VAT category taxable amount
	 * @param mandatory tax : VAT category tax amount
	 * @param mandatory taxCategoryCode : VAT category code
	 * @param mandatory taxRate : VAT category rate (Percentage)
// TODO	 * optional : VAT exemption reason text
// TODO	 * optional : VAT exemption reason code
	 */
	public void addVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		SupplyChainTradeTransactionType supplyChainTradeTransaction = getSupplyChainTradeTransaction();
		HeaderTradeSettlementType applicableHeaderTradeSettlement = getApplicableHeaderTradeSettlement(supplyChainTradeTransaction);

		TradeTaxType tradeTax = makeTradeTaxType(taxCategoryCode, taxRate);
		
		AmountType basisAmount = new AmountType();
		taxableAmount.copyTo(basisAmount);
		tradeTax.getBasisAmount().add(basisAmount);
		
		AmountType calculatedAmount = new AmountType();
		tax.copyTo(calculatedAmount);
		tradeTax.getCalculatedAmount().add(calculatedAmount);
		
		List<TradeTaxType> tradeTaxes = applicableHeaderTradeSettlement.getApplicableTradeTax();
		tradeTaxes.add(tradeTax);
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
	public List<SupplyChainTradeLineItemType> addInvoiceLine(SupplyChainTradeLineItemType invoiceLine) {
//	public List<InvoiceLineType> addInvoiceLine(InvoiceLineType invoiceLine) {
		SupplyChainTradeTransactionType supplyChainTradeTransaction = getSupplyChainTradeTransaction();
		List<SupplyChainTradeLineItemType> supplyChainTradeLineItems = supplyChainTradeTransaction.getIncludedSupplyChainTradeLineItem();
		supplyChainTradeLineItems.add(invoiceLine);
		return supplyChainTradeLineItems;
	}

	/* @see XRechnung-v1-2-0.pdf : 11.16. Gruppe INVOICE LINE

	Dieses Informationselement (ID: BG-25, Anz. 1..*) ist ein direkter Bestandteil des Wurzelelements „INVOICE“
	Eine Gruppe von Informationselementen, die Informationen über einzelne Rechnungspositionen liefern.
	
	mandatory:
	Invoice line identifier BT-126 Identifier 1 / Eindeutige Bezeichnung für die betreffende Rechnungsposition
	Invoiced quantity       BT-129 Quantity   1 / Die Menge zu dem in der betreffenden Zeile in Rechnung gestellten Einzelposten (Waren oder Dienstleistungen)
	Invoiced quantity unit of measure code BT-130 Code 1 / Die für die in Rechnung gestellte Menge geltende Maßeinheit.
	Invoice line net amount BT-131 Amount     1 / Der Gesamtbetrag der Rechnungsposition. Dies ist der Betrag ohne Umsatzsteuer, aber einschließlich 
	                                              aller für die Rechnungsposition geltenden Nachlässe und Abgaben sowie sonstiger anfallender Steuern.
	PRICE DETAILS           BG-29             1
	LINE VAT INFORMATION    BG-30             1
	ITEM INFORMATION        BG-31             1

        <ram:IncludedSupplyChainTradeLineItem>
            <ram:AssociatedDocumentLineDocument>
                <ram:LineID>Porto + Versandkosten</ram:LineID>
            </ram:AssociatedDocumentLineDocument>
            <ram:SpecifiedTradeProduct>
                <ram:Name>Porto + Versandkosten</ram:Name>
            </ram:SpecifiedTradeProduct>
            <ram:SpecifiedLineTradeAgreement>
                <ram:NetPriceProductTradePrice>
                    <ram:ChargeAmount>26.07</ram:ChargeAmount>
                </ram:NetPriceProductTradePrice>
            </ram:SpecifiedLineTradeAgreement>
            <ram:SpecifiedLineTradeDelivery>
                <ram:BilledQuantity unitCode="XPP">1</ram:BilledQuantity>
            </ram:SpecifiedLineTradeDelivery>
            <ram:SpecifiedLineTradeSettlement>
                <ram:ApplicableTradeTax>
                    <ram:TypeCode>VAT</ram:TypeCode>
                    <ram:CategoryCode>S</ram:CategoryCode>
                    <ram:RateApplicablePercent>7</ram:RateApplicablePercent>
                </ram:ApplicableTradeTax>
                <ram:SpecifiedTradeSettlementLineMonetarySummation>
                    <ram:LineTotalAmount>26.07</ram:LineTotalAmount>
                </ram:SpecifiedTradeSettlementLineMonetarySummation>
            </ram:SpecifiedLineTradeSettlement>
        </ram:IncludedSupplyChainTradeLineItem>


	 */
	public SupplyChainTradeLineItemType makeInvoiceLine(String identifier, Quantity quantity, Amount lineNetAmount, UnitPriceAmount priceAmt
			, String itemName, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		SupplyChainTradeLineItemType invoiceLine = new SupplyChainTradeLineItemType(); 
		
//		invoiceLine.getIncludedSubordinateTradeLineItem() // List
//		invoiceLine.setSpecifiedLineTradeSettlement(value);
		
		DocumentLineDocumentType documentLineDocument = new DocumentLineDocumentType();
		IDType lineID = new IDType();
		lineID.setValue(identifier);
		documentLineDocument.setLineID(lineID);
		
		// TODO optional noteText
		NoteType note = new NoteType();
		CodeType code = new CodeType();
		code.setValue("TODO optional noteText");
		note.setContentCode(code);
		documentLineDocument.getIncludedNote().add(note);
		
		invoiceLine.setAssociatedDocumentLineDocument(documentLineDocument);
		
//		CodeType code = new CodeType();
//		invoiceLine.setDescriptionCode(code);
		
		// quantity:
		LineTradeDeliveryType lineTradeDelivery = new LineTradeDeliveryType(); // Lieferschein
		QuantityType billedQty = new QuantityType();
		billedQty.setUnitCode(quantity.getUnitCode());
		billedQty.setValue(quantity.getValue());
		lineTradeDelivery.setBilledQuantity(billedQty);
		invoiceLine.setSpecifiedLineTradeDelivery(lineTradeDelivery);
		
		// priceAmt:
		LineTradeAgreementType lineTradeAgreement = new LineTradeAgreementType(); // Auftrag
		TradePriceType tradePrice = new TradePriceType();
		AmountType amount = new AmountType();
//		amount.setCurrencyID(priceAmt.getCurrencyID());
//		amount.setValue(priceAmt.getValue());
		priceAmt.copyTo(amount);
		List<AmountType> amounts = tradePrice.getChargeAmount();
		amounts.add(amount);
		lineTradeAgreement.setNetPriceProductTradePrice(tradePrice);
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		IDType orderlineID = new IDType();
		orderlineID.setValue("TODO orderlineID"); // TODO
		referencedDocument.setLineID(orderlineID);
		lineTradeAgreement.setBuyerOrderReferencedDocument(referencedDocument); 
		invoiceLine.setSpecifiedLineTradeAgreement(lineTradeAgreement); 
		
		LineTradeSettlementType lineTradeSettlement = new LineTradeSettlementType();
/*
val-sch.1.1 	BR-24 	error 	[BR-24]-Each Invoice line (BG-25) shall have an Invoice line net amount (BT-131).
Pfad: /rsm:CrossIndustryInvoice/rsm:SupplyChainTradeTransaction[1]/ram:IncludedSupplyChainTradeLineItem[1]

val-sch.1.8 	CII-SR-206 	warning 	[CII-SR-206] - NetLineTotalAmount should not be present
Pfad: /rsm:CrossIndustryInvoice/rsm:SupplyChainTradeTransaction[1]/ram:IncludedSupplyChainTradeLineItem[1]/ram:SpecifiedLineTradeSettlement[1]

 */
		TradeSettlementLineMonetarySummationType tradeSettlementLineMonetarySummation = new TradeSettlementLineMonetarySummationType();
		AmountType netLineTotalAmount = new AmountType();
		lineNetAmount.copyTo(netLineTotalAmount);
//		tradeSettlementLineMonetarySummation.getNetLineTotalAmount().add(netLineTotalAmount);
		lineTradeSettlement.setSpecifiedTradeSettlementLineMonetarySummation(tradeSettlementLineMonetarySummation);
		
//		lineTradeSettlement.setBillingSpecifiedPeriod(value); // optional TODO
		
		TradeTaxType tradeTax = makeTradeTaxType(taxCategoryCode, taxRate);
		lineTradeSettlement.getApplicableTradeTax().add(tradeTax);
		invoiceLine.setSpecifiedLineTradeSettlement(lineTradeSettlement);
		
		TradeProductType tradeProduct = new TradeProductType();
		TextType item = new TextType();
		item.setValue(itemName);
		tradeProduct.getName().add(item);
		
//		tradeProduct.setSellerAssignedID(value); // TODO optional Product value
//		tradeProduct.setDescription(value);
//		tradeProduct.getDesignatedProductClassification() // List
		
		invoiceLine.setSpecifiedTradeProduct(tradeProduct);             //Produkt  - ITEM INFORMATION
		
		return invoiceLine;
	}
	
	private TradeTaxType makeTradeTaxType(TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		TradeTaxType tradeTax = new TradeTaxType();
		
		// USt/VAT
		TaxTypeCodeType vat = new TaxTypeCodeType();
		vat.setValue("VAT"); // TODO
		tradeTax.setTypeCode(vat);
		// taxCategory:
		TaxCategoryCodeType taxCategory = new TaxCategoryCodeType();
		taxCategory.setValue(taxCategoryCode.getValue());
		tradeTax.setCategoryCode(taxCategory);
		// taxRate:
		PercentType percent = new PercentType();
		percent.setValue(taxRate);
		tradeTax.setRateApplicablePercent(percent);
		
		return tradeTax;
	}
	
	private TradeSettlementHeaderMonetarySummationType getTradeSettlementHeaderMonetarySummation(HeaderTradeSettlementType applicableHeaderTradeSettlement) {
		TradeSettlementHeaderMonetarySummationType tradeSettlementHeaderMonetarySummationType = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation();
		if(tradeSettlementHeaderMonetarySummationType==null) {
			tradeSettlementHeaderMonetarySummationType = new TradeSettlementHeaderMonetarySummationType();
			LOG.info("new TradeSettlementHeaderMonetarySummationType:"+tradeSettlementHeaderMonetarySummationType);
		}
		return tradeSettlementHeaderMonetarySummationType;
	}

	private HeaderTradeSettlementType getApplicableHeaderTradeSettlement() {
		return getApplicableHeaderTradeSettlement(this.getSupplyChainTradeTransaction());
	}
	private HeaderTradeSettlementType getApplicableHeaderTradeSettlement(SupplyChainTradeTransactionType supplyChainTradeTransaction) {
		HeaderTradeSettlementType headerTradeSettlement = supplyChainTradeTransaction.getApplicableHeaderTradeSettlement();
		if(headerTradeSettlement==null) {
			headerTradeSettlement = new HeaderTradeSettlementType();
			LOG.info("new HeaderTradeSettlementType:"+headerTradeSettlement);
		}
		return headerTradeSettlement;
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

}
