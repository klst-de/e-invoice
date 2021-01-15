package com.klst.einvoice;

import java.util.List;

import com.klst.untdid.codelist.PaymentMeansEnum;

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
	
	public PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText, String remittanceInformation
			, List<CreditTransfer> creditTransfer, PaymentCard paymentCard, DirectDebit directDebit);
	
	default PaymentInstructions createPaymentInstructions(PaymentMeansEnum code, String paymentMeansText) {
		return createPaymentInstructions(code, paymentMeansText, null, null, null, null);
	}
	
}
