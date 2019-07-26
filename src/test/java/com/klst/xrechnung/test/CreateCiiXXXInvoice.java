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
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.einvoice.unece.uncefact.IBANId;
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
		CrossIndustryInvoice cii = new CrossIndustryInvoice(testDoc.getCustomization(), testDoc.getTypeCode());
		cii.setId(testDoc.getId());
		cii.setIssueDate(testDoc.getIssueDateAsTimestamp());
		cii.setDocumentCurrency(testDoc.getDocumentCurrency());
		cii.setTaxCurrency(testDoc.getTaxCurrency());
		cii.setBuyerReference(testDoc.getBuyerReferenceValue());
		
		makeOptionals(cii);
		

		TradeParty sellerParty = testDoc.getSellerParty();
		if(sellerParty.getSpecifiedTaxRegistration().isEmpty()) {
			LOG.warning("sellerParty.getSpecifiedTaxRegistration().isEmpty() !!!!!!!!!!!!!" );
		} else {
			LOG.info("sellerParty.SpecifiedTaxRegistration#:"+sellerParty.getSpecifiedTaxRegistration().size()
					+ " ID:"+sellerParty.getSpecifiedTaxRegistration().get(0).getID().getValue()
					+ " schemeID:"+sellerParty.getSpecifiedTaxRegistration().get(0).getID().getSchemeID()
					);
			if(sellerParty.getSpecifiedTaxRegistration().get(0).getID().getSchemeID().equals(CoreInvoiceVatBreakdown.VAT)) {
				LOG.info("OK schemeID is "+CoreInvoiceVatBreakdown.VAT);
			} else {
				LOG.warning("Korrektur wg. https://github.com/klst-de/e-invoice/issues/5 schemeID is "+sellerParty.getSpecifiedTaxRegistration().get(0).getID().getSchemeID());
				sellerParty.getSpecifiedTaxRegistration().get(0).getID().setSchemeID(CoreInvoiceVatBreakdown.VAT);
			}
		}
		
		cii.setSellerParty(sellerParty);
		cii.setBuyerParty(testDoc.getBuyerParty());
		
		cii.setPaymentInstructions(testDoc.getPaymentMeansCode(), null, testDoc.getRemittanceInformation()); //paymentMeansText, remittanceInformation);
		CreditTransfer testCT = testDoc.getCreditTransfer();
		LOG.info("testCT.PaymentAccountID:"+testCT.getPaymentAccountID() 
			+ ", testCT.PaymentAccountName:"+testCT.getPaymentAccountName()
			+ ", testCT.getPaymentServiceProviderID:"+testCT.getPaymentServiceProviderID());
		CreditTransfer ciiCT = cii.createCreditTransfer(new IBANId(testCT.getPaymentAccountID()), testCT.getPaymentAccountName(), testCT.getPaymentServiceProviderID()==null ? null : new BICId(testCT.getPaymentServiceProviderID()));
		
		cii.setDelivery(null);// ... TODO
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
		cii.setOrderReferenceID(testDoc.getOrderReferenceID());
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
