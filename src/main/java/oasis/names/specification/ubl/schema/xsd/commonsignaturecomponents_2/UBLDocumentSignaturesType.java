//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonsignaturecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.signatureaggregatecomponents_2.SignatureInformationType;


/**
 * <p>Java-Klasse für UBLDocumentSignaturesType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="UBLDocumentSignaturesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:SignatureAggregateComponents-2}SignatureInformation" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UBLDocumentSignaturesType", propOrder = {
    "signatureInformation"
})
public class UBLDocumentSignaturesType {

    @XmlElement(name = "SignatureInformation", namespace = "urn:oasis:names:specification:ubl:schema:xsd:SignatureAggregateComponents-2", required = true)
    protected List<SignatureInformationType> signatureInformation;

    /**
     * Gets the value of the signatureInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signatureInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignatureInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignatureInformationType }
     * 
     * 
     */
    public List<SignatureInformationType> getSignatureInformation() {
        if (signatureInformation == null) {
            signatureInformation = new ArrayList<SignatureInformationType>();
        }
        return this.signatureInformation;
    }

}
