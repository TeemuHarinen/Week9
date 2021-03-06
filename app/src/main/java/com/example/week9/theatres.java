package com.example.week9;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class theatres {

    private ArrayList<theatre> theater_arraylist = new ArrayList<theatre>();



    public void readXML(){
        try {

            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");
            for (int i = 0; i < nList.getLength(); i++){
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){

                    Element element = (Element) node;
                    System.out.print("Theatre ID: ");
                    System.out.println(element.getElementsByTagName("ID").item(0).getTextContent());
                    System.out.print("Theatre Name: ");
                    System.out.println(element.getElementsByTagName("Name").item(0).getTextContent());
                    theater_arraylist.add(new theatre(element.getElementsByTagName("ID").item(0).getTextContent(), element.getElementsByTagName("Name").item(0).getTextContent()));
                }


            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e){
            e.printStackTrace();
        } finally {
            System.out.println("*******HANAA********");
        }
    }

    public ArrayList<theatre>getArray(){return theater_arraylist;}
}
