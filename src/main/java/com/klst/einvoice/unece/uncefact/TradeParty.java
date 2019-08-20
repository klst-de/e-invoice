package com.klst.einvoice.unece.uncefact;

import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.BG4_Seller;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.IContact;
import com.klst.einvoice.PostalAddress;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.LegalOrganizationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TaxRegistrationType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeAddressType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeContactType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.UniversalCommunicationType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

// BG-4 + 1..1 SELLER
// BG-7 + 1..1 BUYER
public class TradeParty extends TradePartyType implements BG4_Seller, BG7_Buyer { 

	private static final Logger LOG = Logger.getLogger(TradeParty.class.getName());
	
	TradeParty() {
		super();
	}
	
	// copy ctor
	public TradeParty(TradePartyType party) {
		this();
		TextType name = party.getName(); // Name des Verkäufers BT-27, .. des Käufers BT-44
		PostalAddress ta = getPostalAddress(party); // BG-5, BG-8
		TradeContact tc = getContact(party); // BG-6, BF-9
		LOG.info("copy ctor Name/BT-27,BT-44,...:"+name.getValue() + " Address:"+ta + " Contact:"+tc);
		super.setName(name);
		setAddress(ta);
		if(tc==null) {
//			LOG.info("TradeContact tc is null");
		} else {
			setContact(tc);
		}
		
		// BT-28 ++ 0..1 Seller trading name / TradingBusinessName
		// BT-29 ++ 0..n Seller identifier
		
		legalOrganization = party.getSpecifiedLegalOrganization();
		super.setSpecifiedLegalOrganization(legalOrganization);
		if(legalOrganization!=null) {
			LOG.info("SpecifiedLegalOrganization.TradingBusinessName/BT-28:"+legalOrganization.getTradingBusinessName()
				+ "  .ID/BT-30:"+legalOrganization.getID());
//			super.setSpecifiedLegalOrganization(legalOrganization);
		}
		
		List<TaxRegistrationType> taxRegistrationList = party.getSpecifiedTaxRegistration(); // 0..n wg. BT-31, BT-32, BT-31-0, BT-32-0
		taxRegistrationList.forEach(taxRegistration -> {
//			this.getSpecifiedTaxRegistration().add(taxRegistration);
//			taxRegistration.getID().getValue();
//			taxRegistration.getID().getSchemeID();
			this.addPartyTaxID(taxRegistration.getID().getValue(), taxRegistration.getID().getSchemeID());
		});
//		addTaxSchemes(getTaxSchemes(party));
		
		List<TextType> textList = party.getDescription();
		textList.forEach(companyLegalForm -> {
			LOG.info("Description/BT-33:"+legalOrganization); //
			super.getDescription().add(companyLegalForm);
		});
		
		// BT-34 ++ 0..1 Seller electronic address
		List<UniversalCommunicationType> uriAddressList = party.getURIUniversalCommunication(); // 0..1
		uriAddressList.forEach(uriAddress -> {
			LOG.info("URIUniversalCommunication/BT-34:"+uriAddress.getURIID()); //
			super.getURIUniversalCommunication().add(uriAddress);
		});
	}
	
	LegalOrganizationType legalOrganization;
	
	/**
	 * 
	 * @param name             BT-27 1..1 Name des Verkäufers   / BT-44 1..1 Name des Käufers
	 * @param address          BG-5  1..1 SELLER POSTAL ADDRESS / BG-8  1..1 BUYER POSTAL ADDRESS
	 * @param contact          BG-6  0..1 SELLER CONTACT        / BG-9  0..1 BUYER CONTACT
	 * @param companyId        BT-30 0..1 legal registration ID / BT-47 0..1 Buyer legal registration identifier
	 * @param companyLegalForm BT-33 0..1 additional legal info / not used for Buyer
//	 * @param shipToTradeName  BT-70 0..1 ShipToTradeParty.Name Name des Waren- oder Dienstleistungsempfängers
	 */
	public TradeParty(String name, PostalAddress address, TradeContact contact, String companyId, String companyLegalForm) {
		this();
		legalOrganization = new LegalOrganizationType();
		super.setSpecifiedLegalOrganization(legalOrganization);
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
//			LegalOrganizationType legalOrganization = new LegalOrganizationType();
			String schemeID = null;
			legalOrganization.setID(CrossIndustryInvoice.newIDType(companyId,schemeID));
//			super.setSpecifiedLegalOrganization(legalOrganization);
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
	@Override
	public PostalAddress getAddress() {
		return getPostalAddress(this);
	}

	@Override
	public void setAddress(PostalAddress address) {
		this.setAddress((TradeAddressType)address);
	}

//	public void setAddress(TradeAddress address) {
//		this.setAddress((TradeAddressType)address);
//	}
	void setAddress(TradeAddressType address) {
		super.setPostalTradeAddress(address);
	}
	
//	public TradeAddress getAddress() {
//		return getPostalAddress(this);
//	}
	static PostalAddress getPostalAddress(TradePartyType party) {
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
		LOG.info("DefinedTradeContact List#="+tradeContactList.size());
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
	void addPartyTaxID(String companyId, String schemeID)  {
		LOG.info("companyId:"+companyId + " schemeID:"+schemeID);
		if(companyId==null) return;
		List<TaxRegistrationType> taxRegistrationList = super.getSpecifiedTaxRegistration();
		TaxRegistrationType taxRegistration = new TaxRegistrationType();
		taxRegistration.setID(CrossIndustryInvoice.newIDType(companyId,schemeID));
		taxRegistrationList.add(taxRegistration);
	}
	void addPartyTaxID(String companyId)  {
		addPartyTaxID(companyId, "VA");
	}

//	// void addTaxSchemes(List<Map<Object,String>> partyTaxSchemes)  {
//	void addTaxSchemes(List<Map<Object,String>> partyTaxSchemes)  {
//		for(int i=0; i<partyTaxSchemes.size(); i++) {
//			Map<Object,String> map = partyTaxSchemes.get(i);
//			map.forEach((k,v) -> {
//				addPartyTaxID((String)k,v);
//			});
//		}
//	}
//
//	public List<Map<Object,String>> getTaxSchemes() { 
//		return getTaxSchemes(this);
//	}
//	static List<Map<Object,String>> getTaxSchemes(TradePartyType party) { 
//		List<TaxRegistrationType> taxRegistrationList = party.getSpecifiedTaxRegistration();
//		LOG.info("taxRegistrationList#="+taxRegistrationList.size());
//		List<Map<Object,String>> resultList = new ArrayList<Map<Object,String>>(taxRegistrationList.size());
//		taxRegistrationList.forEach(taxRegistration -> {
//			Map<Object,String> map = new HashMap<Object,String>();
////			map.put(IDType.class, taxRegistration.getID().getValue());
//			map.put(taxRegistration.getID().getSchemeID(), taxRegistration.getID().getValue());
//			resultList.add(map);
//		});
//		return resultList;
//	}

//	------------------------------------------
	
	String getPartyName() {
		return super.getName().getValue();
	}

	void setPartyName(String name) {
		if(name==null) return;
		super.setName(CrossIndustryInvoice.newTextType(name));
	}
	
	@Override
	public String getRegistrationName() {
		return getPartyName();
	}

	@Override
	public void setRegistrationName(String name) {
		setPartyName(name);
	}

	@Override
	public String getTradingBusinessName() {
		TextType text = legalOrganization.getTradingBusinessName();
		return text==null ? null : text.getValue();
	}

	@Override
	public void setTradingBusinessName(String name) {
		legalOrganization.setTradingBusinessName(CrossIndustryInvoice.newTextType(name));
	}

	@Override // 0..n returns the first
	public String getId() {
		List<IDType> list = this.getID();
		return list.isEmpty() ? null : list.get(0).getValue();
	}

	@Override
	public void setId(String name) {
		setId(name, null);
	}
	@Override
	public void setId(String name, String schemeID) {
		if(name==null) return;
		super.getID().add(CrossIndustryInvoice.newIDType(name, schemeID));
	}

	@Override
	public String getCompanyId() {
		IDType id = legalOrganization.getID();
		return id==null ? null : id.getValue();
	}

	@Override
	public void setCompanyId(String name) {
		setCompanyId(name, null);
	}
	@Override
	public void setCompanyId(String name, String schemeID) {
		if(name==null) return;
		legalOrganization.setID(CrossIndustryInvoice.newIDType(name, schemeID));
	}

	@Override
	public String getTaxRegistrationId() {
		return getTaxRegistrationId("VA");
	}
	@Override
	public String getTaxRegistrationId(String schemeID) {
		List<TaxRegistrationType> taxRegistrationList = super.getSpecifiedTaxRegistration();
		if(taxRegistrationList.isEmpty()) return null;
		if(taxRegistrationList.size()==1) return taxRegistrationList.get(0).getID().getValue(); 
		// jetzt default:
		for(int i=0; i<taxRegistrationList.size(); i++) {
			if(taxRegistrationList.get(i).getID().getSchemeID().equals(schemeID)) {
				return taxRegistrationList.get(i).getID().getValue();
			}
		}
 		return taxRegistrationList.isEmpty() ? null : taxRegistrationList.get(0).getID().getValue(); // den ersten und ohne Schema
	}

	@Override
	public void setTaxRegistrationId(String name, String schemeID) {
		addPartyTaxID(name, schemeID);
	}

	@Override // 0..1 also genügt der erste
	public String getCompanyLegalForm() {
		List<TextType> textList = super.getDescription();
		return textList.isEmpty() ? null : textList.get(0).getValue();
	}

	@Override
	public void setCompanyLegalForm(String name) {
		if(name==null) return;
		super.getDescription().add(CrossIndustryInvoice.newTextType(name));
	}

	@Override // 0..1 also genügt der erste
	public String getUriUniversalCommunication() {
		List<UniversalCommunicationType> uriList = super.getURIUniversalCommunication();
		return uriList.isEmpty() ? null : uriList.get(0).getURIID().getValue(); // ohne schema
	}

	@Override
	public void setUriUniversalCommunication(String name, String schemeID) {
		if(name==null) return;
		UniversalCommunicationType universalCommunicationType = new UniversalCommunicationType();
		universalCommunicationType.setURIID(CrossIndustryInvoice.newIDType(name, schemeID));
		super.getURIUniversalCommunication().add(universalCommunicationType);
	}

}
