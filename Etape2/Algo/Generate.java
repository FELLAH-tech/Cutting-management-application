package Algo;
import Readwrite.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.io.FileWriter;
import java.io.IOException;
 class Generate
{
  
 static void Generate_cut(List<Client> CLientList,List<Supplier> SupplierList,List<Cut> CutList)
    {
        try {
          int cuts;
          cuts = CutList.size();
          List<List<Dimension>> listPanels = new ArrayList<>();
          List<List<Dimension>> listPlanks = new ArrayList<>();

          String[] files = new String[cuts];
          // creating names for svg files
          for(int i = 0 ;i <cuts;i++)
          {
            files[i] = "decoupe_"+Integer.toString(i)+".svg";
          }
          
          for (Supplier x : SupplierList)
          {
            User s = (Supplier)x;
            for(Cut c : CutList)
            {
              if(s.id == c.idSupplier)
              {
                for(Wood p : s.listWood)
                {
                  if((int)c.idPanel == p.id)
                  {
                    listPanels.add(p.listDim);
                  }
                }
              }
            }
          }
          // getting the inner rectangle parameteres, as in the Client Plank
          for (Client x : CLientList)
          {
            User s = (Client)x;
            for(Cut c : CutList)
            {
              if(s.id == c.idClient)
              {
                for(Wood p : s.listWood)
                {
                  if((int)c.idPlanche == p.id)
                  {
                    listPlanks.add(p.listDim);
                    

                  }
                }
              }
            }
          }

      
          
            System.out.println("======================================================================== Creating svg files");
           
             for(int i = 0; i<listPlanks.size();i++)
             {
               FileWriter myWriter = new FileWriter(files[i]);
               String heightPanel = Double.toString(listPanels.get(i).get(0).l);
               String widthPanel = Double.toString(listPanels.get(i).get(0).L);
               String widthPlank = Double.toString(listPlanks.get(i).get(0).L);
               String heightPlank = Double.toString(listPlanks.get(i).get(0).l);
               String x = Double.toString(CutList.get(i).positionX);
               String y = Double.toString(CutList.get(i).positionY);
         
               
               myWriter.write("    <svg width= " + "\"" + widthPanel + "\"" + " height=  " + "\"" + heightPanel +"\"" +"  >\n");
               myWriter.write("        <rect height= " + "\"" +heightPanel + "\"" + " width= " + "\"" +  widthPanel + "\"" + " style=\"fill:rgb(165,42,42);stroke-width:3;stroke:rgb(0,0,0)\"></rect>\n");//outer
               myWriter.write("        <rect   x= " + "\"" + x + "\"" + " y= " + "\"" + y + "\"" + " height= " + "\"" +heightPlank + "\"" + " width= " + "\"" +  widthPlank + "\"" + " style=\"fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)\"></rect>\n");//inner
               myWriter.write("    </svg>\n");
               myWriter.close();
               System.out.println("Successfully wrote to the file : " + files[i]);


            
          }
           } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
          }

    }
 
}
