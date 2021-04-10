package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.IPeriod;
import com.klst.untdid.codelist.DateTimeFormats;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SpecifiedPeriodType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;

public class SpecifiedPeriod extends SpecifiedPeriodType implements IPeriod {

	@Override
	public IPeriod createPeriod(Timestamp start, Timestamp end) {
		return create(start, end);
	}

	static SpecifiedPeriod create(Timestamp start, Timestamp end) {
		return new SpecifiedPeriod(start, end); 
	}
	
	static SpecifiedPeriod create(SpecifiedPeriodType object) {
		if(object instanceof SpecifiedPeriodType && object.getClass()!=SpecifiedPeriodType.class) {
			// object is instance of a subclass of SpecifiedPeriodType, but not SpecifiedPeriodType itself
			return (SpecifiedPeriod)object;
		} else {
			return new SpecifiedPeriod(object); 
		}
	}

	private SpecifiedPeriod(Timestamp start, Timestamp end) {
		setStartDate(start);
		setEndDate(end);
	}
	
	private SpecifiedPeriod(SpecifiedPeriodType object) {
		super();
		if (object != null) {
			SCopyCtor.getInstance().invokeCopy(this, object);
		}
	}

	void setStartDate(Timestamp ts) {
		if(ts==null) return;
		DateTimeType dateTime = DateTimeFormatStrings.toDateTime(ts);
		super.setStartDateTime(dateTime);
	}
	void setEndDate(Timestamp ts) {
		if(ts==null) return;
		DateTimeType dateTime = DateTimeFormatStrings.toDateTime(ts);
		super.setEndDateTime(dateTime);
	}
	
	@Override
	public Timestamp getStartDateAsTimestamp() {
		DateTimeType dateTime = super.getStartDateTime();
		return dateTime==null ? null : DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());
	}
	@Override
	public Timestamp getEndDateAsTimestamp() {
		DateTimeType dateTime = super.getEndDateTime();
		return dateTime==null ? null : DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[start:");
		stringBuilder.append(getStartDateAsTimestamp()==null ? "null" : getStartDateAsTimestamp());
		stringBuilder.append(", end:");
		stringBuilder.append(getEndDateAsTimestamp()==null ? "null" : getEndDateAsTimestamp());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
