package com.klst.xrechnung.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BG2_ProcessControl;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.InvoiceNote;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CiiTest {

/*

java.util.logging.ErrorManager: 5
java.lang.ArrayIndexOutOfBoundsException: 5
	at my.util.logging.CustomFormatter.format(CustomFormatter.java:158)
	at java.util.logging.StreamHandler.publish(StreamHandler.java:211)
	at java.util.logging.ConsoleHandler.publish(ConsoleHandler.java:116)
	at java.util.logging.Logger.log(Logger.java:738)
	at java.util.logging.Logger.doLog(Logger.java:765)
	at java.util.logging.Logger.log(Logger.java:788)
	at java.util.logging.Logger.info(Logger.java:1490)
	at com.klst.xrechnung.test.KositValidation.getCheck(KositValidation.java:54)
	at com.klst.xrechnung.test.KositValidation.<init>(KositValidation.java:70)
	at com.klst.xrechnung.test.CiiTest.staticSetup(CiiTest.java:118)

 */
	private static LogManager logManager = LogManager.getLogManager(); // Singleton
	private static Logger LOG = null;
	private static void initLogger() {
    	URL url = CiiTest.class.getClassLoader().getResource("testLogging.properties");
		try {
	        File file = new File(url.toURI());
			logManager.readConfiguration(new FileInputStream(file));
		} catch (IOException | URISyntaxException e) {
			LOG = Logger.getLogger(CiiTest.class.getName());
			LOG.warning(e.getMessage());
		}
		LOG = Logger.getLogger(CiiTest.class.getName());		
	}

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
			"01.13a-INVOICE_uncefact.xml" , // OK
			"01.14a-INVOICE_uncefact.xml" ,
			"01.15a-INVOICE_uncefact.xml" ,
			"zugferd2_invoice_pdfa3b.xml" ,// war PROFILE_BASIC, geändert in PROFILE_COMFORT
			"02.01a-INVOICE_uncefact.xml" , // see issue #16
			"02.02a-INVOICE_uncefact.xml" ,
			"02.03a-INVOICE_uncefact.xml" ,
			"02.04a-INVOICE_uncefact.xml" ,
			"02.05a-INVOICE_uncefact.xml" ,
			"02.06a-INVOICE_uncefact.xml" ,
			"03.01a-INVOICE_uncefact.xml" ,
			"03.02a-INVOICE_uncefact.xml" ,
			"03.03a-INVOICE_uncefact.xml" ,
			"03.04a-INVOICE_uncefact.xml" ,
			"03.05a-INVOICE_uncefact.xml"
			};
	
	private static final String XRECHNUNG_2p0 = BG2_ProcessControl.PROFILE_XRECHNUNG;

	static private final String ID = "123456XX";
	static private final String ISSUE_DATE = "2018-01-01";
	static private final String SUBJECT_CODE = "ADU";
	static private final String NOTE_CONTENT = "A textual note that gives unstructured information that is relevant to the Invoice as a whole.";
	
	static private KositValidation validation;
	static private PostalAddress testAddress;
	
    @BeforeClass
    public static void staticSetup() {
    	
    	initLogger();
		
    	validation = new KositValidation();
    	testAddress = null; //new Address("CC", "9-PC", "String city", "String street");
    }
    
    CoreInvoice invoice;

	@Before 
    public void setup() {
    }

    @Test
    public void cii0ctor() {
    	invoice = CrossIndustryInvoice.getFactory().createInvoice(XRECHNUNG_2p0, DocumentNameCode.CommercialInvoice);
    	invoice.setId(ID);
    	assertEquals(ID, invoice.getId());
    	
		invoice.setIssueDate(ISSUE_DATE);
    	assertEquals(DateTimeFormats.ymdToTs(ISSUE_DATE), invoice.getIssueDateAsTimestamp());
    	
		invoice.addNote(SUBJECT_CODE, "Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden."); // 0..n (optional)
		invoice.addNote(SUBJECT_CODE); // SUBJECT_CODE wird als NOTE_CONTENT/aka Note verwendet
		invoice.addNote(SUBJECT_CODE, NOTE_CONTENT);
		invoice.addNote(NOTE_CONTENT);
		List<InvoiceNote> notes = invoice.getInvoiceNotes();
		assertEquals(4, notes.size());
		notes.forEach(note -> {
			LOG.info(""+note);
		});
		assertEquals(SUBJECT_CODE, notes.get(0).getCode());
		assertNull(                notes.get(1).getCode());
		assertEquals(SUBJECT_CODE, notes.get(1).getNote());
		assertEquals(SUBJECT_CODE, notes.get(2).getCode());
		assertEquals(NOTE_CONTENT, notes.get(3).getNote());
		
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
    	Object o = factory.makeInvoice();
    	CrossIndustryInvoice cii = (CrossIndustryInvoice)o;
    	PaymentInstructions pi = cii.getPaymentInstructions();
    	assertNull(pi.getRemittanceInformation());
    	assertEquals(PaymentMeansEnum.SEPACreditTransfer, pi.getPaymentMeansEnum());  // <ram:TypeCode>58</ram:TypeCode>
    	assertEquals(1, pi.getCreditTransfer().size());
    	assertEquals("DE75512108001245126199", pi.getCreditTransfer().get(0).getPaymentAccountID());  // <ram:IBANID>DE12345678912345678912</ram:IBANID>
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
    	assertEquals("[Deliver to party name]", delivery.getName()); 
    	
    	assertEquals(Timestamp.valueOf("2018-04-13 00:00:00"), cii.getDeliveryPeriod().getStartDateAsTimestamp()); 
    	assertEquals(Timestamp.valueOf("2018-04-13 00:00:00"), cii.getDeliveryDateAsTimestamp()); 
    	
    	LOG.info("------------------------------------------- toCii:");
    	byte[] bytes = factory.toCii(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
	}
	
	@Test
    public void ciixml15_PaymentInstructions() {
    	InvoiceFactory factory = new CreateCiiXXXInvoice("01.15a-INVOICE_uncefact.xml");
    	Object o = factory.makeInvoice();
    	CrossIndustryInvoice cii = (CrossIndustryInvoice)o;
    	PaymentInstructions pi = cii.getPaymentInstructions();
    	assertEquals("0000123456", pi.getRemittanceInformation());  // <ram:PaymentReference>0000123456</ram:PaymentReference> 
    	assertEquals(PaymentMeansEnum.SEPACreditTransfer, pi.getPaymentMeansEnum());  // <ram:TypeCode>58</ram:TypeCode>
    	assertEquals(1, pi.getCreditTransfer().size());
    	assertEquals("DE75512108001245126199", pi.getCreditTransfer().get(0).getPaymentAccountID());  // <ram:IBANID>DE12123000001234567890</ram:IBANID>
    	
    	LOG.info("------------------------------------------- toCii:");
    	byte[] bytes = factory.toCii(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
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
//    	InvoiceFactory factory = new CreateCiiXXXInvoice("CII_business_example_01.xml");
//    	InvoiceFactory factory = new CreateCiiXXXInvoice("cii001.xml");
//    	InvoiceFactory factory = new CreateCiiXXXInvoice("03.05a-INVOICE_uncefact.xml");
    	InvoiceFactory factory = new CreateCiiXXXInvoice("01.14a-INVOICE_uncefact.xml");
//    	InvoiceFactory factory = new CreateCiiXXXInvoice(CII_XML[CII_XML.length-1]);
    	byte[] bytes = factory.toCii(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
   }
}
