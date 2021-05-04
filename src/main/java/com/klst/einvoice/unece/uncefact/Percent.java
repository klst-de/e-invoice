package com.klst.einvoice.unece.uncefact;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.klst.edoc.api.Rounding;

import un.unece.uncefact.data.standard.unqualifieddatatype._100.PercentType;

/**
 * Percentage: 
 * 
 * This is a "decimal" type with 4 digits maximum after the decimal point, without a thousand separator, and with the ". " as a decimal separator. 
 * To apply this percentage to the amount to which it applies, it is appropriate in the calculations to divide the percentage value indicated by 100. 
 * For a VAT rate of 20%, the value is therefore 20. 
 * 
 * Example 24.1234 for a percentage of 24.1234%
 *
 * for more details, see chapter 6.5 of the Semantic Standard EN 16931-1: 2017
 */
public class Percent extends PercentType implements Rounding {

	// in EN 16931-1:2017/A1:2019 + AC:2020 entfällt die Einschränkung:
	//  „Typ repräsentiert eine Fließkommazahl ohne Limitierung der Anzahl an Nachkommastellen.“ 
	public static final int SCALE = 4;

	Percent() {
		super();
	}

	public Percent(BigDecimal value) {
		this();
		this.setValue(value);
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
		return getValue()==null ? null : "" + getValue(RoundingMode.HALF_UP);
	}

}
