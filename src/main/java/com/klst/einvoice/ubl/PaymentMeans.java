package com.klst.einvoice.ubl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.unece.uncefact.BICId;
import com.klst.einvoice.unece.uncefact.IBANId;
import com.klst.untdid.codelist.PaymentMeansCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionNoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentChannelCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentMeansCodeType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.CodeType;

/* PAYMENT INSTRUCTIONS                        BG-16                       1 (mandatory) 
 * Eine Gruppe von Informationselementen, die Informationen darüber liefern, wie die Zahlung erfolgen soll.

Name                                        ID    Semantischer Datentyp Anz. 
Payment means type code                     BT-81 Code                  1 
Payment means text                          BT-82 Text                  0..1
Remittance information                      BT-83 Text                  0..1
Ein Textwert, der zur Verknüpfung der Zahlung mit der vom Verkäufer ausgestellten Rechnung verwendet wird.
Anmerkung: Die Angabe eines Verwendungszwecks hilft dem Verkäufer bei der Zuweisung einer eingehenden
Zahlung zum jeweiligen Zahlungsprozess. Wenn Remittance information in der Rechnung übermittelt wurde, sollte
diese daher bei der Zahlung genutzt werden.

CREDIT TRANSFER                             BG-17                       0..*
Eine Gruppe von Informationselementen, die Informationen über das Bankkonto geben, auf das die Überweisung
zu leisten ist. Die Gruppe ist alternativ zu „PAYMENT CARD INFORMATION“ (BG-18) oder zu „DIRECT DEBIT“
(BG-19) anzugeben, wenn eine Zahlung per Überweisung erfolgen soll.

PAYMENT CARD INFORMATION                    BG-18                       0..1
Eine Gruppe von Informationselementen, die Informationen über die für die Zahlung genutzte Karte liefern. Die Gruppe
ist alternativ zu „DIRECT DEBIT“ (BG-19) (Lastschrift mit Vorliegen einer Mandatsreferenz) oder zu „CREDIT
TRANSFER“ (BG-17) (Überweisung) anzugeben, wenn eine Zahlung per Zahlungskarte/Kreditkarte erfolgte.

DIRECT DEBIT                                BG-19                       0..1 
Eine Gruppe von Informationselementen, die spezifische Informationen über die vorgesehene Lastschrift geben.
Die Gruppe ist alternativ zu „CREDIT TRANSFER“ (BG-17) oder zu „PAYMENT CARD INFORMATION“ (BG-18)
anzugeben, wenn ein Mandat erteilt wurde und der Rechnungsbetrag per Lastschrift beglichen werden soll.

Bsp: ubl001.xml :
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>		<!-- CreditTransfer 	(30), -->
        <cbc:PaymentID>Deb. 10202 / Fact. 12115118</cbc:PaymentID>
        <cac:PayeeFinancialAccount>
            <cbc:ID>NL57 RABO 0107307510</cbc:ID>
        </cac:PayeeFinancialAccount>
    </cac:PaymentMeans>
    
Bsp: 01.15a-INVOICE_ubl.xml :
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>
        <cbc:PaymentID>0000123456</cbc:PaymentID>
        <cac:PayeeFinancialAccount>
            <cbc:ID>DE12123000001234567890</cbc:ID>
            <cbc:Name>[Payment account name]</cbc:Name>
            <cac:FinancialInstitutionBranch>
                <cbc:ID>[BIC]</cbc:ID>
            </cac:FinancialInstitutionBranch>
        </cac:PayeeFinancialAccount>
    </cac:PaymentMeans>


Bsp: example-peppol-ubl-creditnote.xml :
  <cac:PaymentMeans>
    <!-- Kontoverbindung -->
    <cbc:PaymentMeansCode>31</cbc:PaymentMeansCode>         <!-- DebitTransfer 		(31), -->
    <cbc:PaymentChannelCode>IBAN</cbc:PaymentChannelCode>
    <cac:PayeeFinancialAccount>
      <cbc:ID schemeID="IBAN">AT611904300234573201</cbc:ID>
      <cac:FinancialInstitutionBranch>
        <cac:FinancialInstitution>
          <cbc:ID schemeID="BIC">TUVTAT21</cbc:ID>
        </cac:FinancialInstitution>
      </cac:FinancialInstitutionBranch>
    </cac:PayeeFinancialAccount>
  </cac:PaymentMeans>

Bsp: miad :
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>
        <cbc:PaymentID>TODO Verwendungszweck</cbc:PaymentID>
        <cac:PayeeFinancialAccount>
            <cbc:ID schemeID="IBAN">DE-----------100</cbc:ID>
        </cac:PayeeFinancialAccount>
    </cac:PaymentMeans>

 */
public class PaymentMeans extends PaymentMeansType implements // TODO PaymentInstructions, 
CreditTransfer {

	private static final Logger LOG = Logger.getLogger(PaymentMeans.class.getName());
	
	PaymentMeans() {
		super();
	}
	
	// copy ctor
	public PaymentMeans(PaymentMeansType paymentMeans) {
		this(PaymentMeansCode.valueOf(paymentMeans.getPaymentMeansCode()), paymentMeans.getPayeeFinancialAccount());
		LOG.info("ctor vor setPaymentIDs:"+this.toString());
		setPaymentIDs(paymentMeans.getPaymentID());
	}
	
	FinancialAccountType payeeFinancialAccount;
	
	public PaymentMeans(PaymentMeansCode code, String paymentMeansText, String remittanceInformation,
			List<CreditTransfer> creditTransferList, PaymentCard paymentCard, DirectDebit directDebit) {
		this();
		init(code, paymentMeansText, remittanceInformation);
		if(creditTransferList.isEmpty() && paymentCard==null && directDebit==null) return;
		
		payeeFinancialAccount = new FinancialAccountType();
		creditTransferList.forEach(creditTransfer -> {
			// TODO
		});
		if(paymentCard!=null) {
			// TODO
		}
		if(directDebit!=null) {
			// TODO
		}
	}

	void init(PaymentMeansCode code, String paymentMeansText, String remittanceInformation) {
		
	}
	
	public PaymentMeans(PaymentMeansCode paymentMeansCode, FinancialAccountType financialAccount) {
		this(paymentMeansCode, financialAccount, null);
	}
	
	PaymentMeans(PaymentMeansCode paymentMeansCode, FinancialAccountType financialAccount, String remittanceInformation) {
		this();
		
		PaymentMeansCodeType paymentMeansCodeValue = new PaymentMeansCodeType();
		// Payment means type code                     BT-81 Code                  1 (mandatory)
		//  Das als Code ausgedrückte erwartete oder genutzte Zahlungsmittel:
		paymentMeansCodeValue.setValue(paymentMeansCode.getValueAsString());
		super.setPaymentMeansCode(paymentMeansCodeValue);
		
		LOG.info("!!!!!!!!!!!! FinancialAccountType.ID:"+ (financialAccount.getID()==null ? null : financialAccount.getID().getValue()));
		LOG.info("!!!!!!!!!!!! FinancialAccountType.FinancialInstitutionBranch:"+ (financialAccount.getFinancialInstitutionBranch()==null ? null 
				: financialAccount.getFinancialInstitutionBranch().getFinancialInstitution()));
		FinancialAccountType fa = new FinancialAccount(financialAccount);
//		if(financialAccount.getID()!=null) {
//			fa.setID(Invoice.newIDType(financialAccount.getID().getValue(), financialAccount.getID().getSchemeID()));	
//		}
		super.setPayeeFinancialAccount(fa);

		// Remittance information                      BT-83 Text                  0..1 optional
		// Ein Textwert, der zur Verknüpfung der Zahlung mit der vom Verkäufer ausgestellten Rechnung verwendet wird.
		if(remittanceInformation!=null) {
			List<PaymentIDType> paymentIDs = super.getPaymentID();
			PaymentIDType paymentID = new PaymentIDType();
			paymentID.setValue(remittanceInformation);
			paymentIDs.add(paymentID);
		}
	}

	void setPaymentIDs(List<PaymentIDType> paymentIDs) {
		List<PaymentIDType> myPaymentIDs = super.getPaymentID();
		paymentIDs.forEach(paymentID -> {
			myPaymentIDs.add(paymentID);
		});
	}
	
	public PaymentMeansCode getPaymentMeans() {
		CodeType paymentMeansCode = super.getPaymentMeansCode();
		return PaymentMeansCode.valueOf(paymentMeansCode);
	}
	
	public FinancialAccountType getFinancialAccount() {
		return super.getPayeeFinancialAccount();
	}
	

	public String toString() {
		List<PaymentIDType> paymentIDList = super.getPaymentID();
		String paymentIDs = paymentIDList.isEmpty() ? null : ("#="+paymentIDList.size() + ","+paymentIDList.get(0).getValue()+",...");
		PaymentChannelCodeType paymentChannelCode = super.getPaymentChannelCode();
		String channelCode = paymentChannelCode==null ? null : paymentChannelCode.getValue();
		FinancialAccountType fa = super.getPayerFinancialAccount();
		String financialAccount = fa==null ? null : (fa.getID()==null ? null : fa.getID().getValue());
		return "Code:"+getPaymentMeans().getValueAsString() + ", paymentIDs:"+paymentIDs + 
				", paymentChannelCode:"+channelCode + ", financialAccount:"+financialAccount;
	}

//	----------------------------- implements PaymentInstructions:
	/* 
	 * 
	 * @param code BT-81 1..1 Code für die Zahlungsart
	 * @param text BT-82 0..1 Text zur Zahlungsart
	 */
	public void setPaymentMeans(PaymentMeansCode code, String text) {
		setPaymentMeans(code);
		setPaymentMeansText(text);
	}
	
	// BT-81 1..1 Code für die Zahlungsart
	void setPaymentMeans(PaymentMeansCode code) {
		PaymentMeansCodeType paymentMeansCodeValue = new PaymentMeansCodeType();
		paymentMeansCodeValue.setValue(code.getValueAsString());
		super.setPaymentMeansCode(paymentMeansCodeValue);
	}
	
	// BT-82 0..1 Text zur Zahlungsart
	void setPaymentMeansText(String text) {
		if(text==null) return; // optional
		// TODO überprüfen ob InstructionNote das korrekte element ist!!!!!!!!!
		InstructionNoteType instructionNote = new InstructionNoteType();
		instructionNote.setValue(text);
		super.getInstructionNote().add(instructionNote);
	}
	
	public void setRemittanceInformation(String text) {
		if(text==null) return; // optional, Bsp in 01.14a-INVOICE_ubl.xml : <cbc:PaymentID>Deb. 12345 / Fact. 9876543</cbc:PaymentID>
		// 01.15a-INVOICE_ubl.xml : <cbc:PaymentID>0000123456</cbc:PaymentID>
		List<PaymentIDType> paymentIDs = super.getPaymentID();
		PaymentIDType paymentID = new PaymentIDType();
		paymentID.setValue(text);
		paymentIDs.add(paymentID);
	}
	
//	@Override
//	public PaymentMeansCode getPaymentMeansCode() { // TODO muss umbenannt werden
//		// The return type is incompatible with PaymentMeansType.getPaymentMeansCode()
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setPaymentMeansCode(PaymentMeansCode code) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public String getPaymentMeansText() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getRemittanceInformation() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public List<String> getRemittanceInformation() { // TODO raus
		List<PaymentIDType> paymentIDs = super.getPaymentID();
		List<String> result = new ArrayList<String>(paymentIDs.size());
		paymentIDs.forEach(paymentID -> {
			result.add(paymentID.getValue());
		});
		return result;
	}

//	----------------------------- implements CreditTransfer:
	
	public List<CreditTransfer> getCreditTransfer() {
		FinancialAccountType payeeFinancialAccount = super.getPayeeFinancialAccount(); // PayeeFinancialAccount
		return null;
		// TODO;  ?? doch noch ein FinancialAccount extends FinancialAccountType ?
	}
	
	@Override
	public String getPaymentAccountID() {
		FinancialAccountType payeeFinancialAccount = super.getPayeeFinancialAccount(); 
		if(payeeFinancialAccount==null) return null;
		return payeeFinancialAccount.getID().getValue();
	}

	@Override
	public void setPaymentAccountID(IBANId iban) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPaymentAccountID(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPaymentAccountName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPaymentAccountName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPaymentServiceProviderID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPaymentServiceProviderID(BICId id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPaymentServiceProviderID(String id) {
		// TODO Auto-generated method stub
		
	}

}
