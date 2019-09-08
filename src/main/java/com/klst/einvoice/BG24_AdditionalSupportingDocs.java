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
 * <br>Request ID: 	R36
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
CII:
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
// TODO Idee runter zu ubl und cii und public raus ?!
public interface BG24_AdditionalSupportingDocs {
	
	// BT-122 ++ 1..1 Supporting document reference
//	public void setSupportingDocumentReference(String id);
//	public String getSupportingDocumentReference();
	
	// BT-123 ++ 0..1 Supporting document description
//	public void setSupportingDocumentDescription(String text);
//	public String getSupportingDocumentDescription();
	
	// BT-124 ++ 0..1 External document location
//	public void setExternalDocumentLocation(String location);
//	public String getExternalDocumentLocation();
	
	// BT-125 ++ 0..1 Attached document
//	public void setAttachedDocument(byte[] doc, String mimeCode, String filename);
//	public byte[] getAttachedDocument();
//	public String getAttachedDocumentMimeCode();
//	public String getAttachedDocumentFilename();
	
}
