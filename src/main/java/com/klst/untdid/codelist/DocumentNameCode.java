package com.klst.untdid.codelist;

import java.util.HashMap;
import java.util.Map;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditNoteTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoiceTypeCodeType;
import un.unece.uncefact.data.standard.qualifieddatatype._100.DocumentCodeType;

/* urn:xoev-de:kosit:codeliste:untdid.1001
 * United Nations Trade Data Interchange Directory (UNTDID), http://www.unece.org/fileadmin/DAM/trade/untdid/d16b/tred/tredi2.htm
 * UN/EDIFACT 1001  Document name code

     220   Order
              Document/message by means of which a buyer initiates a
              transaction with a seller involving the supply of goods
              or services as specified, according to conditions set
              out in an offer, or otherwise known to the buyer.
              
     326   Partial invoice
              Document/message specifying details of an incomplete invoice.
     380   Commercial invoice
              (1334) Document/message claiming payment for goods or services supplied under conditions agreed between seller and buyer.
     384   Corrected invoice
              Commercial invoice that includes revised information differing from an earlier submission of the same invoice.
     389   Self-billed invoice
              An invoice the invoicee is producing instead of the seller.
     381   Credit note
              (1113) Document/message for providing credit information to the relevant party.
     382   Commission note
              (1111) Document/message in which a seller specifies the amount of commission, 
              the percentage of the invoice amount, or some other basis for the calculation of the
              commission to which a sales agent is entitled.
-----------------
     50    Validated priced tender
              A validated priced tender.

     130   Invoicing data sheet
              Document/message issued within an enterprise containing
              data about goods sold, to be used as the basis for the
              preparation of an invoice.

     916   Related document
              Document that has a relationship with the stated
              document/message.

 */
public enum DocumentNameCode {
	
	Order					(220),

	PartialConstructionInvoice 		(875),
	PartialFinalConstructionInvoice	(876),
	FinalConstructionInvoice 		(877),
	
	PartialInvoice 			(326),
	CommercialInvoice		(380),
	CorrectedInvoice 		(384),
	SelfbilledInvoice		(389),
	CreditNote 				(381),
	CommissionNote 			(382),
	
	// used for AdditionalSupportingDocs:
	ValidatedPricedTender   ( 50),	// BT-17 "Price/sales catalogue response" / Ausschreibung oder das Los
	InvoicingDataSheet      (130),	// AdditionalSupportingDoc is BT-18 / Rechnungsdatenblatt
	RelatedDocument         (916);	// AdditionalSupportingDoc is BG-24 / Related document / Referenzpapier
	
	/**
	 * @see <A HREF="http://www.unece.org/trade/untdid/d13b/tred/tred1001.htm">UN/EDIFACT 1001</A>
	 */
	public static final String SCHEME_ID  = "UN/EDIFACT 1001";

	DocumentNameCode(int value) {
		this.value = value;
	}
	
	private final int value;
	
	int getValue() {
		return value;
	}

	public String getValueAsString() {
		return ""+value;
	}

    private static Map<Integer, DocumentNameCode> map = new HashMap<Integer, DocumentNameCode>();
    static {
        for (DocumentNameCode documentNameCode : DocumentNameCode.values()) {
            map.put(documentNameCode.value, documentNameCode);
        }
    }
    
    public static DocumentNameCode valueOf(int code) {
        return map.get(code);
    }

    public static DocumentNameCode valueOf(InvoiceTypeCodeType ublCode) {
    	int code = Integer.parseInt(ublCode.getValue());
        return valueOf(code);
    }

    public static DocumentNameCode valueOf(CreditNoteTypeCodeType ublCode) {
    	int code = Integer.parseInt(ublCode.getValue());
        return valueOf(code);
    }

    public static DocumentNameCode valueOf(DocumentCodeType ciiCode) {
    	int code = Integer.parseInt(ciiCode.getValue());
        return valueOf(code);
    }

}
