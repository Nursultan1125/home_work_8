package com.example.homework8.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String dateToString(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        return dateFormat.format(date);
    }
}
