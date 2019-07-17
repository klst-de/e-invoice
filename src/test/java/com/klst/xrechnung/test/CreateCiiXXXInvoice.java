package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.TradeLineItem;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
import com.klst.marshaller.CiiTransformer;
import com.klst.ubl.CommercialInvoice;
import com.klst.ubl.Invoice;
import com.klst.untdid.codelist.DocumentNameCode;

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
		
		cii.setSellerParty(testDoc.getSellerParty()); // statt makeSellerGroup(cii);
		cii.setBuyerParty(testDoc.getBuyerParty());
		// ... TODO
        List<TradeLineItem> lines = testDoc.getLines();
        LOG.info("LineGroup starts for "+lines.size() + " lines.");
        lines.forEach(testLine -> {
        	TradeLineItem line = new TradeLineItem
        			( testLine.getId()
        			, testLine.getQuantity()
        			, testLine.getLineTotalAmount()
        			, testLine.getItemNetPrice()
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
        	line.setOrderLineReference(testLine.getOrderLineReference());
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
