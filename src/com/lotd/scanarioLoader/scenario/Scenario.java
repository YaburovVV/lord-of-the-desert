package com.lotd.scanarioLoader.scenario;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.w3c.dom.Element;

import java.util.ArrayList;

import static com.lotd.scanarioLoader.ScenarioXmlParser.getChildrenElements;

@XStreamAlias("scenario")
public class Scenario {

  @XStreamImplicit
  ArrayList<Paragraph> content;

  public Paragraph get(int index) {
    return content.get(index);
  }

  public Scenario() {
    content = new ArrayList<>();
  }

  public static Scenario parse(Element rootElement) {

    Scenario scenario = new Scenario();
    ArrayList<Element> sectionElements = getChildrenElements(rootElement, 1f);

    sectionElements.forEach(sectionElement -> {
      Paragraph paragraph = Paragraph.parse(sectionElement);
      scenario.content.add(paragraph);
    });
    return scenario;
  }

  public void print() {
    content.forEach(Paragraph::print);
  }
}
