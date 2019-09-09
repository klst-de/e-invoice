package com.klst.einvoice;

import java.sql.Timestamp;

/**
 * BG-14 INVOICING PERIOD 
 * <p>
 * A group of business terms providing information on the invoice period.
 * Used to indicate when the period covered by the invoice starts and when it ends. 
 * Also called delivery period.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-14
 * <br>Rule ID: 	
 * <br>Request ID: 	R34
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */

// TODO Idee runter zu ubl und cii und public raus ?!
public interface BG14_InvoicingPeriod {
	
	// BT-73 +++ 0..1 Invoicing period start date
	public void setStartDate(String ymd);
	public void setStartDate(Timestamp ts);
	public Timestamp getStartDateAsTimestamp();
	
	// BT-74 +++ 0..1 Invoicing period end date
	public void setEndDate(String ymd);
	public void setEndDate(Timestamp ts);
	public Timestamp getEndDateAsTimestamp();
	
}
