package com.lotd.scanarioLoader.scenario.actions;

import com.lotd.scanarioLoader.Print;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("failed")
public class Failed extends Action {

  @Override
  public void apply() {

  }

  @Override
  public void print() {
    Print.print("Failed - game over!");
  }
}
