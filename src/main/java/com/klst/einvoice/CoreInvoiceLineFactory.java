package com.klst.einvoice;

import java.math.BigDecimal;

import com.klst.edoc.api.IAmount;
import com.klst.edoc.api.IQuantity;
import com.klst.edoc.untdid.TaxCategoryCode;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;

/**
 * abstract-factory, aka Kit to create invoice lines
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */
public interface CoreInvoiceLineFactory {

	/**
	 * factory method to create an invoice line, BG-25
	 * 
	 * @param id              : BT-126, a unique identifier for the individual line within the Invoice.
	 * @param quantity        : BT-129+BT-130, UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * @param lineTotalAmount : BT-131, the total amount of the Invoice line.
	 * @param priceAmount     : BG-29.BT-146, item net price (mandatory part in PRICE DETAILS)
	 * @param itemName        : BG-32.BT-153, a name for an item (mandatory part in ITEM INFORMATION)
	 * @param codeEnum        : BG-30.BT-151, codeEnum 1..1 VAT category code
	 * @param percent         : BG-30.BT-152, percent  0..1 VAT rate
	 * 
	 * @return invoice line object
	 * 
	 * @see BG29_PriceDetails
	 * @see BG30_LineVATInformation
	 * @see BG31_ItemInformation
	 */
	public CoreInvoiceLine createInvoiceLine(String id, IQuantity quantity, IAmount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent);

}
