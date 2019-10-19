package Nucleo.utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private static SimpleDateFormat dateFormatYear = new SimpleDateFormat("yyyy");

    public static Boolean isEmptyOrNull(String str){
        if(str == null) return Boolean.TRUE;
            else if(str.isEmpty()) return Boolean.TRUE;
        return Boolean.FALSE;
    }

    public static Boolean isObjectNull(Object param){
        return param == null;
    }

    public static String dateToString(Date date){
        return dateFormat.format(date);
    }

    public static Date stringToDate(String date){
        try {
            return  dateFormat.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static int datoToYearsOld(Date date) {
        Date now = new Date();
        return Integer.parseInt(dateFormatYear.format(now)) - Integer.parseInt(dateFormatYear.format(date));
    }
}