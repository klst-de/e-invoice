package com.klst.einvoice.ubl;

import com.klst.einvoice.BG24_AdditionalSupportingDocs;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AttachmentType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExternalReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EmbeddedDocumentBinaryObjectType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.URIType;

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
public class AdditionalSupportingDocument extends DocumentReferenceType implements BG24_AdditionalSupportingDocs {

	// copy ctor
	public AdditionalSupportingDocument(DocumentReferenceType doc) {
		super();
		EmbeddedDocumentBinaryObjectType embeddedDocumentBinaryObject = getEmbeddedDocumentBinaryObject(doc);
		if(embeddedDocumentBinaryObject==null) {
			init(getId(doc), getSupportingDocumentDescription(doc), getExternalDocumentLocation(doc));
		} else {
			init(getId(doc), getSupportingDocumentDescription(doc), null);
			setAttachedDocument(embeddedDocumentBinaryObject.getValue(), embeddedDocumentBinaryObject.getMimeCode(), embeddedDocumentBinaryObject.getFilename());
		}
	}

	public AdditionalSupportingDocument(String docRefId, String description, byte[] content, String mimeCode, String filename) {
		super();
		init(docRefId, description, null);
		setAttachedDocument(content, mimeCode, filename);
	}
	
	/**
	 * 
	 * @param Supporting document reference id, madatory
	 * @param description, optional
	 * @param url, optional
	 */
	public AdditionalSupportingDocument(String docRefId, String description, String url) {
		super();
		init(docRefId, description, url);
	}
	
	void init(String docRefId, String description, String url) {
		setSupportingDocumentReference(docRefId);
		setSupportingDocumentDescription(description);
		setExternalDocumentLocation(url);
	}

	// BG.24.BT-122
	@Override
	public void setSupportingDocumentReference(String id) {
		super.setID(new ID(id));
	}

	@Override
	public String getSupportingDocumentReference() {
		return getId(this);
	}
	static String getId(DocumentReferenceType documentReference) {
		return documentReference.getID().getValue();
	}

	// BG.24.BT-123 ++ 0..1 Supporting document description
	@Override
	public void setSupportingDocumentDescription(String text) {
		if(text!=null) {
			DocumentDescriptionType documentDescription = new DocumentDescriptionType();
			documentDescription.setValue(text);
			super.getDocumentDescription().add(documentDescription);
		}
	}

	@Override
	public String getSupportingDocumentDescription() {
		return getSupportingDocumentDescription(this);
	}
	static String getSupportingDocumentDescription(DocumentReferenceType documentReference) {
		return documentReference.getDocumentDescription().isEmpty() ? null : documentReference.getDocumentDescription().get(0).getValue();
	}

	/*
	 * Hinweis: Ein Mittel zur Auffindung der Ressource einschließlich des dafür vorgesehenen primären 
	 * Zugangsverfahrens, z. B. http:// oder ftp://.
	 * Der Speicherort des externen Dokuments muss dann verwendet werden, 
	 * wenn der Käufer weitere Informationen als Belege für die in Rechnung gestellten Beträge benötigt.
	 * Externe Dokumente sind nicht Bestandteil der Rechnung. 
	 * Der Zugriff auf externe Dokumente kann gewisse Risiken bergen.

Bsp.: ubl-tc434-example2.xml :

    <cac:AdditionalDocumentReference>
        <cbc:ID>Doc1</cbc:ID>
        <cbc:DocumentDescription>Timesheet</cbc:DocumentDescription>
        <cac:Attachment>
            <cac:ExternalReference>
                <cbc:URI>http://www.suppliersite.eu/sheet001.html</cbc:URI>
            </cac:ExternalReference>
        </cac:Attachment>
    </cac:AdditionalDocumentReference>

	 */
	// BT-124 ++ 0..1 External document location
	@Override
	public void setExternalDocumentLocation(String url) {
		if(url==null) return;
		URIType uri = new URIType();
		uri.setValue(url);
		ExternalReferenceType externalReference = new ExternalReferenceType();
		externalReference.setURI(uri);
		AttachmentType attachment = new AttachmentType();
		attachment.setExternalReference(externalReference);
		super.setAttachment(attachment);
	}
	
	@Override
	public String getExternalDocumentLocation() {
		return getExternalDocumentLocation(this);
	}
	static String getExternalDocumentLocation(DocumentReferenceType documentReference) {
		AttachmentType attachment = documentReference.getAttachment();
		if(attachment==null) return null;
		
		ExternalReferenceType externalReference = attachment.getExternalReference();
		if(externalReference==null) return null;
		
		URIType uri = externalReference.getURI();
		if(uri==null) return null;
		
		return uri.getValue();
	}

	// BT-125 ++ 0..1 Attached document
	@Override
	public void setAttachedDocument(byte[] content, String mimeCode, String filename) {
		EmbeddedDocumentBinaryObjectType embeddedDocumentBinaryObject = new EmbeddedDocumentBinaryObjectType();
		embeddedDocumentBinaryObject.setMimeCode(mimeCode);
		embeddedDocumentBinaryObject.setFilename(filename);
		embeddedDocumentBinaryObject.setValue(content);
		AttachmentType attachment = new AttachmentType();
		attachment.setEmbeddedDocumentBinaryObject(embeddedDocumentBinaryObject);
		super.setAttachment(attachment);
	}
	
	@Override
	public byte[] getAttachedDocument() {
		EmbeddedDocumentBinaryObjectType embeddedDocumentBinaryObject = getEmbeddedDocumentBinaryObject();
		return embeddedDocumentBinaryObject==null ? null : embeddedDocumentBinaryObject.getValue();
	}
	@Override
	public String getAttachedDocumentMimeCode() {
		EmbeddedDocumentBinaryObjectType embeddedDocumentBinaryObject = getEmbeddedDocumentBinaryObject();
		return embeddedDocumentBinaryObject==null ? null : embeddedDocumentBinaryObject.getMimeCode();
	}
	@Override
	public String getAttachedDocumentFilename() {
		EmbeddedDocumentBinaryObjectType embeddedDocumentBinaryObject = getEmbeddedDocumentBinaryObject();
		return embeddedDocumentBinaryObject==null ? null : embeddedDocumentBinaryObject.getFilename();
	}
	
	EmbeddedDocumentBinaryObjectType getEmbeddedDocumentBinaryObject() {
		return getEmbeddedDocumentBinaryObject(this);
	}
	static EmbeddedDocumentBinaryObjectType getEmbeddedDocumentBinaryObject(DocumentReferenceType documentReference) {
		AttachmentType attachment = documentReference.getAttachment();
		if(attachment==null) return null;

		return attachment.getEmbeddedDocumentBinaryObject();
	}

}
