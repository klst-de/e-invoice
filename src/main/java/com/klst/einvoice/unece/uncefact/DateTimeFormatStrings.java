package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;

import com.klst.untdid.codelist.DateTimeFormats;

import un.unece.uncefact.data.standard.qualifieddatatype._100.FormattedDateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateType;

// in CII werden mehrere ähnliche Klassen verwendet, die Date(Time)String als inner Klasse haben
// - DateType.DateString
// - DateTimeType.DateTimeString
// - FormattedDateTimeType.DateTimeString
public class DateTimeFormatStrings extends DateTimeFormats {

	static DateType toDate(Timestamp ts) {
		if(ts==null) return null;
		
		DateType.DateString ds = new DateType.DateString();
		ds.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		ds.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		
		DateType date = new DateType();
		date.setDateString(ds);
		return date;
	}

	static DateTimeType toDateTime(Timestamp ts) {
		if(ts==null) return null;
		
		DateTimeType.DateTimeString dts = new DateTimeType.DateTimeString();
		dts.setFormat(DateTimeFormats.CCYYMMDD_QUALIFIER);
		dts.setValue(DateTimeFormats.tsToCCYYMMDD(ts));
		
		DateTimeType dateTime = new DateTimeType();
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
