package com.klst.einvoice.ubl;

import java.sql.Timestamp;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.Reference;
import com.klst.edoc.untdid.DateTimeFormats;
import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.einvoice.PrecedingInvoice;
import com.klst.einvoice.SupportingDocument;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AttachmentType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ExternalReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DocumentTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EmbeddedDocumentBinaryObjectType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.URIType;

/*
 * used at document level 
 * <br>in BG-3  0..n PRECEDING INVOICE REFERENCE     typeCode==null
 * <br>in BT-17 0..1 Tender or lot reference         typeCode==50
 * <br>in BT-18 0..1 Invoiced object identifier      typeCode==130
 * <br>in BG-24 0..n ADDITIONAL SUPPORTING DOCUMENTS typeCode==916 or null
 * <p>
 * at document line level:
 * <br>in BG.25.BT-128 0..1 line object identifier

expl 01.15a-INVOICE_ubl.xml:

	<cac:AdditionalDocumentReference>
		<cbc:ID>OBJ999</cbc:ID>
		<cbc:DocumentTypeCode>130</cbc:DocumentTypeCode>  <!-- BT-18-0 -->
	</cac:AdditionalDocumentReference>

    <cac:AdditionalDocumentReference>
        <cbc:ID>01_15_Anhang_01.pdf</cbc:ID>
        <cbc:DocumentTypeCode>916</cbc:DocumentTypeCode>  <!-- BG-24-0 -->
        <cbc:DocumentDescription>Aufschlüsselung der einzelnen Leistungspositionen</cbc:DocumentDescription>
        <cac:Attachment>
            <cbc:EmbeddedDocumentBinaryObject mimeCode="application/pdf" filename="01_15_Anhang_01.pdf"> ... </cbc:EmbeddedDocumentBinaryObject>
        </cac:Attachment>
    </cac:AdditionalDocumentReference>

 */
public class DocumentReference extends DocumentReferenceType 
	implements SupportingDocument, PrecedingInvoice {

	// factory for BG-3 PRECEDING INVOICE REFERENCE
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		return create(docRefId, ts);
	}
	static DocumentReference create(String docRefId, Timestamp ts) {
		return new DocumentReference(docRefId, null, null, ts);
	}

	// factory for BG-24 ADDITIONAL SUPPORTING DOCUMENTS
	@Override
	public SupportingDocument createSupportigDocument(String docRefId, Reference lineId, String description, Timestamp ts, String uri) {
		DocumentReference rd = create(docRefId, lineId, description);
		rd.setExternalDocumentLocation(uri);
		return rd;
	}
	@Override
	public SupportingDocument createSupportigDocument(String docRefId, Reference lineId, String description, Timestamp ts
			, byte[] content, String mimeCode, String filename) {
		DocumentReference rd = create(docRefId, lineId, description);
		rd.setAttachedDocument(content, mimeCode, filename);
		return rd;
	}
	static DocumentReference create(String docRefId, Reference lineId, String description) {
		DocumentReference rd = new DocumentReference(docRefId, lineId, description, null);
		return rd;
	}

	// factory for
	// BT-17 0..1 Tender or lot reference
	// BT-18 0..1 (OBJECT IDENTIFIER FOR INVOICE)
	// BG-25.BT-128 : To be used for line object identifier (TypeCode value = 130)
	static DocumentReference create(String docRefId, String code, String referenceTypeCode) {
		return new DocumentReference(docRefId, code, referenceTypeCode);
	}

	// create a factory
	static DocumentReference create() {
		return new DocumentReference(null); 
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

	// copy ctor
	private DocumentReference(DocumentReferenceType doc) {
		if(doc!=null) {
			SCopyCtor.getInstance().invokeCopy(this, doc);
		}
	}

	private DocumentReference(String docRefId, Reference lineId, String description, Timestamp ts) {
//		setDocumentCode(DocumentNameCode.RelatedDocument.getValueAsString());
		setDocumentReference(new ID(docRefId));
		setLineReference(lineId);
		setSupportingDocumentDescription(description);
		setDate(ts);
	}
	
	private DocumentReference(String docRefId, String code, String referenceTypeCode) {
		setDocumentReference(new ID(docRefId));
		setDocumentCode(code);
		setReferenceCode(referenceTypeCode); // TODO BT-18-0:
		// in BG-25.BT-128 steht: 
		//super.setID(new ID(docRefId, null, referenceTypeCode));
		// etwa so
		ID id = new ID(docRefId);
		id.setSchemeID(referenceTypeCode);
		super.setID(id);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[DocumentCode:");
		stringBuilder.append(getDocumentCode()==null ? "null" : getDocumentCode());
		stringBuilder.append(", DocumentReference:");
		stringBuilder.append(getDocumentReference()==null ? "null" : getDocumentReference().getContent());
		stringBuilder.append(", SupportingDocumentDescription:");
		stringBuilder.append(getSupportingDocumentDescription()==null ? "null" : getSupportingDocumentDescription());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	//  BG-3.BT-25  1..1 Preceding Invoice reference
	// BG-24.BT-122 1..1 Supporting document reference
	@Override
	public void setDocumentReference(Reference documentReference) {
		// Reference extends Identifier
		if(documentReference!=null) super.setID((ID)documentReference);
	}
	@Override
	public Reference getDocumentReference() {
		return super.getID()==null ? null : new ID(super.getID());
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
		AttachmentType attachment = super.getAttachment();
		if(attachment==null) return null;
		
		ExternalReferenceType externalReference = attachment.getExternalReference();
		if(externalReference==null) return null;
		
		URIType uri = externalReference.getURI();
		if(uri==null) return null;
		
		return uri.getValue();
	}

	// document line reference
	@Override
	public void setLineReference(Reference lineReference) {
		// TODO
	}
	@Override
	public Reference getLineReference() {
		// TODO
		return null;
	}

	@Override
	public String getDocumentCode() {
		DocumentTypeCodeType documentCode = super.getDocumentTypeCode();
		if(documentCode==null) {
			// ===> isPrecedingInvoice ???
			return null;
		}
		return documentCode.getValue();
	}
	// code == 916 :"ADDITIONAL SUPPORTING DOCUMENTS" ==> BG-24
	// code ==  50 : isValidatedPricedTender() ==> BT-17
	// code == 130 : isInvoicingDataSheet()    ==> BT-18
	@Override
	public void setDocumentCode(String code) {
		if(code==null) return;
		DocumentTypeCodeType documentTypeCode = new DocumentTypeCodeType();
		documentTypeCode.setValue(code);
		super.setDocumentTypeCode(documentTypeCode);
	}
	boolean isRelatedDocument() {
		String typeCode = getDocumentCode();
		if(typeCode==null) return false;
		return typeCode.equals(DocumentNameCode.RelatedDocument.getValueAsString());
	}
	boolean isValidatedPricedTender() {
		String typeCode = getDocumentCode();
		if(typeCode==null) return false;
		return typeCode.equals(DocumentNameCode.ValidatedPricedTender.getValueAsString());
	}
/* 01.15a:
	<cac:AdditionalDocumentReference>
		<cbc:ID>OBJ999</cbc:ID>
		<cbc:DocumentTypeCode>130</cbc:DocumentTypeCode>  <!-- BT-18-0 -->
	</cac:AdditionalDocumentReference>
 */
	boolean isInvoicingDataSheet() {
		String typeCode = getDocumentCode();
		if(typeCode==null) return false;
		return typeCode.equals(DocumentNameCode.InvoicingDataSheet.getValueAsString());
	}

	// BG-24.BT-123 0..1 Supporting document description
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
		DocumentDescriptionType dd = super.getDocumentDescription().isEmpty() ? null : getDocumentDescription().get(0);	
		return dd==null ? null : dd.getValue();
	}

	// BG-24.BT-125 0..1 Attached document
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
	
	private EmbeddedDocumentBinaryObjectType getEmbeddedDocumentBinaryObject() {
		AttachmentType attachment = super.getAttachment();
		return attachment==null ? null : attachment.getEmbeddedDocumentBinaryObject();
	}

	// ReferenceTypeCode, Kennung des Schemas BT-18-1
	/*
	 * To be used for Object identifier (TypeCode value = 130)
	 * If it may be not clear for the receiver what scheme is used for the identifier,
	 * a conditional scheme identifier should be used that shall be chosen from the UNTDID 1153 code list entries.
	 */
	private void setReferenceCode(String code) {
		if(code==null) return;
//		TODO
	}
	public String getReferenceCode() {
		return null;
	}

	// BG-3.BT-26 0..1 Preceding Invoice issue date
	@Override
	public void setDate(Timestamp ts) {
		if(ts!=null) {
			IssueDateType date = new IssueDateType();
			date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
			super.setIssueDate(date);
		}
	}

	@Override
	public Timestamp getDateAsTimestamp() {
		if(super.getIssueDate()==null) return null;
		return DateTimeFormats.xmlGregorianCalendarToTs(getIssueDate().getValue());
	}

}
