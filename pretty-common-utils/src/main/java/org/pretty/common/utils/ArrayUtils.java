/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

/**
 * 数组工具类
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-11-4
 */
public final class ArrayUtils {

    /**
     * 数组是否包含元素t
     * @param ar
     * @param t
     * @return
     */
    public static boolean isContains(int[] ar, int t) {
        for (int i : ar) {
            if (i == t) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组是否包含元素t
     * @param ar
     * @param t
     * @return
     */
    public static boolean isContains(long[] ar, long t) {
        for (long i : ar) {
            if (i == t) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组是否包含元素t
     * @param ar
     * @param t
     * @return
     */
    public static boolean isContains(float[] ar, float t) {
        for (float i : ar) {
            if (i == t) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组是否包含元素t
     * @param ar
     * @param t
     * @return
     */
    public static boolean isContains(double[] ar, double t) {
        for (double i : ar) {
            if (i == t) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组是否包含元素t
     * @param ar
     * @param t
     * @return
     */
    public static boolean isContains(String[] ar, String t) {
        for (String i : ar) {
            if (i.equals(t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 数组转化为一个字符串
     * @param ar
     * @param joinChar 连接字符
     * @return
     */
    public static String join(Object[] ar, char joinChar) {
        if (ar != null && ar.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : ar) {
                if (sb.length() > 0) {
                    sb.append(joinChar);
                }
                sb.append(obj);
            }
            return sb.toString();
        }
        return "";
    }
}
