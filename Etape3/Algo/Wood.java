package Algo;
import Readwrite.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.lang.String;
import java.text.Format;

abstract   class Wood  implements Validate
{
  int id;
  int nombre;
  String date;
  double price;
  List<Dimension> listDim;
  Wood(int id, int nombre,String date,Double price,List<Dimension>listDim)
  {
    this.id = id;
    this.nombre = nombre;
    this.date = date;
    this.price = price;
    this.listDim = listDim;
    
  }
   @Override
  public boolean isPrice(double price)
  {
      if(price >= 0.0)
      {
          return true;
      }
      else
      {
          return false;
      }
  }
    

   @Override
   public boolean isDate(String format, String value, Locale locale) {
    LocalDateTime ldt = null;
    DateTimeFormatter fomatter = DateTimeFormatter.ofPattern(format, locale);

    try {
        ldt = LocalDateTime.parse(value, fomatter);
        String result = ldt.format(fomatter);
        return result.equals(value);
    } catch (DateTimeParseException e) {
        try {
            LocalDate ld = LocalDate.parse(value, fomatter);
            String result = ld.format(fomatter);
            return result.equals(value);
        } catch (DateTimeParseException exp) {
            try {
                LocalTime lt = LocalTime.parse(value, fomatter);
                String result = lt.format(fomatter);
                return result.equals(value);
            } catch (DateTimeParseException e2) {
                // Debugging purposes
                //e2.printStackTrace();
            }
        }
    }

    return false;
    }
  @Override
  public boolean isDimension(Dimension dim)
  {
    if(dim.l >= 0 && dim.L >= 0)
      {
          return true;
      }
      else
      {
          return false;
      }
  }
  @Override
  public boolean isId(double id)
  {
    if(id >= 0.0)
      {
          return true;
      }
      else
      {
          return false;
      }
  }
  @Override
 public boolean isNumber(int number)
 {
  if(number >= 0)
  {
      return true;
  }
  else
  {
      return false;
  }
 }
 @Override
 public boolean isPos(double x, double y)
 {
     return true;
 }
@Override
public boolean isCovering(Cut planche1, Cut planche2) {
    // TODO Auto-generated method stub
    return false;
}

}
