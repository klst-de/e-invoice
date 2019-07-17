package com.klst.einvoice.ubl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.klst.einvoice.Rounding;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;


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

