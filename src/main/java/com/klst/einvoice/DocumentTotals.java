package com.klst.einvoice;

import com.klst.einvoice.unece.uncefact.Amount;

/* @see European standard EN 16931-1:2017
 * 
 * 
ID    | Level | Cardinality | Business Term         | Description | Usage Note | Req.ID   | Semantic data type
BG-22 | +     | 1..1        | DOCUMENT TOTALS       | A group of business terms providing the monetary totals for the Invoice. 
                                                                               | R40

BT-106| ++    | 1..1 | Sum of Invoice line net amount      | Sum of all Invoice line net amounts in the Invoice. 
                                                                               | R40      | Amount
BT-107| ++    | 0..1 | Sum of allowances on document level | Sum of all allowances on document level in the Invoice.
                                                                  | Allowances on line level are included in the Invoice line net amount which is summed up into the Sum of Invoice line net amount.
                                                                               | R19, R40 | Amount
BT-108| ++    | 0..1 | Sum of charges on document level    | Sum of all charges on document level in the Invoice.
                                                                  | Charges on line level are included in the Invoice line net amount which is summed up into the Sum of Invoice line net amount.
                                                                               | R19,R40  | Amount
BT-109| ++    | 1..1 | Invoice total amount without VAT    | The total amount of the Invoice without VAT.
                                                                  | The Invoice total amount without VAT is the Sum of Invoice line net amount minus Sum of allowances on document level plus Sum of charges on document level.
                                                                               | R40      | Amount
BT-110| ++    | 0..1 | Invoice total VAT amount            | The total VAT amount for the Invoice.
                                                                  | The Invoice total VAT amount is the sum of all VAT category tax amounts.
                                                                               | R40, R49 | Amount
BT-111| ++    | 0..1 | Invoice total VAT amount in accounting currency | The VAT total amount expressed in the accounting currency accepted or required in the country of the Seller.
                                                                  | To be used when the VAT accounting currency (BT-6) differs from the Invoice currency code (BT-5) in accordance with article 230 of Directive 2006/112 / EC on VAT.
                                                                    The VAT amount in accounting currency is not used in the calculation of the Invoice totals.
                                                                               | R54      | Amount
BT-112| ++    | 1..1 | Invoice total amount with VAT       | The total amount of the Invoice with VAT.
                                                                  | The Invoice total amount with VAT is the Invoice total amount without VAT plus the Invoice total VAT amount.
                                                                               | R40, R67 | Amount
BT-113| ++    | 0..1 | Paid amount                         | The sum of amounts which have been paid in advance.
                                                                  | This amount is subtracted from the invoice total amount with VAT to calculate the amount due for payment.
                                                                               | R40, R66 | Amount
BT-114| ++    | 0..1 | Rounding amount                     | The amount to be added to the invoice total to round the amount to be paid.
                                                                               | R40      | Amount
BT-115| ++    | 1..1 | Amount due for payment              | The outstanding amount that is requested to be paid.
                                                                  | This amount is the Invoice total amount with VAT minus the paid amount that has been paid in advance. 
                                                                    The amount is zero in case of a fully paid Invoice. The amount may be negative; 
                                                                    in that case the Seller owes the amount to the Buyer.
                                                                               | R40, R59, R68 | Amount
 */
public interface DocumentTotals {

	/**
	 * mandatory total amounts of the invoice
	 * 
	 * @param lineExtension : Sum of Invoice line net amount
	 * @param taxExclusive : Invoice total amount without VAT
	 * @param taxInclusive : Invoice total amount with VAT
	 * @param payable : Amount due for payment 
	 */
	public void setDocumentTotals(Amount lineNet, Amount taxExclusive, Amount taxInclusive, Amount payable);

	// not implemeted, use setDocumentTotals
//	public void setInvoiceLineNetTotal(Amount amount); // mandatory
//	public void setInvoiceTotalTaxExclusive(Amount amount); // mandatory
//	public void setInvoiceTotalTaxInclusive(Amount amount); // mandatory
//	public void setDuePayable(Amount amount); // mandatory
	
	public Amount getInvoiceLineNetTotal(); 
	public Amount getInvoiceTotalTaxExclusive(); 
	public Amount getInvoiceTotalTaxInclusive(); 
	public Amount getDuePayable(); 
	
	/**
	 * Sum of all allowances on document level in the Invoice.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-107
	 * <br>Req.ID: R19, R40
	 * 
	 * @param amount , Allowances on line level are included in the Invoice line net amount which is summed up into the Sum of Invoice line net amount.
	 */
	public void setAllowancesTotal(Amount amount);
	
	/**
	 * Sum of all charges on document level in the Invoice.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-108
	 * <br>Req.ID: R19,R40
	 * 
	 * @param amount , Charges on line level are included in the Invoice line net amount which is summed up into the Sum of Invoice line net amount.
	 */
	public void setChargesTotal(Amount amount);
	
	/**
	 * The total VAT amount for the Invoice.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-110
	 * <br>Req.ID: R40, R49
	 * 
	 * @param amount , The Invoice total VAT amount is the sum of all VAT category tax amounts.
	 */
	public void setInvoiceTax(Amount amount);
	public Amount getInvoiceTax(); 
	
	/**
	 * Invoice total VAT amount in accounting currency
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-111
	 * <br>Req.ID: R54
	 * 
	 * @param amount , The VAT total amount expressed in the accounting currency accepted or required in the country of the Seller.
	 * <br> To be used when the VAT accounting currency (BT-6) differs from the Invoice currency code (BT-5) 
	 *  in accordance with article 230 of Directive 2006/112 / EC on VAT.
	 * <br> The VAT amount in accounting currency is not used in the calculation of the Invoice totals.
	 */
	public void setInvoiceTaxInAccountingCurrency(Amount amount);
	
	/**
	 * The sum of amounts which have been paid in advance.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-113
	 * <br>Req.ID: R40, R66 
	 * 
	 * @param amount , This amount is subtracted from the invoice total amount with VAT to calculate the amount due for payment.                                                                
	 */
	public void setPaid(Amount amount);
	
	/**
	 * Rounding amount  
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>ID: BT-114
	 * <br>Req.ID: R40
	 * 
	 * @param amount , The amount to be added to the invoice total to round the amount to be paid.
	 */
	public void setRounding(Amount amount);
	
}
