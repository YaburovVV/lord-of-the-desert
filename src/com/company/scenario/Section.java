package com.company.scenario;

import com.company.Print;
import com.company.scenario.actions.Action;
import org.w3c.dom.Element;

import java.util.ArrayList;

import static com.company.ScenarioXmlParser.getChildrenElements;
import static com.company.ScenarioXmlParser.getTextContentWithXml;

public class Section {
  public String id;
  public String title;
  public String plot = "";
  public ArrayList<Action> actions;

  public Section(String id) {
    this.id = id;
    this.actions = new ArrayList<>();
  }

  public static Section parse(Element sectionElement) {

    Section section = new Section(sectionElement.getAttribute("id"));
    ArrayList<Element> partSecElements = getChildrenElements(sectionElement);

    partSecElements.forEach(sectionPart -> {
      switch (sectionPart.getTagName()) {
        case "p":
          section.plot += sectionPart.getTextContent() + "\n";
          break;
        case "title":
          section.title = sectionPart.getTextContent().trim();
          break;
        case "actions":
          ArrayList<Element> actionsList = getChildrenElements(sectionPart);
          actionsList.forEach(actionElement -> {
            Action act = Action.parse(actionElement);
            section.actions.add(act);
          });
      }
    });
    return section;
  }

  public void print() {
    Print.print("---\n\t" + title + "\t" + id);
    Print.print(plot);
    actions.forEach(Action::print);
  }
}
