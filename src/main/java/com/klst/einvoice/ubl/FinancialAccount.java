package com.klst.einvoice.ubl;

import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.BranchType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;

// Gruppe CREDIT TRANSFER                   BG-17
public class FinancialAccount extends FinancialAccountType implements CreditTransfer {

	FinancialAccount() {
		super();
	}
	
	// copy ctor
	public FinancialAccount(FinancialAccountType doc) {
		this();
		setPaymentAccountID(doc.getID().getValue());
		setPaymentAccountName(doc.getName()==null ? null : doc.getName().getValue());
		setPaymentServiceProviderID(getPaymentServiceProviderID(doc));
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

//	----------------------------- implements CreditTransfer:
	
	@Override
	public String getPaymentAccountID() {
		return super.getID().getValue();
	}

	@Override
	public void setPaymentAccountID(IBANId iban) {
		super.setID(Invoice.newIDType(iban.getValue(), iban.getSchemeID()));
	}

	@Override
	public void setPaymentAccountID(String id) {
		super.setID(Invoice.newIDType(id, null));	
	}

	@Override
	public String getPaymentAccountName() {
		return super.getName()==null ? null : super.getName().getValue();
	}

	@Override
	public void setPaymentAccountName(String name) {
		if(name==null) return; // optional
		NameType n = new NameType();
		n.setValue(name);
		super.setName(n);
	}

	@Override
	public String getPaymentServiceProviderID() {
		return getPaymentServiceProviderID(this);
	}
	static String getPaymentServiceProviderID(FinancialAccountType doc) {
		BranchType branch = doc.getFinancialInstitutionBranch();
		if(branch==null) return null;
		// bei pepol ist noch element FinancialInstitution
		return branch.getID()==null ? branch.getFinancialInstitution().getID().getValue() : branch.getID().getValue();
	}

	@Override
	public void setPaymentServiceProviderID(BICId id) {
		setPaymentServiceProviderID(id.getValue(), id.getSchemeID());
	}

	@Override
	public void setPaymentServiceProviderID(String id) {
		setPaymentServiceProviderID(id, null);
	}
	void setPaymentServiceProviderID(String id, String schema) {
		if(id==null) return; // optional
		// so ist es bei pepol:
//		FinancialInstitutionType fi = new FinancialInstitutionType();
//		fi.setID(Invoice.newIDType(id, schema));
//		BranchType branch = new BranchType();
//		branch.setFinancialInstitution(fi);
		// ... und so bei xrechnung:
		BranchType branch = new BranchType();
		branch.setID(Invoice.newIDType(id, schema));
		super.setFinancialInstitutionBranch(branch);
	}

}
