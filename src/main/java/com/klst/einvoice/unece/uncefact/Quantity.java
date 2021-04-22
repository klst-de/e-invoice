package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.IQuantity;

import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.QuantityType;

/* Quantity : „Core Data Types“ aus "ISO 15000-5" aka ebXML
 * 
 * A counted number of non-monetary units. 
 * Quantities need to be specified with a unit of quantity.
 * 
 * [Note: This Representation Term shall also be used 
 * for counted coefficients (e.g. flowers/m²).]
 * 
 * Quelle: https://www.oasis-open.org/events/symposium/2006/slides/CrawfordTutorial.pdf
 * PS: Das Original (27Seiten kosten CHF138) : https://www.iso.org/standard/61433.html 
 */
/**
 * Quantity contains unit of measure and quantity of items (goods or services)
 * <p>
 * This is a "decimal" type with 4 digits maximum after the decimal point, without a thousand separator, and with the "." as a decimal separator. 
 * Example 10000.3454
 * 
 * <br>The unit of measure that applies to the ordered or invoiced quantity.
 * The quantity of items (goods or services) that is charged in the Order/Invoice line.
 * 
 */
public class Quantity extends QuantityType implements IQuantity {

	@Override
	public IQuantity createQuantity(String unitCode, BigDecimal value) {
		return create(unitCode, value);
	}

	static Quantity create(String unitCode, BigDecimal value) {
		return new Quantity(unitCode, value);
	}

	// in EN 16931-1:2017/A1:2019 + AC:2020 entfällt die Einschränkung:
	//  „Typ repräsentiert eine Fließkommazahl ohne Limitierung der Anzahl an Nachkommastellen.“ 
	public static final int SCALE = 4;
	
	static Quantity create() {
		return new Quantity(null); 
	}
	// copy factory
	static Quantity create(QuantityType object) {
		if(object==null) return null;
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

	public Quantity(String unitCode, BigDecimal value) {
		super();
		super.setUnitCode(unitCode);
		setvalue(value); // nicht super.setValue!
	}

	private void setvalue(BigDecimal value) {
		if(value==null) return;
		super.setValue(value.setScale(SCALE, RoundingMode.HALF_UP));
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
		return getValue()==null ? "" : getValue(RoundingMode.HALF_UP) 
				+ (getUnitCode()==null ? "" : getUnitCode());
	}

}
