package com.klst.einvoice.ubl;

import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentCardFactory;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CardAccountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HolderNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetworkIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrimaryAccountNumberIDType;

// implements BG-18 ++ 0..1 PAYMENT CARD INFORMATION
public class CardAccount extends CardAccountType implements PaymentCard, PaymentCardFactory {

	// implements PaymentCardFactory
	@Override
	public PaymentCard createPaymentCard(String cardAccountID, String cardHolderName) {
		return create(cardAccountID, cardHolderName);
	}
	static PaymentCard create(String cardAccountID, String cardHolderName) {
		return cardAccountID==null? null : new CardAccount(cardAccountID, cardHolderName);
	}

	CardAccount(String pan, String name) {
		super();
		setCardAccountID(pan);
		setCardHolderName(name);
	}
	
	// copy ctor
	CardAccount(CardAccountType ca) {
		this(ca.getPrimaryAccountNumberID().getValue(), ca.getHolderName()==null? null : ca.getHolderName().getValue());
		setNetwork(ca.getNetworkID()==null? null : ca.getNetworkID().getValue());
	}

	// BG-18.BT-87 (mandatory) Payment card primary account number
	@Override
	public String getCardAccountID() {
		return super.getPrimaryAccountNumberID()==null? null : getPrimaryAccountNumberID().getValue();
	}

	@Override
	public void setCardAccountID(String pan) {
		PrimaryAccountNumberIDType panID = new PrimaryAccountNumberIDType();
		panID.setValue(pan);
		super.setPrimaryAccountNumberID(panID);
	}

	// BG-18.BT-88 (optional) Payment card holder name
	@Override
	public String getCardHolderName() {
		HolderNameType holderName = getHolderName();
		return holderName==null? null : holderName.getValue();
	}

	@Override
	public void setCardHolderName(String name) {
		if(name==null) return; // optional
		HolderNameType holderName = new HolderNameType();
		holderName.setValue(name);
		super.setHolderName(holderName);
	}

	// getNetworkID ist nicht in EN16931 definiert, aber in UBL und in 03.02a Beispiel, 
	// siehe https://github.com/itplr-kosit/validator-configuration-xrechnung/issues/53 daher optional
	public String getNetwork() {
		NetworkIDType networkID = getNetworkID();
		return networkID==null? null : networkID.getValue();
	}

	public void setNetwork(String id) {
		if(id==null) return; // optional
		NetworkIDType networkId = new NetworkIDType();
		networkId.setValue(id);
		super.setNetworkID(networkId);
	}

}
