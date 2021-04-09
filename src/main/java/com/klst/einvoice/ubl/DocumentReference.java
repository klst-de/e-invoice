package com.klst.einvoice.ubl;

import java.sql.Timestamp;
import java.util.logging.Logger;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.Reference;
import com.klst.einvoice.PrecedingInvoice;
import com.klst.untdid.codelist.DateTimeFormats;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;

public class DocumentReference extends DocumentReferenceType implements PrecedingInvoice {

	// factory
	@Override
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		return create(docRefId, ts);
	}
	static DocumentReference create(String docRefId, Timestamp ts) {
		return new DocumentReference(new ID(docRefId), ts);
	}

	static DocumentReference create() {
		return create((DocumentReferenceType)null);
	}
	// copy factory
	static DocumentReference create(DocumentReferenceType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof DocumentReferenceType && object.getClass()!=DocumentReferenceType.class) {
			// object is instance of a subclass of DocumentReferenceType, but not DocumentReferenceType itself
			return (DocumentReference)object;
		} else {
			return new DocumentReference(object); 
		}
	}

	private static final Logger LOG = Logger.getLogger(DocumentReference.class.getName());
	
	private DocumentReference(DocumentReferenceType doc) {
		super();
		if(doc!=null) {
			SCopyCtor.getInstance().invokeCopy(this, doc);
			LOG.config("copy ctor:"+this);
		}
	}

	private DocumentReference(Reference docRefId, Timestamp ts) {
		setDocumentReference(docRefId);
		setDate(ts);
		LOG.info("ctor:"+this);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(getDocumentReference()==null ? "null" : getDocumentReference().getName());
		stringBuilder.append(", date:").append(getDateAsTimestamp());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	// BG-2.BT-25 ++ 1..1 Preceding Invoice reference
	@Override
	public Reference getDocumentReference() {
		return super.getID()==null ? null : new ID(getID());
	}

	@Override
	public void setDocumentReference(Reference docRefId) {
		// Reference extends Identifier
		// ID extends IDType implements Identifier, Reference
		super.setID((ID)docRefId);
	}

	// BG-2.BT-26 ++ 0..1 Preceding Invoice issue date
	@Override
	public Timestamp getDateAsTimestamp() {
		if(super.getIssueDate()==null) return null;
		return DateTimeFormats.xmlGregorianCalendarToTs(getIssueDate().getValue());
	}

	@Override
	public void setDate(String ymd) {
		if(ymd==null) return;
		setDate(DateTimeFormats.ymdToTs(ymd));
	}

	@Override
	public void setDate(Timestamp ts) {
		if(ts!=null) {
			IssueDateType date = new IssueDateType();
			date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
			super.setIssueDate(date);
		}
	}

}
