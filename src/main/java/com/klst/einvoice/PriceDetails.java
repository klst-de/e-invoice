package com.klst.einvoice;

import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;

/* @see European standard EN 16931-1:2017
 * 
 * 
ID    | Level | Cardinality | Business Term         | Description | Usage Note | Req.ID | Semantic data type
BG-29 | ++    | 1..1        | PRICE DETAILS         | A group of business terms providing information about the price applied for the goods and services invoiced on the Invoice line.
                                                                               | R14
BT-146| +++   | 1..1        | Item net price        | The price of an item, exclusive of VAT, after subtracting item price discount.
                                                                  | The Item net price has to be equal with the Item gross price less the Item price discount.
                                                                               | R14    | Unit price amount
BT-147| +++   | 0..1        | Item price discount   | The total discount subtracted from the Item gross price to calculate the Item net price.
                                                                  | Only applies if the discount is provided per unit and if it is not included in the Item gross price.
                                                                               | R14    | Unit price amount
BT-148| +++   | 0..1        | Item gross price      | The unit price, exclusive of VAT, before subtracting Item price discount.
                                                                               | R14    | Unit price amount
BT-149| +++   | 0..1        | Item price base quantity | The number of item units to which the price applies. 
                                                                               | R14    | Quantity
BT-150| +++   | 0..1        | Item price base quantity unit of measure code | The unit of measure that applies to the Item price base quantity.
                                                                  | The Item price base quantity unit of measure shall be the same as the Invoiced quantity unit of measure (BT-130).
                                                                               | R14    | Code
 */
public interface PriceDetails {

	public void setItemNetPrice(UnitPriceAmount priceAmount); // mandatory
	
	// Cardinality: 0..1 (optional)
	public void setItemPriceDiscount(UnitPriceAmount priceAmount);
	public void setItemGrossPrice(UnitPriceAmount priceAmount);
	public void setItemBaseQuantity(Quantity quantity);
//	public void setItemBaseUoM(String unitCode); // use unitCode in	Quantity
}
