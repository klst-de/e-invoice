package com.klst.ebXml.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
/* Notice 
 * that there are two @Singleton annotations, 
 * one in javax.inject and the other in the javax.ebj package. 
 * I'm referring to them by their fully-qualified names to avoid confusion.
 * @see https://stackoverflow.com/questions/26832051/singleton-vs-applicationscope
 * @see https://github.com/javax-inject/javax-inject
 */
@Singleton
public class SCopyCtor {

	private static final Logger LOG = Logger.getLogger(SCopyCtor.class.getName());

	public static SCopyCtor SINGLETON = new SCopyCtor();

	public static SCopyCtor getInstance() {
		return SINGLETON;
	}
	
	private static final String TYPE_NAME_SEPARATOR = "::";

	Map<String, String> getterFieldMap = new HashMap<String, String>();
	
	private SCopyCtor() {
		// Ausnahmen: getter getYYY liefert nicht Fieldname YYY
		// un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100
		getterFieldMap.put("getID", "id");
		getterFieldMap.put("getURIUniversalCommunication", "uriUniversalCommunication");
		
		// org.opentrans.xmlschema._2
		getterFieldMap.put("getEMAILAndPUBLICKEY", "emailAndPUBLICKEY");

	}
	
	Map<String, Field> fieldsByName = new HashMap<String, Field>();
	
	private Map<String, Field> getFieldsByName(Class<?> type) {
		return getFieldsByName(type, type);
	}
	private Map<String, Field> getFieldsByName(Class<?> type, Class<?> otype) {
		Field[] fields = type.getDeclaredFields();
		for(int i=0; i<fields.length; i++) {
			Field field = fields[i];
			if(Modifier.isPublic(field.getModifiers()) || Modifier.isProtected(field.getModifiers())) {
				Field prev = fieldsByName.put(otype.getCanonicalName()+TYPE_NAME_SEPARATOR+field.getName(), field);
				if(prev==null) LOG.fine("added "+otype.getCanonicalName()+TYPE_NAME_SEPARATOR+field.getName());
			}
		}
		if(type.getSuperclass()==null || type.getSuperclass()==Object.class) {
			return fieldsByName;
		}
		return getFieldsByName(type.getSuperclass(), otype);
	}
	
	private static final String get = "get";
	private static final String set = "set";

	Map<String, Method> settersByName = new HashMap<String, Method>();
	Map<String, Method> gettersByName = new HashMap<String, Method>();

	public Map<String, Method> getSettersByName(Class<?> type) {
		// setter Signatur: void setXXX(T arg)
		return getMethodByName(type, set, 1, settersByName);
	}
	public Map<String, Method> getGettersByName(Class<?> type) {
		// getter Signatur: T getXXX()
		return getMethodByName(type, get, 0, gettersByName);
	}
		
	private Map<String, Method> getMethodByName(Class<?> type, String prefix, int parameterCount, Map<String, Method> methodByName) {
		return getMethodByName(type, type, prefix, parameterCount, methodByName);
	}
	private Map<String, Method> getMethodByName(Class<?> type, Class<?> otype, String prefix, int parameterCount, Map<String, Method> methodByName) {
		Method[] methods = type.getDeclaredMethods();
		for(int i=0; i<methods.length; i++) {
			Method method = methods[i];
			if(Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
				String methodName = method.getName();
				if(methodName.startsWith(prefix) && method.getParameterCount()==parameterCount) {
					Method prev = methodByName.put(otype.getCanonicalName()+TYPE_NAME_SEPARATOR+methodName, method);
					if(prev==null) LOG.fine("added "+otype.getCanonicalName()+TYPE_NAME_SEPARATOR+methodName);
				}
			}
		}
		if(type.getSuperclass()==null || type.getSuperclass()==Object.class) {
			return methodByName;
		}
		return getMethodByName(type.getSuperclass(), otype, prefix, parameterCount, methodByName);
	}
	
	/* obj class extends doc class! Bsp: class HeaderTradeDelivery extends HeaderTradeDeliveryType
	 * Initialisiert alle Felder von obj mit den Werten von doc per setter/getter, also: obj.setXXX(doc.getXXX())
	 * - setXXX und getXXX müssen in doc class definiert sein 
	 * -- auch wenn setXXX/getXXX in super von doc definiert sind, 
	 *    Bsp. OT Remarks extends REMARKS, super class REMARKS extends TypeMLSTRING64000 extends DtMLSTRING
	 *    getValue() kommt aus DtMLSTRING
	 */
	public void invokeCopy(Object obj, Object doc) {
		LOG.fine("for "+doc);
		getFieldsByName(doc.getClass());
		getSettersByName(doc.getClass());
		getGettersByName(doc.getClass());
		List<String> getterNames = new ArrayList<>(gettersByName.keySet());
		// es interessieren nur die der Klasse doc.getClass() und die der Oberklassen dazu
		for(int i=0; i<getterNames.size(); i++) {
			String getterName = getterNames.get(i);
			if(!getterName.startsWith(doc.getClass().getCanonicalName()+TYPE_NAME_SEPARATOR)) {
				continue;
			}
			Method getter = gettersByName.get(getterName);
			getterName = getterName.substring(getterName.indexOf(TYPE_NAME_SEPARATOR)+TYPE_NAME_SEPARATOR.length());
			// die getter können korrespondierende setter haben
			String setterName = set+getterName.substring(set.length());
			String setterKey = doc.getClass().getCanonicalName()+TYPE_NAME_SEPARATOR + setterName;
			if(settersByName.containsKey(setterKey)) {
				Method setter = settersByName.get(setterKey); // potentieller Setter muss den Parameter == Result des getters haben
				if(getter.getReturnType()==setter.getParameterTypes()[0]) {						
					LOG.fine(setterName+" ( "+getterName+"() ) ");
					try {
						setter.invoke(obj, getter.invoke(doc)); // obj.setXXX( doc.getXXX() )
				    } catch (Exception e) {
				        LOG.warning(setterName+" ( "+getterName+" ) " + "Exception:"+e);
				    }						
				} else {
					LOG.warning(setterName+" + "+getterName + " typen passen nicht");
				}
			} else {
				// if(settersByName.containsKey(setterName)) false ==> es gibt keinen passenden Setter
				// dann muss es ein member/field geben mit name==getterName (beginnend mit Kleinbuchstaben)
				// ausser ausnahmen in this.getterFieldMap "getID" ...
				String fieldName = getFieldnameLowerCaseFirstLetter(getterName);
				
				LOG.fine("List<?> "+fieldName+" = "+getterName);
				String fieldNameWithTypePrefix = doc.getClass().getCanonicalName()+TYPE_NAME_SEPARATOR+fieldName;
				if(fieldsByName.containsKey(fieldNameWithTypePrefix)) {
					Field field = fieldsByName.get(fieldNameWithTypePrefix);
					setFieldValueWithReflection(obj, doc, field, getter);
				} else {
					// in openTrans ist es anders (auch mit Ausnahmen)
					//ALLOWORCHARGE::List<?> alloworchargedescr = getALLOWORCHARGEDESCR
					//ADDRESS::List<?> emailandpublickey zu getEMAILAndPUBLICKEY nicht gefunden.
					fieldName = getFieldnameLowerCase(getterName);					
					
					LOG.fine(doc.getClass().getSimpleName()+"::List<?> "+fieldName+" = "+getterName+"()");
					fieldNameWithTypePrefix = doc.getClass().getCanonicalName()+TYPE_NAME_SEPARATOR+fieldName;
					if(fieldsByName.containsKey(fieldNameWithTypePrefix)) {
						Field field = fieldsByName.get(fieldNameWithTypePrefix);
						setFieldValueWithReflection(obj, doc, field, getter);
					} else {
						LOG.warning(doc.getClass().getSimpleName()+"::List<?> "+fieldName+" zu "+getterName + " nicht gefunden.");
					}
				}
			}
		} 
		
	}
	
	/*
	 * in UNCEFACT und in UBL kann man aus <getterName> den <fieldName> ermitteln,
	 * Beispiel:     getShipToTradeParty() { // bzw. List<IDType> getGlobalID()
	 * liefert   return shipToTradeParty;                return this.globalID;
	 * 
	 * Bis auf getterFieldMap Ausnahmen "getID" geht es auf! 
	 * Beispiel ===> in TradePartyType: List<IDType> getID() und liefert field id und nicht "ID";
	 * 
	 * Bei anderen schemas gilt es nicht, Beispiel openTrans:
	 *               getPAYMENT() {
	 * liefert   return payment; 
	 */
	private String getFieldnameLowerCaseFirstLetter(String getterName) {
		String fieldname = getterFieldMap.get(getterName);
		if(fieldname!=null) return fieldname;
		int length = get.length();
		return getterName.substring(length, length+1).toLowerCase()+getterName.substring(length+1);
	}
	private String getFieldnameLowerCase(String getterName) {
		String fieldname = getterFieldMap.get(getterName);
		if(fieldname!=null) return fieldname;
		int length = get.length();
		return getterName.substring(length, getterName.length()).toLowerCase();
	}
	
	// see https://stackoverflow.com/questions/24094871/set-field-value-with-reflection
	// macht dynamisch: obj.setXXX( doc.getXXX() ) für Listen
	//            also: obj.YYY = doc.getYYY(), d.h. YYY ist field und getYYY ist getter
	private static void setFieldValueWithReflection(Object obj, Object doc, Field field, Method getter) {
	    try {
	    	field.setAccessible(true);
	    	field.set(obj, getter.invoke(doc));
	    } catch (Exception e) {
	        LOG.warning("List<?> "+field.getName()+" = "+getter.getName() + "Exception:"+e);
	    }
	
	}
}
