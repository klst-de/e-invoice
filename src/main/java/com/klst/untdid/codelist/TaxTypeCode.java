package com.klst.untdid.codelist;

import java.util.HashMap;
import java.util.Map;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;

/* urn:xoev-de:kosit:codeliste:untdid.5305
 * United Nations Trade Data Interchange Directory (UNTDID), http://www.unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tredi2.htm
 * UN/EDIFACT 5153  Duty or tax or fee type name code

Eingeschränkt
In der EN 16931 wird nur die Steuerart „Umsatzsteuer“ mit dem Code „VAT“ unterstützt.
Sollen andere Steuerarten angegeben wie beispielsweise eine Versicherungssteuer oder eine Mineralölsteuer werden, 
muss das EXTENDED Profil genutzt werden. 
Der Code für die Steuerart muss dann der Codeliste UNTDID 5153 entnommen werden

     AAA   Petroleum tax
              A tax levied on the volume of petroleum being  transacted.

     AAB   Provisional countervailing duty cash
              Countervailing duty paid in cash prior to a formal finding of subsidization by Customs.

     AAC   Provisional countervailing duty bond
              Countervailing duty paid by posting a bond during an investigation period 
              prior to a formal decision on subsidization by Customs.

     AAD   Tobacco tax
              A tax levied on tobacco products.

     AAE   Energy fee
              General fee or tax for the use of energy.

     AAF   Coffee tax
              A tax levied specifically on coffee products.
     
     ...
     
     VAT   Value added tax
              A tax on domestic or imported goods applied to the value
              added at each stage in the production/distribution cycle

 */
public enum TaxTypeCode {

	PetroleumTax 		("AAA"),
	ValueAddedTax 	    ("VAT"); // the default
	
	public static final String VAT = TaxTypeCode.ValueAddedTax.getValue();
	
	/**
	 * @see <A HREF="https://unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tred5153.htm">UN/EDIFACT 5153</A>
	 */
	public static final String SCHEME_ID  = "UN/EDIFACT 5153";
	
	TaxTypeCode(String value) {
		this.value = value;
	}
	
	private final String value;
	
	public String getValue() {
		return value;
	}

    private static Map<String, TaxTypeCode> map = new HashMap<String, TaxTypeCode>();
    static {
        for (TaxTypeCode documentNameCode : TaxTypeCode.values()) {
            map.put(documentNameCode.value, documentNameCode);
        }
    }
    
    public static TaxTypeCode valueOf(TaxCategoryType ublCode) {
    	return ublCode.getID()==null ? null : map.get(ublCode.getID().getValue());
    } 

    public static TaxTypeCode valueOf(TaxCategoryCodeType uneceCode) {
    	return map.get(uneceCode.getValue());
    } 

}
