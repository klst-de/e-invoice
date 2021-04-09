package com.klst.einvoice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.klst.edoc.api.Identifier;
import com.klst.edoc.api.Reference;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;

/*

core invoice model ::=
semantic data model of the core elements of an electronic invoice
siehe: EN_16931_1_2017_en , Kap.3 Terms and definitions

Ich wähle den Begriff CoreInvoice für das Interface, das die gemeinsamen Methoden des sematischen Datenmodells beschreibt.
Das Datenmodell hat zwei Syntaxen. UBL und CII
Implemetiert wird CoreInvoice in
 - ubl.Invoice
 - ubl.CreditNote
 - uncefact.CrossIndustryInvoice
 
Eine andere mögliche Namensgebung wären die Profilnamen mit Hierarhie
 - CoreInvoiceMinimum                                          -- nur fr
 - CoreInvoiceBasicwl extends CoreInvoiceMinimum               -- nur fr
 - CoreInvoiceBasic extends CoreInvoiceBasicwl                 -- Untermenge von EN 16931-1
 - CoreInvoiceEN16931 extends CoreInvoiceBasic                 -- EN 16931-1 vollständig, entspricht CoreInvoice
 - CoreInvoiceExtended extends CoreInvoiceEN16931              -- Erweiterung der EN 16931-1

 */
public interface CoreInvoice extends CoreInvoiceFactory, BG1_InvoiceNote, BG2_ProcessControl, BG3_PrecedingInvoiceReference, 
	BG4_Seller, BG7_Buyer, BG10_Payee, BG11_SellerTaxRepresentative, BG14_InvoicingPeriod, 
	PaymentInstructionsFactory, CreditTransferFactory, PaymentCardFactory, DirectDebitFactory,
	BG20_DocumentLevelAllowences, BG21_DocumentLevelCharges,
	BG22_DocumentTotals, BG23_VatBreakdown, 
	PostalAddressFactory, IContactFactory, BusinessPartyFactory {

	/**
	 * Invoice number   - A unique identification of the Invoice.
	 * <p>
	 * The sequential number required in Article 226(2) of the directive 2006/112/EC [2],
	 * to uniquely identify the Invoice within the business context, time-frame, operating systems and records of the Seller. 
	 * It may be based on one or more series of numbers, which may include alphanumeric characters. 
	 * No identification scheme is to be used.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-1
	 * <br>Rule ID: 	BR-2
	 * <br>Request ID: 	R56
	 * 
	 * @param id Identifier
	 */
	public void setId(String id);
	public String getId();
	
	/**
	 * Invoice issue date
	 * <p>
	 * The date when the Invoice was issued
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-2
	 * <br>Rule ID: 	BR-3
	 * <br>Request ID: 	R56
	 * 
	 * @param timestamp
	 */
	public void setIssueDate(Timestamp timestamp);
	public Timestamp getIssueDateAsTimestamp();
	
	/**
	 * Invoice issue date
	 * 
	 * @param ymd - String in UNTDID 2379 Format "102" : CCYYMMDD = "yyyyMMdd" or "yyyy-MM-dd" 
	 * @see #setIssueDate(Timestamp)
	 */
	default void setIssueDate(String ymd) {
		if(ymd!=null) setIssueDate(DateTimeFormats.ymdToTs(ymd));
	}
	
	/* Code für den Rechnungstyp
Anwendung: Für ZUGFeRD werden ab dem Profil BASIC folgende Codes empfohlen: 
380 : Handelsrechnung / Commercial invoice
381 : Gutschriftanzeige / Credit note
384 : Rechnungskorrektur / Corrected invoice
389 : Selbst ausgestellte Rechnung / Self-billed invoice - Gutschrift im Gutschriftsverfahren (Eine Rechnung, die der Zahlungsverpflichtete selbst ausstellt anstelle des Verkäufers.) 
261 : Self billed credit note - a document which indicates that the customer is claiming credit in a self billing environment 
386 : Vorauszahlungsrechnung - Eine Rechnung, die die Vorauszahlung für Produkte anfordert. Die darin enthaltenen Beträge werden in der Schlussrechnung abgezogen. 
326 : Teilrechnung / Partial invoice

Für die Profile BASIC WL und MINIMUM darf auschließlich folgender Code verwendet werden: 
751 : Buchungshilfe - KEINE Rechnung

weitere UNTDID 1001 Untermengen codes in ZUGFeRD-2.0-Spezifikation-TA.pdf

Besonderheit der XRechnung 
Geschäftsregel: BR-DE-17 Mit dem Element „Invoice type code“ (BT-3) sollen ausschließlich 
folgende Codes aus der Codeliste UNTDID 1001 übermittelt werden:
326 (Partial invoice)
380 (Commercial invoice)
384 (Corrected invoice)
381 (Credit note)
389 (Credit note)
Einschränkung: Nur Code 326, 380, 384, 381, 389 zulässig
	 */
	/**
	 * Invoice type code - A code specifying the functional type of the Invoice.
	 * <p>
	 * Commercial invoices and credit notes are defined according the entries in UNTDID 1001.
	 * Other entries of UNTDID 1001 with specific invoices or credit notes may be used if applicable.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-3
	 * <br>Rule ID: 	BR-4, BR-DE-17 :  
	 * Mit dem Element "Invoice type code" sollen ausschließlich folgende Codes aus der Codeliste UNTDID 1001 übermittelt werden: 
	 *     326 (Partial invoice), 
	 *     380 (Commercial invoice), 
	 *     384 (Corrected invoice), 
	 *     389 (Self-billed invoice) und 
	 *     381 (Credit note),
	 *     875 (Partial construction invoice), 
	 *     876 (Partial final construction invoice), 
	 *     877 (Final construction invoice)
	 * <br>Request ID: 	R44
	 * 
	 * @param code
	 */
	void setTypeCode(DocumentNameCode code);
	public DocumentNameCode getTypeCode();

	/*
InvoiceCurrencyCode Code für die Rechnungswährung . 
Datentyp: qdt:CurrencyCodeType . 
Beschreibung: Die Währung, in der alle Rechnungsbeträge angegeben werden, ausgenommen ist Steuergesamtbetrag in Buchungswährung . 
Hinweis: Die Rechnung ist in nur einer Währung auszustellen, ausgenommen hiervon ist nach Artikel 230 der Richtlinie 2006/112/EG über Umsatzsteuer der Steuergesamtbetrag in Buchungswährung (BT-111). 
Die Listen der zugelassenen Währungen werden von der ISO 4217 Maintenance Agency „Codes for the representation of currencies and funds” geführt. . 
Kardinalität: 1 .. 1 . EN16931-ID: BT-5
	 */
// SupplyChainTradeTransaction
// ApplicableHeaderTradeSettlement
// 1 .. 1 InvoiceCurrencyCode Code für die Rechnungswährung BT-5
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
	 * <br>EN16931-ID: 	BT-5
	 * <br>Rule ID: 	BR-5
	 * <br>Request ID: 	R54, R47
	 * 
	 * @param isoCode
	 * <p>
	 * The lists of valid currencies are registered with the ISO 4217 Maintenance Agency “Codes for the representation of currencies and funds”.
	 */
	public void setDocumentCurrency(String isoCurrencyCode);
	public String getDocumentCurrency();

	/*
TaxCurrencyCode Code für die Währung der Umsatzsteuerbuchung . 
Datentyp: qdt:CurrencyCodeType . 
Beschreibung: Währung die für die Umsatzsteuerbuchung- und -Meldezwecke verwendete Währung, die im Land des Verkäufers gültig ist oder verlangt wird. . 
Hinweis: Ist in Verbindung mit dem Steuergesamtbetrag in Buchungswährung (BT-111) anzugeben, wenn für die Währung der Umsatzsteuerbuchung ein anderer Code als für die Rechnungswährung verwendet wird. 
Die Liste der zugelassenen Währungen wird in der ISO 4217 Maintenance Agency „Codes for the representation of currencies and funds” geführt. 
Für weitere Informationen wird auf Artikel 230 der Richtlinie des Rates 2006/ 112/EG verwiesen. . 
Kardinalität: 0 .. 1 .
EN16931-ID: BT-6 
Verwendung ab: EN 16931 (COMFORT)

	 */
	/**
	 * VAT accounting currency code
	 * <p>
	 * The currency used for VAT accounting and reporting purposes as accepted or required in the country of the Seller.
	 * Shall be used in combination with the Invoice total VAT amount in accounting currency (BT-111) 
	 * when the VAT accounting currency code differs from the Invoice currency code.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-6
	 * <br>Rule ID:
	 * <br>Request ID: 	R54
	 * 
	 * @param isoCode
	 * <p>
	 * The lists of valid currencies are registered with the ISO 4217 Maintenance Agency “Codes for the representation of currencies and funds”.
	 */
	public void setTaxCurrency(String isoCurrencyCode);
	public String getTaxCurrency();

	/*
TaxPointDate Datum der Steuerfälligkeit . 
Datentyp: udt:DateType . 
Beschreibung: Angabe eines Datums, in Übereinstimmung mit der Umsatzsteuerrichtlinie, 
an dem die Umsatzsteuer für den Verkäufer und für den Käufer abrechnungsrelevant wird, 
insoweit als dieses Datum bestimmt werden kann und vom Rechnungsdatum abweicht . 
Hinweis: Das Steuererhebungsdatum für umsatzsteuerliche Zwecke ist üblicherweise das Datum der Warenlieferung oder 
des Abschlusses der Dienstleistung (das Basissteuerdatum). 
Dabei gibt es einige Varianten. Für weitere Informationen wird auf Artikel 226 (7) der Richtlinie des Rates 2006/112/EG verwiesen. 
Dieses Element ist erforderlich, falls das für die Umsatzsteuerabrechnung angesetzte Datum vom Rechnungsdatum abweicht. 
Sowohl der Käufer als auch der Verkäufer sollten das Lieferdatum für die Umsatzsteuerabrechnung verwenden, 
wenn dieses vom Verkäufer angegeben wird. Die Verwendung von BT-7 und BT-8 schließt sich gegenseitig aus. . 
Kardinalität: 0 .. 1 . 

Anwendung: In Deutschland wird dieses nicht verwendet. Statt dessen ist das Liefer- und Leistungsdatum anzugeben. (BT-72)

Verwendung ab: EN 16931 (COMFORT)

DateString Datum der Steuerfälligkeit, 
Wert Datentyp: extension (xsd:string) 
Kardinalität: 1 .. 1 
EN16931-ID: BT-7 
Anwendung: In Deutschland wird dieses nicht verwendet. Statt dessen ist das Liefer- und Leistungsdatum anzugeben. 
Geschäftsregel: BR-CO-3 
Rechnung Das Datum der Steuerfälligkeit (BT-7) und der Code für das Datum der Steuerfälligkeit (BT-8) schließen sich gegenseitig aus. 

format Datum, Format Datentyp: xs:string Kardinalität: required EN16931-ID: BT-7-0 
Codeliste: UNTDID 2379 Untermenge Code Codename 102 . CCYYMMDD

	 */
	/**
	 * Value added tax point date
	 * <p>
	 * The date when the VAT becomes accountable for the Seller and for the Buyer in so far as that 
	 * date can be determined and differs from the date of issue of the invoice, according to the VAT directive.
	 * The tax point is usually the date goods were supplied or services completed (the 'basic tax point'). 
	 * There are some variations.
	 * Please refer to Article 226 (7) of the Council Directive 2006/112/EC [2] for more information.
	 * This element is required if the Value added tax point date is different from the Invoice issue date.
	 * Both Buyer and Seller should use the Tax Point Date when provided by the Seller. 
	 * The use of BT-7 and BT-8 is mutually exclusive.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-7 BT-7-0
	 * <br>Rule ID: 	BR-CO-3
	 * <br>Request ID: 	R45 R46
	 * 
	 * @param timestamp
	 */
	public void setTaxPointDate(Timestamp timestamp);
	public Timestamp getTaxPointDateAsTimestamp();
	
	/**
	 * Value added tax point date
	 * 
	 * @param ymd - String in UNTDID 2379 Format "102" : CCYYMMDD = "yyyyMMdd" or "yyyy-MM-dd" 
	 * @see #setTaxPointDate(Timestamp)
	 */

	default void setTaxPointDate(String ymd) {
		if(ymd!=null) setTaxPointDate(DateTimeFormats.ymdToTs(ymd));
	}

	/**
	 * Value added tax point date code
	 * <p>
	 * The code of the date when the VAT becomes accountable for the Seller and for the Buyer.
	 * The code shall distinguish between the following entries of UNTDID 2005 [6]:
	 * <br> - Invoice document issue date
	 * <br> - Delivery date, actual
	 * <br> - Paid to dateThe Value added tax point
	 * <p>
	 * date code is used if the Value added tax point date is not known when the invoice is issued. 
	 * The use of BT-8 and BT-7 is mutually exclusive.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-8
	 * <br>Rule ID: 	BR-CO-3
	 * <br>Request ID: 	R45 R46
	 * 
	 * @param code
	 */
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
	// BT-8 Value added tax point date code - in ubl nicht definiert ???
	// In Deutschland ist das Liefer- und Leistungsdatum maßgebend (BT-72)
	public void setTaxPointDateCode(String code);
	public String getTaxPointDateCode();

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
	 * @param timestamp
	 */
	// CII: SpecifiedTradePaymentTerms.DueDateDateTime.DateTimeString
	public void setDueDate(Timestamp timestamp);
	public Timestamp getDueDateAsTimestamp();
	
	/**
	 * Payment due date 
	 * 
	 * @param ymd - String in UNTDID 2379 Format "102" : CCYYMMDD = "yyyyMMdd" or "yyyy-MM-dd" 
	 * @see #setDate(Timestamp)
	 */
	default void setDueDate(String ymd) {
		if(ymd!=null) setDueDate(DateTimeFormats.ymdToTs(ymd));
	}


	/**
	 * Payment terms & Payment due date
	 * <p>
	 * A textual description of the payment terms that apply to the amount due for payment (Including description of possible penalties).
	 * This element may contain multiple lines and multiple terms.
	 * <p>
	 * The date when the payment is due.
	 * <br>
	 * The payment due date reflects the due date of the net payment. 
	 * For partial payments it states the first net due date. 
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-9 (Payment due date) & BT-20 
	 * <br>Rule ID: 	BR-CO-25
	 * <br>Request ID: 	R60
	 * 
	 * @param description optional BT-20 textual description of the payment terms
	 * @param timestamp optional BT-9 Payment due date
	 */
	public void setPaymentTermsAndDate(String description, Timestamp timestamp);
	default void setPaymentTermsAndDate(String description, String ymd) {
		setPaymentTermsAndDate(description, ymd==null ? (Timestamp)null : DateTimeFormats.ymdToTs(ymd));
	}
	// BT-20
	public String getPaymentTerm();

	/**
	 * Buyer reference - An identifier assigned by the Buyer used for internal routing purposes.
	 * <p>
	 * The identifier is defined by the Buyer (e.g. contact ID, department, office id, project code), 
	 * but provided by the Seller in the Invoice.
	 * <p>
	 * Cardinality: 0..1 (optional), but mandatory in CIUS rule BR-DE-15
	 * <br>EN16931-ID: 	BT-10
	 * <br>Rule ID: 	BR-DE-15
	 * <br>Request ID: 	R8
	 * 
	 * @param Text / aka Leitweg-ID, PEPPOL-ID 
	 *               ==> BG-7.BT-47 0..1 Buyer legal registration identifier + Scheme identifier
	 */
	// siehe https://www.xoev.de/sixcms/media.php/13/Leitweg-ID-Formatspezifikation-v2.pdf
	public void setBuyerReference(String reference);
	public String getBuyerReferenceValue();

	/**
	 * Project reference
	 * <p>
	 * The identification of the project the invoice refers to
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-11, (Projektname BT-11-0)
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R44
	 * 
	 * @param Document reference
	 */
	public void setProjectReference(String id);
	public void setProjectReference(String id, String name); // name nur in CII Beispielen 05 13 15
	public void setProjectReference(Reference ref);
	public Reference getProjectReference();
	
	/**
	 * Contract reference
	 * <p>
	 * The identification of a contract. 
	 * The contract identifier should be unique in the context of the specific trading relationship and for a defined time period.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-12
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R7
	 * 
	 * @param Document reference
	 */
	// Eine eindeutige Bezeichnung des Vertrages (z. B. Vertragsnummer).
	public void setContractReference(String id);
	public String getContractReference();
	
	/**
	 * Purchase order reference
	 * <p>
	 * An identifier of a referenced purchase order, issued by the Buyer. 
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-13
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R5, R56
	 * 
	 * @param Document reference
	 */
	// Eine vom Erwerber ausgegebene Kennung für eine referenzierte Bestellung.
	public void setPurchaseOrderReference(String id);
	public String getPurchaseOrderReference();
	
	/**
	 * Sales order reference
	 * <p>
	 * An identifier of a referenced sales order, issued by the Seller.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-14
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R41
	 * 
	 * @param Document reference
	 */
	public void setOrderReference(String docRefId);
	public String getOrderReference();

	/**
	 * Receiving advice reference / Receipt document reference
	 * <p>
	 * An identifier of a referenced receiving advice.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-15
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R10, R56
	 * 
	 * @param Document reference
	 */
	// Referenz auf die Wareneingangsmeldung
	public void setReceiptReference(String docRefId);
	public String getReceiptReference();
	
	/**
	 * Despatch advice reference
	 * <p>
	 * An identifier of a referenced despatch advice.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-16
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R9, R56
	 * 
	 * @param Document reference
	 */
	// Lieferavisreferenz
	public void setDespatchAdviceReference(String docRefId);
	public String getDespatchAdviceReference();
	
	/**
	 * Tender or lot reference
	 * <p>
	 * The identification of the call for tender or lot the invoice relates to.
	 * In some countries a reference to the call for tender that has led to the contract shall be provided.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-17
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R7, R4
	 * 
	 * @param Document reference
	 */
	public void setTenderOrLotReference(String docRefId);
	public String getTenderOrLotReference();
	
	/* no kosit testCase provided, selber erstellt in 02.01a-uncefact, CII
            <ram:AdditionalReferencedDocument>
                <ram:IssuerAssignedID>871694831000290806</ram:IssuerAssignedID>  <!-- BT-18 -->
                <ram:TypeCode>130</ram:TypeCode>                   <!-- BT-18-0  Code 130 "Rechnungsdatenblatt"-->
                <ram:ReferenceTypeCode>AAC</ram:ReferenceTypeCode> <!-- BT-18-1 -->     
            </ram:AdditionalReferencedDocument>
	 */
	/**
	 * BT-18 Invoiced object identifier
	 * <p>
	 * An identifier for an object on which the invoice is based, given by the Seller.
	 * It may be a subscription number, telephone number, meter point, vehicle, person etc., as applicable.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-18
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R33
	 * 
	 * @param the identifier name BT-18
	 * @param scheme identifier BT-18-1
	 * The identification scheme identifier of the Invoiced object identifier.
	 * If it may be not clear for the receiver what scheme is used for the identifier, 
	 * a conditional scheme identifier should be used that shall be chosen from the UNTDID 1153 code list entries.
	 */
	public void setInvoicedObject(String name, String schemeID);
	public void setInvoicedObjectIdentifier(Identifier id);
	public void setInvoicedObject(String name);
	public String getInvoicedObject();
	public Identifier getInvoicedObjectIdentifier();
	
	/**
	 * Buyer accounting reference
	 * <p>
	 * A textual value that specifies where to book the relevant data into the Buyer's financial accounts.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-19
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R2, R4
	 * 
	 * @param textReference
	 */
	// BT-19 Buyer accounting reference       - es fehlen Testdaten beide CII + UBL  TODO
	public void setBuyerAccountingReference(Reference textReference);
	public Reference getBuyerAccountingReference();

	// BT-20 @see setPaymentTermsAndDate
	
	// BG-1 + 0..n INVOICE NOTE @see BG1_InvoiceNote

	// BG-2 + 1..1 PROCESS CONTROL @see BG2_ProcessControl

	// BG-3 + 0..n PRECEDING INVOICE REFERENCE @see BG3_PrecedingInvoiceReference

	// BG-4 + 1..1 SELLER @see BG4_Seller
	// BG-5 ++ 1..1 SELLER POSTAL ADDRESS @see PostalAddress
	// BG-6 ++ 0..1 SELLER CONTACT @see IContact

	// BG-7 + 1..1 BUYER @see BG7_Buyer
	// BG-8 ++ 1..1 BUYER POSTAL ADDRESS @see PostalAddress
	// BG-9 ++ 0..1 BUYER CONTACT @see IContact
	
	// BG-10 + 0..1 PAYEE
	/*
	 * CII: name ist (registration)Name
	 * UBL: name ist businessName
	 */
	
	// BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY @see BG11_SellerTaxRepresentativeParty
	// BG-12 ++ 1..1 SELLER TAX REPRESENTATIVE POSTAL ADDRESS @see PostalAddress

	// BG-13 + 0..1 DELIVERY INFORMATION @see BG13_DeliveryInformation
	/**
	 * set DELIVERY INFORMATION
	 * 
	 * @param name - BT-70 (optional) Deliver to party name
	 * @param ts - BT-72 (optional) Actual delivery date
	 * @param address - BG-15 (optional) DELIVER TO ADDRESS
	 * @param locationId - BT-71 (optional) Deliver to location
	 * @param scheme - BT-71-0 (optional) Deliver to location Scheme identifier
	 */
	public void setDelivery(String name, Timestamp ts, PostalAddress address, String locationId, String schemeId);
	public void setDelivery(BG13_DeliveryInformation delivery);
	public BG13_DeliveryInformation getDelivery();
	
	// BG-14 ++ 0..1 INVOICING PERIOD @see BG14_InvoicingPeriod
	
	// BG-15 ++ 0..1 DELIVER TO ADDRESS @see PostalAddress
	
	// BG-16 + 0..1 PAYMENT INSTRUCTIONS @see PaymentInstructions and PaymentInstructionsFactory
	/**
	 * 
	 * @param code - BT-81 mandatory Payment means type code
	 * @param paymentMeansText - BT-82 optional Payment means text
	 * @param remittanceInformation - BT-83 optional Remittance information
	 * @param creditTransfer - BG-17 0..n CREDIT TRANSFER
	 * @param paymentCard - BG-18 optional PAYMENT CARD INFORMATION
	 * @param directDebit - BG-19 optional DIRECT DEBIT
	 */
	public void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit);
	default void setPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, CreditTransfer creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		List<CreditTransfer> ctList = null;
		if(creditTransfer!=null) {
			ctList = new ArrayList<CreditTransfer>();
			ctList.add(creditTransfer);
		}
		setPaymentInstructions(code, paymentMeansText, remittanceInformation, ctList, paymentCard, directDebit);
	}
	public void setPaymentInstructions(PaymentInstructions paymentInstructions);
	public PaymentInstructions getPaymentInstructions();
	
// CopyIndicator . Datentyp: udt:IndicatorType . Kardinalität: 0 .. 1 , nur EXTENDED
// LanguageID Sprachkennzeichen . Datentyp: udt:IDType . Kardinalität: 0 .. 1 , nur EXTENDED
	
	/*
	 * 
	 * BG-20 + 0..n DOCUMENT LEVEL ALLOWANCES / ABSCHLÄGE
	 * BG20_DocumentLevelAllowences
	 * 
	 * BG-21 + 0..n DOCUMENT LEVEL CHARGES / ZUSCHLÄGE
	 * BG21_DocumentLevelCharges.java
	 * 
	 */
	
	// VAT BREAKDOWN BG-23 1..* (mandatory)
	// Factory method to create Business Group VAT BREAKDOWN BG-23
//	public VatBreakdown createVATBreakDown(Amount taxableAmount, Amount taxAmount, TaxCategoryCode code, BigDecimal percent);
//	public void addVATBreakDown(VatBreakdown vatBreakdown);
//	public List<VatBreakdown> getVATBreakDowns();
	
	// BG-24 + 0..n ADDITIONAL SUPPORTING DOCUMENTS
	// BG-24.BT-122 ++ 1..1 Supporting document reference
	// BG-24.BT-122-0  1..1 TypeCode
	// BG-24.BT-123 ++ 0..1 Supporting document description
	// BG-24.BT-124 ++ 0..1 External document location
	// BG-24.BT-125 ++ 0..1 Attached document
	/**
	 * use this to add an attached document
	 * 
	 * @param docRefId - BG-24.BT-122 Supporting document reference
//	 * @param code - BG-24.BT-122-0 TypeCode (CII only)
	 * @param description/name - BG-24.BT-123 Supporting document description
	 * @param content - BG-24.BT-125 Attached document content
	 * @param mimeCode
	 * @param filename
	 */
//	public void addSupportigDocument(String docRefId, String code, String description, byte[] content, String mimeCode, String filename);
	public void addSupportigDocument(String docRefId, String description, byte[] content, String mimeCode, String filename);
	
	/**
	 * use this to add an External document
	 * 
	 * @param docRefId - BG-24.BT-122 Supporting document reference
//	 * @param code - BG-24.BT-122-0 TypeCode (CII only)
	 * @param description/name - BG-24.BT-123 Supporting document description
	 * @param uri locationUri
	 */
//	public void addSupportigDocument(String docRefId, String code, String description, String uri);
	public void addSupportigDocument(String docRefId, String description, String uri);
	
	public List<BG24_AdditionalSupportingDocs> getAdditionalSupportingDocuments();
	
	// INVOICE LINE  BG-25 1..* (mandatory)
	public void addLine(CoreInvoiceLine line);
	public List<CoreInvoiceLine> getLines();
	
}
