package com.klst.einvoice.unece.uncefact;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import com.klst.einvoice.reflection.CopyCtor;
import com.klst.untdid.codelist.DateTimeFormats;

import un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100.TradePaymentTermsType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.DateTimeType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;

/* Beispiel: 01.07a-INVOICE_uncefact.xml

            <ram:SpecifiedTradePaymentTerms>
                <ram:Description>Bis zum 14.08.2016 ohne Abzug</ram:Description>
                <ram:DueDateDateTime>
                    <udt:DateTimeString format="102">20160814</udt:DateTimeString>
                </ram:DueDateDateTime>
            </ram:SpecifiedTradePaymentTerms>


01.10a-INVOICE_uncefact.xml:

            <ram:SpecifiedTradePaymentTerms>
                <ram:Description>#SKONTO#TAGE=7#PROZENT=2.00#
#SKONTO#TAGE=14#PROZENT=1.00#
#SKONTO#TAGE=30#PROZENT=0.00#</ram:Description>
            </ram:SpecifiedTradePaymentTerms>

03.01a-INVOICE_uncefact.xml:
            <ram:SpecifiedTradePaymentTerms>
                <ram:Description>Dieses Guthaben werden wir auf Ihr Konto erstatten.</ram:Description>
                <ram:DueDateDateTime>
                    <udt:DateTimeString format="102">20190314</udt:DateTimeString>
                </ram:DueDateDateTime>
                <ram:DirectDebitMandateID>[Mandate reference identifier]</ram:DirectDebitMandateID>
            </ram:SpecifiedTradePaymentTerms>

0 .. n SpecifiedTradePaymentTerms Detailinformationen zu Zahlungsbedingungen xs:sequence
0 .. 1 Description Zahlungsbedingungen                                       BT-20
0 .. 1 DueDateDateTime Fälligkeitsdatum xs:choice
1 .. 1 DateTimeString Fälligkeitsdatum der Zahlung                           BT-9
       required format Datum, Format                                         BT-9-0
0 .. 1 DirectDebitMandateID Kennung der Mandatsreferenz                      BG-19/BT-89

 */

public class TradePaymentTerms extends TradePaymentTermsType {

	private static final Logger LOG = Logger.getLogger(TradePaymentTerms.class.getName());

	static TradePaymentTerms create() {
		return new TradePaymentTerms(null);
	}
	// copy factory
	static TradePaymentTerms create(TradePaymentTermsType hts) {
//		if(hts==null) return null;
		if(hts instanceof TradePaymentTermsType && hts.getClass()!=TradePaymentTermsType.class) {
			// hts is instance of a subclass of TradePaymentTermsType, but not TradePaymentTermsType itself
			return (TradePaymentTerms)hts;
		} else {
			return new TradePaymentTerms(hts); 
		}
	}

	private TradePaymentTerms(TradePaymentTermsType doc) {
		super();
		if(doc!=null) {
			CopyCtor.invokeCopy(this, doc);
			LOG.info("copy ctor:"+this);			// TODO toString
		}
	}
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

	// BT-9 & BT-20
	public void setPaymentTermsAndDate(String description, Timestamp ts) {
//		if(description!=null) super.getDescription().add(new Text(description));
//		if(ts!=null) super.setDueDateDateTime(DateTimeFormatStrings.toDateTime(ts));
		setPaymentTerm(description);
		setDueDate(ts);
	}
	
	// BT-9
	public Timestamp getDueDateAsTimestamp() {
		DateTimeType dateTime = super.getDueDateDateTime();
		return dateTime==null ? null : DateTimeFormats.ymdToTs(dateTime.getDateTimeString().getValue());		
	}
	public void setDueDate(Timestamp ts) {
		if(ts!=null) super.setDueDateDateTime(DateTimeFormatStrings.toDateTime(ts));
	}

	// BT-20
	public String getPaymentTerm() {
		List<TextType> list = super.getDescription();
		if(list.isEmpty()) return null;
		return list.get(0).getValue();
	}
	public void setPaymentTerm(String description) {
		if(description!=null) super.getDescription().add(new Text(description));
	}

	// BG-19.BT-89 0..1 Mandate reference identifier, DirectDebitMandateID
	// Synonym: Mandatsreferenz für SEPA, Kennung der Mandatsreferenz
	public void setMandateReferencedID(String mandateID) {
		if(mandateID!=null) {
			List<IDType> list = super.getDirectDebitMandateID();
			if(list.isEmpty()) {
				list.add(new ID(mandateID));
			} else {
				list.set(0, new ID(mandateID));
			}
		}
	}
	public String getMandateReferencedID() {
		List<IDType> list = super.getDirectDebitMandateID();
		if(list.isEmpty()) return null;
		return list.get(0).getValue();
	}
	
}
