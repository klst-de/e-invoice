package com.klst.einvoice.unece.uncefact;

import java.util.ArrayList;
import java.util.List;

import com.klst.ebXml.reflection.SCopyCtor;
import com.klst.edoc.api.BusinessParty;
import com.klst.edoc.api.Identifier;
import com.klst.edoc.api.Reference;
import com.klst.edoc.untdid.DocumentNameCode;
import com.klst.einvoice.api.SupportingDocument;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.HeaderTradeAgreementType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.ReferencedDocumentType;
import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePartyType;

public class HeaderTradeAgreement extends HeaderTradeAgreementType {

	static HeaderTradeAgreement create() {
		return new HeaderTradeAgreement(null);
	}
	// copy factory
	static HeaderTradeAgreement create(HeaderTradeAgreementType object) {
		// @see https://stackoverflow.com/questions/2699788/java-is-there-a-subclassof-like-instanceof
		if(object instanceof HeaderTradeAgreementType && object.getClass()!=HeaderTradeAgreementType.class) {
			// object is instance of a subclass of HeaderTradeAgreementType, but not HeaderTradeAgreementType itself
			return (HeaderTradeAgreement)object;
		} else {
			return new HeaderTradeAgreement(object); 
		}
	}

	private static final String FIELD_issuerAssignedID = "issuerAssignedID";

	// copy ctor
	private HeaderTradeAgreement(HeaderTradeAgreementType object) {
		super();
		if(object!=null) {
			SCopyCtor.getInstance().invokeCopy(this, object);
		}
	}

	// BT-10 0..1 Buyer reference
	void setBuyerReference(String reference) {
		if(reference==null) return;
		super.setBuyerReference(Text.create(reference));
	}
	String getBuyerReferenceValue() {
		return super.getBuyerReference()==null ? null : getBuyerReference().getValue();	
	}

	// BT-11 0..1 Project reference
	void setProjectReference(String id, String name) {
		SCopyCtor.getInstance().newFieldInstance(this, "specifiedProcuringProject", id);
		SCopyCtor.getInstance().set(getSpecifiedProcuringProject(), "id", id);
		SCopyCtor.getInstance().set(getSpecifiedProcuringProject(), "name", name);
	}
	Reference getProjectReference() {
		return getSpecifiedProcuringProject()==null ? null 
				: new ID( getSpecifiedProcuringProject().getName()==null ? "" : getSpecifiedProcuringProject().getName().getValue()
						, getSpecifiedProcuringProject().getID()==null ? null : getSpecifiedProcuringProject().getID().getValue()
						);
	}

	// BT-12 0..1 Contract reference
	void setContractReference(String id) {
		SCopyCtor.getInstance().newFieldInstance(this, "contractReferencedDocument", id);
		SCopyCtor.getInstance().set(getContractReferencedDocument(), FIELD_issuerAssignedID, id);
	}
	String getContractReference() {
		if(getContractReferencedDocument()==null) return null;
		return getContractReferencedDocument().getIssuerAssignedID()==null ? null : getContractReferencedDocument().getIssuerAssignedID().getValue();
	}

	// BT-13 0..1 Purchase order reference
	void setPurchaseOrderReference(String id) {
		SCopyCtor.getInstance().newFieldInstance(this, "buyerOrderReferencedDocument", id);
		SCopyCtor.getInstance().set(getBuyerOrderReferencedDocument(), FIELD_issuerAssignedID, id);
	}
	String getPurchaseOrderReference() {
		if(getBuyerOrderReferencedDocument()==null) return null;
		return getBuyerOrderReferencedDocument().getIssuerAssignedID()==null ? null : getBuyerOrderReferencedDocument().getIssuerAssignedID().getValue();
	}

	// BT-14 0..1 Sales order reference
	void setOrderReference(String id) {
		SCopyCtor.getInstance().newFieldInstance(this, "sellerOrderReferencedDocument", id);
		SCopyCtor.getInstance().set(getSellerOrderReferencedDocument(), FIELD_issuerAssignedID, id);
	}
	String getOrderReference() {
		ReferencedDocumentType referencedDocument = getSellerOrderReferencedDocument();
		if(referencedDocument==null) return null;
		return referencedDocument.getIssuerAssignedID()==null ? null : referencedDocument.getIssuerAssignedID().getValue();
	}

	// BT-17 0..1 Tender or lot reference
	void setTenderOrLotReference(String docRefId) {
		if(docRefId==null) return;
		ReferencedDocument rd = ReferencedDocument.create(docRefId, DocumentNameCode.ValidatedPricedTender.getValueAsString()
				, (String)null);
		super.getAdditionalReferencedDocument().add(rd);
	}
	String getTenderOrLotReference() {
		List<ReferencedDocumentType> list = super.getAdditionalReferencedDocument();
		List<SupportingDocument> res = new ArrayList<SupportingDocument>(list.size());
		list.forEach(rd -> {
			ReferencedDocument referencedDocument = ReferencedDocument.create(rd);
			if(referencedDocument.isValidatedPricedTender()) res.add(referencedDocument);
		});
		return res.isEmpty() ? null : res.get(0).getDocumentReference().getName();
	}

	// BT-18 0..1 Invoiced object identifier
	void setInvoicedObject(String name, String schemeID) {
		ReferencedDocument rd = ReferencedDocument.create(name, DocumentNameCode.InvoicingDataSheet.getValueAsString()
				, schemeID);
		super.getAdditionalReferencedDocument().add(rd);
	}
	Identifier getInvoicedObjectIdentifier() {
		List<ReferencedDocumentType> list = super.getAdditionalReferencedDocument();
		List<ReferencedDocument> res = new ArrayList<ReferencedDocument>(list.size());
		list.forEach(rd -> {
			ReferencedDocument referencedDocument = ReferencedDocument.create(rd);
			if(referencedDocument.isInvoicingDataSheet()) res.add(referencedDocument);
		});
		if(res.isEmpty()) return null;
		ReferencedDocument sd = res.get(0);
		return new ID(sd.getDocumentReference().getName(), sd.getReferenceCode());
	}

	// BG-4 1..1 SELLER
	void setSeller(BusinessParty party) {
		super.setSellerTradeParty((TradePartyType) party);
	}
	BusinessParty getSeller() {
		TradePartyType sellerParty = super.getSellerTradeParty();
		return sellerParty==null ? null : TradeParty.create(sellerParty);
	}
	
	// BG-7 1..1 BUYER
	void setBuyer(BusinessParty party) {
		super.setBuyerTradeParty((TradePartyType) party);
	}
	BusinessParty getBuyer() {
		TradePartyType buyerParty = super.getBuyerTradeParty();
		return buyerParty==null ? null : TradeParty.create(buyerParty);
	}

	// BG-11 0..1 SELLER TAX REPRESENTATIVE PARTY
	void setTaxRepresentative(BusinessParty party) {
		super.setSellerTaxRepresentativeTradeParty((TradePartyType) party);
	}
	BusinessParty getTaxRepresentative() {
		TradePartyType party = super.getSellerTaxRepresentativeTradeParty();
		return party==null ? null : TradeParty.create(party);
	}

	// BG-24 0..n ADDITIONAL SUPPORTING DOCUMENTS
	void addSupportigDocument(SupportingDocument supportigDocument) {
		super.getAdditionalReferencedDocument().add((ReferencedDocument)supportigDocument);
	}
	List<SupportingDocument> getAdditionalSupportingDocuments() {
		List<ReferencedDocumentType> list = super.getAdditionalReferencedDocument();
		List<SupportingDocument> res = new ArrayList<SupportingDocument>(list.size());
		list.forEach(rd -> {
			ReferencedDocument referencedDocument = ReferencedDocument.create(rd);
			if(referencedDocument.isRelatedDocument()) res.add(referencedDocument);
		});
		return res;
	}

}
