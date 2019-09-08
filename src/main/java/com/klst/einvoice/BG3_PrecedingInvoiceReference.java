package com.klst.einvoice;

import java.sql.Timestamp;

/**
 * BG-3 PRECEDING INVOICE REFERENCE
 * <p>
 * A group of business terms providing information on one or more preceding Invoices.
 * To be used in case:
 * <br>- a preceding invoice is corrected
 * <br>- preceding partial invoices are referred to from a final invoice
 * <br>- preceding pre-payment invoices are referred to from a final invoice
 * <p>
 * Cardinality: 	0..n (optional)
 * <br>EN16931-ID: 	BG-3 , BT-25,BT-26,BT-26-0
 * <br>Rule ID: 	
 * <br>Request ID: 	R11, R12
 */

/* es fehlen testdaten
CII:
UBL:

0 .. 1 InvoiceReferencedDocument Referenz auf die vorausgegangene Rechnungen BG-3 
       xs:sequence 
1 .. 1 IssuerAssignedID Nummer der vorausgegangenen Rechnung                 BT-25 
0 .. 1 FormattedIssueDateTime Rechnungsdatum xs:sequence 
1 .. 1 DateTimeString Rechnungsdatum der vorausgegangenen Rechnung           BT-26 
required format Datum, Format                                                BT-26-0
 */
// TODO Idee runter zu ubl und cii und public raus ?!
public interface BG3_PrecedingInvoiceReference {
	
	// BT-25 ++ 1..1 Preceding Invoice reference	
	// BT-26 ++ 0..1 Preceding Invoice issue date
	public void setPrecedingInvoiceReference(String docRefId);
	public void setPrecedingInvoiceReference(String docRefId, String ymd);
	
	/**
	 * 
	 * @param docRefId - Preceding Invoice reference, BT-25 / 1..1
	 * @param ts - Preceding Invoice issue date, BT-26 / 0..1
	 */
	public void setPrecedingInvoiceReference(String docRefId, Timestamp ts);
	
	public String getPrecedingInvoiceReference(); // TODO muss List<> liefern wg. 0.n
	
}
