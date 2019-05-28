package com.klst.un.unece.uncefact;

import java.math.BigDecimal;

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
 * <br>The unit of measure that applies to the invoiced quantity.
 * The quantity of items (goods or services) that is charged in the Invoice line.
 * 
 * <br>Req.ID: R39, R56, R14
 */
public class Quantity extends QuantityType {

	Quantity() {
		super();
	}

	public Quantity(String unitCode, BigDecimal quantity) {
		this();
		this.setUnitCode(unitCode);
		this.setValue(quantity);
	}

	@Override
	public String toString() {
		return this.getValue() + " " + this.getUnitCode();
	}
}
