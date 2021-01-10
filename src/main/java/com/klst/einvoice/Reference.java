package com.klst.einvoice;

/*

Reference basiert lt. "EN 16931_ Document Reference_ Identifier. Type" auf Identifier, 
siehe 6.5.7 der Doku

 */
public interface Reference extends Identifier {

	default void setID(String id) {
		setSchemeIdentifier(id);
	}
	default String getID() {
		return getSchemeIdentifier();
	}

	default void setName(String name) {
		setContent(name);
	}
	default String getName() {
		return getContent();
	}

}
