package com.company.scenario.actions;

import com.company.Print;

public class UnrecognizedLink extends Action {
  String gotoId;

  public UnrecognizedLink(String gotoId, String text) {
    super();
    this.gotoId = gotoId;
    this.text = text;
  }

  @Override
  public void apply() {

  }

  @Override
  public void print() {
    Print.print(String.format("\tUnrecognizedLink | %s | %s",text, gotoId));
  }
}
