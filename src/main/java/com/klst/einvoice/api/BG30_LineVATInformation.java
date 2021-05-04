package com.klst.einvoice.api;

import java.math.BigDecimal;

import com.klst.edoc.untdid.TaxCategoryCode;

/**
 * LINE VAT INFORMATION
 * <p>
 * A group of business terms providing information about the VAT applicable for the goods and services 
 * <p>
 * Cardinality: 	1..1
 * <br>EN16931-ID: 	BG-30
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 * 
 * @see CoreInvoiceLineFactory
 */
public interface BG30_LineVATInformation {

//	public void setTaxCategory(TaxCategoryCode codeEnum); // use use CoreInvoiceLineFactory#createInvoiceLine 
	/**
	 * Invoiced item VAT category code
	 * <p>
	 * The VAT category code for the invoiced item.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-30.BT-151, BT-151-0
	 * <br>Rule ID: 	BR-CO-4
	 * <br>Request ID: 	R37, R45, R48, R55
	 * 
	 * @return {@link TaxCategoryCode}
	 */
	public TaxCategoryCode getTaxCategory();
	
	// 0..1 EN16931-ID: BT-152 Invoiced item VAT rate
//	public void setTaxCategoryAndRate(TaxCategoryCode codeEnum, BigDecimal percent); // use factory
	
	/**
	 * Invoiced item VAT rate
	 * <p>
	 * The VAT rate, represented as percentage that applies to the invoiced item.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BG-30.BT-152
	 * <br>Rule ID:
	 * <br>Request ID: 	R37, R45, R48
	 * 
	 * @return percentage
	 */
	public BigDecimal getTaxRate(); 

}
