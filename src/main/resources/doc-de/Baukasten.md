# Baukasten (de)

Die e-order und e-invoice sind modular aufgebaut.

![](../image/lego.jpg)

## Übersicht über das Interface Modell

Beispiel: Anschrift

```java
   createAddress(DE, "50600", "Köln");
```

Aus elementaren Komponenten wird mittels einer factory Methode eine neue Komponente gebaut.

```
   PostalAddress --- extends ---> PostalAddressFactory
                <---- create -----
         ^
         |
         |
BusinessPartyAddress 
         ^
         |
         |
BG8_BuyerPostalAddress           


        Contact <---------------> ContactFactory
  BusinessParty <---------------> BusinessPartyFactory

BG7_Buyer extends BusinessParty, PostalAddressFactory, BG9_BuyerContact !!!!
BG8_BuyerPostalAddress extends BusinessPartyAddress
```
