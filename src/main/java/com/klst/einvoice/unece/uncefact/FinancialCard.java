package com.klst.einvoice.unece.uncefact;

import java.util.logging.Logger;

import com.klst.einvoice.PaymentCard;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementFinancialCardType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradeSettlementPaymentMeansType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

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
public class FinancialCard extends TradeSettlementFinancialCardType implements PaymentCard {

	private static final Logger LOG = Logger.getLogger(FinancialCard.class.getName());
	
//	FinancialCard() {
//		super();
//	}
	
	/**
	 * BG-18 PAYMENT CARD INFORMATION
	 * 
	 * @param @param pan - (mandatory) Payment card primary account number (pan)
	 * @param name - (optional) name of the payment card holder
	 */
	public FinancialCard(String pan, String name) {
		super();
		setCardAccountID(pan);
		setCardHolderName(name);
	}

	FinancialCard(IDType pan) {
		this(pan==null? null : pan.getValue(), null);
	}
	
	// copy ctor:
	FinancialCard(TradeSettlementFinancialCardType tradeSettlementFinancialCard) {
		this(tradeSettlementFinancialCard==null? null : tradeSettlementFinancialCard.getID());
		if(tradeSettlementFinancialCard==null) return;
		TextType cardholderName = tradeSettlementFinancialCard.getCardholderName();
		this.setCardHolderName(cardholderName==null? null : cardholderName.getValue());
	}
	// copy ctor:
	FinancialCard(TradeSettlementPaymentMeansType tradeSettlementPaymentMeans) {
		this(tradeSettlementPaymentMeans==null? null : tradeSettlementPaymentMeans.getApplicableTradeSettlementFinancialCard());
	}

	// BG-18.BT-87
	@Override
	public String getCardAccountID() {
		return super.getID().getValue();
	}

	@Override
	public void setCardAccountID(String pan) {
		if(pan==null) {
			LOG.warning("(mandatory) Payment card primary account number (pan) is null.");
			return;
		}
		super.setID(new Identifier(pan));
	}

	// BG-18.BT-88
	@Override
	public String getCardHolderName() {
		return super.getCardholderName()==null ? null : super.getCardholderName().getValue();
	}

	@Override
	public void setCardHolderName(String name) {
		if(name==null) return;
		super.setCardholderName(new Text(name));	
	}

}
