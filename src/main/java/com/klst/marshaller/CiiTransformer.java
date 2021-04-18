package com.klst.marshaller;

import java.io.InputStream;

import javax.inject.Named;

/* in java 1.8 'NamespacePrefixMapper' is not in API (restriction on required library ... jdk1.8.0_241\jre\lib\rt.jar')
 * to compile in eclipse define access rule.
 * 
 * Proposal JEP-320(http://openjdk.java.net/jeps/320) to remove the Java EE and CORBA modules from the JDK.
 * In Java SE 11, the module has been removed. To use JAX-WS and JAXB you need to add them to your project as separate libraries.
 * 
 * @see https://jesperdj.com/2018/09/30/jaxb-on-java-9-10-11-and-beyond/
 */
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
//import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

@Named
/* Notice 
 * that there are two @Singleton annotations, 
 * one in javax.inject and the other in the javax.ebj package. 
 * I'm referring to them by their fully-qualified names to avoid confusion.
 * @see https://stackoverflow.com/questions/26832051/singleton-vs-applicationscope
 * @see https://github.com/javax-inject/javax-inject
 */
@javax.inject.Singleton
public class CiiTransformer extends AbstactTransformer {

	public static AbstactTransformer SINGLETON = new CiiTransformer();

	public static AbstactTransformer getInstance() {
		return SINGLETON;
	}
	
	// xsd file name in the output folder started with "/" == project_loc
	private static final String CII_100_XSD = "/cii/maindoc/CrossIndustryInvoice_100pD16B.xsd";
	// CONTENT_PATH aka package name
	private static final String CONTENT_PATH = "un.unece.uncefact.data.standard.crossindustryinvoice._100";
	// CONTENT_SUPERTYPE_NAME aka class name
	private static final String CONTENT_SUPERTYPE_NAME = CONTENT_PATH+".CrossIndustryInvoiceType"; 
	// CONTENT_TYPE_NAME aka class name , CONTENT_TYPE_NAME extends CONTENT_SUPERTYPE_NAME
	public static final String CONTENT_TYPE_NAME = "com.klst.einvoice.unece.uncefact.CrossIndustryInvoice"; 
	
	private CiiTransformer() {
		super(CONTENT_PATH, SINGLETON);
	}
	
	@Override
	String getResource() {
		return CII_100_XSD;
	}

	@Override
	Class<?> loadClass() {
		Class<?> type = null;
		try {
			// dynamisch die CII Klasse laden 
			type = Class.forName(CONTENT_SUPERTYPE_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return type;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Object> T toModel(InputStream xmlInputStream) {
		Class<?> type = loadClass();
		Object result = this.toModel(xmlInputStream, type);
		return (T) result;
	}

	public NamespacePrefixMapper createNamespacePrefixMapper() {
		return CiiNamespacePrefixMapper.getNamespacePrefixMapper();
	}

}
