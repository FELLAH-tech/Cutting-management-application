package Algo;


import java.util.ArrayList;
import java.util.List;
import javax.swing.ListCellRenderer;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.awt.Color;
import Algo.Dimension;
import Algo.Ifactory;
import Algo.Planche;
import Readwrite.Iread;
import Readwrite.Iwrite;
import Readwrite.XMLReader;
import Readwrite.XMLWriter;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;
import java.util.Locale;

 class Itest{

    public static void main(String[] args) {

      Iread xml = new XMLReader();
      String[] files = {"clients.xml","fournisseurs.xml"};
      Iwrite xmlWrite = new XMLWriter();
       
      Ifactory Supp = new SupplierFactory();
      Ifactory Client = new ClientFactory();
      Ifactory Cut = new CutsFactory();
      
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
          //  Generating cuts 
           GenerateCuts G = new GenerateCuts();



           G.GeneratingCuts( ClientFactory.ListClient,SupplierFactory.ListSupp);
          
           xmlWrite.WriteFile(G.Cutting);//writing cuts to XML
           Iread.infos.clear();
           xml.ReadFile("decoupes.xml");//Reading cut xml file
           Cut.ConstructObj(Iread.infos);//Constructing Cut objects


           JFrame frame = new JFrame("SVG GENERATOR");
          //  final JTextArea textArea = new JTextArea();
          //  textArea.setBounds(50, 50, 180, 20);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setSize(800, 800);
           JButton button = new JButton("Generate SVG files");
           button.setBackground(Color.RED);
           button.setForeground(Color.GREEN);
           button.setBounds(200, 200, 400, 400);
           button.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                //  textArea.setText("Done");
           Generate.Generate_cut(ClientFactory.ListClient,SupplierFactory.ListSupp,CutsFactory.ListCut);//Generating svgs

             }
           });
           frame.add(button);
          //  frame.add(textArea);
           frame.setLayout(null);
           frame.setVisible(true);
          

            
        }
}
        