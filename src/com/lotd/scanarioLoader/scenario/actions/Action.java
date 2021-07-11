package com.lotd.scanarioLoader.scenario.actions;

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
      case "failed":
        resultAction = new Failed();
        break;
      case "monster":
        resultAction = Monster.parseSpecific(actionElement);
        break;
      case "eventLink":
        resultAction = EventLink.parseSpecific(actionElement);
        break;
      default:
        throw new RuntimeException(String.format("Unknown action type \"%s\"!", actionElement.getTagName()));
    }
    return resultAction;
  }

  public abstract void apply();

  public abstract void print();
}
