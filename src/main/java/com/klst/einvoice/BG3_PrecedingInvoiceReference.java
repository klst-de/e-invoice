package com.klst.einvoice;

import java.sql.Timestamp;
import java.util.List;

import com.klst.untdid.codelist.DateTimeFormats;

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
public interface BG3_PrecedingInvoiceReference {
	
	@Deprecated // use factory method
	public void setPrecedingInvoiceReference(String docRefId);
	@Deprecated // use factory method
	public void setPrecedingInvoiceReference(String docRefId, String ymd);
	@Deprecated // use factory method
	public void setPrecedingInvoiceReference(String docRefId, Timestamp ts);
	@Deprecated
	public String getPrecedingInvoiceReference(); // TODO muss List<> liefern wg. 0.n
	
	// TODO: factory 
	// createPrecedingInvoiceReference
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts);
	
	default PrecedingInvoice createPrecedingInvoiceReference(String docRefId, String ymd) {
		return createPrecedingInvoiceReference(docRefId, ymd==null? null : DateTimeFormats.ymdToTs(ymd));
	}
	
	default PrecedingInvoice createPrecedingInvoiceReference(String docRefId) {
		return createPrecedingInvoiceReference(docRefId, (Timestamp)null);
	}
	// und addPrecedingInvoiceReference(PrecedingInvoiceReference pir) coreInvoice
	// und ein IF PrecedingInvoiceReference
	// statt setXXX 3x:
	public void addPrecedingInvoice(PrecedingInvoice precedingInvoice);
	public List<PrecedingInvoice> getPrecedingInvoices();

}
