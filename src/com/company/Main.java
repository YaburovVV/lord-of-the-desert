package com.company;

import com.company.scenario.Section;
import java.util.ArrayList;

import static com.company.ScenarioXmlParser.loadScenario;


public class Main {

  public static void main(String[] args) {

    ArrayList<Section> scenario = loadScenario("game-short.xml");
    scenario.forEach(Section::print);

  }
}