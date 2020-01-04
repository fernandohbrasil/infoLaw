package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class DateUtil {

    private static final SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");    
    private static final SimpleDateFormat dataFull = new SimpleDateFormat("EEEE, d' de 'MMMM' de 'yyyy");
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    private static final SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    private static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    public static SimpleDateFormat getDayFormat() {
        return dayFormat;
    }

    public static SimpleDateFormat getMonthFormat() {
        return monthFormat;
    }

    public static SimpleDateFormat getYearFormat() {
        return yearFormat;
    }

    public static SimpleDateFormat getDate() {
        return date;
    }

    public static String dateToString(Date aData) {
        try {
            return date.format(aData);
        } catch (Exception e) {
            return "";
        }
    }

    public static Date stringToDate(String aData) {
        try {
            return date.parse(aData);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, msgData());
            return Date.from(Instant.now());
        }
    }

    public static Date stringToDateFull(String aData) {
        try {
            return date.parse(aData);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, msgData());
            return Date.from(Instant.now());
        }
    }

    public static boolean validaData(String oData) {
        boolean valida = false;

        try {
            valida = true;
            date.setLenient(false);
            Date data = date.parse(oData);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, msgData());
        }
        return valida;
    }

    public static Date addMonth(Date oData, int add) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(oData);
            cal.add(Calendar.MONTH, add);
            return cal.getTime();
        } catch (Exception e) {
            return oData;
        }
    }

    private static String msgData() {
        return "Data Inválida";
    }

    public static String lastDayOfMonth() {
        try {
            GregorianCalendar dataCal = new GregorianCalendar();
            int mes = dataCal.get(Calendar.MONTH);

            Calendar c = Calendar.getInstance();
            c.set(Calendar.MONTH, mes - 1);
            return dayFormat.format(c.getActualMaximum(Calendar.DAY_OF_MONTH));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
            return "";
        }
    }

    public  static String monthNow() {
        try {
            return monthFormat.format(Date.from(Instant.now()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
            return "";
        }
    }

    public  static String yearNow() {
        try {
            return yearFormat.format(Date.from(Instant.now()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
            return "";
        }
    }
    
     public  static String fullDateNow() {
        try {
            return date.format(Date.from(Instant.now()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
            return "";
        }
    }
}