package com.company;

import com.company.scenario.Scenario;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ScenarioXmlParser {

  public static Scenario loadScenario(String scenarioPath) {

    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;
    try {
      builder = builderFactory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }

    Scenario scenario = null;
    try {
      assert builder != null;
      Document document = builder.parse(new FileInputStream(scenarioPath));
      Element rootElement = document.getDocumentElement();
      scenario = Scenario.parse(rootElement);

    } catch (SAXException | IOException e) {
      e.printStackTrace();
    }
    return scenario;
  }

  public static ArrayList<Element> getChildrenElements(Node parentNode) {
    return getChildrenElements(parentNode, 1);
  }

  public static ArrayList<Element> getChildrenElements(Node parentNode, float ratio) {
    ArrayList<Element> resultElements = new ArrayList<>();
    NodeList childNodes = parentNode.getChildNodes();
    for (int i = 0; i < childNodes.getLength() * ratio; i++) {
      Node childNode = childNodes.item(i);
      if (childNode instanceof Element childElement) {
          resultElements.add(childElement);
      }
    }
    return resultElements;
  }

  public static String getInnerXML(Node node) {
    DOMImplementationLS lsImpl = (DOMImplementationLS)node.getOwnerDocument().getImplementation().getFeature("LS", "3.0");
    LSSerializer lsSerializer = lsImpl.createLSSerializer();
    lsSerializer.getDomConfig().setParameter("xml-declaration", false);
      return lsSerializer.writeToString(node);
  }
}
