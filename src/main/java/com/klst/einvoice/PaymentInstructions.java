package com.klst.einvoice;

import java.util.List;

import com.klst.edoc.untdid.PaymentMeansEnum;

/**
 * BG-16 0..1 PAYMENT INSTRUCTIONS
 * <p>
 * A group of business terms providing information about the payment. 
 * <p>
 * Cardinality: 0..1
 * <br>EN16931-ID: 	BG-16
 * <br>Rule ID: 	BR-DE-1 (1..1 this cius rule makes it mandatory)
 * <br>Request ID: 	R58
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*  (de) rules / Geschäftsregel:
 * 
 * BR-DE-1 : Eine Gruppe von Informationselementen, die Informationen darüber liefern, wie die Zahlung erfolgen soll.
 * Eine Rechnung (INVOICE) muss Angaben zu „PAYMENT INSTRUCTIONS“ (BG-16) enthalten.
 * 
 * BR-49 Zahlungsanweisungen :
 * Eine Zahlungsanweisung (BG-16) muss den Code der Zahlungsmittelart (BT-81) angeben.
 */
// implemented in PaymentMeans extends PaymentMeansType (UBL)
//                PaymentMeans extends TradeSettlementPaymentMeansType (CII)
//  class ApplicableHeaderTradeSettlement extends HeaderTradeSettlementType 
//                                     implements PaymentInstructions, CreditTransferFactory, DirectDebitFactory
public interface PaymentInstructions {

	/**
	 * Payment means type code
	 * <p>
	 * The means, expressed as code, for how a payment is expected to be or has been settled.
	 * <p>
	 * Entries from the UNTDID 4461 code list [6] shall be used. Distinction should be made between SEPA and non-SEPA payments,
	 * and between credit payments, direct debits, card payments and other instruments.
	 * <p>
	 * Cardinality: 	1..1
	 * <br>EN16931-ID: 	BT-81
	 * <br>Rule ID: 	BR-49
	 * <br>Request ID: 	R58
	 * 
	 * @return Code
	 */
	/* BT-81 1..1 TypeCode Code für die Zahlungsart
	 * 
	 * Hinweis: Die Einträge aus der UNTDID 4461 Codeliste müssen verwendet werden. 
	 * Es sollte zwischen SEPA- und Nicht- SEPA-Zahlungen unterschieden werden sowie zwischen Kreditzahlungen, 
	 * Lastschriften, Kartenzahlungen und anderen Zahlungsmitteln.
	 * 
	 * Anwendung: Insbesondere können folgende Codes verwendet werden (enum PaymentMeansCode): 
	 * 10 : Bargeld 
	 * 20 : Scheck 
	 * 30 : Überweisung 
	 * 42 : Payment to bank account 
	 * 48 : Kartenzahlung 
	 * 49 : Lastschrift 
	 * 57 : Dauerauftrag 
	 * 58 : SEPA Credit Transfer 
	 * 59 : SEPA Direct Debit 
	 * 97 : Report
	 */
	public PaymentMeansEnum getPaymentMeansEnum();
	public void setPaymentMeansEnum(PaymentMeansEnum code); // use setPaymentMeans to set BT-81 + BT-82

	/**
	 * Payment means text
	 * <p>
	 * The means, expressed as text, for how a payment is expected to be or has been settled.
	 * Such as cash, credit transfer, direct debit, credit card, etc.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BT-82
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R58
	 * 
	 * @return Text
 	 */
	// Information Text zur Zahlungsart
	public String getPaymentMeansText();
//	public void setPaymentMeansText(String text); // use setPaymentMeans to set BT-81 + BT-82
	
	/**
	 * setter Payment means code + text
	 * 
	 * @param code mandatory BT-81
	 * @param text optional  BT-82 (can be null)
	 */
	public void setPaymentMeans(PaymentMeansEnum code, String text);

	/**
	 * Remittance information
	 * <p>
	 * A textual value used to establish a link between the payment and the Invoice, issued by the Seller.
	 * <p>
	 * Used for creditor's critical reconciliation information. 
	 * This information element helps the Seller to assign an incoming payment to the relevant payment process.
	 * When specifying the textual value, which is commonly the invoice number of the invoice being paid, 
	 * but may be another seller reference, the buyer should indicate this reference in his payment order when executing the payment. 
	 * In a payment transaction this reference is transferred back to the Seller as Remittance Information.
	 * <p>
	 * In order to allow for automatic processing of cross-border SEPA payments, only Latin characters should be used in this field, 
	 * with a maximum of 140 characters. Reference section 1.4 of the SEPA credit transfer and 
	 * SEPA direct debit scheme implementation guides [13] and [14] for details of the allowed characters. 
	 * Other rules may apply for SEPA payments within national borders.
	 * 
	 * If remittance information is structured according to the ISO 11649:2009 standard for Structured RF Creditor Reference,
	 * it shall be mapped to the Structured Remittance Information Creditor Reference field in SEPA payments messages.
	 * If remittance information is structured according to the EACT standard for automated reconciliation, 
	 * it shall be mapped to the Unstructured Remittance Information field in SEPA payments messages.
	 * 
	 * If remittance information is to be mapped to the End To End Identification field or to the 
	 * Structured Remittance Information Creditor Reference field in SEPA payments messages, 
	 * then in addition to the Latin character set restriction, 
	 * the content shall not start or end with a '/' and the content shall not contain '//'s.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BT-83
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R56, R62 
	 * 
	 * @param Text
	 * 
	 * @see <a href="https://www.europeanpaymentscouncil.eu/what-we-do/sepa-credit-transfer">SEPA Credit Transfer Scheme Implementation Guide</a> for [13]
	 * 
	 * @see <a href="https://www.europeanpaymentscouncil.eu/what-we-do/sepa-direct-debit">SEPA Direct Debit Scheme Implementation Guide</a> for [14]
	 */
	// PaymentReference Verwendungszweck
	public void setRemittanceInformation(String text);
	public String getRemittanceInformation();

	/* zu Gruppe PAYMENT INSTRUCTIONS gehören Untergruppen.
	 * Die Untergruppen sind alternativ
	 * BG-17 0..n CREDIT TRANSFER ist anzugeben, wenn eine Zahlung per Überweisung erfolgen soll
	 * BG-18 0..1 PAYMENT CARD INFORMATION ist anzugeben, wenn eine Zahlung per Zahlungskarte/Kreditkarte erfolgte
	 * BG-19 0..1 DIRECT DEBIT ist anzugeben, n, wenn ein Mandat erteilt wurde und der Rechnungsbetrag per Lastschrift beglichen werden soll
	 * 
	 * Eine der Untergruppen muss angegeben werden!
	 */
	// demnach werden setter/getter definiert:
	public void addCreditTransfer(CreditTransfer creditTransfer);
	public List<CreditTransfer> getCreditTransfer();
	
	// BG-18 (optional) PAYMENT CARD INFORMATION
	public void setPaymentCard(PaymentCard paymentCard);
	public PaymentCard getPaymentCard();
	
	// BG-19 (optional) DIRECT DEBIT
	public void setDirectDebit(DirectDebit directDebit);
	public DirectDebit getDirectDebit();
	
}
