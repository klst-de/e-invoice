package com.klst.einvoice.api;

import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;

/**
 * PRICE DETAILS
 * <p>
 * A group of business terms providing information about the price applied for the goods and services
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-29
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */
public interface BG29_PriceDetails {

//	void setUnitPriceAmount(UnitPriceAmount unitPriceAmount) use CoreInvoiceLineFactory#createInvoiceLine
	/**
	 * Get item net price, exclusive of VAT, after subtracting item price discount.
	 * <p>
	 * The unit net price has to be equal with the Item gross price less the Item price discount.
	 * To set use {@link CoreInvoiceLineFactory#createInvoiceLine(String, IQuantity, IAmount, UnitPriceAmount, String, TaxCategoryCode, BigDecimal)}
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-29.BT-146 
	 * <br>Rule ID: 	BR-27 : The Item net price (BT-146) shall NOT be negative.
	 * <br>Request ID: 	R14
	 * 
	 * @return UnitPriceAmount
	 * 
	 * @see CoreInvoiceLineFactory
	 */
	public UnitPriceAmount getUnitPriceAmount();

	// BG-29.BT-146 1..1 UnitPriceAmount , UnitPriceQuantity BT-149-0 + BT-150-0 optional
	public void setUnitPriceAmountAndQuantity(UnitPriceAmount unitPriceAmount, Quantity quantity);

	/**
	 * Item price discount
	 * <p>
	 * The total discount subtracted from the Item gross price to calculate the Item net price. 
	 * Only applies if the discount is provided per unit and if it is not included in the Item gross price.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BG-29.BT-147
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R14
	 * 
	 * @return UnitPriceAmount
	 */
	public UnitPriceAmount getPriceDiscount();

	/**
	 * Item gross price
	 * <p>
	 * The unit price, exclusive of VAT, before subtracting Item price discount.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BG-29.BT-148
	 * <br>Rule ID: 	BR-28 : The Item gross price (BT-148) shall NOT be negative.
	 * <br>Request ID: 	R14
	 * 
	 * @return UnitPriceAmount
	 */
	public UnitPriceAmount getGrossPrice();
	
	/**
	 * Sets price discount and gross price
	 * 
	 * @param priceDiscount BT-147
	 * @param grossPrice BT-148
	 */
	public void setUnitPriceAllowance(UnitPriceAmount priceDiscount, UnitPriceAmount grossPrice);
	
	// optional UnitPriceQuantity : BT-149-0 QuantityUnit 0..1 + BT-150-0 Quantity required
	/**
	 * Item price unit (BT-150) and base quantity (BT-149)
	 * <p>
	 * The number of item units to which the price applies.
	 * <br>Item price base quantity unit of measure code.
	 * The unit of measure that applies to the Item price base quantity.
	 * The Item price base quantity unit of measure shall be the same as the Invoiced quantity unit of measure (BT-130).
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BG-29.BT-150 + BG-29.BT-149
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R14
	 * 
	 * @return UnitPriceQuantity
	 * @see #getQuantity
	 */
	public Quantity getUnitPriceQuantity();

}
