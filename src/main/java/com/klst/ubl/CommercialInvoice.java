package com.klst.ubl;

import com.klst.untdid.codelist.DocumentNameCode;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

public class CommercialInvoice extends Invoice {

	public CommercialInvoice(InvoiceType invoice) {
		super(invoice);
	}
	public CommercialInvoice(String customization) {
		this(customization, null);
	}
	public CommercialInvoice(String customization, String profile) {
		super(customization, profile, DocumentNameCode.CommercialInvoice);
	}

}
