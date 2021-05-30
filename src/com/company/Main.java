package com.company;

import com.company.scenario.Section;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;

import org.xml.sax.SAXException;


public class Main {

  public static void main(String[] args) {

    ArrayList<Section> scenario = loadScenario("game-short.xml");
    scenario.forEach(Section::print);

  }

  public static ArrayList<Section> loadScenario(String scenarioPath) {
    ArrayList<Section> scenario = new ArrayList<>();

    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;
    try {
      builder = builderFactory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }

    try {
      Document document = builder.parse(new FileInputStream(scenarioPath));
      Element rootElement = document.getDocumentElement();
      ArrayList<Element> sectionElements = getChildrenElements(rootElement, .2f);

      sectionElements.forEach(section -> {
        Section sec = new Section(section.getAttribute("id"));
        ArrayList<Element> partSecElements = getChildrenElements(section);

        partSecElements.forEach(sectionPart -> {
          switch (sectionPart.getTagName()) {
            case "p":
              sec.plot += sectionPart.getTextContent() + "\n";
              break;
            case "title":
              sec.title = sectionPart.getTextContent().trim();
              break;
            case "actions":
              ArrayList<Element> actionsList = getChildrenElements(sectionPart);
              actionsList.forEach(action -> Print.print(action.getTextContent()));
          }
        });
        scenario.add(sec);
      });
      NodeList secNodes = rootElement.getChildNodes();
    } catch (SAXException | IOException e) {
      e.printStackTrace();
    }

    return scenario;
  }

  static ArrayList<Element> getChildrenElements(Node parentNode) {
    return getChildrenElements(parentNode, 1);
  }

  static ArrayList<Element> getChildrenElements(Node parentNode, float ratio) {
    ArrayList<Element> resultElements = new ArrayList<>();
    NodeList childNodes = parentNode.getChildNodes();
    for (int i = 0; i < childNodes.getLength() * ratio; i++) {
      Node childNode = childNodes.item(i);
      if (childNode instanceof Element) {
        Element childElement = (Element) childNode;
        resultElements.add(childElement);
      }
    }
    return resultElements;
  }
}