package com.klst.einvoice;

import com.klst.edoc.untdid.DocumentNameCode;

/**
 * abstract-factory, aka Kit to create invoices
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */
public interface CoreInvoiceFactory extends CoreInvoiceLineFactory {
	
	/**
	 * factory method to create an invoice object, uses PROCESS CONTROL (BG-2) params
	 * 
	 * @param CustomizationID aka profile Identifier String, f.i. PROFILE_EN_16931, BG-2.BT-24
	 * @param processType (optional) Textstring identifying the business process context, BG-2.BT-23
	 * @param Invoice type code - A code specifying the functional type of the Invoice, BT-3
	 * 
	 * @return invoice object
	 * 
	 * @see BG2_ProcessControl#getCustomization()
	 * @see BG2_ProcessControl#getProcessType()
	 */
	public CoreInvoice createInvoice(String profile, String processType, DocumentNameCode code);
	
	default CoreInvoice createInvoice(String profile, DocumentNameCode code) {
		return createInvoice(profile, null, code);
	}

}
