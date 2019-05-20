package com.klst.marshaller;

import java.io.InputStream;
import java.net.URL;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

@Named
@Singleton
public class UblTransformer extends AbstactTransformer {

	protected UblTransformer(String contentPath, AbstactTransformer instance) {
		super(contentPath, instance);
	}
	
	@Override
	String getResource() {
		return null;
	}

//	@Override // implements abstract
//	Validator getSchemaValidator(String resource) throws SAXException {
//		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//		URL schemaURL = this.getClass().getResource(resource);
//		Schema schema = sf.newSchema(schemaURL);
//		return schema.newValidator();
//	}

	@Override
	public <T> T toModel(InputStream xmlInputStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	NamespacePrefixMapper getNamespacePrefixMapper() {
		return new UblNamespacePrefixMapper();
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


