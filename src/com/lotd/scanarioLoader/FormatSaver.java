package com.lotd.scanarioLoader;

import com.lotd.scanarioLoader.scenario.Scenario;
import com.lotd.scanarioLoader.scenario.Section;
import com.lotd.scanarioLoader.scenario.actions.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FormatSaver {

  XStream xstream;

  public FormatSaver() {
    xstream = new XStream(new StaxDriver());
    xstream.processAnnotations(Section.class);
  }

  public static String toXML(Object object) {
    XStream xstream = new XStream(new StaxDriver());
    xstream.processAnnotations(Scenario.class);
    xstream.processAnnotations(Section.class);
    xstream.processAnnotations(ChooseLink.class);
    xstream.processAnnotations(Event.class);
    xstream.processAnnotations(EventLink.class);
    xstream.processAnnotations(Failed.class);
    xstream.processAnnotations(Monster.class);
    xstream.processAnnotations(Option.class);
    xstream.processAnnotations(UnrecognizedLink.class);
    String xmlContent = xstream.toXML(object);
    BufferedWriter writer = null;
    try {
      writer = new BufferedWriter(new FileWriter("ScenarioXml.xml"));
      writer.write(xmlContent);

      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return xmlContent;
  }
}
