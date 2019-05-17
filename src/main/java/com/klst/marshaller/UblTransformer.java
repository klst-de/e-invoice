package com.klst.marshaller;

import static javax.xml.bind.JAXBContext.newInstance;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

@Named
@Singleton
public class UblTransformer {
	
	private static final Logger LOG = Logger.getLogger(UblTransformer.class.getName());

	private static final String UBL_INVOICE_XSD_21 = "/ubl/maindoc/UBL-Invoice-2.1.xsd";
	private static final String CONTENT_PATH = "oasis.names.specification.ubl.schema.xsd.invoice_2";

	private final JAXBContext jaxbContext;
	
	public UblTransformer() {
		LOG.info("ctor");
		try {
			this.jaxbContext = newInstance(CONTENT_PATH);
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.JAXB_INSTANTIATE_ERROR, ex);
		}
	}

	UblTransformer(JAXBContext jaxbContext) {
		this.jaxbContext = jaxbContext;
	}

	public Validator getSchemaValidator() throws SAXException {
		return getSchemaValidator(UBL_INVOICE_XSD_21);
	}
	
	public Validator getSchemaValidator(String resource) throws SAXException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		URL schemaURL = UblTransformer.class.getResource(resource);
		Schema schema = sf.newSchema(schemaURL);
		return schema.newValidator();
	}

	public InvoiceType toModel(InputStream xmlInputStream) {
		LOG.info("toModel returns InvoiceType, the root Object from xmlInputStream="+xmlInputStream);
		try {
			Unmarshaller unmarshaller = createUnmarshaller();
			return unmarshaller.unmarshal(new StreamSource(xmlInputStream), InvoiceType.class).getValue();
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.MARSHALLING_ERROR, ex);
		}
	}
	
	public byte[] fromModel(InvoiceType invoice) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16000);
		try {
			Marshaller marshaller = createMarshaller();
			marshaller.marshal(invoice, outputStream);
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.MARSHALLING_ERROR, ex);
		}
		return outputStream.toByteArray();
	}

	
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
		marshaller.setProperty("com.sun.xml.internal.bind.xmlDeclaration", Boolean.FALSE);
		marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		
		// see https://stackoverflow.com/questions/2161350/jaxb-xjc-code-generation-schemalocation-missing-in-xml-generated-by-marshall
		marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2 http://docs.oasis-open.org/ubl/os-UBL-2.1/xsd/maindoc/UBL-Invoice-2.1.xsd");
		
        try {
        	marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new UblNamespacePrefixMapper());
        } catch(PropertyException ex) {
            // In case another JAXB implementation is used
			throw new TransformationException(TransformationException.NAMESPACE_PREFIX_MAPPER_ERROR, ex);
        }
		return marshaller;
	}

	protected Boolean formatXmlOutput() {
		return Boolean.TRUE;
	}

	// -----------------
//	public static void main(String[] args) throws Exception {
//		UblTransformer transformer = new UblTransformer();
//		Marshaller marshaller = transformer.createMarshaller();
//		InvoiceType invoiceType = new InvoiceType();
//
//		marshaller.marshal(invoiceType, System.out);
//	}
	 
}


