package com.klst.einvoice.ubl;

import java.sql.Timestamp;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.IPeriod;
import com.klst.untdid.codelist.DateTimeFormats;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.DateType;

public class Period extends PeriodType implements IPeriod {

	// factory
	@Override
	public IPeriod createPeriod(Timestamp start, Timestamp end) {
		return create(start, end);
	}
	static Period create(Timestamp start, Timestamp end) {
		return new Period(start, end);
	}

	// copy factory
	static Period create(PeriodType object) {
		if(object instanceof PeriodType && object.getClass()!=PeriodType.class) {
			// object is instance of a subclass of PeriodType, but not PeriodType itself
			return (Period)object;
		} else {
			return new Period(object); 
		}
	}

	// copy ctor
	private Period(PeriodType object) {
		if(object!=null) {
			SCopyCtor.getInstance().invokeCopy(this, object);
		}
	}

	private Period(Timestamp start, Timestamp end) {
		setStartDate(start);
		setEndDate(end);
	}
	
	void setStartDate(Timestamp ts) {
		if(ts==null) return;
		
		StartDateType date = new StartDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		super.setStartDate(date);
	}

	@Override
	public Timestamp getStartDateAsTimestamp() {
		DateType date = (DateType)super.getStartDate();
		if(date==null) return null;
		return DateTimeFormats.xmlGregorianCalendarToTs(date.getValue());
	}

	void setEndDate(Timestamp ts) {
		if(ts==null) return;
		
		EndDateType date = new EndDateType();
		date.setValue(DateTimeFormats.tsToXMLGregorianCalendar(ts));
		super.setEndDate(date);
	}

	@Override
	public Timestamp getEndDateAsTimestamp() {
		DateType date = (DateType)super.getEndDate();
		if(date==null) return null;
		return DateTimeFormats.xmlGregorianCalendarToTs(date.getValue());
	}

}
