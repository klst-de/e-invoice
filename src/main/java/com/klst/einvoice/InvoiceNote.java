package com.klst.einvoice;

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

/*      subjectCode gibt es in UBL nicht!
Bsp 05:
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

also ist in UBL effektiv nur ein String da, value
während in CII mehrere Objekte da sind, nur zwei werden genutzt:
    protected TextType subject;
    protected CodeType contentCode;
    protected List<TextType> content;      <=========== BT-22 
    protected CodeType subjectCode;        <=========== BT-21
    protected IDType id; 

 */
public interface InvoiceNote {
	
	// InvoiceNoteFactory: 
//	public InvoiceNote createNote(String subjectCode, String content)
	
	// BT-21 ++ 0..1 Invoice note subject code
	public String getCode();
//	void setCode(String code); // not public ==> use factory
	
	// BT-22 ++ 1..1 Invoice note
	public String getNote();
//	void setNote(String content); // not public ==> use factory
	
	// getter in CoreInvoice:
//	public List<InvoiceNote> getInvoiceNotes();
	
}
