package com.klst.einvoice.unece.uncefact;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.PaymentInstructions;
import com.klst.untdid.codelist.PaymentMeansCode;

import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentMeansCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class ApplicableHeaderTradeSettlement extends HeaderTradeSettlementType implements PaymentInstructions {

	private static final Logger LOG = Logger.getLogger(ApplicableHeaderTradeSettlement.class.getName());
	
	ApplicableHeaderTradeSettlement() {
		super();
	}

	// copy ctor
	public ApplicableHeaderTradeSettlement(HeaderTradeSettlementType hts) {
		this();
		LOG.info("TODO init( ... hts.SpecifiedTradeSettlementPaymentMeans#:" + hts.getSpecifiedTradeSettlementPaymentMeans().size());
		super.getSpecifiedTradePaymentTerms(); // List<TradePaymentTermsType> 0..n
		List<TradeSettlementPaymentMeansType> tspmList = hts.getSpecifiedTradeSettlementPaymentMeans();
		List<TextType> list = null; 
		if(tspmList.isEmpty()) {
			list = new ArrayList<TextType>();
		} else {
			list = tspmList.get(0).getInformation();  // text des ersten tspmList elements!!!!
		}
		
		List<TextType> prList = super.getPaymentReference();

		bg16( tspmList.isEmpty() ? null : PaymentMeansCode.valueOf(tspmList.get(0).getTypeCode())
			, list.isEmpty() ? null : list.get(0).getValue()
			, prList.isEmpty() ? null : prList.get(0).getValue()
			);
	}

	public ApplicableHeaderTradeSettlement(PaymentMeansCode code, String paymentMeansText, String remittanceInformation) {
		this();
		super.getSpecifiedTradePaymentTerms(); // List<TradePaymentTermsType> 0..n
		bg16(code, paymentMeansText, remittanceInformation);
	}
	
	void bg16(PaymentMeansCode code, String paymentMeansText, String remittanceInformation) {
		addPaymentMeansCT(code, paymentMeansText);
		setRemittanceInformation(remittanceInformation);
	}

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
0 .. 1 IBANID Kennung des Zahlungskontos                                      BT-84 
0 .. 1 AccountName Name des Zahlungskontos                                    BT-85 
0 .. 1 ProprietaryID Nationale Kontonummer (nicht für SEPA)                   BT-84-0 
0 .. 1 PayeeSpecifiedCreditorFinancialInstitution Bankinstitut des Verkäufers xs:sequence 
1 .. 1 BICID Kennung des Zahlungsdienstleisters                               BT-86

0 .. 1 SupplyChainTradeTransaction Gruppierung der Informationen zum Geschäftsvorfall
1 .. 1 ApplicableHeaderTradeSettlement Gruppierung von Angaben zur Zahlung und Rechnungsausgleich xs:sequence 
0 .. 1 CreditorReferenceID Kennung des Gläubigers                             BG-19/ BT-90 
0 .. 1 PaymentReference Verwendungszweck                                      BT-83

	 */
	public void addPaymentMeansCT(PaymentMeansCode code, String text) { // code+text
		
		TradeSettlementPaymentMeansType tspm = new TradeSettlementPaymentMeansType();
		PaymentMeansCodeType pmc = new PaymentMeansCodeType(); // BT-81
		pmc.setValue(code.getValueAsString());
		tspm.setTypeCode(pmc);

		if(text!=null) {
			tspm.getInformation().add(CrossIndustryInvoice.newTextType(text));
		}

		super.getSpecifiedTradeSettlementPaymentMeans().add(tspm);
	}
	@Override
	public void setPaymentMeansCode(PaymentMeansCode code) { // use addPaymentMeansCT
//		PaymentMeansCodeType pmc = new PaymentMeansCodeType(); // BT-81
//		pmc.setValue(code.getValueAsString());
//		super.setTypeCode(pmc);
		addPaymentMeansCT(code, null);
	}

	@Override
	public PaymentMeansCode getPaymentMeansCode() {
//		PaymentMeansCodeType paymentMeansCode = super.getTypeCode();
//		return PaymentMeansCode.valueOf(paymentMeansCode);
		List<TradeSettlementPaymentMeansType> tspmList = super.getSpecifiedTradeSettlementPaymentMeans();
		return tspmList.isEmpty() ? null : PaymentMeansCode.valueOf(tspmList.get(0).getTypeCode()); // Code des ersten tspmList elements!!!!
	}

	@Override
	public void setPaymentMeansText(String text) { // use addPaymentMeansCT
		// TODO Auto-generated method stub		
	}

	@Override
	public String getPaymentMeansText() {
//		List<TextType> list = super.getInformation();
//		return list.isEmpty() ? null : list.get(0).getValue();
		List<TradeSettlementPaymentMeansType> tspmList = super.getSpecifiedTradeSettlementPaymentMeans();
		if(tspmList.isEmpty()) return null;
		List<TextType> list = tspmList.get(0).getInformation();  // text des ersten tspmList elements!!!!
		return list.isEmpty() ? null : list.get(0).getValue();
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


}
