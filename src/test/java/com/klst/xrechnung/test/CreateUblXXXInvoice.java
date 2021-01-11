package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BG23_VatBreakdown;
import com.klst.einvoice.BG24_AdditionalSupportingDocs;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.Identifier;
import com.klst.einvoice.InvoiceNote;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.ubl.CardAccount;
import com.klst.einvoice.ubl.FinancialAccount;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.ubl.GenericLine;
import com.klst.einvoice.ubl.PaymentMeans;
import com.klst.einvoice.ubl.TaxSubtotal;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.marshaller.UblCreditNoteTransformer;
import com.klst.marshaller.UblInvoiceTransformer;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

public class CreateUblXXXInvoice extends InvoiceFactory {

	private static final Logger LOG = Logger.getLogger(CreateUblXXXInvoice.class.getName());
	
	private static final String TESTDIR = "src/test/resources/"; // mit Daten aus xrechnung-1.2.0-testsuite-2018-12-14.zip\instances\
	
	private File testFile;
	private GenericInvoice<?> testDoc;
	private GenericInvoice<?> testCN; // GenericInvoice ===> CoreInvoice
	
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

	public GenericInvoice getTestDoc() {
		return testDoc;
	}
		
	Object makeCreditNote() {
		LOG.info("\n (BG-2.BT-24)ProcessType="+testCN.getProcessType() + " (BG-2.BT-24)Customization="+testCN.getCustomization()
			+ " (BT-3)TypeCode="+testCN.getTypeCode());
		CoreInvoice ublInvoice =
				GenericInvoice.createCreditNote(testCN.getCustomization(), testCN.getProcessType(), testCN.getTypeCode());
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
		
//		makeVatBreakDownGroup2(ublInvoice);
        List<TaxSubtotal> vbdList = testCN.getVATBreakDowns();
        LOG.info("CreditNote VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
        vbdList.forEach(tradeTax -> {
        	TaxSubtotal vatBreakdown = new TaxSubtotal(
        	  new Amount(tradeTax.getTaxableAmount().getCurrencyID(), tradeTax.getTaxableAmount().getValue())
			, new Amount(tradeTax.getTaxAmount().getCurrencyID(), tradeTax.getTaxAmount().getValue())
			, TaxCategoryCode.valueOf(tradeTax.getTaxCategory())
			, tradeTax.getTaxCategory().getPercent()==null ? null : tradeTax.getTaxCategory().getPercent().getValue()
			); 
        	vatBreakdown.setTaxExemption(tradeTax.getTaxExemptionReasonText() , tradeTax.getTaxExemptionReasonCode());
        	ublInvoice.addVATBreakDown(vatBreakdown);
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
		CoreInvoice ublInvoice =
				GenericInvoice.createInvoice(testDoc.getCustomization(), testDoc.getProcessType(), testDoc.getTypeCode());
		ublInvoice.setId(testDoc.getId());
		ublInvoice.setIssueDate(testDoc.getIssueDateAsTimestamp());
		ublInvoice.setDocumentCurrency(testDoc.getDocumentCurrency());
		ublInvoice.setTaxCurrency(testDoc.getTaxCurrency());
		ublInvoice.setBuyerReference(testDoc.getBuyerReferenceValue());
		ublInvoice.setStartDate(testDoc.getStartDateAsTimestamp()); // optional
		ublInvoice.setEndDate(testDoc.getEndDateAsTimestamp()); // optional
		LOG.info("ublInvoice "+ublInvoice);
		
		ublInvoice.setSeller(testDoc.getSeller());
		LOG.info("Seller Address and Contact "+ublInvoice.getSeller().getAddress() + " "+ublInvoice.getSeller().getIContact());
		BG7_Buyer buyer = testDoc.getBuyer();
		ublInvoice.setBuyer(testDoc.getBuyer());
		LOG.info("Buyer UriUniversalCommunication:" + buyer.getUriUniversalCommunication());
		LOG.info("Buyer Address and Contact "+ublInvoice.getBuyer().getAddress() + " "+ublInvoice.getBuyer().getIContact());
		
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

	void makeOptionals(CoreInvoice ublInvoice, GenericInvoice<?> testDoc) {	
		LOG.info("testDoc.ProjectReference="+
				(testDoc.getProjectReference()==null ? "null" : testDoc.getProjectReference().getID()));
		ublInvoice.setProjectReference(testDoc.getProjectReference()); // BT-11 + 0..1
		ublInvoice.setContractReference(testDoc.getContractReference()); // BT-12 + 0..1
		ublInvoice.setPurchaseOrderReference(testDoc.getPurchaseOrderReference()); // BT-13 + 0..1
		ublInvoice.setOrderReference(testDoc.getOrderReference()); // BT-14 + 0..1
		
		ublInvoice.setReceiptReference(testDoc.getReceiptReference()); // BT-15 + 0..1
		ublInvoice.setDespatchAdviceReference(testDoc.getDespatchAdviceReference()); // BT-16 + 0..1
		ublInvoice.setTenderOrLotReference(testDoc.getTenderOrLotReference()); // BT-17 + 0..1

		// Testfall 02.01a:
		Identifier identifier = testDoc.getInvoicedObjectIdentifier();
		ublInvoice.setInvoicedObjectIdentifier(identifier); // (optional) BT-18
//		ublInvoice.setInvoicedObject("Test", "AAA"); // (optional) BT-18  NOT IMPLEMENTED: TODO

		List<InvoiceNote> notes = testDoc.getInvoiceNotes();
		notes.forEach(invoiceNote -> {
			ublInvoice.addNote(invoiceNote.getCode(), invoiceNote.getNote());
		});
		
//		ublInvoice.setPayeeParty(testDoc.getPayeeParty());
		BusinessParty party = testDoc.getPayee();
		if(party==null) {
			// nix
		} else {
			LOG.info("Payee.RegistrationName:"+party.getRegistrationName() + " Payee.Id:"+party.getId() + " Payee.BusinessName:"+party.getBusinessName());
			ublInvoice.setPayee(party.getBusinessName()
					, party.getId() // String id
					, party.getCompanyLegalForm()  // String companyLegalForm
					);
		}
		ublInvoice.setTaxRepresentative(testDoc.getTaxRepresentative());
		ublInvoice.setStartDate(testDoc.getStartDateAsTimestamp());
		ublInvoice.setEndDate(testDoc.getEndDateAsTimestamp());
		ublInvoice.setDelivery(testDoc.getDelivery());
		
		List<BG24_AdditionalSupportingDocs> asDocList = testDoc.getAdditionalSupportingDocuments();
		asDocList.forEach(asDoc -> {
			LOG.info("SupportingDocumentReference:"+asDoc.getSupportingDocumentReference() + " MimeCode:"+asDoc.getAttachedDocumentMimeCode());
			byte[] content = asDoc.getAttachedDocument();
			if(content==null) { // TODO
				ublInvoice.addSupportigDocument(asDoc.getSupportingDocumentReference(), asDoc.getSupportingDocumentDescription(), null);
			} else {
				ublInvoice.addSupportigDocument(asDoc.getSupportingDocumentReference()
						, asDoc.getSupportingDocumentDescription()
						, content, asDoc.getAttachedDocumentMimeCode(), asDoc.getAttachedDocumentFilename()
						);
			}
		});
		
		LOG.info("finished.");
	}
	
	void makePaymentGroup(CoreInvoice ublInvoice, GenericInvoice<?> testDoc) {
		
		// BT-20 + 0..1 Payment terms
		ublInvoice.setPaymentTermsAndDate(testDoc.getPaymentTerm(), testDoc.getDueDateAsTimestamp());
		
		PaymentInstructions paymentInstructions = testDoc.getPaymentInstructions();
		LOG.info("PaymentInstructions "+paymentInstructions 
				+ " PaymentMeans="+(paymentInstructions==null ? "nix" : paymentInstructions.getPaymentMeansEnum()));
		
		if(paymentInstructions==null) { // optional BG-16 + 0..1 PAYMENT INSTRUCTIONS / Zahlungsanweisungen
			return;
		}
		List<CreditTransfer> creditTransfer = paymentInstructions.getCreditTransfer();
		if(creditTransfer.isEmpty()) {
			//LOG.info("creditTransfer.isEmpty");
		} else if(creditTransfer.size()==1){
			String accountId = creditTransfer.get(0).getPaymentAccountID();
			String accountName = creditTransfer.get(0).getPaymentAccountName();
			BICId bic = new BICId(creditTransfer.get(0).getPaymentServiceProviderID());
			if(paymentInstructions.getPaymentMeansEnum()==PaymentMeansEnum.SEPACreditTransfer) {
				IBANId iban = new IBANId(accountId);
				LOG.info("SEPACreditTransfer iban:"+iban + " accountName:"+accountName + " bic:"+bic);
			} else if(paymentInstructions.getPaymentMeansEnum()==PaymentMeansEnum.CreditTransfer) {
				FinancialAccount account = new FinancialAccount(accountId, accountName, bic);
				LOG.info("NON SEPA Überweisung kto:"+account + "// accountName:"+accountName + " bic:"+bic);
			}
		} else {
			LOG.warning("!!!!!!!!! mehrere "+creditTransfer.size()+" creditTransfer Einträge");
		}
		
		PaymentCard testCard = paymentInstructions.getPaymentCard();
		PaymentCard paymentCard = null;
		if(testCard!=null) {
			LOG.info("testCard.CardAccountID="+testCard.getCardAccountID() +" CardHolderName="+testCard.getCardHolderName());
			paymentCard = ublInvoice.createPaymentCard(testCard.getCardAccountID(), testCard.getCardHolderName());
//			LOG.info(">>>>>>> testCard:"+testCard);
			if(testCard instanceof CardAccount) {
				String nw = ((CardAccount)testCard).getNetwork();
				if(nw!=null) {
					LOG.info("wg 03.02a-INVOICE_ubl.xml >>>>>>> testCard.Network="+nw);
					((CardAccount)paymentCard).setNetwork(nw);
				}
			}
		} else {
			LOG.warning("paymentCard.isEmpty");
		}
		
		DirectDebit directDebit = null;
		DirectDebit dd = testDoc.getDirectDebit();
		if(dd==null) {
			LOG.warning("dd.isEmpty");
		} else {
			// nur test:
			// ctor () not visible : gut
			// (interne) public copy ctor mit PaymentMeansType 
			// public PaymentMeans(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation,
			//		List<CreditTransfer> creditTransferList, PaymentCard paymentCard, DirectDebit directDebit) {
			PaymentInstructions zahlungsanweisungen = new PaymentMeans(PaymentMeansEnum.DirectDebit,
					"paymentMeansText", "remittanceInformation", null, null, dd
					);
			zahlungsanweisungen.setDirectDebit(dd);
			LOG.info(""+zahlungsanweisungen.getDirectDebit());
/* 03.01a-INVOICE_ubl.xml :
...
  <cac:PaymentMeans>
    <cbc:PaymentMeansCode>59</cbc:PaymentMeansCode>
  
    <cac:PaymentMandate>
      <cbc:ID>[Mandate reference identifier]</cbc:ID>
      <cac:PayerFinancialAccount>
        <cbc:ID>DE75512108001245126199</cbc:ID>
      </cac:PayerFinancialAccount>
    </cac:PaymentMandate>
  </cac:PaymentMeans>

 */
			LOG.info("DirectDebit/Lastschrift MandateReferencetID:"+dd.getMandateReferencetID() 
			+ " BankAssignedCreditorID:"+dd.getBankAssignedCreditorID() + " DebitedAccountID:"+dd.getDebitedAccountID());
			// TODO DirectDebitFactory
			directDebit = ((GenericInvoice)ublInvoice).createDirectDebit(dd.getMandateReferencetID(), dd.getBankAssignedCreditorID(), dd.getDebitedAccountID());
		}
		
		ublInvoice.setPaymentInstructions(paymentInstructions.getPaymentMeansEnum(), paymentInstructions.getPaymentMeansText(), paymentInstructions.getRemittanceInformation()
				, creditTransfer, paymentCard, directDebit); // dd statt directDebit geht auch
		
		LOG.info("finished.");
	}
	
	void makeVatBreakDownGroup(CoreInvoice ublInvoice) {
        List<TaxSubtotal> vbdList = testDoc.getVATBreakDowns();
        LOG.info("VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
        vbdList.forEach(tradeTax -> {
        	BG23_VatBreakdown vatBreakdown = new TaxSubtotal(
        	  new Amount(tradeTax.getTaxableAmount().getCurrencyID(), tradeTax.getTaxableAmount().getValue())
			, new Amount(tradeTax.getTaxAmount().getCurrencyID(), tradeTax.getTaxAmount().getValue())
			, TaxCategoryCode.valueOf(tradeTax.getTaxCategory())
			, tradeTax.getTaxCategory().getPercent()==null ? null : tradeTax.getTaxCategory().getPercent().getValue()
			); 
        	vatBreakdown.setTaxExemption(tradeTax.getTaxExemptionReasonText() , tradeTax.getTaxExemptionReasonCode());
        	ublInvoice.addVATBreakDown(vatBreakdown);
        });
		LOG.info("finished. "+vbdList.size() + " vatBreakDowns.");
	}
	
	void makeLineGroup(CoreInvoice ublDoc, GenericInvoice<?> testDoc) {
		List<CoreInvoiceLine> testLines = testDoc.getLines();
		LOG.info("LineGroup started for "+testLines.size() + " lines. testDoc ist "+testDoc.getClass());
		testLines.forEach(testLine -> {
			CoreInvoiceLine targetLine;
			if(testDoc.get() instanceof InvoiceType) {
				targetLine = GenericLine.createInvoiceLine(testLine.getId(), 
						testLine.getQuantity(),                                       // BT-129
						testLine.getLineTotalAmount(), testLine.getUnitPriceAmount(), // BT-131 , BG-29.BT-146 
						testLine.getItemName(),
						testLine.getTaxCategory(), testLine.getTaxRate()
						);
			} else {
				targetLine = GenericLine.createCreditNoteLine(testLine.getId(), 
						testLine.getQuantity(), 
						testLine.getLineTotalAmount(), testLine.getUnitPriceAmount(), 
						testLine.getItemName(),
						testLine.getTaxCategory(), testLine.getTaxRate()
						);
			}
			
			// opt:
			targetLine.setBuyerAccountingReference(testLine.getBuyerAccountingReference()); // BG-26.BT-133
			targetLine.setStartDate(testLine.getStartDateAsTimestamp()); // optional BG-26
			targetLine.setEndDate(testLine.getEndDateAsTimestamp());     // optional BG-26
			
			// BG-29:BT-149-0 0..1 , BT-150-0
			Quantity baseQuantity = testLine.getBaseQuantity();
			if(baseQuantity!=null) {
				LOG.info("PRICE DETAILS BG-29.BT-149 + BT-150 baseQuantity "+baseQuantity);
				// BG-29.BT-146 + BG-29:BT-149-0 0..1 , BT-150-0
				targetLine.setUnitPriceAmountAndQuantity(testLine.getUnitPriceAmount(), baseQuantity);
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
			List<Identifier> classifications = testLine.getClassifications(); // BG-31.BT-158 0..n
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
