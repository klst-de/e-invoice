package com.klst.marshaller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransformerTest {

	static private AbstactTransformer ublInvoiceTransformer, ublInvoiceTransformer2;
	static private AbstactTransformer ublCreditNoteTransformer, ciiTransformer;

	private static final String TESTDIR = "src/test/resources/"; // mit Daten aus xrechnung-1.2.0-testsuite-2018-12-14.zip\instances\
	private static final String UBL_XML = "01.01a-INVOICE_ubl.xml";
	private static final String UNCEFACT_XML = "01.01a-INVOICE_uncefact.xml";

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
    
    File getUblFile(String uri) {
		File file = new File(uri);
		assertTrue(file.canRead());
		return file;
    }
    
    @Test
    public void validateCiiTest() {
		File file = getUblFile(TESTDIR+UNCEFACT_XML);	
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
			fail("Validator SAXException="+ex.getMessage());
		} catch (Exception ex) {
			fail("Validator Exception="+ex.getMessage());
		}		
    }

    @Test
    public void validateUblInvoiceTest() {
		File file = getUblFile(TESTDIR+UBL_XML);	
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
			fail("Validator SAXException="+ex.getMessage());
		} catch (Exception ex) {
			fail("Validator Exception="+ex.getMessage());
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
		File file = getUblFile(TESTDIR+UBL_XML);
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
