package com.klst.einvoice.unece.uncefact;

import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.CreditTransferFactory;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.PaymentInstructionsFactory;
import com.klst.untdid.codelist.PaymentMeansEnum;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SpecifiedPeriodType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class ApplicableHeaderTradeSettlement extends HeaderTradeSettlementType 
	implements PaymentInstructions, PaymentInstructionsFactory, CreditTransferFactory {

	private static final Logger LOG = Logger.getLogger(ApplicableHeaderTradeSettlement.class.getName());
	
	ApplicableHeaderTradeSettlement() {
		super();
	}

	PaymentInstructions pi;
	
	@Override // implements PaymentInstructionsFactory
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText) {
		return new TradeSettlementPaymentMeans(code, paymentMeansText);
//		return new ApplicableHeaderTradeSettlement(code, paymentMeansText, null);
	}
	PaymentInstructions createPaymentInstructions(HeaderTradeSettlementType hts) {
		List<TradeSettlementPaymentMeansType> tspmList = hts.getSpecifiedTradeSettlementPaymentMeans();
		LOG.info("do bg16( ... hts.SpecifiedTradeSettlementPaymentMeans, aka BG-16 tspmList#:" + tspmList.size());
		
//		TradeSettlementPaymentMeansType tspm = null;
//		PaymentMeansEnum pmc = null; // BT-81
//		String paymentMeansText = null;
//		
//		List<TextType> list = null; 
//		if(tspmList.isEmpty()) {
//			list = new ArrayList<TextType>();
//			return null;
//		} else {
//			tspm = tspmList.get(0);
//			pmc = PaymentMeansEnum.valueOf(tspm.getTypeCode());
//			list = tspm.getInformation();  // BT-82 text des ersten tspmList elements!!!!
//			paymentMeansText = list.isEmpty() ? null : list.get(0).getValue();
//			return new TradeSettlementPaymentMeans(tspm); // geht auch, da TradeSettlementPaymentMeans implements PaymentInstructions
//		}
		return tspmList.isEmpty() ? null : new TradeSettlementPaymentMeans(tspmList.get(0));
	}

	// copy ctor
	public ApplicableHeaderTradeSettlement(HeaderTradeSettlementType hts) {
		this();
		List<TradePaymentTermsType> stptList = hts.getSpecifiedTradePaymentTerms();
		super.getSpecifiedTradePaymentTerms(); // List<TradePaymentTermsType> 0..n
		pi = createPaymentInstructions(hts);
		setBG16(pi);
		
		if(stptList.isEmpty()) {
			//
		} else {
			List<TextType> descriptionList = stptList.get(0).getDescription(); // BT-20 + 0..1 Payment terms
			LOG.info("descriptionList#:"+descriptionList.size() + " super.SpecifiedTradePaymentTerms#"+super.getSpecifiedTradePaymentTerms().size());
			if(descriptionList.isEmpty()) { 
				// Description is optional
			} else {
				TradePaymentTermsType tradePaymentTerms = new TradePaymentTermsType();
				tradePaymentTerms.getDescription().add(CrossIndustryInvoice.newTextType(descriptionList.get(0).getValue()));
				super.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
			}
			DateTimeType dueDateDateTime = stptList.get(0).getDueDateDateTime(); // BT-9 0..1 Payment due date 
			if(dueDateDateTime==null) {
				// Payment due date is optional
			} else {
				List<TradePaymentTermsType> tradePaymentTermsList = super.getSpecifiedTradePaymentTerms();
				if(tradePaymentTermsList.isEmpty()) {
					tradePaymentTermsList.add(new TradePaymentTermsType());
				}
				TradePaymentTermsType tradePaymentTerms = tradePaymentTermsList.get(0);
				tradePaymentTerms.setDueDateDateTime(dueDateDateTime);
			}
		}
		
		List<TextType> prList = hts.getPaymentReference(); // BT-83 
		if(!prList.isEmpty()) {
			prList.forEach(remittanceInformation -> {
				LOG.info("remittanceInformation:"+remittanceInformation.getValue());
			});
			
		}

		setRemittanceInformation(prList.isEmpty() ? null : prList.get(0).getValue());
		
		SpecifiedPeriodType specifiedPeriodType = hts.getBillingSpecifiedPeriod(); // wg. BG14
		if(specifiedPeriodType!=null) super.setBillingSpecifiedPeriod(specifiedPeriodType);
	}

	public ApplicableHeaderTradeSettlement(PaymentMeansEnum pmc, String paymentMeansText, String remittanceInformation) {
		this();
		super.getSpecifiedTradePaymentTerms(); // List<TradePaymentTermsType> 0..n
		pi = createPaymentInstructions(pmc, paymentMeansText);
		setBG16(pi);
		setRemittanceInformation(remittanceInformation);
	}
	
	void setBG16(PaymentInstructions paymentInstructions) { // TODOrename to setPaymentInstructions
// EN16931 sagt: BG-16 0..1 PAYMENT INSTRUCTIONS
// CII:
// 0 .. n SpecifiedTradeSettlementPaymentMeans Zahlungsanweisungen BG-16
		if(paymentInstructions==null) return;
		LOG.info("vor add SpecifiedTradeSettlementPaymentMeans.size="+super.getSpecifiedTradeSettlementPaymentMeans().size());
		super.getSpecifiedTradeSettlementPaymentMeans().add((TradeSettlementPaymentMeans)paymentInstructions);
	}
//	/**
//	 * add a group PAYMENT INSTRUCTIONS, BG-16 Cardinality 0..1
//	 * 
//	 * @param code                   mandatory BT-81
////	 * @param iban                   mandatory BT-84            TODO
////	 *                                                 interface CreditTransfer List wg.: 0..n CREDIT TRANSFER BG-17
////	 *                                         oder    interface PAYMENT CARD INFORMATION 0..1 BG-18
////	 *                                         oder    interface DIRECT DEBIT             0..1 BG-19
//	 * @param paymentMeansText       optional  BT-82 (can be null)
//	 * @param remittanceInformation  optional  BT-83
//	 * @param creditTransfer         optional  BG-17
//	 */
//	void addBG16(PaymentMeansCode code, String paymentMeansText, String remittanceInformation) {
////		LOG.info("code:"+code + " paymentMeansText:"+paymentMeansText + " remittanceInformation:"+remittanceInformation);
//		setBG16(createPaymentInstructions(code, paymentMeansText));
//
//		setRemittanceInformation(remittanceInformation);
//	}

	/*

    <ram:ApplicableHeaderTradeSettlement>
        <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>
        <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>  <<======== setPaymentCurrencyCode

        <ram:SpecifiedTradeSettlementPaymentMeans>              <<======== addPaymentInstructions SpecifiedTradeSettlementPaymentMeans
            <ram:TypeCode>30</ram:TypeCode>
            <ram:PayeePartyCreditorFinancialAccount>
                <ram:IBANID>DE12345678912345678912</ram:IBANID>
            </ram:PayeePartyCreditorFinancialAccount>
        </ram:SpecifiedTradeSettlementPaymentMeans>
        
        
    </ram:ApplicableHeaderTradeSettlement>
1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. 1 CreditorReferenceID Kennung des Gläubigers                                                 BG-19/ BT-90 
0 .. 1 PaymentReference Verwendungszweck                                                                 BT-83 
0 .. 1 TaxCurrencyCode Code für die Währung der Umsatzsteuerbuchung                                      BT-6 
1 .. 1 InvoiceCurrencyCode Code für die Rechnungswährung                                                 BT-5




0 .. n SpecifiedTradeSettlementPaymentMeans Zahlungsanweisungen               BG-16 xs:sequence 
1 .. 1 TypeCode Code für die Zahlungsart                                      BT-81 
0 .. 1 Information Text zur Zahlungsart                                       BT-82 
0 .. 1 ApplicableTradeSettlementFinancialCard Informationen zur Zahlungskarte BG-18 xs:sequence 
1 .. 1 ID Zahlungskartennummer                                                BT-87 
0 .. 1 CardholderName Name des Zahlungskarteninhabers                         BT-88 
0 .. 1 PayerPartyDebtorFinancialAccount Bankinstitut des Käufers xs:sequence 
1 .. 1 IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos         BG-19/ BT-91           TODO
0 .. 1 PayeePartyCreditorFinancialAccount Überweisung                         BG-17 xs:sequence 
0 .. 1 IBANID Kennung des Zahlungskontos                                      BT-84         ----------------- <<BT17
0 .. 1 AccountName Name des Zahlungskontos                                    BT-85         ----------------- <<BT17
0 .. 1 ProprietaryID Nationale Kontonummer (nicht für SEPA)                   BT-84-0       ----------------- <<BT17
0 .. 1 PayeeSpecifiedCreditorFinancialInstitution Bankinstitut des Verkäufers xs:sequence 
1 .. 1 BICID Kennung des Zahlungsdienstleisters                               BT-86         ----------------- <<BT17

0 .. 1 SupplyChainTradeTransaction Gruppierung der Informationen zum Geschäftsvorfall
1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich xs:sequence 
0 .. 1 CreditorReferenceID Kennung des Gläubigers                             BG-19/ BT-90 
0 .. 1 PaymentReference Verwendungszweck                                      BT-83

	 */
	
	@Override
	public void setPaymentMeans(PaymentMeansEnum code, String text) { // code+text
		TradeSettlementPaymentMeansType tspm = (TradeSettlementPaymentMeans)createPaymentInstructions(code, text); // use addBG16
		super.getSpecifiedTradeSettlementPaymentMeans().add(tspm);
//		TradeSettlementPaymentMeansType tspm = new TradeSettlementPaymentMeansType();
//		PaymentMeansCodeType pmc = new PaymentMeansCodeType(); // BT-81
//		pmc.setValue(code.getValueAsString());
//		tspm.setTypeCode(pmc);
//
//		if(text!=null) {
//			tspm.getInformation().add(CrossIndustryInvoice.newTextType(text));
//		}
//
//		super.getSpecifiedTradeSettlementPaymentMeans().add(tspm);
	}
	@Override
	public void setPaymentMeansEnum(PaymentMeansEnum code) { // use addPaymentMeansCT
		setPaymentMeans(code, null);
	}

	@Override
	public PaymentMeansEnum getPaymentMeansEnum() {
		return pi.getPaymentMeansEnum();
//		List<TradeSettlementPaymentMeansType> tspmList = super.getSpecifiedTradeSettlementPaymentMeans();
//		return tspmList.isEmpty() ? null : PaymentMeansCode.valueOf(tspmList.get(0).getTypeCode()); // Code des ersten tspmList elements!!!!
	}

	@Deprecated
	void setPaymentMeansText(String text) { // use setPaymentMeans(PaymentMeansCode code, String text)
	}

	@Override
	public String getPaymentMeansText() {
		return pi.getPaymentMeansText();
//		List<TradeSettlementPaymentMeansType> tspmList = super.getSpecifiedTradeSettlementPaymentMeans();
//		if(tspmList.isEmpty()) return null;
//		List<TextType> list = tspmList.get(0).getInformation();  // text des ersten tspmList elements!!!!
//		return list.isEmpty() ? null : list.get(0).getValue();
	}

	@Override
	public void setRemittanceInformation(String text) { 
		if(text==null) return;
		super.getPaymentReference().add(CrossIndustryInvoice.newTextType(text));
	}

	@Override
	public String getRemittanceInformation() {
		List<TextType> list = super.getPaymentReference();
		return list.isEmpty() ? null : list.get(0).getValue();
	}

//	-------------------------------------------------

	public CreditTransfer getCreditTransfer() {
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("SpecifiedTradeSettlementPaymentMeans is empty");
			return null;
		}
		LOG.info("SpecifiedTradeSettlementPaymentMeans is "+super.getSpecifiedTradeSettlementPaymentMeans().get(0).getClass());
		TradeSettlementPaymentMeans tspm = (TradeSettlementPaymentMeans)super.getSpecifiedTradeSettlementPaymentMeans().get(0);
		LOG.info("TradeSettlementPaymentMeans implementiert CreditTransfer >>>>>> 1..1 >>>>>>> PaymentAccount:" 
				+ tspm.getPaymentAccountID());
		return tspm;
	}
	
	public CreditTransfer createCreditTransfer(IBANId iban) { // eigentlich ist es setXXXXX
		LOG.info("class ßßßßßß:"+super.getSpecifiedTradeSettlementPaymentMeans().get(0).getClass());
		TradeSettlementPaymentMeans tspm = (TradeSettlementPaymentMeans)super.getSpecifiedTradeSettlementPaymentMeans().get(0);
//		tspm.setPaymentAccountID(iban);
		LOG.info(">>>>>>>>>>>>>>>>> PaymentAccountI:"+tspm.getPaymentAccountID());
		return tspm; // TODO
//		return new TradeSettlementPaymentMeans(iban);
	}

	@Override
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		CreditTransfer ct = getCreditTransfer();
		ct.setPaymentAccountID(iban);
		ct.setPaymentAccountName(accountName);
		ct.setPaymentServiceProviderID(bic);
		return ct;
	}

	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
		return null; // TODO
//		return new TradeSettlementPaymentMeans(accountId, accountName, bic);
	}

}
