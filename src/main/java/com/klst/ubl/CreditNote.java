package com.klst.ubl;

import java.sql.Timestamp;

import com.klst.untdid.codelist.DocumentNameCode;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditNoteTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CustomizationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProfileIDType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;

public class CreditNote extends CreditNoteType {

	CreditNote() {
		super();
	}
	
	public CreditNote(String customization, String profile, DocumentNameCode code) {
		this();
		setProcessControl(customization, profile);
		setTypeCode(code); // BT-3		
	}

	// copy-ctor
	public CreditNote(CreditNoteType doc) {
		this(getCustomizationID(doc), getProfileID(doc), getTypeCode(doc));
		setId(getId(doc));
	}
	
	// wie BT-1  Identifier
	public void setId(String id) {
		IDType mID = new IDType();
		mID.setValue(id);
		this.setID(mID);
	}
	public String getId() {
		return getId(this);
	}
	static String getId(CreditNoteType doc) {
		return doc.getID().getValue();
	}

	// wie BT-2  Date
	public void setIssueDate(String ymd) {	
		setIssueDate(Invoice.ymdToTs(ymd));
	}
	public void setIssueDate(Timestamp ts) {
		IssueDateType issueDate = new IssueDateType();
		issueDate.setValue(Invoice.tsToXMLGregorianCalendar(ts));
		super.setIssueDate(issueDate);
	}
	public Timestamp getIssueDateAsTimestamp() {  // bei gleichen Namen getIssueDate() kann es nicht abgeleitet sein
		return getIssueDateAsTimestamp(this);
	}
	static Timestamp getIssueDateAsTimestamp(CreditNoteType doc) {
		IssueDateType issueDate = doc.getIssueDate();
		return Invoice.xmlGregorianCalendarToTs(issueDate.getValue());
	}
	
	// wie BT-3  Code
	void setTypeCode(DocumentNameCode code) {
		CreditNoteTypeCodeType typeCode = new CreditNoteTypeCodeType();
		typeCode.setValue(code.getValueAsString());
		super.setCreditNoteTypeCode(typeCode);
	}
	public DocumentNameCode getTypeCodee() {
		return getTypeCode(this);
	}
	static DocumentNameCode getTypeCode(CreditNoteType doc) {
		return DocumentNameCode.valueOf(doc.getCreditNoteTypeCode());
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

}
