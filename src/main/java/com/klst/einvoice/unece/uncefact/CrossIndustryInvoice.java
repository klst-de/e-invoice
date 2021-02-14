package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BG13_DeliveryInformation;
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
import com.klst.einvoice.PrecedingInvoice;
import com.klst.einvoice.Reference;
import com.klst.einvoice.VatBreakdown;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.ReferenceCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.DocumentContextParameterType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ExchangedDocumentContextType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ExchangedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeAgreementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeDeliveryType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ProcuringProjectType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SpecifiedPeriodType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeLineItemType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeTransactionType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAccountingAccountType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.BinaryObjectType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

// @see https://www.unece.org/fileadmin/DAM/cefact/rsm/RSM_CrossIndustryInvoice_v2.0.pdf
//      https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=2ahUKEwijlav-gPjhAhUGU1AKHSv2CIoQFjAAegQIARAC&url=https%3A%2F%2Fwww.unece.org%2Ffileadmin%2FDAM%2Fcefact%2Frsm%2FRSM_CrossIndustryInvoice_v2.0.pdf&usg=AOvVaw0yPVFpbRqJ50xaDMUaYm62
// ZUGFeRD 2.0 Spezifikation - Technischer Anhang : ZUGFeRD-2.0-Spezifikation-TA.pdf
public class CrossIndustryInvoice extends CrossIndustryInvoiceType implements CoreInvoice {

	private static final Logger LOG = Logger.getLogger(CrossIndustryInvoice.class.getName());
	
	// factory
	public static CoreInvoice getFactory() {
		return new CrossIndustryInvoice(null);
	}
	// copy factory
	public static CrossIndustryInvoice create(CrossIndustryInvoiceType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof CrossIndustryInvoiceType && object.getClass()!=CrossIndustryInvoiceType.class) {
			// object is instance of a subclass of CrossIndustryInvoiceType, but not CrossIndustryInvoiceType itself
			return (CrossIndustryInvoice)object;
		} else {
			return new CrossIndustryInvoice(object); 
		}
	}
	@Override
	public CoreInvoice createInvoice(String profile, String processType, DocumentNameCode code) {
		return new CrossIndustryInvoice(profile, processType, code);
	}
	@Override
	public CoreInvoiceLine createInvoiceLine(String id, Quantity quantity, Amount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent) {
		return TradeLineItem.createInvoiceLine(id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent);
	}

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

--------------------------------------------------------------------------------------
UN/CEFACT is the United Nations Centre for Trade Facilitation and Electronic Business.
It was established by the United Nations Economic Commission for Europe (UNECE).

UN/CEFACT hat folgende Modelle veröffentlicht:
- BSP: BUY-SHIP-PAY domain model (contextualization of business artefacts and structures)
-- subset of BSP: 
-- Supply Chain REFERENCE DATA MODEL (SCRDM), 
     darin die "derived businesss messages" Cross Industry Invoice (CII) und Cross Industry Order (CIO)
-- Multi Modal Transport Semantic model (MMT RDM)

Die Modelle bilden die Core Component Library (CCL). 
Übersicht in Anticipating and Following Technological Trends in eBusiness Data Exchanges
Moscow,  7/8 December 2017 International Conference on Single Window
und in https://unece.org/fileadmin/DAM/cefact/cf_forums/2018_China/ISCO_Domain.pdf

weitere Kürzel:
CCBDA : Core Component Business Document Assembly Technical Specification - beschreibt 
das Vorgehen beim Erstellen von Modellen. Auch Begriffe werden dort eingeführt und erläutert.
BSP soll von "document centric" zu "process driven artefacts" führen (contextualized business artefacts).

ABIE -Aggregate Business Information Entities
ACC - Aggregate Core Component 
qDT – Qualified DataType

Supply Chain (SCRDM) subset of BuyShipPay (BSP) Master CCBDA Message Structure
Core  Component Business Document Assembly Technical Specification (CCBDA).
	
CEFACT/DEC/2018: Supply Chain REFERENCE DATA MODEL (SCRDM) 
Aufbau der SCRDM-Nachrichten, also CII und CIO:

 - rsm:ExchangedDocumentContext
 - rsm:ExchangedDocument
 - rsm:SupplyChainTradeTransaction , darin
 -- ( Referenced Document )       nicht in CII V100 : vll.: ram:AdditionalReferencedDocument
 -- ram:IncludedSupplyChainTradeLineItem
 -- ( Logistics Package )
 -- ( Associated Document Line )
 -- ( Product Group )
 -- ram:ApplicableHeaderTradeAgreement
 -- ram:ApplicableHeaderTradeDelivery
 -- ram:ApplicableHeaderTradeSettlement

PS: CII hat den Status "Published" und zwar am 10 October 2016, Version 100.D16B die wir verwende
    CIO basiert auf eine neuere Version von SCRDM 103
    
 */
	
	ApplicableHeaderTradeSettlement applicableHeaderTradeSettlement;
	HeaderTradeDeliveryType applicableHeaderTradeDelivery;
//	ExchangedDocumentType exchangedDocument; // in super
	
	private CrossIndustryInvoice(CrossIndustryInvoiceType doc) {
		super();
		if(doc!=null) {
			CopyCtor.invokeCopy(this, doc);
			LOG.config("copy ctor:"+this);
		}
		if(super.getSupplyChainTradeTransaction()==null) {
			applicableHeaderTradeSettlement = ApplicableHeaderTradeSettlement.create();
			applicableHeaderTradeDelivery = ApplicableHeaderTradeDelivery.create();
			super.setSupplyChainTradeTransaction(new SupplyChainTradeTransactionType());
		} else {
			applicableHeaderTradeSettlement = ApplicableHeaderTradeSettlement.create(getSupplyChainTradeTransaction().getApplicableHeaderTradeSettlement());
			applicableHeaderTradeDelivery = ApplicableHeaderTradeDelivery.create(getSupplyChainTradeTransaction().getApplicableHeaderTradeDelivery());
		}
		getSupplyChainTradeTransaction().setApplicableHeaderTradeSettlement(applicableHeaderTradeSettlement);
		getSupplyChainTradeTransaction().setApplicableHeaderTradeDelivery(applicableHeaderTradeDelivery);
	}

	public CrossIndustryInvoice(String customization, DocumentNameCode documentNameCode) {
		this(customization, null, documentNameCode);
	}
	
	public CrossIndustryInvoice(String customization, String processType, DocumentNameCode documentNameCode) {
		this(null);
		setProcessControl(customization, processType);
		
		exchangedDocument = new ExchangedDocumentType();
		DocumentCodeType documentCode = new DocumentCodeType();
		documentCode.setValue(documentNameCode.getValueAsString());
		exchangedDocument.setTypeCode(documentCode);
		super.setExchangedDocument(exchangedDocument);
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
		exchangedDocument.setID(new ID(id)); // No identification scheme is to be used.
	}
	
	@Override
	public String getId() {
		return super.getExchangedDocument().getID().getValue();
	}

	/* Invoice issue date                          BT-2  Date                  1 (mandatory) 
	 * Das Datum, an dem die Rechnung ausgestellt wurde.
	 */
	@Override
	public void setIssueDate(Timestamp ts) {
		DateTimeType dateTime = DateTimeFormatStrings.toDateTime(ts);
		this.getExchangedDocument().setIssueDateTime(dateTime);
	}

	@Override
	public Timestamp getIssueDateAsTimestamp() {
		DateTimeType dateTime = super.getExchangedDocument().getIssueDateTime();
		return DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());
	}

	@Override
	public void setTypeCode(DocumentNameCode code) {
		DocumentCodeType documentCode = new DocumentCodeType();
		documentCode.setValue(code.getValueAsString());
		exchangedDocument.setTypeCode(documentCode);
	}

	@Override
	public DocumentNameCode getTypeCode() {
		return DocumentNameCode.valueOf(super.getExchangedDocument().getTypeCode());
	}

	// 1 .. 1 InvoiceCurrencyCode Code für die Rechnungswährung BT-5
	@Override
	public void setDocumentCurrency(String isoCurrencyCode) {
		applicableHeaderTradeSettlement.setDocumentCurrency(isoCurrencyCode);
	}

	@Override
	public String getDocumentCurrency() {
		return applicableHeaderTradeSettlement.getDocumentCurrency();
	}

	// 0..1 (optional) BT-6
	@Override
	public void setTaxCurrency(String isoCurrencyCode) {
		applicableHeaderTradeSettlement.setTaxCurrency(isoCurrencyCode);
	}

	@Override
	public String getTaxCurrency() {
		return applicableHeaderTradeSettlement.getTaxCurrency();
	}

	/*
1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. n ApplicableTradeTax Umsatzsteueraufschlüsselung          BG-23

0 .. 1 TaxPointDate Datum der Steuerfälligkeit xs:choice 
1 .. 1 DateString Datum der Steuerfälligkeit, Wert             BT-7 
required format Datum, Format                                  BT-7-0
0 .. 1 DueDateTypeCode Code für das Datum der Steuerfälligkeit BT-8

Anwendung: In Deutschland wird dieses nicht verwendet. 
Statt dessen ist das Liefer- und Leistungsdatum anzugeben.
	 */
	// 0..1 (optional) BT-7 BT-7-0
	@Override
	public void setTaxPointDate(Timestamp ts) {
		if(ts==null) return;
		List<VatBreakdown> vbs = this.getVATBreakDowns();
		if(vbs.isEmpty()) {
			applicableHeaderTradeSettlement.setTaxPointDate(ts);
		} else {
			vbs.forEach(vb -> {
				TradeTax tradeTax = (TradeTax)vb;
				tradeTax.setTaxPointDate(ts);
			});
		}
	}

	@Override
	public Timestamp getTaxPointDateAsTimestamp() {
		return applicableHeaderTradeSettlement.getTaxPointDateAsTimestamp();
	}
	
	// BT-8 + 0..1 Value added tax point date code
	@Override
	public void setTaxPointDateCode(String code) {
		if(code==null) return;
		List<VatBreakdown> vbs = this.getVATBreakDowns();
		if(vbs.isEmpty()) {
			applicableHeaderTradeSettlement.setTaxPointDateCode(code);
		} else {
			vbs.forEach(vb -> {
				TradeTax tradeTax = (TradeTax)vb;
				tradeTax.setTaxPointDateCode(code);
			});
		}
	}

	@Override
	public String getTaxPointDateCode() {
		return applicableHeaderTradeSettlement.getTaxPointDateCode();
	}

	// BT-9 0..1 DueDateDateTime Fälligkeitsdatum
	@Override
	public void setDueDate(Timestamp ts) {
		setPaymentTermsAndDate(null, ts);
	}

	@Override
	public Timestamp getDueDateAsTimestamp() {
		return applicableHeaderTradeSettlement.getTradePaymentTerms()==null ? null : applicableHeaderTradeSettlement.getTradePaymentTerms().getDueDateAsTimestamp();
	}

	// BT-9 0..1 & BT-20 0..1 : Payment terms & Payment due date
	@Override
	public void setPaymentTermsAndDate(String description, Timestamp ts) {
		applicableHeaderTradeSettlement.setPaymentTermsAndDate(description, ts);
	}
	
	@Override
	public String getPaymentTerm() {
		return applicableHeaderTradeSettlement.getTradePaymentTerms()==null ? null : applicableHeaderTradeSettlement.getTradePaymentTerms().getPaymentTerm();
	}

	/* EN16931-ID: 	BT-10 (optional), but mandatory in CIUS rule BR-DE-15
	 * (non-Javadoc)
	 * @see com.klst.cius.CoreInvoice#setBuyerReference(java.lang.String)
	 */
	@Override
	public void setBuyerReference(String reference) {
		if(reference==null) return;
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setBuyerReference(new Text(reference));
		// TODO hier Leitweg-ID
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	@Override
	public String getBuyerReferenceValue() {
		HeaderTradeAgreementType headerTradeAgreement = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		TextType text = headerTradeAgreement.getBuyerReference();
		return text==null ? null : text.getValue();
	}
	
	// BT-11 + 0..1 Project reference
	@Override
	public void setProjectReference(Reference ref) {
		if(ref==null) return; // optional
		setProjectReference(ref.getID(), ref.getName());
	}
	@Override
	public void setProjectReference(String docRefId) {
		setProjectReference(docRefId, null);
	}
	@Override
	public void setProjectReference(String docRefId, String name) {
		if(docRefId==null) return; // optional
		ProcuringProjectType procuringProject = new ProcuringProjectType();
		procuringProject.setID(new ID(docRefId));
		procuringProject.setName(new Text(name));
		
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setSpecifiedProcuringProject(procuringProject);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	@Override
	public Reference getProjectReference() {
		HeaderTradeAgreementType headerTradeAgreement = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		ProcuringProjectType referencedDocument = headerTradeAgreement.getSpecifiedProcuringProject();
		if(referencedDocument==null) return null;
		return new ID(referencedDocument.getName()==null ? "" : referencedDocument.getName().getValue()
				, referencedDocument.getID()==null ? null : referencedDocument.getID().getValue());	
	}

	// BT-12 + 0..1 Contract reference
/*
test daten in 03 06 08 15
CII: 01.03a-INVOICE_uncefact.xml :
        <ram:ApplicableHeaderTradeAgreement>
        ...
            <ram:ContractReferencedDocument>
                <ram:IssuerAssignedID>CR987654</ram:IssuerAssignedID>
            </ram:ContractReferencedDocument>UBL:
UBL: 
    <cac:ContractDocumentReference>
        <cbc:ID>CR987654</cbc:ID>
    </cac:ContractDocumentReference>
 */
	@Override
	public void setContractReference(String id) {
		if(id==null) return; // optional
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		referencedDocument.setIssuerAssignedID(new ID(id)); // No identification scheme
		headerTradeAgreement.setContractReferencedDocument(referencedDocument);
	}

	@Override
	public String getContractReference() {
		HeaderTradeAgreementType headerTradeAgreement = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		ReferencedDocumentType referencedDocument = headerTradeAgreement.getContractReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getIssuerAssignedID().getValue();
	}

	// BT-13 + 0..1 Purchase order reference
	@Override
	public void setPurchaseOrderReference(String docRefId) {
		if(docRefId==null) return; // optional
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		referencedDocument.setIssuerAssignedID(new ID(docRefId)); // No identification scheme
		
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setBuyerOrderReferencedDocument(referencedDocument);

		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	@Override
	public String getPurchaseOrderReference() {
		HeaderTradeAgreementType headerTradeAgreement = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		ReferencedDocumentType referencedDocument = headerTradeAgreement.getBuyerOrderReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getIssuerAssignedID().getValue();	
	}

	// BT-14 + 0..1 Sales order reference
	@Override
	public void setOrderReference(String docRefId) {
		if(docRefId==null) return; // optional
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		referencedDocument.setIssuerAssignedID(new ID(docRefId)); // No identification scheme
		
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setSellerOrderReferencedDocument(referencedDocument);

		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}
	@Override
	public String getOrderReference() {
		HeaderTradeAgreementType headerTradeAgreement = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		ReferencedDocumentType referencedDocument = headerTradeAgreement.getSellerOrderReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getIssuerAssignedID().getValue();	
	}
	
	// BT-15 + 0..1 Receiving advice reference / Referenz auf die Wareneingangsmeldung
	@Override
	public void setReceiptReference(String docRefId) {
		if(docRefId==null) return; // optional
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		referencedDocument.setIssuerAssignedID(new ID(docRefId)); // No identification scheme
		
		applicableHeaderTradeDelivery.setReceivingAdviceReferencedDocument(referencedDocument);
	}
	@Override
	public String getReceiptReference() {
		HeaderTradeDeliveryType headerTradeDelivery = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeDelivery();
		ReferencedDocumentType referencedDocument = headerTradeDelivery.getReceivingAdviceReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getIssuerAssignedID().getValue();	
	}

	// BT-16 + 0..1 Despatch advice reference / Lieferavisreferenz
	@Override
	public void setDespatchAdviceReference(String docRefId) {
		if(docRefId==null) return; // optional
		ReferencedDocumentType referencedDocument = new ReferencedDocumentType();
		referencedDocument.setIssuerAssignedID(new ID(docRefId)); // No identification scheme
		
		applicableHeaderTradeDelivery.setDespatchAdviceReferencedDocument(referencedDocument);
	}
	@Override
	public String getDespatchAdviceReference() {
		HeaderTradeDeliveryType headerTradeDelivery = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeDelivery();
		ReferencedDocumentType referencedDocument = headerTradeDelivery.getDespatchAdviceReferencedDocument();
		return referencedDocument==null ? null : referencedDocument.getIssuerAssignedID().getValue();	
	}

	// BT-17 Tender or lot reference
	@Override
	public void setTenderOrLotReference(String docRefId) {
		if(docRefId==null) return; // optional
		ReferencedDocument referencedDocument = new ReferencedDocument(docRefId, ReferencedDocument.ValidatedPricedTender);
		addSupportigDocument(referencedDocument);
	}
	@Override
	public String getTenderOrLotReference() {
		List<ReferencedDocument> referencedDocuments = getReferencedDocuments(this);
		if(referencedDocuments.isEmpty()) return null;
		String result = null;
		for(int i=0; i<referencedDocuments.size(); i++) {
			ReferencedDocument refDoc = referencedDocuments.get(i);
			if(refDoc.isValidatedPricedTender()) {
				result = refDoc.getIssuerAssignedID().getValue();
			}
		}
		return result;
	}

	// BT-18 Invoiced object identifier
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
	public void setInvoicedObject(String name, String code) {
		if(name==null) return; // optional
		ReferencedDocument referencedDocument = new ReferencedDocument(name, ReferencedDocument.InvoicingDataSheet, code);
		addSupportigDocument(referencedDocument);
	}
	@Override
	public Identifier getInvoicedObjectIdentifier() {
		List<ReferencedDocument> referencedDocuments = getReferencedDocuments(this);
		if(referencedDocuments.isEmpty()) return null;
		Identifier result = null;
		for(int i=0; i<referencedDocuments.size(); i++) {
			ReferencedDocument refDoc = referencedDocuments.get(i);
			if(refDoc.isInvoicingDataSheet()) {
				// IssuerAssignedID
				// TypeCode 130
				// 0..1 ReferenceTypeCode
				ReferenceCodeType referenceCode = refDoc.getReferenceTypeCode();
				result = new ID(refDoc.getIssuerAssignedID().getValue(), referenceCode==null? null : referenceCode.getValue());
			}
		}
		return result;
	}
	@Override
	public String getInvoicedObject() {
		Identifier id = getInvoicedObjectIdentifier();
		return id==null? null : id.getContent();
	}
	
	// BT-19 + 0..1 Buyer accounting reference       --- keine Testdaten
	// ApplicableHeaderTradeSettlement
	//   - ReceivableSpecifiedTradeAccountingAccount
	//      1 .. 1 ID Buchungsreferenz des Käufers BT-19
	public void setBuyerAccountingReference(Reference reference) {
		if(reference==null) return;
		TradeAccountingAccountType tradeAccountingAccount = new TradeAccountingAccountType();
		tradeAccountingAccount.setID((ID)reference);
		// List<TradeAccountingAccountType> nur ein Element nutzen
		applicableHeaderTradeSettlement.getReceivableSpecifiedTradeAccountingAccount().add(tradeAccountingAccount);
	}
	public Reference getBuyerAccountingReference() {
		List<TradeAccountingAccountType> list = applicableHeaderTradeSettlement.getReceivableSpecifiedTradeAccountingAccount();
		if(list.isEmpty()) return null;
		return new ID(list.get(0).getID());
	}

	/* INVOICE NOTE                                BG-1                        0..*
	 * Eine Gruppe von Informationselementen für rechnungsrelevante Erläuterungen mit Hinweisen auf den Rechnungsbetreff.
	 * 
	 */
	@Override
	public InvoiceNote createNote(String subjectCode, String content) {
		// delegieren:
		return Note.create(subjectCode, content);
	}
	
	@Override
	public void addNote(InvoiceNote note) {
		this.exchangedDocument.getIncludedNote().add((NoteType)note);
	}

	@Override
	public List<InvoiceNote> getInvoiceNotes() {
		// delegieren:
		return Note.getInvoiceNotes(this.exchangedDocument);
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
	 * @param BG-2.BT-24 customization, mandatory
	 * @param BG-2.BT-23 processType (optional)
	 */
	void setProcessControl(String customization, String processType) {
		ExchangedDocumentContextType exchangedDocumentContext = new ExchangedDocumentContextType();
		DocumentContextParameterType documentContextParameter = new DocumentContextParameterType();
		documentContextParameter.setID(new ID(customization)); // No identification scheme

		exchangedDocumentContext.getGuidelineSpecifiedDocumentContextParameter().add(documentContextParameter);
		if(processType!=null) {
			DocumentContextParameterType dcp = new DocumentContextParameterType();
			dcp.setID(new ID(processType)); // No identification scheme
			exchangedDocumentContext.getBusinessProcessSpecifiedDocumentContextParameter().add(dcp);
		}
		this.setExchangedDocumentContext(exchangedDocumentContext);
	}

	// BG-2.BT-23 ++ 0..1 Business process type
	@Override
	public String getProcessType() {
		List<DocumentContextParameterType> documentContextParameterList = super.getExchangedDocumentContext().getBusinessProcessSpecifiedDocumentContextParameter();
		List<String> res = new ArrayList<String>(documentContextParameterList.size());
		documentContextParameterList.forEach(documentContextParameter -> {
			res.add(documentContextParameter.getID().getValue());
		});
		return res.isEmpty() ? null : res.get(0);
	}

	// BG-2.BT-24 ++ 1..1 Specification identifier
	@Override
	public String getCustomization() {
		List<DocumentContextParameterType> documentContextParameterList = super.getExchangedDocumentContext().getGuidelineSpecifiedDocumentContextParameter();
		List<String> res = new ArrayList<String>(documentContextParameterList.size());
		documentContextParameterList.forEach(documentContextParameter -> {
			res.add(documentContextParameter.getID().getValue());
		});
		return res.isEmpty() ? null : res.get(0);
	}
	
	/* PRECEDING INVOICE REFERENCE                 BG-3                        0..* (optional)
	 * Eine Gruppe von Informationselementen, die Informationen über eine vorausgegangene Rechnung liefern, 
	 * die berichtigt oder gutgeschrieben werden soll.
	 */
	
	// BG-3 + 0..n PRECEDING INVOICE REFERENCE / implements BG3_PrecedingInvoiceReference factory
	@Override
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		return ReferencedDocument.createPrecedingInvoiceReference(docRefId, ts);
	}
	@Override // implements BG3_PrecedingInvoiceReference
	public void addPrecedingInvoice(PrecedingInvoice precedingInvoice) {
		if(getPrecedingInvoices().isEmpty()) {
			applicableHeaderTradeSettlement.setInvoiceReferencedDocument((ReferencedDocument)precedingInvoice);
		} else {
			LOG.warning("You try to add a second Preceding Invoice. In CII there is only one BG-3.");
		}
	}
	@Override // implements BG3_PrecedingInvoiceReference
	public List<PrecedingInvoice> getPrecedingInvoices() {
		ReferencedDocumentType referencedDocument = applicableHeaderTradeSettlement.getInvoiceReferencedDocument();
		List<PrecedingInvoice> docRefList = new ArrayList<PrecedingInvoice>();
		if(referencedDocument!=null) {
			docRefList.add(new ReferencedDocument(referencedDocument.getIssuerAssignedID(), referencedDocument.getFormattedIssueDateTime()));
		}
		return docRefList;
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
	public void setSeller(String name, PostalAddress address, IContact contact, String companyId, String companyLegalForm) {
		                               // BT-27 , BG-5   , BG-6          , BT-30    , BT-33
		BusinessParty party = createParty(name, address, contact); //, companyId, companyLegalForm);
		party.setCompanyId(companyId);
		party.setCompanyLegalForm(companyLegalForm);
		setSeller(party);
	}
	
	public void setSeller(BusinessParty party) {
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setSellerTradeParty((TradePartyType)party);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	public BG4_Seller getSeller() {
		HeaderTradeAgreementType headerTradeAgreement = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		TradePartyType sellerParty = headerTradeAgreement.getSellerTradeParty();
		return sellerParty==null ? null : new TradeParty(sellerParty);
	}

	/* BUYER                                       BG-7                        1 (mandatory) 
	 * Eine Gruppe von Informationselementen, die Informationen über den Erwerber liefern.
	 */
	public void setBuyer(String name, PostalAddress address, IContact contact) {
		BusinessParty party = createParty(name, address, contact); // BT-44, BG-8, BG-9
		setBuyer(party);
	}
	public void setBuyer(BusinessParty party) {
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setBuyerTradeParty((TradePartyType) party);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	public BG7_Buyer getBuyer() {
		HeaderTradeAgreementType headerTradeAgreement = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
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
		BusinessParty party = createParty(name, null, null, null);
		party.setId(id);
		party.setCompanyLegalForm(companyLegalForm);
		setPayee(party);
	}
	// BG-10 + 0..1 PAYEE
	public void setPayee(BusinessParty party) {
		LOG.info("setPayee BusinessParty party "+party);
		applicableHeaderTradeSettlement.setPayee(party);
	}

	public BusinessParty getPayee() {
		TradePartyType payeeParty = applicableHeaderTradeSettlement.getPayeeTradeParty();
		return payeeParty==null ? null : new TradeParty(payeeParty);
	}

	/* SELLER TAX REPRESENTATIVE PARTY             BG-11                       0..1
	 * Eine Gruppe von Informationselementen, die Informationen über den Steuervertreter des Verkäufers liefern.
	 */
	// BT-62 ++ 1..1 Seller tax representative name
	
	// BT-63 ++ 1..1 Seller tax representative VAT identifier
	public void setTaxRepresentative(String name, PostalAddress address, String taxRegistrationName, String taxRegistrationSchemaID) {
		BusinessParty party = createParty(name, address, null);
		party.addTaxRegistrationId(taxRegistrationName, taxRegistrationSchemaID);
		setTaxRepresentative(party);
	}
	public void setTaxRepresentative(BusinessParty party) {
		HeaderTradeAgreementType headerTradeAgreement = getApplicableHeaderTradeAgreement();
		headerTradeAgreement.setSellerTaxRepresentativeTradeParty((TradePartyType) party);
		
		SupplyChainTradeTransactionType supplyChainTradeTransaction = this.getSupplyChainTradeTransaction();
		supplyChainTradeTransaction.setApplicableHeaderTradeAgreement(headerTradeAgreement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);		
	}

	public BusinessParty getTaxRepresentative() {
		HeaderTradeAgreementType headerTradeAgreement = super.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
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
	@Override
	public void setDelivery(String name, Timestamp ts, PostalAddress address, String locationId, String schemeId) {
		applicableHeaderTradeDelivery = ApplicableHeaderTradeDelivery.create(name, ts, address, locationId, schemeId);
		supplyChainTradeTransaction.setApplicableHeaderTradeDelivery(applicableHeaderTradeDelivery);
	}
	
	@Override
	public void setDelivery(BG13_DeliveryInformation delivery) {
		supplyChainTradeTransaction.setApplicableHeaderTradeDelivery((HeaderTradeDeliveryType) delivery);
	}
	
	@Override
	public BG13_DeliveryInformation getDelivery() {
		HeaderTradeDeliveryType headerTradeDelivery = supplyChainTradeTransaction.getApplicableHeaderTradeDelivery();
		if(headerTradeDelivery==null) return null;
		return ApplicableHeaderTradeDelivery.create(headerTradeDelivery);
	}

	// BG-14.BT-73 +++ 0..1 Invoicing period start date
	@Override
	public void setStartDate(Timestamp ts) {
		if(ts==null) return;
		DateTimeType dateTime = DateTimeFormatStrings.toDateTime(ts);
		applicableHeaderTradeSettlement.getBillingSpecifiedPeriod().setStartDateTime(dateTime);
	}

	@Override
	public Timestamp getStartDateAsTimestamp() {
		SpecifiedPeriodType specifiedPeriod = applicableHeaderTradeSettlement.getBillingSpecifiedPeriod();
		if(specifiedPeriod==null) return null;
		DateTimeType dateTime = specifiedPeriod.getStartDateTime();
		return dateTime==null ? null : DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());		
	}
	
	// BG-14.BT-74 +++ 0..1 Invoicing period end date
	@Override
	public void setEndDate(Timestamp ts) {
		if(ts==null) return;
		DateTimeType dateTime = DateTimeFormatStrings.toDateTime(ts);
		applicableHeaderTradeSettlement.getBillingSpecifiedPeriod().setEndDateTime(dateTime);
	}

	@Override
	public Timestamp getEndDateAsTimestamp() {
		SpecifiedPeriodType specifiedPeriod = applicableHeaderTradeSettlement.getBillingSpecifiedPeriod();
		if(specifiedPeriod==null) return null;
		DateTimeType dateTime = specifiedPeriod.getEndDateTime();
		return dateTime==null ? null : DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());
	}

/*

EN16931 sagt: BG-16 0..1 PAYMENT INSTRUCTIONS
	die Kardinalität ist 0..1, wg. BR-DE-1 (1..1 this cius rule makes it mandatory)
	ich implemetierte setXXX so, dass PaymentInstructions null sein darf

 */
	// factory delegate to ApplicableHeaderTradeSettlement
	@Override
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		
		return applicableHeaderTradeSettlement.createPaymentInstructions(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}

	@Override
	public void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		setPaymentInstructions(applicableHeaderTradeSettlement.createPaymentInstructions(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit));
	}

	public void setPaymentInstructions(PaymentInstructions paymentInstructions) {
		// so geht es nicht: applicableHeaderTradeSettlement = (ApplicableHeaderTradeSettlement)paymentInstructions;
		// denn es gibt ein sequenzproblem: ApplicableHeaderTradeSettlement implementiert nicht nur PaymentInstructions
		// sondern auch // BG-10 + 0..1 PAYEE : PayeeTradeParty und andere elemente,
		// die man mit dem assign von paymentInstructions überschreiben würde
		// ===> also: nur die paymentInstructions elemente kopieren:
		applicableHeaderTradeSettlement.init(paymentInstructions.getPaymentMeansEnum()
				, paymentInstructions.getPaymentMeansText(), paymentInstructions.getRemittanceInformation()
				, paymentInstructions.getCreditTransfer()
				, paymentInstructions.getPaymentCard()
				, paymentInstructions.getDirectDebit());
	}
	public PaymentInstructions getPaymentInstructions() {
		return applicableHeaderTradeSettlement; // das implementiert PaymentInstructions!
	}

	// implements interface CreditTransferFactory for BG-17 , delegator:
	@Override
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		return applicableHeaderTradeSettlement.createCreditTransfer(iban, accountName, bic);
	}
	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
		return applicableHeaderTradeSettlement.createCreditTransfer(accountId, accountName, bic);
	}
	@Override
	public CreditTransfer addCreditTransfer(IBANId iban, String accountName, BICId bic) {
		return applicableHeaderTradeSettlement.createCreditTransfer(iban, accountName, bic);
	}
	@Override
	public CreditTransfer addCreditTransfer(String accountId, String accountName, BICId bic) {
		return applicableHeaderTradeSettlement.createCreditTransfer(accountId, accountName, bic);
	}

	@Override // implements interface PaymentCardFactory for BG-18
	public PaymentCard createPaymentCard(String cardAccountID, String cardHolderName) {
		return TradeSettlementFinancialCard.create(cardAccountID, cardHolderName);
	}

	@Override // implements interface DirectDebitFactory for BG-19
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, IBANId iban) {
		return applicableHeaderTradeSettlement.createDirectDebit(mandateID, bankAssignedCreditorID, iban);
	}

	@Override // implements interface DirectDebitFactory for BG-19
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, String debitedAccountID) {
		return applicableHeaderTradeSettlement.createDirectDebit(mandateID, bankAssignedCreditorID, debitedAccountID);
	}

	// BG-20 + BG-21- 0..n
	@Override
	public void addAllowanceCharge(AllowancesAndCharges allowanceOrCharge) {
		applicableHeaderTradeSettlement.addAllowanceCharge(allowanceOrCharge);
	}
	@Override
	public List<AllowancesAndCharges> getAllowancesAndCharges() {
		return applicableHeaderTradeSettlement.getAllowancesAndCharges();
	}

	// BG-22.BT-106 - 1..1/1..1
	@Override
	public Amount getInvoiceLineNetTotal() {
		return applicableHeaderTradeSettlement.getInvoiceLineNetTotal();
	}
	// BG-22.BT-109 - 1..1/1..1
	@Override
	public Amount getInvoiceTotalTaxExclusive() {
		return applicableHeaderTradeSettlement.getInvoiceTotalTaxExclusive();
	}
	// BG-22.BT-112 - 1..1/1..1
	@Override
	public Amount getInvoiceTotalTaxInclusive() {
		return applicableHeaderTradeSettlement.getInvoiceTotalTaxInclusive();
	}
	// BG-22.BT-113 - 1..1/0..1 (optional) The sum of amounts which have been paid in advance.
	// Summe bereits gezahlter Beträge.
	@Override
	public Amount getPrepaid() {
		return applicableHeaderTradeSettlement.getPrepaid();
	}
	// BG-22.BT-115 - 1..1/1..1
	@Override
	public Amount getDuePayable() { 
		return applicableHeaderTradeSettlement.getDuePayable();
	}
	
	// BG-22.BT-107
	@Override
	public Amount getAllowancesTotal() {
		return applicableHeaderTradeSettlement.getAllowancesTotal();
	}

	@Override
	public void setAllowancesTotal(Amount amount) {
		if(amount==null) return;
		applicableHeaderTradeSettlement.setAllowancesTotal(amount);
	}

	// BG-22.BT-108
	@Override
	public Amount getChargesTotal() {
		return applicableHeaderTradeSettlement.getChargesTotal();
	}

	@Override
	public void setChargesTotal(Amount amount) {
		if(amount==null) return;
		applicableHeaderTradeSettlement.setChargesTotal(amount);
	}

	/**
	 * setter optional total amounts of the invoice
	 * 
	 * BG-22.BT-113 0..1 (optional) The sum of amounts which have been paid in advance.
	 */
	// Summe bereits gezahlter Beträge.
	@Override
	public void setPrepaid(Amount amount) {
		if(amount==null) return;
		applicableHeaderTradeSettlement.setPrepaid(amount);
	}
	
	// BG-22.BT-114
	@Override
	public Amount getRounding() {
		return applicableHeaderTradeSettlement.getRounding();
	}
	@Override
	public void setRounding(Amount amount) {
		if(amount==null) return;
		applicableHeaderTradeSettlement.setRounding(amount);
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
		LOG.config("setDocumentTotals lineExtension:"+lineExtension + " taxExclusive:"+taxExclusive + " taxInclusive:"+taxInclusive + " payable:"+payable);
		applicableHeaderTradeSettlement.setDocumentTotals(lineExtension, taxExclusive, taxInclusive, payable);
		// zurückschreiben:
		supplyChainTradeTransaction.setApplicableHeaderTradeSettlement(applicableHeaderTradeSettlement);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);
	}

	private Amount getInvoiceTax(boolean sameCurrency) {
		if(applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation() == null) return null;
		List<AmountType> list = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxTotalAmount();
		if(list.isEmpty()) return null;
		LOG.fine("getInvoiceTax: TaxCurrency="+getTaxCurrency() + " DocumentCurrency="+getDocumentCurrency());
		for(int i=0; i<list.size(); i++) {
			if(sameCurrency && (this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
				return list.get(i).getCurrencyID()==null ? new Amount(list.get(i).getValue()) : new Amount(list.get(i).getCurrencyID(), list.get(i).getValue());
			} else if(!sameCurrency && !(this.getTaxCurrency()==null || this.getDocumentCurrency().equals(this.getTaxCurrency()))) {
				return new Amount(getTaxCurrency(), list.get(i).getValue());
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

	/**
	 * optional total VAT amount of the invoice
	 * 
	 * @param taxTotalAmount : Invoice total VAT amount
	 */
	// BG-22.BT-110 CoreInvoice extends BG22_DocumentTotals : sum of all VAT category tax amounts
	@Override
	public void setInvoiceTax(Amount taxTotalAmount) {
		applicableHeaderTradeSettlement.setInvoiceTax(taxTotalAmount);
	}
	
	@Override
	public void setInvoiceTaxInAccountingCurrency(Amount amount) {
		if(this.getDocumentCurrency().equals(this.getTaxCurrency())) {
			LOG.warning("Document currency is "+getDocumentCurrency() + " equals to Tax Currency!");
		}
		setInvoiceTax(amount);	
	}

	/*
	 * VAT BREAKDOWN

1 .. 1 SupplyChainTradeTransaction Gruppierung der Informationen zum Geschäftsvorfall
1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. n ApplicableTradeTax Umsatzsteueraufschlüsselung                                                 BG-23 xs:sequence 

	 */
	@Override
	public VatBreakdown createVATBreakDown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode codeEnum, BigDecimal taxRate) {
		return TradeTax.create(taxableAmount, taxAmount, codeEnum, taxRate);
	}
	
	/**
	 * Adds a mandatory (1..n) VAT BREAKDOWN (BG-23) group
	 * 
	 * @param vatBreakdown
	 */
	@Override
	public void addVATBreakDown(VatBreakdown vatBreakdown) {
		List<TradeTaxType> tradeTaxes = applicableHeaderTradeSettlement.getApplicableTradeTax();
		tradeTaxes.add((TradeTax)vatBreakdown);
	}
	public void addVATBreakDown(Amount taxableAmount, Amount tax, TaxCategoryCode taxCategoryCode, BigDecimal taxRate) {
		addVATBreakDown(createVATBreakDown(taxableAmount, tax, taxCategoryCode, taxRate));
	}
	@Override
	public List<VatBreakdown> getVATBreakDowns() {
		if(applicableHeaderTradeSettlement==null) return null;
		List<TradeTaxType> list = applicableHeaderTradeSettlement.getApplicableTradeTax();
		List<VatBreakdown> result = new ArrayList<VatBreakdown>(list.size());
		list.forEach(tradeTax -> {
			result.add(TradeTax.create(tradeTax));
		});
		return result;
	}
	
	// BG-24 + 0..n ADDITIONAL SUPPORTING DOCUMENTS
	// 0 .. n AdditionalReferencedDocument Rechnungsbegründende Unterlagen BG-24
	// BG-24.BT-122 ++ 1..1 Supporting document reference
	// BG-24.BT-123 ++ 0..1 Supporting document description
	// BG-24.BT-124 ++ 0..1 External document location
	// BG-24.BT-125 ++ 0..1 Attached document
//	An attached document embedded as binary object or sent together with the invoice.
//	Attached document is used when 	documentation shall be stored with the 	Invoice for future reference or audit 	purposes.
//	R35 Binary object
	//                 1..1 Attached document
	//                      Mime code / The mime code of the attached document.
	//                      Allowed mime codes:
	//	- application/pdf
	// 	- image/png
	// 	- image/jpeg
	// 	- text/csv
	// 	- application/vnd.openxmlformatsofficedocument.spreadsheetml.sheet
	// 	- application/vnd.oasis.opendocument.spreadsheet
	//                 1..1 Attached document Filename / The file name of the attached document
/* test daten

        <ram:ApplicableHeaderTradeAgreement>
        ...
            <ram:AdditionalReferencedDocument>
                <ram:IssuerAssignedID>01_15_Anhang_01.pdf</ram:IssuerAssignedID>
                <ram:TypeCode>916</ram:TypeCode>
                <ram:Name>Aufschlüsselung der einzelnen Leistungspositionen</ram:Name>
                <ram:AttachmentBinaryObject mimeCode="application/pdf" filename="01_15_Anhang_01.pdf">... binary data ...</ram:AttachmentBinaryObject>
            </ram:AdditionalReferencedDocument>

 */
	@Override
	public void addSupportigDocument(String docRefId, String description, byte[] content, String mimeCode, String filename) {
		ReferencedDocument referencedDocument = new ReferencedDocument(docRefId);
		referencedDocument.setSupportingDocumentDescription(description);
		referencedDocument.setAttachedDocument(content, mimeCode, filename);
		
		HeaderTradeAgreementType applicableHeaderTradeAgreement = getApplicableHeaderTradeAgreement();
		applicableHeaderTradeAgreement.getAdditionalReferencedDocument().add(referencedDocument);
	}

	/**
	 * add Additional Referenced Document 0..n(optional) BG-24
	 * 
	 * @param docRefId    BG-24.BT-122 ++ 1..1 Supporting document reference
	 * @param description BG-24.BT-123 ++ 0..1 Supporting document description
	 * @param uri         BG-24.BT-124 ++ 0..1 External document location uri
	 */
	@Override
	public void addSupportigDocument(String docRefId, String description, String uri) {
		ReferencedDocument referencedDocument = new ReferencedDocument(docRefId);
		referencedDocument.setSupportingDocumentDescription(description);
		referencedDocument.setExternalDocumentLocation(uri);
		
		HeaderTradeAgreementType applicableHeaderTradeAgreement = getApplicableHeaderTradeAgreement();
		applicableHeaderTradeAgreement.getAdditionalReferencedDocument().add(referencedDocument);
	}
	
	public void addSupportigDocument(ReferencedDocument doc) {
		HeaderTradeAgreementType applicableHeaderTradeAgreement = getApplicableHeaderTradeAgreement();
		applicableHeaderTradeAgreement.getAdditionalReferencedDocument().add(doc);
	}

	@Override
	public List<BG24_AdditionalSupportingDocs> getAdditionalSupportingDocuments() {
		List<ReferencedDocument> referencedDocuments = getReferencedDocuments(this);
		List<BG24_AdditionalSupportingDocs> result = new ArrayList<BG24_AdditionalSupportingDocs>();
//		if(referencedDocuments.isEmpty()) return result;
		referencedDocuments.forEach(refDoc -> {
			if(refDoc.isRelatedDocument()) {
				result.add(refDoc);
			}
		});
		return result;
	}
	// BT-17 BT-18 BG-24.BT-122
	// BT-17 BT-18 haben IssuerAssignedID und (optional) BT-17-0, BT-18-0 TypeCode , BT-18-1 ReferenceTypeCode
/*

TypeCode Typ des referenzierten Dokuments
. Datentyp: qdt:DocumentCodeType
Hinweis: 
Der Code 916 "Referenzpapier" wird benutzt, um die Kennung der rechnungsbegründenden Unterlage zu referenzieren. (BT-122)
Der Code  50 "Price/sales catalogue response" wird benutzt, um die Ausschreibung oder das Los zu referenzieren. (BT-17)
Der Code 130 "Rechnungsdatenblatt" wird benutzt, um eine vom Verkäufer angegebene Kennung für ein Objekt zu referenzieren. (BT-18)

Codeliste: UNTDID 1001 Untermenge
Code Codename
.  50 . Validated priced tender
. 130 . Invoicing data sheet / Rechnungsdatenblatt
. 916 . Related document / Referenzpapier

 */
	static List<ReferencedDocument> getReferencedDocuments(CrossIndustryInvoiceType doc) {
		HeaderTradeAgreementType headerTradeAgreement = doc.getSupplyChainTradeTransaction().getApplicableHeaderTradeAgreement();
		List<ReferencedDocumentType> referencedDocuments = headerTradeAgreement.getAdditionalReferencedDocument();
		List<ReferencedDocument> result = new ArrayList<ReferencedDocument>();
		if(referencedDocuments.isEmpty()) {
			return result;
		}
		referencedDocuments.forEach(refDoc -> {
			IDType issuerAssignedID = refDoc.getIssuerAssignedID();
			DocumentCodeType documentCode = refDoc.getTypeCode(); 
			// documentCode.getValue() == 916 ==> BT-122
			// sonst ist es BT-17 oder BT-18
			LOG.fine("referencedDocument DocumentCode="+documentCode.getValue()+" IssuerAssignedID="+issuerAssignedID.getValue());
			ReferencedDocument rd = new ReferencedDocument(issuerAssignedID.getValue(), documentCode.getValue());
			
			List<TextType> texts = refDoc.getName();
			texts.forEach(text -> {
				rd.getName().add(text);
			});
			
			List<BinaryObjectType> binaryObjects = refDoc.getAttachmentBinaryObject();
			binaryObjects.forEach(bo -> {
				BinaryObjectType bot = new BinaryObjectType();
				bot.setValue(bo.getValue());
				bot.setMimeCode(bo.getMimeCode());
				bot.setFilename(bo.getFilename());
				rd.getAttachmentBinaryObject().add(bot);
			});
			
			result.add(rd);
		});
		return result;
	}

	/* INVOICE LINE                                BG-25                       1..* (mandatory)
	 * Eine Gruppe von Informationselementen, die Informationen über einzelne Rechnungspositionen liefern.
	 * 
	 */
	
	/**
	 * Adds a mandatory invoice line element
	 * 
	 * @param line
	 */
	@Override
	public void addLine(CoreInvoiceLine line) {
		supplyChainTradeTransaction.getIncludedSupplyChainTradeLineItem().add((TradeLineItem)line);
	}
	
	public void addLine(SupplyChainTradeLineItemType line) {
		supplyChainTradeTransaction.getIncludedSupplyChainTradeLineItem().add(line);
		super.setSupplyChainTradeTransaction(supplyChainTradeTransaction);
	}

	public void addLines(CrossIndustryInvoiceType doc) {
		List<TradeLineItem> tradeLineItemList = getLines(doc);
		tradeLineItemList.forEach(line -> {
			CoreInvoiceLine invoiceLine = TradeLineItem.create(line); // TradeLineItem implements CoreInvoiceLine
			addLine(invoiceLine);
		});
	}

	public List<CoreInvoiceLine> getLines() {
		List<SupplyChainTradeLineItemType> lines = supplyChainTradeTransaction.getIncludedSupplyChainTradeLineItem();
		List<CoreInvoiceLine> resultLines = new ArrayList<CoreInvoiceLine>(lines.size());
		lines.forEach(line -> {
			resultLines.add(TradeLineItem.create(line));
		});
		return resultLines;
	}
	static List<TradeLineItem> getLines(CrossIndustryInvoiceType doc) {
		List<SupplyChainTradeLineItemType> lines = doc.getSupplyChainTradeTransaction().getIncludedSupplyChainTradeLineItem();
		List<TradeLineItem> resultLines = new ArrayList<TradeLineItem>(lines.size());
		lines.forEach(line -> {
			resultLines.add(TradeLineItem.create(line));
		});
		return resultLines;
	}

// -----------------------------------------------------------
	
	private HeaderTradeAgreementType getApplicableHeaderTradeAgreement() {
		return getApplicableHeaderTradeAgreement(this.getSupplyChainTradeTransaction());
	}
	private HeaderTradeAgreementType getApplicableHeaderTradeAgreement(SupplyChainTradeTransactionType supplyChainTradeTransaction) {
		HeaderTradeAgreementType headerTradeAgreement = supplyChainTradeTransaction.getApplicableHeaderTradeAgreement();
		if(headerTradeAgreement==null) {
			headerTradeAgreement = new HeaderTradeAgreementType();
			LOG.config("new HeaderTradeAgreementType:"+headerTradeAgreement);
		}
		return headerTradeAgreement;
	}	

	// ----------------- gemeinsam mit TradeParty : delegate
	@Override
	public BusinessParty createParty(String name, String tradingName, PostalAddress address, IContact contact) {
		return new TradeParty(name, tradingName, address, contact); 
	}

	@Override
	public BusinessParty createParty(BusinessParty party) {
		return new TradeParty((TradePartyType)party); 
	}

	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		TradeParty party = new TradeParty();
		return party.createAddress(countryCode, postalCode, city);
	}

	@Override
	public PostalAddress createAddress(PostalAddress address) {
		TradeParty party = new TradeParty();
		return party.createAddress(address);
	}

	@Override
	public IContact createContact(String contactName, String contactTel, String contactMail) {
		TradeParty party = new TradeParty();
		return party.createContact(contactName, contactTel, contactMail);
	}

	@Override
	public IContact createContact(IContact contact) {
		TradeParty party = new TradeParty();
		return party.createContact(contact);
	}

}
