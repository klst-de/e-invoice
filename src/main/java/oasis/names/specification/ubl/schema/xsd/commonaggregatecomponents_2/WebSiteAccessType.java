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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoginType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PasswordType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.URIType;


/**
 * <p>Java-Klasse für WebSiteAccessType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WebSiteAccessType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}URI" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Password"/>
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Login"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebSiteAccessType", propOrder = {
    "uri",
    "password",
    "login"
})
public class WebSiteAccessType {

    @XmlElement(name = "URI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected URIType uri;
    @XmlElement(name = "Password", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PasswordType password;
    @XmlElement(name = "Login", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LoginType login;

    /**
     * Ruft den Wert der uri-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link URIType }
     *     
     */
    public URIType getURI() {
        return uri;
    }

    /**
     * Legt den Wert der uri-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link URIType }
     *     
     */
    public void setURI(URIType value) {
        this.uri = value;
    }

    /**
     * Ruft den Wert der password-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PasswordType }
     *     
     */
    public PasswordType getPassword() {
        return password;
    }

    /**
     * Legt den Wert der password-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PasswordType }
     *     
     */
    public void setPassword(PasswordType value) {
        this.password = value;
    }

    /**
     * Ruft den Wert der login-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LoginType }
     *     
     */
    public LoginType getLogin() {
        return login;
    }

    /**
     * Legt den Wert der login-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginType }
     *     
     */
    public void setLogin(LoginType value) {
        this.login = value;
    }

}
