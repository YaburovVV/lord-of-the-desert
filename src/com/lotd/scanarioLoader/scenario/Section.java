package com.lotd.scanarioLoader.scenario;

import com.lotd.scanarioLoader.Print;
import com.lotd.scanarioLoader.scenario.actions.Action;
import com.lotd.scanarioLoader.scenario.actions.UnrecognizedLink;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.lotd.scanarioLoader.ScenarioXmlParser.getChildrenElements;
import static com.lotd.scanarioLoader.ScenarioXmlParser.getTextContentWithXml;

@XStreamAlias("paragraph")
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
          String plotPart = getTextContentWithXml(sectionPart);
          ArrayList<Action> acts = extractLinks(plotPart);
          section.actions.addAll(acts);
          section.plot += plotPart + "\n";
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

  public String toXML() {
    XStream xstream = new XStream(new StaxDriver());
    xstream.processAnnotations(Section.class);
    return xstream.toXML(this);
  }

  private static ArrayList<Action> extractLinks(String plotPart) {
    ArrayList<Action> actions = new ArrayList<>();
    Pattern pattern = Pattern.compile("(?:a>|\\?|\\.|\\!|^|:)([^.?:!]+?)<a l:href=\"#(\\w+)\"> <strong>(\\d+)<\\/strong> <\\/");
    Matcher matcher = pattern.matcher(plotPart);
    while (matcher.find()) {
      UnrecognizedLink link = new UnrecognizedLink(
          matcher.group(1).replaceAll("^[ (),\\-\\—\"«»]+", "").replaceAll("[ (),\\-\\—\"«»]+$", ""),
          matcher.group(2));
      actions.add(link);
    }
    return actions;
  }

  public void print() {
    Print.print("---\n\t" + title + "\t" + id);
    Print.print(plot);
    actions.forEach(Action::print);
  }
}
