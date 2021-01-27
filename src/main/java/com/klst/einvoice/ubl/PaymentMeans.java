package com.klst.einvoice.ubl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.BG19_DirectDebit;
import com.klst.einvoice.CreditTransfer;
import com.klst.einvoice.DirectDebit;
import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentInstructions;
import com.klst.einvoice.PaymentInstructionsFactory;
import com.klst.untdid.codelist.PaymentMeansEnum;

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
public class PaymentMeans extends PaymentMeansType implements PaymentInstructions, PaymentInstructionsFactory {
	
	// factories:
	@Override
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText,
			String remittanceInformation, List<CreditTransfer> creditTransfer, PaymentCard paymentCard,
			DirectDebit directDebit) {
		return create(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	static PaymentInstructions create(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation, 
			List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		if(creditTransfer!=null) {
			List<PaymentMeansType> list = new ArrayList<PaymentMeansType>();
			creditTransfer.forEach(ct -> {
				FinancialAccount fa = (FinancialAccount)ct;
				if(fa.getPaymentMeans()!=null) list.add(fa.getPaymentMeans());
			});
			if(!list.isEmpty()) create(list);
		}
		return new PaymentMeans(code, paymentMeansText, remittanceInformation, 
			creditTransfer, paymentCard, directDebit);
	}
	
	static PaymentInstructions create(PaymentMeansType pm) {
		return new PaymentMeans(pm, null);
	}
	
	// wegen der 0..n Beziehung zwischen BG-16 und BG-17 in EN16931!
	static PaymentInstructions create(List<PaymentMeansType> list) {
		if(list.isEmpty()) return null;
		PaymentMeans paymentMeans = new PaymentMeans(list.get(0), null);
		if(list.size()==1) {
			return paymentMeans;
		}
		LOG.fine("// bei mehreren Einträgen paymentMeans neu berechnen: ...");
		paymentMeans = new PaymentMeans(list);
//		LOG.info(">>>>>>>>>>> das erste el zurück");
		return paymentMeans.pmList.get(0);
	}

	private static final Logger LOG = Logger.getLogger(PaymentMeans.class.getName());

	List<PaymentMeans> pmList; // mit indexOf(Object o) this finden
//	List<PaymentMeansType> get... TODO
	private void addToPmList(PaymentMeans pm) {
		if(pm==null) return;
		int i = pmList.indexOf(pm);
		if(i<0) pmList.add(pm);
	}
	
	private PaymentMeans() {
		pmList = new ArrayList<PaymentMeans>();
	}
	private PaymentMeans(PaymentMeansType doc, List<PaymentMeans> pmList) {
		this();
		if(doc!=null) {
			super.setID(doc.getID());
			super.setPaymentMeansCode(doc.getPaymentMeansCode());
			super.setPaymentDueDate(doc.getPaymentDueDate());
			super.setPaymentChannelCode(doc.getPaymentChannelCode());
			super.setInstructionID(doc.getInstructionID());
			super.instructionNote = doc.getInstructionNote();
			super.paymentID = doc.getPaymentID();
			super.setCardAccount(doc.getCardAccount());
			super.setPayerFinancialAccount(doc.getPayerFinancialAccount());
			super.setPayeeFinancialAccount(doc.getPayeeFinancialAccount());
			super.setCreditAccount(doc.getCreditAccount());
			super.setPaymentMandate(doc.getPaymentMandate());
			super.setTradeFinancing(doc.getTradeFinancing());
		}
		if(pmList==null) {
			this.pmList.add(this);
		} else {
			this.pmList = pmList;
		}
		if(this.isCreditTransfer()) {
			super.setPayeeFinancialAccount(new FinancialAccount(this));			
		}
		if(this.isDirectDebit()) {
			super.setPayerFinancialAccount(new FinancialAccount(this));			
		}

		LOG.config("ctor:"+this);
	}

	private PaymentMeans(List<PaymentMeansType> list) {
		this();
		LOG.config("more "+list.size()+" BG-17 CreditTransfer/PaymentMeans");
		list.forEach(pm -> {
			LOG.config("CreditTransfer/PaymentMeans:"+pm);
			addToPmList(new PaymentMeans(pm, pmList));
		});
//		LOG.info("ctor für mehrere "+list.size()+" fertig.:"+this.pmList.size());
	}
	
	PaymentMeans(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation,
			List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		this();
		init(code, paymentMeansText, remittanceInformation, creditTransfer, paymentCard, directDebit);
	}
	private void init(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit) {
		
		setPaymentMeans(code, paymentMeansText); // BT-81, BT-82
		setRemittanceInformation(remittanceInformation); // BT-83
		
		if(getPaymentMeansEnum()==null) return;
		
		// BG-17
		if(creditTransfer!=null) {
			creditTransfer.forEach(ct -> {
				LOG.config("init add BG-17:"+ct);
				this.addCreditTransfer(ct);
			});
		} else {
			addToPmList(this);
			setPaymentCard(paymentCard);                   // BG-18
			setDirectDebit((BG19_DirectDebit)directDebit); // BG-19
		}
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		stringBuilder.append("@").append(Integer.toHexString(hashCode()));
		stringBuilder.append(", ").append(getPaymentMeansEnum()==null ? "null" : getPaymentMeansEnum().getValueAsString());
		stringBuilder.append(", PaymentMeansText:");
		stringBuilder.append(getPaymentMeansText()==null ? "null" : getPaymentMeansText());
		stringBuilder.append(", paymentMeans#:"+this.pmList.size());
		stringBuilder.append(", RemittanceInformation:");
		stringBuilder.append(getRemittanceInformation()==null ? "null" : getRemittanceInformation());
		
//		stringBuilder.append(", PayeeFinancialAccount:");
//		stringBuilder.append(getPayeeFinancialAccount()==null ? "null" : getPayeeFinancialAccount());
		
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
	public PaymentMeansEnum getPaymentMeansEnum() {
		return getPaymentMeansEnum(this);
	}
	static PaymentMeansEnum getPaymentMeansEnum(PaymentMeansType pm) {
		CodeType paymentMeansCode = pm.getPaymentMeansCode();
		return paymentMeansCode==null ? null : PaymentMeansEnum.valueOf(paymentMeansCode);
	}
	
	boolean isCreditTransfer() {
		return PaymentMeansEnum.isCreditTransfer(getPaymentMeansEnum());
	}
	boolean isBankCard() {
		return PaymentMeansEnum.isBankCard(getPaymentMeansEnum());
	}
	boolean isDirectDebit() {
		return PaymentMeansEnum.isDirectDebit(getPaymentMeansEnum());
	}

	@Override
	public String getPaymentMeansText() {
		return super.getInstructionNote().isEmpty() ? null : super.getInstructionNote().get(0).getValue();
	}
	static String getPaymentMeansText(PaymentMeansType doc) {
		return doc.getInstructionNote().isEmpty() ? null : doc.getInstructionNote().get(0).getValue();
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
	
	// CreditTransfer ist Interface, List da BG-17 CREDIT TRANSFER die Kardinalität 0..n hat
	// class FinancialAccount extends FinancialAccountType implements CreditTransfer
	@Override
	public void addCreditTransfer(CreditTransfer creditTransfer) {
		if(creditTransfer==null) return;
		FinancialAccount fa = (FinancialAccount)creditTransfer;
		addToPmList(fa.getPaymentMeans());
		super.setPayeeFinancialAccount(fa);
	}

	public FinancialAccount getFinancialAccount() {
		int i = pmList.indexOf(this);
		LOG.fine("gefunden? i="+i);
		if(i<0) return null;
		return new FinancialAccount(pmList.get(i));
	}
// in ubl gibt es keine List<CreditTransfer> !!! ABER mehrere PaymentMeans 
/* siehe ubl-tc434-example1.xml :
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>
        <cbc:PaymentID>Deb. 10202 / Fact. 12115118</cbc:PaymentID>
        <cac:PayeeFinancialAccount>
            <cbc:ID>NL57 RABO 0107307510</cbc:ID>
        </cac:PayeeFinancialAccount>
    </cac:PaymentMeans>
    <cac:PaymentMeans>
        <cbc:PaymentMeansCode>30</cbc:PaymentMeansCode>
        <cac:PayeeFinancialAccount>
            <cbc:ID>NL03 INGB 0004489902</cbc:ID>
        </cac:PayeeFinancialAccount>
    </cac:PaymentMeans>

 */

	@Override
	public List<CreditTransfer> getCreditTransfer() { 
		List<CreditTransfer> result = new ArrayList<CreditTransfer>();
		pmList.forEach(pm -> {
			LOG.config("getCreditTransfer pm:"+pm);
			result.add(new FinancialAccount(pm));
		});
		return result;
	}
	
	// BG-18 (optional) PAYMENT CARD INFORMATION
	@Override
	public void setPaymentCard(PaymentCard paymentCard) {
		if(paymentCard==null) return;
		// CardAccount extends CardAccountType implements PaymentCard
		CardAccount cardAccount = (CardAccount)paymentCard;
		super.setCardAccount(cardAccount);
	}

	@Override
	public PaymentCard getPaymentCard() {
		return super.getCardAccount()==null? null : new CardAccount(getCardAccount());
	}
	
	// DirectDebit ist Interface, kein List da BG-19 die Kardinalität 0..1 hat
	// class PaymentMandate extends PaymentMandateType implements BG19_DirectDebit
	@Override
	public void setDirectDebit(BG19_DirectDebit directDebit) {
		if(directDebit==null) return;
		super.setPaymentMandate((PaymentMandate)directDebit);
	}

	public BG19_DirectDebit getDirectDebit() {
		if(super.getPaymentMandate()==null) return null;
		PaymentMandate directDebit = new PaymentMandate(getPaymentMandate());
		return directDebit;
	}

}
