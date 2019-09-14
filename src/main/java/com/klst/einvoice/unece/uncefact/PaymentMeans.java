package com.klst.einvoice.unece.uncefact;

import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.CreditTransferFactory;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.untdid.codelist.PaymentMeansEnum;

import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentMeansCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SpecifiedPeriodType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

/* wg BT-83 ist PaymentInstructions hier und nicht in TradeSettlementPaymentMeans implementiert


in ram:ApplicableHeaderTradeSettlement stecken auch
- ram:ApplicableTradeTax ==> VatBreakdown 0 .. n ApplicableTradeTax Umsatzsteueraufschlüsselung  
- ram:SpecifiedTradePaymentTerms ==> BT-9 & BT-20 : Payment terms & Payment due date
- ram:SpecifiedTradeSettlementHeaderMonetarySummation ==> BG-22.BT-106 - 1..1/1..1 in


Bsp: 01.15a:
        <ram:ApplicableHeaderTradeSettlement>
            <ram:PaymentReference>0000123456</ram:PaymentReference>                    <!-- BT-83 0..1 Verwendungszweck
            ...
            <ram:SpecifiedTradeSettlementPaymentMeans>
                <ram:TypeCode>30</ram:TypeCode>                                        <!-- BT-81
                <ram:PayeePartyCreditorFinancialAccount>                               <!-- BG-17 0..n CREDIT TRANSFER
                    <ram:IBANID>DE12123000001234567890</ram:IBANID>
                    <ram:AccountName>[Payment account name]</ram:AccountName>
                </ram:PayeePartyCreditorFinancialAccount>
                <ram:PayeeSpecifiedCreditorFinancialInstitution>
                    <ram:BICID>[BIC]</ram:BICID>
                </ram:PayeeSpecifiedCreditorFinancialInstitution>                                   bis hierhin -->
            </ram:SpecifiedTradeSettlementPaymentMeans>

SpecifiedTradeSettlementPaymentMeans Zahlungsanweisungen umbenannt in TradeSettlementPaymentMeans
Datentyp: ram:TradeSettlementPaymentMeansType

1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich
0 .. 1 PaymentReference Verwendungszweck                                        BT-83 

0 .. n SpecifiedTradeSettlementPaymentMeans Zahlungsanweisungen                 BG-16 xs:sequence   ! BG-16 Cardinality: 0..1
  1..1 TypeCode Code für die Zahlungsart                                        BT-81 
  0..1 Information Text zur Zahlungsart                                         BT-82 

  0..1 ApplicableTradeSettlementFinancialCard Informationen zur Zahlungskarte   BG-18 xs:sequence 
    1..1 ID Zahlungskartennummer                                                  BT-87 
    0..1 CardholderName Name des Zahlungskarteninhabers                           BT-88 

  0..1 PayerPartyDebtorFinancialAccount Bankinstitut des Käufers xs:sequence 
    1..1 IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos           BG-19/ BT-91 

  0..1 PayeePartyCreditorFinancialAccount Überweisung                           BG-17 xs:sequence 
    0..1 IBANID Kennung des Zahlungskontos                                        BT-84 
    0..1 AccountName Name des Zahlungskontos                                      BT-85 
    0..1 ProprietaryID Nationale Kontonummer (nicht für SEPA)                     BT-84-0 

  0..1 PayeeSpecifiedCreditorFinancialInstitution Bankinstitut des Verkäufers xs:sequence 
    1..1 BICID Kennung des Zahlungsdienstleisters                                 BT-86

 */   

public class PaymentMeans extends HeaderTradeSettlementType 
	implements PaymentInstructions, CreditTransferFactory {

	private static final Logger LOG = Logger.getLogger(PaymentMeans.class.getName());
	
	PaymentMeans() {
		super();
	}

//	PaymentInstructions pi;
	TradeSettlementPaymentMeansType tradeSettlementPaymentMeans = null; // 1st elem in SpecifiedTradeSettlementPaymentMeans List
	
	PaymentMeans(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		this();
		init(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	
	private void init(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation,
			List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		LOG.info("PaymentMeansEnum:"+code + ", paymentMeansText:"+paymentMeansText);
		if(code==null) return;
		tradeSettlementPaymentMeans = new TradeSettlementPaymentMeansType();
		super.getSpecifiedTradeSettlementPaymentMeans().add(tradeSettlementPaymentMeans);
		
		setPaymentMeans(code, paymentMeansText); // BT-81, BT-82
		setRemittanceInformation(remittanceInformation); // BT-83
		
		
	}

//	@Override // implements PaymentInstructionsFactory
//	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText) {
//		return new TradeSettlementPaymentMeans(code, paymentMeansText);
//	}
//	PaymentInstructions createPaymentInstructions(HeaderTradeSettlementType hts) {
//		List<TradeSettlementPaymentMeansType> tspmList = hts.getSpecifiedTradeSettlementPaymentMeans();
//		LOG.info("do bg16( ... hts.SpecifiedTradeSettlementPaymentMeans, aka BG-16 tspmList#:" + tspmList.size());	
//		return tspmList.isEmpty() ? null : new TradeSettlementPaymentMeans(tspmList.get(0));
//	}

	// copy ctor
	public PaymentMeans(HeaderTradeSettlementType hts) {
		this();
		List<TextType> prList = hts.getPaymentReference(); // BT-83
		String remittanceInformation = null;
		List<TradeSettlementPaymentMeansType> stspmList = hts.getSpecifiedTradeSettlementPaymentMeans();
		LOG.info("hts.SpecifiedTradeSettlementPaymentMeans List#:"+stspmList.size() + " hts.PaymentReference List#:"+prList.size());
		if(!prList.isEmpty()) {
			prList.forEach(paymentReference -> {
				LOG.info("PaymentReference/remittanceInformation:"+paymentReference.getValue());
			});
			remittanceInformation = prList.get(0).getValue();
		}
		if(stspmList.isEmpty()) {
			//
		} else {
			tradeSettlementPaymentMeans = stspmList.get(0);
			super.getSpecifiedTradeSettlementPaymentMeans().add(tradeSettlementPaymentMeans);
//			tradeSettlementPaymentMeans = new TradeSettlementPaymentMeansType();
//			init(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation,
//					List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit)
		}
		
		
		//-----------------
//		List<TradePaymentTermsType> stptList = hts.getSpecifiedTradePaymentTerms();
//		super.getSpecifiedTradePaymentTerms(); // List<TradePaymentTermsType> 0..n
//		pi = createPaymentInstructions(hts);
//		setBG16(pi);
//		
//		if(stptList.isEmpty()) {
//			//
//		} else {
//			List<TextType> descriptionList = stptList.get(0).getDescription(); // BT-20 + 0..1 Payment terms
//			LOG.info("descriptionList#:"+descriptionList.size() + " super.SpecifiedTradePaymentTerms#"+super.getSpecifiedTradePaymentTerms().size());
//			if(descriptionList.isEmpty()) { 
//				// Description is optional
//			} else {
//				TradePaymentTermsType tradePaymentTerms = new TradePaymentTermsType();
//				tradePaymentTerms.getDescription().add(CrossIndustryInvoice.newTextType(descriptionList.get(0).getValue()));
//				super.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
//			}
//			DateTimeType dueDateDateTime = stptList.get(0).getDueDateDateTime(); // BT-9 0..1 Payment due date 
//			if(dueDateDateTime==null) {
//				// Payment due date is optional
//			} else {
//				List<TradePaymentTermsType> tradePaymentTermsList = super.getSpecifiedTradePaymentTerms();
//				if(tradePaymentTermsList.isEmpty()) {
//					tradePaymentTermsList.add(new TradePaymentTermsType());
//				}
//				TradePaymentTermsType tradePaymentTerms = tradePaymentTermsList.get(0);
//				tradePaymentTerms.setDueDateDateTime(dueDateDateTime);
//			}
//		}
//		
//		List<TextType> prList = hts.getPaymentReference(); // BT-83 
//		if(!prList.isEmpty()) {
//			prList.forEach(remittanceInformation -> {
//				LOG.info("remittanceInformation:"+remittanceInformation.getValue());
//			});
//			
//		}
//
//		setRemittanceInformation(prList.isEmpty() ? null : prList.get(0).getValue());
		
		SpecifiedPeriodType specifiedPeriodType = hts.getBillingSpecifiedPeriod(); // wg. BG14_InvoicingPeriod
		if(specifiedPeriodType!=null) super.setBillingSpecifiedPeriod(specifiedPeriodType);
	}

//	public PaymentMeans(PaymentMeansEnum pmc, String paymentMeansText, String remittanceInformation) {
//		this();
//		super.getSpecifiedTradePaymentTerms(); // List<TradePaymentTermsType> 0..n
//		pi = createPaymentInstructions(pmc, paymentMeansText);
//		setBG16(pi);
//		setRemittanceInformation(remittanceInformation);
//	}
//	
//	void setBG16(PaymentInstructions paymentInstructions) { // TODOrename to setPaymentInstructions
//// EN16931 sagt: BG-16 0..1 PAYMENT INSTRUCTIONS
//// CII:
//// 0 .. n SpecifiedTradeSettlementPaymentMeans Zahlungsanweisungen BG-16
//		if(paymentInstructions==null) return;
//		LOG.info("vor add SpecifiedTradeSettlementPaymentMeans.size="+super.getSpecifiedTradeSettlementPaymentMeans().size());
//		super.getSpecifiedTradeSettlementPaymentMeans().add((TradeSettlementPaymentMeans)paymentInstructions);
//	}

	// 1..1 TypeCode Code für die Zahlungsart                                        BT-81
	@Override
	public void setPaymentMeansEnum(PaymentMeansEnum code) { // use addPaymentMeansCT
		setPaymentMeans(code, null);
	}

	@Override
	public PaymentMeansEnum getPaymentMeansEnum() {
		if(tradeSettlementPaymentMeans==null) return null;
		PaymentMeansCodeType pmc = tradeSettlementPaymentMeans.getTypeCode();
		return PaymentMeansEnum.valueOf(pmc);
	}

	// BT-81, BT-82
	@Override
	public void setPaymentMeans(PaymentMeansEnum code, String text) { // code+text
		PaymentMeansCodeType pmc = new PaymentMeansCodeType(); // BT-81
		pmc.setValue(code.getValueAsString());	
		tradeSettlementPaymentMeans.setTypeCode(pmc);
		
		if(text!=null) { // BT-82 
			tradeSettlementPaymentMeans.getInformation().add(CrossIndustryInvoice.newTextType(text));
		}
	}
	
	// 0..1 Information Text zur Zahlungsart                                         BT-82
	@Deprecated
	void setPaymentMeansText(String text) { // use setPaymentMeans(PaymentMeansCode code, String text)
	}

	@Override
	public String getPaymentMeansText() {
		if(tradeSettlementPaymentMeans==null) return null;
		return tradeSettlementPaymentMeans.getInformation().isEmpty() ? null : tradeSettlementPaymentMeans.getInformation().get(0).getValue();
	}

	// 0 .. 1 PaymentReference Verwendungszweck                                        BT-83
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

//	public CreditTransfer getCreditTransfer() {
//		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
//			LOG.warning("SpecifiedTradeSettlementPaymentMeans is empty");
//			return null;
//		}
//		LOG.info("SpecifiedTradeSettlementPaymentMeans is "+super.getSpecifiedTradeSettlementPaymentMeans().get(0).getClass());
//		TradeSettlementPaymentMeans tspm = (TradeSettlementPaymentMeans)super.getSpecifiedTradeSettlementPaymentMeans().get(0);
//		LOG.info("TradeSettlementPaymentMeans implementiert CreditTransfer >>>>>> 1..1 >>>>>>> PaymentAccount:" 
//				+ tspm.getPaymentAccountID());
//		return tspm;
//	}
//	
//	public CreditTransfer createCreditTransfer(IBANId iban) { // eigentlich ist es setXXXXX
//		LOG.info("class ßßßßßß:"+super.getSpecifiedTradeSettlementPaymentMeans().get(0).getClass());
//		TradeSettlementPaymentMeans tspm = (TradeSettlementPaymentMeans)super.getSpecifiedTradeSettlementPaymentMeans().get(0);
////		tspm.setPaymentAccountID(iban);
//		LOG.info(">>>>>>>>>>>>>>>>> PaymentAccountI:"+tspm.getPaymentAccountID());
//		return tspm; // TODO
////		return new TradeSettlementPaymentMeans(iban);
//	}

	// BG-17 ++ 0..n CREDIT TRANSFER
	@Override
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		return new FinancialAccount(iban, accountName, bic);
	}

	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
		return new FinancialAccount(accountId, accountName, bic);
	}

	@Override
	public void addCreditTransfer(CreditTransfer creditTransfer) {
		// FinancialAccount implements CreditTransfer
		// in FinancialAccount payeePartyCreditorFinancialAccount
		FinancialAccount financialAccount = (FinancialAccount)creditTransfer;
		tradeSettlementPaymentMeans.setPayeePartyCreditorFinancialAccount(financialAccount.payeePartyCreditorFinancialAccount);
		tradeSettlementPaymentMeans.setPayeeSpecifiedCreditorFinancialInstitution(financialAccount.payeeSpecifiedCreditorFinancialInstitution);
	}

	@Override
	public List<CreditTransfer> getCreditTransfer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDirectDebit(DirectDebit directDebit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DirectDebit getDirectDebit() {
		// TODO Auto-generated method stub
		return null;
	}

}
