package com.klst.einvoice.api;

import java.util.Properties;

/**
 * BG-32 ITEM ATTRIBUTES with BT-160 Item attribute name and BT-161 Item attribute value
 * <p>
 * A group of business terms providing information about properties of the goods and services invoiced.
 * <p>
 * Cardinality: 	0..n
 * <br>EN16931-ID: 	BG-32
 * <br>Rule ID:     BR-54 	
 * <br>Request ID: 	R28
 * <p>
 * BT-160 and BT-161
 * Cardinality: 	1..1
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> (en)EN_16931_1_2017 for rule and request IDs
 */
/*

ubl-tc434-example8.xml :
    <cac:InvoiceLine>
        <cbc:ID>1</cbc:ID>
...
        <cac:Item>
...
            <cac:AdditionalItemProperty>                          <!-- BG-32
                <cbc:Name>contract transportvermogen</cbc:Name>   <!-- BT-160 Artikelattributname
                <cbc:Value>132,00 kW</cbc:Value>                  <!-- BT-161 Artikelattributwert
            </cac:AdditionalItemProperty>
            <cac:AdditionalItemProperty>
                <cbc:Name>transporttarief</cbc:Name>
                <cbc:Value>Netvlak MSD Enexis</cbc:Value>
            </cac:AdditionalItemProperty>

CII_example8.xml :

        <ram:IncludedSupplyChainTradeLineItem>
            <ram:AssociatedDocumentLineDocument>
                <ram:LineID>1</ram:LineID>
            </ram:AssociatedDocumentLineDocument>
            <ram:SpecifiedTradeProduct>
                <ram:Name>Getransporteerde kWh’s</ram:Name>
                <ram:ApplicableProductCharacteristic>                              <!-- BG-32
                    <ram:Description>contract transportvermogen</ram:Description>  <!-- BT-160 Artikelattributname
                    <ram:Value>132,00 kW</ram:Value>                               <!-- BT-161 Artikelattributwert
                </ram:ApplicableProductCharacteristic>
                <ram:ApplicableProductCharacteristic>
                    <ram:Description>transporttarief</ram:Description>
                    <ram:Value>Netvlak MSD Enexis</ram:Value>
                </ram:ApplicableProductCharacteristic>

 */
public interface BG32_ItemAttributes {

	/**
	 * add a Property to ITEM ATTRIBUTES
	 * 
	 * @param name, Item attribute name. The name of the attribute or property of the item. Such as “Colour”.
	 * @param value, Item attribute value. The value of the attribute or property of the item. Such as “Red”.
	 * <p>
	 * Rule BR-54 :
	 * Each Item attribute (BG-32) shall contain an Item attribute name (BT-160) 
	 * and an Item attribute value (BT-161).
	 */
	public void addItemAttribute(String name, String value);
	public Properties getItemAttributes();

}
