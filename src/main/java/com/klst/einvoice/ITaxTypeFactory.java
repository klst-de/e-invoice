package com.klst.einvoice;

import com.klst.untdid.codelist.TaxTypeCode;

public interface ITaxTypeFactory {

	/**
	 * BG-23.BT-118-0 Tax Categoty TypeCode, 
	 * also used in EN16931-IDs BG-20.BT-95-0 , BG-21.BT-102-0 and BG-30.BT-151-0
	 * 
	 * @param type typically VAT
	 */
	public ITaxType createTaxType(String type);
	
	default ITaxType createTaxType(TaxTypeCode type) {
		return createTaxType(type.getValue());
	}
	
	default ITaxType createVATType() {
		return createTaxType(TaxTypeCode.VAT);
	}

}
