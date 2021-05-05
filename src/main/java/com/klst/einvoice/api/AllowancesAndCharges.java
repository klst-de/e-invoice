package com.klst.einvoice.api;

import java.math.BigDecimal;

import com.klst.edoc.api.IAmount;
import com.klst.edoc.untdid.TaxCategoryCode;

/**
 * Common Interface for ALLOWANCES and CHARGES
 *
 * <p>
 * BG-20 0..n DOCUMENT LEVEL ALLOWANCES / ABSCHLÄGE
 * <br>
 * BG-21 0..n DOCUMENT LEVEL CHARGES / ZUSCHLÄGE
 * <br>
 * BG-27 0..n INVOICE LINE ALLOWANCES / ABSCHLÄGE
 * <br>
 * BG-28 0..n INVOICE LINE CHARGES / ZUSCHLÄGE
 * 
 * <p>
 * <p>
 * Cardinality: 	0..n
 * <br>EN16931-ID: 	BG-20 / BG-21 / BG-27 / BG-28
 * <br>Rule ID: 	
 * <br>Request ID: 	R15, R18
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */

/* ChargeIndicator
Anwendung: 
Im Fall eine Abschlags (BG-27) ist der Wert des ChargeIndicators auf "false" zu setzen.
Im Fall eine Zuschlags (BG-28) ist der Wert des ChargeIndicators auf "true" zu setzen.

Bsp 02.01 CII+UBL
            
 */
public interface AllowancesAndCharges extends AllowancesOrChargesFactory, ITaxCategory {
	
	public static final boolean ALLOWANCE = false;
	public static final boolean CHARGE = true;

	// BG-20-00, BG-21-00
	public void setChargeIndicator(boolean indicator);
	public boolean isAllowance();
	public boolean isCharge();
	
	/**
	 * BT-92, BT-99 (mandatory) Document level allowance/charge amount
	 * <p>
	 * The amount of an allowance, without VAT.
	 * 
	 * <br>Request ID: 	R15/16, R19
	 * 
	 * @param Amount amount
	 */
	/*
	 * Geschäftsregel: BR-31 Abschläge auf Dokumentenebene
	 * Jeder Abschlag auf Dokumentenebene (BG-20) muss einen Abschlagsbetrag auf der Dokumentenebene (BT-92) haben.
	 * <p>
	 * Geschäftsregel: BR-36 Zuschläge auf Dokumentenebene
	 * Jeder Zuschlag auf Dokumentenebene (BG-21) muss einen Betrag des Zuschlags auf der Dokumentenebene (BT99) haben.
	 */
	// Amount umbenennen wg. Namenskollision in UBL // in AmountWithoutTax
	public void setAmountWithoutTax(IAmount amount);
	public IAmount getAmountWithoutTax(); 

	/**
	 * BT-93, BT-100 (optional) Document level allowance/charge base amount
	 * <p>
	 * The base amount that may be used, in conjunction with the document level allowance/charge percentage, 
	 * to calculate the document level allowance/charge amount.
	 * 
	 * <br>Request ID: 	R15, R42 / R15, R16, R19
	 * 
	 * @param Amount amount
	 */
	// BaseAmount umbenennen wg. Namenskollision in UBL // in AssessmentBase
	public void setAssessmentBase(IAmount amount);
	public IAmount getAssessmentBase(); 

	/**
	 * BT-94, BT-101 (optional) Document level allowance/charge percentage
	 * <p>
	 * The percentage that may be used, in conjunction with the document level allowance/charge base amount, 
	 * to calculate the document level allowance/charge amount.
	 * 
	 * <br>Request ID: 	R15, R42 / R15, R16, R19
	 * 
	 * @param percentage
	 */
	public void setPercentage(BigDecimal percentage);
	public BigDecimal getPercentage();

	// BT-95-0, BT-102-0 (CII)
	/**
	 * {@inheritDoc}
	 * 
	 * @see com.klst.untdid.codelist.TaxTypeCode
	 */
	@Override
	public void setTaxType(String code);
	/**
	 * {@inheritDoc}
	 * 
	 * @see com.klst.untdid.codelist.TaxTypeCode
	 */
	@Override
	public String getTaxType();
	
	/**
	 * BT-95, BT-102 (mandatory) Document level allowance/charge VAT category code
	 * <p>
	 * A coded identification of what VAT category applies to the document level allowance/charge.
	 * 
	 * <br>Rule ID: 	BR-32
	 * <br>Request ID: 	R15, R16, R45, R48
	 * 
	 * @param code
	 */
	/* Codeliste: UNTDID 5153 Eingeschränkt
	 * In der EN 16931 wird nur die Steuerart „Umsatzsteuer“ mit dem Code „VAT“ unterstützt.
	 * 
	 * Sollen andere Steuerarten angegeben wie 
	 * beispielsweise eine Versicherungssteuer oder eine Mineralölsteuer werden, 
	 * muss das EXTENDED Profil genutzt werden. 
	 * Der Code für die Steuerart muss dann der Codeliste UNTDID 5153 entnommen werden.
	 * https://service.unece.org/trade/untdid/d01b/trsd/trsdtax.htm
	 * 
	 * Geschäftsregel: BR-32 Abschläge auf Dokumentenebene
	 *  Jeder Abschlag auf Dokumentenebene (BG-20) muss einen Code für die für diesen Abschlag 
	 *  geltende Umsatzsteuer auf Dokumentenebene (BT-95) haben
	 */
	@Override
	public void setTaxCategoryCode(String code);
	@Override
	public TaxCategoryCode getTaxCategoryCode();
	
	/**
	 * BT-96, BT-103 0..1 Document level allowance/charge VAT rate
	 * <p>
	 * The VAT rate, represented as percentage that applies to the document level allowance/charge.
	 * 
	 * <br>Request ID: 	R15, R16, R45, R48
	 * 
	 * @param percentage
	 */
	@Override
	public void setTaxPercentage(BigDecimal percentage);
	@Override
	public BigDecimal getTaxPercentage();

	/**
	 * BT-97, BT-104 0..1 Document level allowance/charge reason
	 * <p>
	 * The reason for the document level allowance/charge, expressed as text.
	 * 
	 * <br>Request ID: 	R15
	 * 
	 * @param text
	 */
	/*

. Geschäftsregel: BR-33 Abschläge auf Dokumentenebene
Jeder Abschlag auf Dokumentenebene (BG-20) muss einen Grund für diesen Abschlag auf Dokumentenebene (BT-97) 
oder einen Code für den Grund für diesen Abschlag auf Dokumentenebene (BT-98) haben.

. Geschäftsregel: BR-CO-22 Zuschläge auf Dokumentenebene
Jeder Zuschlag auf Dokumentenebene (BG-21) muss einen Grund für den Zuschlag auf Dokumentenebene (BT-104) 
oder einen Code des Grundes für den Zuschlag auf Dokumentenebene (BT-105) oder beides enthalten.

. Geschäftsregel: BR-CO-21 Abschläge auf Dokumentenebene
Jeder Abschlag auf Dokumentenebene (BG-20) muss einen Grund für diesen Abschlag auf Dokumentenebene (BT-97) 
oder einen Code für den Grund für diesen Abschlag auf Dokumentenebene (BT-98) oder beides enthalten.

. Geschäftsregel: BR-CO-5 Abschläge auf Dokumentenebene
Der Code des Grundes für den Abschlag auf Dokumentenebene (BT-98) 
und der Grund für den Abschlag auf Dokumentenebene (BT-97) müssen dieselbe Zuschlagsart anzeigen.

. Geschäftsregel: BR-38 Zuschläge auf Dokumentenebene
Jeder Zuschlag auf Dokumentenebene (BG-21) muss einen Grund für den Zuschlag auf Dokumentenebene (BT-104) 
oder einen Code des Grundes für den Zuschlag auf Dokumentenebene (BT-105) haben.

	 */
	public void setReasonText(String text);
	public String getReasonText();
	
	/**
	 * BT-98, BT-103 0..1 Document level allowance/charge reason code
	 * <p>
	 * The reason for the document level allowance/charge, expressed as a code.
	 * <br>Use entries of the UNTDID 5189 code list[6]. 
	 * The Document level allowance/charge reason code and the Document level allowance/charge reason 
	 * shall indicate the same allowance/charge reason.
	 * 
	 * <br>Request ID: 	R15
	 * 
	 * @param text
	 */
	/*

. Codeliste: UNTDID 7161 Vollständige Liste
AA    Advertising
AAA   Telecommunication
AAC   Technical modification
...
ABL   Additional packaging
...
ZZZ   Mutually defined

. Codeliste: UNTDID 5189 Eingeschränkt
Include PEPPOL subset:
41 - Bonus for works ahead of schedule
42 - Other bonus
60 - Manufacturer’s consumer discount
62 - Due to military status
63 - Due to work accident
64 - Special agreement
65 - Production error discount
66 - New outlet discount
67 - Sample discount
68 - End-of-range discount
70 - Incoterm discount
71 - Point of sales threshold allowance
88 - Material surcharge/deduction
95 - Discount
100 - Special rebate
102 - Fixed long term
103 - Temporary
104 - Standard
105 - Yearly turnover

	 */
	public void setReasoncode(String code);
	public String getReasoncode();
	
}
