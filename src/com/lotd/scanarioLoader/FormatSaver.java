package com.lotd.scanarioLoader;

import com.lotd.scanarioLoader.scenario.Scenario;
import com.lotd.scanarioLoader.scenario.Section;
import com.lotd.scanarioLoader.scenario.actions.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class FormatSaver {

    XStream xstreamXml;
    XStream xstreamJson;

    public FormatSaver() {
        xstreamXml = new XStream(new StaxDriver());
        xstreamXml.processAnnotations(Section.class);
        xstreamXml.processAnnotations(Scenario.class);
        xstreamXml.processAnnotations(Section.class);
        xstreamXml.processAnnotations(ChooseLink.class);
        xstreamXml.processAnnotations(Event.class);
        xstreamXml.processAnnotations(EventLink.class);
        xstreamXml.processAnnotations(Failed.class);
        xstreamXml.processAnnotations(Monster.class);
        xstreamXml.processAnnotations(Option.class);
        xstreamXml.processAnnotations(UnrecognizedLink.class);
        xstreamJson = new XStream(new JettisonMappedXmlDriver());
        xstreamJson.processAnnotations(Section.class);
        xstreamJson.processAnnotations(Scenario.class);
        xstreamJson.processAnnotations(Section.class);
        xstreamJson.processAnnotations(ChooseLink.class);
        xstreamJson.processAnnotations(Event.class);
        xstreamJson.processAnnotations(EventLink.class);
        xstreamJson.processAnnotations(Failed.class);
        xstreamJson.processAnnotations(Monster.class);
        xstreamJson.processAnnotations(Option.class);
        xstreamJson.processAnnotations(UnrecognizedLink.class);
    }

    public String toXML(Object object, String fileName) {
        String xmlContent = xstreamXml.toXML(object);
        saveFile(xmlContent, fileName);
        return xmlContent;
    }

    public String toXML(Object object) {
        return toXML(object, "Scenario.xml");
    }

    public String toJSON(Object object, String fileName) {
        String dataJson = xstreamJson.toXML(object);
        saveFile(dataJson, fileName);
        return dataJson;
    }

    public String toJSON(Object object) {
        return toJSON(object, "Scenario.json");
    }

    public Object fromJson() {
        String json = readFile("Scenario.json");
        return xstreamJson.fromXML(json);
    }

    public void saveFile(String content, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String filename) {
        BufferedReader reader = null;
        String currentLine;
        StringBuilder text = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(filename));
            while ((currentLine = reader.readLine()) != null) {
                text.append(currentLine);
                text.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return text.toString();
    }
}
