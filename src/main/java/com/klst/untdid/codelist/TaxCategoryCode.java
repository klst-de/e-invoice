package com.klst.untdid.codelist;

import java.util.HashMap;
import java.util.Map;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.TaxCategoryCodeType;

/* urn:xoev-de:kosit:codeliste:untdid.5305
 * United Nations Trade Data Interchange Directory (UNTDID), http://www.unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tredi2.htm
 * UN/EDIFACT 5305  Duty or tax or fee category code

Der Code der für den in Rechnung gestellten Posten geltenden Umsatzsteuerkategorie.
Anmerkung: nicht alle Codes aus der Codeliste UNTDID 5305 werden verwendet

     AE    VAT Reverse Charge
              Code specifying that the standard VAT rate is levied from the invoicee.

     E     Exempt from tax
              Code specifying that taxes are not applicable.

     G     Free export item, tax not charged
              Code specifying that the item is free export and taxes are not charged.

+    K     VAT exempt for EEA intra-community supply of goods and services
              A tax category code indicating the item is VAT exempt
              due to an intra-community supply in the European Economic Area.
              
+    L     Canary Islands general indirect tax
              Impuesto General Indirecto Canario (IGIC) is an indirect tax levied on goods and services supplied 
              in the Canary Islands (Spain) by traders and professionals, as well as on import of goods.

+    M     Tax for production, services and importation in Ceuta and Melilla
              Impuesto sobre la Producción, los Servicios y la Importación (IPSI) is an indirect municipal tax, 
              levied on the production, processing and import of all kinds of movable tangible property, 
              the supply of services and the transfer of immovable property located in the cities of Ceuta and Melilla.
              
     O     Services outside scope of tax
              Code specifying that taxes are not applicable to the services.
              
     S     Standard rate
              Code specifying the standard rate.

     Z     Zero rated goods
              Code specifying that the goods are at a zero rate.

 */
/**
 * The following entries of UNTDID 5305 are used (further clarification between brackets)
 * <p>
 * <br> - Standard rate (Liable for VAT in a standard way)
 * <br> - Zero rated goods (Liable for VAT with a percentage rate of zero)
 * 
 * <br> - Exempt from tax (VAT/IGIC/IPSI)
 * <br> - VAT Reverse Charge (Reverse charge VAT/IGIC/IPSI rules apply)
 * <br> - VAT exempt for intra community supply of goods (VAT/IGIC/IPSI not levied due to Intra-community supply rules)
 * <br> - Free export item, tax not charged (VAT/IGIC/IPSI not levied due to export outside of the EU)
 * <br> - Services outside scope of tax (Sale is not subject to VAT/IGIC/IPSI)
 * 
 * <br> - Canary Islands General Indirect Tax IGIC (Liable for IGIC tax)
 * <br> - Liable for IPSI (Ceuta/Melilla tax)
 */
public enum TaxCategoryCode {

	StandardRate 		("S"),
	ZeroRatedGoods 		("Z"),
	ExemptFromTax 		("E"),
	VATreverseCharge 	("AE"),
	VATexemptForEEA 	("K"),
	FreeExport 			("G"),
	ServicesOutsideScope ("O"),
	
	/**
	 * IGIC/Impuesto General Indirecto Canario (Canary Islands general indirect tax)
	 */
	CanaryIslandsTax 	("L"),
	/**
	 * IPSI/Impuesto sobre la Producción, los Servicios y la Importación 
	 * (Tax for production, services and importation in Ceuta and Melilla)
	 */
	CeutaMelillaTax 	("M");
	
	/**
	 * @see <A HREF="http://www.unece.org/trade/untdid/d13b/tred/tred5305.htm">UN/EDIFACT 5305</A>
	 */
	public static final String SCHEME_ID  = "UN/EDIFACT 5305";
	
	TaxCategoryCode(String value) {
		this.value = value;
	}
	
	private final String value;
	
	public String getValue() {
		return value;
	}

    private static Map<String, TaxCategoryCode> map = new HashMap<String, TaxCategoryCode>();
    static {
        for (TaxCategoryCode documentNameCode : TaxCategoryCode.values()) {
            map.put(documentNameCode.value, documentNameCode);
        }
    }
    
    public static TaxCategoryCode valueOf(TaxCategoryType ublCode) {
    	return ublCode.getID()==null ? null : map.get(ublCode.getID().getValue());
    } 

    public static TaxCategoryCode valueOf(TaxCategoryCodeType uneceCode) {
    	return map.get(uneceCode.getValue());
    } 

}
