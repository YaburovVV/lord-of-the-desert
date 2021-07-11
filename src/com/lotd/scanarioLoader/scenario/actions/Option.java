package com.lotd.scanarioLoader.scenario.actions;

import com.lotd.scanarioLoader.Print;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.w3c.dom.Element;

@XStreamAlias("option")
public class Option extends Action {
  String effect;

  public Option(String effect, String text) {
    this.effect = effect;
    this.text = text;
  }

  public static Action parseSpecific(Element actionElement) {
    return new Option(
        actionElement.getAttribute("effect"),
        actionElement.getTextContent());
  }

  @Override
  public void apply() {

  }

  @Override
  public void print() {
    Print.print(String.format("\tOption | %s | %s", text, effect));
  }
}
