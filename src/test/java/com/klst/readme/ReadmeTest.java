package com.klst.readme;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.ubl.GenericLine;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
import com.klst.marshaller.AbstactTransformer;
import com.klst.marshaller.UblInvoiceTransformer;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

public class ReadmeTest {

	private static final Logger LOG = Logger.getLogger(ReadmeTest.class.getName());
	
	static final String XRECHNUNG_20 = CoreInvoice.PROFILE_XRECHNUNG;
	static final String EUR = "EUR"; 
	
	static private AbstactTransformer transformer;
	
	@Before 
    public void setup() {
		transformer = UblInvoiceTransformer.getInstance();
//    	ublTransformer = UblInvoiceTransformer.getInstance();
//    	
//    	ublCreditNoteTransformer = UblCreditNoteTransformer.getInstance();
//    	ciiTransformer = CiiTransformer.getInstance();
    }

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void commercialInvoiceTest() {
		  GenericInvoice<InvoiceType> ublInvoice =
				  GenericInvoice.createInvoice(XRECHNUNG_20, null, DocumentNameCode.CommercialInvoice);
		  LOG.info("ublInvoice.Class:"+ublInvoice.get().getClass());
		  ublInvoice.setId("123456XX");
		  ublInvoice.setIssueDate("2016-04-04");
		  ublInvoice.setNote("Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden."); // optional
		  ublInvoice.setDocumentCurrency(EUR);
		  ublInvoice.setOrderReference("1234567890");           // optional
		  ublInvoice.setBuyerReference("04011000-12345-34");
		 
		  CoreInvoiceLine line = GenericLine.createInvoiceLine("1"		// invoice line number
				  , new Quantity("XPP", new BigDecimal(1))
				  , new Amount(EUR, new BigDecimal(288.79))				// line net amount
				  , new UnitPriceAmount(EUR, new BigDecimal(288.79))	// price
				  , "Zeitschrift [...]"									// itemName
				  , TaxCategoryCode.StandardRate, new BigDecimal(7));	// VAT category code, rate 7%
		  ublInvoice.addLine(line);
		  
		  assertEquals(CoreInvoice.PROFILE_XRECHNUNG, ublInvoice.getCustomization());
		  assertThat(ublInvoice.getProcessType()).isNull();
		  assertEquals(DocumentNameCode.CommercialInvoice, ublInvoice.getTypeCode());
		  
		  byte[] xml = transformer.fromModel(ublInvoice.get());
		  LOG.info(new String(xml));
	}

}
