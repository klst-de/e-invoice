package com.klst.einvoice.api;

/*
Tax TypeCode : Code der Umsatzsteuerkategorie
. CII Datentyp: qdt:TaxTypeCodeType
. Beschreibung: Codierte Bezeichnung einer Umsatzsteuerkategorie
. Hinweis: Fester Wert = "VAT"
. Kardinalität: 1 .. 1
. EN16931-ID: BT-118-0

Codeliste: UNTDID 5153 Eingeschränkt
In der EN 16931 wird nur die Steuerart „Umsatzsteuer“ mit dem Code „VAT“ unterstützt. 
Sollen andere Steuerarten angegeben wie beispielsweise eine Versicherungssteuer oder eine Mineralölsteuer werden, 
muss das EXTENDED Profil genutzt werden. 
Der Code für die Steuerart muss dann der Codeliste UNTDID 5153 entnommen werden.

UBL:
      <cac:TaxScheme>
        <cbc:ID>VAT</cbc:ID>         <!-- TaxType -->
      </cac:TaxScheme>
...
    <cac:TaxCategory>
      <cbc:ID>E</cbc:ID>
      <cbc:Percent>0</cbc:Percent>
      <cac:TaxScheme>
        <cbc:ID>VAT</cbc:ID>         <!-- BT-118-0 Tax Categoty TypeCode -->
      </cac:TaxScheme>
    </cac:TaxCategory>
    
CII: 
                <ram:CategoryTradeTax>
                    <ram:TypeCode>VAT</ram:TypeCode>                   <!-- BT-118-0 Tax Categoty TypeCode -->
                    <ram:CategoryCode>E</ram:CategoryCode>
                    <ram:RateApplicablePercent>0</ram:RateApplicablePercent>
                </ram:CategoryTradeTax>

 */
public interface ITaxType {

	/**
	 * BG-23.BT-118-0 Tax TypeCode, 
	 * also used in EN16931-IDs BG-20.BT-95-0 , BG-21.BT-102-0 and BG-30.BT-151-0
	 * 
	 * @param type typically VAT
	 * 
	 * @see com.klst.untdid.codelist.TaxTypeCode
	 */
	public void setTaxType(String type);
	public String getTaxType();

}
