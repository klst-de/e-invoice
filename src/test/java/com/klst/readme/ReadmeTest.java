package com.klst.readme;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.klst.edoc.api.BusinessParty;
import com.klst.edoc.api.ContactInfo;
import com.klst.edoc.api.PostalAddress;
import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.edoc.untdid.TaxTypeCode;
import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.PrecedingInvoice;
import com.klst.einvoice.VatBreakdown;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
import com.klst.marshaller.AbstactTransformer;
import com.klst.marshaller.CiiTransformer;
import com.klst.marshaller.UblInvoiceTransformer;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;

public class ReadmeTest {

	private static final Logger LOG = Logger.getLogger(ReadmeTest.class.getName());
	
	static final String PROFILE_XRECHNUNG = CoreInvoice.PROFILE_XRECHNUNG;
	static final DocumentNameCode CommercialInvoice = DocumentNameCode.CommercialInvoice;
	static final String EUR = "EUR";
	static final String  DE = "DE";  // country code
	/**
	 * ADU   Note
	 * Text subject is note.  chosen from the entries in UNTDID 4451 
	 */
	static final String ADU = "ADU"; 
	
	static private AbstactTransformer ciiTransformer;
	static private AbstactTransformer ublTransformer;
	// UblCreditNoteTransformer for CreditNote!!! not used
//	static private AbstactTransformer ublCNTransformer;
	static private AbstactTransformer transformer;
	
	CoreInvoice invoice;
	
	@Before 
    public void setup() {
		ciiTransformer = CiiTransformer.getInstance();  // for UN/CEFACT Cross Industry Invoice XML
		ublTransformer = UblInvoiceTransformer.getInstance();
		invoice = null;
    }

	@Test
	public void ciiTest() {
		invoice = CrossIndustryInvoice.getFactory().createInvoice(PROFILE_XRECHNUNG, CommercialInvoice);
		transformer = ciiTransformer;
		commercialInvoiceTest();
	}
	
	@Test
	public void ublTest() {
		invoice = GenericInvoice.getFactory().createInvoice(PROFILE_XRECHNUNG, CommercialInvoice);
		transformer = ublTransformer;
		commercialInvoiceTest();
	}

	private static final BigDecimal ONE = new BigDecimal(1);
	
	CoreInvoiceLine line00() {
		// mandatory:
		CoreInvoiceLine line = invoice.createInvoiceLine("1"    // invoice line number
		  , new Quantity("XPP", new BigDecimal(1))              // 1 piece/XPP
		  , new Amount(EUR, new BigDecimal(288.79))				// line net amount
		  , new UnitPriceAmount(EUR, new BigDecimal(288.79))	// price
		  , "Zeitschrift [...]"									// itemName
		  , TaxCategoryCode.StandardRate, new BigDecimal(7));	// VAT category code, rate 7%
		
		// optional ...
		line.setNote("Die letzte Abonnementslieferung");        // BT-127 note
		line.setLineDeliveryPeriod("2016-01-01", "2016-12-31"); // BG-26  line delivery period.
		line.setOrderLineID("6171175.1");                       // BT-132 Referenced purchase order line
		line.setUnitPriceAllowance(new UnitPriceAmount(EUR, new BigDecimal(21.21)) // priceDiscount
				                  ,new UnitPriceAmount(EUR, new BigDecimal(310))); // grossPrice
		return line;
	}
	
	Quantity onePiece = new Quantity("XPP", new BigDecimal(1));
	Amount amount01 = new Amount(EUR, new BigDecimal(26.07));
	UnitPriceAmount price01 = new UnitPriceAmount(EUR, new BigDecimal(26.07));
	BigDecimal rate7 = new BigDecimal(7);
	
	CoreInvoiceLine line01() {
		CoreInvoiceLine line = invoice.createInvoiceLine("2"    // invoice line number
		  , new Quantity("XPP", new BigDecimal(1))              // 1 piece/XPP
		  , new Amount(EUR, new BigDecimal(26.07))				// line net amount
		  , new UnitPriceAmount(EUR, new BigDecimal(26.07))		// price
		  , "Porto + Versandkosten"								// itemName
		  , TaxCategoryCode.StandardRate, new BigDecimal(7));	// VAT category code, rate 7%
		
		// BG-27 0..n LINE ALLOWANCES:
		BigDecimal tenPerCent = new BigDecimal(10);
		line.addAllowance(new Amount(new BigDecimal(6.00)), new Amount(new BigDecimal(60.00)), tenPerCent);
		// BG-28 0..n LINE CHARGES:
		AllowancesAndCharges charge = line.createCharge(new Amount(new BigDecimal(6.00)), new Amount(new BigDecimal(60.00)), tenPerCent);
		charge.setReasoncode("64");                // UNTDID 5189 code
		charge.setReasonText("Special agreement");
		line.addAllowanceCharge(charge);
		
		return line;
	}
	void assertLine01(CoreInvoiceLine line) {
		LOG.info("line:"+line.getId() + " Quantity:"+line.getQuantity() + " TotalAmount:"+line.getLineTotalAmount());
		assertEquals("2", line.getId());
		assertEquals(onePiece.getUnitCode(), line.getQuantity().getUnitCode());
		assertEquals(onePiece.toString(), line.getQuantity().toString());
		assertEquals(EUR, line.getLineTotalAmount().getCurrencyID());
		assertEquals(amount01.toString(), line.getLineTotalAmount().toString());
//		LOG.info("line.getUnitPriceAmount().getCurrencyID():"+line.getUnitPriceAmount().getCurrencyID());
		assertEquals(EUR, line.getUnitPriceAmount().getCurrencyID());
		assertEquals(price01.toString(), line.getUnitPriceAmount().toString());
		assertEquals("Porto + Versandkosten", line.getItemName());
		assertEquals(TaxCategoryCode.StandardRate, line.getTaxCategory());
		assertEquals(rate7, line.getTaxRate());
	}
	
	void commercialInvoiceTest() {
		LOG.info("ublInvoice.Class:"+invoice.getClass());
		invoice.setId("123456XX");
		invoice.setIssueDate("2016-12-04");
		invoice.addNote(ADU, "Es gelten unsere Allgem. Geschäftsbedingungen, die Sie unter […] finden."); // optional
		invoice.setBuyerReference("04011000-12345-34");
		invoice.setDocumentCurrency(EUR);
		invoice.setTaxCurrency(EUR);                         // optional
		invoice.setOrderReference("1234567890");             // optional

		// create lines and add to invoice:
		invoice.addLine(line00());
		invoice.addLine(line01());
		  
		// BusinessParty Seller aka Supplier
		PostalAddress sellerAddress = invoice.createAddress(DE, "12345", "[Seller city]");
		sellerAddress.setAddressLine1("[Seller address line 1]");
		String contactName = "nicht vorhanden";
		String contactTel  = "+49 1234-5678";
		String contactMail = "seller@email.de";
		ContactInfo sellerContact = invoice.createContactInfo(contactName, contactTel, contactMail);
//		invoice.setSeller("[Seller name]", sellerAddress, sellerContact, 
//				"[HRA-Eintrag]", "123/456/7890, HRA-Eintrag in […]");
		// alternativ:
		BusinessParty seller = invoice.createParty("[Seller name]", null, sellerAddress, sellerContact);
		seller.setCompanyId("[HRA-Eintrag]");
		seller.setCompanyLegalForm("123/456/7890, HRA-Eintrag in […]");
		// mehrere BG-4.BT-29  0..n Seller identifier / https://github.com/klst-de/e-invoice/issues/27
		// Bsp aus https://docs.peppol.eu/poacc/billing/3.0/syntax/ubl-invoice/cac-AccountingSupplierParty/cac-Party/cac-PartyIdentification/cbc-ID/
		seller.addId("5060012349998", "0088");     // "0088" : EAN Location Code
		seller.addId("12345 6789 RC0001", "0093"); // "0093" : Revenue Canada Business Number
		invoice.setSeller(seller);
		  
		// BusinessParty Buyer aka Customer 
		PostalAddress buyerAddress = invoice.createAddress(DE, "12345", "[Buyer city]");
		ContactInfo buyerContact = null;                           // (optional)
		invoice.setBuyer("[Buyer name]", buyerAddress, buyerContact);
		
		String taxPointDate = "2016-12-31";
		invoice.setTaxPointDate(taxPointDate);  // wg. sequenzproblem
		
		List<VatBreakdown> vatBreakdowns = invoice.getVATBreakDowns();
		BigDecimal ermUSt = new BigDecimal(16); // 16%
		VatBreakdown vb = invoice.createVATBreakDown(
				new Amount(EUR, new BigDecimal(99.79)) // Amount taxableAmount
			, 	new Amount(EUR, new BigDecimal(9.79)) //Amount taxAmount
			, 	TaxCategoryCode.StandardRate // code
			, 	ermUSt // BigDecimal percent
			);
		LOG.info(">>>>>>>>>>>> tax type VAT? : "+vb.getTaxType() + " , Standard:"+vb.getTaxCategoryCode() + vb.getTaxPercentage());
		assertEquals(TaxTypeCode.VAT, vb.getTaxType());
		assertEquals(TaxCategoryCode.StandardRate, vb.getTaxCategoryCode());
		assertEquals(ermUSt, vb.getTaxPercentage());
		
		String TobaccoTax = "AAD";
		vb.setTaxType(TobaccoTax);
		LOG.info(">>>>>>>>>>>> tax type AAD? : "+vb.getTaxType());
		assertEquals(TobaccoTax, vb.getTaxType());
		
		// BG-3 + 0..n REFERENZ AUF DIE VORAUSGEGANGENE RECHNUNG
		// Zu verwenden, falls:
//		— eine vorausgegangene Rechnung korrigiert wird;
//		— aus einer Schlussrechnung auf vorausgegangene Teilrechnungen Bezug genommen wird;
//		— aus einer Schlussrechnung auf vorausgegangene Rechnungen für Vorauszahlungen Bezug genommen wird.
		invoice.setPrecedingInvoiceReference("Teilrechnung 123456T1", "2016-10-31");
		invoice.setPrecedingInvoiceReference("Teilrechnung 123456T2", "2016-11-11");
		invoice.addPrecedingInvoice(invoice.createPrecedingInvoiceReference("Teilrechnung 123456T1", "2016-10-31"));
		List<PrecedingInvoice> precedingInvoices = invoice.getPrecedingInvoices();
		assertFalse(precedingInvoices.isEmpty());
		if(precedingInvoices.get(0) instanceof ReferencedDocumentType) {
			// eine Warnung wird augegeben wg. https://github.com/klst-de/e-invoice/issues/19
			// Specification BUG in EN16931 : BG-3 PRECEDING INVOICE REFERENCE
			assertEquals(1, invoice.getPrecedingInvoices().size());
		} else {
			assertEquals(3, invoice.getPrecedingInvoices().size());
		}
		
		// BG-20 0..n DOCUMENT LEVEL ALLOWANCE:
		BigDecimal tenPerCent = new BigDecimal(10);
		AllowancesAndCharges allowance = invoice.createAllowance(new Amount(new BigDecimal(31)), new Amount(new BigDecimal(310)), tenPerCent);
		allowance.setReasoncode("64");
		allowance.setReasonText("SPECIAL AGREEMENT");
		allowance.setTaxType(TaxTypeCode.VAT);
		allowance.setTaxCategoryCode(TaxCategoryCode.StandardRate);
		allowance.setTaxPercentage(new BigDecimal(20));
		invoice.addAllowanceCharge(allowance);
		
		assertEquals(CoreInvoice.PROFILE_XRECHNUNG, invoice.getCustomization());
		assertThat(invoice.getProcessType()).isNull();
		assertEquals(DocumentNameCode.CommercialInvoice, invoice.getTypeCode());
		
		Timestamp ts = invoice.getIssueDateAsTimestamp();
		LOG.info("IssueDate (LocalDateTime):"+ts.toLocalDateTime());
		assertEquals(2016, ts.toLocalDateTime().getYear());
		assertEquals(12, ts.toLocalDateTime().getMonthValue());
		
		assertEquals(1, invoice.getInvoiceNotes().size());
		assertEquals(ADU, invoice.getInvoiceNotes().get(0).getCode());
		  
		assertEquals(contactName, invoice.getSeller().getBPContact().getContactPoint());
		assertEquals(contactTel , invoice.getSeller().getBPContact().getContactTelephone());
		assertEquals(contactMail, invoice.getSeller().getBPContact().getContactEmail());		
		assertEquals(DE, invoice.getSeller().getAddress().getCountryCode());
		assertEquals(DE, invoice.getBuyer(). getAddress().getCountryCode());
		
		Timestamp tsTaxPointDate = invoice.getTaxPointDateAsTimestamp();  // Test wg. sequenzproblem
		LocalDateTime ldtTaxPointDate = tsTaxPointDate==null ? null : tsTaxPointDate.toLocalDateTime();
		LOG.info("TaxPointDate (LocalDateTime):"+ ldtTaxPointDate);
		assertEquals(2016, tsTaxPointDate.toLocalDateTime().getYear());
		assertEquals(12, tsTaxPointDate.toLocalDateTime().getMonthValue());
		assertEquals(31, tsTaxPointDate.toLocalDateTime().getDayOfMonth());

		List<CoreInvoiceLine> lines = invoice.getLines();
		assertEquals(2, lines.size());
		assertLine01(lines.get(1));
		
		byte[] xml = transformer.fromModel(invoice);
		LOG.info(new String(xml));
	}

}
