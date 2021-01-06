package com.klst.einvoice.unece.uncefact;

import java.util.ArrayList;
import java.util.List;

import com.klst.einvoice.InvoiceNote;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ExchangedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

/* implements CII BG-1 INVOICE NOTE
 * to get all getInvoiceNotes use  CoreInvoice method 
 * public List<InvoiceNote> getInvoiceNotes()
 */
public class Note extends NoteType implements InvoiceNote {

	@Override // implements NoteFactory
	public InvoiceNote createNote(String subjectCode, String content) {
		return create(subjectCode, content);
	}
	static InvoiceNote create(String subjectCode, String content) {
		return content==null? null : new Note(subjectCode, content);
	}

	static List<InvoiceNote> getInvoiceNotes(ExchangedDocumentType doc) {
		List<NoteType> list = doc.getIncludedNote();
		List<InvoiceNote> result = new ArrayList<InvoiceNote>(list.size());
		list.forEach(note -> {
			result.add(new Note(note));
		});
		return result;
	}

	Note(String subjectCode, String content) {
		super();
		setCode(subjectCode);
		setNote(content);
	}
	// copy ctor
	Note(NoteType note) {
		super();
		setCode(note.getSubjectCode()==null ? null : note.getSubjectCode().getValue());
		setNote(getNote(note));
	}

	// BT-21 ++ 0..1 Invoice note subject code
	@Override
	public String getCode() {
		return super.getSubjectCode()==null ? null : getSubjectCode().getValue();
	}

	void setCode(String code) {
		if(code==null) return; 
		CodeType subjectCode = new CodeType();
		subjectCode.setValue(code);
		super.setSubjectCode(subjectCode);
	}

	// BT-22 ++ 1..1 Invoice note
	@Override
	public String getNote() {
		return getNote(this);
	}
	String getNote(NoteType note) {
		List<TextType> content = note.getContent();
		return content.isEmpty() ? null : content.get(0).getValue();
	}

	void setNote(String content) {
		if(content==null) return; // defensiv, sollte nicht vorkommen
		super.getContent().add(new Text(content));
	}

}
