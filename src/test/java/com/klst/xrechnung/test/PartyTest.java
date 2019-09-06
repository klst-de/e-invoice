package com.klst.xrechnung.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.klst.einvoice.BG4_Seller;
import com.klst.einvoice.BG7_Buyer;
import com.klst.einvoice.BusinessParty;
import com.klst.einvoice.CoreInvoice;
import com.klst.einvoice.IContact;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.ubl.Address;
import com.klst.einvoice.ubl.Contact;
import com.klst.einvoice.ubl.Delivery;
import com.klst.einvoice.ubl.GenericInvoice;
import com.klst.einvoice.ubl.Invoice;
import com.klst.einvoice.ubl.Party;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
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

	GenericInvoice<InvoiceType> invoice;
	private SupplierPartyType supplierParty;
	private BG4_Seller supplierparty; // BG4_Seller extends BusinessParty
	private CustomerPartyType customerParty;
	private BG7_Buyer customerparty;
	
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
		supplierParty = invoice.get().getAccountingSupplierParty();
		if(supplierParty!=null) {
			supplierparty = invoice.getSellerParty();
			LOG.info("supplierparty.RegistrationName:"+ (supplierparty.getRegistrationName())
					+" .BusinessName:"+ (supplierparty.getBusinessName()) );
			testAddress = invoice.createAddress("CC", "9-PC", "String city");
			testAddress.setCountrySubdivision("subDivision"); // kein Setter für , "String street"
		}
		customerparty = null;
		customerParty = invoice.get().getAccountingCustomerParty();
		if(customerParty!=null) {
			customerparty = invoice.getBuyerParty();
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
    	BG7_Buyer party = invoice.getBuyerParty();
		assertEquals(name, party.getRegistrationName());
		assertEquals(address, party.getAddress());
		assertEquals(contact, party.getIContact());
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
    	PostalAddress address = supplierparty.getAddress();
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
    	PostalAddress address = supplierparty.createAddress(supplierparty.getAddress()); // copy
    	assertEquals("[Seller address line 1]", address.getStreet());
    	address.setCountrySubdivision(HESSEN);
    	assertEquals(HESSEN, address.getCountrySubdivision());
    }

    @Test
    public void ublGetContact() {
    	IContact contact = supplierparty.getIContact();
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
    	IContact contact = supplierparty.createContact("contactName", "contactTel", "contactMail");
    	LOG.info("contact:" + contact);
    	assertEquals("contactName", contact.getContactPoint());
    	assertEquals("contactTel", contact.getContactTelephone());
    	assertEquals("contactMail", contact.getContactEmail());
    }
    
    @Test
    public void ublCopyContact() {
    	IContact contact = supplierparty.createContact(supplierparty.getIContact()); // copy
    	LOG.info("contact:" + contact);
    	assertEquals("[Seller contact person]", supplierparty.getIContact().getContactPoint());
    	assertEquals("+49 123456789", supplierparty.getIContact().getContactTelephone());
    	assertEquals("xxx@schulung.de", supplierparty.getIContact().getContactEmail());
    }
    
    @Test
    public void ublGetNameOfDelieveryParty() {
    	List<Delivery> deliveries = invoice.getDeliveries();
		LOG.info("Deliveries #:"+ deliveries.size());
		assertTrue(deliveries.size()==1);
		Party deliveryParty = deliveries.get(0).getParty();
		assertNotNull(deliveryParty);
		List<PartyNameType> names = deliveryParty.getPartyName();
		assertTrue(names.size()==1);
    	assertEquals("Schulungsanbieter", names.get(0).getName().getValue());
    	
    	PostalAddress address = deliveries.get(0).getAddress();
		LOG.info("Delivery LocationAddress:" + address);
    	assertEquals("Schulungsort", address.getCity());	
    }
    
    @Test
    public void ublParty0Create() {
    	BusinessParty party = invoice.createParty("customer", null, null);
    	assertNull(party.getTaxRegistrationId());
    	party.setTaxRegistrationId("DE123456789", "VAT");
    	assertNotNull(party.getTaxRegistrationId("VAT"));
    }
    
    @Test
    public void ublParty1Seller() {
    	LOG.info("supplierparty:"+ supplierparty);
    	assertNotNull(supplierparty);
    	PostalAddress address = supplierparty.getAddress();
    	IContact contact = supplierparty.getIContact();
    	assertNotNull(address);
    	assertNotNull(contact);
    	
    	LOG.info("supplierparty address:" + address + " contact:"+contact + 
    			" TaxRegistrationId:"+supplierparty.getTaxRegistrationId() +
    			" VATRegistrationId:"+supplierparty.getTaxRegistrationId("VAT")
    			);
    	assertEquals("VAT", supplierparty.getTaxRegistrationId());
    	assertEquals("DE123456789", supplierparty.getTaxRegistrationId("VAT"));
    	
    	supplierparty.setTaxRegistrationId("Umsatzsteuer-Identifikationsnummer des Verkäufers","XXX");
    	LOG.info("XXX TaxRegistrationId:"+supplierparty.getTaxRegistrationId("XXX"));
  	
    	// Seller überschreiben: 
    	invoice.setSeller("sellerRegistrationName", testAddress, null, null, null); //contact, companyId, companyLegalForm);
    	LOG.info("testAddress:" + testAddress);
//    	SupplierPartyType sp = invoice.getAccountingSupplierParty();
//    	Party sellerparty = new Party(sp.getParty());
    	BG4_Seller sellerparty = invoice.getSellerParty();
    	LOG.info("seller address:" + sellerparty.getAddress() + " contact:"+sellerparty.getIContact());
    	assertEquals(testAddress.getCountryCode(), sellerparty.getAddress().getCountryCode());	
    	assertNull(sellerparty.getIContact());
//    	LOG.info("??????????????? invoice.getSellerTaxSchemes().size() "+invoice.get().getSellerTaxSchemes().size()); // Seller wurde überschrieben!
//    	assertEquals(0, invoice.getSellerTaxSchemes().size());
//    	invoice.setSellerTaxCompanyId("Umsatzsteuer-Identifikationsnummer des Verkäufers");
//    	invoice.getSellerParty().setTaxRegistrationId("Umsatzsteuer-Identifikationsnummer des Verkäufers", "VAT");
//    	taxSchemes = invoice.getSellerTaxSchemes();
//    	assertEquals(1, taxSchemes.size());
//    	LOG.info("seller taxScheme:" + taxSchemes.get(0).get(CompanyIDType.class) + "/" + taxSchemes.get(0).get(TaxSchemeType.class));
    }
    
    @Test
    public void ublParty2Buyer() {
    	LOG.info("customerparty:"+ customerparty);
    	assertNotNull(customerparty);
    	PostalAddress address = customerparty.getAddress();
    	assertNotNull(address);
    	LOG.info("customerparty address:" + address);
    	assertNull(customerparty.getIContact());
    	invoice.setBuyer("buyerName", testAddress, null); //contact);
    	LOG.info("testAddress:" + testAddress);
    	BG7_Buyer buyerparty = (BG7_Buyer)invoice.getBuyerParty();
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
