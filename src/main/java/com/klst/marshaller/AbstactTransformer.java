package com.klst.marshaller;

import static javax.xml.bind.JAXBContext.newInstance;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

@Named
/* Notice 
 * that there are two @Singleton annotations, 
 * one in javax.inject and the other in the javax.ebj package. 
 * I'm referring to them by their fully-qualified names to avoid confusion.
 * @see https://stackoverflow.com/questions/26832051/singleton-vs-applicationscope
 * @see https://github.com/javax-inject/javax-inject
 */
@javax.inject.Singleton
public abstract class AbstactTransformer implements NamespacePrefixMapperFactory {

	private static final Logger LOG = Logger.getLogger(AbstactTransformer.class.getName());
	
	final JAXBContext jaxbContext;
	
	// this is a SINGLETON! Use getInstance() in subclasses
	@SuppressWarnings("unused")
	private AbstactTransformer() {
		this.jaxbContext = null;
	}
	
	// ctor
	protected AbstactTransformer(String contentPath, AbstactTransformer instance) {
		LOG.fine("contentPath:"+contentPath);
		if(instance==null) try {
			System.setProperty(JAXBContext.JAXB_CONTEXT_FACTORY, "com.sun.xml.internal.bind.v2.ContextFactory");
			this.jaxbContext = newInstance(contentPath);
			LOG.finer("jaxbContext:\n"+jaxbContext.toString()); // displays path and Classes known to context
			instance = this;
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.JAXB_INSTANTIATE_ERROR, ex);
		} else {
			this.jaxbContext = instance.jaxbContext;
		}
	}

	public boolean isValid(File xmlfile) {
		String resource = getResource();
		try {
			Source xmlFile = new StreamSource(xmlfile);
			Validator validator = this.getSchemaValidator(); // throws SAXException, Exception
			validator.validate(xmlFile);
			LOG.config("validate against "+resource+" passed.");
		} catch (SAXException ex) {
			LOG.warning("validate against "+resource+" failed, SAXException: "+ex.getMessage());
			return false;
		} catch (Exception ex) {
			LOG.severe("validate "+ex.getMessage());
		}
		return true;
	}
	
	public Validator getSchemaValidator() throws SAXException {
		return getSchemaValidator(getResource());
	}
	
	public abstract <T> T toModel(InputStream xmlInputStream);
	
	<T extends Object> T toModel(InputStream xmlInputStream, Class<T> declaredType) {
		try {
			Unmarshaller unmarshaller = createUnmarshaller();
			LOG.info("try unmarshal to "+declaredType.getName());
			return unmarshaller.unmarshal(new StreamSource(xmlInputStream), declaredType).getValue();
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.MARSHALLING_ERROR, ex);
		}
	}

	abstract Class<?> loadClass();
	
	public byte[] fromModel(Object document) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16000);
		Class<?> type = loadClass();
		
		try {
			Marshaller marshaller = createMarshaller();
			marshaller.marshal(type.cast(document), outputStream);
			// REMARK objects that doesn't have @XmlRootElement on it:
			// - UBL InvoiceType and CreditNoteType
			// - CrossIndustryInvoiceType
			// see 5.3.3. Marshalling a non-element in file:///C:/proj/jaxb-ri/docs/ch03.html#marshalling
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.MARSHALLING_ERROR, ex);
		}
		
		return outputStream.toByteArray();
	}

	abstract String getResource();
	
	Validator getSchemaValidator(String resource) throws SAXException {
		LOG.fine("resource:"+resource + " Class:"+this.getClass());
		URL schemaURL = this.getClass().getResource(resource);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		LOG.finer("schemaURL:"+schemaURL);
		Schema schema = sf.newSchema(schemaURL);
		return schema.newValidator();
	}

	private Unmarshaller createUnmarshaller() throws JAXBException {
		return jaxbContext.createUnmarshaller();
	}

	/*
	 * some REMARKS on Properties:
	 * 
	 * https://stackoverflow.com/questions/277996/remove-standalone-yes-from-generated-xml
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); 
		marshaller.setProperty("com.sun.xml.internal.bind.xmlDeclaration", Boolean.FALSE);
		marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		
	 * https://stackoverflow.com/questions/2161350/jaxb-xjc-code-generation-schemalocation-missing-in-xml-generated-by-marshall
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2 http://docs.oasis-open.org/ubl/os-UBL-2.1/xsd/maindoc/UBL-Invoice-2.1.xsd");
		
	 *
	 */
	protected Marshaller createMarshaller() throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatXmlOutput());
		
		registerNamespacePrefixMapper(marshaller);

		return marshaller;
	}

	protected Boolean formatXmlOutput() {
		return Boolean.TRUE;
	}

}
