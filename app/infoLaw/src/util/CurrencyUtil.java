package util;

import java.text.DecimalFormat;

public class CurrencyUtil {
    
    public static String getFormatCurrency(Double value) {
        //return NumberFormat.getInstance(new Locale("pt", "BR")).format(value).;        
        return new DecimalFormat("###,###,###,##0.00").format(value);
    }
    
    public static double getFormatCurrency(String value) {        
        return Double.valueOf(value);
    }    
    
    public static double getValorFromEdit(String editValue) {
        try {
            return Double.parseDouble(editValue);
        } catch (NumberFormatException exception) {
            try {
                return Double.parseDouble(editValue.replace(',', '.'));
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
    }
}