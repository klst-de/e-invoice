package com.klst.einvoice.unece.uncefact;

import java.util.logging.Logger;

import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.CreditorFinancialAccountType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.CreditorFinancialInstitutionType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.DebtorFinancialAccountType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;

//Gruppe CREDIT TRANSFER                   BG-17
//Gruppe DIRECT DEBIT                      BG-19
/*
Bsp: 01.15a:

        <ram:ApplicableHeaderTradeSettlement>
            <ram:PaymentReference>0000123456</ram:PaymentReference>
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
            <ram:SpecifiedTradeSettlementPaymentMeans>
                <ram:TypeCode>58</ram:TypeCode>                         <!-- BT-81
                <ram:PayeePartyCreditorFinancialAccount>                <!-- BG-17 0..n CREDIT TRANSFER
                    <ram:IBANID>DE75512108001245126199</ram:IBANID>
                    <ram:AccountName>[Payment account name]</ram:AccountName>
                </ram:PayeePartyCreditorFinancialAccount>
                <ram:PayeeSpecifiedCreditorFinancialInstitution>                 2-te Eintrag
                    <ram:BICID>[BIC]</ram:BICID>
                </ram:PayeeSpecifiedCreditorFinancialInstitution>              bis hierhin -->
            </ram:SpecifiedTradeSettlementPaymentMeans>

Testfälle für DIRECT DEBIT
Bsp: 03.01a:
        <ram:ApplicableHeaderTradeSettlement>
            <ram:CreditorReferenceID>[Bank assigned creditor identifier]</ram:CreditorReferenceID>
            <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
            <ram:SpecifiedTradeSettlementPaymentMeans>
                <ram:TypeCode>59</ram:TypeCode>
                <ram:PayerPartyDebtorFinancialAccount>
                    <!-- dies ist eine nicht existerende aber valide IBAN als test dummy -->
                    <ram:IBANID>DE75512108001245126199</ram:IBANID>
                </ram:PayerPartyDebtorFinancialAccount>
            </ram:SpecifiedTradeSettlementPaymentMeans>
            ...
            <ram:SpecifiedTradePaymentTerms>
                <ram:Description>Dieses Guthaben werden wir auf Ihr Konto erstatten.</ram:Description>
                <ram:DueDateDateTime>
                    <udt:DateTimeString format="102">20190314</udt:DateTimeString>
                </ram:DueDateDateTime>
                <ram:DirectDebitMandateID>[Mandate reference identifier]</ram:DirectDebitMandateID>
            </ram:SpecifiedTradePaymentTerms>

Bsp: 03.04a , 03.04a
 */
public class FinancialAccount implements CreditTransfer, DirectDebit {

	private static final Logger LOG = Logger.getLogger(FinancialAccount.class.getName());

	CreditorFinancialAccountType payeePartyCreditorFinancialAccount = null;
	CreditorFinancialInstitutionType payeeSpecifiedCreditorFinancialInstitution = null;
	DebtorFinancialAccountType payerPartyDebtorFinancialAccount = null;
	
	// ram:SpecifiedTradeSettlementPaymentMeans
	FinancialAccount(TradeSettlementPaymentMeansType tradeSettlementPaymentMeans) {
		super();
		if(tradeSettlementPaymentMeans!=null) {
			payeePartyCreditorFinancialAccount = tradeSettlementPaymentMeans.getPayeePartyCreditorFinancialAccount();
			payeeSpecifiedCreditorFinancialInstitution = tradeSettlementPaymentMeans.getPayeeSpecifiedCreditorFinancialInstitution();
			payerPartyDebtorFinancialAccount = tradeSettlementPaymentMeans.getPayerPartyDebtorFinancialAccount();
			//tradeSettlementPaymentMeans.getPayerSpecifiedDebtorFinancialInstitution();
		}
	}
	
	FinancialAccount(boolean isDirectDebit) {
		super();
		if(isDirectDebit) {
			payerPartyDebtorFinancialAccount = new DebtorFinancialAccountType();
		} else {
			payeePartyCreditorFinancialAccount = new CreditorFinancialAccountType();
			payeeSpecifiedCreditorFinancialInstitution = new CreditorFinancialInstitutionType();
		}
	}
	
	public FinancialAccount(IBANId iban, String accountName, BICId bic) {
		this(false);
		setPaymentAccountID(iban);
		setPaymentAccountName(accountName);
		setPaymentServiceProviderID(bic);
	}

	public FinancialAccount(String accountId, String accountName, BICId bic) {
		this(false);
		setPaymentAccountID(accountId);
		setPaymentAccountName(accountName);
		setPaymentServiceProviderID(bic);
	}

	public FinancialAccount(IBANId iban) { // Debited iban
		this(true);
		setDebitedAccountID(iban);
	}

// ---------------- implements CreditTransfer:
	
	@Override
	public String getPaymentAccountID() {
		if(payeePartyCreditorFinancialAccount==null) return null;
		if(payeePartyCreditorFinancialAccount.getIBANID()!=null) {
			return payeePartyCreditorFinancialAccount.getIBANID().getValue();
		}
		return payeePartyCreditorFinancialAccount.getProprietaryID()==null ? null : payeePartyCreditorFinancialAccount.getProprietaryID().getValue();
	}

	@Override
	public void setPaymentAccountID(IBANId iban) { // use ctor
		if(iban==null) return;
		payeePartyCreditorFinancialAccount.setIBANID(CrossIndustryInvoice.newIDType(iban));		
	}

	@Override
	public void setPaymentAccountID(String accountId) {
		if(accountId==null) return;
		payeePartyCreditorFinancialAccount.setProprietaryID(new Identifier(accountId));		
	}

	@Override
	public String getPaymentAccountName() {
		if(payeePartyCreditorFinancialAccount==null) return null;
		return payeePartyCreditorFinancialAccount.getAccountName()==null ? null : payeePartyCreditorFinancialAccount.getAccountName().getValue();
	}

	@Override
	public void setPaymentAccountName(String name) {
		if(name==null) return;
		payeePartyCreditorFinancialAccount.setAccountName(new Text(name));		
	}

	@Override
	public String getPaymentServiceProviderID() {
		if(payeeSpecifiedCreditorFinancialInstitution==null) return null;
		return payeeSpecifiedCreditorFinancialInstitution.getBICID()==null ? null : payeeSpecifiedCreditorFinancialInstitution.getBICID().getValue();
	}

	@Override
	public void setPaymentServiceProviderID(BICId bic) {
		if(bic==null) return;
		payeeSpecifiedCreditorFinancialInstitution.setBICID(CrossIndustryInvoice.newIDType(bic));
		//payeeSpecifiedCreditorFinancialInstitution.setAustralianBSBID(value);
//		payeeSpecifiedCreditorFinancialInstitution.setAustrianBankleitzahlID(value); //  durch IBAN abgelöst
		//payeeSpecifiedCreditorFinancialInstitution.setCanadianPaymentsAssociationID(value);
		// ...
	}

	@Override
	public void setPaymentServiceProviderID(String id) {
		if(id==null) return;
		payeeSpecifiedCreditorFinancialInstitution.setBICID(new Identifier(id));	
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[CREDIT TRANSFER PaymentAccountID (BG-17.BT-84):");
		stringBuilder.append(getPaymentAccountID()==null ? "null" : getPaymentAccountID());
		stringBuilder.append(", PaymentAccountName:");
		stringBuilder.append(getPaymentAccountName()==null ? "null" : getPaymentAccountName());
		stringBuilder.append(", PaymentServiceProviderID:");
		stringBuilder.append(getPaymentServiceProviderID()==null ? "null" : getPaymentServiceProviderID());
		stringBuilder.append(", DIRECT DEBIT DebitedAccountID (BG-19.BT-91):");
		stringBuilder.append(getDebitedAccountID()==null ? "null" : getDebitedAccountID());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

// ---------------- implements DirectDebit:
	Identifier directDebitMandate = null;
	
	// BG-19.BT-89
	@Override
	public String getMandateReferencetID() {
//		LOG.info("TODO Auto-generated method stub");
		return directDebitMandate==null? null : directDebitMandate.getValue();
	}

	@Override
	public void setMandateReferencetID(String id) {
		directDebitMandate = new Identifier(id);
	}
	public void setMandateReferencetID(Identifier id) {
		directDebitMandate = id;
	}

	// BG-19.BT-90 +++ 0..1 Bank assigned creditor identifier, CreditorReferenceID, Kennung des Gläubigers
	// Hinweis: Wird verwendet, um den Käufer vorweg über eine SEPA-Lastschrift in Kenntnis zu setzen.
	@Override
	public String getBankAssignedCreditorID() {
		LOG.info("TODO Auto-generated method stub");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBankAssignedCreditorID(String id) {
		// TODO Auto-generated method stub
		
	}

	// BG-19.BT-91
	@Override
	public String getDebitedAccountID() {
		if(payerPartyDebtorFinancialAccount==null) return null;
		if(payerPartyDebtorFinancialAccount.getIBANID()!=null) {
			return payerPartyDebtorFinancialAccount.getIBANID().getValue();
		}
		return payerPartyDebtorFinancialAccount.getProprietaryID()==null ? null : payerPartyDebtorFinancialAccount.getProprietaryID().getValue();
	}

	@Override
	public void setDebitedAccountID(String id) {
		if(id==null) return;
		payerPartyDebtorFinancialAccount.setIBANID(new Identifier(id));		
	}

	@Override
	public void setDebitedAccountID(IBANId iban) { // use ctor
		if(iban==null) return;
		payerPartyDebtorFinancialAccount.setIBANID(new Identifier(iban.getValue(), iban.getSchemeID()));		
	}

}
