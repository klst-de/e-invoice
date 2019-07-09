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

import com.klst.cius.IContact;
import com.klst.cius.PostalAddress;
import com.klst.ubl.Address;
import com.klst.ubl.Contact;
import com.klst.ubl.Delivery;
import com.klst.ubl.Invoice;
import com.klst.ubl.Party;

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
    	InvoiceFactory factory = new CreateUblXXXInvoice(UBL_XML[5]);
    	invoice = factory.getTestDoc();
    	supplierparty = null;
		supplierParty = invoice.getAccountingSupplierParty();
		if(supplierParty!=null) {
			supplierparty = new Party(supplierParty.getParty());
			LOG.info("supplierparty.name:"+ (supplierparty.getName()) );
		}
		customerparty = null;
		customerParty = invoice.getAccountingCustomerParty();
		if(customerParty!=null) {
			customerparty = new Party(customerParty.getParty());
			LOG.info("customerparty.name:"+ (customerparty.getName()) );
		}
    }

	private String addressAsString(PostalAddress address) {
		return address.getCountryCode() + " " + address.getPostCode() + " " + address.getCity();
	}
	
	private String contactAsString(IContact contact) {
		return " Contact: " + contact.getContactPoint() + " " + contact.getContactTelephone() + " " + contact.getContactEmail();
	}
	
    @Test
    public void ubl0ctor() {
    	String name = "party name";
    	Address address = null;
    	Contact contact = null;
    	Party party = new Party(name, address, contact, null, null);
		assertEquals(name, party.getName());
		assertEquals(address, party.getAddress());
		assertEquals(contact, party.getContact());
   }

//    @Test
//    public void ublAddName() {
//    	String name = "party name";
//		assertTrue(supplierparty.getNames().isEmpty());
//		supplierparty.addName(name);
//		assertTrue(supplierparty.getNames().size()==1);
//		assertEquals(name, supplierparty.getNames().get(0));
//   }

    @Test
    public void ublGetAddress() {
    	Address address = supplierparty.getAddress();
    	LOG.info(addressAsString(address));
    	assertEquals("[Seller city]", address.getCity());
    }

    @Test
    public void ublGetContact() {
    	IContact contact = supplierparty.getIContact();
    	LOG.info(contactAsString(contact));
     	assertEquals("[Seller contact person]", contact.getContactPoint());
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
    	
    	Address address = deliveries.get(0).getLocationAddress();
		LOG.info("Delivery LocationAddress:" + addressAsString(address));
    	assertEquals("Schulungsort", address.getCity());	
    }
    
    @Test
    public void ublParty0Create() {
    	Party party = new Party("customer", null, null, null, null);
    	
    	List<Map<Object,String>> taxSchemes = party.getTaxSchemes();
    	LOG.info("TaxSchemes #:"+ taxSchemes.size());
    	assertTrue(taxSchemes.isEmpty());
    	party.addPartyTaxID("DE123456789");
    	LOG.info("TaxSchemes #:"+ taxSchemes.size());
    }
    
    @Test
    public void ublParty1Seller() {
    	LOG.info("supplierparty:"+ supplierparty);
    	assertNotNull(supplierparty);
    	Address address = supplierparty.getAddress();
    	IContact contact = supplierparty.getIContact();
    	assertNotNull(address);
    	assertNotNull(contact);
    	LOG.info("supplierparty address:" + addressAsString(address) + contactAsString(contact) + 
    			" TaxSchemes #:"+supplierparty.getTaxSchemes().size());
    	assertEquals(1, supplierparty.getTaxSchemes().size());
    	List<Map<Object,String>> taxSchemes = supplierparty.getTaxSchemes();
    	assertEquals("DE123456789", taxSchemes.get(0).get(CompanyIDType.class));
    	LOG.info("supplierparty taxScheme:" + taxSchemes.get(0).get(CompanyIDType.class) + "/" + taxSchemes.get(0).get(TaxSchemeType.class));
    	supplierparty.addPartyTaxID("Umsatzsteuer-Identifikationsnummer des Verkäufers");
    	LOG.info("TaxSchemes #:"+supplierparty.getTaxSchemes().size());
    	LOG.info("supplierparty taxScheme:" + supplierparty.getTaxSchemes().get(1).get(CompanyIDType.class) + "/" + supplierparty.getTaxSchemes().get(1).get(TaxSchemeType.class));
  	
    	// Seller überschreiben: 
    	invoice.setSeller("sellerRegistrationName", testAddress, null, null, null); //contact, companyId, companyLegalForm);
    	LOG.info("testAddress:" + addressAsString(testAddress));
    	SupplierPartyType sp = invoice.getAccountingSupplierParty();
    	Party sellerparty = new Party(sp.getParty());
    	LOG.info("seller address:" + addressAsString(sellerparty.getAddress()) + " contact:"+sellerparty.getIContact());
    	assertEquals(testAddress.getCountryCode(), sellerparty.getAddress().getCountryCode());	
    	assertNull(sellerparty.getIContact());
    	LOG.info("??????????????? invoice.getSellerTaxSchemes().size() "+invoice.getSellerTaxSchemes().size()); // Seller wurde überschrieben!
    	assertEquals(0, invoice.getSellerTaxSchemes().size());
    	invoice.setSellerTaxCompanyId("Umsatzsteuer-Identifikationsnummer des Verkäufers");
    	taxSchemes = invoice.getSellerTaxSchemes();
    	assertEquals(1, taxSchemes.size());
    	LOG.info("seller taxScheme:" + taxSchemes.get(0).get(CompanyIDType.class) + "/" + taxSchemes.get(0).get(TaxSchemeType.class));
    }
    
    @Test
    public void ublParty2Buyer() {
    	LOG.info("customerparty:"+ customerparty);
    	assertNotNull(customerparty);
    	Address address = customerparty.getAddress();
    	assertNotNull(address);
    	LOG.info("customerparty address:" + addressAsString(address));
    	assertNull(customerparty.getIContact());
    	invoice.setBuyer("buyerName", testAddress, null); //contact);
    	LOG.info("testAddress:" + addressAsString(testAddress));
    	CustomerPartyType cp = invoice.getAccountingCustomerParty();
    	Party buyerparty = new Party(cp.getParty());
    	LOG.info("buyer address:" + addressAsString(buyerparty.getAddress()) + " contact:"+buyerparty.getIContact());
    	assertEquals(testAddress.getCountryCode(), buyerparty.getAddress().getCountryCode());	
    	assertNull(buyerparty.getIContact());
    }
    
    @Test
    public void ublPartyLegalEntityCustomer() {
//    	List<Map<Object,String>> partyLegalEntities = customerparty.getPartyLegalEntities();
//    	LOG.info("PartyLegalEntities #:"+ partyLegalEntities.size());
//		assertTrue(partyLegalEntities.size()==1);
//		Map<Object,String> ple = partyLegalEntities.get(0);
    	assertEquals("[Buyer name]", customerparty.getName());
    	assertNull(customerparty.getCompanyID());
    	assertNull(customerparty.getCompanyLegalForm());
    }
  
    @Test
    public void ublPartyLegalEntitySupplier() {
//    	List<Map<Object,String>> partyLegalEntities = supplierparty.getPartyLegalEntities();
//    	LOG.info("PartyLegalEntities #:"+ partyLegalEntities.size());
//		assertTrue(partyLegalEntities.size()==1);
//		Map<Object,String> ple = partyLegalEntities.get(0);
    	assertEquals("[Seller name]", supplierparty.getName());
    	assertEquals("HRB 123456", supplierparty.getCompanyID());
    	assertEquals("Sitz der Gesellschaft […], Registergericht […], Amtsgericht […]", supplierparty.getCompanyLegalForm());
    }
}
