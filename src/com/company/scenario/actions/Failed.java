package com.company.scenario.actions;

import com.company.Print;

public class Failed extends Action {

  @Override
  public void apply() {

  }

  @Override
  public void print() {
    Print.print("Failed - game over!");
  }
}
