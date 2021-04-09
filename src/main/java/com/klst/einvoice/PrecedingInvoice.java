package com.klst.einvoice;

import java.sql.Timestamp;

import com.klst.edoc.api.Reference;
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
public interface PrecedingInvoice extends PrecedingInvoiceFactory{
	
	/**
	 * Preceding Invoice reference
	 * <p>
	 * The identification of an Invoice that was previously sent by the Seller.
	 * <p>
	 * Cardinality: 	1..1
	 * <br>EN16931-ID: 	BG-3.BT-25
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R11 R12
	 * 
	 * @param Reference Identifier
	 */
	public void setDocumentReference(Reference docRefId);
	public Reference getDocumentReference();

	/**
	 * Preceding Invoice issue date
	 * <p>
	 * The date when the Preceding Invoice was issued.
	 * The Preceding Invoice issue date shall be provided in case the Preceding Invoice identifier is not unique.
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BG-3.BT-26
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R11 R12
	 * 
	 * @param timestamp
	 */
	public void setDate(Timestamp timestamp);
	public Timestamp getDateAsTimestamp();
	
	/**
	 * Preceding Invoice issue date
	 * 
	 * @param ymd - String in UNTDID 2379 Format "102" : CCYYMMDD = "yyyyMMdd" or "yyyy-MM-dd" 
	 * @see #setDate(Timestamp)
	 */
	default void setDate(String ymd) {
		if(ymd!=null) setDate(DateTimeFormats.ymdToTs(ymd));
	}

}
