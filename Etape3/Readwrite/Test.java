
package Readwrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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

import Readwrite.Iread;
import Readwrite.XMLReader;


public class Test
{
    public static void main(String[] args) throws FileNotFoundException,XMLStreamException {
        String file = "../clients.xml";
        XMLReader xml = new XMLReader();    
        xml.ReadFile(file);
        System.out.println(Iread.infos);

    }
}