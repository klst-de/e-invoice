package com.klst.einvoice;

/*

UBL:
      <cac:TaxScheme>
        <cbc:ID>VAT</cbc:ID>         <!-- TaxType -->
      </cac:TaxScheme>
...
    <cac:TaxCategory>
      <cbc:ID>E</cbc:ID>
      <cbc:Percent>0</cbc:Percent>
      <cac:TaxScheme>
        <cbc:ID>VAT</cbc:ID>         <!-- TaxType -->
      </cac:TaxScheme>
    </cac:TaxCategory>
    
CII: 
                <ram:CategoryTradeTax>
                    <ram:TypeCode>VAT</ram:TypeCode>                   <!-- TaxType -->
                    <ram:CategoryCode>E</ram:CategoryCode>
                    <ram:RateApplicablePercent>0</ram:RateApplicablePercent>
                </ram:CategoryTradeTax>

 */
public interface ITaxType {

	public void setTaxType(String type);
	public String getTaxType();

}
