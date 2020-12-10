package com.klst.einvoice;

import java.sql.Timestamp;

/**
 * Period with Start and End Date
 * <p>
 * subclassed by
 * BG-14 INVOICING PERIOD
 * and 
 * BG-26 INVOICE LINE PERIOD
 */
public interface IPeriod {
	
	public void setStartDate(String ymd);
	public void setStartDate(Timestamp ts);
	public Timestamp getStartDateAsTimestamp();
	
	public void setEndDate(String ymd);
	public void setEndDate(Timestamp ts);
	public Timestamp getEndDateAsTimestamp();
	
}
