package Algo;
import Readwrite.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

class GenerateCuts31
{
    List<String> Cutting = new ArrayList<>(); 
    
    void GeneratingCuts31(List<Client> Listc,List<Supplier> ListSupp)
    {
        List<String> Panels = new ArrayList<>();
        List<String> Planks = new ArrayList<>(); 
   
        Planks = GetPlanks(Listc);
        Panels = GetPanels(ListSupp);

        Panels.add("end");
        Planks.add("end");

        // organising planks accoridingly

        Sorting1 sort = new Sorting1();
        List<String> Listcorg = new ArrayList<>();
        Listcorg = sort.Sorting(Planks);
        

        // creating cuts
        int indexc = 0;
        int indexf  = 0;
        boolean value = true;
        double posx = 0;
        double posy = 0;
        int sizec = Planks.size();
        int sizef = Panels.size();
        double current_l = 0;
        double current_L =0;
        double new_L = 0;
        int numberc = 1;
        int numbers = 1;
        boolean cond = true;
        int number_of_clients = Collections.frequency(Listcorg, "client");
        int number_of_generate = Collections.frequency(Listcorg, "generated");
        while( indexf<sizef && cond )
        {

            if(Panels.get(indexf) == "m") //we are on a Panel
            {
                
                while(indexc<sizec)
                {
                    if(Listcorg.get(indexc) == "m")
                    {
                        current_L = Double.parseDouble(Listcorg.get(indexc+3));
                        current_l = Double.parseDouble(Listcorg.get(indexc+4));
                    
                         
                        if(Double.parseDouble(Panels.get(indexf+3)) >=  current_L && Double.parseDouble(Panels.get(indexf+4)) >=  current_l )
                        {
                            Cutting.add("client");
                            Cutting.add(Listcorg.get(indexc+1));//adding client id
                            Cutting.add(Listcorg.get(indexc+2) + "." + Integer.toString(numberc));//plank id with number
                            Cutting.add("supplier");
                            Cutting.add(Panels.get(indexf +1));
                            Cutting.add(Panels.get(indexf + 2) + "." + Integer.toString(numbers));
                            Cutting.add("positionX");
                            Cutting.add(Double.toString(posx));
                            Cutting.add("positionY");
                            Cutting.add(Double.toString(posy));
                            posy = posy + current_L;
                            new_L = Double.parseDouble(Panels.get(indexf+3)) -  current_L;
                            Panels.set(indexf+3,Double.toString(new_L) );
                            // cond = false;
                            Listcorg.set(indexc,"generated");
                            if(number_of_clients == number_of_generate) //there are no more clients to generate there planks
                            {
                                cond = false;
                            }
                            
                            indexc++;
                        }
                        else{
                            indexc++;
                        }
                    }
                    indexc++;
                }
                numbers++;
            }
            if(Panels.get(indexf) == "n"){
                numbers = 1;
             }
            indexf++;//done with the Panel, moving on to the next one
            indexc = 0; //to reiterate over all the ugenerated Planks
            posy = 0; //new Panel, Planks start at (0,0)
            
        }
        
                
    }
    void GenerateCuts32(List<Client> Listc,List<Supplier> ListSupp)
    {
        List<String> Panels = new ArrayList<>();
        List<String> Planks = new ArrayList<>();
        Panels = GetPanels(ListSupp);
        Planks = GetPlanks(Listc);
        Panels.add("end");
        Planks.add("end");
        Sorting1 sort = new Sorting1();
        List<String> Listcorg = new ArrayList<>();
        Listcorg = sort.Sorting2(Planks);

        int indexc = 0;
        int indexf  = 0;
        boolean value = true;
        double posx = 0;
        double posy = 0;
        int sizec = Planks.size();
        int sizef = Panels.size();
        double current_l = 0;
        double current_L =0;
        double new_L = 0;
        double new_l = 0;
        double old_l = 0;
        double old_L = 0;
        double max_L = 0;
        double min_L = 999;
        int numberc = 1;
        int numbers = 1;
        boolean cond = true;
        int number_of_clients = Collections.frequency(Listcorg, "client");
        int number_of_generate = Collections.frequency(Listcorg, "generated");

        while( indexf<sizef && cond )
        {

            if(Panels.get(indexf) == "m") //we are on a Panel
            {
                old_L = Double.parseDouble(Panels.get(indexf+3));
                old_l = Double.parseDouble(Panels.get(indexf+4));
                posy = posy + max_L;
                while(indexc<sizec)
                {
                    if(Listcorg.get(indexc) == "m") //we are on a Plank
                    {
                        current_L = Double.parseDouble(Listcorg.get(indexc+3));
                        current_l = Double.parseDouble(Listcorg.get(indexc+4));

                        
                       
                         if(current_L < min_L)
                        {
                            min_L = current_L;
                        }
                        if(Double.parseDouble(Panels.get(indexf+3)) >=  current_L && Double.parseDouble(Panels.get(indexf+4)) >=  current_l )
                        {
                            
                            Cutting.add("client");
                            Cutting.add(Listcorg.get(indexc+1));//adding client id
                            Cutting.add(Listcorg.get(indexc+2) + "." + Integer.toString(numberc));//plank id with number
                            Cutting.add("supplier");
                            Cutting.add(Panels.get(indexf +1));
                            Cutting.add(Panels.get(indexf + 2) + "." + Integer.toString(numbers));
                            Cutting.add("positionX");
                            Cutting.add(Double.toString(posx));
                            Cutting.add("positionY");
                            Cutting.add(Double.toString(posy));
                            posx = posx + current_l;
                            new_l = Double.parseDouble(Panels.get(indexf+4)) -  current_l;
                            Panels.set(indexf+4,Double.toString(new_l) );
                            // cond = false;
                            Listcorg.set(indexc,"generated");
                            if(number_of_clients == number_of_generate) //there are no more clients to generate there planks
                            {
                                cond = false;
                            }
                            if(current_L > max_L )
                            {
                                max_L = current_L;
                            }
                            indexc++;
                        }
                        else{
                            indexc++;
                        }
                        
                    }
                    indexc++;
                    if(indexc == sizec -1) //then we cannot add a planks to the right, we should go down
                        {
                            Panels.set(indexf+4,Double.toString(old_l));
                            new_L = Double.parseDouble(Panels.get(indexf+3)) -  max_L;
                            Panels.set(indexf+3,Double.toString(new_L) );
                            posy = max_L;
                            posx = 0;
                            if(new_L <= min_L)
                            {
                                indexc = sizec-1;
                            }
                            else{
                                indexc = 0;

                            }
                        }
                }
                numbers++;
            }
            if(Panels.get(indexf) == "n"){
                numbers = 1;
             }
            indexf++;//done with the Panel, moving on to the next one
            indexc = 0; //to reiterate over all the ungenerated Planks
            posy = 0; //new Panel, Planks start at (0,0)
            posx = 0; 
            max_L = 0;
            min_L = 999;
            
        }


    }
    private List<String> GetPlanks(List<Client> ListC)
    {
        List<String> Planks = new ArrayList<>();
        for(Client c : ListC)
        { 
            Planks.add("client");
            for(Wood w : c.listWood)
            {
                Planche p = (Planche)w;//downcasting
                Planks.add("m");
                for(int i = 0;i<p.nombre;i++)
                {   
                    Planks.add(Integer.toString(c.id));
                    Planks.add(Integer.toString(p.id));
                    Planks.add(Double.toString(p.listDim.get(0).L));
                    Planks.add(Double.toString(p.listDim.get(0).l));
                    if( i != p.nombre -1)
                        Planks.add("m");

                }
                Planks.add("n");
            }
        }
        return Planks;
    }

    private List<String> GetPanels(List<Supplier> ListSupp)
    {
        List<String> Panels = new ArrayList<>();
        for(Supplier s : ListSupp)
        {
            Panels.add("supplier");
            for(Wood w : s.listWood)
            {
                Panel p = (Panel)w;//downcasting
                Panels.add("m");
                for(int i = 0 ;i<p.nombre;i++)
                {
                    Panels.add(Integer.toString(s.id));
                    Panels.add(Integer.toString(p.id));
                    Panels.add(Double.toString(p.listDim.get(0).L));
                    Panels.add(Double.toString(p.listDim.get(0).l));
                    if(i != p.nombre -1)
                        Panels.add("m");
                }
                Panels.add("n");
                
            }
        }
        return Panels;
    }

}



        
        

    
