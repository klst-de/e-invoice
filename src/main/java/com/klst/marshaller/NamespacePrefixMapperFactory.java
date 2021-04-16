package com.klst.marshaller;

import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/* in java 1.8 'NamespacePrefixMapper' is not in API (restriction on required library ... jdk1.8.0_241\jre\lib\rt.jar')
 * to compile in eclipse define access rule.
 * 
 * Proposal JEP-320(http://openjdk.java.net/jeps/320) to remove the Java EE and CORBA modules from the JDK.
 * In Java SE 11, the module has been removed. To use JAX-WS and JAXB you need to add them to your project as separate libraries.
 * 
 * @see https://jesperdj.com/2018/09/30/jaxb-on-java-9-10-11-and-beyond/
 */
//import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

public interface NamespacePrefixMapperFactory {

	/**
	 * override the default namespace prefixes ns1, ns2, ... created by the Marshaller.
	 * 
	 * use own NamespacePrefixMapper
	 * and set prop "com.sun.xml.bind.namespacePrefixMapper"
	 * 
	 * @see http://hwellmann.blogspot.com/2011/03/jaxb-marshalling-with-custom-namespace.html
	 * and
	 * 5.1. Changing prefixes in file:///C:/proj/jaxb-ri/docs/ch03.html#marshalling
	 * 
	 * @return own NamespacePrefixMapper
	 */
	default NamespacePrefixMapper createNamespacePrefixMapper() {
		return null;
	}
	
	default void registerNamespacePrefixMapper(Marshaller marshaller) {
		NamespacePrefixMapper namespacePrefixMapper = createNamespacePrefixMapper();
		if(namespacePrefixMapper==null) return;
        try {
        	marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", namespacePrefixMapper);
        } catch(PropertyException ex) {
            // In case another JAXB implementation is used
			throw new TransformationException(TransformationException.NAMESPACE_PREFIX_MAPPER_ERROR, ex);
        }
	}

}
