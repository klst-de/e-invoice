package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.klst.edoc.api.BusinessPartyAddress;
import com.klst.edoc.api.BusinessPartyContact;
import com.klst.edoc.api.Identifier;
import com.klst.edoc.api.Reference;
import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BG24_AdditionalSupportingDocs;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.GlobalIdentifier;
import com.klst.einvoice.InvoiceNote;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.VatBreakdown;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.CrossIndustryInvoice;
import com.klst.einvoice.unece.uncefact.TradeParty;
import com.klst.marshaller.CiiTransformer;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.ReferenceCode;

import un.unece.uncefact.data.standard.crossindustryinvoice._100.CrossIndustryInvoiceType;

public class CreateCiiXXXInvoice extends InvoiceFactory {

	private static final Logger LOG = Logger.getLogger(CreateCiiXXXInvoice.class.getName());

	private static final String TESTDIR = "src/test/resources/"; // mit Daten aus xrechnung-1.2.0-testsuite-2018-12-14.zip\instances\

	private File testFile;
	private CoreInvoice testDoc;

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
		LOG.info("\n (BG-2.BT-24)ProcessType="+testDoc.getProcessType() + " (BG-2.BT-24)Customization="+testDoc.getCustomization()
			+ " (BT-3)TypeCode="+testDoc.getTypeCode());
		// kein CII Testfile mit ProcessType!!!
		CoreInvoice cii = CrossIndustryInvoice.getFactory().createInvoice(testDoc.getCustomization(), testDoc.getTypeCode());

		cii.setId(testDoc.getId());
		cii.setIssueDate(testDoc.getIssueDateAsTimestamp());
//		cii.setDocumentCurrency(testDoc.getDocumentCurrency());                           ---- verschoben hinter pi
//		cii.setTaxCurrency(testDoc.getTaxCurrency()); // BT-6 + 0..1 (optional)
		cii.setBuyerReference(testDoc.getBuyerReferenceValue()); // BT-10 + 0..1 (optional)

		Reference projRef = testDoc.getProjectReference();
		if(projRef!=null) {
			cii.setProjectReference(projRef.getID(), projRef.getName()); // optional BT-11
		}

//		makeOptionals(cii);
		cii.setContractReference(testDoc.getContractReference()); // BT-12 + 0..1
//		cii.setStartDate(testDoc.getStartDateAsTimestamp()); // BG-14.BT-73
//		cii.setEndDate(testDoc.getEndDateAsTimestamp()); // BG-14.BT-74
		cii.setPurchaseOrderReference(testDoc.getPurchaseOrderReference()); // BT-13 + 0..1
		cii.setOrderReference(testDoc.getOrderReference()); // BT-14 + 0..1
		List<InvoiceNote> invoiceNotes = testDoc.getInvoiceNotes();
		invoiceNotes.forEach(invoiceNote -> {
			cii.addNote(invoiceNote);
		});


		BusinessParty testSellerParty = testDoc.getSeller();
		BusinessParty sellerParty = cii.createParty( testSellerParty.getRegistrationName()     // BT-27 String name
				                          , ((BusinessPartyAddress)testSellerParty).getAddress()              // TradeAddress address
				                          , ((BusinessPartyContact)testSellerParty).getContactInfo()             // TradeContact contact
				                          );
		sellerParty.setBusinessName(testSellerParty.getBusinessName()) ; // BT-28
		sellerParty.setIdentifier(testSellerParty.getIdentifier()); // BT-29
		sellerParty.setCompanyIdentifier(testSellerParty.getCompanyIdentifier()); // BT-30
		sellerParty.setCompanyLegalForm(testSellerParty.getCompanyLegalForm());
		// [BR-62]-The Seller electronic address (BT-34) shall have a Scheme identifier :
		sellerParty.setUriUniversalCommunication(testSellerParty.getUriUniversalCommunication());
		// BT-31 (0..1) + BT-32 (0..1)
		if(testSellerParty.getTaxRegistrationIdentifier().isEmpty()) {
			LOG.warning("sellerParty.SpecifiedTaxRegistration().isEmpty() !!!!!!!!!!!!!" );
		}
			/* 01.10a nur einen mit schema "FC": also BT-32
			 * 01.10a-INVOICE_uncefact.xml                      hat zwei Einträge:
                <ram:SpecifiedTaxRegistration>
                    <ram:ID schemeID="VA">DE123456789</ram:ID>
                </ram:SpecifiedTaxRegistration>
                <ram:SpecifiedTaxRegistration>
                    <ram:ID schemeID="FC">123/456/789</ram:ID>
                </ram:SpecifiedTaxRegistration>

			 */
		List<Identifier> taxRegistrationList = testSellerParty.getTaxRegistrationIdentifier();
		taxRegistrationList.forEach(taxReg -> {
			if(taxReg.getSchemeIdentifier().equals(ReferenceCode.VATRegistrationNumber.getValue())) { //VA
				LOG.info("BT-31:"+taxReg);
				sellerParty.addTaxRegistrationIdentifier(taxReg);
			} else if(taxReg.getSchemeIdentifier().equals(ReferenceCode.FiscalNumber.getValue())) { //FC
				LOG.info("BT-32:"+taxReg);
				sellerParty.addTaxRegistrationIdentifier(taxReg);
			} else {
				LOG.warning("weder BT-31 noch BT 32:"+taxReg);
				sellerParty.addTaxRegistrationIdentifier(taxReg);
			}
		});
		LOG.info("Seller identifier (BT-29):"+sellerParty.getRegistrationName()
				+" legal registration identifier (BT-30):"+sellerParty.getCompanyLegalForm()
//				+" VAT identifier (BT-31):"+sellerParty.getVATRegistrationId()
				);
		cii.setSeller(sellerParty);

		BusinessParty buyerParty = testDoc.getBuyer();
		if(((TradeParty)buyerParty).getSpecifiedTaxRegistration().isEmpty()) {
			LOG.warning("BG-7 buyerParty.SpecifiedTaxRegistration().isEmpty() mandatory!" );
		} else {
			TradeParty buyerTradeParty = (TradeParty)buyerParty;
			LOG.info("buyerParty.SpecifiedTaxRegistration#:"+buyerTradeParty.getSpecifiedTaxRegistration().size()
					+ " ID:"+buyerTradeParty.getSpecifiedTaxRegistration().get(0).getID().getValue()
					+ " schemeID:"+buyerTradeParty.getSpecifiedTaxRegistration().get(0).getID().getSchemeID()
					+ " UriUniversalCommunication:"+buyerTradeParty.getUriUniversalCommunication()
					);
//			buyerParty.setUriUniversalCommunication(buyerTradeParty.getUriUniversalCommunication(), null); // TODO
		}
		LOG.info("buyerParty:"+buyerParty.getBusinessName() + " Address:"+((BusinessPartyAddress)buyerParty).getAddress());
		cii.setBuyer(buyerParty);

		// Cardinality: 0..n EN16931-ID: BG-24
		List<BG24_AdditionalSupportingDocs> additionalSupportingDocs = testDoc.getAdditionalSupportingDocuments();
		additionalSupportingDocs.forEach(additionalSupportingDoc -> {
//			cii.addSupportigDocument((ReferencedDocument)additionalSupportingDoc); // TODO methode in CoreInvoice
//			((CrossIndustryInvoice)cii).addSupportigDocument((ReferencedDocument)additionalSupportingDoc);
			
			byte[] byteDoc = additionalSupportingDoc.getAttachedDocument();
			String documentReference = additionalSupportingDoc.getDocumentReference().getName();
			if(byteDoc==null) {
				cii.addSupportigDocument(documentReference
						, additionalSupportingDoc.getSupportingDocumentDescription()
						, additionalSupportingDoc.getExternalDocumentLocation());
			} else {
				cii.addSupportigDocument(documentReference
						, additionalSupportingDoc.getSupportingDocumentDescription()
						, byteDoc
						, additionalSupportingDoc.getAttachedDocumentMimeCode()
						, additionalSupportingDoc.getAttachedDocumentFilename());
			}
		});
		
		cii.setReceiptReference(testDoc.getReceiptReference()); // (optional) BT-15
		cii.setDespatchAdviceReference(testDoc.getDespatchAdviceReference()); // (optional) BT-16
		cii.setTenderOrLotReference(testDoc.getTenderOrLotReference()); // (optional) BT-17
		
		// Testfall 02.01a: (ausschalten)
//		Identifier identifier = testDoc.getInvoicedObjectIdentifier();
//		cii.setInvoicedObjectIdentifier(identifier); // (optional) BT-18
//		cii.setInvoicedObject("Test", "AAA"); // (optional) BT-18

		BusinessParty testPayeeParty = testDoc.getPayee();
		if(testPayeeParty==null) {
			LOG.info("BG-10 (optional) testPayeeParty==null" );
		} else {
			LOG.info("testPayeeParty.RegistrationName:"+testPayeeParty.getRegistrationName()
				+ " BusinessName:"+testPayeeParty.getBusinessName()
				+ " Id:"+testPayeeParty.getId()
				+ " CompanyLegalForm:"+testPayeeParty.getCompanyLegalForm()
				);
			cii.setPayee(testPayeeParty.getRegistrationName(), testPayeeParty.getId(), testPayeeParty.getCompanyLegalForm());
		}
		LOG.info("BG-10 (optional) ???? PayeeParty:"+cii.getPayee() );

		BusinessParty testSellerTaxRepresentativeParty = testDoc.getTaxRepresentative();
		if(testSellerTaxRepresentativeParty==null) {
			LOG.info("BG-11 (optional) testSellerTaxRepresentativeParty==null" );
		} else {
			LOG.info("testSellerTaxRepresentativeParty.Name:"+((TradeParty)testSellerTaxRepresentativeParty).getRegistrationName()
					+ " Address:"+((TradeParty)testSellerTaxRepresentativeParty).getAddress()
					+ " TaxRegistrations#:"+((TradeParty)testSellerTaxRepresentativeParty).getTaxRegistrationIdentifier()
					);
			cii.setTaxRepresentative(testSellerTaxRepresentativeParty.getRegistrationName()
					, ((TradeParty)testSellerTaxRepresentativeParty).getAddress()
					, testSellerTaxRepresentativeParty.getTaxRegistrationIdentifier().get(0).getContent()
					, "VA");
		}

		BG13_DeliveryInformation delivery = testDoc.getDelivery();
		if(delivery!=null) {
			LOG.info("BG-13 delivery:"+delivery);
			cii.setDelivery(delivery);
		}

		PaymentInstructions pi = testDoc.getPaymentInstructions(); // BG-16 (mandatory) PAYMENT INSTRUCTIONS
		if(pi==null || pi.getPaymentMeansEnum()==null) {
			LOG.warning("BG-16 (mandatory) PAYMENT INSTRUCTIONS:"+pi);
		} else {
			List<CreditTransfer> creditTransferList = pi.getCreditTransfer();
			PaymentMeansEnum paymentMeansCode = pi.getPaymentMeansEnum();
			LOG.info("paymentMeansCode="+paymentMeansCode
				+ " paymentMeansText:"+pi.getPaymentMeansText()
				+ " BT-83 remittanceInformation:"+pi.getRemittanceInformation()
				+ "\n BG-17 CreditTransfer:"+creditTransferList.size()
				+ "\n BG-18 PaymentCard:"+pi.getPaymentCard()
				+ "\n BG-19 DirectDebit:"+pi.getDirectDebit()
				);
			PaymentInstructions paymentInstructions = null;
//			paymentInstructions = cii.createPaymentInstructions(pi.getPaymentMeansEnum(), pi.getPaymentMeansText(), pi.getRemittanceInformation()
//				, creditTransferList, pi.getPaymentCard(), pi.getDirectDebit() );
			// oder:
			switch(paymentMeansCode) {
			case DebitTransfer:
			case CreditTransfer:
			case SEPACreditTransfer:
				paymentInstructions = cii.createPaymentInstructions(paymentMeansCode, pi.getPaymentMeansText()
						, pi.getRemittanceInformation(), creditTransferList );
				break;
			case BankCard:
				paymentInstructions = cii.createPaymentInstructions(paymentMeansCode, pi.getPaymentMeansText()
						, pi.getRemittanceInformation(), pi.getPaymentCard() );
				break;
			case DirectDebit:
			case SEPADirectDebit:
				DirectDebit dd = pi.getDirectDebit();
				LOG.info("DirectDebit Creditor:"+dd.getBankAssignedCreditorID()
					+" Account="+dd.getDebitedAccountID()+" MandateReference:"+dd.getMandateReferencedID());
//				dd.getBankAssignedCreditorID();
//				dd.getDebitedAccountID();
//				dd.getMandateReferencetID();
//				cii.createDirectDebit(TESTDIR, TESTDIR, null)
				paymentInstructions = cii.createPaymentInstructions(paymentMeansCode
						, pi.getPaymentMeansText()
						, pi.getRemittanceInformation()
						, pi.getDirectDebit() );
				break;
			default:
				LOG.warning("[BR-DE-13] In der Rechnung müssen Angaben zu genau einer der drei Gruppen sein: CREDIT TRANSFER, PAYMENT CARD INFORMATION, DIRECT DEBIT - Ist:"
						+ paymentMeansCode);
				paymentInstructions = cii.createPaymentInstructions(paymentMeansCode, pi.getPaymentMeansText());
				break;
			}
			LOG.info("BG-10 (optional) ???? PayeeParty:"+cii.getPayee() ); // TODO Payee ist weg !!!!!!!!
			cii.setPaymentInstructions(paymentInstructions);
		}
		LOG.info("BG-10 (optional) ???? PayeeParty:"+cii.getPayee() ); // TODO Payee ist weg !!!!!!!!

		// BG-20 + BG-21 0..n
		List<AllowancesAndCharges> aac = testDoc.getAllowancesAndCharges();
		aac.forEach(ac ->{
			cii.addAllowanceCharge(ac);
		});
		
		cii.setDocumentCurrency(testDoc.getDocumentCurrency()); // BT-5
		if(testDoc.getTaxCurrency()!=null) {                    // BT-6
			cii.setTaxCurrency(testDoc.getTaxCurrency());
		}
		cii.setTaxCurrency(testDoc.getTaxCurrency()); // BT-6 0..1 (optional)

		LOG.info("testDoc.getPaymentTerm():"+testDoc.getPaymentTerm() + " testDoc.getDueDateAsTimestamp():"+testDoc.getDueDateAsTimestamp());
		cii.setPaymentTermsAndDate(testDoc.getPaymentTerm(), testDoc.getDueDateAsTimestamp()); // BT-9 & BT-20 (optional)

		// es ist entscheidend, dass die setter nach cii.setPaymentInstructions ausgeführt werden!!!!!!!!!!!!!!!
		LOG.info("testDoc.StartDateAsTimestamp "+ testDoc.getDeliveryPeriod());
		cii.setDeliveryPeriod(testDoc.getDeliveryPeriod()); // BG-14 0..1 INVOICING PERIOD

        List<VatBreakdown> vbdList = testDoc.getVATBreakDowns();
        LOG.info("VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
        vbdList.forEach(tradeTax -> {
        	VatBreakdown vatBreakdown = cii.createVATBreakDown( tradeTax.getTaxBaseAmount(),
        			tradeTax.getCalculatedTaxAmount(),
        			tradeTax.getTaxCategoryCode(),
        			tradeTax.getTaxPercentage() );
        	
        	// 0..1 (optional) BG-23.BT-120 ExemptionReason Grund der Steuerbefreiung (Freitext)
        	// 0..1 (optional) BG-23.BT-121 ExemptionReasonCode Code für den Umsatzsteuerbefreiungsgrund
        	vatBreakdown.setTaxExemption(tradeTax.getTaxExemptionReasonText(), tradeTax.getTaxExemptionReasonCode());
        	cii.addVATBreakDown(vatBreakdown);
        	LOG.info("added vatBreakdown "+vatBreakdown);
        });
        LOG.info("VATBreakDown added "+cii.getVATBreakDowns().size() + " ?????????? VATBreakDowns.");

		cii.setTaxPointDate(testDoc.getTaxPointDateAsTimestamp()); // BT-7 BT-7-0

        Amount prePaidAmount = testDoc.getPrepaid();
    	LOG.info("-----------------Prepaid amount "+prePaidAmount);
        cii.setDocumentTotals(testDoc.getInvoiceLineNetTotal(),
				testDoc.getInvoiceTotalTaxExclusive(),
				testDoc.getInvoiceTotalTaxInclusive(),
				testDoc.getDuePayable());
        Amount invoiceTaxAmount = testDoc.getInvoiceTax();
    	LOG.info("--------------InvoiceTax amount "+invoiceTaxAmount);
        Amount invoiceTaxIAAmount = testDoc.getInvoiceTaxInAccountingCurrency();
    	LOG.info("--InvoiceTaxInAccountingCurrency amount "+invoiceTaxIAAmount);
    	if(invoiceTaxAmount==null && invoiceTaxIAAmount==null) {
    		// nix
    	} else {
        	if(invoiceTaxAmount==null) {
        		// wie im Bsp. 02.01a
                cii.setInvoiceTax(new Amount(cii.getDocumentCurrency(), invoiceTaxIAAmount.getValue()));   	
        		cii.setInvoiceTaxInAccountingCurrency(invoiceTaxIAAmount);
        	} else {
                cii.setInvoiceTax(invoiceTaxAmount);   	
        	}
    	}
        cii.setPrepaid(prePaidAmount);
        Amount allowancesTotalAmount = testDoc.getAllowancesTotal();
    	LOG.info("---------AllowancesTotal amount "+allowancesTotalAmount);
        cii.setAllowancesTotal(allowancesTotalAmount);
        Amount chargesTotalAmount = testDoc.getChargesTotal();
    	LOG.info("------------chargesTotal amount "+chargesTotalAmount);
        cii.setChargesTotal(chargesTotalAmount);
        Amount roundingAmount = testDoc.getRounding();
    	LOG.info("------------    rounding amount "+roundingAmount);
        cii.setRounding(roundingAmount);

//        cii.setInvoiceTaxInAccountingCurrency(  ...  ist nicht implementiert TODO

        List<CoreInvoiceLine> lines = testDoc.getLines();
        LOG.info("LineGroup starts for "+lines.size() + " lines.");
        lines.forEach(testLine -> {
        	LOG.info("testLine.getTaxCategory() = "+testLine.getTaxCategory() + " , testLine.getTaxRate() = "+testLine.getTaxRate());
        	CoreInvoiceLine line = cii.createInvoiceLine
        			( testLine.getId()
        			, testLine.getQuantity()
        			, testLine.getLineTotalAmount()
        			, testLine.getUnitPriceAmount()
        			, testLine.getItemName()
        			, testLine.getTaxCategory(), testLine.getTaxRate() // mandatory, rate can be null
        			);
        	// BG-29.BT-146 (nochmal) + optional BG-29.BT-150 + BG-29.BT-149
        	line.setUnitPriceAmountAndQuantity(testLine.getUnitPriceAmount(), testLine.getUnitPriceQuantity());
        	// BG-29.BT-147  + BG-29.BT-148
        	line.setUnitPriceAllowance(testLine.getPriceDiscount(), testLine.getGrossPrice());

        	line.setNote(testLine.getNote()); // opt BT-127
        	line.setLineObjectIdentifier(testLine.getLineObjectIdentifier()); // opt BT-128
    		line.setBuyerAccountingReference(testLine.getBuyerAccountingReference()); // BG-26.BT-133
    		line.setLineDeliveryPeriod(testLine.getLineDeliveryPeriod()); // BG-26

			List<AllowancesAndCharges> allowancesAndCharges = testLine.getAllowancesAndCharges();
			LOG.info("(optional) line AllowancesAndCharges #:"+allowancesAndCharges.size());
			allowancesAndCharges.forEach(allowanceOrCharge -> {
				line.addAllowanceCharge(allowanceOrCharge);
			});

        	line.setDescription(testLine.getDescription());
        	line.setSellerAssignedID(testLine.getSellerAssignedID()); // 0..1 BT-128 ram:SellerAssignedID
        	line.setStandardIdentifier(testLine.getStandardIdentifier()); // 0..1 BT-157 0..1 , BT-157-1 required
        	List<GlobalIdentifier> classifications = testLine.getClassifications();  // BG-31.BT-158 0..n
			classifications.forEach(cl -> {
				line.addClassificationID(cl);
			});
			line.setCountryOfOrigin(testLine.getCountryOfOrigin());     // BG-31.BT-159 0..1
			Properties itemAttributes = testLine.getItemAttributes(); // BG-32 0..n
			itemAttributes.entrySet().forEach(cl -> {
				LOG.info("itemAttribute: " +cl.getKey().toString() +" "+ cl.getValue().toString());
				line.addItemAttribute(cl.getKey().toString(), cl.getValue().toString());
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
			cii = CrossIndustryInvoice.create(invoice);
			// TODO ...
		} catch (Exception ex) {
			ex.printStackTrace();
			LOG.severe(ex.getMessage());
		}
		return cii;
	}

}
