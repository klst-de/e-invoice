package com.klst.einvoice;

import com.klst.untdid.codelist.PaymentMeansCode;

/**
 * BG-16 + 0..1 PAYMENT INSTRUCTIONS
 * <p>
 * A group of business terms providing information about the payment. 
 * <p>
 * Cardinality: 0..1
 * <br>EN16931-ID: 	BG-16
 * <br>Rule ID: 	BR-DE-1 (1..1)
 * <br>Request ID: 	R58
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */
/*  (de) rules / Geschäftsregel:
 * 
 * BR-DE-1 :
 * Eine Rechnung (INVOICE) muss Angaben zu „PAYMENT INSTRUCTIONS“ (BG-16) enthalten.
 * 
 * BR-49 Zahlungsanweisungen :
 * Eine Zahlungsanweisung (BG-16) muss den Code der Zahlungsmittelart (BT-81) angeben.
 */
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
	 * @param Code
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
	public void setPaymentMeansCode(PaymentMeansCode code); // use ctor
	public PaymentMeansCode getPaymentMeansCode();

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
	 * @param Text
 	 */
	// Information Text zur Zahlungsart
	public void setPaymentMeansText(String text); // use ctor
	public String getPaymentMeansText();
	
	/**
	 * Remittance information
	 * <p>
	 * A textual value used to establish a link between the payment and the Invoice, issued by the Seller.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BT-83
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R56, R62 
	 * 
	 * @param Text
	 */
	// PaymentReference Verwendungszweck
	public void setRemittanceInformation(String text); // use ctor
	public String getRemittanceInformation();

}
