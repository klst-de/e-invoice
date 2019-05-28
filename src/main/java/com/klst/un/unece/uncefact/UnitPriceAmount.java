package com.klst.un.unece.uncefact;

import java.math.BigDecimal;

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

	UnitPriceAmount() {
		super();
	}

	public UnitPriceAmount(String currencyID, BigDecimal amount) {
		super(currencyID, amount);
	}

	public BigDecimal getValue() {
		return super.getValue();
	}
}
