/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

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
}
