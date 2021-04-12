package com.klst.xrechnung.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.edoc.untdid.PaymentMeansEnum;
import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BG24_AdditionalSupportingDocs;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.marshaller.AbstactTransformer;
import com.klst.marshaller.UblInvoiceTransformer;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UblTest {

	private static LogManager logManager = LogManager.getLogManager(); // Singleton
	private static Logger LOG = null;
	private static void initLogger() {
        URL url = UblTest.class.getClassLoader().getResource("testLogging.properties");
		try {
	        File file = new File(url.toURI());
			logManager.readConfiguration(new FileInputStream(file));
		} catch (IOException | URISyntaxException e) {
			LOG = Logger.getLogger(UblTest.class.getName());
			LOG.warning(e.getMessage());
		}
		LOG = Logger.getLogger(UblTest.class.getName());
	}

	private static final String TESTDIR = "src/test/resources/";
	private File getTestFile(String filename) {
		File file = new File(TESTDIR + filename);
		LOG.info("test file "+file.getAbsolutePath() + " canRead:"+file.canRead());
		return file;
	}
	
	private static final String[] UBL_XML = {
			"ubl001.xml" ,
//			"ubl002.xml" , // error tr=val-sch.1.1BR-06error[BR-06]-An Invoice shall contain the Seller name (BT-27).
			"ubl004.xml" , // WARN: [UBL-SR-44]-Payment ID shall occur maximum once
			"ubl007.xml" ,
//			"ubl008.xml" , //TODO CreditNote ist nicht valide: 11 Fehler zu Schematron rules for EN16931 (UBL) (val-sch.1)
			"01.01a-INVOICE_ubl.xml" ,
			"01.02a-INVOICE_ubl.xml" ,
			"01.03a-INVOICE_ubl.xml" ,
			"01.04a-INVOICE_ubl.xml" ,
			"01.05a-INVOICE_ubl.xml" ,
			"01.06a-INVOICE_ubl.xml" ,
			"01.07a-INVOICE_ubl.xml" ,
			"01.08a-INVOICE_ubl.xml" ,
			"01.09a-INVOICE_ubl.xml" ,
			"01.10a-INVOICE_ubl.xml" ,
			"01.11a-INVOICE_ubl.xml" ,
			"01.12a-INVOICE_ubl.xml" ,
			"01.13a-INVOICE_ubl.xml" ,
			"01.14a-INVOICE_ubl.xml" ,
			"01.15a-INVOICE_ubl.xml" };
	private static final String[] UBL_02_XML = {
			"02.01a-INVOICE_ubl.xml" ,
			"02.02a-INVOICE_ubl.xml" ,
			"03.01a-INVOICE_ubl.xml" ,
			"03.02a-INVOICE_ubl.xml" ,
			"04.01a-INVOICE_ubl.xml" ,  // 1 Warnung SubInvoiceLine
			"04.02a-INVOICE_ubl.xml" }; // 1 Warnung SubInvoiceLine
	private static final String[] UBL_tc43_XML = {
			"ubl-tc434-creditnote1.xml" ,
			"ubl-tc434-example1.xml" ,
			"ubl-tc434-example2.xml" ,
			"ubl-tc434-example3.xml" ,
			"ubl-tc434-example4.xml" ,
			"ubl-tc434-example5.xml" ,
			"ubl-tc434-example6.xml" ,
			"ubl-tc434-example7.xml" ,
			"ubl-tc434-example8.xml" ,
			"ubl-tc434-example9.xml" };
	
	static private KositValidation validation;
	static private AbstactTransformer transformer;
	
	private GenericInvoice<InvoiceType> toModel(File xmlfile) {
		InvoiceType invoice;
		GenericInvoice<InvoiceType> genericInvoice = null;
		try {
			InputStream is = new FileInputStream(xmlfile);
			invoice = transformer.toModel(is);
			genericInvoice = new GenericInvoice<InvoiceType>(invoice);
		} catch (Exception ex) {
			ex.printStackTrace();
			LOG.severe(ex.getMessage());			
		}
		return genericInvoice;
	}

    @BeforeClass
    public static void staticSetup() {
    	initLogger();
		validation = new KositValidation();
		transformer = UblInvoiceTransformer.getInstance();
    }

	@Test
    public void ubl00() {
		CoreInvoice invoice = GenericInvoice.getFactory().createInvoice(CoreInvoice.PROFILE_XRECHNUNG, DocumentNameCode.CommercialInvoice);
		LOG.info("ublInvoice.Class:"+invoice.getClass());
		invoice.setId("123456XX");
		invoice.setIssueDate("2016-04-04");
		invoice.addNote("Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden."); // optional
		invoice.setOrderReference("1234567890");           // optional
		invoice.setBuyerReference("04011000-12345-34");
		// ...
		IBANId payeeIban = new IBANId("NL57RABO0107307510");
		BICId bicId = null; // SwiftCode (optional)
		CreditTransfer ct = invoice.addCreditTransfer(payeeIban, "RaboBank account", bicId);
		// implizit wird ein Objekt SEPACreditTransfer für BG-16 PAYMENT INSTRUCTIONS in ublInvoice erstellt
		assertEquals(PaymentMeansEnum.SEPACreditTransfer, invoice.getPaymentInstructions().getPaymentMeansEnum());

		// TODO auch damit nur ein BG-17 in BG-16
		bicId = new BICId("INGBNL2AXXX");
		CreditTransfer ct2 = invoice.createCreditTransfer("NL03 INGB 0004489902", "ING account", bicId); // TODO addCreditTransfer
		
		List<CreditTransfer> ctList = new ArrayList<CreditTransfer>(Arrays.asList(ct,ct2));
		// create liefert ein BG-16 Objekt, aber bindet es nicht an ublInvoice - das macht setXXX
//		ublInvoice.createPaymentInstructions(PaymentMeansEnum.CreditTransfer, "paymentMeansText"
//				, "PaymentReference Verwendungszweck", ctList);
		invoice.setPaymentInstructions(PaymentMeansEnum.CreditTransfer, "paymentMeansText"
				, "PaymentReference Verwendungszweck", ctList, null, null);
		
//		bicId = new BICId("INGBNL2AXXX");
//		ublInvoice.addCreditTransfer("NL03 INGB 0004489902", "ING account", bicId); // TODO addCreditTransfer
		
		// TODO PaymentReference Verwendungszweck geht nur über BG-16, dann ist aber BG-16 zwei mal da
		
		byte[] bytes = transformer.fromModel(invoice);
		String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	//assertTrue(validation.check(bytes));
   }
    
	@Test
	public void ubl0105_FinancialAccount() {  // zwei IBANs
		File testFile = getTestFile("01.05a-INVOICE_ubl.xml");
		CoreInvoice testDoc = null;
		if(transformer.isValid(testFile)) {
			testDoc = toModel(testFile);
		} else {
			LOG.severe("NOT VALID :"+testFile);
			assertNotNull("NOT VALID "+testFile , testDoc);
		}
		PaymentInstructions pi = testDoc.getPaymentInstructions();
		assertEquals(PaymentMeansEnum.SEPACreditTransfer, pi.getPaymentMeansEnum());
		List<CreditTransfer> creditTransferList = pi.getCreditTransfer();
		assertEquals(2, creditTransferList.size());
		assertEquals("DE75512108001245126199", creditTransferList.get(0).getPaymentAccountID());
		assertEquals("DE12500105170648489890", creditTransferList.get(1).getPaymentAccountID());
		
		String accountName = "ING account";
		BICId bicId = new BICId("INGBNL2AXXX");
		CreditTransfer ct = testDoc.addCreditTransfer(new IBANId("NL03 INGB 0004489902"), accountName, bicId);
		assertNull(ct);
		LOG.info("add accountName:"+accountName +"\n");
		ct = testDoc.addCreditTransfer(new IBANId("NL03 INGB 0004489902"), "ING account", null);
		LOG.info("new ct:"+ct);
		assertEquals(2, pi.getCreditTransfer().size()); // die "alte" PI wurde geändert!!! TODO
		creditTransferList = testDoc.getPaymentInstructions().getCreditTransfer();
		assertEquals(3, creditTransferList.size());
		assertEquals("DE12500105170648489890", creditTransferList.get(1).getPaymentAccountID());
		assertEquals(accountName, creditTransferList.get(2).getPaymentAccountName());
	}
	
	@Test
    public void ubl0114_Delivery() {
    	InvoiceFactory factory = new CreateUblXXXInvoice("01.14a-INVOICE_ubl.xml");
    	Object o = factory.makeInvoice(); // o ist GenericInvoice<?>
    	GenericInvoice<InvoiceType> ublTest = (GenericInvoice<InvoiceType>)o;
    	GenericInvoice<InvoiceType> ublInvoice = new GenericInvoice<InvoiceType>(ublTest.get());
    	BG13_DeliveryInformation delivery = ublInvoice.getDelivery();
    	assertEquals(Timestamp.valueOf("2018-04-13 01:00:00"), delivery.getActualDate());    // 2018-04-13+01:00 "yyyy-[m]m-[d]d hh:mm:ss[.f...]"
    	assertEquals("68", delivery.getId()); 
    	assertEquals("[DE (Bayern), 98765, [Deliver to city]]", delivery.getAddress().toString());
    	assertEquals("[Deliver to party name]", delivery.getName()); 
    	
    	assertEquals(Timestamp.valueOf("2018-04-13 01:00:00"), ublInvoice.getDeliveryPeriod().getStartDateAsTimestamp()); 
    	assertEquals(Timestamp.valueOf("2018-04-13 01:00:00"), ublInvoice.getDeliveryDateAsTimestamp()); 
	}

	@Test
    public void ubl0201_AdditionalDocs() { // auch möglich mit 01.15a
    	InvoiceFactory factory = new CreateUblXXXInvoice("02.01a-INVOICE_ubl.xml");
    	Object o = factory.makeInvoice();
    	GenericInvoice<InvoiceType> ublTest = (GenericInvoice<InvoiceType>)o;
    	GenericInvoice<InvoiceType> ublInvoice = new GenericInvoice<InvoiceType>(ublTest.get());
    	Timestamp taxPointDate = ublInvoice.getTaxPointDateAsTimestamp();
    	assertNotNull(taxPointDate);
    	assertEquals(Timestamp.valueOf("2018-04-13 00:00:00"), taxPointDate);
    	
    	String contractReference = ublInvoice.getContractReference();
    	assertNotNull(contractReference);
    	assertEquals("0000000752", contractReference); 
    	String purchaseOrderReference = ublInvoice.getPurchaseOrderReference();
    	assertNotNull(purchaseOrderReference);
    	assertEquals("65002278", purchaseOrderReference); 
    	String orderReference = ublInvoice.getOrderReference();
    	assertNotNull(orderReference);
    	assertEquals("ABC123456789", orderReference); 
// diese Implementierung rausgenommen
//    	String tenderOrLotReference = ublInvoice.getTenderOrLotReference();
//    	assertNotNull(tenderOrLotReference);
//    	assertEquals("ANG987654321", tenderOrLotReference); 
   	
    	List<BG24_AdditionalSupportingDocs> asdList = ublInvoice.getAdditionalSupportingDocuments();
    	assertEquals(1, asdList.size());
    	BG24_AdditionalSupportingDocs asDoc = asdList.get(0);
    	assertEquals("01_15_Anhang_01.pdf", asDoc.getDocumentReference().getName());
    	assertEquals("Aufschlüsselung der einzelnen Leistungspositionen", asDoc.getSupportingDocumentDescription());
    	assertEquals("application/pdf", asDoc.getAttachedDocumentMimeCode());
    	assertEquals("01_15_Anhang_01.pdf", asDoc.getAttachedDocumentFilename());
    	assertNull(asDoc.getExternalDocumentLocation());
	}
	
	@Test
    public void ubl0201_AllowanceCharge() {
    	InvoiceFactory factory = new CreateUblXXXInvoice("02.01a-INVOICE_ubl.xml");
    	Object o = factory.makeInvoice();
    	GenericInvoice<InvoiceType> ublTest = (GenericInvoice<InvoiceType>)o;
    	GenericInvoice<InvoiceType> ublInvoice = new GenericInvoice<InvoiceType>(ublTest.get());
    	assertEquals("urn:fdc:peppol.eu:2017:poacc:billing:01:1.0", ublInvoice.getProcessType());
    	List<AllowancesAndCharges> list = ublInvoice.getAllowancesAndCharges();
    	assertNotNull(list);
    	assertEquals(2, list.size());
    	assertTrue(list.get(0).isCharge());
    	assertEquals("Testing", list.get(0).getReasonText());	
    	assertEquals("VAT", list.get(0).getTaxType());	
    	assertEquals("E", list.get(0).getTaxCategoryCode().getValue());	
    	assertTrue(list.get(1).isAllowance());
	}

	@Test
    public void ublAll() {
    	for(int i=0; i<UBL_XML.length; i++) {
    		String fileName = UBL_XML[i];
        	InvoiceFactory factory = new CreateUblXXXInvoice(fileName);
        	byte[] bytes = factory.toUbl(); // the xml
        	LOG.info("\n-------------------------------- "+fileName);
        	assertTrue(validation.check(bytes));
    	}
    }
    
    @Test
    public void ublAll02() {
    	for(int i=0; i<UBL_02_XML.length; i++) {
    		String fileName = UBL_02_XML[i];
        	InvoiceFactory factory = new CreateUblXXXInvoice(fileName);
        	byte[] bytes = factory.toUbl(); // the xml
        	LOG.info("\n-------------------------------- "+fileName);
        	String xml = new String(bytes);
        	LOG.info("xml=\n"+xml);
        	assertTrue(validation.check(bytes));
    	}
   }

    @Test
    public void ublAll43() {
    	for(int i=0; i<UBL_tc43_XML.length; i++) {
    		String fileName = UBL_tc43_XML[i];
        	InvoiceFactory factory = new CreateUblXXXInvoice(fileName);
        	byte[] bytes = factory.toUbl(); // the xml
        	LOG.info("\n-------------------------------- "+fileName);
        	String xml = new String(bytes);
        	LOG.info("xml=\n"+xml);
        	assertTrue(validation.check(bytes));
    	}
   }

//	@Test 
    public void ublCreditNote() {
    	InvoiceFactory factory = new CreateUblXXXInvoice("ubl008.xml");  // Quelle ist nicht valide
    	byte[] bytes = factory.toUbl(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
   }
    
//	@Test  // 10 Warnungen. Es ist nicht konform zu den formalen Vorgaben.
    public void ublPEPPOL() {
    	InvoiceFactory factory = new CreateUblXXXInvoice("example-peppol-ubl-creditnote.xml");
    	byte[] bytes = factory.toUbl(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
   }
    
	@Test
    public void ublZZZ() {
//    	InvoiceFactory factory = new CreateUblXXXInvoice("01.05a-INVOICE_ubl.xml");
    	InvoiceFactory factory = new CreateUblXXXInvoice("ubl-tc434-creditnote1.xml");
//    	InvoiceFactory factory = new CreateUblXXXInvoice("ubl-tc434-example5.xml");
    	byte[] bytes = factory.toUbl(); // the xml
    	String xml = new String(bytes);
    	LOG.info("xml=\n"+xml);
    	assertTrue(validation.check(bytes));
   }

}
