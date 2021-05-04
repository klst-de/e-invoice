package com.klst.einvoice.api;

/**
 * abstract-factory, aka Kit for BG-18 PAYMENT CARD INFORMATION
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */

/* Zahlungskarte BG-18
 * 
 * 
 * 
 */

public interface PaymentCardFactory {
	
	// alle para optional
	public PaymentCard createPaymentCard(String cardAccountID, String cardHolderName);
}
