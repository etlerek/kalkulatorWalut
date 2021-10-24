package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class WczytajURL {

    //tworzenie singletona
    static WczytajURL wczytajURL = null;
    static Waluta[] waluty = null;

    //konstruktor
    private WczytajURL() {}

    public void odswiez(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = null;
        try {
            doc = Objects.requireNonNull(db).parse(new URL("https://www.nbp.pl/kursy/xml/lasta.xml").openStream());
        }
        catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        Objects.requireNonNull(doc).getDocumentElement().normalize();

        NodeList list = doc.getElementsByTagName("pozycja");
        waluty = new Waluta[list.getLength()];

        for (int i = 0; i < list.getLength(); i++) {

            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;
                String nazwaWaluty = element.getElementsByTagName("nazwa_waluty").item(0).getTextContent();
                String przelicznik = element.getElementsByTagName("przelicznik").item(0).getTextContent();
                String kodWaluty = element.getElementsByTagName("kod_waluty").item(0).getTextContent();
                String kursSredni = element.getElementsByTagName("kurs_sredni").item(0).getTextContent();

                waluty[i] = new Waluta(i, nazwaWaluty, przelicznik, kodWaluty, kursSredni);
            }
        }
    }

    public static WczytajURL getInstance(){
        if (wczytajURL == null){
            wczytajURL = new WczytajURL();
        }
        return wczytajURL;
    }
}
