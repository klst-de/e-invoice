package com.klst.marshaller;

import static javax.xml.bind.JAXBContext.newInstance;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

@Named
/* Notice 
 * that there are two @Singleton annotations, 
 * one in javax.inject and the other in the javax.ebj package. 
 * I'm referring to them by their fully-qualified names to avoid confusion.
 * @see https://stackoverflow.com/questions/26832051/singleton-vs-applicationscope
 * @see https://github.com/javax-inject/javax-inject
 */
@javax.inject.Singleton
public abstract class AbstactTransformer {

	public static AbstactTransformer SINGLETON = null;

	public static AbstactTransformer getInstance() {
		return SINGLETON;
	}

	final JAXBContext jaxbContext;
	
	// ctor
	protected AbstactTransformer(String contentPath) {
		try {
			this.jaxbContext = newInstance(contentPath);
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.JAXB_INSTANTIATE_ERROR, ex);
		}
	}

	public Validator getSchemaValidator() throws SAXException {
		return getSchemaValidator(getResource());
	}
	
	abstract <T> T toModel(InputStream xmlInputStream);
	
	<T extends Object> T toModel(InputStream xmlInputStream, Class<T> declaredType) {
		try {
			Unmarshaller unmarshaller = createUnmarshaller();
			return unmarshaller.unmarshal(new StreamSource(xmlInputStream), declaredType).getValue();
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.MARSHALLING_ERROR, ex);
		}
	}

	public byte[] fromModel(Object document) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16000);
		try {
			Marshaller marshaller = createMarshaller();
			marshaller.marshal(document, outputStream);
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.MARSHALLING_ERROR, ex);
		}
		return outputStream.toByteArray();
	}

	abstract String getResource();
	
	abstract Validator getSchemaValidator(String resource) throws SAXException;

	abstract NamespacePrefixMapper getNamespacePrefixMapper();
	
	// -- private
	
	private Unmarshaller createUnmarshaller() throws JAXBException {
		return jaxbContext.createUnmarshaller();
	}

	// override the default namespace prefixes ns1, ns2, ... created by the Marshaller.
	// @see http://hwellmann.blogspot.com/2011/03/jaxb-marshalling-with-custom-namespace.html
	private Marshaller createMarshaller() throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatXmlOutput());
		
		// see https://stackoverflow.com/questions/277996/remove-standalone-yes-from-generated-xml
//		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); 
//		marshaller.setProperty("com.sun.xml.internal.bind.xmlDeclaration", Boolean.FALSE);
//		marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		
		// see https://stackoverflow.com/questions/2161350/jaxb-xjc-code-generation-schemalocation-missing-in-xml-generated-by-marshall
//		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2 http://docs.oasis-open.org/ubl/os-UBL-2.1/xsd/maindoc/UBL-Invoice-2.1.xsd");
        try {
        	marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", getNamespacePrefixMapper());
        } catch(PropertyException ex) {
            // In case another JAXB implementation is used
			throw new TransformationException(TransformationException.NAMESPACE_PREFIX_MAPPER_ERROR, ex);
        }

		return marshaller;
	}

	protected Boolean formatXmlOutput() {
		return Boolean.TRUE;
	}

}
