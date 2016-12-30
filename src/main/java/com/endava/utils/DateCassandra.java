package com.endava.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCassandra {

    public static Date dateStringToDate(String inDateStr) {

        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(inDateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return date;
    }
}
