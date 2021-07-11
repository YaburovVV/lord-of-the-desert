package com.lotd.scanarioLoader.scenario.actions;

import com.lotd.scanarioLoader.Print;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.w3c.dom.Element;

@XStreamAlias("monster")
public class Monster extends Action{

  String thoughtPower;
  String strength;

  public Monster(String thoughtPower, String strength, String text) {
    this.thoughtPower = thoughtPower;
    this.strength = strength;
    this.text = text;

  }

  public static Action parseSpecific(Element actionElement) {
    return new Monster(
        actionElement.getAttribute("thoughtPower"),
        actionElement.getAttribute("strength"),
        actionElement.getTextContent());
  }

  @Override
  public void apply() {

  }

  @Override
  public void print() {
    Print.print(String.format("\tMonster | thoughtPower %s | strength %s", thoughtPower, strength));
  }
}
