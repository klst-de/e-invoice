package com.klst.einvoice;

/**
 * abstract-factory, aka Kit for BG-1 INVOICE NOTE
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */

/* Freitext zur Rechnung BG-1
 * 
 * 
 * 
 */

public interface InvoiceNoteFactory {
	
	/**
	 * 
	 * @param subjectCode optional
	 * @param content
	 * @return BG-1 INVOICE NOTE Object
	 */
	public InvoiceNote createNote(String subjectCode, String content);
	
}
