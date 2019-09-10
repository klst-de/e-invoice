package com.klst.einvoice;

import java.sql.Timestamp;

import com.klst.untdid.codelist.DocumentNameCode;

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
public interface CoreInvoice extends BG1_InvoiceNote, BG2_ProcessControl, BG3_PrecedingInvoiceReference, BG14_InvoicingPeriod, BG22_DocumentTotals, 
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
	 * @param ymd Date
	 */
	public void setIssueDate(String ymd);
	public void setIssueDate(Timestamp ts);
	public Timestamp getIssueDateAsTimestamp();
	
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
	 * <br>Rule ID: 	BR-4, BR-DE-17 
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
	 * @param ymd Date
	 */
	public void setTaxPointDate(String ymd);	
	public void setTaxPointDate(Timestamp ts);
	public Timestamp getTaxPointDateAsTimestamp();

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
	 * @param ymd Date, optional: can be null
	 */
	// CII: SpecifiedTradePaymentTerms.DueDateDateTime.DateTimeString
	public void setDueDate(String ymd);
	public void setDueDate(Timestamp ts);
	public Timestamp getDueDateAsTimestamp();

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
	 * <br>EN16931-ID: 	BT-9 & BT-20
	 * <br>Rule ID: 	BR-CO-25
	 * <br>Request ID: 	R60
	 * 
	 * @param description, optional: can be null
	 * @param ymd Date, optional: can be null
	 */
	public void setPaymentTermsAndDate(String description, String ymd);
	public void setPaymentTermsAndDate(String description, Timestamp ts);

	public String getPaymentTerm();

	/**
	 * Buyer reference - An identifier assigned by the Buyer used for internal routing purposes.
	 * <p>
	 * The identifier is defined by the Buyer (e.g. contact ID, department, office id, project code), 
	 * but provided by the Seller in the Invoice.
	 * <p>
	 * Cardinality: 0..1 (optional), but mandatory due to BR-DE-15
	 * <br>EN16931-ID: 	BT-10
	 * <br>Rule ID: 	BR-DE-15
	 * <br>Request ID: 	R8
	 * 
	 * @param Text
	 */
	public void setBuyerReference(String reference);
	public String getBuyerReferenceValue();

	/**
	 * Project reference
	 * <p>
	 * The identification of the project the invoice refers to
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-11
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R44
	 * 
	 * @param Document reference
	 */
	public void setProjectReference(String id);
	public void setProjectReference(String id, String name); // name nur in CII Beispielen 05 13 15
	public String getProjectReference();
	
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

	// BT-15 Receiving advice reference                                TODO 
	// BT-16 Despatch advice reference                                 TODO
	// BT-17 Tender or lot reference                                   TODO
	// BT-18 Invoiced object identifier                                TODO
	// BT-19 Buyer accounting reference                                TODO

	// BT-20 @see setPaymentTermsAndDate
	
	// BG-1 + 0..n INVOICE NOTE @see BG1_InvoiceNote

	// BG-2 + 1..1 PROCESS CONTROL @see BG2_ProcessControl

	// BG-3 + 0..n PRECEDING INVOICE REFERENCE @see BG3_PrecedingInvoiceReference

	// BG-4 + 1..1 SELLER @see BG4_Seller
	public void setSeller(String name, PostalAddress address, IContact contact, String companyId, String companyLegalForm);
	public void setSeller(BusinessParty party);
	public BG4_Seller getSeller();
	
	// BG-5 ++ 1..1 SELLER POSTAL ADDRESS @see PostalAddress
	// BG-6 ++ 0..1 SELLER CONTACT @see IContact

	// BG-7 + 1..1 BUYER @see BG7_Buyer
	public void setBuyer(String name, PostalAddress address, IContact contact);
	public void setBuyer(BusinessParty party);
	public BG7_Buyer getBuyer();
	
	// BG-8 ++ 1..1 BUYER POSTAL ADDRESS @see PostalAddress
	// BG-9 ++ 0..1 BUYER CONTACT @see IContact
	
	// BG-10 + 0..1 PAYEE
	public void setPayee(String name, String id, String companyLegalForm);
	public void setPayee(BusinessParty party);
	public BusinessParty getPayee();
	
	// BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY @see BG11_SellerTaxRepresentativeParty
	public void setTaxRepresentative(String registrationName, PostalAddress address, String taxRegistrationName, String taxRegistrationSchemaID);
	public void setTaxRepresentative(BusinessParty party);
	public BusinessParty getTaxRepresentative();
	
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
	
	// BG-16 + 0..1 PAYMENT INSTRUCTIONS
	
// CopyIndicator . Datentyp: udt:IndicatorType . Kardinalität: 0 .. 1 , nur EXTENDED
// LanguageID Sprachkennzeichen . Datentyp: udt:IDType . Kardinalität: 0 .. 1 , nur EXTENDED
	
	// VAT BREAKDOWN BG-23 1..* (mandatory)
	public void addVATBreakDown(CoreInvoiceVatBreakdown vatBreakdown);
	
	// BG-24 + 0..n ADDITIONAL SUPPORTING DOCUMENTS
	
	// INVOICE LINE  BG-25 1..* (mandatory)
	public void addLine(CoreInvoiceLine line);
	
}
