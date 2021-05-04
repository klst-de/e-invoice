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
public interface InvoiceNote extends InvoiceNoteFactory {
	
//	factory method:
//	public InvoiceNote createNote(String subjectCode, String content);
	
// setter:
//	void setCode(String code); // not public ==> use factory
//	void setNote(String content); // not public ==> use factory
	
// getter in BG1_InvoiceNote:
//	public List<InvoiceNote> getInvoiceNotes();
	
	/**
	 * returns optional Invoice note subject code
	 * <p>
	 * To be chosen from the entries in UNTDID 4451
	 * @see <a href="https://unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tred4451.htm">UNTDID 4451</a>
	 * <p>
	 * Cardinality: 	0..1
	 * <br>EN16931-ID: 	BT-21
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R56
	 * 
	 * @return Text or null
	 */
	public String getCode();
	
	/**
	 * returns Invoice note
	 * <p>
	 * A textual note that gives unstructured information that is relevant to the Invoice as a whole.
	 * Such as the reason for any correction or assignment note in case the invoice has been factored
	 * <p>
	 * Cardinality: 	1..1
	 * <br>EN16931-ID: 	BT-22
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R56
	 * 
	 * @return Text
	 */
	public String getNote();
	
}
