package com.company.scenario.actions;

import com.company.Print;
import org.w3c.dom.Element;

public class ChooseLink extends Action {
  String gotoId;
  String when;

  public ChooseLink(String gotoId, String when, String text) {
    super();
    this.gotoId = gotoId;
    this.when = when;
    this.text = text;
  }

  public static ChooseLink parseSpecific(Element actionElement) {
    return new ChooseLink(
        actionElement.getAttribute("goto"),
        actionElement.getAttribute("when"),
        actionElement.getTextContent());
  }

  @Override
  public void apply() {

  }

  @Override
  public void print() {
    Print.print(String.format("ChooseLink - %s - %s - %s",text, gotoId, when));
  }
}
