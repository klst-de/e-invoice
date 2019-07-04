package com.klst.untdid.codelist;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateTimeFormats {

	// UNTDID 2379 Date/time/period format qualifier , see https://service.unece.org/trade/untdid/d96b/uncl/uncl2379.htm
	public static final String CCYYMMDD_QUALIFIER = "102"; // == "yyyyMMdd"
	public static final String CCYYMMDD = "yyyyMMdd";
	
	public static Timestamp xmlGregorianCalendarToTs(XMLGregorianCalendar cal) {
		long timeInMillis = cal.toGregorianCalendar().getTimeInMillis();
		return new Timestamp(timeInMillis);
	}
	public static Timestamp ymdToTs(String ymd) {
		Timestamp ts = null;
		if(ymd!=null) try {
			//Timestamp.valueOf("yyyy-[m]m-[d]d hh:mm:ss[.f...]"); // JDBC timestamp escape format
			ts = Timestamp.valueOf(ymd);
		} catch (IllegalArgumentException e) {
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				ts = new Timestamp(((java.util.Date)df.parse(ymd)).getTime());
			} catch (ParseException ex) {
				// try UNTDID 2379 Format "102" : CCYYMMDD
			}
			try {
				DateFormat df = new SimpleDateFormat(CCYYMMDD);
				ts = new Timestamp(((java.util.Date)df.parse(ymd)).getTime());
			} catch (ParseException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		return ts;
	}
	
	public static XMLGregorianCalendar tsToXMLGregorianCalendar(Timestamp ts) {
        LocalDateTime ldt = ts.toLocalDateTime();
        XMLGregorianCalendar cal = null;
		try {
			cal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cal.setYear(ldt.getYear());
        cal.setMonth(ldt.getMonthValue());
        cal.setDay(ldt.getDayOfMonth());
        cal.setHour(ldt.getHour());
        cal.setMinute(ldt.getMinute());
        cal.setSecond(ldt.getSecond());
		return cal;
	}

	public static String tsToCCYYMMDD(Timestamp ts) {
		return new SimpleDateFormat(CCYYMMDD).format(ts);
	}


}
