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
 * 
 * <p>
 * Article 219 (COUNCIL DIRECTIVE 2006/112/EC)
 * <br>
 * Any document or message that amends and refers specifically and unambiguously 
 * to the initial invoice shall be treated as an invoice.
 * 
 * @see PrecedingInvoice
 */
public interface BG3_PrecedingInvoiceReference {
	
	@Deprecated
	default String getPrecedingInvoiceReference() {
		List<PrecedingInvoice> list = getPrecedingInvoices();
		if(list.isEmpty()) return null;
		return list.get(0).getDocumentReference().getName();
	}
	
	// factory 
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts);
	
	default PrecedingInvoice createPrecedingInvoiceReference(String docRefId, String ymd) {
		return createPrecedingInvoiceReference(docRefId, ymd==null? null : DateTimeFormats.ymdToTs(ymd));
	}
	
	default PrecedingInvoice createPrecedingInvoiceReference(String docRefId) {
		return createPrecedingInvoiceReference(docRefId, (Timestamp)null);
	}

	public void addPrecedingInvoice(PrecedingInvoice precedingInvoice);
	public List<PrecedingInvoice> getPrecedingInvoices();

	// shortcuts:
	default void setPrecedingInvoiceReference(String docRefId) {
		addPrecedingInvoice(createPrecedingInvoiceReference(docRefId));
	}
	default void setPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		addPrecedingInvoice(createPrecedingInvoiceReference(docRefId, ts));
	}
	default void setPrecedingInvoiceReference(String docRefId, String ymd) {
		addPrecedingInvoice(createPrecedingInvoiceReference(docRefId, DateTimeFormats.ymdToTs(ymd)));
	}

}
