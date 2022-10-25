package com.yugabyte.samples.tradex.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

  public static final SimpleDateFormat DF_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");
  public static Calendar fromYYYMMDD(String input) throws ParseException {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(DF_YYYYMMDD.parse(input));
    return calendar;
  }
}
