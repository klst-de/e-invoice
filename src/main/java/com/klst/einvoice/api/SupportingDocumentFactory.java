package com.klst.einvoice.api;

import java.sql.Timestamp;

import com.klst.edoc.api.Reference;

public interface SupportingDocumentFactory {

	/**
	 * use this to create an External document reference
	 * 
	 * @param docRefId    - document reference ID
	 * @param lineId      - document Line ID
	 * @param description - document description
	 * @param ts          - Timestamp for the issuance
	 * @param uri         - location URI
	 * @return
	 * 
	 * @see BG24_AdditionalSupportingDocs
	 */
	public SupportingDocument createSupportigDocument(String docRefId, Reference lineId, String description, Timestamp ts, String uri);
	default SupportingDocument createSupportigDocument(String docRefId, String description, String uri) {
		return createSupportigDocument(docRefId, null, description, null, uri);
	}

	/**
	 * use this to create an attached document reference
	 * 
	 * @param docRefId    - document reference ID
	 * @param lineId      - document Line ID
	 * @param description - document description
	 * @param ts          - Timestamp for the issuance
	 * @param content     - Attached document content
	 * @param mimeCode
	 * @param filename
	 * @return
	 * 
	 * @see BG24_AdditionalSupportingDocs
	 */
	public SupportingDocument createSupportigDocument(String docRefId, Reference lineId, String description, Timestamp ts
			, byte[] content, String mimeCode, String filename);
	default SupportingDocument createSupportigDocument(String docRefId, String description
			, byte[] content, String mimeCode, String filename) {
		return createSupportigDocument(docRefId, null, description, null, content, mimeCode, filename);		
	}

}
