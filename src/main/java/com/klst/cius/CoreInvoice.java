package com.klst.cius;

import java.sql.Timestamp;

import com.klst.untdid.codelist.DocumentNameCode;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentCurrencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxPointDateType;

/*

Ich wähle den Begriff CoreInvoice für das Interface, das die gemeinsamen Methoden des sematischen Datenmodells beschreibz.
Das Datenmodell hat zwei Syntaxen. UBL und CII
Implemetiert wird CoreInvoice in
 - ubl.Invoice
 - ubl.CreditNote
 - uncefact.CrossIndustryInvoice
 
Eine andere mögliche Namensgebung wären die Profilnamen mit Hierarhie
 - CoreInvoiceMinimum
 - CoreInvoiceBasicwl extends CoreInvoiceMinimum
 - CoreInvoiceBasic extends CoreInvoiceBasicwl
 - CoreInvoiceEN16931 extends CoreInvoiceBasic                 -- das entspricht CoreInvoice
 - CoreInvoiceExtended extends CoreInvoiceEN16931

 */
public interface CoreInvoice {

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

Anwendung: In Deutschland wird dieses nicht verwendet. Statt dessen ist das Liefer- und Leistungsdatum anzugeben.

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
	 * <br>EN16931-ID: 	BT-7
	 * <br>Rule ID: 	BR-CO-3
	 * <br>Request ID: 	R45 R46
	 * 
	 * @param ymd Date
	 */
	public void setTaxPointDate(String ymd);	
	public void setTaxPointDate(Timestamp ts);
	public Timestamp getTaxPointDateAsTimestamp();

// CopyIndicator . Datentyp: udt:IndicatorType . Kardinalität: 0 .. 1 , nur EXTENDED
// LanguageID Sprachkennzeichen . Datentyp: udt:IDType . Kardinalität: 0 .. 1 , nur EXTENDED
	
	
}
