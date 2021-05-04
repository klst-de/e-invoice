package com.klst.einvoice;

import com.klst.edoc.api.BusinessParty;

/**
 * BG-10 + 0..1 PAYEE 
 * <p>
 * A group of business terms providing information about the Payee, i.e. the role that receives the payment.
 * <p>
 * The role of Payee may be fulfilled by another party than the Seller, e.g. a factoring service.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-10
 * <br>Rule ID:     BR-17	
 * <br>Request ID: 	R1, R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

/*   (en) rules
 * 
 * BR-17  Target / context: Payee, Business term / group: BT-59
 * The Payee name (BT-59) shall be provided in the Invoice, if the Payee (BG-10) is different 
 * from the Seller (BG-4).
 * 
 *   (de) rules / Geschäftsregel:
 * 
 * BR-17    : Zahlungsempfänger 
 * Falls der Zahlungsempfänger (BG-10) nicht mit dem Verkäufer (BG-4) identisch ist, 
 * muss seine Firmierung/sein Name in der Rechnung (BT-59) angegeben werden.
 * 
 */
public interface BG10_Payee {
	
/*
CII:
            <ram:PayeeTradeParty>
                <ram:ID>74</ram:ID>
                <ram:Name>[Payee name]</ram:Name>           -- BT-59 RegistrationName
            </ram:PayeeTradeParty>
UBL:
    <cac:PayeeParty>
        <cac:PartyIdentification>
            <cbc:ID>74</cbc:ID>
        </cac:PartyIdentification>
        <cac:PartyName>                                     -- BT-59 TradingBusinessName
            <cbc:Name>[Payee name]</cbc:Name>
        </cac:PartyName>
    </cac:PayeeParty>

ubl-tc434-example2.xml:
    <cac:AccountingSupplierParty>                           -- Seller (BG-4) is different!
        <cac:Party>
            <cac:PartyIdentification>
                <cbc:ID schemeID="0088">1238764941386</cbc:ID>
            </cac:PartyIdentification>
...
            <cac:PartyLegalEntity>
                <cbc:RegistrationName>Salescompany ltd.</cbc:RegistrationName>
                <cbc:CompanyID>123456789</cbc:CompanyID>
            </cac:PartyLegalEntity>

...
    <cac:PayeeParty>
        <cac:PartyIdentification>
            <cbc:ID schemeID="0088">2298740918237</cbc:ID>
        </cac:PartyIdentification>
        <cac:PartyName>
            <cbc:Name>Ebeneser Scrooge AS</cbc:Name>
        </cac:PartyName>
        <cac:PartyLegalEntity>
            <cbc:CompanyID>989823401</cbc:CompanyID>
        </cac:PartyLegalEntity>
    </cac:PayeeParty>

 */

	public void setPayee(String name, String id, String companyId);
	public void setPayee(BusinessParty party);
	public BusinessParty getPayee();

}
