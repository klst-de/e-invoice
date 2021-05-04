package com.klst.einvoice;

import java.math.BigDecimal;
import java.util.List;

import com.klst.edoc.api.IAmount;
import com.klst.edoc.api.IQuantity;
import com.klst.edoc.untdid.TaxCategoryCode;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;

/**
 * BG-25 INVOICE LINE
 * <p>
 * A group of business terms providing information on individual Invoice lines.
 * <p>
 * Cardinality: 	1..n
 * <br>EN16931-ID: 	BG-25
 * <br>Rule ID: 	BR-16 : An Invoice shall have at least one Invoice line.
 * <br>Request ID: 	R17 R23 R27
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */
public interface BG25_InvoiceLine extends CoreInvoiceLineFactory {

	// factory method in CoreInvoiceLineFactory
//	public CoreInvoiceLine createInvoiceLine(...
	
	// setter + getter
	
	/**
	 * Add BG-25 INVOICE LINE {@link CoreInvoiceLine} to the invoice
	 * 
	 * @param line
	 */
	public void addLine(CoreInvoiceLine line);
	default void addLine(String id, IQuantity quantity, IAmount lineTotalAmount, 
			UnitPriceAmount priceAmount, String itemName, TaxCategoryCode codeEnum, BigDecimal percent) {
		addLine(createInvoiceLine(id, quantity, lineTotalAmount, priceAmount, itemName, codeEnum, percent));
	}
	
	/**
	 * Get all BG-25 INVOICE LINEs related to the invoice. The cardinality is 1..n
	 * 
	 * @return List of {@link CoreInvoiceLine}
	 */
	public List<CoreInvoiceLine> getLines();

}
