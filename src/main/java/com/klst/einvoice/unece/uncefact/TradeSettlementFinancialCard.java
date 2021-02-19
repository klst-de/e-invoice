package com.klst.einvoice.unece.uncefact;

import java.util.logging.Logger;

import com.klst.einvoice.PaymentCard;
import com.klst.einvoice.PaymentCardFactory;
import com.klst.einvoice.reflection.CopyCtor;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementFinancialCardType;

//Gruppe PAYMENT CARD                      BG-18
/*
Testfälle für PAYMENT CARD
Bsp: 03.02a:
      <ram:ApplicableHeaderTradeSettlement>
          <ram:InvoiceCurrencyCode>EUR</ram:InvoiceCurrencyCode>
          <ram:SpecifiedTradeSettlementPaymentMeans>
              <ram:TypeCode>48</ram:TypeCode>
              <ram:ApplicableTradeSettlementFinancialCard>
                  <ram:ID>41234</ram:ID>
                  <ram:CardholderName>[Payment card holder name]</ram:CardholderName>
              </ram:ApplicableTradeSettlementFinancialCard>
          </ram:SpecifiedTradeSettlementPaymentMeans>

*/
public class TradeSettlementFinancialCard extends TradeSettlementFinancialCardType 
	implements PaymentCard, PaymentCardFactory {

	private static final Logger LOG = Logger.getLogger(TradeSettlementFinancialCard.class.getName());
	
	// implements PaymentCardFactory
	@Override
	public PaymentCard createPaymentCard(String cardAccountID, String cardHolderName) {
		return create(cardAccountID, cardHolderName);
	}
	static TradeSettlementFinancialCard create(String cardAccountID, String cardHolderName) {
		return cardAccountID==null? null : new TradeSettlementFinancialCard(cardAccountID, cardHolderName);
	}

	static TradeSettlementFinancialCard create() {
		return new TradeSettlementFinancialCard(null);
	}
	// copy factory
	static TradeSettlementFinancialCard create(TradeSettlementFinancialCardType tsfc) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(tsfc instanceof TradeSettlementFinancialCardType && tsfc.getClass()!=TradeSettlementFinancialCardType.class) {
			// tsfc is instance of a subclass of TradeTaxType, but not TradeTaxType itself
			return (TradeSettlementFinancialCard)tsfc;
		} else {
			return new TradeSettlementFinancialCard(tsfc); 
		}
	}

	private TradeSettlementFinancialCard(TradeSettlementFinancialCardType financialCard) {
		super();
		if(financialCard!=null) {
			CopyCtor.invokeCopy(this, financialCard);
			LOG.fine("copy ctor:"+this);
		}
	}
	
	/**
	 * BG-18 PAYMENT CARD INFORMATION
	 * 
	 * @param @param pan - (mandatory) Payment card primary account number (pan)
	 * @param name - (optional) name of the payment card holder
	 */
	private TradeSettlementFinancialCard(String pan, String name) {
		super();
		setCardAccountID(pan);
		setCardHolderName(name);
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder().append("[");
		stringBuilder.append("CardAccountID:");    // BG-18.BT-87
		stringBuilder.append(getCardAccountID()==null ? "null" : getCardAccountID());
		stringBuilder.append(", CardHolderName:"); // BG-18.BT-88
		stringBuilder.append(getCardHolderName()==null ? "null" : getCardHolderName());
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	
	// BG-18.BT-87
	@Override
	public void setCardAccountID(String pan) {
		if(pan==null) {
			LOG.warning("(mandatory) Payment card primary account number (pan) is null.");
			return;
		}
		super.setID(new ID(pan));
	}

	@Override
	public String getCardAccountID() {
		if(super.getID()==null) {
			LOG.warning("(mandatory) Payment card primary account number (pan) is not set.");
			return null;
		}
		return getID().getValue();
	}

	// BG-18.BT-88
	@Override
	public void setCardHolderName(String name) {
		if(name==null) return;
		super.setCardholderName(Text.create(name));	
	}

	@Override
	public String getCardHolderName() {
		return getCardHolderName(this);
	}
	static String getCardHolderName(TradeSettlementFinancialCardType card) {
		if(card==null) return null;
		return card.getCardholderName()==null ? null : card.getCardholderName().getValue();
	}

}
