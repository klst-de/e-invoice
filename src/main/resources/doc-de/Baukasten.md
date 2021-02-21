# Baukasten (de)

Die e-order und e-invoice Schnittstelle ist modular aufgebaut.

![](../image/lego.jpg)

## Übersicht über das Interface Modell

Beispiel: Anschrift + Kontaktdaten + ...

```java
   createAddress(DE, "50600", "Köln");
   ...
   createContact(...);
   ...
   createParty("Reg.Name", "Name", postalAddress, contact);
```

Aus elementaren Komponenten wird mittels einer factory Methode eine neue Komponente gebaut.
So entstehen aus Adressen und Kontaktdaten und weiteren elementaren Daten wie Handelsname, Steuernummer, ... Geschäftspartenerobjekte für Käufer und Verkäufer:

```
   PostalAddress --- extends ---> PostalAddressFactory
         ^      <---- create -----
         |
         |
BusinessPartyAddress 
         ^
         |
         |
BG8_BuyerPostalAddress           
^
|
|       Contact <---------------> ContactFactory
|          ^
|          |
|          |
|  BusinessPartyContact
|          ^
|          |
|          |
+->BG9_BuyerContact
|
|
+->BusinessParty <---------------> BusinessPartyFactory
|
BG7_Buyer extends BusinessParty, BG8_BuyerPostalAddress, BG9_BuyerContact
```
