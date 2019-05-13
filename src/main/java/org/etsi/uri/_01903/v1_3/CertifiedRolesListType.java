//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package org.etsi.uri._01903.v1_3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CertifiedRolesListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CertifiedRolesListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CertifiedRole" type="{http://uri.etsi.org/01903/v1.3.2#}EncapsulatedPKIDataType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertifiedRolesListType", propOrder = {
    "certifiedRole"
})
public class CertifiedRolesListType {

    @XmlElement(name = "CertifiedRole", required = true)
    protected List<EncapsulatedPKIDataType> certifiedRole;

    /**
     * Gets the value of the certifiedRole property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certifiedRole property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertifiedRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EncapsulatedPKIDataType }
     * 
     * 
     */
    public List<EncapsulatedPKIDataType> getCertifiedRole() {
        if (certifiedRole == null) {
            certifiedRole = new ArrayList<EncapsulatedPKIDataType>();
        }
        return this.certifiedRole;
    }

}
