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


/**
 * <p>Java-Klasse für TradeSettlementHeaderMonetarySummationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TradeSettlementHeaderMonetarySummationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LineTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ChargeTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AllowanceTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TaxBasisTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TaxTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RoundingAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrandTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InformationAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalPrepaidAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalDiscountAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalAllowanceChargeAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DuePayableAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RetailValueExcludingTaxInformationAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalDepositFeeInformationAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ProductValueExcludingTobaccoTaxInformationAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TotalRetailValueInformationAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GrossLineTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NetLineTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NetIncludingTaxesLineTotalAmount" type="{urn:un:unece:uncefact:data:standard:UnqualifiedDataType:100}AmountType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TradeSettlementHeaderMonetarySummationType", propOrder = {
    "lineTotalAmount",
    "chargeTotalAmount",
    "allowanceTotalAmount",
    "taxBasisTotalAmount",
    "taxTotalAmount",
    "roundingAmount",
    "grandTotalAmount",
    "informationAmount",
    "totalPrepaidAmount",
    "totalDiscountAmount",
    "totalAllowanceChargeAmount",
    "duePayableAmount",
    "retailValueExcludingTaxInformationAmount",
    "totalDepositFeeInformationAmount",
    "productValueExcludingTobaccoTaxInformationAmount",
    "totalRetailValueInformationAmount",
    "grossLineTotalAmount",
    "netLineTotalAmount",
    "netIncludingTaxesLineTotalAmount"
})
public class TradeSettlementHeaderMonetarySummationType {

    @XmlElement(name = "LineTotalAmount")
    protected List<AmountType> lineTotalAmount;
    @XmlElement(name = "ChargeTotalAmount")
    protected List<AmountType> chargeTotalAmount;
    @XmlElement(name = "AllowanceTotalAmount")
    protected List<AmountType> allowanceTotalAmount;
    @XmlElement(name = "TaxBasisTotalAmount")
    protected List<AmountType> taxBasisTotalAmount;
    @XmlElement(name = "TaxTotalAmount")
    protected List<AmountType> taxTotalAmount;
    @XmlElement(name = "RoundingAmount")
    protected List<AmountType> roundingAmount;
    @XmlElement(name = "GrandTotalAmount")
    protected List<AmountType> grandTotalAmount;
    @XmlElement(name = "InformationAmount")
    protected List<AmountType> informationAmount;
    @XmlElement(name = "TotalPrepaidAmount")
    protected List<AmountType> totalPrepaidAmount;
    @XmlElement(name = "TotalDiscountAmount")
    protected List<AmountType> totalDiscountAmount;
    @XmlElement(name = "TotalAllowanceChargeAmount")
    protected List<AmountType> totalAllowanceChargeAmount;
    @XmlElement(name = "DuePayableAmount")
    protected List<AmountType> duePayableAmount;
    @XmlElement(name = "RetailValueExcludingTaxInformationAmount")
    protected List<AmountType> retailValueExcludingTaxInformationAmount;
    @XmlElement(name = "TotalDepositFeeInformationAmount")
    protected List<AmountType> totalDepositFeeInformationAmount;
    @XmlElement(name = "ProductValueExcludingTobaccoTaxInformationAmount")
    protected List<AmountType> productValueExcludingTobaccoTaxInformationAmount;
    @XmlElement(name = "TotalRetailValueInformationAmount")
    protected List<AmountType> totalRetailValueInformationAmount;
    @XmlElement(name = "GrossLineTotalAmount")
    protected List<AmountType> grossLineTotalAmount;
    @XmlElement(name = "NetLineTotalAmount")
    protected List<AmountType> netLineTotalAmount;
    @XmlElement(name = "NetIncludingTaxesLineTotalAmount")
    protected List<AmountType> netIncludingTaxesLineTotalAmount;

    /**
     * Gets the value of the lineTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getLineTotalAmount() {
        if (lineTotalAmount == null) {
            lineTotalAmount = new ArrayList<AmountType>();
        }
        return this.lineTotalAmount;
    }

    /**
     * Gets the value of the chargeTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chargeTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getChargeTotalAmount() {
        if (chargeTotalAmount == null) {
            chargeTotalAmount = new ArrayList<AmountType>();
        }
        return this.chargeTotalAmount;
    }

    /**
     * Gets the value of the allowanceTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allowanceTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllowanceTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getAllowanceTotalAmount() {
        if (allowanceTotalAmount == null) {
            allowanceTotalAmount = new ArrayList<AmountType>();
        }
        return this.allowanceTotalAmount;
    }

    /**
     * Gets the value of the taxBasisTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxBasisTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxBasisTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getTaxBasisTotalAmount() {
        if (taxBasisTotalAmount == null) {
            taxBasisTotalAmount = new ArrayList<AmountType>();
        }
        return this.taxBasisTotalAmount;
    }

    /**
     * Gets the value of the taxTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taxTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaxTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getTaxTotalAmount() {
        if (taxTotalAmount == null) {
            taxTotalAmount = new ArrayList<AmountType>();
        }
        return this.taxTotalAmount;
    }

    /**
     * Gets the value of the roundingAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roundingAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoundingAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getRoundingAmount() {
        if (roundingAmount == null) {
            roundingAmount = new ArrayList<AmountType>();
        }
        return this.roundingAmount;
    }

    /**
     * Gets the value of the grandTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grandTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrandTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getGrandTotalAmount() {
        if (grandTotalAmount == null) {
            grandTotalAmount = new ArrayList<AmountType>();
        }
        return this.grandTotalAmount;
    }

    /**
     * Gets the value of the informationAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the informationAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInformationAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getInformationAmount() {
        if (informationAmount == null) {
            informationAmount = new ArrayList<AmountType>();
        }
        return this.informationAmount;
    }

    /**
     * Gets the value of the totalPrepaidAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalPrepaidAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalPrepaidAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getTotalPrepaidAmount() {
        if (totalPrepaidAmount == null) {
            totalPrepaidAmount = new ArrayList<AmountType>();
        }
        return this.totalPrepaidAmount;
    }

    /**
     * Gets the value of the totalDiscountAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalDiscountAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalDiscountAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getTotalDiscountAmount() {
        if (totalDiscountAmount == null) {
            totalDiscountAmount = new ArrayList<AmountType>();
        }
        return this.totalDiscountAmount;
    }

    /**
     * Gets the value of the totalAllowanceChargeAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalAllowanceChargeAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalAllowanceChargeAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getTotalAllowanceChargeAmount() {
        if (totalAllowanceChargeAmount == null) {
            totalAllowanceChargeAmount = new ArrayList<AmountType>();
        }
        return this.totalAllowanceChargeAmount;
    }

    /**
     * Gets the value of the duePayableAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the duePayableAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDuePayableAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getDuePayableAmount() {
        if (duePayableAmount == null) {
            duePayableAmount = new ArrayList<AmountType>();
        }
        return this.duePayableAmount;
    }

    /**
     * Gets the value of the retailValueExcludingTaxInformationAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the retailValueExcludingTaxInformationAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRetailValueExcludingTaxInformationAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getRetailValueExcludingTaxInformationAmount() {
        if (retailValueExcludingTaxInformationAmount == null) {
            retailValueExcludingTaxInformationAmount = new ArrayList<AmountType>();
        }
        return this.retailValueExcludingTaxInformationAmount;
    }

    /**
     * Gets the value of the totalDepositFeeInformationAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalDepositFeeInformationAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalDepositFeeInformationAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getTotalDepositFeeInformationAmount() {
        if (totalDepositFeeInformationAmount == null) {
            totalDepositFeeInformationAmount = new ArrayList<AmountType>();
        }
        return this.totalDepositFeeInformationAmount;
    }

    /**
     * Gets the value of the productValueExcludingTobaccoTaxInformationAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productValueExcludingTobaccoTaxInformationAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductValueExcludingTobaccoTaxInformationAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getProductValueExcludingTobaccoTaxInformationAmount() {
        if (productValueExcludingTobaccoTaxInformationAmount == null) {
            productValueExcludingTobaccoTaxInformationAmount = new ArrayList<AmountType>();
        }
        return this.productValueExcludingTobaccoTaxInformationAmount;
    }

    /**
     * Gets the value of the totalRetailValueInformationAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the totalRetailValueInformationAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTotalRetailValueInformationAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getTotalRetailValueInformationAmount() {
        if (totalRetailValueInformationAmount == null) {
            totalRetailValueInformationAmount = new ArrayList<AmountType>();
        }
        return this.totalRetailValueInformationAmount;
    }

    /**
     * Gets the value of the grossLineTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grossLineTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrossLineTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getGrossLineTotalAmount() {
        if (grossLineTotalAmount == null) {
            grossLineTotalAmount = new ArrayList<AmountType>();
        }
        return this.grossLineTotalAmount;
    }

    /**
     * Gets the value of the netLineTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netLineTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetLineTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getNetLineTotalAmount() {
        if (netLineTotalAmount == null) {
            netLineTotalAmount = new ArrayList<AmountType>();
        }
        return this.netLineTotalAmount;
    }

    /**
     * Gets the value of the netIncludingTaxesLineTotalAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the netIncludingTaxesLineTotalAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetIncludingTaxesLineTotalAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getNetIncludingTaxesLineTotalAmount() {
        if (netIncludingTaxesLineTotalAmount == null) {
            netIncludingTaxesLineTotalAmount = new ArrayList<AmountType>();
        }
        return this.netIncludingTaxesLineTotalAmount;
    }

}
