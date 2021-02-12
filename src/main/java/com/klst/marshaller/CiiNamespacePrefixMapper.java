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

	/**
	 * REQUIREMENTS SPECIFICATION MAPPING for Cross Industry Invoice (CII)
	 * <p>
	 * CII is based on Supply Chain REFERENCE DATA MODEL (SCRDM)
	 */
	private static final String RSM="urn:un:unece:uncefact:data:standard:CrossIndustryInvoice:100";

	/**
	 * Reusable Aggregate Model for Aggregate Business Information Entities (ABIE)
	 */
	private static final String RAM="urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100";

	/**
	 * Unqualified Data Type
	 */
	private static final String UDT="urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100";
	
	/**
	 * Qualified Data Type
	 */
	private static final String QDT="urn:un:unece:uncefact:data:standard:QualifiedDataType:100";

	private Map<String, String> namespaceMap = new HashMap<>();
	 
	/**
	 * Create mappings.
	 */
	public CiiNamespacePrefixMapper() {
		namespaceMap.put(RSM, "rsm");
		namespaceMap.put(RAM, "ram");
		namespaceMap.put(UDT, "udt");
		namespaceMap.put(QDT, "qdt");
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
