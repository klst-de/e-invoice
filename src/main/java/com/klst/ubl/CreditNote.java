package com.klst.ubl;

import com.klst.untdid.codelist.DocumentNameCode;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditNoteTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;

public class CreditNote extends CreditNoteType {

	CreditNote() {
		super();
	}
	
	public CreditNote(String customization, String profile, DocumentNameCode documentNameCode) {
		this();
		setProcessControl(customization, profile);
			
		// Ein Code, der den Funktionstyp angibt.
		CreditNoteTypeCodeType itc = new CreditNoteTypeCodeType();
		itc.setValue(documentNameCode.getValueAsString());
		this.setCreditNoteTypeCode(itc);		
	}

	// copy-ctor
	public CreditNote(CreditNoteType doc) {
		this(getCustomizationID(doc), getProfileID(doc), getDocumentNameCode(doc));
	}
	
	void setProcessControl(String customization, String profile) {
		CustomizationIDType customizationID = new CustomizationIDType();
		customizationID.setValue(customization);
//		customizationID.setSchemeID("XRECHNUNG");
		this.setCustomizationID(customizationID);
		if(profile==null) {
			// profileID ist optional
		} else {
			ProfileIDType profileID = new ProfileIDType();
			profileID.setValue(profile);
			this.setProfileID(profileID);
		}
	}

	public String getCustomization() {
		return getCustomizationID(this);
	}
	static String getCustomizationID(CreditNoteType doc) {
		CustomizationIDType customizationID =doc.getCustomizationID();
		return customizationID.getValue();
	}
	
	public String getProfile() {
		return getProfileID(this);
	}
	static String getProfileID(CreditNoteType doc) {
		ProfileIDType profileID = doc.getProfileID();
		if(profileID==null) {
			return null;
		}
		return profileID.getValue();
	}

	public DocumentNameCode getDocumentNameCode() {
		return getDocumentNameCode(this);
	}
	static DocumentNameCode getDocumentNameCode(CreditNoteType doc) {
		return DocumentNameCode.valueOf(doc.getCreditNoteTypeCode());
	}


}
