package com.klst.ubl;

import java.util.List;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;

/* Payment terms BT-20 Text 0..1 (optional)
 * Eine Textbeschreibung der Zahlungsbedingungen, die für den fälligen Zahlungsbetrag gelten 
 * (einschließlich Beschreibung möglicher Skonto- und Verzugsbedingungen). 
 * Dieses Informationselement kann mehrere Zeilen und mehrere Angaben zu Zahlungsbedingungen beinhalten.
 * 
 * Werden Informationen zur Gewährung von Skonto oder zur Berechnung von Verzugszinsen angegeben, 
 * sind sie wie folgt darzustellen: 
 * Anzugeben ist im ersten Segment „SKONTO“ oder „VERZUG“, im zweiten „TAGE=n“, im dritten „PROZENT=n“, 
 * wobei die Segmente jeweils von einer „#“ umfasst sind. 
 * Prozentzahlen sind mit Punkt getrennt von zwei Nachkommastellen anzugeben. 
 * Liegt dem zu berechnenden Betrag nicht BT-115, „fälliger Betrag“ zugrunde, 
 * sondern nur ein Teil des fälligen Betrags der Rechnung, 
 * ist der Grundwert zur Berechnung von Skonto oder Verzugszins als viertes Segment „BASISBETRAG=n“ 
 * mit dem semantischen Datentyp Amount anzugeben.
 * 
 * Beispiele mit drei Segmenten je Zeile:
#SKONTO#TAGE=14#PROZENT=2.25#
#SKONTO#TAGE=28#PROZENT=1.00#
#SKONTO#TAGE=60#PROZENT=0.00#

 * Beispiele mit vier Segmenten je Zeile 
 * (die Gewährung von Skonto bezieht sich nur auf einen Teilbetrag der Rechnung (z. B. Material) und 
 * der Grundwert zur Berechnung des Skonto muss mit angegeben werden):
#SKONTO#TAGE=14#PROZENT=2.25#BASISBETRAG=357.93#
#SKONTO#TAGE=28#PROZENT=1.00#BASISBETRAG=357.93#
#SKONTO#TAGE=60#PROZENT=0.00#BASISBETRAG=357.93#

 *
 * optional, aber wg. [BR-CO-25] doch mandatory!
 [BR-CO-25]-In case the Amount due for payment (BT-115) is positive, 
            either the Payment due date (BT-9) 
            or the Payment terms (BT-20) shall be present.
 */
/* Bsp:
 
    <cbc:Note>#SKONTO#TAGE=7#PROZENT=2.00#
#SKONTO#TAGE=14#PROZENT=1.00#
#SKONTO#TAGE=30#PROZENT=0.00#</cbc:Note>

 */
public class PaymentTerms extends PaymentTermsType {

	PaymentTerms() {
		super();
	}
	
	public PaymentTerms(PaymentTermsType paymentTerms) {
		this();
//		paymentTerms.getPaymentMeansID(); // LIST  
		super.setID(paymentTerms.getID());
		// TODO ??? alle member kopieren
		List<NoteType> myNotes = super.getNote();
		List<NoteType> notes = paymentTerms.getNote();
		notes.forEach(note -> {
			myNotes.add(note);
		});
	}
	
	public PaymentTerms(String paymentTermsNote) {
		this();
		addNote(paymentTermsNote);
	}

	List<NoteType> addNote(String paymentTermsNote) {
		List<NoteType> notes = super.getNote();
		NoteType note = new NoteType();
		note.setValue(paymentTermsNote);
		notes.add(note);
		return notes;
	}

	public String getFirstNote() {
		List<NoteType> notes = super.getNote();
		if(notes.isEmpty()) {
			return null;
		}
		return notes.get(0).getValue();
	}
}
