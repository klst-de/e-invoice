package com.klst.marshaller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.logging.Logger;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.xml.sax.SAXException;

import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.einvoice.api.CoreInvoice;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransformerTest {

	static private AbstactTransformer ublInvoiceTransformer, ublInvoiceTransformer2;
	static private AbstactTransformer ublCreditNoteTransformer, ciiTransformer;

	private static final String TESTDIR = "src/test/resources/"; // mit Daten aus xrechnung-1.2.0-testsuite-2018-12-14.zip\instances\
	private static final String NOT_EXISTING_FILE = "NOT_EXISTING_FILE.xml";
	private static final String UBL_XML = "01.01a-INVOICE_ubl.xml";
	private static final String UNCEFACT_XML = "01.01a-INVOICE_uncefact.xml";
	private static final String NON_UNCEFACT_XML = UBL_XML;

	private static final Logger LOG = Logger.getLogger(TransformerTest.class.getName());

	@Before 
    public void setup() {
    	ublInvoiceTransformer = UblInvoiceTransformer.getInstance();
    	ublInvoiceTransformer2 = UblInvoiceTransformer.getInstance();
    	
    	ublCreditNoteTransformer = UblCreditNoteTransformer.getInstance();
    	ciiTransformer = CiiTransformer.getInstance();
    }

    @Test
    public void singletonTest() {
    	assertNotNull(ublInvoiceTransformer);
    	assertNotNull(ublInvoiceTransformer2);
    	assertNotNull(ublCreditNoteTransformer);
    	assertNotNull(ciiTransformer);
    	
    	assertEquals(ublInvoiceTransformer, ublInvoiceTransformer2);
    	
    	assertNotEquals(ublInvoiceTransformer, ublCreditNoteTransformer);
    	assertNotEquals(ublInvoiceTransformer, ciiTransformer);
    	assertNotEquals(ublCreditNoteTransformer, ciiTransformer);
   }
    
    @Test
    public void notExistingFileTest() {
		File file = new File(TESTDIR+NOT_EXISTING_FILE);
		assertFalse(file.canRead());
		Validator validator = null;
		try {
			validator = ciiTransformer.getSchemaValidator(); // throws SAXException
		} catch (SAXException ex) {
			fail("Validator SAXException="+ex.getMessage());
		}
		
		try {
			Source xmlFile = new StreamSource(file);
			validator.validate(xmlFile); // throws SAXException, Exception
			fail("Exception notExistingFile not thrown");
		} catch (SAXException ex) {
			LOG.warning("Validator SAXException="+ex.getMessage());
			fail("Validator SAXException="+ex.getMessage());
		} catch (Exception ex) {
			LOG.warning("expected SAXException="+ex.getMessage());
			// expected this exception : fail("Validator Exception="+ex.getMessage());
		}
		
    }

    File getTestFile(String uri) {
		File file = new File(uri);
		assertTrue(file.canRead());
		return file;
    }
    
    @Test
    public void validateCiiTest() {
		File file = getTestFile(TESTDIR+UNCEFACT_XML);	
		Validator validator = null;
		try {
			validator = ciiTransformer.getSchemaValidator(); // throws SAXException
		} catch (SAXException ex) {
			fail("Validator SAXException="+ex.getMessage());
		}
		
		try {
			Source xmlFile = new StreamSource(file);
			validator.validate(xmlFile); // throws SAXException, Exception
		} catch (SAXException ex) {
			LOG.warning("Validator SAXException="+ex.getMessage());
			fail("Validator SAXException="+ex.getMessage());
		} catch (Exception ex) {
			LOG.warning("Validator SAXException="+ex.getMessage());
			fail("Validator Exception="+ex.getMessage());
		}		
		
		LOG.info("file " +file+ " is valid.");
		try {
			InputStream is = new FileInputStream(file);
			Class<?> type = Class.forName(com.klst.marshaller.CiiTransformer.CONTENT_TYPE_NAME); // CrossIndustryInvoice laden
			//CoreInvoice invoice = new CrossIndustryInvoice(ciiTransformer.toModel(is));
			// dynamisch, dafür muss der ctor public sein
			Object o = ciiTransformer.toModel(is);
			CoreInvoice invoice = CoreInvoice.class.cast(type.getConstructor(o.getClass()).newInstance(o));
			assertEquals(DocumentNameCode.CommercialInvoice, invoice.getTypeCode());
		} catch (Exception ex) {
			ex.printStackTrace();
			LOG.severe(ex.getMessage());
		}
    }

    @Test
    public void validateUblInvoiceTest() {
		File file = getTestFile(TESTDIR+UBL_XML);	
		Validator validator = null;
		try {
			validator = ublInvoiceTransformer.getSchemaValidator(); // throws SAXException
		} catch (SAXException ex) {
			fail("Validator SAXException="+ex.getMessage());
		}
		
		try {
			Source xmlFile = new StreamSource(file);
			validator.validate(xmlFile); // throws SAXException, Exception
		} catch (SAXException ex) {
			LOG.warning("Validator SAXException="+ex.getMessage());
			fail("Validator SAXException="+ex.getMessage());
		} catch (Exception ex) {
			LOG.warning("Validator SAXException="+ex.getMessage());
			fail("Validator Exception="+ex.getMessage());
		}
		
		LOG.info("file " +file+ " is valid.");
		try {
			InputStream is = new FileInputStream(file);
			Class<?> type = Class.forName(com.klst.marshaller.UblInvoiceTransformer.CONTENT_TYPE_NAME); // GenericInvoice laden
			//CoreInvoice invoice = new GenericInvoice(ciiTransformer.toModel(is));
			// dynamisch, dafün muss der ctror public sein
			Object o = ublInvoiceTransformer.toModel(is);
			LOG.info("o:"+o);
			
			Class<? extends Object> typeOfo = o.getClass();
			Constructor<?>[] ctors = type.getDeclaredConstructors();
			Constructor<?> ctor = ctors[0];
//			Constructor<?> ctor = type.getConstructor(typeOfo); // liefert
// java.lang.NoSuchMethodException: com.klst.einvoice.ubl.GenericInvoice.<init>(oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType)
			Object invoiceType = ctor.newInstance(o);
			LOG.info("invoiceType:"+invoiceType);
			
			CoreInvoice invoice = CoreInvoice.class.cast(invoiceType);
//			CoreInvoice invoice = CoreInvoice.class.cast(type.getConstructor(o.getClass()).newInstance(o));
			assertEquals(DocumentNameCode.CommercialInvoice, invoice.getTypeCode());
		} catch (Exception ex) {
			ex.printStackTrace();
			LOG.severe(ex.getMessage());
		}
		
		// create CreditNote validator without applaying:
		try {
			validator = ublCreditNoteTransformer.getSchemaValidator(); // throws SAXException
		} catch (SAXException ex) {
			fail("Validator SAXException="+ex.getMessage());
		}	
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    void validate(Validator validator, Source xmlFile) throws SAXException, IOException {
    	validator.validate(xmlFile); 
    }
    
    @Test
    public void validateUblInvoiceExceptionTest() {
		File file = getTestFile(TESTDIR+UBL_XML);
		Validator validator = null;
		try {
			validator = ublCreditNoteTransformer.getSchemaValidator(); // throws SAXException
		} catch (SAXException ex) {
			fail("Validator SAXException="+ex.getMessage());
		}
		
//	    exception.expect(SAXException.class);
//	    validate(validator, new StreamSource(file));
		try {
			Source xmlFile = new StreamSource(file);
			validator.validate(xmlFile); // throws SAXException, Exception
		} catch (SAXException ex) {
			// assertEquals(Object expected, Object actual)
//			assertEquals(ex.getMessage(), "cvc-elt.1: Deklaration des Elements 'ubl:Invoice' kann nicht gefunden werden.");
//			assertEquals("cvc-elt.1: Deklaration des Elements 'ubl:Invoice'", ex.getMessage());
			// besser:
			assertTrue(ex.getMessage().contains("'ubl:Invoice'"));
		} catch (Exception ex) {
			fail("Validator Exception="+ex.getMessage());
		}
    	
		try {
			validator = ciiTransformer.getSchemaValidator(); // throws SAXException
		} catch (SAXException ex) {
			fail("Validator SAXException="+ex.getMessage());
		}
		try {
			Source xmlFile = new StreamSource(file);
			validator.validate(xmlFile); // throws SAXException, Exception
		} catch (SAXException ex) {
			// expected "cvc-elt.1: Deklaration des Elements 'ubl:Invoice' kann nicht gefunden werden."
			assertTrue(ex.getMessage().contains("'ubl:Invoice'"));
		} catch (Exception ex) {
			fail("Validator Exception="+ex.getMessage());
		}

    }

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
