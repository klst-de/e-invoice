package com.klst.einvoice.api;

import java.sql.Timestamp;

import com.klst.edoc.untdid.DateTimeFormats;

/**
 * BG-3 Factory for PRECEDING INVOICE REFERENCE
 * 
 * @see PrecedingInvoice
 * @see BG3_PrecedingInvoiceReference
 */
public interface PrecedingInvoiceFactory {
	
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts);
	
	default PrecedingInvoice createPrecedingInvoiceReference(String docRefId, String ymd) {
		return createPrecedingInvoiceReference(docRefId, ymd==null? null : DateTimeFormats.ymdToTs(ymd));
	}
	
	default PrecedingInvoice createPrecedingInvoiceReference(String docRefId) {
		return createPrecedingInvoiceReference(docRefId, (Timestamp)null);
	}

}
