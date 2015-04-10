/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

/**
 * Html 操作相关的工具
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-10-15
 */
public final class HtmlUtils {
    /**
     * 移除htmlTag
     * @param html
     * @return
     */
    public static String removeHtmlTag(String html) {
        if (StrUtils.isBlank(html)) {
            return html;
        }
        html = html.replaceAll("<[^>]+>", "");
        return html;
    }
}
