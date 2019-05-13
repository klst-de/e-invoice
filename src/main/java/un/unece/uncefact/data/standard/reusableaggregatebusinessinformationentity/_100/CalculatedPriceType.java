//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.13 um 09:58:17 AM CEST 
//


package un.unece.uncefact.data.standard.reusableaggregatebusinessinformationentity._100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.AmountType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.CodeType;


/**
 * <p>Java-Klasse für CalculatedPriceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CalculatedPriceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ChargeAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RelatedAppliedAllowanceCharge" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}AppliedAllowanceChargeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalculatedPriceType", propOrder = {
    "typeCode",
    "chargeAmount",
    "relatedAppliedAllowanceCharge"
})
public class CalculatedPriceType {

    @XmlElement(name = "TypeCode")
    protected List<CodeType> typeCode;
    @XmlElement(name = "ChargeAmount")
    protected List<AmountType> chargeAmount;
    @XmlElement(name = "RelatedAppliedAllowanceCharge")
    protected List<AppliedAllowanceChargeType> relatedAppliedAllowanceCharge;

    /**
     * Gets the value of the typeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getTypeCode() {
        if (typeCode == null) {
            typeCode = new ArrayList<CodeType>();
        }
        return this.typeCode;
    }

    /**
     * Gets the value of the chargeAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chargeAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getChargeAmount() {
        if (chargeAmount == null) {
            chargeAmount = new ArrayList<AmountType>();
        }
        return this.chargeAmount;
    }

    /**
     * Gets the value of the relatedAppliedAllowanceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedAppliedAllowanceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedAppliedAllowanceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppliedAllowanceChargeType }
     * 
     * 
     */
    public List<AppliedAllowanceChargeType> getRelatedAppliedAllowanceCharge() {
        if (relatedAppliedAllowanceCharge == null) {
            relatedAppliedAllowanceCharge = new ArrayList<AppliedAllowanceChargeType>();
        }
        return this.relatedAppliedAllowanceCharge;
    }

}
