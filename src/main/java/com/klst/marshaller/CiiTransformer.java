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

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;

@Named
@Singleton
public class CiiTransformer extends AbstactTransformer {

	public static AbstactTransformer SINGLETON = new CiiTransformer();

	public static AbstactTransformer getInstance() {
		return SINGLETON;
	}
	
	private static final String CI_INVOICE_100 = "/cii/maindoc/CrossIndustryInvoice_100pD16B.xsd";
	private static final String CONTENT_PATH = "un.unece.uncefact.data.standard.crossindustryinvoice._100";
	
	private CiiTransformer() {
		super(CONTENT_PATH, SINGLETON);
	}
	
	@Override
	String getResource() {
		return CI_INVOICE_100;
	}

	@Override // implements abstract
	Validator getSchemaValidator(String resource) throws SAXException {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		URL schemaURL = CiiTransformer.class.getResource(resource);
		Schema schema = sf.newSchema(schemaURL);
		return schema.newValidator();
	}

	@Override
	public <T extends Object> T toModel(InputStream xmlInputStream) {
		Object result = this.toModel(xmlInputStream, CrossIndustryInvoiceType.class);
		return (T) result;
	}

	@Override
	NamespacePrefixMapper getNamespacePrefixMapper() {
		return new CiiNamespacePrefixMapper();
	}

}
