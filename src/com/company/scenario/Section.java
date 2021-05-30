package com.company.scenario;

import com.company.Print;
import com.company.scenario.actions.Action;

import java.util.ArrayList;

public class Section {
  public String id;
  public String title;
  public String plot = "";
  ArrayList<Action> actions;

  public Section(String id) {
    this.id = id;
  }

  public void print() {
    Print.print("\t" + title + "\t" + id);
    Print.print(plot);
  }
}
