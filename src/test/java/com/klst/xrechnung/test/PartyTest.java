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

import com.klst.einvoice.IContact;
import com.klst.einvoice.PostalAddress;
import com.klst.einvoice.ubl.Address;
import com.klst.einvoice.ubl.Contact;
import com.klst.einvoice.ubl.Delivery;
import com.klst.einvoice.ubl.Invoice;
import com.klst.einvoice.ubl.Party;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PartyNameType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;

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

	Invoice invoice;
	private SupplierPartyType supplierParty;
	private Party supplierparty;
	private CustomerPartyType customerParty;
	private Party customerparty;
	
	static private Address testAddress;
	
    @BeforeClass
    public static void staticSetup() {
    	testAddress = new Address("CC", "9-PC", "String city", "String street");
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
		supplierParty = invoice.getAccountingSupplierParty();
		if(supplierParty!=null) {
			supplierparty = new Party(supplierParty.getParty());
			LOG.info("supplierparty.RegistrationName:"+ (supplierparty.getRegistrationName())
					+" .BusinessName:"+ (supplierparty.getBusinessName()) );
		}
		customerparty = null;
		customerParty = invoice.getAccountingCustomerParty();
		if(customerParty!=null) {
			customerparty = new Party(customerParty.getParty());
			LOG.info("customerparty.RegistrationName:"+ (customerparty.getRegistrationName()) 
					+" .BusinessName:"+ (customerparty.getBusinessName()) );
		}
    }

    @Test
    public void ubl0ctor() {
    	String name = "party name";
    	Address address = null;
    	Contact contact = null;
    	Party party = new Party(name, address, contact, null, null);
		assertEquals(name, party.getBusinessName());
		assertEquals(address, party.getAddress());
		assertEquals(contact, party.getContact());
   }

    @Test
    public void ublBusinessName() {
    	String name = "party name";
		assertTrue(supplierparty.getPartyName().isEmpty());
		supplierparty.setBusinessName(name);
		assertTrue(supplierparty.getPartyName().size()==1);
		assertEquals(name, supplierparty.getPartyName().get(0).getName().getValue());
		assertEquals(name, supplierparty.getBusinessName());
   }

    @Test
    public void ublGetAddress() {
    	PostalAddress address = supplierparty.getAddress();
    	LOG.info("address:"+address);
    	assertEquals("[Seller city]", address.getCity());
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
    	Party party = new Party("customer", null, null, null, null);
    	
    	List<Map<Object,String>> taxSchemes = party.getTaxSchemes();
    	LOG.info("TaxSchemes #:"+ taxSchemes.size());
    	assertTrue(taxSchemes.isEmpty());
    	party.setTaxRegistrationId("DE123456789");
    	LOG.info("TaxSchemes #:"+ taxSchemes.size());
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
    			" TaxSchemes #:"+supplierparty.getTaxSchemes().size());
    	assertEquals(1, supplierparty.getTaxSchemes().size());
    	List<Map<Object,String>> taxSchemes = supplierparty.getTaxSchemes();
    	assertEquals("DE123456789", taxSchemes.get(0).get(CompanyIDType.class));
    	LOG.info("supplierparty taxScheme:" + taxSchemes.get(0).get(CompanyIDType.class) + "/" + taxSchemes.get(0).get(TaxSchemeType.class));
    	supplierparty.setTaxRegistrationId("Umsatzsteuer-Identifikationsnummer des Verkäufers");
    	LOG.info("TaxSchemes #:"+supplierparty.getTaxSchemes().size());
    	LOG.info("supplierparty taxScheme:" + supplierparty.getTaxSchemes().get(1).get(CompanyIDType.class) + "/" + supplierparty.getTaxSchemes().get(1).get(TaxSchemeType.class));
  	
    	// Seller überschreiben: 
    	invoice.setSeller("sellerRegistrationName", testAddress, null, null, null); //contact, companyId, companyLegalForm);
    	LOG.info("testAddress:" + testAddress);
    	SupplierPartyType sp = invoice.getAccountingSupplierParty();
    	Party sellerparty = new Party(sp.getParty());
    	LOG.info("seller address:" + sellerparty.getAddress() + " contact:"+sellerparty.getIContact());
    	assertEquals(testAddress.getCountryCode(), sellerparty.getAddress().getCountryCode());	
    	assertNull(sellerparty.getIContact());
    	LOG.info("??????????????? invoice.getSellerTaxSchemes().size() "+invoice.getSellerTaxSchemes().size()); // Seller wurde überschrieben!
    	assertEquals(0, invoice.getSellerTaxSchemes().size());
//    	invoice.setSellerTaxCompanyId("Umsatzsteuer-Identifikationsnummer des Verkäufers");
    	invoice.getSellerParty().setTaxRegistrationId("Umsatzsteuer-Identifikationsnummer des Verkäufers");
    	taxSchemes = invoice.getSellerTaxSchemes();
    	assertEquals(1, taxSchemes.size());
    	LOG.info("seller taxScheme:" + taxSchemes.get(0).get(CompanyIDType.class) + "/" + taxSchemes.get(0).get(TaxSchemeType.class));
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
    	CustomerPartyType cp = invoice.getAccountingCustomerParty();
    	Party buyerparty = new Party(cp.getParty());
    	LOG.info("buyer address:" + buyerparty.getAddress() + " contact:"+buyerparty.getIContact());
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
