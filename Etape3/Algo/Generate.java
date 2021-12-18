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
          
          int Supp = 0;
          int PanelId = 0;
          int PanelNumber = 0;
          
          double TotalSurfaceAvailable = 0;
          double SurfaceUsed = 0;
          double SurfaceLeft = 0;
          double PercentageUsed = 0;
          double PercentageWasted = 0;
          int PlanksUsed = 0;

          String[] files = new String[cuts];
          String[] logs = new String[cuts];

          // creating names for svg files
          for(int i = 0 ;i <cuts;i++)
          {
            files[i] = "decoupe_"+Integer.toString(i)+".svg";
          }

          for(int i = 0 ;i <cuts;i++)
          {
            logs[i] = "log_"+Integer.toString(i)+".txt";
          }
        
          for(Cut ct : CutList)
          {
            for(Client x : CLientList)
            {
              User c = (Client)x;
              if(c.id == ct.idClient)
              {
                for(Wood w : c.listWood)
                {
                  if(w.id == (int)ct.idPlanche)
                  {
                    listPlanks.add(w.listDim);
                  }
                }
              }
            }
          }

          for(Cut ct : CutList)
          {
            for(Supplier x : SupplierList)
            {
              User c = (Supplier)x;
              if(c.id == ct.idSupplier)
              {
                for(Wood w : c.listWood)
                {
                  if(w.id == (int)ct.idPanel)
                  {
                    listPanels.add(w.listDim);
                  }
                }
              }
            }
          }
          
          int index = 0;
          int index2 = 0;

          while(index < CutList.size())
          {
            SurfaceUsed = 0;
            PlanksUsed++;
            FileWriter myWriter = new FileWriter(files[index]);
            FileWriter logWriter = new FileWriter(logs[index]);
            logWriter.write("******** DATA ON ALGORITHM EFFICIENCY*************");
            logWriter.write("\n");
            logWriter.write("\n");
            String heightPanel = Double.toString(listPanels.get(index).get(0).L);
            String widthPanel = Double.toString(listPanels.get(index).get(0).l);
            TotalSurfaceAvailable = listPanels.get(index).get(0).L * listPanels.get(index).get(0).l;
             
            logWriter.write("TotalSurfaceAvailable : " + Double.toString(TotalSurfaceAvailable));
            logWriter.write("\n");


            
            Supp = CutList.get(index).idSupplier;
            PanelId = (int)CutList.get(index).idPanel;
            PanelNumber = (int)((10*CutList.get(index).idPanel))%10;


            myWriter.write("    <svg width= " + "\"" + widthPanel + "\"" + " height=  " + "\"" + heightPanel +"\"" +"  >\n");
            myWriter.write("        <rect height= " + "\"" +heightPanel + "\"" + " width= " + "\"" +  widthPanel + "\"" + " style=\"fill:rgb(165,42,42);stroke-width:3;stroke:rgb(0,0,0)\"></rect>\n");//outer
            for(Cut c : CutList)
            {
              
              if(c.idSupplier == Supp && (int)c.idPanel == PanelId && ((int)((10*c.idPanel))%10) == PanelNumber )
              {
                String widthPlank = Double.toString(listPlanks.get(index2).get(0).l);
                String heightPlank = Double.toString(listPlanks.get(index2).get(0).L);
                SurfaceUsed = SurfaceUsed + listPlanks.get(index2).get(0).l*listPlanks.get(index2).get(0).L;
                String x = Double.toString(CutList.get(index2).positionX);
                String y = Double.toString(CutList.get(index2).positionY);


                myWriter.write("        <rect   x= " + "\"" + x + "\"" + " y= " + "\"" + y + "\"" + " height= " + "\"" +heightPlank + "\"" + " width= " + "\"" +  widthPlank + "\"" + " style=\"fill:rgb(0,0,255);stroke-width:3;stroke:rgb(0,0,0)\"></rect>\n");//inner
                index2++;
                index++;
              }
              
            }
            logWriter.write("SurfaceUsed is : " + Double.toString(SurfaceUsed));
            logWriter.write("\n");
            logWriter.write("SurfaceLeft is : " + Double.toString(TotalSurfaceAvailable - SurfaceUsed));
            logWriter.write("\n");
            logWriter.write("PercentageUsed is : " + (Double.toString(SurfaceUsed*100/TotalSurfaceAvailable)) + "%");
            logWriter.write("\n");
            logWriter.write("PercentageWasted is : " + (Double.toString((TotalSurfaceAvailable - SurfaceUsed)*100/TotalSurfaceAvailable)) + "%");
            logWriter.write("\n");
            logWriter.write("\n");
            logWriter.write("******************************");
            myWriter.write("    </svg>\n");
            myWriter.close();
            logWriter.close();




          }


            
            
          } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
          }

    }
    


}
