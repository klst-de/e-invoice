package com.klst.ubl;

import java.util.ArrayList;
import java.util.List;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AttachmentType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExternalReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EmbeddedDocumentBinaryObjectType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.URIType;
import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.BinaryObjectType;

/* ADDITIONAL SUPPORTING DOCUMENTS             BG-24                       0..*  
 * 
 * Eine Gruppe von Informationselementen mit Informationen über rechnungsbegründende Unterlagen, 
 * die Belege für die in der Rechnung gestellten Ansprüche enthalten.
 * 
 * Anmerkung: Die Gruppe kann verwendet werden, um auf eine dem Erwerber bekannte Dokumentennummer 
 * oder ein externes Dokument (referenziert über eine URL als separat herunterladbare Ressource) 
 * oder ein eingebettetes Dokument (wie z. B. ein Leistungsnachweis als pdf) zu referenzieren. 
 * Von der Möglichkeit der Trennung von Rechnung und rechnungsbegründenden Unterlagen
 * kann insbesondere im Fall großer Anlagen oder sensibler Daten Gebrauch gemacht werden.
 * 
 * Supporting document reference               BT-122   Document Reference 1
 * Supporting document description             BT-123                 Text 0..1
 * External document location                  BT-124                 Text 0..1
 * Attached document                           BT-125        Binary Object 0..1
 * Attached document/Attached document Mime code                           1
 * Attached document/Attached document Filename                            1
 * 
 */
public class AdditionalSupportingDocument extends DocumentReferenceType { // TODO implements ...

	AdditionalSupportingDocument() {
		super();
	}
	
	// copy ctor
	public AdditionalSupportingDocument(DocumentReferenceType documentReference) {
		this();
		setID(documentReference.getID());
		addDocumentDescription(documentReference);
		setAttachment(documentReference.getAttachment());
	}

	/*
	 * 
	 * @param Supporting document reference id, madatory
	 * @param description, optional
	 */
	public AdditionalSupportingDocument(String id, String description) {
		this();
		IDType mID = new IDType();
		mID.setValue(id);
		setID(mID);
		addDocumentDescription(description);
	}

	public String getId() {
		return getId(this);
	}
	static String getId(DocumentReferenceType documentReference) {
		return documentReference.getID().getValue();
	}

	List<DocumentDescriptionType> addDocumentDescription(DocumentReferenceType documentReference) {
		List<DocumentDescriptionType> documentDescription = documentReference.getDocumentDescription();
		List<DocumentDescriptionType> dd = this.getDocumentDescription();
		documentDescription.forEach(description -> {
			dd.add(description);
		});
		return dd;
	}
	
	List<DocumentDescriptionType> addDocumentDescription(List<String> descriptions) {
		descriptions.forEach(description -> {
			addDocumentDescription(description);
		});
		return addDocumentDescription((String)null);
	}

	List<DocumentDescriptionType> addDocumentDescription(String description) {
		List<DocumentDescriptionType> documentDescription = super.getDocumentDescription();
		DocumentDescriptionType dd = new DocumentDescriptionType();
		dd.setValue(description);
		documentDescription.add(dd);
		return documentDescription;
	}

	public List<String> getDescriptions() {
		List<DocumentDescriptionType> documentDescription = super.getDocumentDescription();
		List<String> result = new ArrayList<String>(documentDescription.size());
		documentDescription.forEach(description -> {
			result.add(description.getValue());
		});
		return result;
	}
	
	public String getFirstDescription() {
		List<DocumentDescriptionType> documentDescription = super.getDocumentDescription();
		if(documentDescription.isEmpty()) {
			return null;
		}
		return documentDescription.get(0).getValue();
	}

	/**
	 * External document location
	 * <p>
	 * The URL (Uniform Resource Locator) that identifies where the external document is located.
	 * A means of locating the resource including its primary access mechanism, e.g. http:// or ftp://.
	 * 
	 * External document location shall be used if the Buyer requires additional information to support the Invoice.
	 * External documents do not form part of the invoice. Risks can be involved when accessing external documents.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-124
	 * <br>Req.ID: R36
	 * 
	 * @param url
	 */
	public void setExternalDocumentLocation(String url) {
		URIType uri = new URIType();
		uri.setValue(url);
		ExternalReferenceType externalReference = new ExternalReferenceType();
		externalReference.setURI(uri);
		AttachmentType attachment = new AttachmentType();
		attachment.setExternalReference(externalReference);
		super.setAttachment(attachment);
	}
	
	public String getExternalDocumentLocation() {
		AttachmentType attachment = super.getAttachment();
		if(attachment==null) return null;
		
		ExternalReferenceType externalReference = attachment.getExternalReference();
		if(externalReference==null) return null;
		
		URIType uri = externalReference.getURI();
		if(uri==null) return null;
		
		return uri.getValue();
	}

	/**
	 * Attached document
	 * An attached document embedded as binary object or sent together with the invoice.
	 * 
	 * Attached document is used when documentation shall be stored with the Invoice 
	 * for future reference or audit purposes.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-125
	 * <br>Req.ID: R35
	 * 
	 * @param uncefact binaryObject
	 */
	public void setAttachedDocument(BinaryObjectType binaryObject) {
		String mimeCode = binaryObject.getMimeCode(); // mandatory
		String filename = binaryObject.getFilename(); // mandatory
		byte[] value = binaryObject.getValue(); // content
		EmbeddedDocumentBinaryObjectType embeddedDocumentBinaryObject = new EmbeddedDocumentBinaryObjectType();
		embeddedDocumentBinaryObject.setMimeCode(mimeCode);
		embeddedDocumentBinaryObject.setFilename(filename);
		embeddedDocumentBinaryObject.setValue(value);
		AttachmentType attachment = new AttachmentType();
		attachment.setEmbeddedDocumentBinaryObject(embeddedDocumentBinaryObject);
		super.setAttachment(attachment);
	}
	
	public BinaryObjectType getAttachedDocument() {
		AttachmentType attachment = super.getAttachment();
		if(attachment==null) return null;

		return attachment.getEmbeddedDocumentBinaryObject();
	}

}
