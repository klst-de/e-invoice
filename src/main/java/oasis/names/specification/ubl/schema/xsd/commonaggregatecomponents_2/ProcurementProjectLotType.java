//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;


/**
 * <p>Java-Klasse für ProcurementProjectLotType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ProcurementProjectLotType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderingTerms" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ProcurementProject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcurementProjectLotType", propOrder = {
    "id",
    "tenderingTerms",
    "procurementProject"
})
public class ProcurementProjectLotType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "TenderingTerms")
    protected TenderingTermsType tenderingTerms;
    @XmlElement(name = "ProcurementProject")
    protected ProcurementProjectType procurementProject;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der tenderingTerms-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TenderingTermsType }
     *     
     */
    public TenderingTermsType getTenderingTerms() {
        return tenderingTerms;
    }

    /**
     * Legt den Wert der tenderingTerms-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TenderingTermsType }
     *     
     */
    public void setTenderingTerms(TenderingTermsType value) {
        this.tenderingTerms = value;
    }

    /**
     * Ruft den Wert der procurementProject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProcurementProjectType }
     *     
     */
    public ProcurementProjectType getProcurementProject() {
        return procurementProject;
    }

    /**
     * Legt den Wert der procurementProject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementProjectType }
     *     
     */
    public void setProcurementProject(ProcurementProjectType value) {
        this.procurementProject = value;
    }

}
