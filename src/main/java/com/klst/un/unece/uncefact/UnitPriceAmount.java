package com.klst.un.unece.uncefact;

import java.math.BigDecimal;
import java.math.RoundingMode;

/* Mit diesem Datentyp wird der dem Preis eines Einzelpostens entsprechende Betrag abgebildet.
 * 
 * Dieser Geldwert kann mit der jeweiligen Mengenangabe zum Einzelposten multipliziert werden. 
 * Der Datentyp basiert auf dem Typ „Unit Price_ Amount“, wie in ISO 15000-5:2014 Anhang B definiert.
 * 
 * Hinweis: Dem Geldwert wird über ein eigenständiges Informationselement eine Währung zugeordnet.
 * 
 */
/**
 * Unit Price Amount
 * 
 * This is a "decimal" type with 4 digits maximum after the decimal point, without a thousand separator, and with the ". " as a decimal separator. 
 * It can be supplemented by a "Currency" attribute, if different from the currency in the header. Example 1000.3454
 * 
 * @see European standard EN 16931-1:2017 : 6.5.3 Unit Price Amount
 * 
 * A unit price amount states a numerical monetary amount value for data elements 
 * that contain item prices that may be multiplied by item quantities. 
 * The currency of the amount is defined as a separate business term. This EN 16931_ Unit Price_ Amount.
 *  
 * Type is based on the Amount. Type as defined in ISO 15000-5:2014, Annex B.
 *
 */
public class UnitPriceAmount extends Amount {

	public static final int SCALE = 4;
	
	UnitPriceAmount() {
		super();
	}

	public UnitPriceAmount(BigDecimal amount) {
		super(amount);
	}

	public UnitPriceAmount(String currencyID, BigDecimal amount) {
		super(currencyID, amount);
	}

	public BigDecimal getValue(RoundingMode roundingMode) {
		return getValue().setScale(SCALE, roundingMode);
	}
	
	void copyTo(un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType amount) {
		amount.setValue(this.getValue(RoundingMode.HALF_UP));
	}

	@Override
	public String toString() {
		return getCurrencyID()==null ? ""+getValue(RoundingMode.HALF_UP) : getCurrencyID() + getValue(RoundingMode.HALF_UP);
	}

}
