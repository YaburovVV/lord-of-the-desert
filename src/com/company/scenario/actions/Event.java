package com.company.scenario.actions;

import com.company.Print;
import org.w3c.dom.Element;

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
