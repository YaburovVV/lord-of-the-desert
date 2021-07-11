package com.lotd.scanarioLoader.scenario.actions;

import com.lotd.scanarioLoader.Print;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("unrecognizedLink")
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
