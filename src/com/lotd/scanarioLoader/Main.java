package com.lotd.scanarioLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lotd.scanarioLoader.scenario.Scenario;


public class Main {

  public static void main(String[] args) {

    Scenario scenario = ScenarioXmlParser.loadScenario("game-short.xml");
    GsonBuilder builder = new GsonBuilder();
    builder.setPrettyPrinting().disableHtmlEscaping();
    Gson gson = builder.create();
    Print.print(gson.toJson(scenario));
//    Print scenario to console
//    scenario.print();
//    to xml

//    Print.print(new FormatSaver().toXML(scenario));
//    Print.print(new FormatSaver().toJSON(scenario));
//      Print.print(FormatSaver.readFile("Scenario.json"));
//      Scenario scenario = (Scenario) new FormatSaver().fromJson() ;
//      scenario.print();
  }
}