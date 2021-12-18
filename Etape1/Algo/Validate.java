package Algo;
import Readwrite.*;

import java.util.Locale;

 interface Validate {
    boolean isPrice(double price);
    boolean isDate(String format, String value, Locale locale);
    boolean isDimension(Dimension dim);
    boolean isId(double id);
    boolean isNumber(int number);
    boolean isPos(double x, double y);
    public boolean isCovering(Cut planche1,Cut planche2);
    // String[] isValide(Object obj);



}
