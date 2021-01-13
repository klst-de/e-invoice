package com.klst.untdid.codelist;

import java.util.HashMap;
import java.util.Map;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;

/* urn:xoev-de:kosit:codeliste:untdid.1153
 * United Nations Trade Data Interchange Directory (UNTDID), http://www.unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tredi2.htm
 * UN/EDIFACT 1153  Reference code qualifier 

schemeID Art der Steuernummer des Verkäufers
Synonym: Steuernummer, Umsatzsteueridentnummer
Kardinalität: required
EN16931-ID: BG-4.BT-31-0, BG-4.BT-32-0
Anwendung: 
     FC = Steuernummer des Verkäufers (BT-32)
     VA = Umsatzsteueridentnummer des Verkäufers (BT-31)

Codeliste: UNTDID 1153 Untermenge
Die betriebswirtschaftlichen Begriffe werden über einen Scheme identifier unterschieden.
     Code Codename / (de) Description
     ---- -----------
     FC    Fiscal number / (Steuernummer)
              Tax payer's number. Number assigned to individual
              persons as well as to corporates by a public
              institution; this number is different from the VAT
              registration number.
...
     VA    VAT registration number / (Umsatzsteuernummer)
              Unique number assigned by the relevant tax authority to
              identify a party for use in relation to Value Added Tax
              (VAT).

 */
public enum ReferenceCode {

	FiscalNumber 			("FC"),
	VATRegistrationNumber 	("VA");
	
	/**
	 * @see <A HREF="https://unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tred1153.htm">UN/EDIFACT 1153</A>
	 */
	public static final String SCHEME_ID  = "UN/EDIFACT 1153";
	
	ReferenceCode(String value) {
		this.value = value;
	}
	
	private final String value;
	
	public String getValue() {
		return value;
	}

    private static Map<String, ReferenceCode> map = new HashMap<String, ReferenceCode>();
    static {
        for (ReferenceCode documentNameCode : ReferenceCode.values()) {
            map.put(documentNameCode.value, documentNameCode);
        }
    }
    
    public static ReferenceCode valueOf(TaxCategoryType ublCode) {
    	return ublCode.getID()==null ? null : map.get(ublCode.getID().getValue());
    } 

    public static ReferenceCode valueOf(TaxCategoryCodeType uneceCode) {
    	return map.get(uneceCode.getValue());
    } 

}
