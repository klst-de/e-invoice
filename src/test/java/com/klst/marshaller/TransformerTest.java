package com.klst.marshaller;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Validator;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
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
    
    @Test
    public void validateUblInvoiceTest() {
		String uri = TESTDIR+UBL_XML;
		File file = new File(uri);
		assertTrue(file.canRead());
		
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
    }
 
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
