package com.annet.user.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.datarelay.utils
 * 时间：2019/08/09 01:26
 * 说明：时间日期工具类
 */
@Slf4j
public class TimeUtils {
    private static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取此刻之前多长时间的字符串
     *
     * @param before    量化时间
     * @param type      时间尺度，Calendar.DATE、Calendar.MONTH、Calendar.YEAR
     * @param strFormat 格式化串
     * @return 此刻之前多长时间的字符串
     */
    private static String getBeforeDate(int before, int type, String strFormat) {
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        if (before != 0) {
            // 如果before == 0，则返回当前时间
            calendar.add(type, -before);
        }

        Date date = calendar.getTime();
        return format.format(date);
    }

    public static String getBeforeDay(int day) {
        return getBeforeDate(day, Calendar.DATE, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getBeforeMonthDate(int month) {
        return getBeforeDate(month, Calendar.MONTH, "yyyy-MM-dd");
    }

    public static String getBeforeMonth(int month) {
        return getBeforeDate(month, Calendar.MONTH, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getBeforeYear(int year) {
        return getBeforeDate(year, Calendar.YEAR, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentTime() {
        return getBeforeDate(0, Calendar.DATE, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentDate() {
        return getBeforeDate(0, Calendar.DATE, "yyyy-MM-dd");
    }

    public static String getTodayStartDate() {
        return getBeforeDate(0, Calendar.DATE, "yyyy-MM-dd 00:00:00");
    }

    public static String getTodayEndDate() {
        return getBeforeDate(0, Calendar.DATE, "yyyy-MM-dd 23:59:59");
    }

    public static String getTimestamp() {
        return System.currentTimeMillis() + "";
    }

    /**
     * 获取日期时间 yyyy-MM-dd
     *
     * @param strDate 时间字符串
     * @return 日期时间
     */
    public static String getStrDate(String strDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(strDate);
            return format.format(date);
        } catch (ParseException e) {
            log.error(e.getMessage());
            return strDate;
        }
    }

    public static boolean isValidDate(String strDate, String strFormat) {
        SimpleDateFormat format = new SimpleDateFormat(strFormat);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2018-02-29会被接受，并转换成2018-03-01
            format.setLenient(false);
            Date date = format.parse(strDate);
            String dateStr = format.format(date);
            log.info(dateStr);
        } catch (Exception ex) {
            log.error(ex.toString());
            return false;
        }

        return true;
    }

    public static boolean isValidDate(String strDate) {
        return isValidDate(strDate, "yyyy-MM-dd");
    }

    public static boolean isValidTime(String strDate) {
        return isValidDate(strDate, "yyyy-MM-dd HH:mm:ss");
    }
}
