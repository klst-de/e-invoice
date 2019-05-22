//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.05.22 um 04:29:27 PM CEST 
//


package oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BudgetYearNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CalculationSequenceNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FrozenPeriodDaysNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineCountNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineNumberNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumCopiesNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumNumberNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumPaymentInstructionsNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumNumberNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MultiplierFactorNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderIntervalDaysNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderQuantityIncrementNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackSizeNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReminderSequenceNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResidentOccupantsNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeightNumericType;


/**
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT0000014&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Numeric. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Numeric information that is assigned or is determined by calculation, counting, or&#13;
 *                     sequencing. It does not require a unit of quantity or unit of measure.&#13;
 *                 &lt;/ccts:Definition&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Numeric&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 *             
 * 
 * <p>Java-Klasse für NumericType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="NumericType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2&gt;NumericType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumericType")
@XmlSeeAlso({
    BudgetYearNumericType.class,
    CalculationSequenceNumericType.class,
    FrozenPeriodDaysNumericType.class,
    LineCountNumericType.class,
    LineNumberNumericType.class,
    MaximumCopiesNumericType.class,
    MaximumNumberNumericType.class,
    MaximumPaymentInstructionsNumericType.class,
    MinimumNumberNumericType.class,
    MultiplierFactorNumericType.class,
    OrderIntervalDaysNumericType.class,
    OrderQuantityIncrementNumericType.class,
    PackSizeNumericType.class,
    ReminderSequenceNumericType.class,
    ResidentOccupantsNumericType.class,
    SequenceNumericType.class,
    WeightNumericType.class
})
public class NumericType
    extends un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.NumericType
{


}
