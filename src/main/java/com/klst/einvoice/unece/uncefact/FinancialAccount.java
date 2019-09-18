package com.klst.einvoice.unece.uncefact;

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
keine Testfälle für DIRECT DEBIT
 */
public class FinancialAccount implements CreditTransfer, DirectDebit {

	CreditorFinancialAccountType payeePartyCreditorFinancialAccount = null;
	CreditorFinancialInstitutionType payeeSpecifiedCreditorFinancialInstitution = null;
	DebtorFinancialAccountType payerPartyDebtorFinancialAccount = null;
	
	FinancialAccount(TradeSettlementPaymentMeansType tradeSettlementPaymentMeans) {
		super();
		payeePartyCreditorFinancialAccount = tradeSettlementPaymentMeans.getPayeePartyCreditorFinancialAccount();
		payeeSpecifiedCreditorFinancialInstitution = tradeSettlementPaymentMeans.getPayeeSpecifiedCreditorFinancialInstitution();
		payerPartyDebtorFinancialAccount = tradeSettlementPaymentMeans.getPayerPartyDebtorFinancialAccount();
		//tradeSettlementPaymentMeans.getPayerSpecifiedDebtorFinancialInstitution();
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
		payeePartyCreditorFinancialAccount.setProprietaryID(CrossIndustryInvoice.newIDType(accountId, null));		
	}

	@Override
	public String getPaymentAccountName() {
		if(payeePartyCreditorFinancialAccount==null) return null;
		return payeePartyCreditorFinancialAccount.getAccountName()==null ? null : payeePartyCreditorFinancialAccount.getAccountName().getValue();
	}

	@Override
	public void setPaymentAccountName(String name) {
		if(name==null) return;
		payeePartyCreditorFinancialAccount.setAccountName(CrossIndustryInvoice.newTextType(name));		
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
	}

	@Override
	public void setPaymentServiceProviderID(String id) {
		if(id==null) return;
		payeeSpecifiedCreditorFinancialInstitution.setBICID(CrossIndustryInvoice.newIDType(id, null));	
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
	@Override
	public String getMandateReferencetID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMandateReferencetID(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getBankAssignedCreditorID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBankAssignedCreditorID(String id) {
		// TODO Auto-generated method stub
		
	}

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDebitedAccountID(IBANId iban) { // use ctor
		if(iban==null) return;
		payerPartyDebtorFinancialAccount.setIBANID(CrossIndustryInvoice.newIDType(iban));		
	}

}
