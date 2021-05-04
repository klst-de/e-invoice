package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.IAmount;

import un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.AmountType;

/* Mit diesem Datentyp wird ein Betrag in numerischer Form abgebildet. 
 * 
 * Er basiert auf dem Typ „Amount. Type“, wie in ISO 15000-5:2014 Anhang B definiert.
 * 
 * Hinweis: Dem Geldwert wird über ein eigenständiges Informationselement eine Währung zugeordnet.
 * 
 */
/**
 * Amount
 * 
 * This is a "decimal" type with 2 digits maximum after the decimal point, without a thousand separator, and with the ". " as a decimal separator. 
 * It can be supplemented by a "Currency" attribute, if different from the currency in the header. Example 10000.34
 * 
 * @see European standard EN 16931-1:2017 : 6.5.2 Amount. Type
 * 
 * An amount states a numerical monetary value. 
 * The currency of the amount is defined as a separate business term. 
 * 
 * This EN 16931_ Amount. Type4 is based on the Amount. Type as defined in ISO 15000-5:2014, Annex B. EN 16931_ Amount. 
 * Type is floating up to two fraction digits.
 *
 */
public class Amount extends AmountType implements IAmount {

	@Override
	public IAmount createAmount(String currencyID, BigDecimal amount) {
		return create(currencyID, amount);
	}
	static Amount create(String currencyID, BigDecimal amount) {
		return new Amount(currencyID, amount);
	}
	static Amount create(un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType amount) {
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}
	public static Amount create(oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.AmountType amount) {
		return new Amount(amount.getCurrencyID(), amount.getValue());
	}

	// Der Betrag wird mit zwei Nachkommastellen angegeben. ==> setScale(2, RoundingMode.HALF_UP)
	public static final int SCALE = 2;
	private int scale = SCALE;

	static Amount create() {
		return new Amount((AmountType)null); 
	}
	// copy factory
	static Amount create(AmountType object) {
		if(object instanceof AmountType && object.getClass()!=AmountType.class) {
			// object is instance of a subclass of AmountType, but not AmountType itself
			return (Amount)object;
		} else {
			return new Amount(object); 
		}
	}

	// copy ctor
	private Amount(AmountType object) {
		super();
		if(object!=null) {
			SCopyCtor.getInstance().invokeCopy(this, object);
		}
	}

	public Amount(BigDecimal amount) {
		this((String)null, amount);
	}
	public Amount(String currencyID, BigDecimal amount) {
		this(currencyID, SCALE, RoundingMode.HALF_UP, amount);
	}

	Amount(String currencyID, int scale, RoundingMode roundingMode, BigDecimal amount) {
		super();
		super.setCurrencyID(currencyID);
		this.scale = scale;
		super.setValue(amount.setScale(this.scale, IAmount.roundingMode));
	}

	void copyTo(un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType amount) {
		amount.setCurrencyID(this.getCurrencyID());
		amount.setValue(this.getValue(RoundingMode.HALF_UP));
	}
	
	public void copyTo(oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.AmountType amount) {
		amount.setCurrencyID(this.getCurrencyID());
		amount.setValue(this.getValue(RoundingMode.HALF_UP));
	}
	
	@Override
	public BigDecimal getValue(RoundingMode roundingMode) {
		return super.getValue().setScale(scale, roundingMode);
	}
	
	@Override
	public String toString() {
		return getCurrencyID()==null ? ""+getValue(roundingMode) : getCurrencyID() + getValue(roundingMode);
	}

}
