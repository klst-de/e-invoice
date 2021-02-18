package com.klst.einvoice;

import java.sql.Timestamp;

import com.klst.untdid.codelist.DateTimeFormats;

/**
 * BG-3 Factory for PRECEDING INVOICE REFERENCE
 * 
 * @see PrecedingInvoice
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
