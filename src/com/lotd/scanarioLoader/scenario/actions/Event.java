package com.lotd.scanarioLoader.scenario.actions;

import com.lotd.scanarioLoader.Print;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.w3c.dom.Element;

@XStreamAlias("event")
public class Event extends Action {
  String effect;

  public Event(String effect, String text) {
    this.effect = effect;
    this.text = text;
  }

  public static Action parseSpecific(Element actionElement) {
    return new Event(
        actionElement.getAttribute("effect"),
        actionElement.getTextContent());
  }

  @Override
  public void apply() {

  }

  @Override
  public void print() {
    Print.print(String.format("\tEvent | %s | %s", text, effect));
  }
}
