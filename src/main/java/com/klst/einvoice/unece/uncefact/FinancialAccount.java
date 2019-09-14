package com.klst.einvoice.unece.uncefact;

import com.klst.einvoice.CreditTransfer;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.CreditorFinancialAccountType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.CreditorFinancialInstitutionType;

//Gruppe CREDIT TRANSFER                   BG-17
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

 */
public class FinancialAccount implements CreditTransfer {

	CreditorFinancialAccountType payeePartyCreditorFinancialAccount;
	CreditorFinancialInstitutionType payeeSpecifiedCreditorFinancialInstitution;
	
	FinancialAccount() {
		super();
		payeePartyCreditorFinancialAccount = new CreditorFinancialAccountType();
		payeeSpecifiedCreditorFinancialInstitution = new CreditorFinancialInstitutionType();
	}
	
	public FinancialAccount(IBANId iban, String accountName, BICId bic) {
		this();
		setPaymentAccountID(iban);
		setPaymentAccountName(accountName);
		setPaymentServiceProviderID(bic);
	}

	public FinancialAccount(String accountId, String accountName, BICId bic) {
		this();
		setPaymentAccountID(accountId);
		setPaymentAccountName(accountName);
		setPaymentServiceProviderID(bic);
	}

	@Override
	public String getPaymentAccountID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPaymentAccountID(IBANId iban) { // use ctor
		payeePartyCreditorFinancialAccount.setIBANID(CrossIndustryInvoice.newIDType(iban));		
	}

	@Override
	public void setPaymentAccountID(String accountId) {
		payeePartyCreditorFinancialAccount.setProprietaryID(CrossIndustryInvoice.newIDType(accountId, null));		
	}

	@Override
	public String getPaymentAccountName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPaymentAccountName(String name) {
		if(name==null) return;
		payeePartyCreditorFinancialAccount.setAccountName(CrossIndustryInvoice.newTextType(name));		
	}

	@Override
	public String getPaymentServiceProviderID() {
		// TODO Auto-generated method stub
		return null;
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

}
