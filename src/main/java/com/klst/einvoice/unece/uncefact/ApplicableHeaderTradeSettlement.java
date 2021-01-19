package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.BG19_DirectDebit;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.CreditTransferFactory;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.DirectDebitFactory;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.PaymentInstructionsFactory;
import com.klst.untdid.codelist.DateTimeFormats;
import com.klst.untdid.codelist.PaymentMeansEnum;

import un.unece.uncefact.data.standard.qualifieddatatype._100.CurrencyCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.PaymentMeansCodeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeSettlementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SpecifiedPeriodType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeTransactionType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAllowanceChargeType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementFinancialCardType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementHeaderMonetarySummationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeTaxType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
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
		, BG19_DirectDebit, DirectDebitFactory {

	// implements PaymentInstructionsFactory
	@Override
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		return create(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	static PaymentInstructions create(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		return new ApplicableHeaderTradeSettlement(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	
	private static final Logger LOG = Logger.getLogger(ApplicableHeaderTradeSettlement.class.getName());
	
	SpecifiedPeriodType billingSpecifiedPeriod = null; // BG-14 ++ 0..1 INVOICING PERIOD

	static ApplicableHeaderTradeSettlement getApplicableHeaderTradeSettlement(SupplyChainTradeTransactionType supplyChainTradeTransaction) {
		if(supplyChainTradeTransaction==null) return null;
		return new ApplicableHeaderTradeSettlement(supplyChainTradeTransaction.getApplicableHeaderTradeSettlement());
	}
	
	static Timestamp taxPointDateAsTimestamp(DateType date) {
		return DateTimeFormats.ymdToTs(date.getDateString().getValue());
	}
	
	static Timestamp getTaxPointDateAsTimestamp(HeaderTradeSettlementType ahts) {
		List<TradeTaxType> tradeTaxList = ahts.getApplicableTradeTax();
		if(tradeTaxList.isEmpty()) return null;
		
		List<Timestamp> results = new ArrayList<Timestamp>(tradeTaxList.size());
		tradeTaxList.forEach(tradeTax -> {
			DateType date = tradeTax.getTaxPointDate();
			if(date==null) {
				LOG.fine("getTaxPointDateAsTimestamp(doc) TaxPointDate is null");
			} else if(DateTimeFormats.CCYYMMDD_QUALIFIER.equals(date.getDateString().getFormat())) {
				results.add(taxPointDateAsTimestamp(date));
			} else {
				LOG.warning("not CCYYMMDD-Format:"+date.getDateString().getFormat() + " value:"+date.getDateString().getValue());
			}		
		});
		if(results.isEmpty()) return null;
		if(results.size()>1) {
			LOG.warning("results.size()>1:"+results.size());
		}
		return results.get(0);
	}

	// copy ctor
	ApplicableHeaderTradeSettlement(HeaderTradeSettlementType ahts) {
		super();
		this.setDocumentCurrency(ahts.getInvoiceCurrencyCode().getValue());
		if(ahts.getTaxCurrencyCode()!=null) {
			this.setTaxCurrency(ahts.getTaxCurrencyCode().getValue());
		}
		if(ahts.getCreditorReferenceID()!=null) {
			this.setCreditorReferenceID(new ID(ahts.getCreditorReferenceID()));
		}
		
		this.setMandateReferencedID(getMandateReferencedID(ahts)); // wg DirectDebit
		
		if(getRemittanceInformation(ahts)!=null) { // getRemittanceInformation
			this.setRemittanceInformation(getRemittanceInformation(ahts));
		}
		
//		// BG-20 + BG-21- 0..n
//		getAllowancesAndCharges(ahts).forEach(aac -> {
//			addAllowanceCharge(aac);
//		});

		
		// 1 .. 1 SpecifiedTradeSettlementHeaderMonetarySummation Gesamtsummen auf Dokumentenebene BG-22 : nicht null
		setSpecifiedTradeSettlementHeaderMonetarySummation(ahts.getSpecifiedTradeSettlementHeaderMonetarySummation());
		
		if(ahts.getSpecifiedTradeAllowanceCharge().isEmpty()) {
			// no TradeAllowanceCharge
		} else {
			ahts.getSpecifiedTradeAllowanceCharge().forEach(stac -> {
				this.addAllowanceCharge(new TradeAllowanceCharge(stac));
			});
		}

		List<TradeSettlementPaymentMeansType> tradeSettlementPaymentMeans = ahts.getSpecifiedTradeSettlementPaymentMeans();
		if(tradeSettlementPaymentMeans.isEmpty()) {
			// sollte nicht vorkommen
			LOG.warning("SpecifiedTradeSettlementPaymentMeans is empty");
		} else {
			// anhand von code ergibt sich, welcher der drei verwendet wird
			TradeSettlementPaymentMeansType pm = tradeSettlementPaymentMeans.get(0);
//			PaymentMeansEnum paymentMeansCode = getPaymentMeansEnum(pm);
//			String paymentMeansText = getPaymentMeansText(pm);
//			switch(paymentMeansCode) { 
///*
//	InstrumentNotDefined 	(1),
//	InCash 				(10),
//	Cheque				(20),
//	CreditTransfer 		(30),
//	DebitTransfer 		(31),
//	PaymentToBankAccount 	(42),
//	BankCard 			(48),
//	DirectDebit 		(49),
//	StandingAgreement 	(57),
//	SEPACreditTransfer 	(58),
//	SEPADirectDebit 	(59),
//	ClearingBetweenPartners (97);
// */
//			case CreditTransfer:
//			case SEPACreditTransfer:
//				getSpecifiedTradeSettlementPaymentMeans().add(new TradeSettlementPaymentMeans(pm));
//				break;		
//			case BankCard:
//				getSpecifiedTradeSettlementPaymentMeans().add(new TradeSettlementPaymentMeans(pm));
//				break;
//			case DirectDebit: 
//			case SEPADirectDebit: 
//				getSpecifiedTradeSettlementPaymentMeans().add(new TradeSettlementPaymentMeans(pm));
//				break;
//			default:
//				LOG.warning("[BR-DE-13] In der Rechnung müssen Angaben zu genau einer der drei Gruppen sein: CREDIT TRANSFER, PAYMENT CARD INFORMATION, DIRECT DEBIT - Ist:"
//						+ paymentMeansCode);
//				break;
//			}
			getSpecifiedTradeSettlementPaymentMeans().add(new TradeSettlementPaymentMeans(pm));
		}
		if(tradeSettlementPaymentMeans.size()>1) {
			// mehrere PaymentInstructions bei CreditTransfer:
			for(int i=1; i<tradeSettlementPaymentMeans.size(); i++) {
				TradeSettlementPaymentMeansType pm = tradeSettlementPaymentMeans.get(i);
				TradeSettlementPaymentMeans creditTransfer = new TradeSettlementPaymentMeans(pm);
				getSpecifiedTradeSettlementPaymentMeans().add(creditTransfer);
			}
		}
	} // copy ctor
	
	// ctor
	ApplicableHeaderTradeSettlement() {
		super();
	}
/*
in super gibt es 0..n <ram:SpecifiedTradeSettlementPaymentMeans> - Objekte
 */
	ApplicableHeaderTradeSettlement(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		this();
		init(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	void init(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
//		TradeSettlementPaymentMeansType pm = addPaymentMeans(code, paymentMeansText); // BT-81, BT-82
		setRemittanceInformation(remittanceInformation); // BT-83
		 // BG-17 :
		if(creditTransfer!=null) {
			if(creditTransfer.size()>0) {
				TradeSettlementPaymentMeansType pm = new TradeSettlementPaymentMeans((TradeSettlementPaymentMeansType)creditTransfer.get(0));
				getSpecifiedTradeSettlementPaymentMeans().add(pm);
			}
			for(int i=1; i<creditTransfer.size(); i++) {
//				TradeSettlementPaymentMeansType newPm 
//					= addPaymentMeans(code, paymentMeansText); // BT-81, BT-82
//				newPm.setPayeePartyCreditorFinancialAccount(((FinancialAccount)creditTransfer.get(i)).payeePartyCreditorFinancialAccount);
//				newPm.setPayeeSpecifiedCreditorFinancialInstitution(((FinancialAccount)creditTransfer.get(i)).payeeSpecifiedCreditorFinancialInstitution);
				TradeSettlementPaymentMeansType pm = new TradeSettlementPaymentMeans((TradeSettlementPaymentMeansType)creditTransfer.get(i));
				getSpecifiedTradeSettlementPaymentMeans().add(pm);
			}
		} else {
			setPaymentCard(paymentCard); // BG-18
			setDirectDebit((BG19_DirectDebit)directDebit); // BG-19
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
			LOG.warning("BT-5 + 1..1 Invoice currency code is null !!!!!!!!!!!!!!!!!!");
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
	
	// BT-7 + 0..1 Value added tax point date
	void setTaxPointDate(Timestamp ts) {
		if(ts==null) return;  // optional
		List<TradeTaxType> listBG23 = super.getApplicableTradeTax();
		// 0..n ApplicableTradeTax Umsatzsteueraufschlüsselung BG-23
		if(listBG23==null) {
			LOG.warning("das darf nicht sein ------- exception");
			// oder doch?
			return;
		}
		listBG23.forEach(tradeTax -> {
			tradeTax.setTaxPointDate(newDateType(ts));
		});
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
		LOG.info("PaymentMeansEnum="+code +" // use addPaymentMeansCT");
		setPaymentMeans(code, null);
	}

	@Override
	public PaymentMeansEnum getPaymentMeansEnum() {
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			return null;
		}
		return getPaymentMeansEnum(getSpecifiedTradeSettlementPaymentMeans().get(0));
	}
	static PaymentMeansEnum getPaymentMeansEnum(TradeSettlementPaymentMeansType tradeSettlementPaymentMeans) {
		if(tradeSettlementPaymentMeans==null) return null;
		PaymentMeansCodeType pmc = tradeSettlementPaymentMeans.getTypeCode();	
		return pmc==null ? null : PaymentMeansEnum.valueOf(pmc);
	}

	// BT-81, BT-82
	@Override
	public void setPaymentMeans(PaymentMeansEnum code, String text) { // code+text
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.info("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty() - create it:");
		}
		addPaymentMeans(code, text);
	}
	private TradeSettlementPaymentMeansType addPaymentMeans(PaymentMeansEnum code, String text) { // code+text
		PaymentMeansCodeType pmc = new PaymentMeansCodeType(); // BT-81
		pmc.setValue(code.getValueAsString());
		
		TradeSettlementPaymentMeansType tradeSettlementPaymentMeans = new TradeSettlementPaymentMeansType();
		getSpecifiedTradeSettlementPaymentMeans().add(tradeSettlementPaymentMeans);
		
		tradeSettlementPaymentMeans.setTypeCode(pmc);
		
		if(text!=null) { // BT-82 
			tradeSettlementPaymentMeans.getInformation().add(new Text(text));
		}
		return tradeSettlementPaymentMeans;
	}
	
	@Override
	public String getPaymentMeansText() {
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			return null;
		}
		return getPaymentMeansText(getSpecifiedTradeSettlementPaymentMeans().get(0));
	}
	static String getPaymentMeansText(TradeSettlementPaymentMeansType tradeSettlementPaymentMeans) {
		if(tradeSettlementPaymentMeans==null) return null;
		return tradeSettlementPaymentMeans.getInformation().isEmpty() ? null : tradeSettlementPaymentMeans.getInformation().get(0).getValue();
	}
	

	// 0 .. 1 PaymentReference Verwendungszweck                                        BT-83
	@Override
	public void setRemittanceInformation(String text) { 
		if(text==null) return;
		super.getPaymentReference().add(new Text(text));
	}

	@Override
	public String getRemittanceInformation() {
		return getRemittanceInformation(this);
	}
	static String getRemittanceInformation(HeaderTradeSettlementType headerTradeSettlement) {
		List<TextType> list = headerTradeSettlement.getPaymentReference();
		return list.isEmpty() ? null : list.get(0).getValue();
	}

	// BG-17 ++ 0..n CREDIT TRANSFER
	@Override
	public void addCreditTransfer(CreditTransfer creditTransfer) {
		// FinancialAccount implements CreditTransfer
		// in FinancialAccount payeePartyCreditorFinancialAccount
		TradeSettlementPaymentMeans financialAccount = (TradeSettlementPaymentMeans)creditTransfer;
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			return;
		}
//		getSpecifiedTradeSettlementPaymentMeans().get(0).setPayeePartyCreditorFinancialAccount(financialAccount.payeePartyCreditorFinancialAccount);
//		getSpecifiedTradeSettlementPaymentMeans().get(0).setPayeeSpecifiedCreditorFinancialInstitution(financialAccount.payeeSpecifiedCreditorFinancialInstitution);
		getSpecifiedTradeSettlementPaymentMeans().add(financialAccount);
	}

	// BG-17 Kardinalität ist 0..n, aber in CII kann es nur 0..1 sein,
	// daher wird CreditTransfer von ApplicableHeaderTradeSettlement implementiert 
	// in 01.08a gibt es mehrere BG-17
	@Override
	public List<CreditTransfer> getCreditTransfer() {
		return getCreditTransfer(this);
	}
	static List<CreditTransfer> getCreditTransfer(HeaderTradeSettlementType haderTradeSettlement) {
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
				TradeSettlementPaymentMeans financialAccount = new TradeSettlementPaymentMeans(pm);
				ret.add(financialAccount);
			break;
			default:
				LOG.info(".............");
			break;
			}
		});
		return ret;
	}

	// implements BG-18 (optional) PAYMENT CARD INFORMATION
	@Override
	public PaymentCard getPaymentCard() {
		if(TradeSettlementPaymentMeans.isBankCard(getPaymentMeansEnum())) {
			List<TradeSettlementPaymentMeansType> list = super.getSpecifiedTradeSettlementPaymentMeans();
			if(list.isEmpty()) {
				LOG.warning("superXXX.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
				return null;
			}
			TradeSettlementPaymentMeansType pm = list.get(0);
			if(pm instanceof TradeSettlementPaymentMeans) {
				TradeSettlementFinancialCardType card = ((TradeSettlementPaymentMeans)pm).getApplicableTradeSettlementFinancialCard();
				if(card instanceof TradeSettlementFinancialCard) {
					return (PaymentCard)card;
				}
				return new TradeSettlementFinancialCard(card);
			} else {
				LOG.warning("pm NOT instanceof TradeSettlementPaymentMeans, ....");
			}
		}
		return null;
	}
//	static PaymentCard getPaymentCard(HeaderTradeSettlementType headerTradeSettlement) {
//		if(TradeSettlementPaymentMeans.isBankCard(getPaymentMeansEnum())) {
//			if(headerTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
//				LOG.warning("superXXX.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
//				return null;
//			}
//			return headerTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().get(0);
//		};
//		return null;
//		if(headerTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
//			LOG.warning("superXXX.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
//			return null;
//		}
//		if(PaymentMeansEnum.BankCard != getPaymentMeansEnum(headerTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().get(0))) {
//			return null;
//		}
//			
//		return new FinancialCard(headerTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().get(0));
//	}
	
	private void setPaymentCard(TradeSettlementFinancialCardType financialCard) {
		if(financialCard==null) return;
		LOG.info(">>>>>>>>>>>>>>financialCard:"+financialCard);
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()>>>>> create it");
//			return; new TradeSettlementPaymentMeansType
			TradeSettlementPaymentMeansType tradeSettlementPaymentMeans = new TradeSettlementPaymentMeansType();
			getSpecifiedTradeSettlementPaymentMeans().add(tradeSettlementPaymentMeans);
		}
		getSpecifiedTradeSettlementPaymentMeans().get(0).setApplicableTradeSettlementFinancialCard(financialCard);
	}
	@Override
	public void setPaymentCard(PaymentCard paymentCard) {
		if(paymentCard==null) return;
		LOG.warning(">>>>>>>>>>>>>>"+paymentCard);
		
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			TradeSettlementPaymentMeansType tradeSettlementPaymentMeans = new TradeSettlementPaymentMeans((TradeSettlementFinancialCard)paymentCard);
			getSpecifiedTradeSettlementPaymentMeans().add(tradeSettlementPaymentMeans);
		}
//		if(paymentCard instanceof TradeSettlementFinancialCard) {
//			setPaymentCard((TradeSettlementFinancialCardType)paymentCard);
//		}
	}

	// BG-19 ++ 0..1 DIRECT DEBIT
	@Override
	public void setDirectDebit(BG19_DirectDebit directDebit) {
		if(directDebit==null) return;
		// this:Class implements BG19_DirectDebit
		// FinancialAccount implements DirectDebit
		// in FinancialAccount payerPartyDebtorFinancialAccount
//		LOG.warning(">>>>>>>>>>>>>>"+directDebit);
		if(directDebit instanceof ApplicableHeaderTradeSettlement) {
			List<TradeSettlementPaymentMeansType> list = ((ApplicableHeaderTradeSettlement)directDebit).getSpecifiedTradeSettlementPaymentMeans();
			if(list.isEmpty()) {
				LOG.warning("----SpecifiedTradeSettlementPaymentMeans().isEmpty()");
			} else {
				TradeSettlementPaymentMeansType dd = list.get(0);
				super.getSpecifiedTradeSettlementPaymentMeans().add(dd);
				
				LOG.warning("----directDebit.getMandateReferencedID="+directDebit.getMandateReferencedID());
				this.setMandateReferencedID(directDebit.getMandateReferencedID());
				this.setBankAssignedCreditorID(directDebit.getBankAssignedCreditorID());
			}
			return;
		}
		// ------------------------------
		TradeSettlementPaymentMeans financialAccount = (TradeSettlementPaymentMeans)directDebit;
		if(super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("super.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			getSpecifiedTradeSettlementPaymentMeans().add(financialAccount);
			return;
		}
//		getSpecifiedTradeSettlementPaymentMeans().get(0).setPayerPartyDebtorFinancialAccount(financialAccount.payerPartyDebtorFinancialAccount);
//		if(financialAccount.getMandateReferencedID()==null) {
//			// nix tun
//		} else {
//			// TODO in SpecifiedTradePaymentTerms
//			LOG.warning("TODO in SpecifiedTradePaymentTerms MandateReferencetID setzen: "+financialAccount.getMandateReferencedID());
//		}
	}

// BG-19 ++ 0..1 DIRECT DEBIT
// CII:
	// ram:SpecifiedTradePaymentTerms . ram:DirectDebitMandateID
// 0 .. 1 DirectDebitMandateID Kennung der Mandatsreferenz               BG-19/ BT-89
// 0 .. 1 CreditorReferenceID Kennung des Gläubigers                     BG-19/ BT-90
// 1 .. 1 IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos BG-19/ BT-91
	@Override
	public BG19_DirectDebit getDirectDebit() {
		if(TradeSettlementPaymentMeans.isDirectDebit(getPaymentMeansEnum())) {
			return (BG19_DirectDebit)this;
		};
		return null;
	}
	static TradeSettlementPaymentMeans getFinancialAccount(HeaderTradeSettlementType headerTradeSettlement) {
		if(headerTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().isEmpty()) {
			LOG.warning("XXXX.getSpecifiedTradeSettlementPaymentMeans().isEmpty()");
			return null;
		}
		PaymentMeansEnum code = getPaymentMeansEnum(headerTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().get(0));
		if(PaymentMeansEnum.DirectDebit == code || PaymentMeansEnum.SEPADirectDebit == code) {
			return new TradeSettlementPaymentMeans(headerTradeSettlement.getSpecifiedTradeSettlementPaymentMeans().get(0));
		}
		return null;
	}
	static ID getDirectDebitMandateID(HeaderTradeSettlementType headerTradeSettlement) {
		ID directDebitMandate = null;
		if(headerTradeSettlement.getSpecifiedTradePaymentTerms().isEmpty()) {
			// keine Mandatsreferenz
		} else {
			TradePaymentTermsType tradePaymentTerms = headerTradeSettlement.getSpecifiedTradePaymentTerms().get(0); // 0..1
			if(tradePaymentTerms.getDirectDebitMandateID().isEmpty()) {
				// keine Mandatsreferenz
			} else {
				directDebitMandate = new ID(tradePaymentTerms.getDirectDebitMandateID().get(0).getValue());
			}
		}
		return directDebitMandate;
	}

// ---------------- implements CreditTransferFactory:
//	private FinancialAccount financialAccount = null;

	@Override
	public CreditTransfer createCreditTransfer(IBANId iban, String accountName, BICId bic) {
//		if(financialAccount==null) {
//			financialAccount = new FinancialAccount(iban, accountName, bic); //new FinancialAccount(tradeSettlementPaymentMeans);
//		}
//		return financialAccount;
		return TradeSettlementPaymentMeans.create(iban, accountName, bic);
	}

	@Override
	public CreditTransfer createCreditTransfer(String accountId, String accountName, BICId bic) {
//		if(financialAccount==null) {
//			financialAccount = new FinancialAccount(accountId, accountName, bic); //new FinancialAccount(tradeSettlementPaymentMeans);
//		}
//		return financialAccount;
		return TradeSettlementPaymentMeans.create(accountId, accountName, bic);
	}
	
// ---------------- implements DirectDebit + Factory:
	// BG19_DirectDebit methods
	@Override
	public String getMandateReferencedID() {
		return getMandateReferencedID(this);
	}
	static String getMandateReferencedID(HeaderTradeSettlementType headerTradeSettlement) {
		List<TradePaymentTermsType> tradePaymentTerms = headerTradeSettlement.getSpecifiedTradePaymentTerms();
		if(tradePaymentTerms.isEmpty()) return null;
		List<IDType> directDebitMandateIDs = tradePaymentTerms.get(0).getDirectDebitMandateID();
		if(directDebitMandateIDs.isEmpty()) return null;
		return directDebitMandateIDs.get(0).getValue();
	}
	@Override
	public void setMandateReferencedID(String mandateID) {
		if(mandateID!=null) {
			TradePaymentTermsType tradePaymentTerms = this.getPaymentTerms();
			tradePaymentTerms.getDirectDebitMandateID().add(new ID(mandateID));
			this.setPaymentTerms(tradePaymentTerms);
		}
	}
	
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
	@Override
	public String getDebitedAccountID() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setDebitedAccountID(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setDebitedAccountID(IBANId iban) {
		// TODO Auto-generated method stub
		
	}

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
			TradePaymentTermsType tradePaymentTerms = this.getPaymentTerms();
			tradePaymentTerms.getDirectDebitMandateID().add(new ID(mandateID));
			this.setPaymentTerms(tradePaymentTerms);
		}
		
		return (DirectDebit)this;
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
			TradePaymentTermsType tradePaymentTerms = this.getPaymentTerms();
			tradePaymentTerms.getDirectDebitMandateID().add(new ID(mandateID));
			this.setPaymentTerms(tradePaymentTerms);
		}
		
		return (DirectDebit)this;
	}

	// TradeAllowanceCharge extends TradeAllowanceChargeType implements AllowancesAndCharges
	public void addAllowanceCharge(AllowancesAndCharges allowanceOrCharge) {
		super.getSpecifiedTradeAllowanceCharge().add((TradeAllowanceCharge)allowanceOrCharge); // ram:SpecifiedTradeAllowanceCharge
	}
	public List<AllowancesAndCharges> getAllowancesAndCharges() {
		return getAllowancesAndCharges(this);
	}
	static List<AllowancesAndCharges> getAllowancesAndCharges(HeaderTradeSettlementType hts) {
		List<TradeAllowanceChargeType> list = hts.getSpecifiedTradeAllowanceCharge();
		List<AllowancesAndCharges> res = new ArrayList<AllowancesAndCharges>(list.size());
		list.forEach(stac -> {
			res.add(new TradeAllowanceCharge(stac));
		});
		return res;
	}

// ----------------
	// 1 .. 1 SpecifiedTradeSettlementHeaderMonetarySummation Gesamtsummen auf Dokumentenebene BG-22
	void setDocumentTotals(Amount lineExtension, Amount taxExclusive, Amount taxInclusive, Amount payable) {
		LOG.config("setDocumentTotals: lineExtension:"+lineExtension + " taxExclusive:"+taxExclusive + " taxInclusive:"+taxInclusive + " payable:"+payable);
		AmountType lineTotalAmt = new AmountType();
		lineExtension.copyTo(lineTotalAmt);
		TradeSettlementHeaderMonetarySummationType gesamtsummen = super.getSpecifiedTradeSettlementHeaderMonetarySummation();
		if(gesamtsummen==null) {
			LOG.fine("gesamtsummen==null ===> erstellen");
			setSpecifiedTradeSettlementHeaderMonetarySummation(new TradeSettlementHeaderMonetarySummationType());
		}
		getSpecifiedTradeSettlementHeaderMonetarySummation().getLineTotalAmount().add(lineTotalAmt); // add to list
		
		AmountType taxBasisTotalAmt = new AmountType();
		taxExclusive.copyTo(taxBasisTotalAmt);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxBasisTotalAmount().add(taxBasisTotalAmt); // add to list
		
		AmountType taxTotalAmt = new AmountType();
		taxInclusive.copyTo(taxTotalAmt);

		taxTotalAmt.setCurrencyID(taxInclusive.getCurrencyID()); // wg. validation 
		getSpecifiedTradeSettlementHeaderMonetarySummation().getGrandTotalAmount().add(taxTotalAmt); // add to list
		
		AmountType payableAmt = new AmountType();
		payable.copyTo(payableAmt);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getDuePayableAmount().add(payableAmt); // add to list
	}
	void setInvoiceTax(Amount amount) {
		AmountType taxTotalAmt = new AmountType();
		amount.copyTo(taxTotalAmt);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getTaxTotalAmount().add(taxTotalAmt); // add to list
	}
	Amount getPrepaid() {
		List<AmountType> list = getSpecifiedTradeSettlementHeaderMonetarySummation().getTotalPrepaidAmount();
		return list.isEmpty() ? null : new Amount(list.get(0).getCurrencyID(), list.get(0).getValue());		
	}
	void setPrepaid(Amount amount) {
		if(amount==null) return;
		AmountType prepaidAmount = new AmountType();
		amount.copyTo(prepaidAmount);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getTotalPrepaidAmount().add(prepaidAmount); // add to list
	}
	Amount getAllowancesTotal() {
		List<AmountType> list = getSpecifiedTradeSettlementHeaderMonetarySummation().getAllowanceTotalAmount();
		return list.isEmpty() ? null : new Amount(list.get(0).getCurrencyID(), list.get(0).getValue());		
	}
	void setAllowancesTotal(Amount amount) {
		if(amount==null) return;
		AmountType allowancesTotalAmount = new AmountType();
		amount.copyTo(allowancesTotalAmount);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getAllowanceTotalAmount().add(allowancesTotalAmount); // add to list
	}
	Amount getChargesTotal() {
		List<AmountType> list = getSpecifiedTradeSettlementHeaderMonetarySummation().getChargeTotalAmount();
		return list.isEmpty() ? null : new Amount(list.get(0).getCurrencyID(), list.get(0).getValue());		
	}
	void setChargesTotal(Amount amount) {
		if(amount==null) return;
		AmountType chargesTotalAmount = new AmountType();
		amount.copyTo(chargesTotalAmount);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getChargeTotalAmount().add(chargesTotalAmount); // add to list
	}
	Amount getRounding() {
		List<AmountType> list = getSpecifiedTradeSettlementHeaderMonetarySummation().getRoundingAmount();
		return list.isEmpty() ? null : new Amount(list.get(0).getCurrencyID(), list.get(0).getValue());		
	}
	void setRounding(Amount amount) {
		if(amount==null) return;
		AmountType rounding = new AmountType();
		amount.copyTo(rounding);
		getSpecifiedTradeSettlementHeaderMonetarySummation().getRoundingAmount().add(rounding); // add to list
	}
	
	public TradeParty getPayeeTradeParty() {
		TradePartyType party = super.getPayeeTradeParty();
		return party==null ? null : new TradeParty(party);
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

	TradePaymentTermsType getPaymentTerms() {
		if(super.getSpecifiedTradePaymentTerms().isEmpty()) {
			TradePaymentTermsType tradePaymentTerms = new TradePaymentTermsType();
			super.getSpecifiedTradePaymentTerms().add(tradePaymentTerms);
			return tradePaymentTerms;
		}
		return super.getSpecifiedTradePaymentTerms().get(0);
	}
	void setPaymentTerms(TradePaymentTermsType tradePaymentTerms) {
		super.getSpecifiedTradePaymentTerms().set(0, tradePaymentTerms);
	}
	
}
