package com.company.scenario;

import com.company.Print;
import com.company.scenario.actions.Action;

import java.util.ArrayList;

public class Section {
  public String id;
  public String title;
  public String plot = "";
  public ArrayList<Action> actions;

  public Section(String id) {
    this.id = id;
    this.actions = new ArrayList<>();
  }

  public void print() {
    Print.print("---\n\t" + title + "\t" + id);
    Print.print(plot);
    actions.forEach(action -> action.print());
  }
}
