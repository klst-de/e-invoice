package com.klst.einvoice.ubl;

import com.klst.untdid.codelist.TaxTypeCode;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;

// verwendet in
// ALLOWANCES (BG-20) and CHARGES (BG-21) : BT-95-0, BT-102-0
// BG-23.BT-118-0
public class TaxScheme extends TaxSchemeType {

	TaxScheme(String code) {
		super();
		super.setID(new Identifier(code));
	}
	TaxScheme() {
		this(TaxTypeCode.VAT);
	}
	
}
