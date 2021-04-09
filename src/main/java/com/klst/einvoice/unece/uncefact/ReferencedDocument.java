package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.List;

import com.klst.edoc.api.Reference;
import com.klst.einvoice.BG24_AdditionalSupportingDocs;
import com.klst.einvoice.PrecedingInvoice;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.FormattedDateTimeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.ReferenceCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.BinaryObjectType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

// BT-17 + 0..1 Tender or lot reference
// BT-18 + 0..1 Invoiced object identifier
// BT-18-0 0..1 Scheme identifier
//
// BG-3 + 0..n PRECEDING INVOICE REFERENCE
// BG-3.BT-25 ++ 1..1 Preceding Invoice reference
// BG-3.BT-26 ++ 0..1 Preceding Invoice issue date
//
// BG-24 + 0..n ADDITIONAL SUPPORTING DOCUMENTS
// 0 .. n AdditionalReferencedDocument Rechnungsbegründende Unterlagen BG-24
// BG-24.BT-122 ++ 1..1 Supporting document reference
// BG-24.BT-122-0  1..1 TypeCode
// BG-24.BT-123 ++ 0..1 Supporting document description
// BG-24.BT-124 ++ 0..1 External document location
// BG-24.BT-125 ++ 0..1 Attached document
/*
BR-52 Each Additional supporting document (BG-24) shall contain a Supporting document reference (BT-122).
Additional supporting documents BT-122

ReferencedDocument kapselt auch BT-3, BT-17 und BT-18 

 */
public class ReferencedDocument extends ReferencedDocumentType implements BG24_AdditionalSupportingDocs, PrecedingInvoice {

	// factory for BG-3
	@Override
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		return create(docRefId, ts);
	}

	static ReferencedDocument create(String docRefId, Timestamp ts) {
		ReferencedDocument rd = new ReferencedDocument(docRefId, (String)null, (String)null);
		rd.setDate(ts);
		return rd;
	}
	
	public ReferencedDocument(IDType issuerAssignedID, FormattedDateTimeType ftd) {
		super();
		super.setIssuerAssignedID(issuerAssignedID);
		super.setFormattedIssueDateTime(ftd);
	}
	/**
	 * ADDITIONAL SUPPORTING DOCUMENT
	 * <p>
	 * ctor with mandatory document reference
	 * <br>
	 * Business rule BR-52 : 
	 * Each Additional supporting document (BG-24) shall contain a Supporting document reference (BT-122).
	 * 
	 * @param docRefId, BG-24.BT-122 (mandatory BT business term) Supporting document reference
	 */
	public ReferencedDocument(String docRefId) {
		this(docRefId, DocumentNameCode.RelatedDocument);
	}
	// nicht public!
	ReferencedDocument(String docRefId, DocumentNameCode code) {
		this(docRefId, code, null);
	}
	ReferencedDocument(String docRefId, DocumentNameCode code, String referenceTypeCode) {
		this(docRefId, code.getValueAsString(), referenceTypeCode);
	}
	ReferencedDocument(String docRefId, String code, String referenceTypeCode) {
		super();
//		setSupportingDocumentReference(docRefId);
		super.setIssuerAssignedID(new ID(docRefId));
		setDocumentCode(code);
		setReferenceCode(referenceTypeCode);
	}
	
	// BG-24.BT-123 ++ 0..1 Supporting document description
	@Override
	public void setSupportingDocumentDescription(String text) {
		if(text==null) return;
		if(super.getName().isEmpty()) {
			super.getName().add(Text.create(text));
		} else {
			super.getName().get(0).setValue(text);
		}
	}

	@Override
	public String getSupportingDocumentDescription() {
		List<TextType> texts = super.getName();
		// in CII ist es eine Liste, hole erstes element
		return texts.isEmpty()? null : texts.get(0).getValue();
	}

	// BG-24.BT-124 ++ 0..1 External document location
	// in CII abgebildet auf ram:URIID , test Bsp 03.03a
	@Override
	public void setExternalDocumentLocation(String locationUri) {
		if(locationUri==null) return;
		super.setURIID(new ID(locationUri));
	}

	@Override
	public String getExternalDocumentLocation() {
		IDType uriID = super.getURIID();
		return uriID==null? null : uriID.getValue();
	}

	// BG-24.BT-125 ++ 0..1 Attached document
	@Override
	public void setAttachedDocument(byte[] content, String mimeCode, String filename) {
		if(super.getAttachmentBinaryObject().isEmpty()) {
			BinaryObjectType e = new BinaryObjectType();
			e.setValue(content);
			e.setMimeCode(mimeCode);
			e.setFilename(filename);
			super.getAttachmentBinaryObject().add(e);
		}
	}

	@Override
	public byte[] getAttachedDocument() {
		List<BinaryObjectType> binaryObjects = super.getAttachmentBinaryObject();
		if(binaryObjects.isEmpty()) return null;
		return binaryObjects.get(0).getValue();
	}

	@Override
	public String getAttachedDocumentMimeCode() {
		List<BinaryObjectType> binaryObjects = super.getAttachmentBinaryObject();
		if(binaryObjects.isEmpty()) return null;
		return binaryObjects.get(0).getMimeCode();
	}

	@Override
	public String getAttachedDocumentFilename() {
		List<BinaryObjectType> binaryObjects = super.getAttachmentBinaryObject();
		if(binaryObjects.isEmpty()) return null;
		return binaryObjects.get(0).getFilename();
	}

	// ReferenceTypeCode Kennung des Schemas BT-18-1
	private void setReferenceCode(String code) {
		if(code==null) return;
		ReferenceCodeType referenceCode = new ReferenceCodeType();
		referenceCode.setValue(code);
		super.setReferenceTypeCode(referenceCode);
	}
	
	// code ==  50 : isValidatedPricedTender() ==> BT-17
	// code == 130 : isInvoicingDataSheet()    ==> BT-18
	private void setDocumentCode(String code) {
		if(code==null) return;
		DocumentCodeType documentCode = new DocumentCodeType();
		documentCode.setValue(code);
		super.setTypeCode(documentCode);
	}
	private String getDocumentCode() {
		DocumentCodeType documentCode = super.getTypeCode();
		if(documentCode==null) {
			// ===> isPrecedingInvoice
			//super.getIssuerAssignedID()
			//super.getFormattedIssueDateTime();
		}
		return documentCode.getValue();
	}
	
	// BG-3.BT-25 ++ 1..1 Preceding Invoice reference / implements PrecedingInvoice
	@Override
	public Reference getDocumentReference() {
		return super.getIssuerAssignedID()==null ? null : new ID(getIssuerAssignedID());
	}
	@Override
	public void setDocumentReference(Reference docRefId) {
		super.setIssuerAssignedID((ID)docRefId);
	}

	// BG-3.BT-26 ++ 0..1 Preceding Invoice issue date / implements PrecedingInvoice
	@Override
	public Timestamp getDateAsTimestamp() {
		if(super.getFormattedIssueDateTime()==null) return null;
		FormattedDateTimeType dateTime = getFormattedIssueDateTime(); // FormattedDateTimeType
		return dateTime==null ? null : DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());		
	}
	@Override
	public void setDate(Timestamp ts) {
		if(ts==null) return;
		super.setFormattedIssueDateTime(DateTimeFormatStrings.toFormattedDateTime(ts));
	}

	boolean isPrecedingInvoice() {
		return (getDocumentCode()==null);
	}
	
//	Der Code  50 "Price/sales catalogue response" wird benutzt, 
//	um die Ausschreibung oder das Los zu referenzieren. (BT-17)
//	.  50 . Validated priced tender
	boolean isValidatedPricedTender() {
		return getDocumentCode().equals(DocumentNameCode.ValidatedPricedTender.getValueAsString());
	}
//	Der Code 130 "Rechnungsdatenblatt" wird benutzt, 
//	um eine vom Verkäufer angegebene Kennung für ein Objekt zu referenzieren. (BT-18)
//	. 130 . Invoicing data sheet / Rechnungsdatenblatt
	boolean isInvoicingDataSheet() {
		return getDocumentCode().equals(DocumentNameCode.InvoicingDataSheet.getValueAsString());
	}
//	Der Code 916 "Referenzpapier" wird benutzt, um die Kennung der rechnungsbegründenden Unterlage zu referenzieren. (BT-122)
//	. 916 . Related document / Referenzpapier
	boolean isRelatedDocument() {
		return getDocumentCode().equals(DocumentNameCode.RelatedDocument.getValueAsString());
	}
	
}
