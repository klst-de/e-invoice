package com.klst.einvoice;

import java.util.List;

/**
 * BG-1 INVOICE NOTE
 * <p>
 * A group of business terms providing textual notes that are relevant for the invoice, 
 * together with an indication of the note subject.
 * <p>
 * Cardinality: 	0..n
 * <br>EN16931-ID: 	BG-1
 * <br>Rule ID: 	
 * <br>Request ID: 	R56
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 * @see InvoiceNoteFactory
 */
public interface BG1_InvoiceNote extends InvoiceNoteFactory {
	
	/**
	 * A shortcut to create an InvoiceNote without optional subjectCode
	 * @param content
	 * @return INVOICE NOTE Object
	 * 
	 * @see InvoiceNoteFactory#createNote(String, String)
	 */
	default InvoiceNote createNote(String content) {
		return createNote((String)null, content);
	}

	/**
	 * Add BG-1 INVOICE NOTE <code>note</code> to the invoice
	 * 
	 * @param note
	 */
	public void addNote(InvoiceNote note);
	default void addNote(String subjectCode, String content) {
		addNote(createNote(subjectCode, content));
	}
	default void addNote(String content) {
		addNote((String)null, content);
	}
	
	/**
	 * Get all BG-1 INVOICE NOTEs related to the invoice. The cardinality is 0..n
	 * 
	 * @return List of InvoiceNotes
	 */
	public List<InvoiceNote> getInvoiceNotes();

}
