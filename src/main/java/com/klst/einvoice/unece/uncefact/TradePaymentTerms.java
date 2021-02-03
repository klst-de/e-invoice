package com.klst.einvoice.unece.uncefact;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.klst.einvoice.reflection.CopyCtor;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;

public class TradePaymentTerms extends TradePaymentTermsType {

	private static final Logger LOG = Logger.getLogger(TradePaymentTerms.class.getName());

	private TradePaymentTerms(TradePaymentTermsType doc) {
		CopyCtor.invokeCopy(this, doc);
	}
	private TradePaymentTerms(TradePaymentTermsType doc, int xxx) {
		super();
		if(doc!=null) {
			Field[] fields = doc.getClass().getDeclaredFields();
			Map<String, Field> fieldsByName = new HashMap<String, Field>(fields.length);
			for(int i=0; i<fields.length; i++) {
				Field field = fields[i];
				String fieldName = fields[i].getName();
				fieldsByName.put(fieldName, field);
			}
			Method[] methods = doc.getClass().getDeclaredMethods();
			List<Method> setters = new ArrayList<Method>(methods.length);
			Map<String, Method> settersByName = new HashMap<String, Method>(methods.length);
			for(int i=0; i<methods.length; i++) {
				Method method = methods[i];
				String methodName = method.getName();
				// die setter mit einem Parameter heißen setXXX, also 
				if(methodName.startsWith("set") && method.getParameterCount()==1) {
					setters.add(method);
					// die setter können korrespondierende getter haben, aber nicht wenn es Listen/xs:sequence sind
					// Beispiel: TradePaymentTermsType:: public List<TextType> getDescription()
					settersByName.put(methodName, method);
				}
			}
			List<Method> getters = new ArrayList<Method>(methods.length);
			for(int i=0; i<methods.length; i++) {
				Method method = methods[i];
				String methodName = method.getName();
				// die getter ohne Parameter heißen getXXX, also 
				if(methodName.startsWith("get") && method.getParameterCount()==0) {
					getters.add(method);
					Method getter = method;
					String getterName = methodName;
					// die getter können korrespondierende setter haben
					String setterName = "set"+methodName.substring(3);
					if(settersByName.containsKey(setterName)) {
						Method setter = settersByName.get(setterName); // potentieller Setter muss den Parameter == Result des getters haben
						Class<?> param0Type = setter.getParameterTypes()[0];
						if(method.getReturnType()==param0Type) {						
							LOG.info(setterName+" + "+methodName);
						    try {
						    	getter.invoke(doc);
						    	setter.invoke(this, getter.invoke(doc));
						    } catch (Exception e) {
						        LOG.warning(setterName+" + "+methodName + "Exception:"+e);
						    }
						} else {
							LOG.warning(setterName+" + "+methodName + " typen passen nicht");
/*
#9:
INFORMATION: setTypeCode + getTypeCode
INFORMATION: setID + getID
INFORMATION: setApplicableTradePaymentPenaltyTerms + getApplicableTradePaymentPenaltyTerms
INFORMATION: setApplicableTradePaymentDiscountTerms + getApplicableTradePaymentDiscountTerms
INFORMATION: setSettlementPeriodMeasure + getSettlementPeriodMeasure
INFORMATION: setPartialPaymentPercent + getPartialPaymentPercent
INFORMATION: setDueDateDateTime + getDueDateDateTime
INFORMATION: setInstructionTypeCode + getInstructionTypeCode
INFORMATION: setFromEventCode + getFromEventCode
#5:
INFORMATION: List<?> getter : getPayeeTradeParty
INFORMATION: List<?> getter : getDirectDebitMandateID
INFORMATION: List<?> getter : getPaymentMeansID
INFORMATION: List<?> getter : getPartialPaymentAmount
INFORMATION: List<?> getter : getDescription
#14 fields

 */
						}
					} else {
						// if(settersByName.containsKey(setterName)) false ==> es gibt keinen passenden Setter
						// dann muss es ein member/field geben mit name==getterName (
						String fieldName = getterName.substring(3, 4).toLowerCase()+getterName.substring(4);
						LOG.info("List<?> "+fieldName+" = "+methodName);
						if(fieldsByName.containsKey(fieldName)) {
							Field field = fieldsByName.get(fieldName);
						    try {
						    	// see https://stackoverflow.com/questions/24094871/set-field-value-with-reflection
						    	getter.invoke(doc);
						    	field.set(this, getter.invoke(doc));
						    } catch (Exception e) {
						        LOG.warning("List<?> "+fieldName+" = "+methodName + "Exception:"+e);
						    }
						} else {
							LOG.warning("List<?> "+fieldName+" zu  "+methodName + " nicht gefunden.");
						}
					}
				}
			}
			
//			super.setID(doc.getID());
//			...
		}
	}

	// Test:
	public static void main(String[] args) {
		TradePaymentTerms tradePaymentTerms = new TradePaymentTerms(new TradePaymentTermsType());
	}

}
