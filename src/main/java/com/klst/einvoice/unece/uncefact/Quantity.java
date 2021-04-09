package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.IQuantity;

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
public class Quantity extends QuantityType implements IQuantity {

	@Override
	public IQuantity createQuantity(String unitCode, BigDecimal quantity) {
		return create(unitCode, quantity);
	}

	static Quantity create(String unitCode, BigDecimal quantity) {
		return new Quantity(unitCode, quantity);
	}

	// in EN 16931-1:2017/A1:2019 + AC:2020 entfällt die Einschränkung:
	//  „Typ repräsentiert eine Fließkommazahl ohne Limitierung der Anzahl an Nachkommastellen.“ 
	public static final int SCALE = 4;
	
	static Quantity create() {
		return new Quantity(null); 
	}
	// copy factory
	static Quantity create(QuantityType object) {
		if(object instanceof QuantityType && object.getClass()!=QuantityType.class) {
			// object is instance of a subclass of QuantityType, but not QuantityType itself
			return (Quantity)object;
		} else {
			return new Quantity(object); 
		}
	}

	// copy ctor
	private Quantity(QuantityType object) {
		super();
		if(object!=null) {
			SCopyCtor.getInstance().invokeCopy(this, object);
		}
	}

	public Quantity(String unitCode, BigDecimal quantity) {
		super();
		super.setUnitCode(unitCode);
		super.setValue(quantity.setScale(SCALE, RoundingMode.HALF_UP));
	}

	void copyTo(un.unece.uncefact.data.standard.unqualifieddatatype._100.QuantityType quantity) {
		quantity.setUnitCode(this.getUnitCode());
		quantity.setValue(this.getValue(RoundingMode.HALF_UP));
	}

	@Override
	public BigDecimal getValue(RoundingMode roundingMode) {
		return getValue().setScale(SCALE, roundingMode);
	}
	
	@Override
	public String toString() {
		return getValue(RoundingMode.HALF_UP) + (getUnitCode()==null ? "" : getUnitCode());
	}

}
