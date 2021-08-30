package com.lotd.scanarioLoader.scenario;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import org.w3c.dom.Element;
import java.util.ArrayList;
import static com.lotd.scanarioLoader.ScenarioXmlParser.getChildrenElements;

public class Scenario {

//  @SerializedName("cont")
  ArrayList<Section> content;

  @SerializedName("section")
  public Section get(int index) {
    return content.get(index);
  }

  public Scenario() {
    content = new ArrayList<>();
  }

  public static Scenario parse(Element rootElement) {

    Scenario scenario = new Scenario();
    ArrayList<Element> sectionElements = getChildrenElements(rootElement, 1f);

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
