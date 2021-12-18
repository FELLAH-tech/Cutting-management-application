package Algo;
import Readwrite.*;

import java.util.List;
abstract  class User 
{
    int id;
    List<? extends Wood> listWood;
    User(int id, List<? extends Wood> listWood)
    {
        this.id = id;
        this.listWood = listWood;
    }
    
}
