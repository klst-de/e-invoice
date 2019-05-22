//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package un.unece.uncefact.data.standard.crossindustryinvoice._100;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the un.unece.uncefact.data.standard.crossindustryinvoice._100 package. 
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

    private final static QName _CrossIndustryInvoice_QNAME = new QName("urn:un:unece:uncefact:data:standard:CrossIndustryInvoice:100", "CrossIndustryInvoice");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: un.unece.uncefact.data.standard.crossindustryinvoice._100
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrossIndustryInvoiceType }
     * 
     */
    public CrossIndustryInvoiceType createCrossIndustryInvoiceType() {
        return new CrossIndustryInvoiceType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrossIndustryInvoiceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrossIndustryInvoiceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:un:unece:uncefact:data:standard:CrossIndustryInvoice:100", name = "CrossIndustryInvoice")
    public JAXBElement<CrossIndustryInvoiceType> createCrossIndustryInvoice(CrossIndustryInvoiceType value) {
        return new JAXBElement<CrossIndustryInvoiceType>(_CrossIndustryInvoice_QNAME, CrossIndustryInvoiceType.class, null, value);
    }

}
