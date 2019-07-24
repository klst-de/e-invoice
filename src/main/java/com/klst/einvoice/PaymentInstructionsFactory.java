package com.klst.einvoice;

import com.klst.untdid.codelist.PaymentMeansCode;

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
	
	public PaymentInstructions createPaymentInstructions(PaymentMeansCode code, String paymentMeansText);
	
}
