//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
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
import un.unece.uncefact.data.standard.unqualifieddatatype._100.IDType;
import un.unece.uncefact.data.standard.unqualifieddatatype._100.TextType;


/**
 * <p>Java-Klasse für ReturnableAssetInstructionsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ReturnableAssetInstructionsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MaterialID" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}IDType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TermsAndConditionsDescription" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}TextType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TermsAndConditionsDescriptionCode" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="DepositValueSpecifiedAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DepositValueValiditySpecifiedPeriod" type="{urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:100}SpecifiedPeriodType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnableAssetInstructionsType", propOrder = {
    "materialID",
    "termsAndConditionsDescription",
    "termsAndConditionsDescriptionCode",
    "depositValueSpecifiedAmount",
    "depositValueValiditySpecifiedPeriod"
})
public class ReturnableAssetInstructionsType {

    @XmlElement(name = "MaterialID")
    protected List<IDType> materialID;
    @XmlElement(name = "TermsAndConditionsDescription")
    protected List<TextType> termsAndConditionsDescription;
    @XmlElement(name = "TermsAndConditionsDescriptionCode")
    protected CodeType termsAndConditionsDescriptionCode;
    @XmlElement(name = "DepositValueSpecifiedAmount")
    protected List<AmountType> depositValueSpecifiedAmount;
    @XmlElement(name = "DepositValueValiditySpecifiedPeriod")
    protected SpecifiedPeriodType depositValueValiditySpecifiedPeriod;

    /**
     * Gets the value of the materialID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the materialID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaterialID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDType }
     * 
     * 
     */
    public List<IDType> getMaterialID() {
        if (materialID == null) {
            materialID = new ArrayList<IDType>();
        }
        return this.materialID;
    }

    /**
     * Gets the value of the termsAndConditionsDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the termsAndConditionsDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTermsAndConditionsDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getTermsAndConditionsDescription() {
        if (termsAndConditionsDescription == null) {
            termsAndConditionsDescription = new ArrayList<TextType>();
        }
        return this.termsAndConditionsDescription;
    }

    /**
     * Ruft den Wert der termsAndConditionsDescriptionCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getTermsAndConditionsDescriptionCode() {
        return termsAndConditionsDescriptionCode;
    }

    /**
     * Legt den Wert der termsAndConditionsDescriptionCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setTermsAndConditionsDescriptionCode(CodeType value) {
        this.termsAndConditionsDescriptionCode = value;
    }

    /**
     * Gets the value of the depositValueSpecifiedAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the depositValueSpecifiedAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDepositValueSpecifiedAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getDepositValueSpecifiedAmount() {
        if (depositValueSpecifiedAmount == null) {
            depositValueSpecifiedAmount = new ArrayList<AmountType>();
        }
        return this.depositValueSpecifiedAmount;
    }

    /**
     * Ruft den Wert der depositValueValiditySpecifiedPeriod-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public SpecifiedPeriodType getDepositValueValiditySpecifiedPeriod() {
        return depositValueValiditySpecifiedPeriod;
    }

    /**
     * Legt den Wert der depositValueValiditySpecifiedPeriod-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecifiedPeriodType }
     *     
     */
    public void setDepositValueValiditySpecifiedPeriod(SpecifiedPeriodType value) {
        this.depositValueValiditySpecifiedPeriod = value;
    }

}
