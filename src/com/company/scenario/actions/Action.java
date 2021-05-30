package com.company.scenario.actions;

import org.w3c.dom.Element;

public abstract class Action {
  public String text;

  public static Action parse(Element actionElement) {
    Action resultAction;
    switch (actionElement.getTagName()) {
      case "choseLink":
        resultAction = ChooseLink.parseSpecific(actionElement);
        break;
      case "option":
        resultAction = Option.parseSpecific(actionElement);
        break;
      case "event":
        resultAction = Event.parseSpecific(actionElement);
        break;
      default:
        resultAction = null;
    }
    return resultAction;
  }

  public abstract void apply();

  public abstract void print();
}
