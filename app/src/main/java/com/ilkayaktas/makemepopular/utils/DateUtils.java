package com.ilkayaktas.makemepopular.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by iaktas on 05.06.2017.
 */

public class DateUtils {
    private DateUtils() {
        // This utility class is not publicly instantiable
    }

    public final static DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
    public final static DateFormat hourFormat = new SimpleDateFormat("HH:mm");

    public static String getFormattedDate(Date date){
        return dateFormat.format(date);
    }
    
    public static String getFormattedDateAsHour(Date date){
        return hourFormat.format(date);
    }
    
}
