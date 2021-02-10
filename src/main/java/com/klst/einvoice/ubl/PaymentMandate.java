package com.klst.einvoice.ubl;

import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.DirectDebitFactory;
import com.klst.einvoice.unece.uncefact.IBANId;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMandateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;

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

Bsp. 04.02a : ähnlich wie 03.01a

Bsp. ubl-tc434-example5.xml :

    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>49</cbc:PaymentMeansCode>    <!-- BG-16.BT-81 --> 49:Direct debit NONSEPA
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
public class PaymentMandate extends PaymentMandateType implements DirectDebit, DirectDebitFactory {

	// implements PaymentCardFactory
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, IBANId iban) {
		return create(mandateID, bankAssignedCreditorID, iban);
	}
	static PaymentMandate create(String mandateID, String bankAssignedCreditorID, IBANId iban) {
		return new PaymentMandate(mandateID, bankAssignedCreditorID, iban);
	}
	
	public DirectDebit createDirectDebit(String mandateID, String bankAssignedCreditorID, String debitedAccountID) {
		return create(mandateID, bankAssignedCreditorID, debitedAccountID);
	}
	static PaymentMandate create(String mandateID, String bankAssignedCreditorID, String debitedAccountID) {
		return new PaymentMandate(mandateID, bankAssignedCreditorID, debitedAccountID);
	}

	public PaymentMandate(PaymentMandateType doc) {
		super();
		if(doc!=null) {
			super.setID(doc.getID());
			super.setMandateTypeCode(doc.getMandateTypeCode());
			super.setMaximumPaymentInstructionsNumeric(doc.getMaximumPaymentInstructionsNumeric());
			super.setMaximumPaidAmount(doc.getMaximumPaidAmount());
			super.setSignatureID(doc.getSignatureID());
			super.setPayerParty(doc.getPayerParty());
			super.setPayerFinancialAccount(doc.getPayerFinancialAccount());
			super.setValidityPeriod(doc.getValidityPeriod());
			super.setPaymentReversalPeriod(doc.getPaymentReversalPeriod());
			super.clause = doc.getClause();
		}
	}
	
	public PaymentMandate(String mandateID, String bankAssignedCreditorID, IBANId iban) {
		setMandateReferencedID(mandateID);
		setBankAssignedCreditorID(bankAssignedCreditorID);
		setDebitedAccountID(iban);
	}

	public PaymentMandate(String mandateID, String bankAssignedCreditorID, String debitedAccountID) {
		setMandateReferencedID(mandateID);
		setBankAssignedCreditorID(bankAssignedCreditorID);
		setDebitedAccountID(debitedAccountID);
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.DirectDebit#getMandateReferencetID()
	 */
	// BG-19.BT-89 0..1
	@Override
	public String getMandateReferencedID() {
		return super.getID()==null ? null : super.getID().getValue();
	}

	@Override
	public void setMandateReferencedID(String id) {
		if(id==null) return;
		IDType iDType = new IDType();
		iDType.setValue(id);
		super.setID(iDType);	
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.DirectDebit#getBankAssignedCreditorID()
	 */
	// BG-19.BT-90 0..1
	@Override
	public String getBankAssignedCreditorID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBankAssignedCreditorID(String id) {
		if(id==null) return;
		// TODO Auto-generated method stub  ??? setPayerParty
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.einvoice.DirectDebit#getDebitedAccountID()
	 */
	// BG-19.BT-91 0..1
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
		if(id==null) return;
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
