package com.klst.einvoice;

import java.util.List;

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
 * <br>Rule ID: 	BR-52 Each Additional supporting document (BG-24) shall contain a Supporting document reference (BT-122).
 * <br>Request ID: 	R36 / multiple attached or referenced documents at document level
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 * @see SupportingDocument
 * @see SupportingDocumentFactory
 */
public interface BG24_AdditionalSupportingDocs extends SupportingDocumentFactory {

	public void addSupportigDocument(SupportingDocument supportigDocument);
	
	/**
	 * use this to add an attached document
	 * 
	 * @param docRefId    - document reference
	 * @param description - document description
	 * @param content     - Attached document content
	 * @param mimeCode
	 * @param filename
	 * 
	 * @see SupportingDocumentFactory#createSupportigDocument(String, com.klst.edoc.api.Reference, String, java.sql.Timestamp, byte[], String, String)
	 */
	default void addSupportigDocument(String docRefId, String description, byte[] content, String mimeCode, String filename) {
		addSupportigDocument(createSupportigDocument(docRefId, description, content, mimeCode, filename));
	}
	
	/**
	 * use this to add an External document
	 * 
	 * @param docRefId    - document reference
	 * @param description - document description
	 * @param uri         - External document location URI
	 * 
	 * @see SupportingDocumentFactory#createSupportigDocument(String, com.klst.edoc.api.Reference, String, java.sql.Timestamp, String)
	 */
	default void addSupportigDocument(String docRefId, String description, String uri) {
		addSupportigDocument(createSupportigDocument(docRefId, description, uri));
	}
	
	public List<SupportingDocument> getAdditionalSupportingDocuments();

}
