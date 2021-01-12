package com.klst.einvoice;

/**
 * BG-24 ADDITIONAL SUPPORTING DOCUMENTS
 * <p>
 * A group of business terms providing information about additional supporting documents substantiating the claims made in the Invoice.
 * <p>
 * The additional supporting documents can be used for both referencing a document number which is expected to be known by the receiver, 
 * an external document (referenced by a URL) or as an embedded document (such as a time report in pdf).
 * The option to link to an external document will be needed, for example in the case of large attachments and/or when sensitive information, 
 * e.g. person-related services, has to be separated from the Invoice itself.
 * <p>
 * Cardinality: 	0..n
 * <br>EN16931-ID: 	BG-24
 * <br>Rule ID: 	
 * <br>Request ID: 	R36 / multiple attached or referenced documents at document level
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */

/* Bsp 15:
UBL:
    <cac:AdditionalDocumentReference>
        <cbc:ID>01_15_Anhang_01.pdf</cbc:ID>
        <cbc:DocumentTypeCode>916</cbc:DocumentTypeCode>
        <cbc:DocumentDescription>Aufschlüsselung der einzelnen Leistungspositionen</cbc:DocumentDescription>
        <cac:Attachment>
            <cbc:EmbeddedDocumentBinaryObject mimeCode="application/pdf" filename="01_15_Anhang_01.pdf"> ... </cbc:EmbeddedDocumentBinaryObject>
        </cac:Attachment>
    </cac:AdditionalDocumentReference>
    
CII: ApplicableHeaderTradeAgreement ...
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
public interface BG24_AdditionalSupportingDocs {
	
	/**
	 * set business term BT-122 (mandatory): Supporting document reference
	 * <p>
	 * Business rule BR-52: Each Additional supporting document (BG-24) shall contain a 
	 *                      Supporting document reference (BT-122).
	 * @param id IssuerAssignedID, an identifier of the supporting document.
	 */
	public void setSupportingDocumentReference(String id);
	public String getSupportingDocumentReference();
	
	/**
	 * Supporting document description
	 * <p>
	 * A description of the supporting document. Such as: timesheet, usage report etc.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: 		BG-24.BT-123
	 * <br>Rule ID: 	 
	 * <br>Req.ID: 	R36
	 * 
	 * @param text
	 */
	public void setSupportingDocumentDescription(String text);
	public String getSupportingDocumentDescription();
	
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
	 * <br>ID: 		BG-24.BT-124
	 * <br>Rule ID: 	 
	 * <br>Req.ID: 	R36
	 * 
	 * @param url
	 */
	public void setExternalDocumentLocation(String location);
	public String getExternalDocumentLocation();
	
	/**
	 * Attached document
	 * An attached document embedded as binary object or sent together with the invoice.
	 * 
	 * Attached document is used when documentation shall be stored with the Invoice 
	 * for future reference or audit purposes.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: 		BG-24.BT-125
	 * <br>Rule ID: 	 
	 * <br>Req.ID:  R35
	 * 
	 * @param binary content BT-125
	 * @param mimeCode BT-125-1 The mime code of the attached document
	 * @param filename BT-125-2 The file name of the attached document
	 */
	public void setAttachedDocument(byte[] doc, String mimeCode, String filename);
	public byte[] getAttachedDocument();
	public String getAttachedDocumentMimeCode();
	public String getAttachedDocumentFilename();
	
}
