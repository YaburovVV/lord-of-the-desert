package com.lotd.scanarioLoader.scenario.actions;

import com.lotd.scanarioLoader.Print;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.w3c.dom.Element;

@XStreamAlias("chooseLink")
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
    Print.print(String.format("\tChooseLink | %s | %s | %s",text, gotoId, when));
  }
}
