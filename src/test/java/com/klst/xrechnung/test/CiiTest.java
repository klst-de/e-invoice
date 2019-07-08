package com.klst.xrechnung.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.klst.ubl.Address;
import com.klst.un.unece.uncefact.CrossIndustryInvoice;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CiiTest {

	private static final Logger LOG = Logger.getLogger(CiiTest.class.getName());
	
	private static final String[] CII_XML = {
			"01.01a-INVOICE_uncefact.xml" ,
			// ...
			"01.15a-INVOICE_uncefact.xml" };
	
	private static final String XRECHNUNG_12 = "urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_1.2";

	static private final String ID = "123456XX";
	static private final String ISSUE_DATE = "2018-01-01";
	static private final String SUBJECT_CODE = "ADU";
	static private final String NOTE_CONTENT = "A textual note that gives unstructured information that is relevant to the Invoice as a whole.";
	
	CrossIndustryInvoice invoice;

	static private Address testAddress;
	
    @BeforeClass
    public static void staticSetup() {
    	testAddress = new Address("CC", "9-PC", "String city", "String street");
    }
    
	@Before 
    public void setup() {
    }

    @Test
    public void cii0ctor() {
    	invoice = new CrossIndustryInvoice(XRECHNUNG_12, DocumentNameCode.CommercialInvoice);
    	invoice.setId(ID);
    	assertEquals(ID, invoice.getId());
    	
		invoice.setIssueDate(ISSUE_DATE);
    	assertEquals(DateTimeFormats.ymdToTs(ISSUE_DATE), invoice.getIssueDateAsTimestamp());
    	
		invoice.setNote("Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden.", SUBJECT_CODE); // 0..n (optional)
		invoice.setNote(SUBJECT_CODE);
		invoice.setNote(SUBJECT_CODE, NOTE_CONTENT);
		invoice.setNote(NOTE_CONTENT);
		List<String> notes = invoice.getNotes();
		assertEquals(4, notes.size());
		notes.forEach(note -> {
			LOG.info(note);
			});
		
    	assertEquals(ID, invoice.getId());
    	assertEquals(DateTimeFormats.ymdToTs(ISSUE_DATE), invoice.getIssueDateAsTimestamp());
   }

	@Test
    public void ciixml01() {
    	InvoiceFactory factory = new CreateCiiXXXInvoice(CII_XML[0]);
    	byte[] bytes = factory.toCii(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
//    	assertTrue(check(bytes));
   }

	@Test
    public void ciixml_last() {
    	InvoiceFactory factory = new CreateCiiXXXInvoice(CII_XML[CII_XML.length-1]);
    	byte[] bytes = factory.toCii(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
//    	assertTrue(check(bytes));
   }
}
