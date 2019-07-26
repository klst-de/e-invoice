package com.klst.xrechnung.test;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.kosit.validationtool.api.Check;
import de.kosit.validationtool.api.CheckConfiguration;
import de.kosit.validationtool.api.Input;
import de.kosit.validationtool.api.InputFactory;
import de.kosit.validationtool.impl.DefaultCheck;

public class KositValidation {

	private static final Logger LOG = Logger.getLogger(KositValidation.class.getName());
	
	private static Check check = null;

	static Check getCheck() {
		if(check==null) {
	        LOG.info("startup - creating kosit validator");
	        String userDir = System.getProperty("user.dir").replace('\\', '/');
			String so = "file:"+userDir.substring(2, userDir.length())+"/src/test/kositresources/1.2.0_2018-12-19/scenarios.xml";
			URI scenarios =  URI.create(so); // so == ablsolte path
			CheckConfiguration config = new CheckConfiguration(scenarios);
			LOG.info("config.ScenarioDefinition:"+config.getScenarioDefinition() +
					"\n config.ScenarioRepository:"+config.getScenarioRepository()
					);
			check = new DefaultCheck(config);
		}
		return check;
	}
	
	// ctor
	KositValidation () {
		getCheck();
	}
	
	boolean check(byte[] xml) {
		Input xmlToCheck = InputFactory.read(xml, "test result");
		Document repDoc = check.check(xmlToCheck);

/* Auswertung ## Prüfbericht
Der Aufbau des Prüfberichts ist im entsprechenden Schema [report.xsd](configurations/xrechnung/resources/report.xsd) erläutert.
Die für die maschinelle Auswertung des Prüfberichts wesentlichsten Angaben sind

* der *Konformitätsstatus* (*valid* oder *invalid*, Attribut rep:report/@valid)
* die Empfehlung zur Annahme (*accept* - Element rep:report/rep:assessment/rep:accept) oder 
  Ablehnung (*reject* - Element rep:report/rep:assessment/rep:reject) des geprüften Dokuments.  
 */

		NodeList repReport = repDoc.getElementsByTagName("rep:report");
		NamedNodeMap repReportAttribute = repReport.item(0).getAttributes();
		String validValue = repReportAttribute.getNamedItem("valid").getNodeValue();
		LOG.info("rep:report/@valid" + "="+validValue);
		boolean ret = Boolean.TRUE.toString().equals(validValue);
		if(ret) {
			return ret; // isValid
		}
		// warum not valid?
		NodeList repReject = repDoc.getElementsByTagName("rep:reject");
		if(repReject.getLength()>0) {
			NodeList repExplanation = logNodeListAndFirstChild(repReject.item(0).getChildNodes(), "rep:explanation");
			NodeList html = logNodeListAndFirstChild(repExplanation, "html");
			NodeList body = logNodeListAndFirstChild(html, "body");
			NodeList table = logNodeListAndFindChild(body, "table", "class", "tbl-errors");
			NodeList tbody = logNodeListAndFirstChild(table, "tbody");
			NodeList tr = logNodeListAndFirstChild(tbody);
		}
		return ret;
	}
	private NodeList logNodeListAndFindChild(NodeList nodeList, String nodeName, String aName, String aValue) {
		if(nodeList==null) return null;
		NodeList childNodeList = null;
		for(int i=0; i<nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			NamedNodeMap nnm = node.getAttributes();
			LOG.info(i + ":"+ node.getNodeType() + " " + node.getNodeName() + "="+node.getNodeValue() + " Attributes:"+getAttributesAsString(nnm));
			Map<String,List<String>> map = getAttributesAsMap(nnm);
			if(nodeName.equals(node.getNodeName())) {
				List<String> aValues = map.get(aName);
				int j = aValues.indexOf(aValue);
				if(j>=0) {
					aValues.get(j);
//					LOG.info("!!!!!!!!!!!!! gefunden j="+j +" >>>"+node.getNodeName()); // davon gibt es 2! - der letzte wird genommen
					childNodeList = node.getChildNodes();
				}
			}
		}
		return childNodeList;
	}
	private NodeList logNodeListAndFirstChild(NodeList nodeList, String nodeName) {
		if(nodeList==null) return null;
		NodeList childNodeList = null;
		for(int i=0; i<nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			NamedNodeMap nnm = node.getAttributes();
			LOG.info(i + ":"+ node.getNodeType() + " " + node.getNodeName() + "="+node.getNodeValue() + "- Attributes:"+getAttributesAsString(nnm));
			if(nodeName.equals(node.getNodeName()) && childNodeList==null) {
				childNodeList = node.getChildNodes();
			}
		}
		return childNodeList;
	}
	private NodeList logNodeListAndFirstChild(NodeList nodeList) {
		if(nodeList==null) return null;
		NodeList childNodeList = null;
		for(int i=0; i<nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			NamedNodeMap nnm = node.getAttributes();
			LOG.info(i + ":"+ node.getNodeType() + " " + node.getNodeName() + "="+node.getTextContent() + "- Attributes:"+getAttributesAsString(nnm));
		}
		return childNodeList;
	}
	
	private Map<String,List<String>> getAttributesAsMap(NamedNodeMap attributeList) {
		Map<String,List<String>> maps = new HashMap<String,List<String>>();
		StringBuilder sb = new StringBuilder();
	    for (int j = 0; j < attributeList.getLength(); j++) {
	    	if(j>0) sb.append(" ");
	    	String attributeName = attributeList.item(j).getNodeName();
	    	String attributeValue = attributeList.item(j).getNodeValue();
	    	sb.append(attributeName).append("=").append(attributeValue);
	    	if(maps.get(attributeName)==null) {
	    		List<String> attribs = new ArrayList<String>();
	    		attribs.add(attributeValue);
	    		maps.put(attributeName, attribs);
	    	} else {
	    		maps.get(attributeName).add(attributeValue);
	    	}
	    }
//	    return sb.toString();
	    return maps;
	}
	/* @see https://stackoverflow.com/questions/4171380/generic-foreach-iteration-of-namednodemap
	 * Iterates through the node attribute map, else we need to specify specific 
	 * attribute values to pull and they could be of an unknown type
	 */
	private String getAttributesAsString(NamedNodeMap attributeList) {
		StringBuilder sb = new StringBuilder();
	    for (int j = 0; j < attributeList.getLength(); j++) {
	    	if("xmlns:xml".equals(attributeList.item(j).getNodeName())) {
	    		// nix
	    	} else {
		    	if(j>0) sb.append(" ");
//		    	sb.append(attributesList.item(j).getNodeType()).append("/");
		    	sb.append(attributeList.item(j).getNodeName()).append("=").append(attributeList.item(j).getNodeValue());
	    	}
	    }
	    return sb.toString();
	}

}
