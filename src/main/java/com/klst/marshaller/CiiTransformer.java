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

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;

@Named
@Singleton
public class CiiTransformer {

	private static final Logger LOG = Logger.getLogger(CiiTransformer.class.getName());

	private static final String CI_INVOICE_100 = "/cii/maindoc/CrossIndustryInvoice_100pD16B.xsd";
	private static final String CONTENT_PATH = "un.unece.uncefact.data.standard.crossindustryinvoice._100";

	private final JAXBContext jaxbContext;

	public CiiTransformer() {
		LOG.info("ctor");
		try {
			this.jaxbContext = newInstance(CONTENT_PATH);
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.JAXB_INSTANTIATE_ERROR, ex);
		}
	}

	CiiTransformer(JAXBContext jaxbContext) {
		this.jaxbContext = jaxbContext;
	}

	public Validator getSchemaValidator() throws SAXException {
		return getSchemaValidator(CI_INVOICE_100);
	}
	
	Validator getSchemaValidator(String resource) throws SAXException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		URL schemaURL = CiiTransformer.class.getResource(resource);
		Schema schema = sf.newSchema(schemaURL);
		return schema.newValidator();
	}

	public CrossIndustryInvoiceType toModel(InputStream xmlInputStream) {
		LOG.info("toModel returns CrossIndustryInvoiceType, the root Object from xmlInputStream="+xmlInputStream);
		try {
			Unmarshaller unmarshaller = createUnmarshaller();
			return unmarshaller.unmarshal(new StreamSource(xmlInputStream), CrossIndustryInvoiceType.class).getValue();
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.MARSHALLING_ERROR, ex);
		}
	}

	public byte[] fromModel(CrossIndustryInvoiceType invoice) {
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

	private Marshaller createMarshaller() throws JAXBException {
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, formatXmlOutput());
		
        try {
        	marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new CiiNamespacePrefixMapper());
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
