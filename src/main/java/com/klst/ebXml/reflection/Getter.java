package com.klst.ebXml.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class Getter {

	private static final Logger LOG = Logger.getLogger(Getter.class.getName());

    private static final String METHOD_GETVALUE = "getValue";
    public static Object getValue(Object codeType, String clazz) {
		Class<?> type = null;
		try {
			// dynamisch die Klasse laden
			type = Class.forName(clazz);
		} catch (ClassNotFoundException e) {
			LOG.warning(e.getMessage());
			e.printStackTrace(); // darf nicht passieren
			return null;
		}
		
		if(type.isInstance(codeType)) {
			try {
				Method getValue = type.getDeclaredMethod(METHOD_GETVALUE);
				return getValue.invoke(codeType);
			} catch (NoSuchMethodException e) {
				LOG.severe(METHOD_GETVALUE + "() not defined for " + codeType.getClass().getSimpleName());
				e.printStackTrace(); // darf nicht passieren
			} catch (IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
				LOG.severe(e.getMessage());
				e.printStackTrace(); // darf nicht passieren
			}					
		}
		
		return null;
    }

}
