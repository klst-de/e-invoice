//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalInformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BrandNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CatalogueIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousRiskIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.KeywordType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ModelNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackSizeNumericType;


/**
 * <p>Java-Klasse für ItemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PackSizeNumeric" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CatalogueIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Name" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardousRiskIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdditionalInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Keyword" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BrandName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ModelName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BuyersItemIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SellersItemIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ManufacturersItemIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}StandardItemIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CatalogueItemIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalItemIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CatalogueDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ItemSpecificationDocumentReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginCountry" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CommodityClassification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransactionConditions" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HazardousItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ClassifiedTaxCategory" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalItemProperty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ManufacturerParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}InformationContentProviderParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OriginAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ItemInstance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Certificate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Dimension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemType", propOrder = {
    "description",
    "packQuantity",
    "packSizeNumeric",
    "catalogueIndicator",
    "name",
    "hazardousRiskIndicator",
    "additionalInformation",
    "keyword",
    "brandName",
    "modelName",
    "buyersItemIdentification",
    "sellersItemIdentification",
    "manufacturersItemIdentification",
    "standardItemIdentification",
    "catalogueItemIdentification",
    "additionalItemIdentification",
    "catalogueDocumentReference",
    "itemSpecificationDocumentReference",
    "originCountry",
    "commodityClassification",
    "transactionConditions",
    "hazardousItem",
    "classifiedTaxCategory",
    "additionalItemProperty",
    "manufacturerParty",
    "informationContentProviderParty",
    "originAddress",
    "itemInstance",
    "certificate",
    "dimension"
})
public class ItemType {

    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "PackQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PackQuantityType packQuantity;
    @XmlElement(name = "PackSizeNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PackSizeNumericType packSizeNumeric;
    @XmlElement(name = "CatalogueIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CatalogueIndicatorType catalogueIndicator;
    @XmlElement(name = "Name", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NameType name;
    @XmlElement(name = "HazardousRiskIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardousRiskIndicatorType hazardousRiskIndicator;
    @XmlElement(name = "AdditionalInformation", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<AdditionalInformationType> additionalInformation;
    @XmlElement(name = "Keyword", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<KeywordType> keyword;
    @XmlElement(name = "BrandName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<BrandNameType> brandName;
    @XmlElement(name = "ModelName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ModelNameType> modelName;
    @XmlElement(name = "BuyersItemIdentification")
    protected ItemIdentificationType buyersItemIdentification;
    @XmlElement(name = "SellersItemIdentification")
    protected ItemIdentificationType sellersItemIdentification;
    @XmlElement(name = "ManufacturersItemIdentification")
    protected List<ItemIdentificationType> manufacturersItemIdentification;
    @XmlElement(name = "StandardItemIdentification")
    protected ItemIdentificationType standardItemIdentification;
    @XmlElement(name = "CatalogueItemIdentification")
    protected ItemIdentificationType catalogueItemIdentification;
    @XmlElement(name = "AdditionalItemIdentification")
    protected List<ItemIdentificationType> additionalItemIdentification;
    @XmlElement(name = "CatalogueDocumentReference")
    protected DocumentReferenceType catalogueDocumentReference;
    @XmlElement(name = "ItemSpecificationDocumentReference")
    protected List<DocumentReferenceType> itemSpecificationDocumentReference;
    @XmlElement(name = "OriginCountry")
    protected CountryType originCountry;
    @XmlElement(name = "CommodityClassification")
    protected List<CommodityClassificationType> commodityClassification;
    @XmlElement(name = "TransactionConditions")
    protected List<TransactionConditionsType> transactionConditions;
    @XmlElement(name = "HazardousItem")
    protected List<HazardousItemType> hazardousItem;
    @XmlElement(name = "ClassifiedTaxCategory")
    protected List<TaxCategoryType> classifiedTaxCategory;
    @XmlElement(name = "AdditionalItemProperty")
    protected List<ItemPropertyType> additionalItemProperty;
    @XmlElement(name = "ManufacturerParty")
    protected List<PartyType> manufacturerParty;
    @XmlElement(name = "InformationContentProviderParty")
    protected PartyType informationContentProviderParty;
    @XmlElement(name = "OriginAddress")
    protected List<AddressType> originAddress;
    @XmlElement(name = "ItemInstance")
    protected List<ItemInstanceType> itemInstance;
    @XmlElement(name = "Certificate")
    protected List<CertificateType> certificate;
    @XmlElement(name = "Dimension")
    protected List<DimensionType> dimension;

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Ruft den Wert der packQuantity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PackQuantityType }
     *     
     */
    public PackQuantityType getPackQuantity() {
        return packQuantity;
    }

    /**
     * Legt den Wert der packQuantity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PackQuantityType }
     *     
     */
    public void setPackQuantity(PackQuantityType value) {
        this.packQuantity = value;
    }

    /**
     * Ruft den Wert der packSizeNumeric-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PackSizeNumericType }
     *     
     */
    public PackSizeNumericType getPackSizeNumeric() {
        return packSizeNumeric;
    }

    /**
     * Legt den Wert der packSizeNumeric-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PackSizeNumericType }
     *     
     */
    public void setPackSizeNumeric(PackSizeNumericType value) {
        this.packSizeNumeric = value;
    }

    /**
     * Ruft den Wert der catalogueIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CatalogueIndicatorType }
     *     
     */
    public CatalogueIndicatorType getCatalogueIndicator() {
        return catalogueIndicator;
    }

    /**
     * Legt den Wert der catalogueIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CatalogueIndicatorType }
     *     
     */
    public void setCatalogueIndicator(CatalogueIndicatorType value) {
        this.catalogueIndicator = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setName(NameType value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der hazardousRiskIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public HazardousRiskIndicatorType getHazardousRiskIndicator() {
        return hazardousRiskIndicator;
    }

    /**
     * Legt den Wert der hazardousRiskIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousRiskIndicatorType }
     *     
     */
    public void setHazardousRiskIndicator(HazardousRiskIndicatorType value) {
        this.hazardousRiskIndicator = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalInformationType }
     * 
     * 
     */
    public List<AdditionalInformationType> getAdditionalInformation() {
        if (additionalInformation == null) {
            additionalInformation = new ArrayList<AdditionalInformationType>();
        }
        return this.additionalInformation;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeywordType }
     * 
     * 
     */
    public List<KeywordType> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<KeywordType>();
        }
        return this.keyword;
    }

    /**
     * Gets the value of the brandName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the brandName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBrandName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BrandNameType }
     * 
     * 
     */
    public List<BrandNameType> getBrandName() {
        if (brandName == null) {
            brandName = new ArrayList<BrandNameType>();
        }
        return this.brandName;
    }

    /**
     * Gets the value of the modelName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modelName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModelName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModelNameType }
     * 
     * 
     */
    public List<ModelNameType> getModelName() {
        if (modelName == null) {
            modelName = new ArrayList<ModelNameType>();
        }
        return this.modelName;
    }

    /**
     * Ruft den Wert der buyersItemIdentification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemIdentificationType }
     *     
     */
    public ItemIdentificationType getBuyersItemIdentification() {
        return buyersItemIdentification;
    }

    /**
     * Legt den Wert der buyersItemIdentification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemIdentificationType }
     *     
     */
    public void setBuyersItemIdentification(ItemIdentificationType value) {
        this.buyersItemIdentification = value;
    }

    /**
     * Ruft den Wert der sellersItemIdentification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemIdentificationType }
     *     
     */
    public ItemIdentificationType getSellersItemIdentification() {
        return sellersItemIdentification;
    }

    /**
     * Legt den Wert der sellersItemIdentification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemIdentificationType }
     *     
     */
    public void setSellersItemIdentification(ItemIdentificationType value) {
        this.sellersItemIdentification = value;
    }

    /**
     * Gets the value of the manufacturersItemIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manufacturersItemIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManufacturersItemIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemIdentificationType }
     * 
     * 
     */
    public List<ItemIdentificationType> getManufacturersItemIdentification() {
        if (manufacturersItemIdentification == null) {
            manufacturersItemIdentification = new ArrayList<ItemIdentificationType>();
        }
        return this.manufacturersItemIdentification;
    }

    /**
     * Ruft den Wert der standardItemIdentification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemIdentificationType }
     *     
     */
    public ItemIdentificationType getStandardItemIdentification() {
        return standardItemIdentification;
    }

    /**
     * Legt den Wert der standardItemIdentification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemIdentificationType }
     *     
     */
    public void setStandardItemIdentification(ItemIdentificationType value) {
        this.standardItemIdentification = value;
    }

    /**
     * Ruft den Wert der catalogueItemIdentification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ItemIdentificationType }
     *     
     */
    public ItemIdentificationType getCatalogueItemIdentification() {
        return catalogueItemIdentification;
    }

    /**
     * Legt den Wert der catalogueItemIdentification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemIdentificationType }
     *     
     */
    public void setCatalogueItemIdentification(ItemIdentificationType value) {
        this.catalogueItemIdentification = value;
    }

    /**
     * Gets the value of the additionalItemIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalItemIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalItemIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemIdentificationType }
     * 
     * 
     */
    public List<ItemIdentificationType> getAdditionalItemIdentification() {
        if (additionalItemIdentification == null) {
            additionalItemIdentification = new ArrayList<ItemIdentificationType>();
        }
        return this.additionalItemIdentification;
    }

    /**
     * Ruft den Wert der catalogueDocumentReference-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getCatalogueDocumentReference() {
        return catalogueDocumentReference;
    }

    /**
     * Legt den Wert der catalogueDocumentReference-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setCatalogueDocumentReference(DocumentReferenceType value) {
        this.catalogueDocumentReference = value;
    }

    /**
     * Gets the value of the itemSpecificationDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemSpecificationDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemSpecificationDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getItemSpecificationDocumentReference() {
        if (itemSpecificationDocumentReference == null) {
            itemSpecificationDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.itemSpecificationDocumentReference;
    }

    /**
     * Ruft den Wert der originCountry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getOriginCountry() {
        return originCountry;
    }

    /**
     * Legt den Wert der originCountry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setOriginCountry(CountryType value) {
        this.originCountry = value;
    }

    /**
     * Gets the value of the commodityClassification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commodityClassification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommodityClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommodityClassificationType }
     * 
     * 
     */
    public List<CommodityClassificationType> getCommodityClassification() {
        if (commodityClassification == null) {
            commodityClassification = new ArrayList<CommodityClassificationType>();
        }
        return this.commodityClassification;
    }

    /**
     * Gets the value of the transactionConditions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transactionConditions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransactionConditions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionConditionsType }
     * 
     * 
     */
    public List<TransactionConditionsType> getTransactionConditions() {
        if (transactionConditions == null) {
            transactionConditions = new ArrayList<TransactionConditionsType>();
        }
        return this.transactionConditions;
    }

    /**
     * Gets the value of the hazardousItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hazardousItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHazardousItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousItemType }
     * 
     * 
     */
    public List<HazardousItemType> getHazardousItem() {
        if (hazardousItem == null) {
            hazardousItem = new ArrayList<HazardousItemType>();
        }
        return this.hazardousItem;
    }

    /**
     * Gets the value of the classifiedTaxCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classifiedTaxCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassifiedTaxCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxCategoryType }
     * 
     * 
     */
    public List<TaxCategoryType> getClassifiedTaxCategory() {
        if (classifiedTaxCategory == null) {
            classifiedTaxCategory = new ArrayList<TaxCategoryType>();
        }
        return this.classifiedTaxCategory;
    }

    /**
     * Gets the value of the additionalItemProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalItemProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalItemProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemPropertyType }
     * 
     * 
     */
    public List<ItemPropertyType> getAdditionalItemProperty() {
        if (additionalItemProperty == null) {
            additionalItemProperty = new ArrayList<ItemPropertyType>();
        }
        return this.additionalItemProperty;
    }

    /**
     * Gets the value of the manufacturerParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the manufacturerParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getManufacturerParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyType }
     * 
     * 
     */
    public List<PartyType> getManufacturerParty() {
        if (manufacturerParty == null) {
            manufacturerParty = new ArrayList<PartyType>();
        }
        return this.manufacturerParty;
    }

    /**
     * Ruft den Wert der informationContentProviderParty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getInformationContentProviderParty() {
        return informationContentProviderParty;
    }

    /**
     * Legt den Wert der informationContentProviderParty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setInformationContentProviderParty(PartyType value) {
        this.informationContentProviderParty = value;
    }

    /**
     * Gets the value of the originAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the originAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOriginAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressType }
     * 
     * 
     */
    public List<AddressType> getOriginAddress() {
        if (originAddress == null) {
            originAddress = new ArrayList<AddressType>();
        }
        return this.originAddress;
    }

    /**
     * Gets the value of the itemInstance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemInstance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemInstance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemInstanceType }
     * 
     * 
     */
    public List<ItemInstanceType> getItemInstance() {
        if (itemInstance == null) {
            itemInstance = new ArrayList<ItemInstanceType>();
        }
        return this.itemInstance;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the certificate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCertificate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CertificateType }
     * 
     * 
     */
    public List<CertificateType> getCertificate() {
        if (certificate == null) {
            certificate = new ArrayList<CertificateType>();
        }
        return this.certificate;
    }

    /**
     * Gets the value of the dimension property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dimension property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDimension().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DimensionType }
     * 
     * 
     */
    public List<DimensionType> getDimension() {
        if (dimension == null) {
            dimension = new ArrayList<DimensionType>();
        }
        return this.dimension;
    }

}
