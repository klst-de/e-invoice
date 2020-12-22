package com.klst.einvoice.ubl;

import com.klst.einvoice.ITaxType;
import com.klst.untdid.codelist.TaxTypeCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;

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
// verwendet in
// ALLOWANCES (BG-20) and CHARGES (BG-21) : BT-95-0, BT-102-0
// BG-23.BT-118-0
public class TaxScheme extends TaxSchemeType implements ITaxType {

	/**
	 * factory method to create different tax types
	 * 
	 * @param type enum, example TaxTypeCode.PetroleumTax or InsuranceTax
	 * @return
	 */
	static public TaxScheme createTaxType(TaxTypeCode type) {
		return new TaxScheme(type.getValue());
	}
	
	TaxScheme(String type) {
		super();
		setTaxType(type);
	}

	TaxScheme() {
		this(TaxTypeCode.VAT);
	}

	@Override
	public void setTaxType(String type) {
		super.setID(new Identifier(type));
	}

	@Override
	public String getTaxType() {
		return super.getID().getValue();
	}
	static String getTaxType(TaxSchemeType taxScheme) {
		return taxScheme.getID().getValue();
	}
	
}
