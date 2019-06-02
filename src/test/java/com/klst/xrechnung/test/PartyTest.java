package com.klst.xrechnung.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.klst.cius.IContact;
import com.klst.ubl.Address;
import com.klst.ubl.Contact;
import com.klst.ubl.Delivery;
import com.klst.ubl.Invoice;
import com.klst.ubl.Party;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;

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
	
	@Before 
    public void setup() {
    	UblInvoiceFactory factory = new CreateUblXXXInvoice(UBL_XML[5]);
    	invoice = factory.getTestDoc();
    	supplierparty = null;
		supplierParty = invoice.getAccountingSupplierParty();
		if(supplierParty!=null) {
			supplierparty = new Party(supplierParty.getParty());
			LOG.info("party.neme(0):"+ (supplierparty.getNames().isEmpty() ? "nix" : supplierparty.getNames().get(0)) );
		}
    }

    @Test
    public void ubl0ctor() {
    	String name = "party name";
    	Address address = null;
    	Contact contact = null;
    	Party party = new Party(name, address, contact);
		assertEquals(name, party.getNames().get(0));
		assertEquals(address, party.getAddress());
		assertEquals(contact, party.getContact());
   }

    @Test
    public void ublAddName() {
    	String name = "party name";
		assertTrue(supplierparty.getNames().isEmpty());
		supplierparty.addName(name);
		assertTrue(supplierparty.getNames().size()==1);
		assertEquals(name, supplierparty.getNames().get(0));
   }

    @Test
    public void ublGetAddress() {
    	Address address = supplierparty.getAddress();
    	LOG.info(address.getCountryCode() + " " + address.getPostCode() + " " + address.getCity());
    	assertEquals("[Seller city]", address.getCity());
    }

    @Test
    public void ublGetContact() {
    	IContact contact = supplierparty.getIContact();
    	LOG.info(contact.getContactPoint() + " " + contact.getContactTelephone() + " " + contact.getContactEmail());
    	assertEquals("[Seller contact person]", contact.getContactPoint());
    }
    
    @Test
    public void ublGetNameOfDelieveryParty() {
    	List<Delivery> deliveries = invoice.getDeliveries();
		LOG.info("Deliveries #:"+ deliveries.size());
		assertTrue(deliveries.size()==1);
		Party deliveryParty = deliveries.get(0).getParty();
		assertNotNull(deliveryParty);
		List<String> names = deliveryParty.getNames();
		assertTrue(names.size()==1);
    	assertEquals("Schulungsanbieter", names.get(0));
    	
    	Address address = deliveries.get(0).getLocationAddress();
		LOG.info("Delivery LocationAddress:"+ address.getCountryCode() + " " + address.getPostCode() + " " + address.getCity());
    	assertEquals("Schulungsort", address.getCity());	
    }

}
