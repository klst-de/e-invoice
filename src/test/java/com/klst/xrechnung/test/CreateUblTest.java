package com.klst.xrechnung.test;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateUblTest {

	private static final String[] UBL_XML = {
			"ubl001.xml" ,
			"ubl002.xml" ,
			"ubl004.xml" ,
			"ubl007.xml" ,
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
	
    @Test
    public void ubl() {
    	for(int i=0; i<UBL_XML.length; i++) {
        	UblInvoiceFactory factory = new CreateUblXXXInvoice(UBL_XML[i]);
        	byte[] bytes = factory.toUbl(); // the xml
        	assertTrue(factory.check(bytes));
    	}
   }

}
