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
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.TradeLineItem;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
import com.klst.marshaller.AbstactTransformer;
import com.klst.marshaller.CiiTransformer;
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
//		transformer = CiiTransformer.getInstance();  // for UN/CEFACT Cross Industry Invoice XML
		transformer = UblInvoiceTransformer.getInstance();
    }

	@Test
	public void commercialInvoiceTest() {
//		CoreInvoice invoice = new CrossIndustryInvoice(CoreInvoice.PROFILE_XRECHNUNG, null
//				, DocumentNameCode.CommercialInvoice);
		CoreInvoice invoice = GenericInvoice.createInvoice(CoreInvoice.PROFILE_XRECHNUNG, null
				, DocumentNameCode.CommercialInvoice);
		LOG.info("ublInvoice.Class:"+invoice.getClass());
		invoice.setId("123456XX");
		invoice.setIssueDate("2016-12-04");
		invoice.addNote(ADU, "Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden."); // optional
		invoice.setBuyerReference("04011000-12345-34");
		invoice.setDocumentCurrency(EUR);
		invoice.setTaxCurrency(EUR);                         // optional
		invoice.setOrderReference("1234567890");             // optional

//		CoreInvoiceLine line = new TradeLineItem("1"		// invoice line number
		CoreInvoiceLine line = GenericLine.createInvoiceLine("1"		// invoice line number
		  , new Quantity("XPP", new BigDecimal(1))
		  , new Amount(EUR, new BigDecimal(288.79))				// line net amount
		  , new UnitPriceAmount(EUR, new BigDecimal(288.79))	// price
		  , "Zeitschrift [...]"									// itemName
		  , TaxCategoryCode.StandardRate, new BigDecimal(7));	// VAT category code, rate 7%
		invoice.addLine(line);
		  
		// BusinessParty Seller aka Supplier
		PostalAddress sellerAddress = invoice.createAddress(DE, "12345", "[Seller city]");
		sellerAddress.setAddressLine1("[Seller address line 1]");
		String contactName = "nicht vorhanden";
		String contactTel  = "+49 1234-5678";
		String contactMail = "seller@email.de";
		IContact sellerContact = invoice.createContact(contactName, contactTel, contactMail);
		invoice.setSeller("[Seller name]", sellerAddress, sellerContact, 
				"[HRA-Eintrag]", "123/456/7890, HRA-Eintrag in […]");
		  
		// BusinessParty Buyer aka Customer 
		PostalAddress buyerAddress = invoice.createAddress(DE, "12345", "[Buyer city]");
		IContact buyerContact = null;                           // (optional)
		invoice.setBuyer("[Buyer name]", buyerAddress, buyerContact);
		
		
		assertEquals(CoreInvoice.PROFILE_XRECHNUNG, invoice.getCustomization());
		assertThat(invoice.getProcessType()).isNull();
		assertEquals(DocumentNameCode.CommercialInvoice, invoice.getTypeCode());
		
		Timestamp ts = invoice.getIssueDateAsTimestamp();
		LOG.info("IssueDate (LocalDateTime):"+ts.toLocalDateTime());
		assertEquals(2016, ts.toLocalDateTime().getYear());
		assertEquals(12, ts.toLocalDateTime().getMonthValue());
		
		assertEquals(1, invoice.getInvoiceNotes().size());
		assertEquals(ADU, invoice.getInvoiceNotes().get(0).getCode());
		  
		assertEquals(contactName, invoice.getSeller().getIContact().getContactPoint());
		assertEquals(contactTel , invoice.getSeller().getIContact().getContactTelephone());
		assertEquals(contactMail, invoice.getSeller().getIContact().getContactEmail());
		assertEquals(DE, invoice.getSeller().getAddress().getCountryCode());
		assertEquals(DE, invoice.getBuyer() .getAddress().getCountryCode());
		
		byte[] xml = transformer.fromModel(invoice);
		LOG.info(new String(xml));
	}

}
