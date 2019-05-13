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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ApplicationStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CertificateTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OriginalJobIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousJobIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RemarksType;


/**
 * <p>Java-Klasse für CertificateOfOriginApplicationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CertificateOfOriginApplicationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferenceID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CertificateType"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ApplicationStatusCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OriginalJobID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousJobID" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Remarks" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Shipment"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EndorserParty" maxOccurs="unbounded"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PreparationParty"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}IssuerParty"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExporterParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ImporterParty" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}IssuingCountry"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentDistribution" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupportingDocumentReference" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Signature" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificateOfOriginApplicationType", propOrder = {
    "referenceID",
    "certificateType",
    "applicationStatusCode",
    "originalJobID",
    "previousJobID",
    "remarks",
    "shipment",
    "endorserParty",
    "preparationParty",
    "issuerParty",
    "exporterParty",
    "importerParty",
    "issuingCountry",
    "documentDistribution",
    "supportingDocumentReference",
    "signature"
})
public class CertificateOfOriginApplicationType {

    @XmlElement(name = "ReferenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ReferenceIDType referenceID;
    @XmlElement(name = "CertificateType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected CertificateTypeType certificateType;
    @XmlElement(name = "ApplicationStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ApplicationStatusCodeType applicationStatusCode;
    @XmlElement(name = "OriginalJobID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected OriginalJobIDType originalJobID;
    @XmlElement(name = "PreviousJobID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PreviousJobIDType previousJobID;
    @XmlElement(name = "Remarks", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RemarksType> remarks;
    @XmlElement(name = "Shipment", required = true)
    protected ShipmentType shipment;
    @XmlElement(name = "EndorserParty", required = true)
    protected List<EndorserPartyType> endorserParty;
    @XmlElement(name = "PreparationParty", required = true)
    protected PartyType preparationParty;
    @XmlElement(name = "IssuerParty", required = true)
    protected PartyType issuerParty;
    @XmlElement(name = "ExporterParty")
    protected PartyType exporterParty;
    @XmlElement(name = "ImporterParty")
    protected PartyType importerParty;
    @XmlElement(name = "IssuingCountry", required = true)
    protected CountryType issuingCountry;
    @XmlElement(name = "DocumentDistribution")
    protected List<DocumentDistributionType> documentDistribution;
    @XmlElement(name = "SupportingDocumentReference")
    protected List<DocumentReferenceType> supportingDocumentReference;
    @XmlElement(name = "Signature")
    protected List<SignatureType> signature;

    /**
     * Ruft den Wert der referenceID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceIDType }
     *     
     */
    public ReferenceIDType getReferenceID() {
        return referenceID;
    }

    /**
     * Legt den Wert der referenceID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceIDType }
     *     
     */
    public void setReferenceID(ReferenceIDType value) {
        this.referenceID = value;
    }

    /**
     * Ruft den Wert der certificateType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CertificateTypeType }
     *     
     */
    public CertificateTypeType getCertificateType() {
        return certificateType;
    }

    /**
     * Legt den Wert der certificateType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateTypeType }
     *     
     */
    public void setCertificateType(CertificateTypeType value) {
        this.certificateType = value;
    }

    /**
     * Ruft den Wert der applicationStatusCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationStatusCodeType }
     *     
     */
    public ApplicationStatusCodeType getApplicationStatusCode() {
        return applicationStatusCode;
    }

    /**
     * Legt den Wert der applicationStatusCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationStatusCodeType }
     *     
     */
    public void setApplicationStatusCode(ApplicationStatusCodeType value) {
        this.applicationStatusCode = value;
    }

    /**
     * Ruft den Wert der originalJobID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OriginalJobIDType }
     *     
     */
    public OriginalJobIDType getOriginalJobID() {
        return originalJobID;
    }

    /**
     * Legt den Wert der originalJobID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalJobIDType }
     *     
     */
    public void setOriginalJobID(OriginalJobIDType value) {
        this.originalJobID = value;
    }

    /**
     * Ruft den Wert der previousJobID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PreviousJobIDType }
     *     
     */
    public PreviousJobIDType getPreviousJobID() {
        return previousJobID;
    }

    /**
     * Legt den Wert der previousJobID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousJobIDType }
     *     
     */
    public void setPreviousJobID(PreviousJobIDType value) {
        this.previousJobID = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemarks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemarksType }
     * 
     * 
     */
    public List<RemarksType> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<RemarksType>();
        }
        return this.remarks;
    }

    /**
     * Ruft den Wert der shipment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ShipmentType }
     *     
     */
    public ShipmentType getShipment() {
        return shipment;
    }

    /**
     * Legt den Wert der shipment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentType }
     *     
     */
    public void setShipment(ShipmentType value) {
        this.shipment = value;
    }

    /**
     * Gets the value of the endorserParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endorserParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndorserParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EndorserPartyType }
     * 
     * 
     */
    public List<EndorserPartyType> getEndorserParty() {
        if (endorserParty == null) {
            endorserParty = new ArrayList<EndorserPartyType>();
        }
        return this.endorserParty;
    }

    /**
     * Ruft den Wert der preparationParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getPreparationParty() {
        return preparationParty;
    }

    /**
     * Legt den Wert der preparationParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setPreparationParty(PartyType value) {
        this.preparationParty = value;
    }

    /**
     * Ruft den Wert der issuerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getIssuerParty() {
        return issuerParty;
    }

    /**
     * Legt den Wert der issuerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setIssuerParty(PartyType value) {
        this.issuerParty = value;
    }

    /**
     * Ruft den Wert der exporterParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getExporterParty() {
        return exporterParty;
    }

    /**
     * Legt den Wert der exporterParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setExporterParty(PartyType value) {
        this.exporterParty = value;
    }

    /**
     * Ruft den Wert der importerParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getImporterParty() {
        return importerParty;
    }

    /**
     * Legt den Wert der importerParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setImporterParty(PartyType value) {
        this.importerParty = value;
    }

    /**
     * Ruft den Wert der issuingCountry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getIssuingCountry() {
        return issuingCountry;
    }

    /**
     * Legt den Wert der issuingCountry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setIssuingCountry(CountryType value) {
        this.issuingCountry = value;
    }

    /**
     * Gets the value of the documentDistribution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentDistribution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentDistribution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentDistributionType }
     * 
     * 
     */
    public List<DocumentDistributionType> getDocumentDistribution() {
        if (documentDistribution == null) {
            documentDistribution = new ArrayList<DocumentDistributionType>();
        }
        return this.documentDistribution;
    }

    /**
     * Gets the value of the supportingDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportingDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportingDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getSupportingDocumentReference() {
        if (supportingDocumentReference == null) {
            supportingDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.supportingDocumentReference;
    }

    /**
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignatureType }
     * 
     * 
     */
    public List<SignatureType> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureType>();
        }
        return this.signature;
    }

}
