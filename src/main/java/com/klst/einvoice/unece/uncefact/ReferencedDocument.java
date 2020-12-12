package com.klst.einvoice.unece.uncefact;

import java.util.List;

import com.klst.einvoice.BG24_AdditionalSupportingDocs;

import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.BinaryObjectType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

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

 */
public class ReferencedDocument extends ReferencedDocumentType implements BG24_AdditionalSupportingDocs {

	ReferencedDocument() {
		super();
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
	public ReferencedDocument(String docRefId, String code) {
		this();
		setSupportingDocumentReference(docRefId);
		setSupportingDocumentCode(code);
	}
	
	@Override
	public void setSupportingDocumentReference(String docRefId) {
		super.setIssuerAssignedID(new Identifier(docRefId));
	}

	@Override
	public String getSupportingDocumentReference() {
//		Identifier id = new Identifier(super.getIssuerAssignedID());
//		return id.getValue();
		// oder direkt:
		return super.getIssuerAssignedID().getValue();
	}

	// BG-24.BT-123 ++ 0..1 Supporting document description
	@Override
	public void setSupportingDocumentDescription(String text) {
		if(super.getName().isEmpty()) {
			super.getName().add(new Text(text));
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
		super.setURIID(new Identifier(locationUri));
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

	void setSupportingDocumentCode(String code) {
		if(code==null) return;
		DocumentCodeType documentCode = new DocumentCodeType();
		documentCode.setValue(code);
		super.setTypeCode(documentCode);
	}

	@Override
	public String getSupportingDocumentCode() {
		DocumentCodeType documentCode = super.getTypeCode();
		return documentCode==null? null : documentCode.getValue();
	}

}
