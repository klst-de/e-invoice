package com.klst.cius;

import java.math.BigDecimal;

import com.klst.un.unece.uncefact.Amount;
import com.klst.un.unece.uncefact.Quantity;
import com.klst.un.unece.uncefact.UnitPriceAmount;
import com.klst.untdid.codelist.TaxCategoryCode;

/**
 * INVOICE LINE
 * <p>
 * A group of business terms providing information on individual Invoice lines.
 * <p>
 * Cardinality: 1..n (mandatory)
 * <br>EN16931-ID: 	BG-25
 * <br>Rule ID: 	BR-16 
 * <br>Request ID: 	R17 R23 R27
 */
public interface CoreInvoiceLine {

	/**
	 * Invoice line identifier
	 * <p>
	 * A unique identifier for the individual line within the Invoice.
	 * <p>
	 * Cardinality: 1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-126
	 * <br>Rule ID: 	BR-21
	 * <br>Request ID: 	R44
	 * 
	 * @param id Identifier
	 */
	public void setId(String id);
	public String getId();

	/**
	 * Invoice line note
	 * <p>
	 * A textual note that gives unstructured information that is relevant to the Invoice line.
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-127
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R28
	 * 
	 * @param text Text
	 */
	public void setNote(String text);
	public String getNote();

	// 1 .. 1 SpecifiedTradeProduct Artikelinformationen                                                BG-31
	// 0 .. 1 GlobalID Kennung eines Artikels nach registriertem Schema                                 BT-157 
    //        required schemeID Kennung des Schemas                                                     BT-157-1 
	// 0 .. 1 SellerAssignedID Artikelnummer des Verkäufers                                             BT-155 
	// 0 .. 1 BuyerAssignedID Artikelnummer des Käufers                                                 BT-156 
	// 1 .. 1 Name Artikelname                                                                          BT-153 

	/**
	 * Item name (mandatory part in 1..1 BG-31 ITEM INFORMATION)
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-153 
	 * <br>Rule ID: 	BR-25
	 * <br>Request ID: 	R20, R56
	 * 
	 * @param text Text
	 */
	public void setItemName(String text);
	public String getItemName();

	/**
	 * Billed quantity and UoM of items (goods or services) that is charged in the Invoice line.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-129 BT-130  
	 * <br>Rule ID: 	BR-22
	 * <br>Request ID: 	R14, R39, R56
	 * 
	 * @param Quantity
	 */
	public void setQuantity(Quantity quantity);
	public Quantity getQuantity();

	/**
	 * Invoice line net amount 
	 * <p>
	 * The total amount of the Invoice line. The amount is “net” without VAT, i.e.
	 * inclusive of line level allowances and charges as well as other relevant taxes.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-131
	 * <br>Rule ID: 	BR-24
	 * <br>Request ID: 	R39, R56, R14
	 * 
	 * @param Amount
	 */
	public void setLineTotalAmount(Amount amount);
	public Amount getLineTotalAmount();

	/**
	 * Item net price (mandatory part in PRICE DETAILS), exclusive of VAT, after subtracting item price discount.
	 * <p>
	 * The Item net price has to be equal with the Item gross price less the Item price discount.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-29, BT-146 
	 * <br>Rule ID: 	BR-27
	 * <br>Request ID: 	R14
	 * 
	 * @param UnitPriceAmount
	 */
	public void setUnitPriceAmount(UnitPriceAmount unitPriceAmount);
	public UnitPriceAmount getItemNetPrice();

	// 1 .. 1 ChargeAmount BT-146 , BaseQuantity BT-149-0 + BT-150-0 optional
	public void setUnitPriceAmountAndQuantity(UnitPriceAmount unitPriceAmount, Quantity quantity);

	// optional BaseQuantity : BT-149-0 QuantityType 0..1 + BT-150-0 required
	public Quantity getBaseQuantity();
	
	/**
	 * Invoiced item VAT category code
	 * <p>
	 * The VAT category code for the invoiced item.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-30, BT-151, BT-151-0
	 * <br>Rule ID: 	BR-CO-4
	 * <br>Request ID: 	R37, R45, R48, R55
	 * 
	 * @param Code
	 */
	public void setTaxCategory(TaxCategoryCode codeEnum); 
	public TaxCategoryCode getTaxCategory(); 
	// + 0..1 EN16931-ID: BT-152 Invoiced item VAT rate
//	public void setTaxCategoryAndRate(TaxCategoryCode codeEnum, Percent percent); // Percent nur UN
//	public Percent getTaxRate(); 
	public void setTaxCategoryAndRate(TaxCategoryCode codeEnum, BigDecimal percent);
	public BigDecimal getTaxRate(); 

}
