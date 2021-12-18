package Readwrite;
import Algo.*;
import javax.swing.ListCellRenderer;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import java.lang.SuppressWarnings;


public class XMLReader implements Iread
{
  static int index = 0;
   
  @Override
    public  void ReadFile(String filename )  
  {
      
      try{
        FileInputStream file = new FileInputStream(filename);
        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(file);
      
      while(reader.hasNext())
      {
        while(reader.next() == XMLStreamConstants.START_ELEMENT)
        {
          infos.add(reader.getName().toString());
          while(index < reader.getAttributeCount())
          {

            infos.add(reader.getAttributeValue(index));
            index++;
          }
          index = 0;// reinitialsing index for next tag
        }

        }
      }
      catch (FileNotFoundException e)
          {
              e.printStackTrace();
          }
          catch (XMLStreamException e)
          {
              e.printStackTrace();
          }
      }
  }
    