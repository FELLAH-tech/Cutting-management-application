package Algo;


import java.util.ArrayList;
import java.util.List;
import javax.swing.ListCellRenderer;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import Algo.Dimension;
import Algo.Planche;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import java.lang.SuppressWarnings;

class SupplierFactory implements Ifactory{
    static List<Supplier> ListSupp = new ArrayList<>();

   

    @Override
    public void ConstructObj(List<String> ListAtt)
    {
        
        int size = ListAtt.size();
       

        for(int index = 0;index<size;index ++)
        {
            if(ListAtt.get(index) == "fournisseur")
            {
                
                Supplier c = ConstructSupp(index,size,ListAtt);//index containes the index of the current element
                ListSupp.add(c);

            }
            else{
                continue;
            }
        }
        
        
    }

    private Supplier ConstructSupp(int index2,int size,List<String> ListAtt)
    {
        int id;
        List<Panel> listPanel = new ArrayList<>();
        
        try{
            id = Integer.parseInt(ListAtt.get(index2+1));
        }
        catch(Exception e)
        {
            id = -99;
        }
        
        for(int index = index2+1;index<size;index++)
        {
            if(ListAtt.get(index) == "fournisseur")
             {
                 break;
             }
            if(ListAtt.get(index) == "panneau")
            {
                Panel p = ConstructPanel(index,size,ListAtt);
                listPanel.add(p);
                
            }
            else{
                continue;
            }
        }
      
        return new Supplier(id,listPanel);
    }

    private Panel ConstructPanel(int index3,int size,List<String> ListAtt)
    {
        int id;
        int nombre;
        String date;
        double price;
        List<Dimension> ListDim = new ArrayList<>();

        try{
            id = Integer.parseInt(ListAtt.get(index3+1));
        }
        catch(Exception e)
        {
            id = -99;
        }
        try{
            nombre = Integer.parseInt(ListAtt.get(index3+2));
        }
        catch(Exception e){
            nombre = -99;
        }
        try{
            date = ListAtt.get(index3+3);
        }
        catch(Exception e)
        {
            date = "not a date";
        }
        try{
            price = Double.parseDouble(ListAtt.get(index3+4));
        }
        catch(Exception e)
        {
            price = -99.00;
        }

        
        
        for(int index = index3;index<size;index++)
        {
        
            if(ListAtt.get(index) == "dim")
             {
                //  System.out.println("equals dim");
                 Dimension d = ConstructDim(index,size,ListAtt);
                 ListDim.add(d);
                 break;
             }
             else{
                 continue;
             }
        }
        return new Panel(id,nombre,date,price,ListDim);
    }
    private Dimension ConstructDim(int index,int size,List<String> ListAtt)
    {
        double L;
        double l;
        try{
            L = Double.parseDouble(ListAtt.get(index+1));
        }
        catch(Exception e){
            L = -99.00;
        }
        try{
            l = Double.parseDouble(ListAtt.get(index+2));
        }
        catch(Exception e){
            l = -99.00;
        }
        return new Dimension( L, l);
    }
    
}