package Readwrite;
import Algo.*; 

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.util.*;
import java.io.IOException;

import java.io.StringWriter;


import javax.xml.stream.XMLStreamException;




import java.io.FileWriter;

 
public class XMLWriter implements Iwrite {
 
    @Override
    public  void WriteFile(List<String> Cuts) {
      int size = Cuts.size();
      int index = 0;
      try {
 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
        // élément de racine
        Document doc = docBuilder.newDocument();
        Element racine = doc.createElement("decoupes");
        doc.appendChild(racine);
        while(index<size)
        {
        // l'élément decoupe
        Element decoupe = doc.createElement("decoupe");
        racine.appendChild(decoupe);
        //client element
        Element client = doc.createElement("client");
        decoupe.appendChild(client);

        // attributs de l'élément client
        Attr idc = doc.createAttribute("id");
        idc.setValue(Cuts.get(index+1));
        client.setAttributeNode(idc);
        Attr plank = doc.createAttribute("planche");
        plank.setValue(Cuts.get(index+2));
        client.setAttributeNode(plank);
 
        // Supplier
        Element supplier = doc.createElement("fournisseur");
        decoupe.appendChild(supplier);

        // Supplier attributs
        Attr ids = doc.createAttribute("id");
        ids.setValue(Cuts.get(index+4));
        supplier.setAttributeNode(ids);
        Attr panels = doc.createAttribute("panneau");
        panels.setValue(Cuts.get(index+5));
        supplier.setAttributeNode(panels);

        // position
        Element position = doc.createElement("position");
        decoupe.appendChild(position);
        // position attriubtes
        Attr posX = doc.createAttribute("x");
        posX.setValue(Cuts.get(index+7));
        position.setAttributeNode(posX);
        Attr posY = doc.createAttribute("y");
        posY.setValue(Cuts.get(index+9));
        position.setAttributeNode(posY);

        index = index + 10;
        }
 
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult resultat = new StreamResult(new File("decoupes.xml"));
 
        transformer.transform(source, resultat);
 
        System.out.println("Fichier sauvegardé avec succès!");
 
     } catch (ParserConfigurationException pce) {
         pce.printStackTrace();
     } catch (TransformerException tfe) {
         tfe.printStackTrace();
     }

  
    }
  }

