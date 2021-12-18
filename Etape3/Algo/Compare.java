package Algo;
import Readwrite.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class Compare {

    int Comparelexico(List<String> c1,List<String> c2)
    {
        double c11 = Double.parseDouble(c1.get(0));
        double c12 = Double.parseDouble(c1.get(1));
        double c21 = Double.parseDouble(c2.get(0));
        double c22 = Double.parseDouble(c2.get(1));

        if(c11>c21)
        {
            return 1;
        }
        else if(c11 == c21)
        {
            if(c12>c22)
            {
                return 1;
            }
            else if(c12 == c22)
            {
                return 1;
            }
            else{
                return 2;
            }
        }
        else if(c11 < c21)
        {
            return 2;
        }


        return 1;
    }
   
} 