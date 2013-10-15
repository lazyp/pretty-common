/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

/**
 * 操作系统相关的工具方法
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-10-15
 */
public final class OsUtils {
    /**
     * 获取操作系统名字:windows or linux or mac
     * @return
     */
    public static String getOsName() {
        return System.getProperty("os.name");
    }

    /**
     * 获取操作系统的版本号
     * @return
     */
    public static String getOsVersion() {
        return System.getProperty("os.version");
    }

    /**
     * 获取操作系统架构
     * @return
     */
    public static String getOsArch() {
        return System.getProperty("os.arch");
    }

    public static void main(String[] args) {
        System.out.println(OsUtils.getOsName());
        System.out.println(OsUtils.getOsVersion());
        System.out.println(OsUtils.getOsArch());
    }
}
