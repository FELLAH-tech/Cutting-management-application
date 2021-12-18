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
import Readwrite.Iread;
import Readwrite.Iwrite;
import Readwrite.XMLReader;
import Readwrite.XMLWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import java.lang.SuppressWarnings;
import java.util.Locale;

 class Itest{

    public static void main(String[] args) {

      Iread xml = new XMLReader();
        String[] files = {"clients.xml","fournisseurs.xml"};
       Iwrite xmlWrite = new XMLWriter();
       
       

        Ifactory Supp = new SupplierFactory();
        Ifactory Client = new ClientFactory();
        // Ifactory Cut = new CutsFactory();


        
        xml.ReadFile(files[1]);



        Supp.ConstructObj(Iread.infos);

         for(Supplier u : SupplierFactory.ListSupp)
         {


          System.out.println( "Supplier with id  : " + u.id +" has : ");
          for(Wood p : u.listWood )
          {
            Panel w = (Panel)p;
            System.out.println("============PANEL===============");
            System.out.println("");
            System.out.println("Panel with id : " + w.id + " and number : "+w.nombre + " with price : " +w.price + " with date : " + w.date + " with dimensions : ");
            for(Dimension d : w.listDim)
            {
                System.out.println(" width of : " + d.l + " and length of : " + d.L);
                System.out.println("");
                System.out.println("\u001B[33m==================CHEKING ATTRIBUTES====================\u001B[0m");
                System.out.println("");


                if((w.isPrice(w.price)) && (w.isDimension(d)) && (w.isId((double)w.id)) && (w.isNumber(w.nombre) && w.isDate("dd.MM.yy",w.date,Locale.ENGLISH)))
                {
                  System.out.println("\u001B[32mCHECK OK\u001B[0m");
                  System.out.println("");
                }
                 if (w.isPrice(w.price) == false){
                  System.out.println("\u001B[31mPRICE INVALID !\u001B[0m");
                  System.out.println("");
                }
                 if(w.isDimension(d) == false){
                  System.out.println("\u001B[31mDIMENSION INVALID !\u001B[0m");
                  System.out.println("");
                }
                 if(w.isId((double)w.id)== false)
                {
                  System.out.println("\u001B[31mID INVALID !\u001B[0m");
                  System.out.println("");
                }
                 if(w.isNumber(w.nombre)== false)
                {
                  System.out.println("\u001B[31mNOMBRE INVALID !\u001B[0m");
                  System.out.println("");
                }
                if(w.isDate("dd.MM.yy",w.date,Locale.ENGLISH) == false)
                {
                  System.out.println("\u001B[31mDATE INVALID !\u001B[0m");
                  System.out.println("");
                }



              }
            }
            System.out.println("=====================================================================================");
            System.out.println("");

          }

          xml.ReadFile(files[0]);
          Client.ConstructObj(Iread.infos);


          for(Client u : ClientFactory.ListClient)
          {


             System.out.println( "Client with id  : " + u.id +" has : ");
           for(Wood p : u.listWood )
           {
             Planche w = (Planche)p;
             System.out.println("============PLANK===========");
             System.out.println("");


             System.out.println("Plank with id : " + w.id + " and number : "+w.nombre + " with price : " +w.price + " with date : " + w.date + " with dimensions : ");
             for(Dimension d : w.listDim)
             {
               System.out.println(" width of : " + d.l + " and length of : " + d.L);
               System.out.println("");
               System.out.println("\u001B[33m==================CHEKING ATTRIBUTES====================\u001B[0m");
               System.out.println("");


               if((w.isPrice(w.price)) && (w.isDimension(d)) && (w.isId((double)w.id)) &&   (w.isNumber(w.nombre) && w.isDate("dd.MM.yy",w.date,Locale.ENGLISH)))
               {
                 System.out.println("\u001B[32mCHECK OK\u001B[0m");
                 System.out.println("");
               }
                if (w.isPrice(w.price) == false){
                 System.out.println("\u001B[31mPRICE INVALID !\u001B[0m");
                 System.out.println("");
               }

                if(w.isDimension(d) == false){
                 System.out.println("\u001B[31mDIMENSION INVALID !\u001B[0m");
                 System.out.println("");
               }
                if(w.isId((double)w.id)== false)
               {
                 System.out.println("\u001B[31mID INVALID !\u001B[0m");
                 System.out.println("");
               }
                if(w.isNumber(w.nombre)== false)
               {
                 System.out.println("\u001B[31mNOMBRE INVALID !\u001B[0m");
                 System.out.println("");
               }
               if(w.isDate("dd.MM.yy",w.date,Locale.ENGLISH) == false)
               {
                 System.out.println("\u001B[31mDATE INVALID !\u001B[0m");
                 System.out.println("");
               }



               }
             }
             System.out.println("=====================================================================================");
             System.out.println("");
            
           }
          //  GenerateCuts G = new GenerateCuts();
          //  GenerateCuts31 G31 = new GenerateCuts31();
          //  G.GeneratingCuts( ClientFactory.ListClient,SupplierFactory.ListSupp);
          //  G31.GeneratingCuts31(ClientFactory.ListClient,SupplierFactory.ListSupp);
          //  System.out.println("G.cutting  " + G.Cutting);
          //  xmlWrite.WriteFile(G.Cutting);
           
          //  Iread.infos.clear();
          //  xml.ReadFile("decoupes.xml");
          //  System.out.println("cuts are : " + Iread.infos);
          //  Cut.ConstructObj(Iread.infos);
      //      for(Cut c : CutsFactory.ListCut)
      //  {
      //    System.out.println("Cut has client id " + c.idClient + " and planche id " + c.idPlanche + " fournisseurs id " + c.idSupplier + " panel id " + c.idPanel + " positions x " + c.positionX + " position y " + c.positionY);
      //  }
      // generate.generate_cut(ClientFactory.ListClient,SupplierFactory.ListSupp,CutsFactory.ListCut);

            
        }
        }
        