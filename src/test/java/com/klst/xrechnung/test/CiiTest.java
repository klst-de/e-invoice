package com.klst.xrechnung.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CiiTest {

	private static final Logger LOG = Logger.getLogger(CiiTest.class.getName());
	
	private static final String[] CII_XML = {
			"01.01a-INVOICE_uncefact.xml" ,
			"01.02a-INVOICE_uncefact.xml" ,
			"01.03a-INVOICE_uncefact.xml" ,
			"01.04a-INVOICE_uncefact.xml" , // OK
			"01.05a-INVOICE_uncefact.xml" ,
			"01.06a-INVOICE_uncefact.xml" ,
			"01.07a-INVOICE_uncefact.xml" ,
			"01.08a-INVOICE_uncefact.xml" ,
			"01.09a-INVOICE_uncefact.xml" ,
			"01.10a-INVOICE_uncefact.xml" , // OK
			"01.11a-INVOICE_uncefact.xml" ,
			"01.12a-INVOICE_uncefact.xml" ,
			"01.13a-INVOICE_uncefact.xml" , // NOK
			"01.14a-INVOICE_uncefact.xml" ,
			"01.15a-INVOICE_uncefact.xml" ,
			"zugferd2_invoice_pdfa3b.xml" };
	
	private static final String XRECHNUNG_12 = "urn:cen.eu:en16931:2017#compliant#urn:xoev-de:kosit:standard:xrechnung_1.2";

	static private final String ID = "123456XX";
	static private final String ISSUE_DATE = "2018-01-01";
	static private final String SUBJECT_CODE = "ADU";
	static private final String NOTE_CONTENT = "A textual note that gives unstructured information that is relevant to the Invoice as a whole.";
	
	static private KositValidation validation;
	static private PostalAddress testAddress;
	
    @BeforeClass
    public static void staticSetup() {
    	validation = new KositValidation();
    	testAddress = null; //new Address("CC", "9-PC", "String city", "String street");
    }
    
	CrossIndustryInvoice invoice;

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
    	
		invoice.setNote(SUBJECT_CODE, "Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden."); // 0..n (optional)
		invoice.setNote(SUBJECT_CODE);
		invoice.setNote(SUBJECT_CODE, NOTE_CONTENT);
		invoice.setNote(NOTE_CONTENT);
		List<Object> notes = invoice.getNotes();
		assertEquals(4, notes.size());
		notes.forEach(note -> {
			LOG.info(""+((NoteType)note).getContent().get(0).getValue());
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
    	assertTrue(validation.check(bytes));
   }

	@Test
    public void ciixml04() { // wg. ram:ExemptionReason
    	InvoiceFactory factory = new CreateCiiXXXInvoice("01.04a-INVOICE_uncefact.xml");
    	byte[] bytes = factory.toCii(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
   }

	@Test
    public void ciixml13() { // wg. <ram:ID schemeID="FC">123/456/789</ram:ID>
    	InvoiceFactory factory = new CreateCiiXXXInvoice("01.13a-INVOICE_uncefact.xml");
    	byte[] bytes = factory.toCii(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
   }

	@Test
    public void ciixml14_Delivery() {
    	InvoiceFactory factory = new CreateCiiXXXInvoice("01.14a-INVOICE_uncefact.xml");
    	Object o = factory.makeInvoice();
    	CrossIndustryInvoice cii = (CrossIndustryInvoice)o;
    	BG13_DeliveryInformation delivery = cii.getDelivery();
    	assertEquals(Timestamp.valueOf("2018-04-13 00:00:00"), delivery.getActualDate());    // 2018-04-13+01:00 "yyyy-[m]m-[d]d hh:mm:ss[.f...]"
    	assertEquals("68", delivery.getId()); 
    	assertEquals("[DE (Bayern), 98765, [Deliver to city]]", delivery.getAddress().toString());
    	assertEquals("[Deliver to party name]", delivery.getBusinessName()); 
    	
    	assertEquals(Timestamp.valueOf("2018-04-13 00:00:00"), cii.getStartDateAsTimestamp()); 
    	assertEquals(Timestamp.valueOf("2018-04-13 00:00:00"), cii.getEndDateAsTimestamp()); 
	}
	
    @Test
    public void ciiAll() {
    	for(int i=0; i<CII_XML.length; i++) {
    		String fileName = CII_XML[i];
        	InvoiceFactory factory = new CreateCiiXXXInvoice(fileName);
        	byte[] bytes = factory.toUbl(); // the xml
        	LOG.info("\n-------------------------------- "+fileName);
        	assertTrue(validation.check(bytes));
    	}
   }
    
	@Test
    public void ciixml_last() {
    	InvoiceFactory factory = new CreateCiiXXXInvoice(CII_XML[CII_XML.length-1]);
    	byte[] bytes = factory.toCii(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
   }
}
