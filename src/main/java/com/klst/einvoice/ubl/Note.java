package com.klst.einvoice.ubl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.klst.einvoice.api.BG1_InvoiceNote;
import com.klst.einvoice.api.InvoiceNote;
import com.klst.einvoice.api.InvoiceNoteFactory;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;

/** 
 * implements UBL BG-1 INVOICE NOTE {@link InvoiceNote}
 * <p>
 * to get all InvoiceNotes use {@link BG1_InvoiceNote#getInvoiceNotes()} method 
 * <p>
 * also implements BG-25.BT-127 0..n IncludedNote.Content {@link com.klst.einvoice.api.CoreInvoiceLine#setNote(String)}
 * 
 * @see InvoiceNoteFactory
 */
/*      subjectCode BT-21 gibt es in UBL nicht!
Bsp 05:
UBL:
    <cbc:Note>ADU</cbc:Note>
    <cbc:Note>Trainer: Herr […]</cbc:Note>

wurde geändert zu:
    <cbc:Note>#ADU#Trainer: Herr […]</cbc:Note>

also ist in UBL effektiv nur ein String da, value - dieser wird per regex in subjectCode und content aufgeteilt
 */

public class Note extends NoteType implements InvoiceNote, InvoiceNoteFactory {

	@Override // implements NoteFactory
	public InvoiceNote createNote(String subjectCode, String content) {
		return create(subjectCode, content);
	}
	static InvoiceNote create(String subjectCode, String content) {
		return content==null? null : new Note(subjectCode, content);
	}

	static List<InvoiceNote> getInvoiceNotes(List<NoteType> list) {
		List<InvoiceNote> result = new ArrayList<InvoiceNote>(list.size());
		list.forEach(note -> {
			result.add(new Note(note));
		});
		return result;
	}

	private static final Logger LOG = Logger.getLogger(Note.class.getName());

	static final String FORMAT = "(#)([A-Z]{3})(#)(.*)";
	static Pattern PATTERN = Pattern.compile(FORMAT);
	static final int SUBJECT_CODE_GROUP = 2;
	static final int CONTENT_GROUP = 4;
	
	private String getGroup(String content, int group) {
		Matcher matcher = PATTERN.matcher(content);
		if (matcher.find()) {
//			LOG.fine("getGroup "+ group + ": SUBJECT_CODE_GROUP="+matcher.group(SUBJECT_CODE_GROUP) + "<<<<" 
//					+", CONTENT_GROUP="+matcher.group(CONTENT_GROUP) + "<<<<");
			return matcher.group(group);
		} else {
			LOG.fine("no match in '"+content+"´");
			return group==SUBJECT_CODE_GROUP ? null : content;
		}
	}
	Note(String subjectCode, String content) {
		super();
		if(subjectCode==null) {
			this.setNote(content);
		} else {
			this.setNote("#"+subjectCode+"#"+content);
		}

	}
	// copy ctor
	Note(NoteType note) {
		super();
		setNote(note.getValue());
	}

	@Override
	public String getCode() {
		return getGroup(super.getValue(), SUBJECT_CODE_GROUP);
	}

	// nicht public ==> use factory
//	void setCode(String code) {
//	}

	// BT-22 ++ 1..1 Invoice note
	@Override
	public String getNote() {
//		return super.getValue();
		return getGroup(super.getValue(), CONTENT_GROUP);
	}

	void setNote(String content) {
		if(content==null) return; // defensiv, sollte nicht vorkommen
		super.setValue(content);
	}

	// Test:
//	public static void main(String[] args) {
//		LOG.info("ADU+Trainer: Herr […]");
//		Note note1 = new Note("ADU", "Trainer: Herr […]");
//		LOG.info("Code:"+note1.getCode() + " content:"+note1.getNote());
//		
//		LOG.info("null+#ADU#Trainer: Herr […]");
//		Note note2 = new Note(null, "#ADU#Trainer: Herr […]");
//		LOG.info("Code:"+note2.getCode() + " content:"+note2.getNote());
//		
//		LOG.info("null+#AD#Trainer: Herr […]");
//		Note note3 = new Note(null, "#AD#Trainer: Herr […]");
//		LOG.info("Code:"+note3.getCode() + " content:"+note3.getNote());
//		
//		LOG.info("ADU+null");
//		Note note4 = new Note("ADU", null);
//		LOG.info("Code:"+note4.getCode() + " content:"+note4.getNote());
//	}
}
