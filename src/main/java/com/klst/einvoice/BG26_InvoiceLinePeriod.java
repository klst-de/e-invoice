package com.klst.einvoice;

import java.sql.Timestamp;

import com.klst.edoc.api.IPeriod;
import com.klst.edoc.api.IPeriodFactory;
import com.klst.edoc.untdid.DateTimeFormats;

/**
 * BG-26 INVOICE LINE PERIOD with BT-134 Invoice line period start date and BT-135 Invoice line period end date
 * <p>
 * A group of business terms providing information about the period relevant for the Invoice line.
 * Is also called Invoice line delivery period
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-26
 * <br>Rule ID: 	
 * <br>Request ID: 	R30
 * <p>
 * BT-134 and BT-135
 * Cardinality: 	0..1
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */
public interface BG26_InvoiceLinePeriod extends IPeriodFactory {

	public void setLineDeliveryDate(Timestamp timestamp);
	default void setLineDeliveryDate(String ymd) {
		if(ymd!=null) setLineDeliveryDate(DateTimeFormats.ymdToTs(ymd));
	}
	public Timestamp getLineDeliveryDateAsTimestamp();

	public void setLineDeliveryPeriod(IPeriod period);
	default void setLineDeliveryPeriod(Timestamp start, Timestamp end) {
		setLineDeliveryPeriod(createPeriod(start, end));
	}
	default void setLineDeliveryPeriod(String ymdStart, String ymdEnd) {
		setLineDeliveryPeriod(createPeriod(ymdStart, ymdEnd));
	}
	public IPeriod getLineDeliveryPeriod();

}
