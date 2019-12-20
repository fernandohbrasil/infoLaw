package util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author fernando
 */
public class CurrencyUtil {
    
    public String getFormatCurrency(Double value){
        return NumberFormat.getInstance(new Locale("pt", "BR")).format(value);
    }
    
    public double getFormatCurrency(String value){        
        return Double.valueOf(value);
    }    
}
