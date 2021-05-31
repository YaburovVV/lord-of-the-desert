package com.company.scenario;

import org.w3c.dom.Element;

import java.util.ArrayList;

import static com.company.ScenarioXmlParser.getChildrenElements;


public class Scenario {

  ArrayList<Section> content;

  public Scenario() {
    content = new ArrayList<>();
  }

  public static Scenario parse(Element rootElement) {

    Scenario scenario = new Scenario();
    ArrayList<Element> sectionElements = getChildrenElements(rootElement, 0.1f);

    sectionElements.forEach(sectionElement -> {
      Section section = Section.parse(sectionElement);
      scenario.content.add(section);
    });
    return scenario;
  }

  public void print() {
    content.forEach(Section::print);
  }
}
