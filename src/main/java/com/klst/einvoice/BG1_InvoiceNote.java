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

!!! in CII gehören Content und SubjectCode zusammen, in UBL nicht

 */
// TODO Idee runter zu ubl und cii und public raus ?!
public interface BG1_InvoiceNote {
	
	// BT-21 ++ 0..1 Invoice note subject code
//	public String getSubjectCode();
	
	// BT-22 ++ 1..1 Invoice note
//	public String getNote();
	
	public List<Object> getNotes(); // Object == NoteType/CII ist mächtiger als  NoteType/UBL TODO UBL -> CII NoteType mappen
	
	/**
	 * 
	 * @param subjectCode - To be chosen from the entries in UNTDID 4451, BT-21 / 0..1
	 * @param content - note Content, BT-22 / 1..1 
	 * <br> A textual note that gives unstructured information that is relevant to the Invoice as a whole.
 	 * Such as the reason for any correction or assignment note in case the invoice has been factored.
	 */
	void setNote(String subjectCode, String content);
	void setNote(String content);

}
