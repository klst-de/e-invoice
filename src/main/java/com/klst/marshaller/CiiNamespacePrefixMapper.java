package com.klst.marshaller;

import java.util.HashMap;
import java.util.Map;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

//@see https://www.intertech.com/Blog/jaxb-tutorial-customized-namespace-prefixes-example-using-namespaceprefixmapper/
//@see http://hwellmann.blogspot.com/2011/03/jaxb-marshalling-with-custom-namespace.html
/**
* Implementation of {@link NamespacePrefixMapper} that maps the schema
* namespaces more to readable names. Used by the jaxb marshaller. Requires
* setting the property "com.sun.xml.bind.namespacePrefixMapper" to an instance
* of this class.
* <p>
* Requires dependency on JAXB implementation jars
* </p>
*/
public class CiiNamespacePrefixMapper extends NamespacePrefixMapper {

	private Map<String, String> namespaceMap = new HashMap<>();
	 
	/**
	 * Create mappings.
	 */
	public CiiNamespacePrefixMapper() {
		namespaceMap.put("urn:un:unece:uncefact:data:standard:CrossIndustryInvoice:100", "rsm");
		namespaceMap.put("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100", "ram");
		namespaceMap.put("urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100", "udt");
		namespaceMap.put("urn:un:unece:uncefact:data:standard:QualifiedDataType:100", "qdt");
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
