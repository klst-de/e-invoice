//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidateProcessType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidateToolType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidateToolVersionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidationResultCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidationTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidatorIDType;


/**
 * <p>Java-Klasse für ResultOfVerificationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ResultOfVerificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValidatorID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValidationResultCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValidationDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValidationTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValidateProcess" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValidateTool" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValidateToolVersion" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SignatoryParty" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultOfVerificationType", propOrder = {
    "validatorID",
    "validationResultCode",
    "validationDate",
    "validationTime",
    "validateProcess",
    "validateTool",
    "validateToolVersion",
    "signatoryParty"
})
public class ResultOfVerificationType {

    @XmlElement(name = "ValidatorID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValidatorIDType validatorID;
    @XmlElement(name = "ValidationResultCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValidationResultCodeType validationResultCode;
    @XmlElement(name = "ValidationDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValidationDateType validationDate;
    @XmlElement(name = "ValidationTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValidationTimeType validationTime;
    @XmlElement(name = "ValidateProcess", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValidateProcessType validateProcess;
    @XmlElement(name = "ValidateTool", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValidateToolType validateTool;
    @XmlElement(name = "ValidateToolVersion", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValidateToolVersionType validateToolVersion;
    @XmlElement(name = "SignatoryParty")
    protected PartyType signatoryParty;

    /**
     * Ruft den Wert der validatorID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValidatorIDType }
     *     
     */
    public ValidatorIDType getValidatorID() {
        return validatorID;
    }

    /**
     * Legt den Wert der validatorID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidatorIDType }
     *     
     */
    public void setValidatorID(ValidatorIDType value) {
        this.validatorID = value;
    }

    /**
     * Ruft den Wert der validationResultCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValidationResultCodeType }
     *     
     */
    public ValidationResultCodeType getValidationResultCode() {
        return validationResultCode;
    }

    /**
     * Legt den Wert der validationResultCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationResultCodeType }
     *     
     */
    public void setValidationResultCode(ValidationResultCodeType value) {
        this.validationResultCode = value;
    }

    /**
     * Ruft den Wert der validationDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValidationDateType }
     *     
     */
    public ValidationDateType getValidationDate() {
        return validationDate;
    }

    /**
     * Legt den Wert der validationDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationDateType }
     *     
     */
    public void setValidationDate(ValidationDateType value) {
        this.validationDate = value;
    }

    /**
     * Ruft den Wert der validationTime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValidationTimeType }
     *     
     */
    public ValidationTimeType getValidationTime() {
        return validationTime;
    }

    /**
     * Legt den Wert der validationTime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationTimeType }
     *     
     */
    public void setValidationTime(ValidationTimeType value) {
        this.validationTime = value;
    }

    /**
     * Ruft den Wert der validateProcess-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValidateProcessType }
     *     
     */
    public ValidateProcessType getValidateProcess() {
        return validateProcess;
    }

    /**
     * Legt den Wert der validateProcess-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateProcessType }
     *     
     */
    public void setValidateProcess(ValidateProcessType value) {
        this.validateProcess = value;
    }

    /**
     * Ruft den Wert der validateTool-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValidateToolType }
     *     
     */
    public ValidateToolType getValidateTool() {
        return validateTool;
    }

    /**
     * Legt den Wert der validateTool-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateToolType }
     *     
     */
    public void setValidateTool(ValidateToolType value) {
        this.validateTool = value;
    }

    /**
     * Ruft den Wert der validateToolVersion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ValidateToolVersionType }
     *     
     */
    public ValidateToolVersionType getValidateToolVersion() {
        return validateToolVersion;
    }

    /**
     * Legt den Wert der validateToolVersion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidateToolVersionType }
     *     
     */
    public void setValidateToolVersion(ValidateToolVersionType value) {
        this.validateToolVersion = value;
    }

    /**
     * Ruft den Wert der signatoryParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getSignatoryParty() {
        return signatoryParty;
    }

    /**
     * Legt den Wert der signatoryParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setSignatoryParty(PartyType value) {
        this.signatoryParty = value;
    }

}
