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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChangeConditionsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportServiceProviderSpecialTermsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportUserSpecialTermsType;


/**
 * <p>Java-Klasse für TransportExecutionTermsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransportExecutionTermsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportUserSpecialTerms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportServiceProviderSpecialTerms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChangeConditions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentTerms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DeliveryTerms" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BonusPaymentTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CommissionPaymentTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PenaltyPaymentTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnvironmentalEmission" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}NotificationRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ServiceChargePaymentTerms" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportExecutionTermsType", propOrder = {
    "transportUserSpecialTerms",
    "transportServiceProviderSpecialTerms",
    "changeConditions",
    "paymentTerms",
    "deliveryTerms",
    "bonusPaymentTerms",
    "commissionPaymentTerms",
    "penaltyPaymentTerms",
    "environmentalEmission",
    "notificationRequirement",
    "serviceChargePaymentTerms"
})
public class TransportExecutionTermsType {

    @XmlElement(name = "TransportUserSpecialTerms", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TransportUserSpecialTermsType> transportUserSpecialTerms;
    @XmlElement(name = "TransportServiceProviderSpecialTerms", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<TransportServiceProviderSpecialTermsType> transportServiceProviderSpecialTerms;
    @XmlElement(name = "ChangeConditions", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ChangeConditionsType> changeConditions;
    @XmlElement(name = "PaymentTerms")
    protected List<PaymentTermsType> paymentTerms;
    @XmlElement(name = "DeliveryTerms")
    protected List<DeliveryTermsType> deliveryTerms;
    @XmlElement(name = "BonusPaymentTerms")
    protected PaymentTermsType bonusPaymentTerms;
    @XmlElement(name = "CommissionPaymentTerms")
    protected PaymentTermsType commissionPaymentTerms;
    @XmlElement(name = "PenaltyPaymentTerms")
    protected PaymentTermsType penaltyPaymentTerms;
    @XmlElement(name = "EnvironmentalEmission")
    protected List<EnvironmentalEmissionType> environmentalEmission;
    @XmlElement(name = "NotificationRequirement")
    protected List<NotificationRequirementType> notificationRequirement;
    @XmlElement(name = "ServiceChargePaymentTerms")
    protected PaymentTermsType serviceChargePaymentTerms;

    /**
     * Gets the value of the transportUserSpecialTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportUserSpecialTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportUserSpecialTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportUserSpecialTermsType }
     * 
     * 
     */
    public List<TransportUserSpecialTermsType> getTransportUserSpecialTerms() {
        if (transportUserSpecialTerms == null) {
            transportUserSpecialTerms = new ArrayList<TransportUserSpecialTermsType>();
        }
        return this.transportUserSpecialTerms;
    }

    /**
     * Gets the value of the transportServiceProviderSpecialTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transportServiceProviderSpecialTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransportServiceProviderSpecialTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransportServiceProviderSpecialTermsType }
     * 
     * 
     */
    public List<TransportServiceProviderSpecialTermsType> getTransportServiceProviderSpecialTerms() {
        if (transportServiceProviderSpecialTerms == null) {
            transportServiceProviderSpecialTerms = new ArrayList<TransportServiceProviderSpecialTermsType>();
        }
        return this.transportServiceProviderSpecialTerms;
    }

    /**
     * Gets the value of the changeConditions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeConditions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeConditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChangeConditionsType }
     * 
     * 
     */
    public List<ChangeConditionsType> getChangeConditions() {
        if (changeConditions == null) {
            changeConditions = new ArrayList<ChangeConditionsType>();
        }
        return this.changeConditions;
    }

    /**
     * Gets the value of the paymentTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTermsType }
     * 
     * 
     */
    public List<PaymentTermsType> getPaymentTerms() {
        if (paymentTerms == null) {
            paymentTerms = new ArrayList<PaymentTermsType>();
        }
        return this.paymentTerms;
    }

    /**
     * Gets the value of the deliveryTerms property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveryTerms property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveryTerms().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeliveryTermsType }
     * 
     * 
     */
    public List<DeliveryTermsType> getDeliveryTerms() {
        if (deliveryTerms == null) {
            deliveryTerms = new ArrayList<DeliveryTermsType>();
        }
        return this.deliveryTerms;
    }

    /**
     * Ruft den Wert der bonusPaymentTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getBonusPaymentTerms() {
        return bonusPaymentTerms;
    }

    /**
     * Legt den Wert der bonusPaymentTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setBonusPaymentTerms(PaymentTermsType value) {
        this.bonusPaymentTerms = value;
    }

    /**
     * Ruft den Wert der commissionPaymentTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getCommissionPaymentTerms() {
        return commissionPaymentTerms;
    }

    /**
     * Legt den Wert der commissionPaymentTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setCommissionPaymentTerms(PaymentTermsType value) {
        this.commissionPaymentTerms = value;
    }

    /**
     * Ruft den Wert der penaltyPaymentTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getPenaltyPaymentTerms() {
        return penaltyPaymentTerms;
    }

    /**
     * Legt den Wert der penaltyPaymentTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setPenaltyPaymentTerms(PaymentTermsType value) {
        this.penaltyPaymentTerms = value;
    }

    /**
     * Gets the value of the environmentalEmission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the environmentalEmission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvironmentalEmission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvironmentalEmissionType }
     * 
     * 
     */
    public List<EnvironmentalEmissionType> getEnvironmentalEmission() {
        if (environmentalEmission == null) {
            environmentalEmission = new ArrayList<EnvironmentalEmissionType>();
        }
        return this.environmentalEmission;
    }

    /**
     * Gets the value of the notificationRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notificationRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotificationRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotificationRequirementType }
     * 
     * 
     */
    public List<NotificationRequirementType> getNotificationRequirement() {
        if (notificationRequirement == null) {
            notificationRequirement = new ArrayList<NotificationRequirementType>();
        }
        return this.notificationRequirement;
    }

    /**
     * Ruft den Wert der serviceChargePaymentTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTermsType }
     *     
     */
    public PaymentTermsType getServiceChargePaymentTerms() {
        return serviceChargePaymentTerms;
    }

    /**
     * Legt den Wert der serviceChargePaymentTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTermsType }
     *     
     */
    public void setServiceChargePaymentTerms(PaymentTermsType value) {
        this.serviceChargePaymentTerms = value;
    }

}
