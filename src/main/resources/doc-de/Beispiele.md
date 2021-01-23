# Beispiele (de)

Das Einführungsbeispiel gab es bereits im [README](https://github.com/klst-de/e-invoice). Zum Verständnis Der Beispiele verweise ich auf die DIN-EN16931-1, dem "€uro invoice" Standard.

## Übersicht über das EN16931 Modell

![](../image/CoreInvoice-de.PNG)

## Beteiligte Geschäftspartner

Im [Vertriebsprozess](https://klst.gitbook.io/adempiere/usr/2.3-sales) gibt es zwei Geschäftspartner, den Verkäufer (Seller/Supplier) und den Käufer (Buyer/Customer). Jeder Partner kann im Prozess mehrere Rollen ausüben.

- der **Verkäufer** ist i.A. auch der Lieferant und der **Zahlungsempfänger**
- der **Käufer/Kunde** kann auch Empfänger der Waren oder Dienstleistungen sein

Beide Geschäftspartner sind i.A. umsatzsteuerpflichtig. Der Verkäufer darf seine Rolle an einen **Steuerbevollmächtigten** delegieren, der die Umsatzsteuer in seinem Namen ausweist und bezahlt.

Die Rolle des Zahlungsempfängers darf an einen weiteren Geschäftspartner delegiert werden ([Factoring](https://de.wikipedia.org/wiki/Factoring)).

![](../image/PartiesAndRoles.PNG)

### Die Geschäftspartner im Modell

![](../image/CoreInvoice_BP-de.PNG)

### Geschäftsregeln für Rechnungen

siehe auch [rechtliche Anforderungen an eine Rechnung](https://de.wikipedia.org/wiki/Fakturierung#Mindestanforderungen)

- BR-6: Eine Rechnung muss den Namen des Verkäufers (BT-27) enthalten.
- BR-7: Eine Rechnung muss den Namen des Käufers (BT-44) enthalten.
- BR-8: Eine Rechnung muss die Postanschrift des Verkäufers (BG-5) enthalten.
- BR-9: Eine Postanschrift des Verkäufers (BG-5) muss einen Ländercode der Verkäuferanschrift (BT-40) enthalten.
- BR-10: Eine Rechnung muss die Postanschrift des Käufers (BG-8) enthalten.
- BR-11: Die Postanschrift des Käufers muss einen Ländercode der Käuferanschrift (BT-55) enthalten.

### Beispiel Verkäufer und Käufer

Das folgende Beispiel definiert den Verkäufer und den Käufer und damit erfüllt es die ersten vier Regeln. Auch BR-11 ist erfüllt. Nicht jedoch BR-10, in der Adresse der Käufers fehlt die "Straße aka address line 1":

```java
  static final String DE = "DE";  // country code 
...
	// BusinessParty Seller aka Supplier
	PostalAddress sellerAddress = ublInvoice.createAddress(DE, "12345", "[Seller city]");
	sellerAddress.setAddressLine1("[Seller address line 1]");
	IContact sellerContact = null;                           // (optional)
	ublInvoice.setSeller("[Seller name]", sellerAddress, sellerContact, 
		"[HRA-Eintrag]", "123/456/7890, HRA-Eintrag in […]");
		  
	// BusinessParty Buyer aka Customer 
	PostalAddress buyerAddress = ublInvoice.createAddress(DE, "12345", "[Buyer city]");
	IContact buyerContact = null;                           // (optional)
	ublInvoice.setBuyer("[Buyer name]", buyerAddress, buyerContact);
...
```

Die Adresse der Käufers ist einfach zu vervollständigen: `setAddressLine1(...)`. Auch die optionalen Kontaktdaten lassen sich einfach ergänzen:

```java
...
	String contactName = "nicht vorhanden";
	String contactTel  = "+49 1234-5678";
	String contactMail = "seller@email.de";
	IContact sellerContact = ublInvoice.createContact(contactName, contactTel, contactMail);
...
```

