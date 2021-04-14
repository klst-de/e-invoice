package com.klst.einvoice;

import java.math.BigDecimal;

import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.edoc.untdid.TaxCategoryCode;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;

/**
 * abstract-factory, aka Kit to create invoices
 * 
 * @see <a href="https://java-design-patterns.com/patterns/abstract-factory/">java-design-patterns</a> for patterns abstract-factory
 */
public interface CoreInvoiceFactory {
	
	/**
	 * factory method to create an invoice object, uses PROCESS CONTROL (BG-2) params
	 * 
	 * @param CustomizationID aka profile Identifier String, f.i. PROFILE_EN_16931, BG-2.BT-24
	 * @param processType (optional) Textstring identifying the business process context, BG-2.BT-23
	 * @param Invoice type code - A code specifying the functional type of the Invoice, BT-3
	 * 
	 * @return invoice object
	 * 
	 * @see BG2_ProcessControl#getCustomization()
	 * @see BG2_ProcessControl#getProcessType()
	 */
	public CoreInvoice createInvoice(String profile, String processType, DocumentNameCode code);
	
	default CoreInvoice createInvoice(String profile, DocumentNameCode code) {
		return createInvoice(profile, null, code);
	}

	/**
	 * factory method to create an invoice line, BG-25
	 * 
	 * @param id              : BT-126, a unique identifier for the individual line within the Invoice.
	 * @param quantity        : BT-129+BT-130, UoM and quantity of items (goods or services) that is charged in the Invoice line.
	 * @param lineTotalAmount : BT-131, the total amount of the Invoice line.
	 * @param priceAmount     : BT-146, item net price (mandatory part in PRICE DETAILS)
	 * @param itemName        : BT-153, a name for an item (mandatory part in ITEM INFORMATION)
	 * @param codeEnum        : BG-30.BT-151, codeEnum 1..1 VAT category code
	 * @param percent         : BG-30.BT-152, percent  0..1 VAT rate
	 * 
	 * @return invoice line object
	 */
	public CoreInvoiceLine createInvoiceLine(String id, Quantity quantity, Amount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent);

}
