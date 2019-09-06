package com.klst.xrechnung.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.CoreInvoiceLine;
import com.klst.einvoice.CoreInvoiceVatBreakdown;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.IContact;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.ubl.CommercialInvoice;
import com.klst.einvoice.ubl.CreditNote;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.ubl.GenericLine;
import com.klst.einvoice.ubl.Invoice;
import com.klst.einvoice.ubl.VatBreakdown;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
import com.klst.marshaller.UblCreditNoteTransformer;
import com.klst.marshaller.UblInvoiceTransformer;
import com.klst.untdid.codelist.DocumentNameCode;
import com.klst.untdid.codelist.PaymentMeansEnum;
import com.klst.untdid.codelist.TaxCategoryCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CommodityClassificationType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ItemClassificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

public class CreateUblXXXInvoice extends InvoiceFactory {

	private static final Logger LOG = Logger.getLogger(CreateUblXXXInvoice.class.getName());
	
	private static final String TESTDIR = "src/test/resources/"; // mit Daten aus xrechnung-1.2.0-testsuite-2018-12-14.zip\instances\
	
	private File testFile;
	private GenericInvoice testDoc;
//	private CreditNote testCreditNote;
	private GenericInvoice testGenericInvoice; // GenericInvoice ===> CoreInvoice
	
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
//				testCreditNote = toModelCreditNote(testFile);
				testGenericInvoice = toModelCN(testFile);
			}
		}
	}

	public GenericInvoice getTestDoc() {
		return testDoc;
	}
		
	Object makeCreditNote() {
		testGenericInvoice.getCustomization();
		testGenericInvoice.getProfile();
		testGenericInvoice.getTypeCode();
//		CoreInvoice ublInvoice = // in CoreInvoice sind nicht alle Methoden definiert, zB getSellerParty/getSeller , daher:
		GenericInvoice<CreditNoteType> ublInvoice =
				GenericInvoice.createCreditNote(testGenericInvoice.getCustomization(), testGenericInvoice.getProfile(), testGenericInvoice.getTypeCode());
		ublInvoice.setId(testGenericInvoice.getId());
		ublInvoice.setIssueDate(testGenericInvoice.getIssueDateAsTimestamp());
		ublInvoice.setDocumentCurrency(testGenericInvoice.getDocumentCurrency());
		ublInvoice.setTaxCurrency(testGenericInvoice.getTaxCurrency());
		ublInvoice.setBuyerReference(testGenericInvoice.getBuyerReferenceValue());
		
		LOG.info("makeOptionals...");	
			ublInvoice.setOrderReferenceID(testGenericInvoice.getOrderReferenceID());
			List<Object> notes = testGenericInvoice.getNotes();
			notes.forEach(note -> {
				ublInvoice.setNote(((NoteType)note).getValue());
			});
		LOG.info("finished makeOptionals.");
		
		ublInvoice.setSellerParty(testGenericInvoice.getSellerParty());
		ublInvoice.setBuyerParty(testGenericInvoice.getBuyerParty());
		ublInvoice.setPayee(testGenericInvoice.getPayee());
		ublInvoice.setTaxRepresentative(testGenericInvoice.getTaxRepresentative());

		PaymentMeansEnum code = testGenericInvoice.getPaymentMeansEnum();
		String paymentMeansText = testGenericInvoice.getPaymentMeansText();
		String remittanceInformation = testGenericInvoice.getPaymentRemittanceInformation();
		LOG.info("PaymentMeansEnum code:"+code + " paymentMeansText:"+paymentMeansText + " remittanceInformation:"+remittanceInformation);
		List<CreditTransfer> creditTransfer = testGenericInvoice.getCreditTransfer();
		PaymentCard paymentCard = null;
		DirectDebit directDebit = null;
		ublInvoice.setPaymentInstructions(code, paymentMeansText, remittanceInformation
				, creditTransfer, paymentCard, directDebit);
		
		ublInvoice.setPaymentTermsAndDate(testGenericInvoice.getPaymentTerm(), testGenericInvoice.getDueDateAsTimestamp());
		LOG.info("finished PaymentGroup.");

		ublInvoice.setDocumentTotals(testGenericInvoice.getInvoiceLineNetTotal(), 
					testGenericInvoice.getInvoiceTotalTaxExclusive(), 
					testGenericInvoice.getInvoiceTotalTaxInclusive(), 
					testGenericInvoice.getDuePayable());
		ublInvoice.setInvoiceTax(testGenericInvoice.getInvoiceTax());
		LOG.info("finished DocumentTotalsGroup.");
		
//		makeVatBreakDownGroup2(ublInvoice);
        List<VatBreakdown> vbdList = testGenericInvoice.getVATBreakDowns();
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
		
//		 LineGroup 
//		public List<GenericLine<?>> 
		List<?> list = testGenericInvoice.getLines();
		LOG.info("LineGroup started for "+list.size() + " lines.");
		List<GenericLine<CreditNoteLineType>> testLines = testGenericInvoice.getLines();
		testLines.forEach(testLine -> {
			GenericLine<CreditNoteLineType> targetLine = GenericLine.createCreditNoteLine(testLine.getId(), 
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
//	Object makeCreditNoteXXX() {
//		CreditNote ublInvoice = new  CreditNote(testCreditNote.getCustomization(), testCreditNote.getProfile(), testCreditNote.getTypeCode());
//		ublInvoice.setId(testCreditNote.getId());
//		ublInvoice.setIssueDate(testCreditNote.getIssueDateAsTimestamp());
//		ublInvoice.setDocumentCurrency(testCreditNote.getDocumentCurrency());
//		ublInvoice.setTaxCurrency(testCreditNote.getTaxCurrency());
//		ublInvoice.setBuyerReference(testCreditNote.getBuyerReferenceValue());
//		
//		LOG.info("makeOptionals...");	
//			ublInvoice.setOrderReferenceID(testCreditNote.getOrderReferenceID());
//			List<Object> notes = testCreditNote.getNotes();
//			notes.forEach(note -> {
//				ublInvoice.setNote(((NoteType)note).getValue());
//			});
//		LOG.info("finished makeOptionals.");
//		
//		ublInvoice.setSellerParty(testCreditNote.getSellerParty());
//		ublInvoice.setBuyerParty(testCreditNote.getBuyerParty());
//		ublInvoice.setPayeeParty(testCreditNote.getPayeeParty());
//		ublInvoice.setTaxRepresentativeParty(testCreditNote.getTaxRepresentativeParty());
//
//		PaymentMeansEnum code = testCreditNote.getPaymentMeansEnum();
//		String paymentMeansText = testCreditNote.getPaymentMeansText();
//		String remittanceInformation = testCreditNote.getRemittanceInformation();
//		LOG.info("code:"+code + " paymentMeansText:"+paymentMeansText + " remittanceInformation:"+remittanceInformation);
//		List<CreditTransfer> creditTransfer = testCreditNote.getCreditTransfer();
//		PaymentCard paymentCard = null;
//		DirectDebit directDebit = null;
//		ublInvoice.setPaymentInstructions(code, paymentMeansText, remittanceInformation
//				, creditTransfer, paymentCard, directDebit);
//		
//		ublInvoice.setPaymentTermsAndDate(testCreditNote.getPaymentTerm(), testCreditNote.getDueDateAsTimestamp());
//		LOG.info("finished PaymentGroup.");
//
////		void makesDocumentTotalsGroup(Invoice ublInvoice) {
//			ublInvoice.setDocumentTotals(testCreditNote.getInvoiceLineNetTotal(), 
//					testCreditNote.getInvoiceTotalTaxExclusive(), 
//					testCreditNote.getInvoiceTotalTaxInclusive(), testCreditNote.getDuePayable());
//			ublInvoice.setInvoiceTax(testCreditNote.getInvoiceTax());
//		LOG.info("finished DocumentTotalsGroup.");
//		
//		makeVatBreakDownGroup2(ublInvoice);
//		
////		 LineGroup 
//		List<GenericLine<CreditNoteLineType>> testLines = testCreditNote.getLines();
//		testLines.forEach(testLine -> {
//			GenericLine<CreditNoteLineType> targetLine = GenericLine.createCreditNoteLine(testLine.getId(), 
//			        testLine.getQuantity(),
//					testLine.getLineTotalAmount(), testLine.getUnitPriceAmount(), 
//					testLine.getItemName(),
//					testLine.getTaxCategory(), testLine.getTaxRate()
//					);
//			
//			// opt:
//			targetLine.setSellerAssignedID(testLine.getSellerAssignedID());   //BT-155 0..1
//			targetLine.setBuyerAssignedID(testLine.getBuyerAssignedID());     //BT-156 0..1
//			targetLine.setStandardID(testLine.getStandardID(), "TODOSchema"); //BT-157 0..1 , BT-157-1 required
//        	List<Object> cl = testLine.getClassificationList();                //BT-158 0..n , BT-158-1 1..1 , BT-158-2 0..1
//        	cl.forEach(c -> {
//        		if(c.getClass() == CommodityClassificationType.class) {
//        			ItemClassificationCodeType cc = ((CommodityClassificationType)c).getItemClassificationCode();
//        			targetLine.addClassificationID(cc.getValue(), cc.getListID(), cc.getListVersionID());
//        		}
//        	});
//			
////			testLine.getNotes().forEach(note -> {
////				targetLine.setNoteText(note);
////			});
//			targetLine.setNote(testLine.getNote());
//			
////			testLine.getOrderLineIDs().forEach(lineRef -> {
////				targetLine.setOrderLineID(lineRef);
////			});
//			targetLine.setOrderLineID(testLine.getOrderLineID());
//			
//			ublInvoice.addLine(targetLine);
//		});
//		LOG.info("LineGroup finished. "+testLines.size() + " lines.");
//
//		return ublInvoice;
//	}
//	void makeVatBreakDownGroup2(CreditNote ublInvoice) {
//        List<VatBreakdown> vbdList = testCreditNote.getVATBreakDowns();
//        LOG.info("CreditNote VATBreakDown starts for "+vbdList.size() + " VATBreakDowns.");
//        vbdList.forEach(tradeTax -> {
//        	VatBreakdown vatBreakdown = new VatBreakdown(
//        	  new Amount(tradeTax.getTaxableAmount().getCurrencyID(), tradeTax.getTaxableAmount().getValue())
//			, new Amount(tradeTax.getTaxAmount().getCurrencyID(), tradeTax.getTaxAmount().getValue())
//			, TaxCategoryCode.valueOf(tradeTax.getTaxCategory())
//			, tradeTax.getTaxCategory().getPercent()==null ? null : tradeTax.getTaxCategory().getPercent().getValue()
//			); 
//        	vatBreakdown.setTaxExemption(tradeTax.getTaxExemptionReasonText() , tradeTax.getTaxExemptionReasonCode());
//        	ublInvoice.addVATBreakDown(vatBreakdown);
//        });
//		LOG.info("finished. "+ublInvoice.getVATBreakDowns().size() + " vatBreakDowns.");
//	}

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
		
		ublInvoice.setSellerParty(testDoc.getSellerParty());
		LOG.info("Seller Address and Contact "+ublInvoice.getSellerParty().getAddress() + " "+ublInvoice.getSellerParty().getIContact());
		ublInvoice.setBuyerParty(testDoc.getBuyerParty());
		LOG.info("Buyer Address and Contact "+ublInvoice.getBuyerParty().getAddress() + " "+ublInvoice.getBuyerParty().getIContact());
		
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
	
//	void makeSellerGroup(GenericInvoice ublInvoice) {
//		ublInvoice.setSellerParty(testDoc.getSellerParty());
//		LOG.info("finished.");
//	}
//	
//	void makeBuyerGroup(GenericInvoice ublInvoice) {
//		ublInvoice.setBuyerParty(testDoc.getBuyerParty());
//		LOG.info("finished.");
//	}
	
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
	
//	void makesDocumentTotalsGroup(GenericInvoice ublInvoice) {
//		ublInvoice.setDocumentTotals(testDoc.getInvoiceLineNetTotal(), 
//				testDoc.getInvoiceTotalTaxExclusive(), 
//				testDoc.getInvoiceTotalTaxInclusive(), testDoc.getDuePayable());
//		ublInvoice.setInvoiceTax(testDoc.getInvoiceTax());
//		LOG.info("finished.");
//	}
	
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
		List<GenericLine<InvoiceLineType>> testLines = testDoc.getLines();
		testLines.forEach(testLine -> {
			GenericLine<InvoiceLineType> targetLine = GenericLine.createInvoiceLine(testLine.getId(), 
			//CoreInvoiceLine targetLine = GenericLine.createInvoiceLine(testLine.getId(), 
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
	
//	private CreditNote toModelCreditNote(File xmlfile) {
//		CreditNoteType invoice;
//		CreditNote creditNote = null;
//		try {
//			InputStream is = new FileInputStream(xmlfile);
//			invoice = transformer.toModel(is);
//			creditNote = new CreditNote(invoice);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			LOG.severe(ex.getMessage());			
//		}
//		return creditNote;
//	}
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
//	private Invoice toModel(File xmlfile) {
//		InvoiceType invoice;
//		CommercialInvoice cmInvoice = null;
//		try {
//			InputStream is = new FileInputStream(xmlfile);
//			invoice = transformer.toModel(is);
//			DocumentNameCode documentNameCode = DocumentNameCode.valueOf(invoice.getInvoiceTypeCode()); // ein enum
//			LOG.info("enum InvoiceTypeCode: " + documentNameCode);
//			if(documentNameCode==DocumentNameCode.CommercialInvoice) {
//				cmInvoice = new CommercialInvoice(invoice);
//				
//				String sellerRegistrationName = cmInvoice.getSellerParty().getRegistrationName();
//				String sellerCompanyID = cmInvoice.getSellerParty().getCompanyId();
//				String sellerCompanyLegalForm = cmInvoice.getSellerParty().getCompanyLegalForm();
//				
//				String buyerRegistrationName = cmInvoice.getBuyerParty().getRegistrationName();
//				String buyerCompanyID = cmInvoice.getBuyerParty().getCompanyId();
//				String buyerCompanyLegalForm = cmInvoice.getBuyerParty().getCompanyLegalForm();
//				
//				List<Map<Object,String>> sellerTaxSchemes = cmInvoice.getSellerTaxSchemes();
//				Map<Object, String> sellerTaxScheme = null;
//				if(sellerTaxSchemes.isEmpty()) {
//					LOG.warning("sellerTaxSchemes is empty");
//				} else {
//					LOG.info("------------------------------ sellerTaxSchemes #="+sellerTaxSchemes.size());
//					sellerTaxScheme = sellerTaxSchemes.get(0); // first
//				}
//				List<Map<Object,String>> buyerTaxSchemes = cmInvoice.getBuyerTaxSchemes();
//				Map<Object, String> buyerTaxScheme = null;
//				if(buyerTaxSchemes.isEmpty()) {
//					LOG.warning("buyerTaxSchemes is empty");
//					buyerTaxScheme = new HashMap<Object,String>();
//				} else {
//					buyerTaxScheme = buyerTaxSchemes.get(0); // first
//				}
//				
//				IContact buyerContact = cmInvoice.getBuyerParty().getIContact();
//				if(buyerContact==null) {
//					LOG.warning("buyerContact is null");
//					buyerContact = cmInvoice.createContact("nix", "0", "nix@nix.nix");
//				}
//				
////				List<PaymentMeans> paymentInstructions = cmInvoice.getPaymentInstructions();
////				PaymentMeans paymentInstruction = null;
////				if(paymentInstructions.isEmpty()) {
////					LOG.warning("paymentInstructions is empty");
////					paymentInstruction = new PaymentMeans(PaymentMeansEnum.InCash, new FinancialAccount(new IBANId("nix")));
////				} else {
////					paymentInstruction = paymentInstructions.get(0); // first
////				}
//				
//				String paymentTerm = cmInvoice.getPaymentTerm();
//				
//				List<VatBreakdown> vatBreakDownList = cmInvoice.getVATBreakDowns();
//				VatBreakdown vatBreakDown = null;
////				List<Map<Object,Object>> vatBreakDownList = cmInvoice.getVATBreakDown();
////				Map<Object, Object> vatBreakDown = null;
//				if(vatBreakDownList.isEmpty()) {
//					LOG.warning("vatBreakDownList is empty");
////					vatBreakDown = new HashMap<Object,Object>();
//				} else {
//					vatBreakDown = vatBreakDownList.get(0); // first
//				} 
//
//				List<GenericLine<InvoiceLineType>> invoiceLines = cmInvoice.getLines();
//				LOG.info("\ninvoice ID="+			        cmInvoice.getId() +
//						" \ninvoice IssueDate="+			cmInvoice.getIssueDateAsTimestamp() + 
//						" \ninvoice CustomizationID="+		cmInvoice.getCustomization() + 
//						" \ninvoice ProfileID="+			cmInvoice.getProfile() + 
//						" \ninvoice tDocumentNameCode="+	cmInvoice.getTypeCode() + 
//						" \ninvoice Notes#:"+				cmInvoice.getNotes().size() +
//						" \ninvoice TaxCurrency="+			cmInvoice.getTaxCurrency() + 
//						" \ninvoice DocumentCurrency="+		cmInvoice.getDocumentCurrency() + 
//						" \ninvoice BuyerReferenceValue="+	cmInvoice.getBuyerReferenceValue() + 
//						" \ninvoice OrderReferenceID="+		cmInvoice.getOrderReferenceID() + 
//						" \ninvoice SellerRegistrationName="+	sellerRegistrationName +					
//						" \ninvoice SellerCompanyID="+			sellerCompanyID +					
//						" \ninvoice SellerCompanyLegalForm="+	sellerCompanyLegalForm +					
//						" \ninvoice BuyerRegistrationName="+	buyerRegistrationName +					
//						" \ninvoice BuyerCompanyID="+			buyerCompanyID +					
//						" \ninvoice BuyerCompanyLegalForm="+	buyerCompanyLegalForm +					
//						" \ninvoice SellerTaxScheme="+		sellerTaxScheme.get(TaxSchemeType.class) +					
//						" \ninvoice SellerCompanyID="+		sellerTaxScheme.get(CompanyIDType.class) +					
//						" \ninvoice SellerAddress="+		cmInvoice.getSellerParty().getAddress() +					
//						" \ninvoice SellerContact="+		(cmInvoice.getSellerParty()==null ? "null" : cmInvoice.getSellerParty().getIContact()) +					
//						" \ninvoice BuyerAddress="+			cmInvoice.getBuyerParty().getAddress() +					
//						" \ninvoice BuyerContact="+			buyerContact +				
//						" \ninvoice buyerTaxSchemes#:"+		cmInvoice.getBuyerTaxSchemes().size() +
//						" \ninvoice BuyerTaxScheme="+		buyerTaxScheme.get(TaxSchemeType.class) +					
//						" \ninvoice BuyerCompanyID="+		buyerTaxScheme.get(CompanyIDType.class) +					
//						" \ninvoice InvoiceLineNetTotal="+		cmInvoice.getInvoiceLineNetTotal() +					
//						" \ninvoice InvoiceTotalTaxExclusive="+	cmInvoice.getInvoiceTotalTaxExclusive() +					
//						" \ninvoice InvoiceTotalTaxInclusive="+	cmInvoice.getInvoiceTotalTaxInclusive() +					
//						" \ninvoice DuePayable="+				cmInvoice.getDuePayable() +					
//						" \ninvoice InvoiceTax="+				cmInvoice.getInvoiceTax() +					
////						" \ninvoice paymentInstructions#:"+		cmInvoice.getPaymentInstructions().size() +					
////						" \ninvoice paymentInstruction.PaymentMeans="+	paymentInstruction.getPaymentMeansEnum()+" "+paymentInstruction.getFinancialAccount().getID().getValue() +				
//						" \ninvoice paymentTerms.1st Note="+	paymentTerm +				
////						" \ninvoice VATBreakDown.TaxableAmount="+	vatBreakDown.get(TaxableAmountType.class) +					
////						" \ninvoice VATBreakDown.TaxAmount="+		vatBreakDown.get(TaxAmountType.class) +					
////						" \ninvoice VATBreakDown.VatCategory="+		vatBreakDown.get(VatCategory.class) +					
//						" \ninvoice invoiceLines#:"+		invoiceLines.size() 
//						);
//				invoiceLines.forEach(invoiceLine -> {
//					LOG.info("\n invoiceLine ID="+			        invoiceLine.getId() +
//							" \n invoiceLine ItemName="+			invoiceLine.getItemName() +
//							" \n invoiceLine Quantity="+			invoiceLine.getQuantity() +
//							" \n invoiceLine ItemNetPrice="+		invoiceLine.getUnitPriceAmount() +
//							" \n invoiceLine LineNetAmount="+		invoiceLine.getLineTotalAmount() +
//							" \n invoiceLine TaxCategory/Rate="+	invoiceLine.getTaxCategory()+invoiceLine.getTaxRate()
//							);
//				});
//
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			LOG.severe(ex.getMessage());
//		}
//		return cmInvoice;
//	}

}
