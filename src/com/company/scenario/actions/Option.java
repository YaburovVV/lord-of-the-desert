package com.company.scenario.actions;

import com.company.Print;
import org.w3c.dom.Element;

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
    Print.print(this.text + " " + this.effect);
  }
}
