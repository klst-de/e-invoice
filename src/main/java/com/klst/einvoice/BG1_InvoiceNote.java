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
 */

/* Bsp 05:
CII:
        <ram:IncludedNote>
            <ram:Content>Trainer: Herr […]</ram:Content>
            <ram:SubjectCode>ADU</ram:SubjectCode>
        </ram:IncludedNote>

UBL:
    <cbc:Note>ADU</cbc:Note>
    <cbc:Note>Trainer: Herr […]</cbc:Note>

wurde geändert zu:
    <cbc:Note>#ADU#Trainer: Herr […]</cbc:Note>

 */
public interface BG1_InvoiceNote extends InvoiceNoteFactory {
	
	// getter
	public List<InvoiceNote> getInvoiceNotes();

	// factory methods
	/**
	 * {@inheritDoc}
	 */
	@Override
	public InvoiceNote createNote(String subjectCode, String content);
	default InvoiceNote createNote(String content) {
		return createNote((String)null, content);
	}

	// setter
	public void addNote(InvoiceNote note);
	default void addNote(String subjectCode, String content) {
		addNote(createNote(subjectCode, content));
	}
	default void addNote(String content) {
		addNote((String)null, content);
	}
	
}
