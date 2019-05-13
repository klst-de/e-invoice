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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoleCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoleDescriptionType;


/**
 * <p>Java-Klasse für EconomicOperatorRoleType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="EconomicOperatorRoleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RoleCode" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RoleDescription" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EconomicOperatorRoleType", propOrder = {
    "roleCode",
    "roleDescription"
})
public class EconomicOperatorRoleType {

    @XmlElement(name = "RoleCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RoleCodeType roleCode;
    @XmlElement(name = "RoleDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RoleDescriptionType> roleDescription;

    /**
     * Ruft den Wert der roleCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RoleCodeType }
     *     
     */
    public RoleCodeType getRoleCode() {
        return roleCode;
    }

    /**
     * Legt den Wert der roleCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RoleCodeType }
     *     
     */
    public void setRoleCode(RoleCodeType value) {
        this.roleCode = value;
    }

    /**
     * Gets the value of the roleDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roleDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoleDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoleDescriptionType }
     * 
     * 
     */
    public List<RoleDescriptionType> getRoleDescription() {
        if (roleDescription == null) {
            roleDescription = new ArrayList<RoleDescriptionType>();
        }
        return this.roleDescription;
    }

}
