package com.klst.einvoice;

/**
 * BG-14 INVOICING PERIOD with BT-73 Invoicing period start date and BT-74 Invoicing period end date
 * <p>
 * A group of business terms providing information on the invoice period.
 * Used to indicate when the period covered by the invoice starts and when it ends. 
 * Also called delivery period.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-14
 * <br>Rule ID: 	
 * <br>Request ID: 	R34
 * <p>
 * BT-73 and BT-74
 * Cardinality: 	0..1
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */
public interface BG14_InvoicingPeriod extends IPeriod {
	
}
