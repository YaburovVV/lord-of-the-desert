package com.lotd.scanarioLoader;

import com.lotd.scanarioLoader.scenario.Scenario;


public class Main {

  public static void main(String[] args) {

    Scenario scenario = ScenarioXmlParser.loadScenario("game-short.xml");
//    Print scenario to console
//    scenario.print();
//    to xml

    Print.print(FormatSaver.toXML(scenario));

  }
}