package com.klst.marshaller;

import java.util.HashMap;
import java.util.Map;

// @see https://dzone.com/articles/jaxb-and-namespace-prefixes
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

// @see https://www.intertech.com/Blog/jaxb-tutorial-customized-namespace-prefixes-example-using-namespaceprefixmapper/
// @see http://hwellmann.blogspot.com/2011/03/jaxb-marshalling-with-custom-namespace.html
/**
 * Implementation of {@link NamespacePrefixMapper} that maps the schema
 * namespaces more to readable names. Used by the jaxb marshaller. Requires
 * setting the property "com.sun.xml.bind.namespacePrefixMapper" to an instance
 * of this class.
 * <p>
 * Requires dependency on JAXB implementation jars
 * </p>
 */
public class UblNamespacePrefixMapper extends NamespacePrefixMapper {

	private static final String INVOICE="urn:oasis:names:specification:ubl:schema:xsd:Invoice-2";
	private static final String CREDITNOTE="urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2";
	
	/**
	 * shprt prefix for XML Namespace Common Aggregate Components
	 * <p>
	 * UBL ASBIEs (Association Business Information Entities) are substructures of a UBL document.
	 * Children of ASBIEs may be BBIEs or other ASBIEs, never ABIEs. 
	 * All UBL ASBIEs (and only UBL ASBIEs) are members as elements of the UBL 
	 * common aggregate components namespace, denoted in UBL schemas by the cac: prefix.
	 * 
	 * @see http://docs.oasis-open.org/ubl/os-UBL-2.1/UBL-2.1.pdf
	 */
	private static final String CAC="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2";
	
	/**
	 * shprt prefix for XML Namespace Common Basic Components
	 * <p>
	 * UBL BBIEs (Basic Business Information Entities) are the leaf nodes of every UBL document structure. 
	 * All UBL BBIE elements (and only UBL BBIE elements) are members of the UBL 
	 * common basic components namespace, conventionally denoted in UBL schemas by the cbc: prefix. 
	 */
	private static final String CBC="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2";
	
	/**
	 * shprt prefix for XML Namespace Common Extension Components
	 * <p>
	 * The Common Extension Components schema defines the extension structures that are used in all UBL 
	 * document types, providing metadata regarding the use of an extension embedded in a UBL document instance.
	 */
	private static final String CEC="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2";

	private Map<String, String> namespaceMap = new HashMap<>();
 
	/**
	 * Create mappings.
	 */
	public UblNamespacePrefixMapper() {
		namespaceMap.put(INVOICE, "ubl");
		namespaceMap.put(CREDITNOTE, "ubl");
		namespaceMap.put(CAC, "cac");
		namespaceMap.put(CBC, "cbc");
		namespaceMap.put(CEC, "cec"); // oder "ext" 
	}

	/* (non-Javadoc)
	 * Returning null when not found based on spec.
	 * @see com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
		return namespaceMap.getOrDefault(namespaceUri, suggestion);
	}
}