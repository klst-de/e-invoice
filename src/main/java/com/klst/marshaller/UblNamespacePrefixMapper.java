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
 
	private Map<String, String> namespaceMap = new HashMap<>();
 
	/**
	 * Create mappings.
	 */
	public UblNamespacePrefixMapper() {
		namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:Invoice-2", "ubl");
		namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2", "cac");
		namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", "cbc");
		namespaceMap.put("urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2", "cec"); // oder "ext" ?
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