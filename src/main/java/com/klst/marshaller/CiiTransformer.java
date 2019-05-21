package com.klst.marshaller;

import java.io.InputStream;

import javax.inject.Named;
import javax.inject.Singleton;

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
