package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;

import com.klst.untdid.codelist.DateTimeFormats;

import un.unece.uncefact.data.standard.qualifieddatatype._100.FormattedDateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;

// in CII werden zwei ähnliche Klassen verwendet, die DateTimeString als inner Klassen haben
// - FormattedDateTimeType.DateTimeString
// und
// - DateTimeType.DateTimeString
public class DateTimeFormatStrings extends DateTimeFormats {

	static DateTimeType toDateTime(Timestamp ts) {
		if(ts==null) return null;
		
		DateTimeType dateTime = new DateTimeType();
		DateTimeType.DateTimeString dts = new DateTimeType.DateTimeString();
		dts.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		dts.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		dateTime.setDateTimeString(dts);
		return dateTime;
	}

	static FormattedDateTimeType toFormattedDateTime(Timestamp ts) {
		if (ts == null) return null;

		FormattedDateTimeType.DateTimeString dts = new FormattedDateTimeType.DateTimeString();
		dts.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		dts.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		
		FormattedDateTimeType fdt = new FormattedDateTimeType();
		fdt.setDateTimeString(dts);

		return fdt;
	}

}
