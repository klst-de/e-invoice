package com.klst.einvoice.unece.uncefact;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.BG10_Payee;
import com.klst.einvoice.BG11_SellerTaxRepresentativeParty;
import com.klst.einvoice.BG4_Seller;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.BusinessPartyFactory;
import com.klst.einvoice.IContact;
import com.klst.einvoice.Identifier;
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
// BG-10 + 0..1 PAYEE
// BG-11 + 0..1 SELLER TAX REPRESENTATIVE PARTY
public class TradeParty extends TradePartyType implements BG4_Seller, BG7_Buyer, BG10_Payee, BG11_SellerTaxRepresentativeParty { 

	private static final Logger LOG = Logger.getLogger(TradeParty.class.getName());
	
	TradeParty() {
		super();
	}
	
	// copy ctor
	TradeParty(TradePartyType party) {
		this();
		LegalOrganizationType legalOrganization = party.getSpecifiedLegalOrganization();
		init( getPartyName(party)
			, getPostalAddress(party)
			, getContact(party)
			);
		
		// BT-28 ++ 0..1 Seller trading name / TradingBusinessName
		setBusinessName(legalOrganization==null ? null : legalOrganization.getTradingBusinessName()==null ? null : legalOrganization.getTradingBusinessName().getValue());

		// BG-4.BT-29 ++ 0..n Seller identifier
		// BG-7.BT-46 ++ 0..1 Buyer identifier
		List<IDType> iDlist = party.getID();
		iDlist.forEach(iD -> {
			Identifier identifier = new ID(iD.getValue(), iD.getSchemeID());
			this.setId(identifier.getContent(), identifier.getSchemeIdentifier());
		});
		
		// BT-30 0..1 legal registration ID / BT-47 0..1 Buyer legal registration identifier
		if(legalOrganization!=null) {
			if(legalOrganization.getID()!=null) {
				setCompanyIdentifier(new ID(legalOrganization.getID().getValue(), legalOrganization.getID().getSchemeID()));
			}
		}
		
		List<Identifier> taxRegistrationList = getTaxRegistrationIdentifier(party); // 0..n wg. BT-31, BT-32, BT-31-0, BT-32-0
		taxRegistrationList.forEach(taxRegistration -> {
			this.addTaxRegistrationIdentifier(taxRegistration);
		});
		//		List<TaxRegistrationType> taxRegistrationList = party.getSpecifiedTaxRegistration(); 
//		taxRegistrationList.forEach(taxRegistration -> {
//			this.addPartyTaxID(taxRegistration.getID().getValue(), taxRegistration.getID().getSchemeID());
//		});
		
		// BT-33 0..1 additional legal info / not used for Buyer
		setCompanyLegalForm(party.getDescription().isEmpty() ? null : party.getDescription().get(0).getValue());
		
		// BT-34 ++ 0..1 Seller electronic address
		List<UniversalCommunicationType> uriAddressList = party.getURIUniversalCommunication(); // 0..1
		uriAddressList.forEach(uriAddress -> {
			LOG.info("URIUniversalCommunication/BT-34:"+uriAddress.getURIID()); //
			super.getURIUniversalCommunication().add(uriAddress);
		});
	}
	
	LegalOrganizationType legalOrganization;
	
	/**
	 * ctor for BusinessParty - use BusinessPartyFactory method
	 * 
	 * @param name             BT-27 1..1 Name des Verkäufers   / BT-44 1..1 Name des Käufers
	 * @param address          BG-5  1..1 SELLER POSTAL ADDRESS / BG-8  1..1 BUYER POSTAL ADDRESS
	 * @param contact          BG-6  0..1 SELLER CONTACT        / BG-9  0..1 BUYER CONTACT
	 * 
	 * @see BusinessPartyFactory
	 */
	TradeParty(String name, PostalAddress address, IContact contact) {
		this();
		init(name, address, contact); //, companyId, companyLegalForm);
	}
	
	void init(String name, PostalAddress address, IContact contact) { //, String companyId, String companyLegalForm) {
		legalOrganization = new LegalOrganizationType();
		setRegistrationName(name);
		setAddress(address);
		if(contact!=null) setIContact(contact);
	}

	// PostalAddress
	@Override
	public PostalAddress getAddress() {
		return getPostalAddress(this);
	}
	static PostalAddress getPostalAddress(TradePartyType party) {
		TradeAddressType address = party.getPostalTradeAddress();
		if(address==null) return null; // defensiv, sollte nie null sein
		return new TradeAddress(address);
	}

	@Override
	public void setAddress(PostalAddress address) {
		if(address!=null) setAddress((TradeAddressType)address);
	}
	void setAddress(TradeAddressType address) {
		super.setPostalTradeAddress(address);
	}
	
	@Override
	public PostalAddress createAddress(String countryCode, String postalCode, String city) {
		return new TradeAddress(countryCode, postalCode, city, null);
	}

	@Override
	public PostalAddress createAddress(PostalAddress address) {
		return new TradeAddress((TradeAddressType)address);
	}

	// Contact
	@Override
	public IContact getIContact() {
		return getContact(this);
	}
	static IContact getContact(TradePartyType party) {
		List<TradeContactType> tradeContactList = party.getDefinedTradeContact();
		return tradeContactList.isEmpty() ? null : new TradeContact(tradeContactList.get(0));
	}

	@Override
	public void setIContact(IContact contact) {
		super.getDefinedTradeContact().add((TradeContact)contact);	
	}

	
	@Override
	public IContact createContact(String contactName, String contactTel, String contactMail) {
		return new TradeContact(contactName, contactTel, contactMail);
	}

	@Override
	public IContact createContact(IContact contact) {
		return new TradeContact((TradeContactType)contact);
	}


	/*
	 * 0..n : SpecifiedTaxRegistration - Detailinformationen zu Steuerangaben des Verkäufers
	 * 1..1 : ID                       - Steuernummer des Verkäufers, Umsatzsteueridentnummer des Verkäufers
	 *        schemeID                 - Art der Steuernummer des Verkäufers
	 *        Anwendung: FC = Steuernummer des Verkäufers
	 *                   VA = Umsatzsteueridentnummer des Verkäufers
	 *                        Codeliste: UNTDID 1153 Untermenge
	 * Beispiel: <ram:ID schemeID="VA">DE 123456789</ram:ID>
	 * Quelle: ZUGFeRD Version 2.1.1 TA
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
	 * @param ID companyId
	 * @param ID schemeID, BT-31-0, BT-32-0, tax registration identifier
	 * <p>
	 * The local identification (defined by the Seller’s address) of the Seller for tax purposes 
	 * or a reference that enables the Seller to state his registered tax status.
	 * This information may affect how the Buyer settles the payment (such as for social security fees). 
	 * E.g. in some countries, if the Seller is not registered as a tax paying entity 
	 * then the Buyer is required to withhold the amount of the tax and pay it on behalf of the Seller.
	 */
	void addPartyTaxID(String companyId, String schemeID)  {
		LOG.fine("addPartyTaxID: companyId:"+companyId + " schemeID:"+schemeID);
		if(companyId==null) return;
		List<TaxRegistrationType> taxRegistrationList = super.getSpecifiedTaxRegistration();
		TaxRegistrationType taxRegistration = new TaxRegistrationType();
		taxRegistration.setID(new ID(companyId, schemeID));
		taxRegistrationList.add(taxRegistration);
	}
	void addPartyTaxID(String companyId)  {
		addPartyTaxID(companyId, "VA");
	}

//	------------------------------------------
	
	String getPartyName() {
		return getPartyName(this);
	}
	static String getPartyName(TradePartyType party) {
		return party.getName()==null ? null : party.getName().getValue();
	}

	void setPartyName(String name) {
		if(name==null) return;
		super.setName(new Text(name));
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
	public String getBusinessName() {
		TextType text = legalOrganization.getTradingBusinessName();
		return text==null ? null : text.getValue();
	}

	@Override
	public void setBusinessName(String name) {
		if(name==null) return;
		legalOrganization.setTradingBusinessName(new Text(name));
		super.setSpecifiedLegalOrganization(legalOrganization);
	}

	@Override // 0..n returns the first
	public Identifier getIdentifier() {
		List<IDType> list = this.getID();
		return list.isEmpty() ? null : new ID(list.get(0).getValue(), list.get(0).getSchemeID());
	}
	public String getId() {
		List<IDType> list = this.getID();
		return list.isEmpty() ? null : list.get(0).getValue();
	}

	@Override
	public void setId(String name) {
		setId(name, null);
	}
	@Override
	public void setIdentifier(Identifier id) {
		if(id==null) return;
		setId(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void setId(String name, String schemeID) {
		if(name==null) return;
		super.getID().add(new ID(name, schemeID));
	}

	@Override
	public String getCompanyId() {
		IDType id = legalOrganization.getID();
		return id==null ? null : id.getValue();
	}
	@Override
	public Identifier getCompanyIdentifier() {
		IDType id = legalOrganization.getID();
		return id==null ? null : new ID(id.getValue(), id.getSchemeID());
	}

	@Override
	public void setCompanyIdentifier(Identifier id) {
		if(id==null) return;
		setCompanyId(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void setCompanyId(String name) {
		setCompanyId(name, null);
	}
	@Override
	public void setCompanyId(String name, String schemeID) {
		if(name==null) return;
		legalOrganization.setID(new ID(name, schemeID));
		super.setSpecifiedLegalOrganization(legalOrganization);
	}

	@Override
	public List<Identifier> getTaxRegistrationIdentifier() {
		return getTaxRegistrationIdentifier(this);
	}
	static List<Identifier> getTaxRegistrationIdentifier(TradePartyType party) {
		List<TaxRegistrationType> taxRegistrationList = party.getSpecifiedTaxRegistration();
		List<Identifier> result = new ArrayList<Identifier>(taxRegistrationList.size());
		if(taxRegistrationList.isEmpty()) return result;
		taxRegistrationList.forEach(taxRegistration -> {
			result.add(new ID(taxRegistration.getID()));
		});
		return result;
	}
	
//	public String getTaxRegistrationId() {
//		return getTaxRegistrationId("VA");
//	}
//	@Override
//	public String getTaxRegistrationId(String schemeID) {
//		List<TaxRegistrationType> taxRegistrationList = super.getSpecifiedTaxRegistration();
//		if(taxRegistrationList.isEmpty()) return null;
//		if(taxRegistrationList.size()==1) return taxRegistrationList.get(0).getID().getValue(); 
//		// jetzt default:
//		for(int i=0; i<taxRegistrationList.size(); i++) {
//			if(taxRegistrationList.get(i).getID().getSchemeID().equals(schemeID)) {
//				return taxRegistrationList.get(i).getID().getValue();
//			}
//		}
// 		return taxRegistrationList.isEmpty() ? null : taxRegistrationList.get(0).getID().getValue(); // den ersten und ohne Schema
//	}

	@Override
	public void addTaxRegistrationIdentifier(Identifier id) {
		if(id==null) return;
		addTaxRegistrationId(id.getContent(), id.getSchemeIdentifier());
	}
	@Override
	public void addTaxRegistrationId(String name, String schemeID) {
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
		super.getDescription().add(new Text(name));
	}

	@Override // 0..1 also genügt der erste
	public Identifier getUriUniversalCommunication() {
		List<UniversalCommunicationType> uriList = super.getURIUniversalCommunication();
		if(uriList.isEmpty()) return null;
		return new ID(uriList.get(0).getURIID().getValue(), uriList.get(0).getURIID().getSchemeID()); 
	}

	@Override
	public void setUriUniversalCommunication(Identifier id) {
		if(id==null) return;
		setUriUniversalCommunication(id.getContent(), id.getSchemeIdentifier());
	}
	
	@Override
	public void setUriUniversalCommunication(String name, String schemeID) {
		if(name==null) return;
		UniversalCommunicationType universalCommunicationType = new UniversalCommunicationType();
		universalCommunicationType.setURIID(new ID(name, schemeID));
		super.getURIUniversalCommunication().add(universalCommunicationType);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[RegistrationName:");
		stringBuilder.append(getRegistrationName()==null ? "null" : getRegistrationName());
		stringBuilder.append(", BusinessName:");
		stringBuilder.append(getBusinessName()==null ? "null" : getBusinessName());
		stringBuilder.append(", Id:");
		stringBuilder.append(getId()==null ? "null" : getId());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}
