package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.ApplicableHeaderTradeDelivery;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.einvoice.unece.uncefact.TradeContact;
import com.klst.einvoice.unece.uncefact.TradeLineItem;
import com.klst.einvoice.unece.uncefact.TradeParty;
import com.klst.einvoice.unece.uncefact.VatBreakdown;
import com.klst.marshaller.CiiTransformer;
import com.klst.untdid.codelist.TaxCategoryCode;

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;
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
	CrossIndustryInvoice makeInvoice() {
		LOG.info("\n\n");
		CrossIndustryInvoice cii = new CrossIndustryInvoice(testDoc.getCustomization(), testDoc.getTypeCode());
		cii.setId(testDoc.getId());
		cii.setIssueDate(testDoc.getIssueDateAsTimestamp());
		cii.setDocumentCurrency(testDoc.getDocumentCurrency());
		cii.setTaxCurrency(testDoc.getTaxCurrency()); // BT-6 + 0..1 (optional)
		cii.setBuyerReference(testDoc.getBuyerReferenceValue()); // BT-10 + 0..1 (optional)
		
		makeOptionals(cii);
		

		TradeParty testSellerParty = testDoc.getSellerParty();
		TradeParty sellerParty = new TradeParty( testSellerParty.getBusinessName()     // BT-27 String name
				                               , testSellerParty.getAddress()          // TradeAddress address
				                               , (TradeContact)(testSellerParty.getIContact())         // TradeContact contact
				                               , testSellerParty.getCompanyId()        // BT-30 String companyId
				                               , testSellerParty.getCompanyLegalForm() // BT-33 String companyLegalForm
				                               );
//		sellerParty.setTradingBusinessName(testSellerParty.getTradingBusinessName()) ; // BT-28
		sellerParty.setId(testSellerParty.getId()); // BT-29
		// BT-31 + BT-32
		if(testSellerParty.getSpecifiedTaxRegistration().isEmpty()) {
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
		LOG.info("sellerParty.SpecifiedTaxRegistration#:"+testSellerParty.getSpecifiedTaxRegistration().size());
		testSellerParty.getSpecifiedTaxRegistration().forEach(taxRegistration -> {
			String BT_31 = taxRegistration.getID().getValue();
			String BT_31_0 = taxRegistration.getID().getSchemeID();
			LOG.info(" value ID/BT_31:"+BT_31
					+" schemeID/BT_31_0:"+BT_31_0
					);
//			if(BT_31_0.equals("VA")) {
//				// OK : Umsatzsteuernummer
////				if(BT_31.startsWith(testSellerParty.getAddress().getCountryCode())) {
////					// OK : Umsatzsteuernummer mit vorangestelltem Ländercode.
////				} else {
////					LOG.warning("Korrektur wg. https://github.com/klst-de/e-invoice/issues/5 : Umsatzsteuernummer mit vorangestelltem Ländercode. ");
////					BT_31 = testSellerParty.getAddress().getCountryCode() + BT_31;
////				}	
//			} else {
//				if(testSellerParty.getSpecifiedTaxRegistration().size()==1) {
//					LOG.warning("Korrektur wg. https://github.com/klst-de/e-invoice/issues/5 : schemeID is "+BT_31_0);
////					BT_31_0 = "VA";
////					BT_31 = testSellerParty.getAddress().getCountryCode() + BT_31;
//					sellerParty.setTaxRegistrationId(testSellerParty.getAddress().getCountryCode()+"123456789", "VA");
//				} else {
//					LOG.warning("KEINE Korrektur wg. https://github.com/klst-de/e-invoice/issues/5 : schemeID is "+BT_31_0);
//				}
//			}
////			if(BT_31.startsWith(testSellerParty.getAddress().getCountryCode())) {
////				// OK : Umsatzsteuernummer mit vorangestelltem Ländercode.
////			} else {
////				LOG.warning("Korrektur wg. https://github.com/klst-de/e-invoice/issues/5 : Umsatzsteuernummer mit vorangestelltem Ländercode. ");
////				BT_31 = testSellerParty.getAddress().getCountryCode() + BT_31;
////			}	
			if(BT_31_0.equals("FC") && BT_31.equals("123/456/789") && testSellerParty.getSpecifiedTaxRegistration().size()==1) {
				// harccoded patch wg. https://github.com/klst-de/e-invoice/issues/5
				sellerParty.setTaxRegistrationId("DE123456789", "VA");
			}
			sellerParty.setTaxRegistrationId(BT_31, BT_31_0);
		});
		LOG.info("?Seller identifier (BT-29):"+sellerParty.getRegistrationName()
				+" legal registration identifier (BT-30):"+sellerParty.getCompanyLegalForm()
				+" VAT identifier (BT-31):"+sellerParty.getTaxRegistrationId()
				);
//		sellerParty.setUriUniversalCommunication(testSellerParty.getUriUniversalCommunication()); // BT-34
		cii.setSellerParty(sellerParty);
		
		TradeParty buyerParty = testDoc.getBuyerParty();
		if(buyerParty.getSpecifiedTaxRegistration().isEmpty()) {
			LOG.warning("buyerParty.SpecifiedTaxRegistration().isEmpty() !!!!!!!!!!!!!" );
		} else {
			LOG.info("buyerParty.SpecifiedTaxRegistration#:"+buyerParty.getSpecifiedTaxRegistration().size()
					+ " ID:"+buyerParty.getSpecifiedTaxRegistration().get(0).getID().getValue()
					+ " schemeID:"+buyerParty.getSpecifiedTaxRegistration().get(0).getID().getSchemeID()
					);
//			buyerParty.setTaxRegistrationId(buyerParty.getSpecifiedTaxRegistration().get(0).getID().getValue(), buyerParty.getSpecifiedTaxRegistration().get(0).getID().getSchemeID());
		}
		cii.setBuyerParty(buyerParty);
		
		TradeParty testPayeeParty = testDoc.getPayeeParty();
		if(testPayeeParty==null) {
			LOG.warning("testPayeeParty==null" );
		} else {
			LOG.info("testPayeeParty.RegistrationName:"+testPayeeParty.getBusinessName()
					+ " Id:"+testPayeeParty.getId()
					+ " CompanyLegalForm:"+testPayeeParty.getCompanyLegalForm()
					);
//			TradeParty payeeParty = new TradeParty( testPayeeParty.getRegistrationName()
//                    , null         // TradeAddress address
//                    , null         // TradeContact contact
//                    , testPayeeParty.getCompanyId()
//                    , testPayeeParty.getCompanyLegalForm()
//                    );
//			payeeParty.setId(testPayeeParty.getId());
//			cii.setPayeeParty(payeeParty); // alternativ:
			cii.setPayee(testPayeeParty.getBusinessName(), testPayeeParty.getId(), testPayeeParty.getCompanyLegalForm());
		}
		
		TradeParty testSellerTaxRepresentativeParty = testDoc.getTaxRepresentativeParty();
		if(testSellerTaxRepresentativeParty==null) {
			LOG.warning("testPayeeParty==null" );
		} else {
			LOG.info("testSellerTaxRepresentativeParty.Name:"+testSellerTaxRepresentativeParty.getBusinessName()
					+ " Address:"+testSellerTaxRepresentativeParty.getAddress()
					+ " TaxRegistrationId:"+testSellerTaxRepresentativeParty.getTaxRegistrationId()
					);
			cii.setTaxRepresentative(testSellerTaxRepresentativeParty.getBusinessName()
					, testSellerTaxRepresentativeParty.getAddress()
					, testSellerTaxRepresentativeParty.getTaxRegistrationId()
//					, CoreInvoiceVatBreakdown.VAT);
					, "VA");
		}
		
		LOG.info("testDoc.getPaymentTerm():"+testDoc.getPaymentTerm() + " testDoc.getDueDateAsTimestamp():"+testDoc.getDueDateAsTimestamp());
		cii.setPaymentTermsAndDate(testDoc.getPaymentTerm(), testDoc.getDueDateAsTimestamp()); // BT-9 & BT-20 (optional)
		
		ApplicableHeaderTradeDelivery delivery = (ApplicableHeaderTradeDelivery)testDoc.getDeliveryInformation();
		if(delivery!=null) {
			LOG.info("delivery:"+delivery);
			cii.setDeliveryInformation(delivery);
//			cii.setDeliveryInformation(delivery.getBusinessName() // String businessName
//					, delivery.getActualDate() // Timestamp ts
//					, delivery.getAddress() // PostalAddress address
//					, delivery.getId() // String locationId
//					); 
		}
		
		cii.setPaymentInstructions(testDoc.getPaymentMeansCode(), null, testDoc.getRemittanceInformation()); //paymentMeansText, remittanceInformation);
		CreditTransfer testCT = testDoc.getCreditTransfer();
		LOG.info("testCT.PaymentAccountID:"+testCT.getPaymentAccountID() 
			+ ", testCT.PaymentAccountName:"+testCT.getPaymentAccountName()
			+ ", testCT.getPaymentServiceProviderID:"+testCT.getPaymentServiceProviderID());
		CreditTransfer ciiCT = cii.createCreditTransfer(new IBANId(testCT.getPaymentAccountID()), testCT.getPaymentAccountName(), testCT.getPaymentServiceProviderID()==null ? null : new BICId(testCT.getPaymentServiceProviderID()));
		
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
        });
		
        cii.setDocumentTotals(testDoc.getInvoiceLineNetTotal(), 
				testDoc.getInvoiceTotalTaxExclusive(), 
				testDoc.getInvoiceTotalTaxInclusive(), testDoc.getDuePayable());
        cii.setInvoiceTax(testDoc.getInvoiceTax());
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
        	
        	line.setNoteText(testLine.getNoteText()); // opt
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
	void makeOptionals(CrossIndustryInvoice cii) {	
		
		cii.setTaxPointDate(testDoc.getTaxPointDateAsTimestamp()); // BT-7 BT-7-0
		
//		cii.setProjectReference("PR12345678", "Project reference");
		
		cii.setOrderReferenceID(testDoc.getOrderReferenceID()); // BT-14 + 0..1
		
		List<String> notes = testDoc.getNotes();
		notes.forEach(note -> {
			cii.setNote(note);
		});
		LOG.info("finished.");
	}


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
