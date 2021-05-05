package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.klst.edoc.api.BusinessParty;
import com.klst.edoc.api.BusinessPartyAddress;
import com.klst.edoc.api.BusinessPartyContact;
import com.klst.edoc.api.IAmount;
import com.klst.edoc.api.IQuantity;
import com.klst.edoc.api.Identifier;
import com.klst.edoc.untdid.PaymentMeansEnum;
import com.klst.einvoice.api.AllowancesAndCharges;
import com.klst.einvoice.api.CoreInvoice;
import com.klst.einvoice.api.CoreInvoiceLine;
import com.klst.einvoice.api.CreditTransfer;
import com.klst.einvoice.api.DirectDebit;
import com.klst.einvoice.api.GlobalIdentifier;
import com.klst.einvoice.api.InvoiceNote;
import com.klst.einvoice.api.PaymentInstructions;
import com.klst.einvoice.api.PrecedingInvoice;
import com.klst.einvoice.api.SupportingDocument;
import com.klst.einvoice.api.VatBreakdown;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.marshaller.UblCreditNoteTransformer;
import com.klst.marshaller.UblInvoiceTransformer;

import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

public class CreateUblXXXInvoice extends InvoiceFactory {

	private static final Logger LOG = Logger.getLogger(CreateUblXXXInvoice.class.getName());
	
	private static final String TESTDIR = "src/test/resources/"; // mit Daten aus xrechnung-1.2.0-testsuite-2018-12-14.zip\instances\
	
	private File testFile;
	private CoreInvoice testDoc;
	private CoreInvoice testCN; // GenericInvoice ===> CoreInvoice
	
	// ctor
	public CreateUblXXXInvoice() {
		super(UblInvoiceTransformer.getInstance());
	}
	CreateUblXXXInvoice(String ublXml) {
		super(UblInvoiceTransformer.getInstance());
		testFile = getTestFile(TESTDIR+ublXml);
		if(transformer.isValid(testFile)) {
			testDoc = toModel(testFile);
		} else {
			LOG.warning(ublXml + "ist nicht UblInvoice!!!!!!!!!!!!!!! versuche UblCreditNote:");
			this.transformer = UblCreditNoteTransformer.getInstance();
			if(transformer.isValid(testFile)) {
				testDoc = null;
				testCN = toModelCN(testFile);
			}
		}
	}

	public CoreInvoice getTestDoc() {
		return testDoc;
	}
		
	Object makeCreditNote() {
		LOG.info("\n (BG-2.BT-24)ProcessType="+testCN.getProcessType() + " (BG-2.BT-24)Customization="+testCN.getCustomization()
			+ " (BT-3)TypeCode="+testCN.getTypeCode());
		CoreInvoice ublInvoice = GenericInvoice.getFactory().createInvoice(testCN.getCustomization(), testCN.getProcessType(), testCN.getTypeCode());
		ublInvoice.setId(testCN.getId());
		ublInvoice.setIssueDate(testCN.getIssueDateAsTimestamp());
		ublInvoice.setDocumentCurrency(testCN.getDocumentCurrency());
		ublInvoice.setTaxCurrency(testCN.getTaxCurrency());
		ublInvoice.setBuyerReference(testCN.getBuyerReferenceValue());
		
		makeOptionals(ublInvoice, testCN);
		
		ublInvoice.setSeller(testCN.getSeller());
		ublInvoice.setBuyer(testCN.getBuyer());
		ublInvoice.setPayee(testCN.getPayee());
		ublInvoice.setTaxRepresentative(testCN.getTaxRepresentative());

		makePaymentGroup(ublInvoice, testCN);
		
		ublInvoice.setDocumentTotals(testCN.getInvoiceLineNetTotal(), 
					testCN.getInvoiceTotalTaxExclusive(), 
					testCN.getInvoiceTotalTaxInclusive(), 
					testCN.getDuePayable());
		ublInvoice.setInvoiceTax(testCN.getInvoiceTax());
		LOG.info("finished DocumentTotalsGroup.");
		
        List<VatBreakdown> vbdList = ((GenericInvoice)testCN).getVATBreakDowns();
        LOG.info("CreditNote VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
        vbdList.forEach(tradeTax -> {
        	VatBreakdown vatBreakdown = ublInvoice.createVATBreakDown( tradeTax.getTaxBaseAmount(),
        			tradeTax.getCalculatedTaxAmount(),
        			tradeTax.getTaxCategoryCode(),
        			tradeTax.getTaxPercentage() );
        	
        	// 0..1 (optional) BG-23.BT-120 ExemptionReason Grund der Steuerbefreiung (Freitext)
        	// 0..1 (optional) BG-23.BT-121 ExemptionReasonCode Code für den Umsatzsteuerbefreiungsgrund
        	vatBreakdown.setTaxExemption(tradeTax.getTaxExemptionReasonText(), tradeTax.getTaxExemptionReasonCode());
        	ublInvoice.addVATBreakDown(vatBreakdown);
        	LOG.info("added vatBreakdown "+vatBreakdown);
        });
		LOG.info("finished. "+vbdList.size() + " vatBreakDowns.");
		
		makeLineGroup(ublInvoice, testCN);
		LOG.info("LineGroup finished.");

		return ublInvoice;
	}
	@Override
	Object makeInvoice() {
		if(testDoc==null) {
			return makeCreditNote();
		}
		LOG.info("\n (BG-2.BT-24)ProcessType="+testDoc.getProcessType() + " (BG-2.BT-24)Customization="+testDoc.getCustomization()
			+ " (BT-3)TypeCode="+testDoc.getTypeCode());
		CoreInvoice ublInvoice = GenericInvoice.getFactory().createInvoice(testDoc.getCustomization(), testDoc.getProcessType(), testDoc.getTypeCode());
		ublInvoice.setId(testDoc.getId());
		ublInvoice.setIssueDate(testDoc.getIssueDateAsTimestamp());
		ublInvoice.setDocumentCurrency(testDoc.getDocumentCurrency());
		ublInvoice.setTaxCurrency(testDoc.getTaxCurrency());
		ublInvoice.setBuyerReference(testDoc.getBuyerReferenceValue());
		ublInvoice.setDeliveryPeriod(testDoc.getDeliveryPeriod());  // BG-14 optional
		LOG.info("ublInvoice "+ublInvoice);
		
		ublInvoice.setSeller(testDoc.getSeller());
		LOG.info("Seller Address and Contact "+((BusinessPartyAddress)ublInvoice.getSeller()).getAddress() 
				+ " "+((BusinessPartyContact)ublInvoice.getSeller()).getContactInfo());
		BusinessParty buyer = testDoc.getBuyer();
		ublInvoice.setBuyer(testDoc.getBuyer());
		LOG.info("Buyer UriUniversalCommunication:" + buyer.getUriUniversalCommunication());
		LOG.info("Buyer Address and Contact "+((BusinessPartyAddress)ublInvoice.getBuyer()).getAddress() 
				+ " "+((BusinessPartyContact)ublInvoice.getBuyer()).getContactInfo());
		
		makeOptionals(ublInvoice, testDoc);
		
		makePaymentGroup(ublInvoice, testDoc);
		
		ublInvoice.setDocumentTotals(testDoc.getInvoiceLineNetTotal(), 
				testDoc.getInvoiceTotalTaxExclusive(), 
				testDoc.getInvoiceTotalTaxInclusive(), 
				testDoc.getDuePayable());
		
		Amount invoiceTaxAmount =  testDoc.getInvoiceTax();
        Amount invoiceTaxIAAmount = testDoc.getInvoiceTaxInAccountingCurrency();
    	boolean sameCurrency = false;
    	if(testDoc.getTaxCurrency()==null || testDoc.getDocumentCurrency().equals(testDoc.getTaxCurrency())) {
    		sameCurrency = true;
    	}
    	if(sameCurrency) { 
        	LOG.info("            VAT+doc same currency       "+testDoc.getDocumentCurrency());
    	} else {
        	LOG.info("            VAT+doc diff currency   VAT "+testDoc.getTaxCurrency()+" / Doc "+testDoc.getDocumentCurrency());    		
    	}
    	LOG.info("----------------------InvoiceTax amount "+invoiceTaxAmount);
    	LOG.info("--InvoiceTaxInAccountingCurrency amount "+invoiceTaxIAAmount);
    	if(sameCurrency) {
    		ublInvoice.setInvoiceTax(invoiceTaxAmount);
    	} else {
    		// Bsp. 02.01a:
    		//  <cbc:DocumentCurrencyCode>EUR</cbc:DocumentCurrencyCode>
    		//  <cbc:TaxCurrencyCode>GBP</cbc:TaxCurrencyCode>
    		// Bsp. ubl-tc434-example5.xml
    	    //	<cbc:DocumentCurrencyCode>DKK</cbc:DocumentCurrencyCode>
    	    //	<cbc:TaxCurrencyCode>EUR</cbc:TaxCurrencyCode>
    		ublInvoice.setInvoiceTax(invoiceTaxAmount);   	
            ublInvoice.setInvoiceTaxInAccountingCurrency(invoiceTaxIAAmount);
    	}

    	Amount invoiceATAmount = testDoc.getAllowancesTotal();
    	LOG.info("-----------------AllowancesTotal amount "+invoiceATAmount);
    	if(invoiceATAmount!=null) {
    		ublInvoice.setAllowancesTotal(invoiceATAmount);
    	}
        Amount invoiceChargesAmount = testDoc.getChargesTotal();
    	LOG.info("--------------------ChargesTotal amount "+invoiceChargesAmount);
    	if(invoiceChargesAmount!=null) {
    		ublInvoice.setChargesTotal(invoiceChargesAmount);
    	}
        Amount invoiceRoundingAmount = testDoc.getRounding();
    	LOG.info("------------------------Rounding amount "+invoiceRoundingAmount);
    	if(invoiceRoundingAmount!=null) {
    		ublInvoice.setRounding(invoiceRoundingAmount);
    	} 
		
		LOG.info("(optional) getPrepaid="+testDoc.getPrepaid());	
		ublInvoice.setPrepaid(testDoc.getPrepaid());
		LOG.info("finished DocumentTotalsGroup.");

		LOG.info("(optional) getTaxPointDate="+testDoc.getTaxPointDateAsTimestamp());	
		Timestamp testTpd = testDoc.getTaxPointDateAsTimestamp();	
		LOG.info("(optional) getTaxPointDate="+testTpd);	
    	if(testDoc.getTaxPointDateAsTimestamp()!=null) {
    		ublInvoice.setTaxPointDate(testTpd);
    	}

		List<AllowancesAndCharges> allowancesAndCharges = testDoc.getAllowancesAndCharges();
		LOG.info("(optional) AllowancesAndCharges #:"+allowancesAndCharges.size());
		allowancesAndCharges.forEach(aac -> {
			ublInvoice.addAllowanceCharge(aac);
		});
		
		makeVatBreakDownGroup(ublInvoice);
		makeLineGroup(ublInvoice, testDoc);
		LOG.info("finished.");
		return ublInvoice;
	}

	void makeOptionals(CoreInvoice ublInvoice, CoreInvoice testDoc) {	
		LOG.info("testDoc.ProjectReference="+
				(testDoc.getProjectReference()==null ? "null" : testDoc.getProjectReference().getID()));
		ublInvoice.setProjectReference(testDoc.getProjectReference()); // BT-11 + 0..1
		ublInvoice.setContractReference(testDoc.getContractReference()); // BT-12 + 0..1
		ublInvoice.setPurchaseOrderReference(testDoc.getPurchaseOrderReference()); // BT-13 + 0..1
		ublInvoice.setOrderReference(testDoc.getOrderReference()); // BT-14 + 0..1
		
		ublInvoice.setReceiptReference(testDoc.getReceiptReference()); // BT-15 + 0..1
		ublInvoice.setDespatchAdviceReference(testDoc.getDespatchAdviceReference()); // BT-16 + 0..1
		String _BT17_tenderOrLotReference = testDoc.getTenderOrLotReference();
		LOG.info("_BT17_tenderOrLotReference="+_BT17_tenderOrLotReference);
		ublInvoice.setTenderOrLotReference(testDoc.getTenderOrLotReference()); // BT-17 + 0..1
		// BT-18 + 0..1
		// Testfälle 01.15a , 02.01a:
		Identifier identifierBT18 = testDoc.getInvoicedObjectIdentifier();
		if(identifierBT18!=null) {
			ublInvoice.setInvoicedObjectIdentifier(identifierBT18);
//			ublInvoice.setInvoicedObject(identifierBT18.getContent());
//			ublInvoice.setInvoicedObject(identifierBT18.getContent(), identifierBT18.getSchemeIdentifier());
		}
		ublInvoice.setBuyerAccountingReference(testDoc.getBuyerAccountingReference()); // BT-19 + 0..1

		// 0..n BG3_PrecedingInvoiceReference:
		List<PrecedingInvoice> precedingInvoices = testDoc.getPrecedingInvoices();
		String precedingInvoiceReference = precedingInvoices.isEmpty() ? null : precedingInvoices.get(0).getDocumentReference().getName();
		if(precedingInvoiceReference!=null) {
			LOG.info("BG3_PrecedingInvoiceReference: "+precedingInvoiceReference);
			// Datum erfunden TODO
			ublInvoice.setPrecedingInvoiceReference(precedingInvoiceReference, "2013-03-10");
		}

		List<InvoiceNote> notes = testDoc.getInvoiceNotes();
		notes.forEach(invoiceNote -> {
			ublInvoice.addNote(invoiceNote.getCode(), invoiceNote.getNote());
		});
		
		BusinessParty payeeParty = testDoc.getPayee(); // optional BG-10
		if(payeeParty!=null) { // BT-61 ++ 0..1 Payee legal registration identifier
			LOG.info("BT-59 Payee.BusinessName (aka Name):"+payeeParty.getBusinessName() // BT-59
				+ " Payee.Id:"+payeeParty.getId()                                        // BT-60 (ohne schema)
				+ " Payee.CompanyId:"+payeeParty.getCompanyId()                          // BT-61
				+ " Payee.CompanyLegalForm:"+payeeParty.getCompanyLegalForm() 
				+ " Payee.RegistrationName:"+payeeParty.getRegistrationName() 
				);
			Identifier payeePartyId = payeeParty.getIdentifier();
//			BusinessParty payee = ublInvoice.createParty(payeeParty.getRegistrationName(), payeeParty.getBusinessName(), null, null);  // BT-59
			if(payeePartyId!=null && payeePartyId.getSchemeIdentifier()!=null) {
				BusinessParty payee = ublInvoice.createParty(payeeParty.getRegistrationName(), payeeParty.getBusinessName(), null, null);  // BT-59
				payee.setIdentifier(payeePartyId); // BT-60 mit schema
				payee.setCompanyIdentifier(payeeParty.getCompanyIdentifier());
				ublInvoice.setPayee(payee);
			} else {
				ublInvoice.setPayee(payeeParty.getBusinessName() // BT-59
						, payeeParty.getId()                     // BT-60 (ohne schema)
						, payeeParty.getCompanyId()              // BT-61 (ohne schema)
						);
			}
		}
		ublInvoice.setTaxRepresentative(testDoc.getTaxRepresentative());
		ublInvoice.setDeliveryPeriod(testDoc.getDeliveryPeriod());
		ublInvoice.setDelivery(testDoc.getDelivery());
		
		List<SupportingDocument> asDocList = testDoc.getAdditionalSupportingDocuments();
		asDocList.forEach(asDoc -> {
			String documentReference = asDoc.getDocumentReference().getName();
			LOG.info("SupportingDocumentReference:"+documentReference + " MimeCode:"+asDoc.getAttachedDocumentMimeCode());
			byte[] content = asDoc.getAttachedDocument();
			if(content==null) {
				LOG.info("SupportingDocumentDescription:"+asDoc.getSupportingDocumentDescription() 
					+ " ExternalDocumentLocation:"+asDoc.getExternalDocumentLocation());
				ublInvoice.addSupportigDocument(documentReference, asDoc.getSupportingDocumentDescription(), asDoc.getExternalDocumentLocation());
			} else {
				ublInvoice.addSupportigDocument(documentReference
						, asDoc.getSupportingDocumentDescription()
						, content, asDoc.getAttachedDocumentMimeCode(), asDoc.getAttachedDocumentFilename()
						);
			}
		});
		
		LOG.info("finished.");
	}
	
	void makePaymentGroup(CoreInvoice ublInvoice, CoreInvoice testDoc) {
		
		// BT-20 + 0..1 Payment terms
		ublInvoice.setPaymentTermsAndDate(testDoc.getPaymentTerm(), testDoc.getDueDateAsTimestamp());
		
		PaymentInstructions pi = testDoc.getPaymentInstructions(); // BG-16 (mandatory) PAYMENT INSTRUCTIONS
		if(pi==null || pi.getPaymentMeansEnum()==null) {
			LOG.warning("BG-16 (mandatory) PAYMENT INSTRUCTIONS:"+pi);
			// in ubl-tc434-example6.xml !
			return;
		} else {
			List<CreditTransfer> creditTransferList = pi.getCreditTransfer();
			PaymentMeansEnum paymentMeansCode = pi.getPaymentMeansEnum();
			LOG.info("paymentMeansCode="+paymentMeansCode
				+ " paymentMeansText:"+pi.getPaymentMeansText()
				+ " BT-83 remittanceInformation:"+pi.getRemittanceInformation()
				+ "\n BG-17 CreditTransfer #:"+creditTransferList.size()
				+ "\n BG-18 PaymentCard:"+pi.getPaymentCard()
				+ "\n BG-19 DirectDebit:"+pi.getDirectDebit()
				);
			creditTransferList.forEach(ct -> {
				LOG.info("... CreditTransfer:"+ct);
			});
			PaymentInstructions paymentInstructions = null;
//			paymentInstructions = ublInvoice.createPaymentInstructions(pi.getPaymentMeansEnum(), pi.getPaymentMeansText(), pi.getRemittanceInformation()
//				, creditTransferList, pi.getPaymentCard(), pi.getDirectDebit() );
			// oder:
			switch(paymentMeansCode) {
			case DebitTransfer:
			case CreditTransfer:
			case SEPACreditTransfer:
				paymentInstructions = ublInvoice.createPaymentInstructions(paymentMeansCode, pi.getPaymentMeansText()
						, pi.getRemittanceInformation(), creditTransferList );
				break;
			case BankCard:
				paymentInstructions = ublInvoice.createPaymentInstructions(paymentMeansCode, pi.getPaymentMeansText()
						, pi.getRemittanceInformation(), pi.getPaymentCard() );
				break;
			case DirectDebit:
			case SEPADirectDebit:
				DirectDebit dd = pi.getDirectDebit();
				LOG.info("DirectDebit Creditor:"+dd.getBankAssignedCreditorID()
					+" Account="+dd.getDebitedAccountID()+" MandateReference:"+dd.getMandateReferencedID());
				paymentInstructions = ublInvoice.createPaymentInstructions(paymentMeansCode, pi.getPaymentMeansText()
						, pi.getRemittanceInformation(), pi.getDirectDebit() );
				break;
			default:
				LOG.warning("[BR-DE-13] In der Rechnung müssen Angaben zu genau einer der drei Gruppen sein: CREDIT TRANSFER, PAYMENT CARD INFORMATION, DIRECT DEBIT - Ist:"
						+ paymentMeansCode);
				paymentInstructions = ublInvoice.createPaymentInstructions(paymentMeansCode, pi.getPaymentMeansText());
				break;
			}
			ublInvoice.setPaymentInstructions(paymentInstructions);
		}
		LOG.info("finished.");
	}
	
	void makeVatBreakDownGroup(CoreInvoice ublInvoice) {
        List<VatBreakdown> vbdList = testDoc.getVATBreakDowns();
        LOG.info("VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
        vbdList.forEach(tradeTax -> {
        	IAmount taxBaseAmount = tradeTax.getTaxBaseAmount();
        	IAmount calculatedTaxAmount = tradeTax.getCalculatedTaxAmount();
            LOG.info("taxBaseAmount="+taxBaseAmount + " calculatedTaxAmount="+calculatedTaxAmount);
        	VatBreakdown vatBreakdown = ublInvoice.createVATBreakDown( taxBaseAmount,
        			calculatedTaxAmount,
        			tradeTax.getTaxCategoryCode(),
        			tradeTax.getTaxPercentage() );
        	
        	// 0..1 (optional) BG-23.BT-120 ExemptionReason Grund der Steuerbefreiung (Freitext)
        	// 0..1 (optional) BG-23.BT-121 ExemptionReasonCode Code für den Umsatzsteuerbefreiungsgrund
        	vatBreakdown.setTaxExemption(tradeTax.getTaxExemptionReasonText(), tradeTax.getTaxExemptionReasonCode());
        	ublInvoice.addVATBreakDown(vatBreakdown);
        	LOG.info("added vatBreakdown "+vatBreakdown);
        });
		LOG.info("finished. "+vbdList.size() + " vatBreakDowns.");
	}
	
	void makeLineGroup(CoreInvoice ublDoc, CoreInvoice testDoc) {
		List<CoreInvoiceLine> testLines = testDoc.getLines();
		LOG.info("LineGroup started for "+testLines.size() + " lines. testDocObject ist "+testDoc.getClass() +
				" testDoc ist "+testDoc.getClass());
		testLines.forEach(testLine -> {
			CoreInvoiceLine targetLine;
			targetLine = ublDoc.createInvoiceLine(testLine.getId(), 
					testLine.getQuantity(),                                       // BT-129
					testLine.getLineTotalAmount(), testLine.getUnitPriceAmount(), // BT-131 , BG-29.BT-146 
					testLine.getItemName(),
					testLine.getTaxCategory(), testLine.getTaxRate()
					);
			
			// opt:
			targetLine.setBuyerAccountingReference(testLine.getBuyerAccountingReference()); // BG-25.BT-133
			targetLine.setLineDeliveryPeriod(testLine.getLineDeliveryPeriod());     // optional BG-26
			
			// BG-29:BT-149-0 0..1 , BT-150-0
			IQuantity baseQuantity = testLine.getUnitPriceQuantity();
			if(baseQuantity!=null) {
				LOG.info("PRICE DETAILS BG-29.BT-149 + BT-150 baseQuantity "+baseQuantity);
				// BG-29.BT-146 + BG-29:BT-149-0 0..1 , BT-150-0
				targetLine.setUnitPriceAmountAndQuantity(testLine.getUnitPriceAmount(), baseQuantity);
				targetLine.setUnitPriceAllowance(testLine.getPriceDiscount(), testLine.getGrossPrice());
			}
			
			List<AllowancesAndCharges> allowancesAndCharges = testLine.getAllowancesAndCharges();
			LOG.info("(optional) line AllowancesAndCharges #:"+allowancesAndCharges.size());
			allowancesAndCharges.forEach(aac -> {
				targetLine.addAllowanceCharge(aac);
			});

			targetLine.setDescription(testLine.getDescription());   //BT-154 0..1
			targetLine.setSellerAssignedID(testLine.getSellerAssignedID());   //BT-155 0..1
			targetLine.setBuyerAssignedID(testLine.getBuyerAssignedID());     //BT-156 0..1
			targetLine.setStandardIdentifier(testLine.getStandardIdentifier()); //BT-157 0..1 , BT-157-1 required
			List<GlobalIdentifier> classifications = testLine.getClassifications(); // BG-31.BT-158 0..n
			classifications.forEach(cl -> {
				targetLine.addClassificationID(cl);
			});
			targetLine.setCountryOfOrigin(testLine.getCountryOfOrigin());     // BG-31.BT-159 0..1
			Properties itemAttributes = testLine.getItemAttributes(); // BG-32 0..n
			itemAttributes.entrySet().forEach(cl -> {
				LOG.info("itemAttribute: " +cl.getKey().toString() +" "+ cl.getValue().toString());
				targetLine.addItemAttribute(cl.getKey().toString(), cl.getValue().toString());
			});
			
        	targetLine.setNote(testLine.getNote());   	
			targetLine.setLineObjectIdentifier(testLine.getLineObjectIdentifier()); // opt BT-128
        	targetLine.setOrderLineID(testLine.getOrderLineID());
        	
			ublDoc.addLine(targetLine);
		});
		LOG.info("finished. "+testLines.size() + " lines.");
	}

	private File getTestFile(String uri) {
		File file = new File(uri);
		LOG.info("test file "+file.getAbsolutePath() + " canRead:"+file.canRead());
		return file;
	}
	
	private GenericInvoice<CreditNoteType> toModelCN(File xmlfile) {
		CreditNoteType invoice;
		GenericInvoice<CreditNoteType> genericInvoice = null;
		try {
			InputStream is = new FileInputStream(xmlfile);
			invoice = transformer.toModel(is);
			genericInvoice = new GenericInvoice<CreditNoteType>(invoice);
		} catch (Exception ex) {
			ex.printStackTrace();
			LOG.severe(ex.getMessage());			
		}
		return genericInvoice;
	}
	
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
	
}
