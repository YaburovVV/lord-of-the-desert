package com.company.scenario.actions;

import com.company.Print;
import org.w3c.dom.Element;

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
    Print.print(String.format("\tMonster - thoughtPower %s - strength %s", thoughtPower, strength));
  }
}
