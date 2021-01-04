package com.klst.einvoice;

import java.math.BigDecimal;
import java.util.List;

import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;
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
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for EN_16931_1_2017 rule and request IDs
 */
public interface CoreInvoiceLine extends BG26_InvoiceLinePeriod {

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
//	public void setId(String id); // use ctor
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

	/*
	 * Eine vom Verkäufer angegebene Kennung für einen Gegenstand, auf dem die Rechnungsposition basiert
	 * EN16931-ID: BT-128-0 1..1 TypeCode = "130" Rechnungsdatenblatt, UNTDID 1001 Untermenge
	 * EN16931-ID: BT-128-1 0..1 UNTDID 1153
	 */
	/*    TODO
	 * Invoice line object identifier
	 * <p>
	 * An identifier for an object on which the invoice line is based, given by the Seller.
	 * It may be a subscription number, telephone number, meter point etc., as applicable.  
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-128
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R33
	 * 
	 * @param Identifier
	 * @param schemeID, (optional) ff it may be not clear for the receiver what scheme is used for the identifier, 
	 * a conditional scheme identifier should be used that shall be chosen from the UNTDID 1153 code list entries.
	 */
//	public void setIssuerAssignedID(String id, String schemeID);
//	public String getIssuerAssignedID();

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
//	public void setItemName(String text); // use ctor
	public String getItemName();

	/**
	 * Item description (optional part in 1..1 BG-31 ITEM INFORMATION)
 	 * <p>
	 * The Item description allows for describing the item and its features in more detail than the Item name.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-154
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R20, R56
	 * 
	 * @param Text
	 */
	public void setDescription(String text);
	public String getDescription();

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
//	public void setQuantity(Quantity quantity); // use ctor
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
//	public void setLineTotalAmount(Amount amount); // use ctor
	public Amount getLineTotalAmount();

	/*
Bsp. CII 01.01a-INVOICE_uncefact.xml :
                <ram:BuyerOrderReferencedDocument>
                    <ram:LineID>6171175.1</ram:LineID>
                </ram:BuyerOrderReferencedDocument>
     UBL
        <cac:OrderLineReference>
            <cbc:LineID>6171175.1</cbc:LineID>
        </cac:OrderLineReference>

	 */
	/**
	 * Referenced purchase order line reference
	 * <p>
	 * An identifier for a referenced line within a purchase order, issued by the Buyer.
	 * The purchase order identifier is referenced on document level. 
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-132
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R6
	 * 
	 * @param reference id
	 */
	public void setOrderLineID(String id);
	public String getOrderLineID();

	/**
	 * Item net price (mandatory part in PRICE DETAILS), exclusive of VAT, after subtracting item price discount.
	 * <p>
	 * The unit net price has to be equal with the Item gross price less the Item price discount.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BG-29, BT-146 
	 * <br>Rule ID: 	BR-27
	 * <br>Request ID: 	R14
	 * 
	 * @param UnitPriceAmount
	 */
//	public void setUnitPriceAmount(UnitPriceAmount unitPriceAmount); // use ctor
	public UnitPriceAmount getUnitPriceAmount();

	// 1 .. 1 ChargeAmount BT-146 , BaseQuantity BT-149-0 + BT-150-0 optional
	public void setUnitPriceAmountAndQuantity(UnitPriceAmount unitPriceAmount, Quantity baseQuantity);

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
//	public void setTaxCategory(TaxCategoryCode codeEnum); // use ctor 
	public TaxCategoryCode getTaxCategory(); 
	// + 0..1 EN16931-ID: BT-152 Invoiced item VAT rate
//	public void setTaxCategoryAndRate(TaxCategoryCode codeEnum, BigDecimal percent); // use ctor
	public BigDecimal getTaxRate(); 

	/**
	 * Item Seller's identifier (optional part in 1..1 BG-31 ITEM INFORMATION)
 	 * <p>
	 * An identifier, assigned by the Seller, for the item.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-155
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R21, R56
	 * 
	 * @param Identifier
	 */
	public void setSellerAssignedID(String id);
	public String getSellerAssignedID();

	/**
	 * Item Buyer's identifier (optional part in 1..1 BG-31 ITEM INFORMATION)
 	 * <p>
	 * An identifier, assigned by the Buyer, for the item.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-156
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R21, R56, R22
	 * 
	 * @param Identifier
	 */
	public void setBuyerAssignedID(String id);
	public String getBuyerAssignedID();
	
	/*
	 * GlobalID Kennung eines Artikels nach registriertem Schema
	 * CII:
	 * BG-31    1 .. 1   SpecifiedTradeProduct
	 * BT-157   0 .. 1   GlobalID
	 * BT-157-1          required schemeID
	 * Codeliste: ISO 6523 :
	 * 0021 : SWIFT 
	 * 0088 : EAN 
	 * 0060 : DUNS 
	 * 0177 : ODETTE automotive industry
	 */
	/**
	 * Item standard identifier (optional part in 1..1 BG-31 ITEM INFORMATION)
 	 * <p>
	 * An item identifier based on a registered scheme.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-157 BT-157-1
	 * <br>Rule ID: 	BR-64
	 * <br>Request ID: 	R23, R56
	 * 
	 * @param Identifier
	 * @param schemeID, The identification scheme shall be identified from the entries of the list published by the ISO/IEC 6523 maintenance agency.
	 */
	public void setStandardID(String globalID, String schemeID);
	public void setStandardID(String globalID);
	public void setStandardIdentifier(Identifier id);
	public Identifier getStandardIdentifier();
	public String getStandardID();

	/**
	 * Item classification identifier (optional part in 1..1 BG-31 ITEM INFORMATION)
 	 * <p>
	 * A code for classifying the item by its type or nature.
	 * Classification codes are used to allow grouping of similar items for a various purposes e.g. public procurement (CPV), e-Commerce (UNSPSC) etc.
	 * <p>
	 * Cardinality: 	0..n (optional)
	 * <br>EN16931-ID: 	BT-158
	 * <br>Rule ID: 	BR-64
	 * <br>Request ID: 	R24
	 * 
	 * @param Identifier
	 * @param schemeID,      BT-158-1 1..1 The identification scheme shall be chosen from the entries in UNTDID 7143
	 * @param schemeVersion, BT-158-2 0..1 Scheme version identifier - The version of the identification scheme.
	 */
	public void addClassificationID(String id, String schemeID, String schemeVersion);
	public void addClassificationID(Identifier id);
	@Deprecated
	public List<Object> getClassificationList();
	public List<Identifier> getClassifications();

	/**
	 * Item country of origin (optional part in 1..1 BG-31 ITEM INFORMATION)
 	 * <p>
	 * The code identifying the country from which the item originates.
	 * The lists of valid countries are registered with the EN ISO 3166-1 Maintenance agency, 
	 * “Codes for the representation of names of countries and their subdivisions”.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-159
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R29 
	 * 
	 * @param code
	 */
	public void setCountryOfOrigin(String code);
	public String getCountryOfOrigin();

}
