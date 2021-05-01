package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.List;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.Reference;
import com.klst.edoc.untdid.DateTimeFormats;
import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.einvoice.PrecedingInvoice;
import com.klst.einvoice.SupportingDocument;

import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.FormattedDateTimeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.ReferenceCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.BinaryObjectType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

/**
 * Objects of this class are used
 * <p>
 * at document level 
 * <br>in BG-3  0..n PRECEDING INVOICE REFERENCE     typeCode==null
 * <br>in BT-17 0..1 Tender or lot reference         typeCode==50
 * <br>in BT-18 0..1 Invoiced object identifier      typeCode==130
 * <br>in BG-24 0..n ADDITIONAL SUPPORTING DOCUMENTS typeCode==916
 * <p>
 * at document line level:
 * <br>in BG.25.BT-128 0..1 line object identifier
 * <p>
 * The super class {@code ReferencedDocumentType} contains
 * <blockquote><pre>
 *     protected IDType issuerAssignedID;                         // BG-24.BT-122, BG-3.BT-25
 *     protected IDType uriid;                                    // BG-24.BT-124
 *     protected DocumentStatusCodeType statusCode;
 *     protected IndicatorType copyIndicator;
 *     protected IDType lineID;                                   // BG.25.BT-128
 *     protected DocumentCodeType typeCode;                       // BG-24.BT-122-0
 *     protected IDType globalID;
 *     protected IDType revisionID;
 *     protected List<TextType> name;
 *     protected List<BinaryObjectType> attachmentBinaryObject;   // BG-24.BT-125
 *     protected List<TextType> information;
 *     protected ReferenceCodeType referenceTypeCode;
 *     protected List<TextType> sectionName;
 *     protected List<IDType> previousRevisionID;
 *     protected FormattedDateTimeType formattedIssueDateTime;    // BG-3.BT-26
 *     protected SpecifiedPeriodType effectiveSpecifiedPeriod;
 *     protected TradePartyType issuerTradeParty;
 *     protected List<SpecifiedBinaryFileType> attachedSpecifiedBinaryFile;
 * </pre></blockquote>
 * <p>
 * {@code uriid}, Xml name = "URIID" is used alternatively with {@code attachmentBinaryObject}.
 * <p>
 * {@code referenceTypeCode} is used only in {@code object identifier}.
 */
/*

ApplicableHeaderTradeAgreement:
 ...
            <ram:AdditionalReferencedDocument>
                <ram:IssuerAssignedID>01_15_Anhang_01.pdf</ram:IssuerAssignedID>
                <ram:TypeCode>916</ram:TypeCode>
                <ram:Name>Aufschlüsselung der einzelnen Leistungspositionen</ram:Name>
                <ram:AttachmentBinaryObject mimeCode="application/pdf" filename="01_15_Anhang_01.pdf"> ... </ram:AttachmentBinaryObject>
            </ram:AdditionalReferencedDocument>
            
0 .. n AdditionalReferencedDocument Rechnungsbegründende Unterlagen BG-24 
xs:sequence 
1 .. 1 IssuerAssignedID Dokumentenkennung                           BT-17, BT-18, BT-122
1 .. 1 TypeCode Typ des referenzierten Dokuments                    BT-17-0, BT-18-0, BT-122-0
0 .. 1 Name Beschreibung der rechnungsbegründenden Unterlage        BT-123
0 .. 1 AttachmentBinaryObject Anhangsdokument                       BT-125 
required mimeCode MIME-Code des Anhangsdokuments                    BT-125-1 
required filename Dateiname des Anhangsdokuments                    BT-125-2

 */
public class ReferencedDocument extends ReferencedDocumentType 
	implements SupportingDocument, PrecedingInvoice {

	// factory for BG-3 PrecedingInvoice
	@Override
	public PrecedingInvoice createPrecedingInvoiceReference(String docRefId, Timestamp ts) {
		return create(docRefId, ts);
	}
	static ReferencedDocument create(String docRefId, Timestamp ts) {
		ReferencedDocument rd = new ReferencedDocument(docRefId, (String)null, (String)null);
		rd.setDate(ts);
		return rd;
	}
	
	// factory
	@Override
	public SupportingDocument createSupportigDocument(String docRefId, Reference lineId, String description, Timestamp ts, String uri) {
		ReferencedDocument rd = create(docRefId, lineId, description);
		rd.setExternalDocumentLocation(uri);
		return rd;
	}
	@Override
	public SupportingDocument createSupportigDocument(String docRefId, Reference lineId, String description, Timestamp ts
			, byte[] content, String mimeCode, String filename) {
		ReferencedDocument rd = create(docRefId, lineId, description);
		rd.setAttachedDocument(content, mimeCode, filename);
		return rd;
	}

	static ReferencedDocument create(String docRefId, Reference lineId, String description) {
		ReferencedDocument rd = new ReferencedDocument(docRefId, lineId, description);
		return rd;
	}

	// factory for
	// BT-17 0..1 Tender or lot reference
	// BT-18 0..1 (OBJECT IDENTIFIER FOR INVOICE)
	// BG.25.BT-128 : To be used for line object identifier (TypeCode value = 130)
	static ReferencedDocument create(String docRefId, String code, String referenceTypeCode) {
		return new ReferencedDocument(docRefId, code, referenceTypeCode);
	}

	// create a factory
	static ReferencedDocument create() {
		return new ReferencedDocument(null); 
	}
	// copy factory
	static ReferencedDocument create(ReferencedDocumentType object) {
		if(object instanceof ReferencedDocumentType && object.getClass()!=ReferencedDocumentType.class) {
			// object is instance of a subclass of ReferencedDocumentType, but not ReferencedDocumentType itself
			return (ReferencedDocument)object;
		} else {
			return new ReferencedDocument(object); 
		}
	}

	// copy ctor
	private ReferencedDocument(ReferencedDocumentType object) {
		if(object!=null) {
			SCopyCtor.getInstance().invokeCopy(this, object);
		}
	}

	private ReferencedDocument(String docRefId, Reference lineId, String description) {
		setDocumentCode(DocumentNameCode.RelatedDocument.getValueAsString());
		setDocumentReference(new ID(docRefId));
		setLineReference(lineId);
		setSupportingDocumentDescription(description);
	}

	private ReferencedDocument(String docRefId, String code, String referenceTypeCode) {
		setDocumentReference(new ID(docRefId));
		setDocumentCode(code);
		setReferenceCode(referenceTypeCode);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[DocumentCode:");
		stringBuilder.append(getDocumentCode()==null ? "null" : getDocumentCode());
		stringBuilder.append(", DocumentReference:");
		stringBuilder.append(getDocumentReference()==null ? "null" : getDocumentReference());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	// BG-3.BT-25   1..1 Preceding Invoice reference / implements PrecedingInvoice
	// BG-24.BT-122 1..1 Supporting document reference
	@Override
	public void setDocumentReference(Reference documentReference) {
		// Reference extends Identifier
		if(documentReference!=null) super.setIssuerAssignedID((ID)documentReference);
	}
	@Override
	public Reference getDocumentReference() {
		return super.getIssuerAssignedID()==null ? null : new ID(super.getIssuerAssignedID());
	}

	// BG-24.BT-124 0..1 External document location
	// in CII abgebildet auf ram:URIID , test Bsp 03.03a
	@Override
	public void setExternalDocumentLocation(String locationUri) {
		if(locationUri==null) return;
		super.setURIID(new ID(locationUri));	
	}
	@Override
	public String getExternalDocumentLocation() {
		return super.getURIID()==null? null : getURIID().getValue();
	}

	// document line reference
	@Override
	public void setLineReference(Reference lineReference) {
		if(lineReference!=null) super.setLineID((ID)lineReference);
	}
	@Override
	public Reference getLineReference() {
		return super.getLineID()==null ? null : new ID(super.getLineID());		
	}

	@Override
	public String getDocumentCode() {
		DocumentCodeType documentCode = super.getTypeCode();
		if(documentCode==null) {
			// ===> isPrecedingInvoice
			//super.getIssuerAssignedID()
			//super.getFormattedIssueDateTime();
		}
		return documentCode.getValue();
	}
	// code == 916 :"ADDITIONAL SUPPORTING DOCUMENTS" ==> BG-24
	// code ==  50 : isValidatedPricedTender() ==> BT-17
	// code == 130 : isInvoicingDataSheet()    ==> BT-18
	@Override
	public void setDocumentCode(String code) {
//		Mapper.set(this, "typeCode", code);   // TODO mapper!!!!
		if(code==null) return;
		DocumentCodeType documentCode = new DocumentCodeType();
		documentCode.setValue(code);
		super.setTypeCode(documentCode);
	}
//	Der Code 916 "Referenzpapier" wird benutzt, um die Kennung der rechnungsbegründenden Unterlage zu referenzieren. (BT-122)
//	. 916 . Related document / Referenzpapier
	boolean isRelatedDocument() {
		String typeCode = getDocumentCode();
		if(typeCode==null) return false;
		return typeCode.equals(DocumentNameCode.RelatedDocument.getValueAsString());
	}
//	Der Code  50 "Price/sales catalogue response" wird benutzt, um die Ausschreibung oder das Los zu referenzieren. (BT-17)
//	.  50 . Validated priced tender
	boolean isValidatedPricedTender() {
		String typeCode = getDocumentCode();
		if(typeCode==null) return false;
		return typeCode.equals(DocumentNameCode.ValidatedPricedTender.getValueAsString());
	}
//	Der Code 130 "Rechnungsdatenblatt" wird benutzt, um eine vom Verkäufer angegebene Kennung für ein Objekt zu referenzieren. (BT-18)
//	. 130 . Invoicing data sheet / Rechnungsdatenblatt
	boolean isInvoicingDataSheet() {
		String typeCode = getDocumentCode();
		if(typeCode==null) return false;
		return typeCode.equals(DocumentNameCode.InvoicingDataSheet.getValueAsString());
	}

	// BG-24.BT-123 0..1 Supporting document description
	@Override
	public void setSupportingDocumentDescription(String text) {
//		Mapper.set(this, "name", text);
		if(text==null) return;
		if(super.getName().isEmpty()) {
			super.getName().add(Text.create(text));
		} else {
			super.getName().get(0).setValue(text);
		}
	}
	@Override
	public String getSupportingDocumentDescription() {
//		return super.getName()==null ? null : getName().getValue(); // CIO
		// in CII ist es eine Liste, hole erstes element
		List<TextType> texts = super.getName();
		return texts.isEmpty()? null : texts.get(0).getValue();
	}

	// BG-24.BT-125 0..1 Attached document
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

	// ReferenceTypeCode, Kennung des Schemas BT-18-1
	/*
	 * To be used for Object identifier (TypeCode value = 130)
	 * If it may be not clear for the receiver what scheme is used for the identifier,
	 * a conditional scheme identifier should be used that shall be chosen from the UNTDID 1153 code list entries.
	 */
	private void setReferenceCode(String code) {
		if(code==null) return;
		ReferenceCodeType referenceCode = new ReferenceCodeType();
//		referenceCode.setValue(ReferenceTypeCodeContentType.fromValue(code)); // CIO
		referenceCode.setValue(code);
		super.setReferenceTypeCode(referenceCode);
	}
	public String getReferenceCode() {
//		return super.getReferenceTypeCode().getValue().value(); // CIO
		return super.getReferenceTypeCode().getValue();
	}

	// BG-3.BT-26 0..1 Preceding Invoice issue date / implements PrecedingInvoice
	// Timestamp for the issuance
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
	
}
