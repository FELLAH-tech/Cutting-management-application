package Algo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListCellRenderer;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import Algo.Dimension;
import Algo.Ifactory;
import Algo.Planche;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import java.lang.SuppressWarnings;

class CutsFactory implements Ifactory
{
    static List<Cut> ListCut = new ArrayList<>();
    @Override
    public void ConstructObj(List<String> ListAtt)

    {
        
        int size = ListAtt.size();
        for(int index = 0; index<size;index++)
        {
            if(ListAtt.get(index) == "decoupe")
            {
               Cut c =  new Cut(Integer.parseInt(ListAtt.get(index+2)),Integer.parseInt(ListAtt.get(index+5)),Double.parseDouble(ListAtt.get(index+3)),Double.parseDouble(ListAtt.get(index+6)),Double.parseDouble(ListAtt.get(index+8)),Double.parseDouble(ListAtt.get(index+9)));
               ListCut.add(c);
            }
        }
       
    }
}