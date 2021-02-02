package com.klst.einvoice.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class CopyCtor {

	private static final Logger LOG = Logger.getLogger(CopyCtor.class.getName());

	public static Map<String, Field> getFieldsByName(Class<?> type) {
		Field[] fields = type.getDeclaredFields();
		Map<String, Field> fieldsByName = new HashMap<String, Field>(fields.length);
		for(int i=0; i<fields.length; i++) {
			Field field = fields[i];
			String fieldName = fields[i].getName();
			fieldsByName.put(fieldName, field);
		}
		return fieldsByName;
	}
	
	private static final String get = "get";
	private static final String set = "set";
	
	public static Map<String, Method> getSettersByName(Class<?> type) {
		// setter Signatur: void setXXX(T arg)
		return getMethodByName(type, set, 1);
	}
	public static Map<String, Method> getGettersByName(Class<?> type) {
		// getter Signatur: T getXXX()
		return getMethodByName(type, get, 0);
	}
		
	private static Map<String, Method> getMethodByName(Class<?> type, String prefix, int parameterCount) {
		Method[] methods = type.getDeclaredMethods();
		Map<String, Method> methodByName = new HashMap<String, Method>(methods.length);
		for(int i=0; i<methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();
			if(methodName.startsWith(prefix) && method.getParameterCount()==parameterCount) {
				methodByName.put(methodName, method);
			}
		}
		return methodByName;
	}
	
	// obj class extends doc!
	public static void invokeCopy(Object obj, Object doc) {
		LOG.fine("for "+doc);
		Map<String, Field> fieldsByName = getFieldsByName(doc.getClass());
		Map<String, Method> settersByName = getSettersByName(doc.getClass());
		Map<String, Method> gettersByName = getGettersByName(doc.getClass());
		List<String> getterNames = new ArrayList<>(gettersByName.keySet());
		for(int i=0; i<getterNames.size(); i++) {
			String getterName = getterNames.get(i);
			Method getter = gettersByName.get(getterName);
			// die getter können korrespondierende setter haben
			String setterName = set+getterName.substring(set.length());
			if(settersByName.containsKey(setterName)) {
				Method setter = settersByName.get(setterName); // potentieller Setter muss den Parameter == Result des getters haben
				if(getter.getReturnType()==setter.getParameterTypes()[0]) {						
					LOG.fine(setterName+" ( "+getterName+" ) ");
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
				String fieldName = getterName.substring(set.length(), set.length()+1).toLowerCase()+getterName.substring(set.length()+1);
				LOG.fine("List<?> "+fieldName+" = "+getterName);
				if(fieldsByName.containsKey(fieldName)) {
					Field field = fieldsByName.get(fieldName);
				    try {
				    	// see https://stackoverflow.com/questions/24094871/set-field-value-with-reflection
				    	field.setAccessible(true);
				    	field.set(obj, getter.invoke(doc));
				    } catch (Exception e) {
				        LOG.warning("List<?> "+fieldName+" = "+getterName + "Exception:"+e);
				    }
				} else {
					LOG.warning("List<?> "+fieldName+" zu  "+getterName + " nicht gefunden.");
				}
			}
		} 
		
	}
	
}
