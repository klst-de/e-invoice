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
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AltitudeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseUnitMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeableWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparedValueMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossTonnageMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeDegreesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeMinutesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LeadTimeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoadingLengthMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeDegreesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeMinutesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetNetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetTonnageMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostEventNotificationDurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreEventNotificationDurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceValueMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TareWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueMeasureType;


/**
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT0000013&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Measure. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A numeric value determined by measuring an object using a specified unit of measure.&#13;
 *                 &lt;/ccts:Definition&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Measure&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PropertyTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Type&lt;/ccts:PropertyTermName&gt;
 * </pre>
 * 
 *                 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;decimal&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 *             
 * 
 * <p>Java-Klasse für MeasureType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MeasureType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;restriction base="&lt;urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2&gt;MeasureType"&gt;
 *       &lt;attribute name="unitCode" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasureType")
@XmlSeeAlso({
    AltitudeMeasureType.class,
    BaseUnitMeasureType.class,
    ChargeableWeightMeasureType.class,
    ComparedValueMeasureType.class,
    DurationMeasureType.class,
    GrossTonnageMeasureType.class,
    GrossVolumeMeasureType.class,
    GrossWeightMeasureType.class,
    LatitudeDegreesMeasureType.class,
    LatitudeMinutesMeasureType.class,
    LeadTimeMeasureType.class,
    LoadingLengthMeasureType.class,
    LongitudeDegreesMeasureType.class,
    LongitudeMinutesMeasureType.class,
    MaximumMeasureType.class,
    oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeasureType.class,
    MinimumMeasureType.class,
    NetNetWeightMeasureType.class,
    NetTonnageMeasureType.class,
    NetVolumeMeasureType.class,
    NetWeightMeasureType.class,
    PostEventNotificationDurationMeasureType.class,
    PreEventNotificationDurationMeasureType.class,
    SourceValueMeasureType.class,
    TareWeightMeasureType.class,
    ValueMeasureType.class
})
public class MeasureType
    extends un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.MeasureType
{


}
