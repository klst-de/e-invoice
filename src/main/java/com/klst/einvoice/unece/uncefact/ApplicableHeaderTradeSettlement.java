package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.CreditTransferFactory;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.DirectDebitFactory;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.PaymentMeansEnum;

import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentMeansCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SpecifiedPeriodType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeTransactionType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementHeaderMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

// kapselt          HeaderTradeSettlementType
/* 
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
 

in ram:ApplicableHeaderTradeSettlement stecken auch BT-5, BT-6
- ram:PayeeTradeParty                                 ==>
- ram:ApplicableTradeTax                              ==> VatBreakdown 0 .. n ApplicableTradeTax Umsatzsteueraufschlüsselung  
- ram:BillingSpecifiedPeriod                          ==> BG-14 ++ 0..1 INVOICING PERIOD
- ram:SpecifiedTradePaymentTerms                      ==> BT-9 & BT-20 : Payment terms & Payment due date
- ram:SpecifiedTradeSettlementHeaderMonetarySummation ==> BG-22.BT-106 - 1..1/1..1 in

 * 
   01.02a-INVOICE_uncefact.xml :                                mit PayeeTradeParty
        <ram:ApplicableHeaderTradeSettlement>
            <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>               <!-- BT-6 + 0..1 VAT accounting currency code
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>       <!-- 1 .. 1 InvoiceCurrencyCode Code für die Rechnungswährung BT-5
            <ram:PayeeTradeParty>
                <ram:Name>VSB - Verlagsservice Braunschweig GmbH</ram:Name>
            </ram:PayeeTradeParty>
            
   01.14a-INVOICE_uncefact.xml :
           <ram:ApplicableHeaderTradeSettlement>
            <ram:PaymentReference>Deb. 12345 / Fact. 9876543</ram:PaymentReference>
            <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
            <ram:PayeeTradeParty>
                <ram:ID>74</ram:ID>
                <ram:Name>[Payee name]</ram:Name>
            </ram:PayeeTradeParty>

   01.15a-INVOICE_uncefact.xml :                                ohne PayeeTradeParty
        <ram:ApplicableHeaderTradeSettlement>
            <ram:PaymentReference>0000123456</ram:PaymentReference>
            <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
            <ram:SpecifiedTradeSettlementPaymentMeans>
                <ram:TypeCode>30</ram:TypeCode>
                <ram:PayeePartyCreditorFinancialAccount>
                    <ram:IBANID>DE12123000001234567890</ram:IBANID>
                    <ram:AccountName>[Payment account name]</ram:AccountName>
                </ram:PayeePartyCreditorFinancialAccount>
                <ram:PayeeSpecifiedCreditorFinancialInstitution>
                    <ram:BICID>[BIC]</ram:BICID>
                </ram:PayeeSpecifiedCreditorFinancialInstitution>
            </ram:SpecifiedTradeSettlementPaymentMeans>
            <ram:ApplicableTradeTax>
                <ram:CalculatedAmount>1706.2</ram:CalculatedAmount>
                <ram:TypeCode>VAT</ram:TypeCode>
                <ram:BasisAmount>8980</ram:BasisAmount>
                <ram:CategoryCode>S</ram:CategoryCode>
                <ram:RateApplicablePercent>19</ram:RateApplicablePercent>
            </ram:ApplicableTradeTax>
            <ram:SpecifiedTradePaymentTerms>                             <!-- 0 .. n SpecifiedTradePaymentTerms Detailinformationen zu Zahlungsbedingungen
                <ram:Description>Bei Zahlungen binnen 14 Tagen, 2% Skonto</ram:Description>
                <ram:DueDateDateTime>
                    <udt:DateTimeString format="102">20180110</udt:DateTimeString>
                </ram:DueDateDateTime>
            </ram:SpecifiedTradePaymentTerms>
            <ram:SpecifiedTradeSettlementHeaderMonetarySummation>        <!-- 1 .. 1 Gesamtsummen auf Dokumentenebene BG-22
                <ram:LineTotalAmount>8980</ram:LineTotalAmount>
                <ram:TaxBasisTotalAmount>8980</ram:TaxBasisTotalAmount>
                <ram:TaxTotalAmount currencyID="EUR">1706.2</ram:TaxTotalAmount>
                <ram:GrandTotalAmount>10686.2</ram:GrandTotalAmount>
                <ram:DuePayableAmount>10686.2</ram:DuePayableAmount>
            </ram:SpecifiedTradeSettlementHeaderMonetarySummation>
        </ram:ApplicableHeaderTradeSettlement>

 */
public class ApplicableHeaderTradeSettlement implements PaymentInstructions, CreditTransferFactory, DirectDebitFactory {

	private static final Logger LOG = Logger.getLogger(ApplicableHeaderTradeSettlement.class.getName());
	
	HeaderTradeSettlementType applicableHeaderTradeSettlement = null;
	TradeSettlementHeaderMonetarySummationType tradeSettlementHeaderMonetarySummation = null;
	TradeSettlementPaymentMeansType tradeSettlementPaymentMeans = null; // 1st elem in SpecifiedTradeSettlementPaymentMeans List
	SpecifiedPeriodType billingSpecifiedPeriod = null; // BG-14 ++ 0..1 INVOICING PERIOD
	
	static ApplicableHeaderTradeSettlement getApplicableHeaderTradeSettlement(SupplyChainTradeTransactionType supplyChainTradeTransaction) {
		if(supplyChainTradeTransaction==null) return null;
		return new ApplicableHeaderTradeSettlement(supplyChainTradeTransaction);
	}
	
	ApplicableHeaderTradeSettlement(SupplyChainTradeTransactionType supplyChainTradeTransaction) {
		// 1 .. 1 ApplicableHeaderTradeSettlement : darf nicht null sein
		applicableHeaderTradeSettlement = supplyChainTradeTransaction.getApplicableHeaderTradeSettlement();
		// 1 .. 1 SpecifiedTradeSettlementHeaderMonetarySummation Gesamtsummen auf Dokumentenebene BG-22 : ebenfalls nicht null
		tradeSettlementHeaderMonetarySummation = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementHeaderMonetarySummation();
		if(applicableHeaderTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			// no PaymentInstructions
		} else {
			tradeSettlementPaymentMeans = applicableHeaderTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().get(0);
		}
	}
	
	// ctor
	ApplicableHeaderTradeSettlement() {
		applicableHeaderTradeSettlement = new HeaderTradeSettlementType();
		tradeSettlementHeaderMonetarySummation = new TradeSettlementHeaderMonetarySummationType();
		applicableHeaderTradeSettlement.setSpecifiedTradeSettlementHeaderMonetarySummation(tradeSettlementHeaderMonetarySummation);
	}
	
	ApplicableHeaderTradeSettlement(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		this();
		init(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}

	private void init(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation,
			List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
//		LOG.info("PaymentMeansEnum:"+code + ", paymentMeansText:"+paymentMeansText);
		if(code==null) return;
		getTradeSettlementPaymentMeans(); // create if neccessary
		
		setPaymentMeans(code, paymentMeansText); // BT-81, BT-82
		setRemittanceInformation(remittanceInformation); // BT-83
		creditTransfer.forEach(ct -> {
			addCreditTransfer(ct);
		});
	}
	
	private TradeSettlementPaymentMeansType getTradeSettlementPaymentMeans() {
		if(tradeSettlementPaymentMeans==null) {
			tradeSettlementPaymentMeans = new TradeSettlementPaymentMeansType();
			applicableHeaderTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().add(tradeSettlementPaymentMeans);	
		}
		return tradeSettlementPaymentMeans;
	}

	// liefert das gekapselte Objekt
	HeaderTradeSettlementType get() {
		return applicableHeaderTradeSettlement;
	}
	
	// BT-5 + 1..1 Invoice currency code
	void setDocumentCurrency(String isoCurrencyCode) {
		CurrencyCodeType currencyCode = new CurrencyCodeType();
		currencyCode.setValue(isoCurrencyCode);
		applicableHeaderTradeSettlement.setInvoiceCurrencyCode(currencyCode);		
	}
	String getDocumentCurrency() {
		return applicableHeaderTradeSettlement.getInvoiceCurrencyCode().getValue();
	}
	
	// BT-6 + 0..1 VAT accounting currency code
	void setTaxCurrency(String isoCurrencyCode) {
		if(isoCurrencyCode==null) return;  // optional
		CurrencyCodeType currencyCode = new CurrencyCodeType();
		currencyCode.setValue(isoCurrencyCode);
		applicableHeaderTradeSettlement.setTaxCurrencyCode(currencyCode);
	}
	public String getTaxCurrency() {
		CurrencyCodeType currencyCode = applicableHeaderTradeSettlement.getTaxCurrencyCode();
		return currencyCode==null ? null : currencyCode.getValue();
	}
	
	// BT-7 + 0..1 Value added tax point date
	void setTaxPointDate(Timestamp ts) {
		if(ts==null) return;  // optional
		TradeTaxType tradeTax = new TradeTaxType();
		tradeTax.setTaxPointDate(newDateType(ts));
		applicableHeaderTradeSettlement.getApplicableTradeTax().add(tradeTax);
	}
	
	DateType newDateType(Timestamp ts) {
		if(ts==null) return null;
		
		DateType dateTime = new DateType();
		DateType.DateString dts = new DateType.DateString(); // DateString ist inner class in DateType
		dts.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		dts.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		dateTime.setDateString(dts);
		return dateTime;
	}

// ---------------- implements PaymentInstructions:
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
		getTradeSettlementPaymentMeans().setTypeCode(pmc);
		
		if(text!=null) { // BT-82 
			tradeSettlementPaymentMeans.getInformation().add(CrossIndustryInvoice.newTextType(text));
		}
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
		applicableHeaderTradeSettlement.getPaymentReference().add(CrossIndustryInvoice.newTextType(text));
	}

	@Override
	public String getRemittanceInformation() {
		List<TextType> list = applicableHeaderTradeSettlement.getPaymentReference();
		return list.isEmpty() ? null : list.get(0).getValue();
	}

	// BG-17 ++ 0..n CREDIT TRANSFER
	@Override
	public void addCreditTransfer(CreditTransfer creditTransfer) {
		// FinancialAccount implements CreditTransfer
		// in FinancialAccount payeePartyCreditorFinancialAccount
		FinancialAccount financialAccount = (FinancialAccount)creditTransfer;
		tradeSettlementPaymentMeans.setPayeePartyCreditorFinancialAccount(financialAccount.payeePartyCreditorFinancialAccount);
		tradeSettlementPaymentMeans.setPayeeSpecifiedCreditorFinancialInstitution(financialAccount.payeeSpecifiedCreditorFinancialInstitution);
	}

	FinancialAccount financialAccount = null;
	FinancialAccount getFinancialAccount() {
		if(financialAccount==null) {
			financialAccount = new FinancialAccount(tradeSettlementPaymentMeans);
		}
		return financialAccount;
	}
	
	// BG-17 Kardinalität ist 0..n, aber in CII kann es nur 0..1 sein
	@Override
	public List<CreditTransfer> getCreditTransfer() {
		List<CreditTransfer> ret = new ArrayList<CreditTransfer>();
		CreditTransfer ct = getFinancialAccount(); //new FinancialAccount(tradeSettlementPaymentMeans);
		if(ct.getPaymentAccountID()==null) {
			return ret; // empty List
		}
		ret.add(ct);
		return ret;
	}

	// BG-19 ++ 0..1 DIRECT DEBIT
	@Override
	public void setDirectDebit(DirectDebit directDebit) {
		// FinancialAccount implements DirectDebit
		// in FinancialAccount payerPartyDebtorFinancialAccount
		FinancialAccount financialAccount = (FinancialAccount)directDebit;
		tradeSettlementPaymentMeans.setPayerPartyDebtorFinancialAccount(financialAccount.payerPartyDebtorFinancialAccount);
	}

	@Override
	public DirectDebit getDirectDebit() {
		return getFinancialAccount();
	}

// ---------------- implements CreditTransferFactory:
	@Override
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		if(financialAccount==null) {
			financialAccount = new FinancialAccount(iban, accountName, bic); //new FinancialAccount(tradeSettlementPaymentMeans);
		}
		return financialAccount;
	}

	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
		if(financialAccount==null) {
			financialAccount = new FinancialAccount(accountId, accountName, bic); //new FinancialAccount(tradeSettlementPaymentMeans);
		}
		return financialAccount;
	}
	
// ---------------- implements DirectDebitFactory:
	@Override
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, IBANId iban) {
		if(financialAccount==null) {
			financialAccount = new FinancialAccount(iban);
		}
		return financialAccount;
	}

	@Override
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, String debitedAccountID) {
		// TODO Auto-generated method stub
		return null;
	}

// ----------------
	// 1 .. 1 SpecifiedTradeSettlementHeaderMonetarySummation Gesamtsummen auf Dokumentenebene BG-22
	void setDocumentTotals(Amount lineExtension, Amount taxExclusive, Amount taxInclusive, Amount payable) {
		LOG.info("lineExtension:"+lineExtension + " taxExclusive:"+taxExclusive + " taxInclusive:"+taxInclusive + " payable:"+payable);
		AmountType lineTotalAmt = new AmountType();
		lineExtension.copyTo(lineTotalAmt);
		tradeSettlementHeaderMonetarySummation.getLineTotalAmount().add(lineTotalAmt); // add to list
		
		AmountType taxBasisTotalAmt = new AmountType();
		taxExclusive.copyTo(taxBasisTotalAmt);
		tradeSettlementHeaderMonetarySummation.getTaxBasisTotalAmount().add(taxBasisTotalAmt); // add to list
		
		AmountType taxTotalAmt = new AmountType();
		taxInclusive.copyTo(taxTotalAmt);

		taxTotalAmt.setCurrencyID(taxInclusive.getCurrencyID()); // wg. validation 
		tradeSettlementHeaderMonetarySummation.getGrandTotalAmount().add(taxTotalAmt); // add to list
		
		AmountType payableAmt = new AmountType();
		payable.copyTo(payableAmt);
		tradeSettlementHeaderMonetarySummation.getDuePayableAmount().add(payableAmt); // add to list
	}
	void setInvoiceTax(Amount taxTotalAmount) {
		AmountType taxTotalAmt = new AmountType();
		taxTotalAmount.copyTo(taxTotalAmt);
		tradeSettlementHeaderMonetarySummation.getTaxTotalAmount().add(taxTotalAmt); // add to list
	}
	
	TradeSettlementHeaderMonetarySummationType getTradeSettlementHeaderMonetarySummation() {
		return tradeSettlementHeaderMonetarySummation;
	}

	TradeParty getPayeeTradeParty() {
		TradePartyType party = applicableHeaderTradeSettlement.getPayeeTradeParty();
		return party==null ? null : new TradeParty(party);
	}
	
	List<TradeTaxType> getApplicableTradeTax() {
		return applicableHeaderTradeSettlement.getApplicableTradeTax();
	}
	
	// BG-14 ++ 0..1 INVOICING PERIOD
	SpecifiedPeriodType getBillingSpecifiedPeriod() {
		if(billingSpecifiedPeriod==null) {
			billingSpecifiedPeriod = applicableHeaderTradeSettlement.getBillingSpecifiedPeriod();
			if(billingSpecifiedPeriod==null) {
				billingSpecifiedPeriod = new SpecifiedPeriodType();
				applicableHeaderTradeSettlement.setBillingSpecifiedPeriod(billingSpecifiedPeriod);
			}
		}
		return billingSpecifiedPeriod;
	}

	void addPaymentTerms(TradePaymentTermsType tradePaymentTerms) {
		applicableHeaderTradeSettlement.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
	}

}
