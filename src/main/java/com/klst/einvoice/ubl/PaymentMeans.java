package com.klst.einvoice.ubl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.untdid.codelist.PaymentMeansEnum;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMandateType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstructionNoteType;
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

Bsp: ubl-tc434-example1.xml       hat mehrere cac:PaymentMeans

Bsp: ubl-tc434-example5.xml       direct debit
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>49</cbc:PaymentMeansCode>
        <cbc:InstructionNote>Half prepaid</cbc:InstructionNote>
        <cbc:PaymentID>Payref1</cbc:PaymentID>
        <cac:PaymentMandate>
            <cbc:ID>123456</cbc:ID>
            <cac:PayerFinancialAccount>
                <cbc:ID>DK1212341234123412</cbc:ID>
            </cac:PayerFinancialAccount>
        </cac:PaymentMandate>
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
public class PaymentMeans extends PaymentMeansType implements PaymentInstructions {

	private static final Logger LOG = Logger.getLogger(PaymentMeans.class.getName());
	
	PaymentMeans() {
		super();
	}
	
	// copy ctor
	public PaymentMeans(PaymentMeansType doc) {
		this();
//		String paymentMeansText = doc.getInstructionNote().isEmpty() ? null : doc.getInstructionNote().get(0).getValue();
		String paymentMeansText = getPaymentMeansText(doc);
		String remittanceInformation = getRemittanceInformation(doc);
				// doc.getPaymentID().isEmpty() ? null : doc.getPaymentID().get(0).getValue();
		init(PaymentMeansEnum.valueOf(doc.getPaymentMeansCode()), paymentMeansText, remittanceInformation);
		LOG.info("ctor vor new FinancialAccount: "+this.toString() + " remittanceInformation:"+remittanceInformation);
		if(doc.getPayeeFinancialAccount()==null) {
			// kann null sein, zB. in ubl-tc434-example5.xml bei DirectDebit
		} else {
			payeeFinancialAccount = new FinancialAccount(doc.getPayeeFinancialAccount());
			super.setPayeeFinancialAccount(payeeFinancialAccount);
		}
		if(doc.getPaymentMandate()==null) {
			// kein DirectDebit
		} else {
			paymentMandate = new PaymentMandate(doc.getPaymentMandate());
			super.setPaymentMandate(paymentMandate);
		}
	}
	
	FinancialAccountType payeeFinancialAccount;
	PaymentMandateType paymentMandate;
	
	public PaymentMeans(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation,
			List<CreditTransfer> creditTransferList, PaymentCard paymentCard, DirectDebit directDebit) {
		this();
		init(code, paymentMeansText, remittanceInformation);
		if(creditTransferList.isEmpty() && paymentCard==null && directDebit==null) return;
		
		payeeFinancialAccount = new FinancialAccount();
		paymentMandate = new PaymentMandate();
		creditTransferList.forEach(creditTransfer -> {
			payeeFinancialAccount = (FinancialAccount)creditTransfer;
			super.setPayeeFinancialAccount(payeeFinancialAccount);
		});
		if(paymentCard!=null) {
			// TODO
		}
		if(directDebit!=null) {
			paymentMandate = (PaymentMandate)directDebit;
			super.setPaymentMandate(paymentMandate);
		}
	}

	void init(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation) {
		setPaymentMeans(code, paymentMeansText);
		setRemittanceInformation(remittanceInformation);
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append(getPaymentMeansEnum()==null ? "null" : getPaymentMeansEnum().getValueAsString());
		stringBuilder.append(", PaymentMeansText:");
		stringBuilder.append(getPaymentMeansText()==null ? "null" : getPaymentMeansText());
		stringBuilder.append(", RemittanceInformation:");
		stringBuilder.append(getRemittanceInformation()==null ? "null" : getRemittanceInformation());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

//	----------------------------- implements PaymentInstructions:
	/* 
	 * 
	 * @param code BT-81 1..1 Code für die Zahlungsart
	 * @param text BT-82 0..1 Text zur Zahlungsart
	 */
	@Override
	public void setPaymentMeans(PaymentMeansEnum code, String text) {
		setPaymentMeansEnum(code);
		setPaymentMeansText(text);
	}
	
	@Override
	// BT-81 1..1 Code für die Zahlungsart
	public void setPaymentMeansEnum(PaymentMeansEnum code) {
		PaymentMeansCodeType paymentMeansCodeValue = new PaymentMeansCodeType();
		paymentMeansCodeValue.setValue(code.getValueAsString());
		super.setPaymentMeansCode(paymentMeansCodeValue);
	}

	// BT-82 0..1 Text zur Zahlungsart
	void setPaymentMeansText(String text) {
		if(text==null) return; // optional
		// Bsp: ubl-tc434-example5.xml
		InstructionNoteType instructionNote = new InstructionNoteType();
		instructionNote.setValue(text);
		super.getInstructionNote().add(instructionNote);
	}
	
	@Override
	// BT-83 0..1 Verwendungszweck
	public void setRemittanceInformation(String text) {
		if(text==null) return; // optional, Bsp in 
		// 01.14a-INVOICE_ubl.xml : <cbc:PaymentID>Deb. 12345 / Fact. 9876543</cbc:PaymentID>
		// 01.15a-INVOICE_ubl.xml : <cbc:PaymentID>0000123456</cbc:PaymentID>
		List<PaymentIDType> paymentIDs = super.getPaymentID();
		PaymentIDType paymentID = new PaymentIDType();
		paymentID.setValue(text);
		paymentIDs.add(paymentID);
	}
	
	@Override
	public PaymentMeansEnum getPaymentMeansEnum() {
		CodeType paymentMeansCode = super.getPaymentMeansCode();
		return PaymentMeansEnum.valueOf(paymentMeansCode);
	}
	static PaymentMeansEnum getPaymentMeansEnum(PaymentMeansType doc) {
		CodeType paymentMeansCode = doc.getPaymentMeansCode();
		return PaymentMeansEnum.valueOf(paymentMeansCode);
	}

	@Override
	public String getPaymentMeansText() {
		return super.getInstructionNote().isEmpty() ? null : super.getInstructionNote().get(0).getValue();
	}
	static String getPaymentMeansText(PaymentMeansType doc) {
		return doc.getInstructionNote().isEmpty() ? null : doc.getInstructionNote().get(0).getValue();
	}

	@Override
	public String getRemittanceInformation() {
		return super.getPaymentID().isEmpty() ? null : getRemittanceInformationList().get(0);
	}
	List<String> getRemittanceInformationList() {
		List<PaymentIDType> paymentIDs = super.getPaymentID();
		List<String> result = new ArrayList<String>(paymentIDs.size());
		paymentIDs.forEach(paymentID -> {
			result.add(paymentID.getValue());
		});
		return result;
	}
	static String getRemittanceInformation(PaymentMeansType doc) {
		return doc.getPaymentID().isEmpty() ? null : doc.getPaymentID().get(0).getValue();
	}
	
	// CreditTransfer ist Interface, List da BG-17 CREDIT TRANSFER die Kardinalität 0..n hat
	@Override
	public void addCreditTransfer(CreditTransfer creditTransfer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CreditTransfer> getCreditTransfer() { 
		List<CreditTransfer> result = new ArrayList<CreditTransfer>();
		if(payeeFinancialAccount==null) {
			// LOG
		} else {
			// add interface CreditTransfer
			// FinancialAccount extends FinancialAccountType implements CreditTransfer
//			LOG.info("PaymentMeansCode:"+getPaymentMeansCode() + " ID:"+payeeFinancialAccount.getID());
			result.add((FinancialAccount)payeeFinancialAccount);
		}
		return result;
	}
	
	// DirectDebit ist Interface, kein List da BG-19 die Kardinalität 0..1 hat
	@Override
	public void setDirectDebit(DirectDebit directDebit) {
		// TODO Auto-generated method stub
		
	}

	public DirectDebit getDirectDebit() { 
		return paymentMandate==null ? null : (DirectDebit)paymentMandate;
	}

}
