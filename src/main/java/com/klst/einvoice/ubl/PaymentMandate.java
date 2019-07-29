package com.klst.einvoice.ubl;

import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.unece.uncefact.IBANId;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMandateType;

// Gruppe DIRECT DEBIT BG-19 
//0 .. 1 DirectDebitMandateID Kennung der Mandatsreferenz               BG-19/ BT-89
//0 .. 1 CreditorReferenceID Kennung des Gläubigers                     BG-19/ BT-90
//1 .. 1 IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos BG-19/ BT-91
public class PaymentMandate extends PaymentMandateType implements DirectDebit {

	PaymentMandate() {
		super();
	}
	
	// copy ctor
	public PaymentMandate(PaymentMandateType doc) {
		this();
		setMandateReferencetID(doc.getID()==null ? null : doc.getID().getValue());
//		getBankAssignedCreditorID(doc.getID().getValue()); TODO
		setDebitedAccountID(getDebitedAccountID(doc));
	}
	
	public PaymentMandate(IBANId iban) {
		setDebitedAccountID(iban);
	}

	public PaymentMandate(String accountId) {
		setDebitedAccountID(accountId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.DirectDebit#getMandateReferencetID()
	 */
	@Override
	public String getMandateReferencetID() {
		return super.getID()==null ? null : super.getID().getValue();
	}

	@Override
	public void setMandateReferencetID(String id) {
		super.setID(Invoice.newIDType(id, null));	
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.DirectDebit#getBankAssignedCreditorID()
	 */
	@Override
	public String getBankAssignedCreditorID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBankAssignedCreditorID(String id) {
		// TODO Auto-generated method stub  ??? setPayerParty
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.DirectDebit#getDebitedAccountID()
	 */
	@Override
	public String getDebitedAccountID() {
		return super.getID().getValue();
	}
	static String getDebitedAccountID(PaymentMandateType doc) {
		FinancialAccountType fa = doc.getPayerFinancialAccount();
		if(fa==null) return null;
		return fa.getID()==null ? null : fa.getID().getValue();
	}

	@Override
	public void setDebitedAccountID(String id) {
		FinancialAccountType fa = new FinancialAccountType();
		fa.setID(Invoice.newIDType(id, null));
		super.setPayerFinancialAccount(fa);
	}

	@Override
	public void setDebitedAccountID(IBANId iban) {
		FinancialAccountType fa = new FinancialAccountType();
		fa.setID(Invoice.newIDType(iban.getValue(), iban.getSchemeID()));
		super.setPayerFinancialAccount(fa);
	}

}
