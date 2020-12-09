package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BG4_Seller;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.einvoice.unece.uncefact.FinancialAccount;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.einvoice.unece.uncefact.TradeLineItem;
import com.klst.einvoice.unece.uncefact.TradeParty;
import com.klst.einvoice.unece.uncefact.VatBreakdown;
import com.klst.marshaller.CiiTransformer;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.NoteType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ProductClassificationType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;

public class CreateCiiXXXInvoice extends InvoiceFactory {

	private static final Logger LOG = Logger.getLogger(CreateCiiXXXInvoice.class.getName());
	
	private static final String TESTDIR = "src/test/resources/"; // mit Daten aus xrechnung-1.2.0-testsuite-2018-12-14.zip\instances\
	
	private File testFile;
	private CrossIndustryInvoice testDoc;
	
	// ctor
	public CreateCiiXXXInvoice() {
		super(CiiTransformer.getInstance());
	}
	CreateCiiXXXInvoice(String ublXml) {
		super(CiiTransformer.getInstance());
		testFile = getTestFile(TESTDIR+ublXml);
		if(transformer.isValid(testFile)) {
			testDoc = toModel(testFile);
		}
	}

	@Override
	CoreInvoice makeInvoice() {
		LOG.info("\n\n");
		CoreInvoice cii = new CrossIndustryInvoice(testDoc.getCustomization(), testDoc.getTypeCode());
		cii.setId(testDoc.getId());
		cii.setIssueDate(testDoc.getIssueDateAsTimestamp());
//		cii.setDocumentCurrency(testDoc.getDocumentCurrency());                           ---- verschoben hinter pi
//		cii.setTaxCurrency(testDoc.getTaxCurrency()); // BT-6 + 0..1 (optional)
		cii.setBuyerReference(testDoc.getBuyerReferenceValue()); // BT-10 + 0..1 (optional)
		
//		makeOptionals(cii);
		cii.setTaxPointDate(testDoc.getTaxPointDateAsTimestamp()); // BT-7 BT-7-0
		cii.setOrderReference(testDoc.getOrderReference()); // BT-14 + 0..1	
		List<Object> noteList = testDoc.getNotes();
		noteList.forEach(note -> {
			if(note instanceof NoteType) {
				cii.setNote(((NoteType)note).getContent().get(0).getValue());
			}
		});
		

		BG4_Seller testSellerParty = testDoc.getSeller();
		BusinessParty sellerParty = cii.createParty( testSellerParty.getRegistrationName()     // BT-27 String name
				                          , testSellerParty.getAddress()              // TradeAddress address
				                          , testSellerParty.getIContact()             // TradeContact contact
				                          );
		sellerParty.setBusinessName(testSellerParty.getBusinessName()) ; // BT-28
		sellerParty.setId(testSellerParty.getId()); // BT-29
		sellerParty.setCompanyId(testSellerParty.getCompanyId());
		sellerParty.setCompanyLegalForm(testSellerParty.getCompanyLegalForm());
		// BT-31 + BT-32
		if(((TradeParty)testSellerParty).getSpecifiedTaxRegistration().isEmpty()) {
			LOG.warning("sellerParty.SpecifiedTaxRegistration().isEmpty() !!!!!!!!!!!!!" );
		} 
			/* 01.10a-INVOICE_uncefact.xml                      hat zwei Einträge:
                <ram:SpecifiedTaxRegistration>
                    <ram:ID schemeID="VA">DE123456789</ram:ID>
                </ram:SpecifiedTaxRegistration>
                <ram:SpecifiedTaxRegistration>
                    <ram:ID schemeID="FC">123/456/789</ram:ID>
                </ram:SpecifiedTaxRegistration>

			 */
		TradeParty testTradeSellerParty = (TradeParty)testSellerParty;
		LOG.info("sellerParty.d#:"+testTradeSellerParty.getSpecifiedTaxRegistration().size());
		testTradeSellerParty.getSpecifiedTaxRegistration().forEach(taxRegistration -> {
			String BT_31 = taxRegistration.getID().getValue();
			String BT_31_0 = taxRegistration.getID().getSchemeID();
			LOG.info("SpecifiedTaxRegistration value ID/BT_31:"+BT_31
					+" schemeID/BT_31_0:"+BT_31_0
					);
			if(BT_31_0.equals("FC") && BT_31.equals("123/456/789") && testTradeSellerParty.getSpecifiedTaxRegistration().size()==1) {
				// harccoded patch wg. https://github.com/klst-de/e-invoice/issues/5
				sellerParty.setTaxRegistrationId("DE123456789", "VA");
			}
			sellerParty.setTaxRegistrationId(BT_31, BT_31_0);
		});
		LOG.info("?Seller identifier (BT-29):"+sellerParty.getRegistrationName()
				+" legal registration identifier (BT-30):"+sellerParty.getCompanyLegalForm()
				+" VAT identifier (BT-31):"+sellerParty.getTaxRegistrationId()
				);
		cii.setSeller((TradeParty)sellerParty);
		
		BG7_Buyer buyerParty = testDoc.getBuyer();
		if(((TradeParty)buyerParty).getSpecifiedTaxRegistration().isEmpty()) {
			LOG.warning("buyerParty.SpecifiedTaxRegistration().isEmpty() !!!!!!!!!!!!!" );
		} else {
			TradeParty buyerTradeParty = (TradeParty)buyerParty;
			LOG.info("buyerParty.SpecifiedTaxRegistration#:"+buyerTradeParty.getSpecifiedTaxRegistration().size()
					+ " ID:"+buyerTradeParty.getSpecifiedTaxRegistration().get(0).getID().getValue()
					+ " schemeID:"+buyerTradeParty.getSpecifiedTaxRegistration().get(0).getID().getSchemeID()
					);
		}
		LOG.info("buyerParty:"+buyerParty.getBusinessName() + " Address:"+buyerParty.getAddress());
		cii.setBuyer(buyerParty);
		
		BusinessParty testPayeeParty = testDoc.getPayee();
		if(testPayeeParty==null) {
			LOG.warning("testPayeeParty==null" );
		} else {
			LOG.info("testPayeeParty.RegistrationName:"+testPayeeParty.getRegistrationName()
					+ " Id:"+testPayeeParty.getId()
					+ " CompanyLegalForm:"+testPayeeParty.getCompanyLegalForm()
					);
			cii.setPayee(testPayeeParty.getRegistrationName(), testPayeeParty.getId(), testPayeeParty.getCompanyLegalForm());
		}
		
		BusinessParty testSellerTaxRepresentativeParty = testDoc.getTaxRepresentative();
		if(testSellerTaxRepresentativeParty==null) {
			LOG.warning("testSellerTaxRepresentativeParty==null" );
		} else {
			LOG.info("testSellerTaxRepresentativeParty.Name:"+((TradeParty)testSellerTaxRepresentativeParty).getRegistrationName()
					+ " Address:"+((TradeParty)testSellerTaxRepresentativeParty).getAddress()
					+ " TaxRegistrationId:"+((TradeParty)testSellerTaxRepresentativeParty).getTaxRegistrationId()
					);
			cii.setTaxRepresentative(testSellerTaxRepresentativeParty.getRegistrationName()
					, ((TradeParty)testSellerTaxRepresentativeParty).getAddress()
					, testSellerTaxRepresentativeParty.getTaxRegistrationId()
//					, CoreInvoiceVatBreakdown.VAT);
					, "VA");
		}
		
		BG13_DeliveryInformation delivery = testDoc.getDelivery();
		if(delivery!=null) {
			LOG.info("delivery:"+delivery);
			cii.setDelivery(delivery);
		}
		
		PaymentInstructions pi = testDoc.getPaymentInstructions();
		LOG.info("testDoc.PaymentInstructions pi.RemittanceInformation:"+pi.getRemittanceInformation() + 
				" PaymentMeansEnum:"+pi.getPaymentMeansEnum() + " PaymentMeansText:"+pi.getPaymentMeansText());
		List<CreditTransfer> creditTransferList = pi.getCreditTransfer();
		CreditTransfer creditTransferAccount = null;
		if(creditTransferList.isEmpty()) {
			// no CreditTransfer
		} else {
			creditTransferList.forEach(testCT -> {
				LOG.info("interface CreditTransfer "+testCT);
			});
			creditTransferAccount = creditTransferList.get(0);
		}
		
		DirectDebit directDebitAccount = null; // getMandateReferencetID : direct debit authorisation == Einzugsermächtigung
		DirectDebit dd = pi.getDirectDebit(); // interface DirectDebit
		if(dd==null) {
			// no DirectDebit
		} else {
			LOG.info("interface DirectDebit "+dd);
			IBANId iban = new IBANId(dd.getDebitedAccountID());
			directDebitAccount = new FinancialAccount(iban);
		}

		cii.setPaymentInstructions(pi.getPaymentMeansEnum(), pi.getPaymentMeansText(), pi.getRemittanceInformation(), creditTransferAccount, null, directDebitAccount);

		cii.setDocumentCurrency(testDoc.getDocumentCurrency());
		cii.setTaxCurrency(testDoc.getTaxCurrency()); // BT-6 + 0..1 (optional)

		LOG.info("testDoc.getPaymentTerm():"+testDoc.getPaymentTerm() + " testDoc.getDueDateAsTimestamp():"+testDoc.getDueDateAsTimestamp());
		cii.setPaymentTermsAndDate(testDoc.getPaymentTerm(), testDoc.getDueDateAsTimestamp()); // BT-9 & BT-20 (optional)
		
		// es ist entscheidend, dass die setter nach cii.setPaymentInstructions ausgeführt werden!!!!!!!!!!!!!!!
		LOG.info(">>> testDoc.StartDateAsTimestamp "+ testDoc.getStartDateAsTimestamp());
		cii.setStartDate(testDoc.getStartDateAsTimestamp());
		cii.setEndDate(testDoc.getEndDateAsTimestamp());
		
        List<VatBreakdown> vbdList = testDoc.getVATBreakDowns();
        LOG.info("VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
        vbdList.forEach(tradeTax -> {
        	CoreInvoiceVatBreakdown vatBreakdown = new VatBreakdown( new Amount(tradeTax.getBasisAmount().get(0).getValue())
					,new Amount(tradeTax.getCalculatedAmount().get(0).getValue())
					,TaxCategoryCode.valueOf(tradeTax.getCategoryCode())
					,tradeTax.getRateApplicablePercent()==null ? null : tradeTax.getRateApplicablePercent().getValue()
					);
        	vatBreakdown.setTaxExemption(tradeTax.getExemptionReason()==null ? null : tradeTax.getExemptionReason().getValue()
        			, tradeTax.getExemptionReasonCode()==null ? null : tradeTax.getExemptionReasonCode().getValue());
        	cii.addVATBreakDown(vatBreakdown);
        	LOG.info("added vatBreakdown "+vatBreakdown);
        });
		
        Amount prePaidAmount = testDoc.getPrepaid();
    	LOG.info("-----------------Prepaid amount "+prePaidAmount);
        cii.setDocumentTotals(testDoc.getInvoiceLineNetTotal(), 
				testDoc.getInvoiceTotalTaxExclusive(), 
				testDoc.getInvoiceTotalTaxInclusive(), 
				testDoc.getDuePayable());
        cii.setInvoiceTax(testDoc.getInvoiceTax());
        cii.setPrepaid(prePaidAmount);
        
//        cii.setInvoiceTaxInAccountingCurrency(  ...  ist nicht implementiert TODO

        List<TradeLineItem> lines = testDoc.getLines();
        LOG.info("LineGroup starts for "+lines.size() + " lines.");
        lines.forEach(testLine -> {
        	LOG.info("testLine.getTaxCategory() = "+testLine.getTaxCategory() + " , testLine.getTaxRate() = "+testLine.getTaxRate());
        	CoreInvoiceLine line = new TradeLineItem
        			( testLine.getId()
        			, testLine.getQuantity()
        			, testLine.getLineTotalAmount()
        			, testLine.getUnitPriceAmount()
        			, testLine.getItemName()
        			, testLine.getTaxCategory(), testLine.getTaxRate() // mandatory, rate can be null
        			);
        	
        	line.setNote(testLine.getNote()); // opt
        	line.setDescription(testLine.getDescription());
        	line.setSellerAssignedID(testLine.getSellerAssignedID()); // 0..1 BT-128 ram:SellerAssignedID
        	List<Object> cl = testLine.getClassificationList();
        	cl.forEach(c -> {
        		if(c.getClass() == ProductClassificationType.class) {
        			CodeType cc = ((ProductClassificationType)c).getClassCode();
        			line.addClassificationID(cc.getValue(), cc.getListID(), cc.getListVersionID());
        		}
        	});
        	line.setOrderLineID(testLine.getOrderLineID());
        	cii.addLine(line);
        });
        LOG.info("LineGroup finished.");
		return cii;
	}
//	void makeOptionals(CrossIndustryInvoice cii) {	
//		
//		cii.setTaxPointDate(testDoc.getTaxPointDateAsTimestamp()); // BT-7 BT-7-0
//		
////		cii.setProjectReference("PR12345678", "Project reference");
//		
//		cii.setOrderReference(testDoc.getOrderReference()); // BT-14 + 0..1
//		
//		List<Object> noteList = testDoc.getNotes();
//		noteList.forEach(note -> {
//			cii.addNote(note);
//		});
//		LOG.info("finished.");
//	}


	private File getTestFile(String uri) {
		File file = new File(uri);
		LOG.info("test file "+file.getAbsolutePath() + " canRead:"+file.canRead());
		return file;
	}
	
	private CrossIndustryInvoice toModel(File xmlfile) {
		CrossIndustryInvoiceType invoice;
		CrossIndustryInvoice cii = null;
		try {
			InputStream is = new FileInputStream(xmlfile);
			invoice = transformer.toModel(is);
			cii = new CrossIndustryInvoice(invoice);
			// TODO ...
		} catch (Exception ex) {
			ex.printStackTrace();
			LOG.severe(ex.getMessage());
		}
		return cii;
	}

}
