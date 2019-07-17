package com.klst.xrechnung.test;

import java.util.logging.Logger;

import com.klst.einvoice.ubl.Invoice;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.marshaller.AbstactTransformer;

// mit subclass CreateUbl01_01aInvoice, CreateUbl01_04aInvoice, CreateAD_xxInvoice, ...
public abstract class InvoiceFactory {

	private static final Logger LOG = Logger.getLogger(InvoiceFactory.class.getName());
	
	protected AbstactTransformer transformer; // ein Singleton
	protected Object invoice;
	
	// ctor
	public InvoiceFactory(AbstactTransformer transformer) {
		this.transformer = transformer;
	}

	public byte[] toUbl() {
		invoice = makeInvoice();
		return transformer.fromModel(invoice);
	}
	
	public byte[] toCii() {
		invoice = makeInvoice();
		return transformer.fromModel(invoice);
	}
	
	abstract Object makeInvoice();
	
	public Invoice getTestDoc() {
		LOG.warning("not implemented (for test only)");
		return null;
	}
	
	boolean check(byte[] xml) {
		LOG.warning("not implemented (for test only)");
		return false;
	}
}
