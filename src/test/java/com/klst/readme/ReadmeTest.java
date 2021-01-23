package com.klst.readme;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.IContact;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.ubl.GenericLine;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
import com.klst.marshaller.AbstactTransformer;
import com.klst.marshaller.UblInvoiceTransformer;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.TaxCategoryCode;

public class ReadmeTest {

	private static final Logger LOG = Logger.getLogger(ReadmeTest.class.getName());
	
	static final String EUR = "EUR";
	static final String  DE = "DE";  // country code
	/**
	 * ADU   Note
	 * Text subject is note.  chosen from the entries in UNTDID 4451 
	 */
	static final String ADU = "ADU"; 
	
	static private AbstactTransformer transformer;
	
	@Before 
    public void setup() {
		transformer = UblInvoiceTransformer.getInstance();
    }

	@Test
	public void commercialInvoiceTest() {
		CoreInvoice ublInvoice = GenericInvoice.createInvoice(CoreInvoice.PROFILE_XRECHNUNG, null
				, DocumentNameCode.CommercialInvoice);
		LOG.info("ublInvoice.Class:"+ublInvoice.getClass());
		ublInvoice.setId("123456XX");
		ublInvoice.setIssueDate("2016-12-04");
		ublInvoice.addNote(ADU, "Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden."); // optional
		ublInvoice.setBuyerReference("04011000-12345-34");
		ublInvoice.setDocumentCurrency(EUR);
		ublInvoice.setTaxCurrency(EUR);                         // optional
		ublInvoice.setOrderReference("1234567890");             // optional

		CoreInvoiceLine line = GenericLine.createInvoiceLine("1"		// invoice line number
		  , new Quantity("XPP", new BigDecimal(1))
		  , new Amount(EUR, new BigDecimal(288.79))				// line net amount
		  , new UnitPriceAmount(EUR, new BigDecimal(288.79))	// price
		  , "Zeitschrift [...]"									// itemName
		  , TaxCategoryCode.StandardRate, new BigDecimal(7));	// VAT category code, rate 7%
		ublInvoice.addLine(line);
		  
		// BusinessParty Seller aka Supplier TODO
		  
		// BusinessParty Buyer aka Customer 
		PostalAddress buyerAddress = ublInvoice.createAddress(DE, "12345", "[Buyer city]");
		IContact buyerContact = null;                           // (optional)
		ublInvoice.setBuyer("[Buyer name]", buyerAddress, buyerContact);
		
		
		assertEquals(CoreInvoice.PROFILE_XRECHNUNG, ublInvoice.getCustomization());
		assertThat(ublInvoice.getProcessType()).isNull();
		assertEquals(DocumentNameCode.CommercialInvoice, ublInvoice.getTypeCode());
		
		Timestamp ts = ublInvoice.getIssueDateAsTimestamp();
		LOG.info("IssueDate (LocalDateTime):"+ts.toLocalDateTime());
		assertEquals(2016, ts.toLocalDateTime().getYear());
		assertEquals(12, ts.toLocalDateTime().getMonthValue());
		
		assertEquals(1, ublInvoice.getInvoiceNotes().size());
		assertEquals(ADU, ublInvoice.getInvoiceNotes().get(0).getCode());
		  
		assertEquals(DE, ublInvoice.getBuyer().getAddress().getCountryCode());
		
		byte[] xml = transformer.fromModel(ublInvoice);
		LOG.info(new String(xml));
	}

}
