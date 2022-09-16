package com.grupo.salinas.recursos.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {
    public static String formatDate(Date date) {
        SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
        return sp.format(date);
    }

    public static boolean validaFormato(String rfc, String date) {
        String[] datelis = date.split("-");
        date = datelis[0].substring(2,4);
        date += datelis[1];
        date += datelis[2];
        if (rfc.length() == 18 && rfc.contains(date)) {
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
            Matcher camp = pattern.matcher(rfc);
            if (!camp.matches()) {
                return false;
            } else return true;
        } else return false;
    }

    public static String validaCadena(String origen, String nueva) {
        if (!nueva.equals("") && nueva != null) {
            return nueva;
        } else return origen;
    }

}
