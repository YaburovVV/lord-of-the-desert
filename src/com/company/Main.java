package com.company;

import com.company.scenario.Scenario;

import static com.company.ScenarioXmlParser.loadScenario;


public class Main {

  public static void main(String[] args) {

    Scenario scenario = loadScenario("game.xml");
//    Print scenario to console
    scenario.print();
  }
}