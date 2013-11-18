/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * 字符串处理公具类
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-10-14
 */
public final class StringUtils {
    public static final String EMPTY = "";

    /**
     * 去掉收尾空格 <code>
     *  StringUtils.trim("  ") return "";
     *  StringUtils.trim(" abc ") return "abc";
     *  StringUtils.trim(null) return "";
     * </code>
     * @param str
     * @return
     */
    public static String trim(String str) {
        if (str == null) return EMPTY;
        return str.trim();
    }

    /**
     * <code>
     *  StringUtils.trimToNull("") return null;
     *  StringUtils.trimToNull("  ") return null;
     *  StringUtils.trimToNull(null) return null;
     *  StringUtils.trimToNull(" abc ") return "abc";
     * </code>
     * @param str
     * @return
     */
    public static String trimToNull(String str) {
        if (str == null) return null;
        str = str.trim();
        if ("".equals(str)) return null;
        return str;
    }

    /**
     * <code>
     *  StringUtils.isBlank("") return true;
     *  StringUtils.isBlank(" ") return true;
     *  StringUtils.isBlank(null) return true;
     *  StringUtils.isBlank("abc") return false;
     * </code>
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return trimToNull(str) == null;
    }

    /**
     * <code>
     *  StringUtils.isNotBlank("") return false;
     *  StringUtils.isNotBlank(" ") return false;
     *  StringUtils.isNotBlank(null) return false;
     *  StringUtils.isNotBlank("abc") return true;
     * </code>
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 字符串第一个字符大写
     * @param str
     * @return
     */
    public static String firstCharToUpperCase(String str) {
        if (isNotBlank(str)) {
            char firstChar = str.charAt(0);
            return String.valueOf(firstChar).toUpperCase(Locale.ENGLISH) + str.substring(1);
        }
        return str;
    }

    /**
     *  字符串第一个字符转为小写
     * @param str
     * @return
     */
    public static String firstCharToLowerCase(String str) {
        if (isNotBlank(str)) {
            char firstChar = str.charAt(0);
            return String.valueOf(firstChar).toLowerCase(Locale.ENGLISH) + str.substring(1);
        }
        return str;
    }

    public static byte[] getBytesByCharset(String str, Charset charset) {
        if (isNotBlank(str)) {
            return str.getBytes(charset);
        }
        return null;
    }

    /**
     * 获取UTF8编码的字节数组
     * @param str
     * @return
     */
    public static byte[] getUTF8Bytes(String str) {
        return getBytesByCharset(str, Charset.forName("UTF-8"));
    }

    /**
     * 获取GBK编码的字节数组
     * @param str
     * @return
     */
    public static byte[] getGBKBytes(String str) {
        return getBytesByCharset(str, Charset.forName("GBK"));
    }

    /**
     * 获取ISO-8859-1编码的字节数组
     * @param str
     * @return
     */
    public static byte[] getISO8859Bytes(String str) {
        return getBytesByCharset(str, Charset.forName("ISO-8859-1"));
    }
}
