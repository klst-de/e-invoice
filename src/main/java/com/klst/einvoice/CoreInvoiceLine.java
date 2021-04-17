package com.klst.einvoice;

import java.util.List;

import com.klst.edoc.api.IAmount;
import com.klst.edoc.api.IQuantity;

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
 * 
 * @see BG26_InvoiceLinePeriod
 * @see BG27_LineLevelAllowences
 * @see BG28_LineLevelCharges
 * @see BG29_PriceDetails
 * @see BG30_LineVATInformation
 * @see BG31_ItemInformation
 * @see BG32_ItemAttributes
 */
public interface CoreInvoiceLine extends CoreInvoiceLineFactory, BG26_InvoiceLinePeriod, BG27_LineLevelAllowences, 
	BG28_LineLevelCharges, BG29_PriceDetails, BG30_LineVATInformation, BG31_ItemInformation, BG32_ItemAttributes {

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
//	0 .. 1 IssuerAssignedID Objektkennung auf Ebene der Rechnungsposition, Wert             	BT-128
//	1 .. 1 TypeCode Typ der Kennung für einen Gegenstand, auf dem die Rechnungsposition basiert BT-128-0
//	0 .. 1 ReferenceTypeCode Kennung des Schemas                                                BT-128-1	
	 */
	/**
	 * Invoice line object identifier
	 * <p>
	 * An identifier for an object on which the invoice line is based, given by the Seller.
	 * It may be a subscription number, telephone number, meter point etc., as applicable.  
	 * <p>
	 * Cardinality: 0..1 (optional)
	 * <br>EN16931-ID: 	BT-128, BT-128-0, BT-128-1
	 * <br>Rule ID: 	
	 * <br>Request ID: 	R33
	 * 
	 * @param id
	 * @param schemeID (optional) if it may be not clear for the receiver what scheme is used for the identifier, 
	 * a conditional scheme identifier should be used that shall be chosen from the UNTDID 1153 code list entries.
	 * @param schemeCode example AAC :  Documentary credit identifier
	 */
	public void setLineObjectID(String id, String schemeID, String schemeCode);
	public void setLineObjectID(String id);
	public void setLineObjectID(String id, String schemeID);
	public void setLineObjectIdentifier(GlobalIdentifier id);
	public GlobalIdentifier getLineObjectIdentifier();

	/**
	 * Get billed quantity and UoM of items (goods or services) that is charged in the Invoice line.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-129 (decimal quantity) + BT-130 (unitCode) 
	 * <br>Rule ID: 	BR-22
	 * <br>Request ID: 	R14, R39, R56
	 * 
	 * @return {@link IQuantity} contains unit of measure and quantity of items
	 */
	public IQuantity getQuantity();
//	public void setQuantity(Quantity quantity); // use factory

	/**
	 * Get invoice line net amount 
	 * <p>
	 * The total amount of the Invoice line. The amount is “net” without VAT, i.e.
	 * inclusive of line level allowances and charges as well as other relevant taxes.
	 * <p>
	 * Cardinality: 	1..1 (mandatory)
	 * <br>EN16931-ID: 	BT-131
	 * <br>Rule ID: 	BR-24
	 * <br>Request ID: 	R39, R56, R14
	 * 
	 * @return {@link IAmount}
	 */
	public IAmount getLineTotalAmount();
//	public void setLineTotalAmount(Amount amount); // use factory

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
	 * Invoice line Buyer accounting reference
	 * <p>
	 * A textual value that specifies where to book the relevant data into the Buyer's financial accounts.
	 * If required, this reference shall be provided by the Buyer to the Seller prior to the issuing of the Invoice.
	 * <p>
	 * Cardinality: 	0..1 (optional)
	 * <br>EN16931-ID: 	BT-133
	 * <br>Rule ID: 	 
	 * <br>Request ID: 	R3
	 * 
	 * @param Text
	 */
	public void setBuyerAccountingReference(String text);
	public String getBuyerAccountingReference();

	// BG-26 0..1 INVOICE LINE PERIOD with 
	//       BT-134 0..1 Invoice line period start date
	//       BT-135 0..1 Invoice line period end date
	
	/**
	 * add an allowance or charge
	 * <p>
	 * BG-27 0..n INVOICE LINE ALLOWANCES / ABSCHLÄGE
	 * <br>
	 * BG-28 0..n INVOICE LINE CHARGES / ZUSCHLÄGE
	 * 
	 * @param allowanceOrCharge
	 */
	public void addAllowanceCharge(AllowancesAndCharges allowanceOrCharge);
	public List<AllowancesAndCharges> getAllowancesAndCharges();

	
	// BG-29 1..1 PRICE DETAILS with BT-146 net price to BT-150 price unit
	
	// BG-30 1..1 LINE VAT INFORMATION with BT-151 VAT category code and BT-152 rate
	
	// BG-31 1..1 ITEM INFORMATION with BT-153 Item name to BT-159 country of origin
	
}
