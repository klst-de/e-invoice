package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.ubl.GenericLine;
import com.klst.einvoice.ubl.VatBreakdown;
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
			LOG.warning(ublXml + "ist nicht UblInvoice!!!!!!!!!!!!!!!");
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
			ublInvoice.setOrderReferenceID(testCN.getOrderReferenceID());
			List<Object> notes = testCN.getNotes();
			notes.forEach(note -> {
				ublInvoice.setNote(((NoteType)note).getValue());
			});
		LOG.info("finished makeOptionals.");
		
		ublInvoice.setSeller(testCN.getSeller());
		ublInvoice.setBuyer(testCN.getBuyer());
		ublInvoice.setPayee(testCN.getPayee());
		ublInvoice.setTaxRepresentative(testCN.getTaxRepresentative());

		PaymentMeansEnum code = testCN.getPaymentMeansEnum();
		String paymentMeansText = testCN.getPaymentMeansText();
		String remittanceInformation = testCN.getPaymentRemittanceInformation();
		LOG.info("PaymentMeansEnum code:"+code + " paymentMeansText:"+paymentMeansText + " remittanceInformation:"+remittanceInformation);
		List<CreditTransfer> creditTransfer = testCN.getCreditTransfer();
		PaymentCard paymentCard = null;
		DirectDebit directDebit = null;
		ublInvoice.setPaymentInstructions(code, paymentMeansText, remittanceInformation
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
        List<VatBreakdown> vbdList = testCN.getVATBreakDowns();
        LOG.info("CreditNote VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
        vbdList.forEach(tradeTax -> {
        	VatBreakdown vatBreakdown = new VatBreakdown(
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
			
			targetLine.setNote(testLine.getNote());
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
		LOG.info("ublInvoice "+ublInvoice);
		
		ublInvoice.setSeller(testDoc.getSeller());
		LOG.info("Seller Address and Contact "+ublInvoice.getSeller().getAddress() + " "+ublInvoice.getSeller().getIContact());
		ublInvoice.setBuyer(testDoc.getBuyer());
		LOG.info("Buyer Address and Contact "+ublInvoice.getBuyer().getAddress() + " "+ublInvoice.getBuyer().getIContact());
		
		makeOptionals(ublInvoice);
		
//		makeSellerGroup(ublInvoice);
//		makeBuyerGroup(ublInvoice);
		makePaymentGroup(ublInvoice);
		
		ublInvoice.setDocumentTotals(testDoc.getInvoiceLineNetTotal(), 
				testDoc.getInvoiceTotalTaxExclusive(), 
				testDoc.getInvoiceTotalTaxInclusive(), 
				testDoc.getDuePayable());
		ublInvoice.setInvoiceTax(testDoc.getInvoiceTax());
		LOG.info("finished DocumentTotalsGroup.");
//		makesDocumentTotalsGroup(ublInvoice);
		
		makeVatBreakDownGroup(ublInvoice);
		makeLineGroup(ublInvoice);
		LOG.info("finished.");
		return ublInvoice.get();
	}

	void makeOptionals(GenericInvoice ublInvoice) {	
		ublInvoice.setOrderReferenceID(testDoc.getOrderReferenceID());
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
		ublInvoice.addDelivery(testDoc.getDeliveries());
		
		LOG.info("finished.");
	}
	
	void makePaymentGroup(GenericInvoice ublInvoice) {
		PaymentMeansEnum code = testDoc.getPaymentMeansEnum(); // TODO besser testDoc.getPaymentMeans().getPaymentMeansEnum()
		String paymentMeansText = testDoc.getPaymentMeansText();
		String remittanceInformation = testDoc.getPaymentRemittanceInformation();
		LOG.info("PaymentMeans code:"+code + " paymentMeansText:"+paymentMeansText + " remittanceInformation:"+remittanceInformation);
		
		List<CreditTransfer> creditTransfer = testDoc.getCreditTransfer();
		if(creditTransfer.isEmpty()) {
			LOG.warning("creditTransfer.isEmpty");
		} else {
			IBANId iban = new IBANId(creditTransfer.get(0).getPaymentAccountID());
			String accountName = creditTransfer.get(0).getPaymentAccountName();
			BICId bic = new BICId(creditTransfer.get(0).getPaymentServiceProviderID());
			LOG.info("iban:"+iban + " accountName:"+accountName + " bic:"+bic);
//			CreditTransfer ct = FinancialAccount.createCreditTransfer(iban, accountName, bic);
		}
		
		PaymentCard paymentCard = ublInvoice.createPaymentCard(null, null);
		
		DirectDebit directDebit = null;
		DirectDebit dd = testDoc.getDirectDebit();
		if(dd==null) {
			LOG.warning("dd.isEmpty");
		} else {
			LOG.info("MandateReferencetID:"+dd.getMandateReferencetID() + " BankAssignedCreditorID:"+dd.getBankAssignedCreditorID() + " DebitedAccountID:"+dd.getDebitedAccountID());
			directDebit = ublInvoice.createDirectDebit(dd.getMandateReferencetID(), dd.getBankAssignedCreditorID(), dd.getDebitedAccountID());
		}
		
		ublInvoice.setPaymentInstructions(code, paymentMeansText, remittanceInformation
				, creditTransfer, paymentCard, directDebit); // dd statt directDebit geht auch
		
		ublInvoice.setPaymentTermsAndDate(testDoc.getPaymentTerm(), testDoc.getDueDateAsTimestamp());
		LOG.info("finished.");
	}
	
	void makeVatBreakDownGroup(GenericInvoice ublInvoice) {
        List<VatBreakdown> vbdList = testDoc.getVATBreakDowns();
        LOG.info("VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
        vbdList.forEach(tradeTax -> {
        	CoreInvoiceVatBreakdown vatBreakdown = new VatBreakdown(
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
			
        	targetLine.setNote(testLine.getNote());   	
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
