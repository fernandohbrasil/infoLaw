package util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class DateUtil {

    public SimpleDateFormat formt;
    private final SimpleDateFormat dataFull;
    private final SimpleDateFormat dayFormat;
    private final SimpleDateFormat monthFormat;
    private final SimpleDateFormat yearFormat;

    public DateUtil() {
        formt = new SimpleDateFormat("dd/MM/yyyy");
        dataFull = new SimpleDateFormat("EEEE, d' de 'MMMM' de 'yyyy");
        dayFormat = new SimpleDateFormat("dd");
        monthFormat = new SimpleDateFormat("MM");
        yearFormat = new SimpleDateFormat("yyyy");
    }

    public SimpleDateFormat getDayFormat() {
        return dayFormat;
    }

    public SimpleDateFormat getMonthFormat() {
        return monthFormat;
    }

    public SimpleDateFormat getYearFormat() {
        return yearFormat;
    }

    public SimpleDateFormat getFormt() {
        return formt;
    }

    public String dateToString(Date aData) {
        try {
            return formt.format(aData);
        } catch (Exception e) {            
            return "";
        }
    }

    public Date stringToDate(String aData) {
        try {
            return formt.parse(aData);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
            return Date.from(Instant.now());
        }
    }

    public Date stringToDateFull(String aData) {
        try {
            return formt.parse(aData);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
            return Date.from(Instant.now());
        }
    }

    public boolean validaData(String oData) {
        boolean valida = false;

        try {
            valida = true;
            formt.setLenient(false);
            Date data = formt.parse(oData);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
        }
        return valida;
    }

    public Date addMonth(Date oData, int add) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(oData);
            cal.add(Calendar.MONTH, add);
            return cal.getTime();
        } catch (Exception e) {
            return oData;
        }
    }

    private String msgData() {
        return "Data Inválida";
    }

    public String lastDayOfMonth() {
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

    public String monthNow() {
        try {
            return monthFormat.format(Date.from(Instant.now()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
            return "";
        }
    }

    public String yearNow() {
        try {
            return yearFormat.format(Date.from(Instant.now()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, msgData());
            return "";
        }
    }
}
