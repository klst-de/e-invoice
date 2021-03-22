# UN/CEFACT vs UBL schemas

Compare [UN/CEFACT xml-schemas](https://unece.org/trade/uncefact/xml-schemas) with [OASIS UBL-2.1](https://docs.oasis-open.org/ubl/UBL-2.1.html), see also [CEFeInvoicingWebinar](https://ec.europa.eu/cefdigital/wiki/download/attachments/44893070/CEFeInvoicingWebinar%20v1.00.pdf).

- UBL was released in 2013 and consists of 62 main business documents defined as xml. Each document type has its unique Namespace, there is `UBL-CreditNote-2.1.xsd` or `UBL-Invoice-2.1.xsd` for example
- You can find the release date in the xsd-module:

```xml
<!--
  Library:           OASIS Universal Business Language (UBL) 2.1 OS
                     http://docs.oasis-open.org/ubl/os-UBL-2.1/
  Release Date:      04 November 2013
  Module:            xsdrt/maindoc/UBL-CreditNote-2.1.xsd
  Generated on:      2013-10-31 17:17z
  Copyright (c) OASIS Open 2013. All Rights Reserved.
-->
```

- thus UBL is **document oriented**
- UBL is part of [ebXML](https://en.wikipedia.org/wiki/EbXML), a family of frameworks developed by OASIS and UN/CEFACT
- in an [agreement between OASIS and UN/CEFACT](http://ubl.xml.org/ebXML) OASIS declared not to release further versions of UBL ...
- in _the expectation that UN/CEFACT will produce its own integrated set of XML schemas_
- the first [UN/CEFACT XML schemas](https://unece.org/trade/uncefact/xml-schemas) were document oriented as well
- and fragments of the leaves of UBL documents uses CEFACT datatypes like `Amount`- or `Percent`- Type
- the later UN/CEFACT schemas are **process oriented**, `cross industry invoice` for example, which was released 2016

```xml
<!--
Schema agency:  UNCEFACT
Schema version:  100.D16B (Decoupled Code List Schema Modules)
Schema date:      10 October 2016
...
-->
<xsd:schema xmlns:rsm="urn:un:unece:uncefact:data:standard:CrossIndustryInvoice:100" ...
```

So this is the main difference between UBL-invoice and CII:
- the process invoicing requires an `invoice document` or sometimes a `Credit note`
- in CII both documents are defineed in the same XML schema with different document types
- in UBL there are two XML schemas, which are very similar

The next difference is the target usage. In factur-x/ZUGFeRD CII can be delivered as xml or hybrid pdf invoice.

Cross Industry Invoice (CII) was the first UN/CEFACT schema derived from the process oriented Supply Chain Reference Data Model [SCRDM](https://www.unescap.org/sites/default/files/Session%202_SCRDM_UNCEFACT.pdf). In 2019 the Cross Industry Order (CIO) schema was published. Both messages has similar structure:

![](../image/CIOvsCII.PNG)

