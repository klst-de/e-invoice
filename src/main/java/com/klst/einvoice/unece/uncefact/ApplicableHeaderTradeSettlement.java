package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.CreditTransferFactory;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.DirectDebitFactory;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.PaymentInstructionsFactory;
import com.klst.untdid.codelist.PaymentMeansEnum;

import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SpecifiedPeriodType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAllowanceChargeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementHeaderMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

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

   01.15a-INVOICE_uncefact.xml :                                ohne PayeeTradeParty, CreditTransfer
        <ram:ApplicableHeaderTradeSettlement>
            <ram:PaymentReference>0000123456</ram:PaymentReference>
            <ram:TaxCurrencyCode>EUR</ram:TaxCurrencyCode>
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
            <ram:SpecifiedTradeSettlementPaymentMeans>
                <ram:TypeCode>30</ram:TypeCode>             -- CreditTransfer 		(30)
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

   03.02a-INVOICE_uncefact.xml :                                BankCard
            <ram:SpecifiedTradeSettlementPaymentMeans>
                <ram:TypeCode>48</ram:TypeCode>
                <ram:ApplicableTradeSettlementFinancialCard>
                    <ram:ID>41234</ram:ID>
                    <ram:CardholderName>[Payment card holder name]</ram:CardholderName>
                </ram:ApplicableTradeSettlementFinancialCard>
            </ram:SpecifiedTradeSettlementPaymentMeans>

   03.01a-INVOICE_uncefact.xml :                                SEPADirectDebit
        <ram:ApplicableHeaderTradeSettlement>
            <ram:CreditorReferenceID>[Bank assigned creditor identifier]</ram:CreditorReferenceID>
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
            <ram:SpecifiedTradeSettlementPaymentMeans>
                <ram:TypeCode>59</ram:TypeCode>                 -- SEPADirectDebit 	(59)
                <ram:PayerPartyDebtorFinancialAccount>
                    <!-- dies ist eine nicht existerende aber valide IBAN als test dummy -->
                    <ram:IBANID>DE75512108001245126199</ram:IBANID>
                </ram:PayerPartyDebtorFinancialAccount>
            </ram:SpecifiedTradeSettlementPaymentMeans>

 */
public class ApplicableHeaderTradeSettlement extends HeaderTradeSettlementType 
	implements PaymentInstructions, PaymentInstructionsFactory, CreditTransferFactory
		, DirectDebit, DirectDebitFactory {

	// implements PaymentInstructionsFactory
	@Override
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		return create(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	static ApplicableHeaderTradeSettlement create(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		return new ApplicableHeaderTradeSettlement(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	
	private static final Logger LOG = Logger.getLogger(ApplicableHeaderTradeSettlement.class.getName());
	
	static ApplicableHeaderTradeSettlement create() {
		return new ApplicableHeaderTradeSettlement(null);
	}
	// copy ctor:
	static ApplicableHeaderTradeSettlement create(HeaderTradeSettlementType object) {
		if(object instanceof HeaderTradeSettlementType && object.getClass()!=HeaderTradeSettlementType.class) {
			// object is instance of a subclass of HeaderTradeSettlementType, but not HeaderTradeSettlementType itself
			return (ApplicableHeaderTradeSettlement)object;
		} else {
			return new ApplicableHeaderTradeSettlement(object); 
		}
	}
	
	SpecifiedPeriodType billingSpecifiedPeriod = null; // BG-14 ++ 0..1 INVOICING PERIOD
	
	// das erste element der Liste specifiedTradePaymentTerms aus super, die anderen werden nicht genutzt
	TradePaymentTerms tradePaymentTerms = null;
	// das erste element der Liste applicableTradeTax aus super, die anderen werden nicht genutzt
	TradeTax tradeTax = null;

	// copy ctor
	private ApplicableHeaderTradeSettlement(HeaderTradeSettlementType doc) {
		super();
		if(doc!=null) {
			SCopyCtor.getInstance().invokeCopy(this, doc);
			
			TradePaymentTermsType tpt = doc.getSpecifiedTradePaymentTerms().isEmpty() ? null : doc.getSpecifiedTradePaymentTerms().get(0);
			tradePaymentTerms = TradePaymentTerms.create(tpt);
			
			TradeTaxType tt = doc.getApplicableTradeTax().isEmpty() ? null : doc.getApplicableTradeTax().get(0);
			tradeTax = TradeTax.create(tt); 
			
			LOG.fine("copy ctor:"+this); // TODO toString	
		}

	}
	
	TradePaymentTerms getTradePaymentTerms() {
		return tradePaymentTerms;
	}

/*
in super gibt es 0..n <ram:SpecifiedTradeSettlementPaymentMeans> - Objekte
 */
	private ApplicableHeaderTradeSettlement(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		super();
		init(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	void init(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		setPaymentMeans(code, paymentMeansText); // BT-81, BT-82 - ein pm ohne BG-17 wird erstellt
		setRemittanceInformation(remittanceInformation); // BT-83
		 // BG-17 :
		if(creditTransfer!=null && creditTransfer.size()>0) {
			if(creditTransfer.size()>0) {
				TradeSettlementPaymentMeans pm = TradeSettlementPaymentMeans.create((TradeSettlementPaymentMeansType)creditTransfer.get(0));
				getSpecifiedTradeSettlementPaymentMeans().get(0).setPayeePartyCreditorFinancialAccount(pm.getPayeePartyCreditorFinancialAccount());
				//                          accountName ist auch in PayeePartyCreditorFinancialAccount
				getSpecifiedTradeSettlementPaymentMeans().get(0).setPayeeSpecifiedCreditorFinancialInstitution(pm.getPayeeSpecifiedCreditorFinancialInstitution());
			}
			for(int i=1; i<creditTransfer.size(); i++) {
				TradeSettlementPaymentMeans pm = TradeSettlementPaymentMeans.create((TradeSettlementPaymentMeansType)creditTransfer.get(i));
				getSpecifiedTradeSettlementPaymentMeans().add(pm);
			}
		} else {
			setPaymentCard(paymentCard); // BG-18
			setDirectDebit((DirectDebit)directDebit); // BG-19
		}
		if(getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("no PaymentMeans");
		} else {
			LOG.info(this.getSpecifiedTradeSettlementPaymentMeans().get(0).toString());
		}
	}

	// BT-5 + 1..1 Invoice currency code
	void setDocumentCurrency(String isoCurrencyCode) {
		CurrencyCodeType currencyCode = new CurrencyCodeType();
		currencyCode.setValue(isoCurrencyCode);
		super.setInvoiceCurrencyCode(currencyCode);		
	}
	String getDocumentCurrency() {
		if(super.getInvoiceCurrencyCode()==null) {
			LOG.warning("BT-5 + 1..1 Invoice currency code is null");
			return null;
		}
		return super.getInvoiceCurrencyCode().getValue();
	}
	
	// BT-6 + 0..1 VAT accounting currency code
	void setTaxCurrency(String isoCurrencyCode) {
		if(isoCurrencyCode==null) return;  // optional
		CurrencyCodeType currencyCode = new CurrencyCodeType();
		currencyCode.setValue(isoCurrencyCode);
		super.setTaxCurrencyCode(currencyCode);
	}
	public String getTaxCurrency() {
		CurrencyCodeType currencyCode = super.getTaxCurrencyCode();
		return currencyCode==null ? null : currencyCode.getValue();
	}
	
	private void checkTradeTax() {
		if(tradeTax==null) {
			tradeTax = TradeTax.create(); 
		super.getApplicableTradeTax().add(tradeTax);
		}
	}

	// BT-7 + 0..1 Value added tax point date : ist in jedem VATBreakDowns
	void setTaxPointDate(Timestamp ts) {
		checkTradeTax();
		tradeTax.setTaxPointDate(ts);
	}
	Timestamp getTaxPointDateAsTimestamp() {
		return tradeTax==null ? null : tradeTax.getTaxPointDateAsTimestamp();
	}
	
	// BT-8 + 0..1 Value added tax point date code
	void setTaxPointDateCode(String code) {
		checkTradeTax();
		tradeTax.setTaxPointDateCode(code);
	}
	String getTaxPointDateCode() {
		return tradeTax==null ? null : tradeTax.getTaxPointDateCode();
	}
	
// ---------------- implements PaymentInstructions:
	// 1..1 TypeCode Code für die Zahlungsart                                        BT-81
	@Override
	public void setPaymentMeansEnum(PaymentMeansEnum code) { // use addPaymentMeansCT
		LOG.info("PaymentMeansEnum="+code +" // use addPaymentMeansCT");
		setPaymentMeans(code, null);
	}

	// liefert das TypeCode des ersten pm oder null!
	@Override
	public PaymentMeansEnum getPaymentMeansEnum() {
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			return null;
		}
		TradeSettlementPaymentMeans pm = TradeSettlementPaymentMeans.create(getSpecifiedTradeSettlementPaymentMeans().get(0));
		return pm.getPaymentMeansEnum();
	}

	// BT-81, BT-82
	@Override
	public void setPaymentMeans(PaymentMeansEnum code, String text) { // code+text
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.info("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty() - create it:");
		}
		addPaymentMeans(code, text);
	}
	private TradeSettlementPaymentMeans addPaymentMeans(PaymentMeansEnum code, String text) { // code+text
		TradeSettlementPaymentMeans pm = new TradeSettlementPaymentMeans(code, text); // BT-81 , BT-82
		getSpecifiedTradeSettlementPaymentMeans().add(pm);
		LOG.info("added pm"+pm);
		return pm;
	}
	
	@Override
	public String getPaymentMeansText() {
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			return null;
		}
		return getPaymentMeansText(getSpecifiedTradeSettlementPaymentMeans().get(0));
	}
	private static String getPaymentMeansText(TradeSettlementPaymentMeansType tradeSettlementPaymentMeans) {
		if(tradeSettlementPaymentMeans==null) return null;
		return tradeSettlementPaymentMeans.getInformation().isEmpty() ? null : tradeSettlementPaymentMeans.getInformation().get(0).getValue();
	}
	

	// 0 .. 1 PaymentReference Verwendungszweck                                        BT-83
	@Override
	public void setRemittanceInformation(String text) { 
		if(text==null) return;
		super.getPaymentReference().add(Text.create(text));
	}

	@Override
	public String getRemittanceInformation() {
		return getRemittanceInformation(this);
	}
	private static String getRemittanceInformation(HeaderTradeSettlementType headerTradeSettlement) {
		List<TextType> list = headerTradeSettlement.getPaymentReference();
		return list.isEmpty() ? null : list.get(0).getValue();
	}

// ---------------- implements CreditTransferFactory:
	// BG-17 ++ 0..n CREDIT TRANSFER
	@Override
	public void addCreditTransfer(CreditTransfer creditTransfer) {
		TradeSettlementPaymentMeans financialAccount = (TradeSettlementPaymentMeans)creditTransfer;
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			return;
		}
		getSpecifiedTradeSettlementPaymentMeans().add(financialAccount);
	}

	// BG-17 Kardinalität ist 0..n, aber in CII kann es nur 0..1 sein,
	// daher wird CreditTransfer von ApplicableHeaderTradeSettlement implementiert 
	// in 01.08a gibt es mehrere BG-17
	@Override
	public List<CreditTransfer> getCreditTransfer() {
		return getCreditTransfer(this);
	}
	private static List<CreditTransfer> getCreditTransfer(HeaderTradeSettlementType haderTradeSettlement) {
		List<CreditTransfer> ret = new ArrayList<CreditTransfer>();

		if(haderTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			return ret;	// leere Liste zurück
		}

		// FinancialAccount implements CreditTransfer, DirectDebit
		haderTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().forEach(pm -> {
			PaymentMeansEnum code = PaymentMeansEnum.valueOf(pm.getTypeCode());
			switch(code) {
			case CreditTransfer:
			case SEPACreditTransfer:
				// TODO factory für CreditTransfer:
				TradeSettlementPaymentMeans financialAccount = TradeSettlementPaymentMeans.create(pm);
				ret.add(financialAccount);
			break;
			default:
				LOG.info(".............");
			break;
			}
		});
		return ret;
	}

	@Override
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
		return TradeSettlementPaymentMeans.create(iban, accountName, bic);
	}

	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
		return TradeSettlementPaymentMeans.create(accountId, accountName, bic);
	}
	
	// der Unterschied zwischen createXXX und addXXX:
	// bei add wird das ct-Objekt in PM eingetragen,
	// bei create nicht
	
	@Override
	public CreditTransfer addCreditTransfer(IBANId iban, String accountName, BICId bic) {
		CreditTransfer ct = TradeSettlementPaymentMeans.create(iban, accountName, bic);
		addCreditTransfer(ct);
		return ct;
	}

	@Override
	public CreditTransfer addCreditTransfer(String accountId, String accountName, BICId bic) {
		CreditTransfer ct =  TradeSettlementPaymentMeans.create(accountId, accountName, bic);
		addCreditTransfer(ct);
		return ct;
	}
	
// ---------------- implements BG-18 (optional) PAYMENT CARD INFORMATION
		@Override
		public PaymentCard getPaymentCard() {
			if(PaymentMeansEnum.isBankCard(getPaymentMeansEnum())) {
				TradeSettlementPaymentMeans pm = TradeSettlementPaymentMeans.create(getSpecifiedTradeSettlementPaymentMeans().get(0));
				return (PaymentCard)(pm.getPaymentCard());
			};
			return null;
		}
		
		@Override
		public void setPaymentCard(PaymentCard paymentCard) {
			if(paymentCard==null) return;
			
			if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
				LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
				TradeSettlementPaymentMeansType tradeSettlementPaymentMeans = TradeSettlementPaymentMeans.create((TradeSettlementFinancialCard)paymentCard);
				getSpecifiedTradeSettlementPaymentMeans().add(tradeSettlementPaymentMeans);
			} else {
				getSpecifiedTradeSettlementPaymentMeans().get(0).setApplicableTradeSettlementFinancialCard((TradeSettlementFinancialCard)paymentCard);
			}
		}

/* ---------------- implements DirectDebit + Factory:
	BG-19 ++ 0..1 DIRECT DEBIT
	ram:SpecifiedTradePaymentTerms . ram:DirectDebitMandateID
0 .. 1 DirectDebitMandateID Kennung der Mandatsreferenz               BG-19/ BT-89
0 .. 1 CreditorReferenceID Kennung des Gläubigers                     BG-19/ BT-90
1 .. 1 IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos BG-19/ BT-91

	BG19_DirectDebit == DirectDebit + get/setMandateReferencedID(String id) ==> in tradePaymentTerms
	                                + get/setBankAssignedCreditorID(String id) ==> this
                        DirectDebit.get/setDebitedAccountID(iban oder account) ==> in pm

 */

	// interface DirectDebitFactory
	@Override 
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, IBANId iban) {
		LOG.info("mandateID="+mandateID + " bankAssignedCreditorID="+bankAssignedCreditorID + " iban="+iban);

		if(iban!=null) {
			TradeSettlementPaymentMeans dd = TradeSettlementPaymentMeans.create(iban);
			getSpecifiedTradeSettlementPaymentMeans().add(dd);
		}
		
		// <ram:CreditorReferenceID>
		if(bankAssignedCreditorID!=null) {
			super.setCreditorReferenceID(new ID(bankAssignedCreditorID));
		}
		
		//ram:SpecifiedTradePaymentTerms
		// <ram:DirectDebitMandateID>
		if(mandateID!=null) {
			this.setMandateReferencedID(mandateID);
		}
		
		return (DirectDebit)this; // BG19_DirectDebit extends DirectDebit
	}

	@Override
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, String debitedAccountID) {
		LOG.info("mandateID="+mandateID + " bankAssignedCreditorID="+bankAssignedCreditorID + " debitedAccountID="+debitedAccountID);

		if(debitedAccountID!=null) {
			TradeSettlementPaymentMeans dd = TradeSettlementPaymentMeans.create(debitedAccountID, (BICId)null);
			getSpecifiedTradeSettlementPaymentMeans().add(dd);
		}
		
		if(bankAssignedCreditorID!=null) {
			super.setCreditorReferenceID(new ID(bankAssignedCreditorID));
		}
		
		if(mandateID!=null) {
			this.setMandateReferencedID(mandateID);
		}
		
		return (DirectDebit)this; // BG19_DirectDebit extends DirectDebit
	}

	@Override // implements interface PaymentInstructions
	public void setDirectDebit(DirectDebit bg19_directDebit) {
		if(bg19_directDebit==null) return;

//		LOG.fine("bg19_directDebit:"+bg19_directDebit.getMandateReferencedID()+" ==> tradePaymentTerms:"+this.tradePaymentTerms);
//		LOG.fine("bg19_directDebit:"+bg19_directDebit.getBankAssignedCreditorID()+" ==> this:"+this.getBankAssignedCreditorID());
//		LOG.fine("bg19_directDebit:"+bg19_directDebit.getDebitedAccountID()+" ==> this.pm#"+this.getSpecifiedTradeSettlementPaymentMeans().size());
		setMandateReferencedID(bg19_directDebit.getMandateReferencedID());       // BG-19.BT-89 0..1
		setBankAssignedCreditorID(bg19_directDebit.getBankAssignedCreditorID()); // BG-19.BT-90 0..1
//		                                                                         // BG-19.BT-91 0..1 :
		TradeSettlementPaymentMeansType dd = ((ApplicableHeaderTradeSettlement)bg19_directDebit).getSpecifiedTradeSettlementPaymentMeans().get(0);
		if(this.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			getSpecifiedTradeSettlementPaymentMeans().add(dd);
		} else {
			getSpecifiedTradeSettlementPaymentMeans().get(0).setPayerPartyDebtorFinancialAccount(dd.getPayerPartyDebtorFinancialAccount());
		}
	}

	@Override // implements interface PaymentInstructions
	public DirectDebit getDirectDebit() {
		if(PaymentMeansEnum.isDirectDebit(getPaymentMeansEnum())) {
			return (DirectDebit)this;
		};
		return null;
	}

	// BG19_DirectDebit methods:
	// BG-19.BT-89 0..1
	@Override
	public String getMandateReferencedID() {
		return tradePaymentTerms==null ? null : tradePaymentTerms.getMandateReferencedID();
	}
	@Override
	public void setMandateReferencedID(String mandateID) {
		if(mandateID==null) return;
		checkTradePaymentTerms();
		tradePaymentTerms.setMandateReferencedID(mandateID);
	}
	
	// BG-19.BT-90 0..1
	@Override
	public String getBankAssignedCreditorID() {
		return super.getCreditorReferenceID()==null ? null : super.getCreditorReferenceID().getValue();
	}
	@Override
	public void setBankAssignedCreditorID(String bankAssignedCreditorID) {
		if(bankAssignedCreditorID!=null) {
			super.setCreditorReferenceID(new ID(bankAssignedCreditorID));		
		}
	}
	
	// BG-19.BT-91 0..1
	@Override
	public String getDebitedAccountID() {
		if(PaymentMeansEnum.isDirectDebit(getPaymentMeansEnum())) {
			TradeSettlementPaymentMeans pm = TradeSettlementPaymentMeans.create(getSpecifiedTradeSettlementPaymentMeans().get(0));
			return pm.getDebitedAccountID();
		};
		return null;
	}
	
	@Override
	public void setDebitedAccountID(String id) {
		DirectDebit thisAlsDD = getDirectDebit();
		if(thisAlsDD==null) {
			createDirectDebit(null, null, id);
		}
		TradeSettlementPaymentMeans dd = TradeSettlementPaymentMeans.create(getSpecifiedTradeSettlementPaymentMeans().get(0));
//		LOG.info(">>>>>>> dd:"+dd);
		dd.setDebitedAccountID(id);
		this.getSpecifiedTradeSettlementPaymentMeans().set(0, dd);
	}
	@Override
	public void setDebitedAccountID(IBANId iban) {
		DirectDebit thisAlsDD = getDirectDebit();
		if(thisAlsDD==null) {
			createDirectDebit(null, null, iban);
		} else {
			TradeSettlementPaymentMeans dd = TradeSettlementPaymentMeans.create(getSpecifiedTradeSettlementPaymentMeans().get(0));
//			LOG.info(">>>>>>> dd:"+dd);
			dd.setDebitedAccountID(iban);
			this.getSpecifiedTradeSettlementPaymentMeans().set(0, dd);
		}
	}

	private void checkTradePaymentTerms() {
		if(tradePaymentTerms==null) {
			tradePaymentTerms = TradePaymentTerms.create();
			super.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
		}
	}
	
	void setPaymentTermsAndDate(String description, Timestamp ts) {
		if(description==null && ts==null) return;
		checkTradePaymentTerms();
		tradePaymentTerms.setPaymentTermsAndDate(description, ts);;
	}
	
	// TradeAllowanceCharge extends TradeAllowanceChargeType implements AllowancesAndCharges
	public void addAllowanceCharge(AllowancesAndCharges allowanceOrCharge) {
		super.getSpecifiedTradeAllowanceCharge().add((TradeAllowanceCharge)allowanceOrCharge); // ram:SpecifiedTradeAllowanceCharge
	}
	public List<AllowancesAndCharges> getAllowancesAndCharges() {
		List<TradeAllowanceChargeType> list = super.getSpecifiedTradeAllowanceCharge();
		List<AllowancesAndCharges> res = new ArrayList<AllowancesAndCharges>(list.size());
		list.forEach(stac -> {
			res.add(TradeAllowanceCharge.create(stac));
		});
		return res;
	}

// ---------------- TODO BG22
	// 1 .. 1 SpecifiedTradeSettlementHeaderMonetarySummation Gesamtsummen auf Dokumentenebene BG-22
	void setDocumentTotals(Amount lineExtension, Amount taxExclusive, Amount taxInclusive, Amount payable) {
		LOG.info("setDocumentTotals: lineExtension:"+lineExtension + " taxExclusive:"+taxExclusive + " taxInclusive:"+taxInclusive + " payable:"+payable);
		if(lineExtension==null && taxExclusive==null && taxInclusive==null && payable==null) return; // defensiv

		TradeSettlementHeaderMonetarySummationType gesamtsummen = super.getSpecifiedTradeSettlementHeaderMonetarySummation();
		if(gesamtsummen==null) {
			LOG.fine("gesamtsummen==null ===> erstellen");
			setSpecifiedTradeSettlementHeaderMonetarySummation(new TradeSettlementHeaderMonetarySummationType());
		}
		
		if(lineExtension!=null) {
			AmountType lineTotalAmt = new AmountType();
			lineExtension.copyTo(lineTotalAmt);
			getSpecifiedTradeSettlementHeaderMonetarySummation().getLineTotalAmount().add(lineTotalAmt); // add to list
		}
		
		if(taxExclusive!=null) {
			AmountType taxBasisTotalAmt = new AmountType();
			taxExclusive.copyTo(taxBasisTotalAmt);
			getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxBasisTotalAmount().add(taxBasisTotalAmt); // add to list
		}
		
		if(taxInclusive!=null) {
			AmountType taxTotalAmt = new AmountType();
			taxInclusive.copyTo(taxTotalAmt);
			taxTotalAmt.setCurrencyID(taxInclusive.getCurrencyID()); // wg. validation 
			getSpecifiedTradeSettlementHeaderMonetarySummation().getGrandTotalAmount().add(taxTotalAmt); // add to list
		}
		
		if(payable!=null) {
			AmountType payableAmt = new AmountType();
			payable.copyTo(payableAmt);
			getSpecifiedTradeSettlementHeaderMonetarySummation().getDuePayableAmount().add(payableAmt); // add to list
		}
	}
	// BG-22.BT-106 - 1..1/1..1
	Amount getInvoiceLineNetTotal() {
		if(super.getSpecifiedTradeSettlementHeaderMonetarySummation() == null) return null;
		return new Amount(getSpecifiedTradeSettlementHeaderMonetarySummation().getLineTotalAmount().get(0).getValue());
	}
	// BG-22.BT-109 - 1..1/1..1
	public Amount getInvoiceTotalTaxExclusive() {
		if(super.getSpecifiedTradeSettlementHeaderMonetarySummation() == null) return null;
		return new Amount(getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxBasisTotalAmount().get(0).getValue());
	}
	// BG-22.BT-112 - 1..1/1..1
	public Amount getInvoiceTotalTaxInclusive() {
		if(super.getSpecifiedTradeSettlementHeaderMonetarySummation() == null) return null;
		return new Amount(getSpecifiedTradeSettlementHeaderMonetarySummation().getGrandTotalAmount().get(0).getValue());
	}
	// BG-22.BT-115 - 1..1/1..1
	public Amount getDuePayable() { 
		if(super.getSpecifiedTradeSettlementHeaderMonetarySummation() == null) return null;
		return new Amount(getSpecifiedTradeSettlementHeaderMonetarySummation().getDuePayableAmount().get(0).getValue());
	}

	void setInvoiceTax(Amount amount) {
		AmountType taxTotalAmt = new AmountType();
		amount.copyTo(taxTotalAmt);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxTotalAmount().add(taxTotalAmt); // add to list
	}
	// BG-22.BT-113 - 1..1/0..1 (optional) The sum of amounts which have been paid in advance.
	Amount getPrepaid() {
		if(super.getSpecifiedTradeSettlementHeaderMonetarySummation()==null) return null;
		List<AmountType> list = getSpecifiedTradeSettlementHeaderMonetarySummation().getTotalPrepaidAmount();
		return list.isEmpty() ? null : new Amount(list.get(0).getCurrencyID(), list.get(0).getValue());		
	}
	void setPrepaid(Amount amount) {
		if(amount==null) return;
		AmountType prepaidAmount = new AmountType();
		amount.copyTo(prepaidAmount);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getTotalPrepaidAmount().add(prepaidAmount); // add to list
	}
	// BG-22.BT-107
	Amount getAllowancesTotal() {
		if(super.getSpecifiedTradeSettlementHeaderMonetarySummation() == null) return null;
		List<AmountType> list = getSpecifiedTradeSettlementHeaderMonetarySummation().getAllowanceTotalAmount();
		return list.isEmpty() ? null : new Amount(list.get(0).getCurrencyID(), list.get(0).getValue());		
	}
	void setAllowancesTotal(Amount amount) {
		if(amount==null) return;
		AmountType allowancesTotalAmount = new AmountType();
		amount.copyTo(allowancesTotalAmount);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getAllowanceTotalAmount().add(allowancesTotalAmount); // add to list
	}
	// BG-22.BT-108
	Amount getChargesTotal() {
		if(super.getSpecifiedTradeSettlementHeaderMonetarySummation() == null) return null;
		List<AmountType> list = getSpecifiedTradeSettlementHeaderMonetarySummation().getChargeTotalAmount();
		return list.isEmpty() ? null : new Amount(list.get(0).getCurrencyID(), list.get(0).getValue());		
	}
	void setChargesTotal(Amount amount) {
		if(amount==null) return;
		AmountType chargesTotalAmount = new AmountType();
		amount.copyTo(chargesTotalAmount);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getChargeTotalAmount().add(chargesTotalAmount); // add to list
	}
	// BG-22.BT-114
	Amount getRounding() {
		if(super.getSpecifiedTradeSettlementHeaderMonetarySummation() == null) return null;
		List<AmountType> list = getSpecifiedTradeSettlementHeaderMonetarySummation().getRoundingAmount();
		return list.isEmpty() ? null : new Amount(list.get(0).getCurrencyID(), list.get(0).getValue());		
	}
	void setRounding(Amount amount) {
		if(amount==null) return;
		AmountType rounding = new AmountType();
		amount.copyTo(rounding);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getRoundingAmount().add(rounding); // add to list
	}
	
	// BG-10 + 0..1 PAYEE
	public void setPayee(BusinessParty party) {
		super.setPayeeTradeParty((TradePartyType) party);
	}
	public TradeParty getPayeeTradeParty() {
		TradePartyType party = super.getPayeeTradeParty();
		return party==null ? null : TradeParty.create(party);
	}
	
	// BG-14 ++ 0..1 INVOICING PERIOD
	public SpecifiedPeriodType getBillingSpecifiedPeriod() {
		if(billingSpecifiedPeriod==null) {
			billingSpecifiedPeriod = super.getBillingSpecifiedPeriod();
			if(billingSpecifiedPeriod==null) {
				billingSpecifiedPeriod = new SpecifiedPeriodType();
				super.setBillingSpecifiedPeriod(billingSpecifiedPeriod);
			}
		}
		return billingSpecifiedPeriod;
	}

}
