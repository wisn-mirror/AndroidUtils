package com.wisn.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wisn on 2017/10/8.
 */

public class DataUtils {

    /**
     * @param str
     * @param fmt
     *
     * @return
     */
    public static Date getDateByStr(String str, String fmt) {
        if (str == null || str.length() == 0) return null;
        if (fmt == null || fmt.length() == 0) return null;
        SimpleDateFormat format = new SimpleDateFormat(fmt, Locale.CHINA);
        try {
            Date parse = format.parse(str);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getDateTimeByStr(String str, String fmt) {
        Date date = getDateByStr(str, fmt);
        if (date != null) return date.getTime();
        return -1;
    }

}
