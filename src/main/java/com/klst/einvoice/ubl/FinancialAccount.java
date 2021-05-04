package com.klst.einvoice.ubl;

import java.util.logging.Logger;

import com.klst.einvoice.api.CreditTransfer;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.BranchType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;

// Gruppe CREDIT TRANSFER                   BG-17
public class FinancialAccount extends FinancialAccountType implements CreditTransfer {

	private static final Logger LOG = Logger.getLogger(FinancialAccount.class.getName());

	PaymentMeans paymentMeans;

	private FinancialAccount(FinancialAccountType doc) {
		super();
		if(doc!=null) {
			super.setID(doc.getID());
			super.setName(doc.getName());
			super.setAliasName(doc.getAliasName());
			super.setAccountTypeCode(doc.getAccountTypeCode());
			super.setAccountFormatCode(doc.getAccountFormatCode());
			super.setCurrencyCode(doc.getCurrencyCode());
			super.paymentNote = doc.getPaymentNote();
			super.setFinancialInstitutionBranch(doc.getFinancialInstitutionBranch());
			super.setCountry(doc.getCountry());
		}
	}
	FinancialAccount(PaymentMeans pm) {
		this(pm.getPayeeFinancialAccount());
		LOG.config("pm"+pm);
		paymentMeans = pm;
		LOG.config("ctor:"+this);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(getPaymentAccountID()==null ? "null" : getPaymentAccountID());
		
		stringBuilder.append(", paymentMeans:").append(paymentMeans);

		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	public PaymentMeans getPaymentMeans() {
		return paymentMeans;
	}
	
	public FinancialAccount(IBANId iban, String accountName, BICId bic) {
		setPaymentAccountID(iban);
		setPaymentAccountName(accountName);
		setPaymentServiceProviderID(bic);
	}
	
	public FinancialAccount(String accountId, String accountName, BICId bic) {
		setPaymentAccountID(accountId);
		setPaymentAccountName(accountName);
		setPaymentServiceProviderID(bic);
	}

//	----------------------------- implements CreditTransfer:
	
	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CreditTransfer#getPaymentAccountID()
	 */
	@Override
	public String getPaymentAccountID() {
		return super.getID()==null ? null : getID().getValue();
	}

	@Override
	// 1..1 BT-84   IBANID        Kennung des Zahlungskontos
	public void setPaymentAccountID(IBANId iban) {
		super.setID(new ID(iban.getValue())); // wg. https://github.com/klst-de/e-invoice/issues/7 ohne iban.getSchemeID()));
	}

	@Override
	public void setPaymentAccountID(String id) {
		super.setID(new ID(id));	
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CreditTransfer#getPaymentAccountName()
	 */
	@Override
	public String getPaymentAccountName() {
		return super.getName()==null ? null : super.getName().getValue();
	}

	@Override
	// BT-85 0..1 Payment account name, AccountName, Name des Zahlungskontos
	public void setPaymentAccountName(String name) {
		if(name==null) return; // optional
		NameType n = new NameType();
		n.setValue(name);
		super.setName(n);
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.CreditTransfer#getPaymentServiceProviderID()
	 */
	@Override
	public String getPaymentServiceProviderID() {
		return getPaymentServiceProviderID(this);
	}
	static String getPaymentServiceProviderID(FinancialAccountType doc) {
		BranchType branch = doc.getFinancialInstitutionBranch();
		if(branch==null) return null;
		// bei PEPPOL ist noch element FinancialInstitution
		return branch.getID()==null ? branch.getFinancialInstitution().getID().getValue() : branch.getID().getValue();
	}

	@Override
	// BT-86 0..1 Payment service provider identifier, BICID,  Kennung des Zahlungsdienstleisters
	public void setPaymentServiceProviderID(BICId id) {
		if(id==null) return; // optional
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
		branch.setID(new ID(id, schema));
		super.setFinancialInstitutionBranch(branch);
	}

}
