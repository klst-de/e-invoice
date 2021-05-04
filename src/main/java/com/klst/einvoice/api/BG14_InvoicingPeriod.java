package com.klst.einvoice.api;

import java.sql.Timestamp;

import com.klst.edoc.api.IPeriod;
import com.klst.edoc.api.IPeriodFactory;
import com.klst.edoc.untdid.DateTimeFormats;

/**
 * BG-14 INVOICING PERIOD with BT-73 Invoicing period start date and BT-74 Invoicing period end date
 * <p>
 * A group of business terms providing information on the invoice period.
 * Used to indicate when the period covered by the invoice starts and when it ends. 
 * Also called delivery period.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-14
 * <br>Rule ID: 	
 * <br>Request ID: 	R34
 * <p>
 * BT-73 and BT-74
 * Cardinality: 	0..1
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */
/*   (en) rules
 * 
 * BR-29  Target / context: Invoicing Period, Business term / group: BT-74
 * If both Invoicing period start date (BT-73) and Invoicing period end date (BT-74) are given 
 * then the Invoicing period end date (BT-74) shall be later or equal to the Invoicing period start date (BT-73).
 * 
 *   (de) rules / Geschäftsregel:
 *   
 * BR-29    : Rechnungszeitraum
 * Wenn sowohl das Anfangsdatum des Rechnungszeitraums (BT-73) 
 * als auch das Enddatum des Rechnungszeitraums (BT-74) angegeben werden, 
 * muss das Enddatum jedes Rechnungszeitraums (BT-74) entweder gleich 
 * dem Anfangsdatum dieses Rechnungszeitraums (BT-73) sein oder später liegen.
 * 
 * BR-CO-19 : Liefer- oder Rechnungszeitraum
 * Wird der Liefer- oder Rechnungszeitraum (BG-14) verwendet, muss das Anfangsdatum des Lieferzeitraums (BT-73) 
 * oder das Enddatum des Lieferzeitraums (BT-74) oder beides angegeben werden
 * 
 * BR-IC-11 :
 * In einer Rechnung mit einer Umsatzsteueraufschlüsselung (BG-23), 
 * bei der als Code der Umsatzsteuerkategorie (BT-118) „Innergemeinschaftliche Lieferung“ angegeben ist, 
 * muss das tatsächliche Lieferdatum (BT-72) oder der Lieferzeitraum (BG-14) angegeben werden.
 */
public interface BG14_InvoicingPeriod extends IPeriodFactory {

	/**
	 * To specify exact one date for the shipment, both sub-elements start and end should be the equal.
	 * @param timestamp
	 */
	default void setDeliveryDate(Timestamp timestamp) {
		setDeliveryPeriod(createPeriod(timestamp, timestamp));
	}
	default void setDeliveryDate(String ymd) {
		if(ymd!=null) setDeliveryDate(DateTimeFormats.ymdToTs(ymd));
	}
	default Timestamp getDeliveryDateAsTimestamp() {
		IPeriod period = getDeliveryPeriod();
		if(period==null) return null;
		if(period.getStartDateAsTimestamp().equals(period.getEndDateAsTimestamp())) return period.getEndDateAsTimestamp();
		return null;
	}

	public void setDeliveryPeriod(IPeriod period);
	default void setDeliveryPeriod(Timestamp start, Timestamp end) {
		setDeliveryPeriod(createPeriod(start, end));
	}
	default void setDeliveryPeriod(String ymdStart, String ymdEnd) {
		setDeliveryPeriod(createPeriod(ymdStart, ymdEnd));
	}
	public IPeriod getDeliveryPeriod();

}
