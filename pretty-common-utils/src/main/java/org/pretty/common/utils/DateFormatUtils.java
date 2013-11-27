/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-11-11
 */
public final class DateFormatUtils {
    /**
     * 获取当前时间的long值
     * @return
     */
    public static long now() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间，并指定格式化
     * @param format 格式化
     * @return
     */
    public static String now(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(now());
    }

    /**
     * 格式化日期
     * @param t
     * @param format
     * @return
     */
    public static String format(long t, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(t);
    }

    public static String format(Calendar calendar, String format) {
        return format(calendar.getTimeInMillis(), format);
    }

    public static String format(Date date, String format) {
        return format(date.getTime(), format);
    }

    public static void main(String[] args) {
        System.out.println(DateFormatUtils.now("yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateFormatUtils.now("yyyy年MM月dd日"));
        System.out.println(DateFormatUtils.format(new Date(), "yyyy年MM月dd日 HH时mm分ss秒"));
    }
}
