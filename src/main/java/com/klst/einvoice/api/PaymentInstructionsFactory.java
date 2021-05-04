package com.klst.einvoice;

import java.util.List;

import com.klst.edoc.untdid.PaymentMeansEnum;

/**
 * abstract-factory, aka Kit for BG-16 PAYMENT INSTRUCTIONS
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */

/* Zahlungsanweisungen BG-16
 * 
 * 
 * 
 */

public interface PaymentInstructionsFactory {
	
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText
			, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit);
	
	default PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText) {
		return createPaymentInstructions(code, paymentMeansText, null, null, null, null);
	}
	
	/*
	 * BR-DE-13: In der Rechnung müssen Angaben zu genau einer der drei Gruppen sein: 
	 * CREDIT TRANSFER, PAYMENT CARD INFORMATION, DIRECT DEBIT 
	 */
	default PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText
			, String remittanceInformation, List<CreditTransfer> creditTransfer) {
		return createPaymentInstructions(code, paymentMeansText, remittanceInformation, creditTransfer, null, null);
	}
	default PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText
			, String remittanceInformation, PaymentCard paymentCard) {
		return createPaymentInstructions(code, paymentMeansText, remittanceInformation, null, paymentCard, null);
	}
	default PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText
			, String remittanceInformation, DirectDebit directDebit) {
		return createPaymentInstructions(code, paymentMeansText, remittanceInformation, null, null, directDebit);
	}
}
