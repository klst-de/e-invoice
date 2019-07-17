package com.klst.un.unece.uncefact;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.klst.einvoice.Rounding;

import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.QuantityType;

/* Mit diesem Datentyp wird die Mengenangabe zu einem Einzelposten abgebildet. 
 * 
 * Er basiert auf dem Typ „Quantity. Type“, wie in ISO 15000-5:2014 Anhang B definiert.
 * 
 * Hinweis: Der Mengenangabe wird über ein eigenständiges Informationselement eine Maßeinheit zugeordnet.
 * 
 */
/**
 * Quantity contains unit of measure and quantity of items (goods or services)
 * <p>
 * This is a "decimal" type with 4 digits maximum after the decimal point, without a thousand separator, and with the ". " as a decimal separator. 
 * Example 10000.3454
 * 
 * <br>The unit of measure that applies to the invoiced quantity.
 * The quantity of items (goods or services) that is charged in the Invoice line.
 * 
 */
public class Quantity extends QuantityType implements Rounding {

	public static final int SCALE = 4;
	
	Quantity() {
		super();
	}

	public Quantity(BigDecimal quantity) {
		this(null, quantity);
	}

	public Quantity(String unitCode, BigDecimal quantity) {
		this();
		this.setUnitCode(unitCode);
		this.setValue(quantity);
	}

	void copyTo(un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType quantity) {
		quantity.setUnitCode(this.getUnitCode());
		quantity.setValue(this.getValue(RoundingMode.HALF_UP));
	}

	/*
	 * (non-Javadoc)
	 * @see com.klst.cius.Rounding#getValue(java.math.RoundingMode)
	 */
	@Override
	public BigDecimal getValue(RoundingMode roundingMode) {
		return getValue().setScale(SCALE, roundingMode);
	}
	
	@Override
	public String toString() {
		return getValue(RoundingMode.HALF_UP) + (getUnitCode()==null ? "" : " " + getUnitCode());
	}
}
