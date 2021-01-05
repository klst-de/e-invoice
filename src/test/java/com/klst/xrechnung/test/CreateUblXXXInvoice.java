package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import com.klst.einvoice.BG24_AdditionalSupportingDocs;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BG23_VatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.Identifier;
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
import com.klst.marshaller.UblCreditNoteTransformer;
import com.klst.marshaller.UblInvoiceTransformer;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CommodityClassificationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ItemClassificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
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
		testCN.getCustomization();
		testCN.getProfile();
		testCN.getTypeCode();
//		CoreInvoice ublInvoice = // in CoreInvoice sind nicht alle Methoden definiert, zB getSellerParty/getSeller , daher:
		GenericInvoice<CreditNoteType> ublInvoice =
				GenericInvoice.createCreditNote(testCN.getCustomization(), testCN.getProfile(), testCN.getTypeCode());
		ublInvoice.setId(testCN.getId());
		ublInvoice.setIssueDate(testCN.getIssueDateAsTimestamp());
		ublInvoice.setDocumentCurrency(testCN.getDocumentCurrency());
		ublInvoice.setTaxCurrency(testCN.getTaxCurrency());
		ublInvoice.setBuyerReference(testCN.getBuyerReferenceValue());
		
		LOG.info("makeOptionals...");	
			ublInvoice.setOrderReference(testCN.getOrderReference());
			List<Object> notes = testCN.getNotes();
			notes.forEach(note -> {
				ublInvoice.setNote(((NoteType)note).getValue());
			});
		LOG.info("finished makeOptionals.");
		
		ublInvoice.setSeller(testCN.getSeller());
		ublInvoice.setBuyer(testCN.getBuyer());
		ublInvoice.setPayee(testCN.getPayee());
		ublInvoice.setTaxRepresentative(testCN.getTaxRepresentative());

		PaymentInstructions paymentInstructions = testCN.getPaymentInstructions();
		LOG.info("PaymentInstructions "+paymentInstructions);
//		PaymentMeansEnum code = testCN.getPaymentMeansEnum();
//		String paymentMeansText = testCN.getPaymentMeansText();
//		String remittanceInformation = testCN.getPaymentRemittanceInformation();
//		LOG.info("PaymentMeansEnum code:"+code + " paymentMeansText:"+paymentMeansText + " remittanceInformation:"+remittanceInformation);
		List<CreditTransfer> creditTransfer = paymentInstructions.getCreditTransfer();
		PaymentCard paymentCard = null;
		DirectDebit directDebit = null;
		ublInvoice.setPaymentInstructions(paymentInstructions.getPaymentMeansEnum(), paymentInstructions.getPaymentMeansText(), paymentInstructions.getRemittanceInformation()
				, creditTransfer, paymentCard, directDebit);
		
		ublInvoice.setPaymentTermsAndDate(testCN.getPaymentTerm(), testCN.getDueDateAsTimestamp());
		LOG.info("finished PaymentGroup.");

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
		
//		LineGroup 
		List<?> list = testCN.getLines();
		LOG.info("LineGroup started for "+list.size() + " lines.");
		List<GenericLine<?>> testLines = testCN.getLines();
		testLines.forEach(testLine -> {
			CoreInvoiceLine targetLine = GenericLine.createCreditNoteLine(testLine.getId(), 
			        testLine.getQuantity(),
					testLine.getLineTotalAmount(), testLine.getUnitPriceAmount(), 
					testLine.getItemName(),
					testLine.getTaxCategory(), testLine.getTaxRate()
					);
			
			// opt:
			targetLine.setUnitPriceAmountAndQuantity(testLine.getUnitPriceAmount(), testLine.getBaseQuantity()); // BT-149-0 + BT-150-0 
			targetLine.setSellerAssignedID(testLine.getSellerAssignedID());   //BT-155 0..1
			targetLine.setBuyerAssignedID(testLine.getBuyerAssignedID());     //BT-156 0..1
			targetLine.setStandardID(testLine.getStandardID(), "TODOSchema"); //BT-157 0..1 , BT-157-1 required
        	List<Object> cl = testLine.getClassificationList();                //BT-158 0..n , BT-158-1 1..1 , BT-158-2 0..1
        	cl.forEach(c -> {
        		if(c.getClass() == CommodityClassificationType.class) {
        			ItemClassificationCodeType cc = ((CommodityClassificationType)c).getItemClassificationCode();
        			targetLine.addClassificationID(cc.getValue(), cc.getListID(), cc.getListVersionID());
        		}
        	});
			
			targetLine.setNote(testLine.getNote()); // opt BT-127
			targetLine.setLineObjectIdentifier(
					testLine.getLineObjectIdentifier()); // opt BT-128
			targetLine.setOrderLineID(testLine.getOrderLineID());
			
			ublInvoice.addLine(targetLine);
		});
		LOG.info("LineGroup finished: "+testLines.size() + " lines.");

		return ublInvoice.get();
	}
	@Override
	Object makeInvoice() {
		if(testDoc==null) {
			return makeCreditNote();
		}
		testDoc.getCustomization();
		testDoc.getProfile();
		testDoc.getTypeCode();
//		CoreInvoice ublInvoice = // in CoreInvoice sind nicht alle Methoden definiert, zB getSellerParty/getSeller , daher:
		GenericInvoice<InvoiceType> ublInvoice =
				GenericInvoice.createInvoice(testDoc.getCustomization(), testDoc.getProfile(), testDoc.getTypeCode());
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
		
		makeOptionals(ublInvoice);
		
		makePaymentGroup(ublInvoice);
		
		ublInvoice.setDocumentTotals(testDoc.getInvoiceLineNetTotal(), 
				testDoc.getInvoiceTotalTaxExclusive(), 
				testDoc.getInvoiceTotalTaxInclusive(), 
				testDoc.getDuePayable());
		
		Amount invoiceTaxAmount =  testDoc.getInvoiceTax();
    	LOG.info("----------------------InvoiceTax amount "+invoiceTaxAmount);
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
        Amount invoiceTaxIAAmount = testDoc.getInvoiceTaxInAccountingCurrency();
    	LOG.info("--InvoiceTaxInAccountingCurrency amount "+invoiceTaxIAAmount);
    	if(invoiceTaxAmount==null) {
    		// wie im Bsp. 02.01a
    		ublInvoice.setInvoiceTax(new Amount(testDoc.getDocumentCurrency(), invoiceTaxIAAmount.getValue()));   	
            ublInvoice.setInvoiceTaxInAccountingCurrency(invoiceTaxIAAmount);
    	} else {
    		ublInvoice.setInvoiceTax(invoiceTaxAmount);
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
		makeLineGroup(ublInvoice);
		LOG.info("finished.");
		return ublInvoice.get();
	}

	void makeOptionals(GenericInvoice ublInvoice) {	
		ublInvoice.setProjectReference(testDoc.getProjectReference()); // BT-11 + 0..1
		ublInvoice.setContractReference(testDoc.getContractReference()); // BT-12 + 0..1
		ublInvoice.setPurchaseOrderReference(testDoc.getPurchaseOrderReference()); // BT-13 + 0..1
		ublInvoice.setOrderReference(testDoc.getOrderReference()); // BT-14 + 0..1
		
		ublInvoice.setTenderOrLotReference(testDoc.getTenderOrLotReference()); // BT-17 + 0..1
		
		List<Object> notes = testDoc.getNotes();
		notes.forEach(note -> {
			ublInvoice.setNote(((NoteType)note).getValue());
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
	
	void makePaymentGroup(GenericInvoice ublInvoice) {
		PaymentInstructions paymentInstructions = testDoc.getPaymentInstructions();
		LOG.info("PaymentInstructions "+paymentInstructions + " PaymentMeans="+paymentInstructions.getPaymentMeansEnum());
		
		List<CreditTransfer> creditTransfer = paymentInstructions.getCreditTransfer();
		if(creditTransfer.isEmpty()) {
			LOG.warning("creditTransfer.isEmpty");
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
			directDebit = ublInvoice.createDirectDebit(dd.getMandateReferencetID(), dd.getBankAssignedCreditorID(), dd.getDebitedAccountID());
		}
		
		ublInvoice.setPaymentInstructions(paymentInstructions.getPaymentMeansEnum(), paymentInstructions.getPaymentMeansText(), paymentInstructions.getRemittanceInformation()
				, creditTransfer, paymentCard, directDebit); // dd statt directDebit geht auch
		
		ublInvoice.setPaymentTermsAndDate(testDoc.getPaymentTerm(), testDoc.getDueDateAsTimestamp());
		LOG.info("finished.");
	}
	
	void makeVatBreakDownGroup(GenericInvoice ublInvoice) {
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
		LOG.info("finished. "+ublInvoice.getVATBreakDowns().size() + " vatBreakDowns.");
	}
	
	void makeLineGroup(GenericInvoice ublDoc) {
		List<?> list = testDoc.getLines();
		LOG.info("LineGroup started for "+list.size() + " lines.");
		List<GenericLine<?>> testLines = testDoc.getLines();
		testLines.forEach(testLine -> {
//			GenericLine<InvoiceLineType> targetLine = GenericLine.createInvoiceLine(testLine.getId(), 
			CoreInvoiceLine targetLine = GenericLine.createInvoiceLine(testLine.getId(), 
					testLine.getQuantity(), 
					testLine.getLineTotalAmount(), testLine.getUnitPriceAmount(), 
					testLine.getItemName(),
					testLine.getTaxCategory(), testLine.getTaxRate()
					);
			
			// opt:
			targetLine.setBuyerAccountingReference(testLine.getBuyerAccountingReference()); // BG-26.BT-133
			targetLine.setStartDate(testLine.getStartDateAsTimestamp()); // optional
			targetLine.setEndDate(testLine.getEndDateAsTimestamp()); // optional
			
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
			targetLine.setLineObjectIdentifier(
					testLine.getLineObjectIdentifier()); // opt BT-128
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
