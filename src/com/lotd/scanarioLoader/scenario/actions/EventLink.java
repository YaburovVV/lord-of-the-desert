package com.lotd.scanarioLoader.scenario.actions;

import com.lotd.scanarioLoader.Print;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.w3c.dom.Element;

@XStreamAlias("eventLink")
public class EventLink extends Action {

  String gotoLink;
  String when;

  public EventLink(String gotoLink, String when) {
    this.gotoLink = gotoLink;
    this.when = when;
  }

  public static Action parseSpecific(Element actionElement) {
    return new EventLink(
        actionElement.getAttribute("goto"),
        actionElement.getAttribute("when"));
  }

  @Override
  public void apply() {

  }

  @Override
  public void print() {
    Print.print(String.format("\tEventLink | %s | %s", gotoLink, when));
  }
}
