package com.company.scenario.actions;

import com.company.Print;
import org.w3c.dom.Element;

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
