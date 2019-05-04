# e-invoice

- "e-" as [electronic invoice](https://en.wikipedia.org/wiki/Electronic_invoicing)
- "e-" as "€uro invoice" conforming to european CIUS “Core Invoice Usage Specification” 

The goal is to have a jar, which can be used to create a valid xml invoice conforming to german [XRechnung](https://de.wikipedia.org/wiki/XRechnung) or european standard [EN16931-1:2017](https://standards.cen.eu/dyn/www/f?p=204:110:0::::FSP_LANG_ID,FSP_PROJECT:25,60602&cs=17E89F8487E3C0558D35491BC876B7E8C).

The goal is not to build a validator for the xml invoice. For this use [EN-16931 - Validation artefacts](https://github.com/CenPC434/validation) or [XRechnung validator](https://github.com/itplr-kosit/validator).

### What is a CIUS?
A “Core Invoice Usage Specification” (CIUS) is a specification that provides a seller with detailed guidance, explanations and examples, as well as rules (business rules) related to the actual implementation and use of structured information elements present in the core invoice model in a specific trading situation. An instance document created following a given CIUS shall always be compliant with the European Standard EN16931-1:2017. [[peppol.eu]](https://peppol.eu/core-invoice-usage-specification-cius-use-peppol/)
