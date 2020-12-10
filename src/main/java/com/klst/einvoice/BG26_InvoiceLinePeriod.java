package com.klst.einvoice;

import java.sql.Timestamp;

/**
 * BG-26 INVOICE LINE PERIOD
 * <p>
 * A group of business terms providing information about the period relevant for the Invoice line.
 * Is also called Invoice line delivery period
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-26
 * <br>Rule ID: 	
 * <br>Request ID: 	R30
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */
public interface BG26_InvoiceLinePeriod {
	
	// BT-134 +++ 0..1 Invoice line period start date
	public void setStartDate(String ymd);
	public void setStartDate(Timestamp ts);
	public Timestamp getStartDateAsTimestamp();
	
	// BT-135 +++ 0..1 Invoice line period end date
	public void setEndDate(String ymd);
	public void setEndDate(Timestamp ts);
	public Timestamp getEndDateAsTimestamp();
	
}
