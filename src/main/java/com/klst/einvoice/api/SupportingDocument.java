package com.klst.einvoice;

import java.sql.Timestamp;

import com.klst.edoc.api.Reference;

/*
 * used in
 * - at document level 
 * - BT-17 0..1 Tender or lot reference
 * - BT-18 0..1 Invoiced object identifier
 * - BG-24 0..n ADDITIONAL SUPPORTING DOCUMENTS
 * 
 * - at document line level:
 * - BG-25.BT-128 0..1 line object identifier
 */
/**
 * a common interface to BG-24 ADDITIONAL SUPPORTING DOCUMENTS,
 * BT-17 Tender or lot reference
 * and BT-18 Invoiced object identifier
 *
 * @see CoreInvoice#setTenderOrLotReference
 * @see CoreInvoice#setInvoicedObject
 * @see BG24_AdditionalSupportingDocs
 * @see CoreInvoiceLine#setLineObjectID(String, String, String)
 */
public interface SupportingDocument extends SupportingDocumentFactory {

	public void setDocumentCode(String code);
	public String getDocumentCode();
	
	public void setDate(Timestamp ts);
	public Timestamp getDateAsTimestamp();

	/**
	 * Additional supporting document reference
	 * <p>
	 * Cardinality:     1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-24.BT-122
	 * <br>Rule ID: 	BR-52: Each Additional supporting document (BG-24) shall contain a document reference (BT-122).
	 * 
	 * @param documentReference, an identifier of the supporting document.
	 */
	public void setDocumentReference(Reference documentReference);
	public Reference getDocumentReference();
	
	/**
	 * External document location
	 * <p>
	 * The URL (Uniform Resource Locator) that identifies where the external document is located.
	 * A means of locating the resource including its primary access mechanism, e.g. http:// or ftp://.
	 * 
	 * External document location shall be used if the Buyer requires additional information to support the document.
	 * External documents do not form part of the invoice. Risks can be involved when accessing external documents.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BG-24.BT-124
	 * <br>Rule ID: 	 
	 * 
	 * @param url
	 */
	public void setExternalDocumentLocation(String location);
	public String getExternalDocumentLocation();

	/*
	 * Additional supporting document line reference
	 * <p>
	 * Used in ADDITIONAL REFERENCED DOCUMENT (SpecifiedLineTradeAgreement)
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	
	 * <br>Rule ID: 	 
	 * <br>Order-X-No: 	144
	 * 
	 * @param lineReference
	 */
	public void setLineReference(Reference lineReference);
	public Reference getLineReference();

	/**
	 * Supporting document description
	 * <p>
	 * A description of the supporting document. Such as: timesheet, usage report etc.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BG-24.BT-123
	 * <br>Rule ID: 	 
	 * 
	 * @param text
	 */
	public void setSupportingDocumentDescription(String text);
	public String getSupportingDocumentDescription();

	/**
	 * Attached document
	 * An attached document embedded as binary object or sent together with the invoice.
	 * 
	 * Attached document is used when documentation shall be stored with the Invoice 
	 * for future reference or audit purposes.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BG-24.BT-125
	 * <br>Rule ID: 	 
	 * 
	 * @param doc      - binary content
	 * @param mimeCode - The mime code of the attached document
	 * @param filename - The file name of the attached document
	 */
	public void setAttachedDocument(byte[] doc, String mimeCode, String filename);
	public byte[] getAttachedDocument();
	public String getAttachedDocumentMimeCode();
	public String getAttachedDocumentFilename();

}
