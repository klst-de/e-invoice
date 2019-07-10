package com.klst.ubl;

import java.util.ArrayList;
import java.util.List;

import com.klst.untdid.codelist.PaymentMeansCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.FinancialAccountType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
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

 */
public class PaymentMeans extends PaymentMeansType {

	PaymentMeans() {
		super();
	}
	
	// copy ctor
	public PaymentMeans(PaymentMeansType paymentMeans) {
		this(PaymentMeansCode.valueOf(paymentMeans.getPaymentMeansCode()), paymentMeans.getPayeeFinancialAccount());
		setPaymentIDs(paymentMeans.getPaymentID());
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
		
		super.setPayeeFinancialAccount(financialAccount);

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
	
	public List<String> getRemittanceInformation() {
		List<PaymentIDType> paymentIDs = super.getPaymentID();
		List<String> result = new ArrayList<String>(paymentIDs.size());
		paymentIDs.forEach(paymentID -> {
			result.add(paymentID.getValue());
		});
		return result;
	}

}
