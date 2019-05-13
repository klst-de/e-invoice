//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NotificationTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostEventNotificationDurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreEventNotificationDurationMeasureType;


/**
 * <p>Java-Klasse für NotificationRequirementType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="NotificationRequirementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NotificationTypeCode"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PostEventNotificationDurationMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreEventNotificationDurationMeasure" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}NotifyParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}NotificationPeriod" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}NotificationLocation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationRequirementType", propOrder = {
    "notificationTypeCode",
    "postEventNotificationDurationMeasure",
    "preEventNotificationDurationMeasure",
    "notifyParty",
    "notificationPeriod",
    "notificationLocation"
})
public class NotificationRequirementType {

    @XmlElement(name = "NotificationTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected NotificationTypeCodeType notificationTypeCode;
    @XmlElement(name = "PostEventNotificationDurationMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PostEventNotificationDurationMeasureType postEventNotificationDurationMeasure;
    @XmlElement(name = "PreEventNotificationDurationMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PreEventNotificationDurationMeasureType preEventNotificationDurationMeasure;
    @XmlElement(name = "NotifyParty")
    protected List<PartyType> notifyParty;
    @XmlElement(name = "NotificationPeriod")
    protected List<PeriodType> notificationPeriod;
    @XmlElement(name = "NotificationLocation")
    protected List<LocationType> notificationLocation;

    /**
     * Ruft den Wert der notificationTypeCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NotificationTypeCodeType }
     *     
     */
    public NotificationTypeCodeType getNotificationTypeCode() {
        return notificationTypeCode;
    }

    /**
     * Legt den Wert der notificationTypeCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationTypeCodeType }
     *     
     */
    public void setNotificationTypeCode(NotificationTypeCodeType value) {
        this.notificationTypeCode = value;
    }

    /**
     * Ruft den Wert der postEventNotificationDurationMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PostEventNotificationDurationMeasureType }
     *     
     */
    public PostEventNotificationDurationMeasureType getPostEventNotificationDurationMeasure() {
        return postEventNotificationDurationMeasure;
    }

    /**
     * Legt den Wert der postEventNotificationDurationMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PostEventNotificationDurationMeasureType }
     *     
     */
    public void setPostEventNotificationDurationMeasure(PostEventNotificationDurationMeasureType value) {
        this.postEventNotificationDurationMeasure = value;
    }

    /**
     * Ruft den Wert der preEventNotificationDurationMeasure-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PreEventNotificationDurationMeasureType }
     *     
     */
    public PreEventNotificationDurationMeasureType getPreEventNotificationDurationMeasure() {
        return preEventNotificationDurationMeasure;
    }

    /**
     * Legt den Wert der preEventNotificationDurationMeasure-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PreEventNotificationDurationMeasureType }
     *     
     */
    public void setPreEventNotificationDurationMeasure(PreEventNotificationDurationMeasureType value) {
        this.preEventNotificationDurationMeasure = value;
    }

    /**
     * Gets the value of the notifyParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notifyParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotifyParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyType }
     * 
     * 
     */
    public List<PartyType> getNotifyParty() {
        if (notifyParty == null) {
            notifyParty = new ArrayList<PartyType>();
        }
        return this.notifyParty;
    }

    /**
     * Gets the value of the notificationPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notificationPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
     * 
     * 
     */
    public List<PeriodType> getNotificationPeriod() {
        if (notificationPeriod == null) {
            notificationPeriod = new ArrayList<PeriodType>();
        }
        return this.notificationPeriod;
    }

    /**
     * Gets the value of the notificationLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notificationLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocationType }
     * 
     * 
     */
    public List<LocationType> getNotificationLocation() {
        if (notificationLocation == null) {
            notificationLocation = new ArrayList<LocationType>();
        }
        return this.notificationLocation;
    }

}
