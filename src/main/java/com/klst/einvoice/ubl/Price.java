package com.klst.einvoice.ubl;

import java.util.logging.Logger;

import com.klst.einvoice.AllowancesAndCharges;
import com.klst.einvoice.reflection.CopyCtor;
import com.klst.einvoice.unece.uncefact.Amount;
import com.klst.einvoice.unece.uncefact.Quantity;
import com.klst.einvoice.unece.uncefact.UnitPriceAmount;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PriceType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceAmountType;

/* implements BG-29 ++ 1..1 PRICE DETAILS

BT-146 +++ 1..1 Item net price
BT-147 +++ 0..1 Item price discount
BT-148 +++ 0..1 Item gross price
BT-149 +++ 0..1 Item price base quantity
BT-150 +++ 0..1 Item price base quantity unit of measure code 

example: 
ubl-tc434-example5.xml

BG-29.BT-147 0..1 Item price discount, Nachlass auf den Artikelpreis
                      der gesamte zur Berechnung des Nettopreises vom Bruttopreis subtrahierte Rabatt
BG-29.BT-148 0..1 Item gross price, Bruttopreis des Artikels
                      der Einheitspreis ohne Umsatzsteuer vor Abzug des Nachlass auf den Artikelpreis
ubl-tc434-example5.xml :

        <cac:Price>
            <cbc:PriceAmount currencyID="DKK">1.00</cbc:PriceAmount>   <!-- BG-29.BT-146 -->
            <cbc:BaseQuantity unitCode="EA">1</cbc:BaseQuantity>       <!-- BG-29.BT-150:"EA" BG-29.BT-149:1 -->
            <cac:AllowanceCharge>
                <cbc:ChargeIndicator>false</cbc:ChargeIndicator>
                <cbc:Amount currencyID="DKK">0.10</cbc:Amount>         <!-- BG-29.BT-147 -->
                <cbc:BaseAmount currencyID="DKK">1.10</cbc:BaseAmount> <!-- BG-29.BT-148 -->
            </cac:AllowanceCharge>
        </cac:Price>

 */
public class Price extends PriceType {

	// copy factory
	static Price create(PriceType object) {
		if(object instanceof PriceType && object.getClass()!=PriceType.class) {
			// object is instance of a subclass of PriceType, but not PriceType itself
			return (Price)object;
		} else {
			return new Price(object); 
		}
	}

	private static final Logger LOG = Logger.getLogger(Price.class.getName());
	
	// copy ctor
	private Price(PriceType doc) {
		super();
		if(doc!=null) {
			CopyCtor.invokeCopy(this, doc);
			LOG.fine("copy ctor:"+this);			
		}
	}
	
	//BT-146 +++ 1..1 Item net price , Unit price amount
	public void setUnitPriceAmount(UnitPriceAmount unitPriceAmount) {
		if(unitPriceAmount==null) return; // defensiv, ist mandatory
		PriceAmountType priceAmount = new PriceAmountType();
		unitPriceAmount.copyTo(priceAmount);
		super.setPriceAmount(priceAmount);	
	}
	public UnitPriceAmount getUnitPriceAmount() {
		if(super.getPriceAmount()==null) return null;
		return new UnitPriceAmount(getPriceAmount().getCurrencyID(), getPriceAmount().getValue());	
	}

//	BG-29.BT-147 +++ 0..1 Item price discount
//	BG-29.BT-148 +++ 0..1 Item gross price
	void setPriceDiscount(Amount priceDiscount, Amount grossPrice) {
		if(super.getAllowanceCharge().isEmpty()) {
			AllowanceCharge ac = AllowanceCharge.create(AllowancesAndCharges.ALLOWANCE, priceDiscount, grossPrice, null);
			super.getAllowanceCharge().add(ac);
		} else {
			AllowanceCharge ac = AllowanceCharge.create(getAllowanceCharge().get(0)); 
			LOG.info("Allowance:"+ac + " priceDiscount "+priceDiscount + " grossPrice "+grossPrice);			
			if(priceDiscount!=null) ac.setAmountWithoutTax(priceDiscount);
			if(grossPrice!=null) ac.setAmountWithoutTax(grossPrice);
			super.getAllowanceCharge().set(0, ac);
		}
	}
	
//	public void setPriceDiscount(Amount amount) {
//		if(super.getAllowanceCharge().isEmpty()) {
//			AllowanceCharge ac = AllowanceCharge.createAllowance(amount, amount, null);
//			ac.setChargeIndicator(AllowancesAndCharges.ALLOWANCE);
//			ac.setAmountWithoutTax(amount);
//			super.getAllowanceCharge().add(ac);
//		} else {
//			AllowanceCharge ac = AllowanceCharge.create(getAllowanceCharge().get(0)); 
//			LOG.info("Allowance:"+ac + " setPriceDiscount "+amount);			
//			ac.setAmountWithoutTax(amount);
//			super.getAllowanceCharge().set(0, ac);
//		}
//	}
//	public void setGrossPrice(Amount amount) {
//		if(super.getAllowanceCharge().isEmpty()) {
//			AllowanceCharge ac = AllowanceCharge.create(); // TODO factory in AllowanceCharge
//			ac.setChargeIndicator(AllowancesAndCharges.ALLOWANCE);
//			ac.setAssessmentBase(amount);
//			super.getAllowanceCharge().add(ac);
//		} else {
//			AllowanceCharge ac = AllowanceCharge.create(getAllowanceCharge().get(0)); 
//			LOG.info("Allowance:"+ac + " setGrossPrice "+amount);			
//			ac.setAssessmentBase(amount);
//			super.getAllowanceCharge().set(0, ac);
//		}
//	}
	public Amount getPriceDiscount() {
		if(super.getAllowanceCharge().isEmpty()) return null;
		AllowanceCharge allowance = AllowanceCharge.create(getAllowanceCharge().get(0));
		return allowance.getAmountWithoutTax();
	}
	public Amount getGrossPrice() {
		if(super.getAllowanceCharge().isEmpty()) return null;
		AllowanceCharge allowance = AllowanceCharge.create(getAllowanceCharge().get(0));
		return allowance.getAssessmentBase();
	}
	
	/* 
	 * BT-149 0..1 Basismenge zum Artikelpreis
	 * BT-150 0..1 Code der Maßeinheit der Basismenge zum Artikelpreis
	 * 
	 * Bsp.: <cbc:BaseQuantity unitCode="EA">1</cbc:BaseQuantity>
	 * 
	 */
	public void setUnitPriceQuantity(Quantity quantity) {
		if(quantity!=null) {
			BaseQuantityType baseQuantity = new BaseQuantityType();
			baseQuantity.setUnitCode(quantity.getUnitCode());
			baseQuantity.setValue(quantity.getValue());
			super.setBaseQuantity(baseQuantity);
		}	
	}
	public Quantity getUnitPriceQuantity() {
		if(super.getBaseQuantity()==null) return null;
		String unit = getBaseQuantity().getUnitCode();
		return new Quantity(unit, getBaseQuantity().getValue());
	}

}
