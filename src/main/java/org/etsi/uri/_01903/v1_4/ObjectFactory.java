//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package org.etsi.uri._01903.v1_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.etsi.uri._01903.v1_3.XAdESTimeStampType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.etsi.uri._01903.v1_4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TimeStampValidationData_QNAME = new QName("http://uri.etsi.org/01903/v1.4.1#", "TimeStampValidationData");
    private final static QName _ArchiveTimeStampV2_QNAME = new QName("http://uri.etsi.org/01903/v1.4.1#", "ArchiveTimeStampV2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.etsi.uri._01903.v1_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidationDataType }
     * 
     */
    public ValidationDataType createValidationDataType() {
        return new ValidationDataType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationDataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidationDataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://uri.etsi.org/01903/v1.4.1#", name = "TimeStampValidationData")
    public JAXBElement<ValidationDataType> createTimeStampValidationData(ValidationDataType value) {
        return new JAXBElement<ValidationDataType>(_TimeStampValidationData_QNAME, ValidationDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XAdESTimeStampType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XAdESTimeStampType }{@code >}
     */
    @XmlElementDecl(namespace = "http://uri.etsi.org/01903/v1.4.1#", name = "ArchiveTimeStampV2")
    public JAXBElement<XAdESTimeStampType> createArchiveTimeStampV2(XAdESTimeStampType value) {
        return new JAXBElement<XAdESTimeStampType>(_ArchiveTimeStampV2_QNAME, XAdESTimeStampType.class, null, value);
    }

}
