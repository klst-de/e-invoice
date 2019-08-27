package com.klst.einvoice;

/**
 * BG-10 + 0..1 PAYEE 
 * <p>
 * A group of business terms providing information about the Payee, i.e. the role that receives the payment.
 * <p>
 * The role of Payee may be fulfilled by another party than the Seller, e.g. a factoring service.
 * <p>
 * Cardinality: 	0..1
 * <br>EN16931-ID: 	BG-10
 * <br>Rule ID: 	
 * <br>Request ID: 	R1, R57
 * 
 * @see <a href="https://standards.cen.eu">standards.cen.eu</a> for (en)EN_16931_1_2017 rule and request IDs
 */

/*  (de) rules / Geschäftsregel:
 * 
 * BR-17    : Zahlungsempfänger 
 * Falls der Zahlungsempfänger (BG-10) nicht mit dem Verkäufer (BG-4) identisch ist, 
 * muss seine Firmierung/sein Name in der Rechnung (BT-59) angegeben werden.
 * 
 */
//TODO Idee runter zu ubl und cii und public raus ?!
public interface BG10_Payee extends BusinessParty {
	
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

 */
	// BT-59 ++ 1..1 Payee name / <ram:Name> / UBL: <cac:PartyName><cbc:Name>
	// BT-27 ++ 1..1 Seller name / ram:Name / UBL: <cac:PartyLegalEntity><cbc:RegistrationName>
	// BT-44 ++ 1..1 Buyer name / ram:Name / UBL: <cac:PartyLegalEntity><cbc:RegistrationName>
	
	// BT-60 ++ 0..1 Payee identifier / <ram:ID> + <ram:GlobalID> / UBL: <cac:PartyIdentification><cbc:ID>
	
	// BT-61 ++ 0..1 Payee legal registration identifier / <ram:SpecifiedLegalOrganization><ram:ID>

}
