package Algo;
import Readwrite.*;
import java.util.Locale;
 class Cut implements Validate
{
    int idClient;
    int  idSupplier;
    double idPlanche;
    double idPanel;
    double positionX;
    double positionY;
 Cut(int idClient,int  idSupplier,double idPlanche,double idPanel ,double positionX,double positionY)
    {
        this.idClient = idClient;
        this.idSupplier = idSupplier;
        this.idPanel = idPanel;
        this.idPlanche = idPlanche;
        this.positionX = positionX;
        this.positionY = positionY;
    }
    @Override
    public boolean isId(double id)
    {
        if(id >=0.0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean isPos(double x,double y)
    {
        if(x >= 0 && y>= 0)
        {
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public   boolean isPrice(double price)
    {
        return true;
    }
    @Override
    public boolean isDate(String format, String value, Locale locale)
    {
        return true;
    }
    @Override
    public  boolean isDimension(Dimension dim)
    {
        return true;
    }
    @Override
    public boolean isNumber(int number)
    {
        return true;
    }
    @Override
    public boolean isCovering(Cut planche1,Cut planche2)
    {
        if( (planche1.positionX < planche2.positionX) && (planche1.positionY< planche2.positionY)  ){
            return true;   
        }
        else{
            return false;
        }
        
    }

    
    

    
}
