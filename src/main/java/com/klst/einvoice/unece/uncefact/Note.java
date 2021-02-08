package com.klst.einvoice.unece.uncefact;

import java.util.ArrayList;
import java.util.List;

import com.klst.einvoice.InvoiceNote;
import com.klst.einvoice.reflection.CopyCtor;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ExchangedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

/* implements CII BG-1 INVOICE NOTE
 * to get all getInvoiceNotes use  CoreInvoice method 
 * public List<InvoiceNote> getInvoiceNotes()
 * 
 * also implements BG-25.BT-127 0..n IncludedNote.Content
 */
public class Note extends NoteType implements InvoiceNote {

	@Override // implements NoteFactory
	public InvoiceNote createNote(String subjectCode, String content) {
		return create(subjectCode, content);
	}
	static Note create(String subjectCode, String content) {
		return content==null? null : new Note(subjectCode, content);
	}
	static Note create(String content) {
		return create(null, content);
	}

	static List<InvoiceNote> getInvoiceNotes(ExchangedDocumentType doc) {
		List<NoteType> list = doc.getIncludedNote();
		List<InvoiceNote> result = new ArrayList<InvoiceNote>(list.size());
		list.forEach(note -> {
			result.add(Note.create(note));
		});
		return result;
	}

	// copy factory
	static Note create(NoteType object) {
		if(object instanceof NoteType && object.getClass()!=NoteType.class) {
			// object is instance of a subclass of NoteType, but not NoteType itself
			return (Note)object;
		} else {
			return new Note(object); 
		}
	}
	
	private Note(String subjectCode, String content) {
		super();
		setCode(subjectCode);
		setNote(content);
	}
	// copy ctor
	private Note(NoteType note) {
		super();
		if(note!=null) {
			CopyCtor.invokeCopy(this, note);
		}
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

	// BG-1 .BT-22  1..1 Invoice note
	// BG-25.BT-127 0..n IncludedNote.Content 
	@Override
	public String getNote() {
		return getNote(this);
	}
	static String getNote(NoteType note) {
		List<TextType> content = note.getContent();
		return content.isEmpty() ? null : content.get(0).getValue();
	}

	void setNote(String content) {
		if(content==null) return; // defensiv, sollte nicht vorkommen
		super.getContent().add(new Text(content));
	}

}
