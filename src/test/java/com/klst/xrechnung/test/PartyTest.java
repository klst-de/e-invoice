package com.klst.xrechnung.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.klst.einvoice.BG13_DeliveryInformation;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.BusinessPartyAddress;
import com.klst.einvoice.BusinessPartyContact;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.IContact;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.ubl.Address;
import com.klst.einvoice.ubl.Contact;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.ubl.Party;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AddressType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ContactType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PartyTest {

	private static final Logger LOG = Logger.getLogger(PartyTest.class.getName());
	
	private static final String[] UBL_XML = {
			"ubl001.xml" ,
//			"ubl002.xml" ,
//			"ubl004.xml" ,
//			"ubl007.xml" ,
//			"ubl008.xml" , TODO
			"01.01a-INVOICE_ubl.xml" ,
			"01.02a-INVOICE_ubl.xml" ,
			"01.03a-INVOICE_ubl.xml" ,
			"01.04a-INVOICE_ubl.xml" ,
			"01.05a-INVOICE_ubl.xml" ,
			"01.06a-INVOICE_ubl.xml" ,
			"01.07a-INVOICE_ubl.xml" ,
			"01.08a-INVOICE_ubl.xml" ,
			"01.09a-INVOICE_ubl.xml" ,
			"01.10a-INVOICE_ubl.xml" ,
			"01.11a-INVOICE_ubl.xml" ,
			"01.12a-INVOICE_ubl.xml" ,
			"01.13a-INVOICE_ubl.xml" ,
			"01.14a-INVOICE_ubl.xml" ,
			"01.15a-INVOICE_ubl.xml" };

	CoreInvoice invoice;
	private SupplierPartyType supplierParty;
//	private BG4_Seller supplierparty; // BG4_Seller extends BusinessParty
	private BusinessParty supplierparty;
	private CustomerPartyType customerParty;
//	private BG7_Buyer customerparty; // BG7_Buyer extends BusinessParty
	private BusinessParty customerparty;
	
	static private PostalAddress testAddress;
	
    @BeforeClass
    public static void staticSetup() {
    	testAddress = null;
    }
    
	@Before 
    public void setup() {
/*
    <cac:AccountingSupplierParty>
        <cac:Party>
            <cac:PostalAddress>
                <cbc:StreetName>[Seller address line 1]</cbc:StreetName>
                <cbc:CityName>[Seller city]</cbc:CityName>
                <cbc:PostalZone>12345</cbc:PostalZone>
                <cac:Country>
                    <cbc:IdentificationCode>DE</cbc:IdentificationCode>
                </cac:Country>
            </cac:PostalAddress>
            <cac:PartyTaxScheme>
                <cbc:CompanyID>DE123456789</cbc:CompanyID>
                <cac:TaxScheme>
                    <cbc:ID>VAT</cbc:ID>
                </cac:TaxScheme>
            </cac:PartyTaxScheme>
            <cac:PartyLegalEntity>
                <cbc:RegistrationName>[Seller name]</cbc:RegistrationName>
                <cbc:CompanyID>HRB 123456</cbc:CompanyID>
                <cbc:CompanyLegalForm>Sitz der Gesellschaft […], Registergericht […], Amtsgericht […]</cbc:CompanyLegalForm>
            </cac:PartyLegalEntity>
            <cac:Contact>
                <cbc:Name>[Seller contact person]</cbc:Name>
                <cbc:Telephone>+49 123456789</cbc:Telephone>
                <cbc:ElectronicMail>xxx@schulung.de</cbc:ElectronicMail>
            </cac:Contact>
        </cac:Party>
    </cac:AccountingSupplierParty>

 */
    	InvoiceFactory factory = new CreateUblXXXInvoice(UBL_XML[5]);
    	invoice = factory.getTestDoc();
    	supplierparty = null;
    	Object o = ((GenericInvoice)invoice).get();
		supplierParty = ((InvoiceType)o).getAccountingSupplierParty();
		if(supplierParty!=null) {
			supplierparty = invoice.getSeller();
			LOG.info("supplierparty.RegistrationName:"+ (supplierparty.getRegistrationName())
					+" .BusinessName:"+ (supplierparty.getBusinessName()) );
			testAddress = invoice.createAddress("CC", "9-PC", "String city");
			testAddress.setCountrySubdivision("subDivision"); // kein Setter für , "String street"
		}
		customerparty = null;
		customerParty = ((InvoiceType)o).getAccountingCustomerParty();
		if(customerParty!=null) {
			customerparty = invoice.getBuyer();
			LOG.info("customerparty.RegistrationName:"+ (customerparty.getRegistrationName()) 
					+" .BusinessName:"+ (customerparty.getBusinessName()) );
		}
		LOG.info("testAddress:"+ testAddress);
    }

    @Test
    public void ubl0ctor() {
    	String name = "party name";
    	Address address = null;
    	Contact contact = null;
    	invoice.setBuyer(name, address, contact);
    	BusinessParty party = invoice.getBuyer();
		assertEquals(name, party.getRegistrationName());
		assertEquals(address, ((BusinessPartyAddress)party).getAddress());
		assertEquals(contact, ((BusinessPartyContact)party).getIContact());
   }

    @Test
    public void ublBusinessName() {
    	String name = "party name";
		assertNull(supplierparty.getBusinessName());
		supplierparty.setBusinessName(name);
		assertEquals(name, supplierparty.getBusinessName());
   }

    @Test
    public void ublGetAddress() {
    	PostalAddress address = ((BusinessPartyAddress)supplierparty).getAddress();
    	LOG.info("address:"+address);
//        <cac:PostalAddress>
//        <cbc:StreetName>[Seller address line 1]</cbc:StreetName>
//        <cbc:CityName>[Seller city]</cbc:CityName>
//        <cbc:PostalZone>12345</cbc:PostalZone>
//        <cac:Country>
//            <cbc:IdentificationCode>DE</cbc:IdentificationCode>
//        </cac:Country>
//        </cac:PostalAddress>
    	assertEquals("12345", address.getPostCode());
    	assertEquals("[Seller city]", address.getCity());
    	assertEquals("[Seller address line 1]", address.getStreet());
    }

    private static final String HESSEN = "Hessen";
    @Test
    public void ublCopyAddress() {
    	PostalAddress a = ((BusinessPartyAddress)supplierparty).getAddress();
    	PostalAddress address = Address.createPostalAddress((AddressType)a);
    	assertEquals("[Seller address line 1]", address.getStreet());
    	address.setCountrySubdivision(HESSEN);
    	assertEquals(HESSEN, address.getCountrySubdivision());
    }

    @Test
    public void ublGetContact() {
    	IContact contact = ((BusinessPartyContact)supplierparty).getIContact();
    	LOG.info("supplierparty.Contact:" + contact);
//        <cbc:Name>[Seller contact person]</cbc:Name>
//        <cbc:Telephone>+49 123456789</cbc:Telephone>
//        <cbc:ElectronicMail>xxx@schulung.de</cbc:ElectronicMail>
    	assertEquals("[Seller contact person]", contact.getContactPoint());
    	assertEquals("+49 123456789", contact.getContactTelephone());
    	assertEquals("xxx@schulung.de", contact.getContactEmail());
    }
    
    @Test
    public void ublSetContact() {
    	IContact contact = ((Party)supplierparty).createContact("contactName", "contactTel", "contactMail");
    	LOG.info("contact:" + contact);
    	assertEquals("contactName", contact.getContactPoint());
    	assertEquals("contactTel", contact.getContactTelephone());
    	assertEquals("contactMail", contact.getContactEmail());
    }
    
    @Test
    public void ublCopyContact() {
    	IContact c = ((BusinessPartyContact)supplierparty).getIContact();
    	IContact contact = Contact.createIContact((ContactType)c);
    	LOG.info("contact:" + contact);
    	assertEquals("[Seller contact person]", contact.getContactPoint());
    	assertEquals("+49 123456789", contact.getContactTelephone());
    	assertEquals("xxx@schulung.de", contact.getContactEmail());
    }
    
    @Test
    public void ublGetNameOfDelieveryParty() {
    	BG13_DeliveryInformation delivery = invoice.getDelivery();
    	assertEquals("Schulungsanbieter", delivery.getName());
    	
    	PostalAddress address = delivery.getAddress();
		LOG.info("Delivery LocationAddress:" + address);
    	assertEquals("Schulungsort", address.getCity());	
    }
    
    @Test
    public void ublParty0Create() {
    	String Umsatzsteuernummer = "DE123456789";
    	PostalAddress address = invoice.createAddress("DE", "plz", "city");
    	LOG.info("Umsatzsteuernummer:"+ Umsatzsteuernummer);
    	BusinessParty party = invoice.createParty("customer", address, null);
    	assertTrue(party.getTaxRegistrationIdentifier().isEmpty());
//    	party.addTaxRegistrationId("DE123456789", "VAT"); // Umsatzsteuernummer
    	party.setVATRegistrationId("123456789");
    	party.addTaxRegistrationId("andere Steuernummer des Verkäufers", "???"); // andere Steuernummer des Verkäufers
    	assertEquals(2, party.getTaxRegistrationIdentifier().size());
    	assertEquals("DE123456789", party.getVATRegistrationId());
    	assertNull(party.getTaxRegistrationId());
    	party.addTaxRegistrationId("Fiscal number", "FC"); // andere Steuernummer des Verkäufers
    	assertEquals("Fiscal number", party.getTaxRegistrationId());
    }
    
    @Test
    public void ublParty1Seller() {
    	LOG.info("supplierparty:"+ supplierparty);
    	assertNotNull(supplierparty);
    	PostalAddress address = supplierparty.getAddress();
    	IContact contact = ((BusinessPartyContact)supplierparty).getIContact();
    	assertNotNull(address);
    	assertNotNull(contact);
    	
    	LOG.info("supplierparty address:" + address + " contact:"+contact
    		+ " TaxRegistrationId:"+supplierparty.getTaxRegistrationIdentifier().get(0)
//    			" TaxRegistrationId:"+supplierparty.getTaxRegistrationId("FC") +
    		+ " VATRegistrationId:"+supplierparty.getVATRegistrationId()
    		);
//    	assertEquals("VAT", supplierparty.getTaxRegistrationId("VAT"));
    	assertEquals("DE123456789", supplierparty.getVATRegistrationId());
    	
    	supplierparty.addTaxRegistrationId("keine Umsatzsteuer-Identifikationsnummer des Verkäufers","XXX");
    	assertEquals("DE123456789", supplierparty.getVATRegistrationId());
  	
    	// Seller überschreiben: 
    	invoice.setSeller("sellerRegistrationName", testAddress, null, null, null); //contact, companyId, companyLegalForm);
    	LOG.info("testAddress (zum überschreiben):" + testAddress);
    	BusinessParty sellerparty = invoice.getSeller();
    	LOG.info("seller address:" + ((BusinessPartyAddress)sellerparty).getAddress()
    		+ " contact:"+((BusinessPartyContact)sellerparty).getIContact());
    	assertEquals(testAddress.getCountryCode(), ((BusinessPartyAddress)sellerparty).getAddress().getCountryCode());	
    	assertNull(((BusinessPartyContact)sellerparty).getIContact());
    }
    
    @Test
    public void ublParty2Buyer() {
    	LOG.info("customerparty:"+ customerparty);
    	assertNotNull(customerparty);
    	PostalAddress address = customerparty.getAddress();
    	assertNotNull(address);
    	LOG.info("customerparty address:" + address);
    	assertNull(((BusinessPartyContact)customerparty).getIContact());
    	invoice.setBuyer("buyerName", testAddress, null); //contact);
    	LOG.info("testAddress:" + testAddress);
    	BusinessParty buyerparty = invoice.getBuyer();
    	LOG.info("testAddress:" + testAddress +", buyer address:" + buyerparty.getAddress() + " contact:"+buyerparty.getIContact());
    	assertEquals(testAddress.getCountryCode(), buyerparty.getAddress().getCountryCode());	
    	assertNull(buyerparty.getIContact());
    }
    
    @Test
    public void ublPartyLegalEntityCustomer() {
    	assertEquals("[Buyer name]", customerparty.getRegistrationName());
    	assertNull(customerparty.getCompanyId());
    	assertNull(customerparty.getCompanyLegalForm());
    }
  
    @Test
    public void ublPartyLegalEntitySupplier() {
    	assertEquals("[Seller name]", supplierparty.getRegistrationName());
    	assertEquals("HRB 123456", supplierparty.getCompanyId());
    	assertEquals("Sitz der Gesellschaft […], Registergericht […], Amtsgericht […]", supplierparty.getCompanyLegalForm());
    }
    
}
