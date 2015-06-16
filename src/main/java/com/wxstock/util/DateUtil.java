package com.wxstock.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * util of date
 * Created by wcong on 15/5/22.
 */
public class DateUtil {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static List<Date> makeDateListForBuyIn(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        List<Date> dateList = new ArrayList<Date>(2);
        dateList.add(calendar.getTime());
        calendar.add(Calendar.YEAR, -1);
        dateList.add(calendar.getTime());
        return dateList;
    }

    public static Date formatStringToDate(String stringDate) throws ParseException {
        return dateFormat.parse(stringDate);
    }

}
