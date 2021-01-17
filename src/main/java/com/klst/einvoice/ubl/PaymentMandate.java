package com.klst.einvoice.ubl;

import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.unece.uncefact.IBANId;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMandateType;

// Gruppe DIRECT DEBIT BG-19
// CII:
//0 .. 1 DirectDebitMandateID Kennung der Mandatsreferenz               BG-19/ BT-89
//0 .. 1 CreditorReferenceID Kennung des Gläubigers                     BG-19/ BT-90
//1 .. 1 IBANID Lastschriftverfahren: Kennung des zu belastenden Kontos BG-19/ BT-91
/* Gruppe DIRECT DEBIT BG-19

Bsp. 03.01a :

  <cac:PaymentMeans>
    <cbc:PaymentMeansCode>59</cbc:PaymentMeansCode>        <!-- BG-16.BT-81  59:SEPA direct debit -->
                                                           <!--              49:Direct debit      -->
    <cac:PaymentMandate>
      <cbc:ID>[Mandate reference identifier]</cbc:ID>      <!-- BG-19.BT-89 -->
      <cac:PayerFinancialAccount>
        <cbc:ID>DE75512108001245126199</cbc:ID>            <!-- BG-19.BT-91 -->
      </cac:PayerFinancialAccount>
    </cac:PaymentMandate>
  </cac:PaymentMeans>


Bsp. ubl-tc434-example5.xml :

    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>49</cbc:PaymentMeansCode>    <!-- BG-16.BT-81 -->
        <cbc:InstructionNote>Half prepaid</cbc:InstructionNote>
        <cbc:PaymentID>Payref1</cbc:PaymentID>             <!-- BG-16.BT-83 0..1 Verwendungszweck -->
        <cac:PaymentMandate>
            <cbc:ID>123456</cbc:ID>                        <!-- BG-19.BT-89 -->
            <cac:PayerFinancialAccount>
                <cbc:ID>DK1212341234123412</cbc:ID>        <!-- BG-19.BT-91 -->
            </cac:PayerFinancialAccount>
        </cac:PaymentMandate>
    </cac:PaymentMeans>


 */
public class PaymentMandate extends PaymentMandateType implements DirectDebit {

	static DirectDebit createDirectDebit(Object debitedAccountID) {
		return debitedAccountID.getClass()==IBANId.class ? new PaymentMandate((IBANId)debitedAccountID) : new PaymentMandate((String)debitedAccountID);
	}
	/**
	 * Factory method
	 * 
	 * @param mandateID
	 * @param bankAssignedCreditorID
	 * @param debitedAccountID
	 * @return DirectDebit if object
	 */
	public static DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, Object debitedAccountID) {
		DirectDebit directDebit = createDirectDebit(debitedAccountID); 
		directDebit.setMandateReferencedID(mandateID);
		directDebit.setBankAssignedCreditorID(bankAssignedCreditorID);
		return directDebit;
	}
	
	PaymentMandate() {
		super();
	}
	
	// copy ctor
	public PaymentMandate(PaymentMandateType doc) {
		this();
		setMandateReferencedID(doc.getID()==null ? null : doc.getID().getValue());
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
	public String getMandateReferencedID() {
		return super.getID()==null ? null : super.getID().getValue();
	}

	@Override
	public void setMandateReferencedID(String id) {
		super.setID(new ID(id));	
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
		return getDebitedAccountID(this);
	}
	static String getDebitedAccountID(PaymentMandateType doc) {
		FinancialAccountType fa = doc.getPayerFinancialAccount();
		if(fa==null) return null;
		return fa.getID()==null ? null : fa.getID().getValue();
	}

	@Override
	public void setDebitedAccountID(String id) {
		FinancialAccountType fa = new FinancialAccountType();
		fa.setID(new ID(id));
		super.setPayerFinancialAccount(fa);
	}

	@Override
	public void setDebitedAccountID(IBANId iban) {
		FinancialAccountType fa = new FinancialAccountType();
		fa.setID(new ID(iban.getValue(), iban.getSchemeID()));
		super.setPayerFinancialAccount(fa);
	}

	public String toString() {
		return "["
			+"MandateReferencetID="+this.getMandateReferencedID()
			+", BankAssignedCreditorID="+this.getBankAssignedCreditorID()
			+", DebitedAccountID="+this.getDebitedAccountID()
			+ "]";
	}
}
