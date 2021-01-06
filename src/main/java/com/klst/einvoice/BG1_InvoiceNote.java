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
	
//	TODO delete this >>>>>>>>>>
	@Deprecated // use List<InvoiceNote> getInvoiceNotes()
	public List<Object> getNotes();
	
	@Deprecated
	void setNote(String subjectCode, String content);
	@Deprecated
	void setNote(String content);
//	<<<<<<<<<<<<<<<<

	// getter
	public List<InvoiceNote> getInvoiceNotes();

	// factory methods
	@Override
	public InvoiceNote createNote(String subjectCode, String content);
	public InvoiceNote createNote(String content);

	// setter
	public void addNote(InvoiceNote note);
	public void addNote(String subjectCode, String content);
	public void addNote(String content);
	
}
