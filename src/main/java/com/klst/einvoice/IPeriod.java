package com.klst.einvoice;

import java.sql.Timestamp;

import com.klst.untdid.codelist.DateTimeFormats;

/**
 * Period with Start and End Date
 * <p>
 * subclassed by
 * BG-14 INVOICING PERIOD
 * and 
 * BG-26 INVOICE LINE PERIOD
 */
public interface IPeriod {
	
	public void setStartDate(Timestamp ts);
	public Timestamp getStartDateAsTimestamp();
	default void setStartDate(String ymd) {
		if(ymd!=null) setStartDate(DateTimeFormats.ymdToTs(ymd));
	}
	
	public void setEndDate(Timestamp ts);
	public Timestamp getEndDateAsTimestamp();
	default void setEndDate(String ymd) {
		if(ymd!=null) setEndDate(DateTimeFormats.ymdToTs(ymd));
	}

	default void setPeriod(String startYmd, String endYmd) {
		setStartDate(DateTimeFormats.ymdToTs(startYmd));
		setEndDate(DateTimeFormats.ymdToTs(endYmd));
	}

	default void setPeriod(Timestamp startTs, Timestamp endTs) {
		setStartDate(startTs);
		setEndDate(endTs);
	}
	
}
