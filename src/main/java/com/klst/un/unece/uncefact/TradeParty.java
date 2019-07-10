package com.klst.un.unece.uncefact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.klst.cius.IContact;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LegalOrganizationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TaxRegistrationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAddressType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeContactType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

public class TradeParty extends TradePartyType{

	private static final Logger LOG = Logger.getLogger(TradeParty.class.getName());
	
	TradeParty() {
		super();
	}
	
	// copy ctor
	public TradeParty(TradePartyType party) {
		this();
		super.setName(party.getName());
		setAddress(getPostalAddress(party));
		TradeContact tc = getContact(party);
		if(tc==null) {
			LOG.info("TradeContact tc is null");
		} else {
			setContact(tc);
		}
		
		LegalOrganizationType legalOrganization = party.getSpecifiedLegalOrganization();
		if(legalOrganization!=null) {
			super.setSpecifiedLegalOrganization(legalOrganization);
		}
		List<TextType> textList = party.getDescription();
		textList.forEach(companyLegalForm -> {
			this.getDescription().add(companyLegalForm);
		});

		addTaxSchemes(getTaxSchemes(party));
	}
	
	/**
	 * 
	 * @param name             BT-27 1..1 Name des Verkäufers   / BT-44 1..1 Name des Käufers
	 * @param address          BG-5  1..1 SELLER POSTAL ADDRESS / BG-8  1..1 BUYER POSTAL ADDRESS
	 * @param contact          BG-6  0..1 SELLER CONTACT        / BG-9  0..1 BUYER CONTACT
	 * @param companyId        BT-30 0..1 legal registration ID / BT-47 0..1 Buyer legal registration identifier
	 * @param companyLegalForm BT-33 0..1 additional legal info / not used for Buyer
//	 * @param shipToTradeName  BT-70 0..1 ShipToTradeParty.Name Name des Waren- oder Dienstleistungsempfängers
	 */
	public TradeParty(String name, TradeAddress address, TradeContact contact, String companyId, String companyLegalForm) {
		this();
		if(name!=null) super.setName(CrossIndustryInvoice.newTextType(name));
		if(address!=null) setAddress(address);
		if(contact!=null) setContact(contact);
/*
1 .. 1 SellerTradeParty Verkäufer                                       BG-4  xs:sequence 
0 .. 1 Description Sonstige rechtliche Informationen des Verkäufers     BT-33 
0 .. 1 SpecifiedLegalOrganization Details zur Organisation xs:sequence 
0 .. 1 ID Kennung der rechtlichen Registrierung des Verkäufers          BT-30 
       required schemeID Kennung des Schemas                            BT-30-1
       EN16931-ID: BT-30-1 Anwendung: Insbesondere können folgende Codes genutzt werden: 
       0021 : SWIFT 
       0088 : EAN 
       0060 : DUNS 
       0177 : ODETTE
 */
		if(companyId!=null) {
			LegalOrganizationType legalOrganization = new LegalOrganizationType();
			String schemeID = null;
			legalOrganization.setID(CrossIndustryInvoice.newIDType(companyId,schemeID));
			super.setSpecifiedLegalOrganization(legalOrganization);
		}
		
		if(companyLegalForm!=null) {
			super.getDescription().add(CrossIndustryInvoice.newTextType(companyLegalForm));
		}
	}

	// BT-70 PartyName/shipToTradeName
	public void addName(String shipToTradeName) { // !wie Name
		super.setName(CrossIndustryInvoice.newTextType(shipToTradeName));
	}

	// PostalAddress
	public void setAddress(TradeAddress address) {
		this.setAddress((TradeAddressType)address);
	}
	void setAddress(TradeAddressType address) {
		super.setPostalTradeAddress(address);
	}
	
	public TradeAddress getAddress() {
		return getPostalAddress(this);
	}
	static TradeAddress getPostalAddress(TradePartyType party) {
		TradeAddressType address = party.getPostalTradeAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return new TradeAddress(address);
	}

	// Contact
	public void setContact(TradeContact contact) {
		List<TradeContactType> tradeContactList = super.getDefinedTradeContact();
		TradeContactType tradeContact = new TradeContact((TradeContactType)contact);
		tradeContactList.add(tradeContact);
	}
	
	public IContact getIContact() {
		return getContact(this);
	}
	
/*
0 .. 1 DefinedTradeContact Kontaktdaten des Verkäufers                  BG-6 xs:sequence SELLER CONTACT 
0 .. 1 PersonName Kontaktstelle des Verkäufers                          BT-41 
0 .. 1 DepartmentName Kontaktstelle des Verkäufers                      BT-41-0 
0 .. 1 TelephoneUniversalCommunication Detailinformationen zur Telefonnummer des Verkäufers xs:sequence 
1 .. 1 CompleteNumber Telefonnummer des Verkäufers                      BT-42       
0 .. 1 FaxUniversalCommunication Detailinformationen zur Faxnummer des Verkäufers xs:sequence 
1 .. 1 CompleteNumber Faxnummer des Verkäufers 
0 .. 1 EmailURIUniversalCommunication Detailinformationen zur Emailadresse des Verkäufers xs:sequence 
1 .. 1 URIID E-Mailadresse des Verkäufers                               BT-43 
 */
	static TradeContact getContact(TradePartyType party) {
		List<TradeContactType> tradeContactList = party.getDefinedTradeContact();
		LOG.info("tradeContactList#="+tradeContactList.size());
		if(tradeContactList.isEmpty()) return null;
		return new TradeContact(tradeContactList.get(0));
	}
	
	/*
	 * 0..n : SpecifiedTaxRegistration - Detailinformationen zu Steuerangaben des Verkäufers
	 * 1..1 : ID                       - Steuernummer des Verkäufers, Umsatzsteueridentnummer des Verkäufers
	 *        schemeID                 - Art der Steuernummer des Verkäufers
	 *        Anwendung: FC = Steuernummer des Verkäufers
	 *                   VA = Umsatzsteueridentnummer des Verkäufers
	 *                        Codeliste: UNTDID 1153 Untermenge
	 * Beispiel: <ram:ID schemeID="VA">DE 123456789</ram:ID>
	 */
	/**
	 * VAT/tax identifier and tax registration identifier
	 * <p>
	 * The VAT identifier (also known as VAT identification number).
	 * <p>
	 * VAT number prefixed by a country code. A VAT registered Supplier shall include his VAT ID, 
	 * except when he uses a tax representative.
	 * <p>
	 * Cardinality: 	0..1 (optional) 
	 * <br>EN16931-ID: 	BT-31, BT-32 / BT-31-0, BT-32-0
	 * <br>Rule ID: 	BR-CO-9, BR-CO-26, BR-DE-16
	 * <br>Request ID: 	R52, R47
	 * 
	 * @param Identifier companyId
	 * @param Identifier schemeID, BT-31-0, BT-32-0, tax registration identifier
	 * <p>
	 * The local identification (defined by the Seller’s address) of the Seller for tax purposes 
	 * or a reference that enables the Seller to state his registered tax status.
	 * This information may affect how the Buyer settles the payment (such as for social security fees). 
	 * E.g. in some countries, if the Seller is not registered as a tax paying entity 
	 * then the Buyer is required to withhold the amount of the tax and pay it on behalf of the Seller.
	 */
	public void addPartyTaxID(String companyId, String schemeID)  {
		if(companyId==null) return;
		List<TaxRegistrationType> taxRegistrationList = super.getSpecifiedTaxRegistration();
		TaxRegistrationType taxRegistration = new TaxRegistrationType();
		taxRegistration.setID(CrossIndustryInvoice.newIDType(companyId,schemeID));
		taxRegistrationList.add(taxRegistration);
	}
	public void addPartyTaxID(String companyId)  {
		addPartyTaxID(companyId, "VA");
	}

	// void addTaxSchemes(List<Map<Object,String>> partyTaxSchemes)  {
	void addTaxSchemes(List<Map<Object,String>> partyTaxSchemes)  {
		for(int i=0; i<partyTaxSchemes.size(); i++) {
			Map<Object,String> map = partyTaxSchemes.get(i);
			map.forEach((k,v) -> {
				addPartyTaxID((String)k,v);
			});
		}
	}

	public List<Map<Object,String>> getTaxSchemes() { 
		return getTaxSchemes(this);
	}
	static List<Map<Object,String>> getTaxSchemes(TradePartyType party) { 
		List<TaxRegistrationType> taxRegistrationList = party.getSpecifiedTaxRegistration();
		LOG.info("taxRegistrationList#="+taxRegistrationList.size());
		List<Map<Object,String>> resultList = new ArrayList<Map<Object,String>>(taxRegistrationList.size());
		taxRegistrationList.forEach(taxRegistration -> {
			Map<Object,String> map = new HashMap<Object,String>();
//			map.put(IDType.class, taxRegistration.getID().getValue());
			map.put(taxRegistration.getID().getSchemeID(), taxRegistration.getID().getValue());
			resultList.add(map);
		});
		return resultList;
	}
	
}
