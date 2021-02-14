package com.klst.marshaller;

import java.io.InputStream;

import javax.inject.Named;
import javax.inject.Singleton;

// in java 1.8 'NamespacePrefixMapper' is not in API
// Proposal JEP-320(http://openjdk.java.net/jeps/320) to remove the Java EE and CORBA modules from the JDK.
// In Java SE 11, the module java.se.ee has been removed. To use JAX-WS and JAXB you need to add them to your project as separate libraries.
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;

@Named
/* Notice 
 * that there are two @Singleton annotations, 
 * one in javax.inject and the other in the javax.ebj package. 
 * I'm referring to them by their fully-qualified names to avoid confusion.
 * @see https://stackoverflow.com/questions/26832051/singleton-vs-applicationscope
 * @see https://github.com/javax-inject/javax-inject
 */
@Singleton
public class CiiTransformer extends AbstactTransformer {

	public static AbstactTransformer SINGLETON = new CiiTransformer();

	public static AbstactTransformer getInstance() {
		return SINGLETON;
	}
	
	// xsd file name in the output folder started with "/" == project_loc
	private static final String CII_100_XSD = "/cii/maindoc/CrossIndustryInvoice_100pD16B.xsd";
	// CONTENT_PATH aka package name
	private static final String CONTENT_PATH = "un.unece.uncefact.data.standard.crossindustryinvoice._100";
	
	private CiiTransformer() {
		super(CONTENT_PATH, SINGLETON);
	}
	
	@Override
	String getResource() {
		return CII_100_XSD;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> T toModel(InputStream xmlInputStream) {
		Object result = this.toModel(xmlInputStream, CrossIndustryInvoiceType.class);
		return (T) result;
	}

	// implements com.klst.marshaller.AbstactTransformer.getNamespacePrefixMapper
	@Override
	NamespacePrefixMapper getNamespacePrefixMapper() {
		return new CiiNamespacePrefixMapper();
	}

}
