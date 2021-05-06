package com.klst.einvoice.unece.uncefact;

import java.util.ArrayList;
import java.util.List;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.einvoice.api.CoreInvoice;
import com.klst.einvoice.api.CoreInvoiceLine;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeLineItemType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.SupplyChainTradeTransactionType;

public class SupplyChainTradeTransaction extends SupplyChainTradeTransactionType {

	static SupplyChainTradeTransaction create() {
		return new SupplyChainTradeTransaction(null); 
	}
	// copy factory
	static SupplyChainTradeTransaction create(SupplyChainTradeTransactionType object, CoreInvoice invoice) {
		SupplyChainTradeTransaction res;
		if(object instanceof SupplyChainTradeTransactionType && object.getClass()!=SupplyChainTradeTransactionType.class) {
			// object is instance of a subclass of SupplyChainTradeTransactionType, but not SupplyChainTradeTransactionType itself
			res = (SupplyChainTradeTransaction)object;
		} else {
			res = new SupplyChainTradeTransaction(object); 
		}
//		res.invoice = invoice; // not used
		return res;
	}

//	private CoreInvoice invoice;

	// copy ctor
	private SupplyChainTradeTransaction(SupplyChainTradeTransactionType object) {
		super();
		if(object!=null) {
			SCopyCtor.getInstance().invokeCopy(this, object);
		}
	}

	// BG-25 1..n INVOICE LINE
	void addLine(CoreInvoiceLine line) {
		super.getIncludedSupplyChainTradeLineItem().add((TradeLineItem)line);
	}
	List<CoreInvoiceLine> getLines() {
		List<SupplyChainTradeLineItemType> lines = super.getIncludedSupplyChainTradeLineItem();
		List<CoreInvoiceLine> resultLines = new ArrayList<CoreInvoiceLine>(lines.size());
		lines.forEach(line -> {
			resultLines.add(TradeLineItem.create(line));
		});
		return resultLines;
	}
	
	HeaderTradeAgreement createtHeaderTradeAgreement() {
		return HeaderTradeAgreement.create(getApplicableHeaderTradeAgreement());
	}

	HeaderTradeDelivery createtHeaderTradeDelivery() {
		return HeaderTradeDelivery.create(getApplicableHeaderTradeDelivery());
	}
	
	HeaderTradeSettlement createtHeaderTradeSettlement() {
		return HeaderTradeSettlement.create(getApplicableHeaderTradeSettlement());
	}
	

}
