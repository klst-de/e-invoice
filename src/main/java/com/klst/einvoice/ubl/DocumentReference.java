package com.klst.einvoice.ubl;

import java.sql.Timestamp;
import java.util.logging.Logger;

import com.klst.einvoice.PrecedingInvoice;
import com.klst.einvoice.Reference;
import com.klst.untdid.codelist.DateTimeFormats;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;

public class DocumentReference extends DocumentReferenceType implements PrecedingInvoice {

	// factory
	static PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		return new DocumentReference(new ID(docRefId), ts);
	}

	private static final Logger LOG = Logger.getLogger(DocumentReference.class.getName());
	
	public DocumentReference(DocumentReferenceType doc) {
		super();
		if(doc!=null) {
			super.setID(doc.getID());
			super.setCopyIndicator(doc.getCopyIndicator());
			super.setUUID(doc.getUUID());
			super.setIssueDate(doc.getIssueDate());
			super.setIssueTime(doc.getIssueTime());
			super.setDocumentTypeCode(doc.getDocumentTypeCode());
			super.setDocumentType(doc.getDocumentType());
			super.xPath = doc.getXPath();
			super.setLanguageID(doc.getLanguageID());
			super.setLocaleCode(doc.getLocaleCode());
			super.setVersionID(doc.getVersionID());
			super.setDocumentStatusCode(doc.getDocumentStatusCode());
			super.documentDescription = doc.getDocumentDescription();			
			super.setAttachment(doc.getAttachment());
			super.setValidityPeriod(doc.getValidityPeriod());
			super.setIssuerParty(doc.getIssuerParty());
			super.setResultOfVerification(doc.getResultOfVerification());
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
