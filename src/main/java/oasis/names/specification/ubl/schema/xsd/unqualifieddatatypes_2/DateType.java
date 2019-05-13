//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDespatchDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualPickupDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ApprovalDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AvailabilityDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BestBeforeDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BirthDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparisonForecastIssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EarliestPickupDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EffectiveDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDespatchDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpiryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FirstShipmentAvailibilityDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GuaranteedDespatchDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstallmentDueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LastRevisionDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestMeterReadingDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestPickupDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestProposalAcceptanceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestSecurityClearanceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ManufactureDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NominationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OccurrenceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentDueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PlannedDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousMeterReadingDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReceivedDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegisteredDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationExpirationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDespatchDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedPublicationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResponseDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RevisionDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceForecastIssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubmissionDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubmissionDueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxPointDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidityStartDateType;


/**
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT000009&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Date. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;One calendar day according the Gregorian calendar.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Date&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 *             
 * 
 * <p>Java-Klasse für DateType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DateType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>date">
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateType", propOrder = {
    "value"
})
@XmlSeeAlso({
    LatestSecurityClearanceDateType.class,
    RegisteredDateType.class,
    ValidityStartDateType.class,
    ValidationDateType.class,
    ActualPickupDateType.class,
    NominationDateType.class,
    FirstShipmentAvailibilityDateType.class,
    RequiredDeliveryDateType.class,
    EstimatedDeliveryDateType.class,
    EstimatedDespatchDateType.class,
    GuaranteedDespatchDateType.class,
    EffectiveDateType.class,
    InstallmentDueDateType.class,
    ActualDeliveryDateType.class,
    IssueDateType.class,
    ReferenceDateType.class,
    ManufactureDateType.class,
    ReceivedDateType.class,
    LatestDeliveryDateType.class,
    CallDateType.class,
    SubmissionDueDateType.class,
    ActualDespatchDateType.class,
    LastRevisionDateType.class,
    ResolutionDateType.class,
    SourceForecastIssueDateType.class,
    ApprovalDateType.class,
    LatestProposalAcceptanceDateType.class,
    OccurrenceDateType.class,
    oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DateType.class,
    BestBeforeDateType.class,
    LatestPickupDateType.class,
    SubmissionDateType.class,
    ResponseDateType.class,
    EndDateType.class,
    EarliestPickupDateType.class,
    RevisionDateType.class,
    ExpiryDateType.class,
    DueDateType.class,
    AwardDateType.class,
    TaxPointDateType.class,
    ComparisonForecastIssueDateType.class,
    AvailabilityDateType.class,
    PreviousMeterReadingDateType.class,
    PaymentDueDateType.class,
    PaidDateType.class,
    RegistrationDateType.class,
    LatestMeterReadingDateType.class,
    RegistrationExpirationDateType.class,
    PlannedDateType.class,
    RequestedPublicationDateType.class,
    StartDateType.class,
    RequestedDespatchDateType.class,
    BirthDateType.class,
    RequestedDeliveryDateType.class
})
public class DateType {

    @XmlValue
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar value;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValue(XMLGregorianCalendar value) {
        this.value = value;
    }

}
