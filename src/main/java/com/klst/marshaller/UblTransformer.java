package com.klst.marshaller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.inject.Named;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.klst.einvoice.ubl.GenericInvoice;

/* in java 1.8 'NamespacePrefixMapper' is not in API (restriction on required library ... jdk1.8.0_241\jre\lib\rt.jar')
 * to compile in eclipse define access rule.
 * 
 * Proposal JEP-320(http://openjdk.java.net/jeps/320) to remove the Java EE and CORBA modules from the JDK.
 * In Java SE 11, the module has been removed. To use JAX-WS and JAXB you need to add them to your project as separate libraries.
 * 
 * @see https://jesperdj.com/2018/09/30/jaxb-on-java-9-10-11-and-beyond/
 */
//import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;

@Named
/* Notice 
 * that there are two @Singleton annotations, 
 * one in javax.inject and the other in the javax.ebj package. 
 * I'm referring to them by their fully-qualified names to avoid confusion.
 * @see https://stackoverflow.com/questions/26832051/singleton-vs-applicationscope
 * @see https://github.com/javax-inject/javax-inject
 */
@javax.inject.Singleton
public abstract class UblTransformer extends AbstactTransformer {

	// ctor
	protected UblTransformer(String contentPath, AbstactTransformer instance) {
		super(contentPath, instance);
	}
	
	@Override
	abstract String getResource();

	@Override
	public byte[] fromModel(Object document) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(16000);
		Class<?> type = loadClass();
		
		try {
			Marshaller marshaller = createMarshaller();

			if(document instanceof GenericInvoice<?>) {
				marshaller.marshal(((GenericInvoice)document).get(), outputStream);
			} else if(document instanceof CrossIndustryInvoiceType) {
				marshaller.marshal((CrossIndustryInvoiceType)document, outputStream);
			}
		} catch (JAXBException ex) {
			throw new TransformationException(TransformationException.MARSHALLING_ERROR, ex);
		}
		
		return outputStream.toByteArray();
	}

	@Override
	abstract public <T> T toModel(InputStream xmlInputStream);

	@SuppressWarnings("restriction")
	@Override // implements abstract method
	NamespacePrefixMapper getNamespacePrefixMapper() {
		return new UblNamespacePrefixMapper();
	}
	
}


