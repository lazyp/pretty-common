/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Html 操作相关的工具
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-10-15
 */
public final class HtmlUtils {
    private static Map<String, Pattern> patternCacheMap = new ConcurrentHashMap<String, Pattern>();

    /**
     * 提取html代码中的image url地址
     * @param html
     * @return
     */
    public static List<String> extractImgSrc(String html) {
        Pattern extractImgSrcPattern = patternCacheMap.get("extractImgSrcPattern");
        if (extractImgSrcPattern == null) {
            extractImgSrcPattern = Pattern.compile("<img[^>]*src=\"([^\"]+)\"[^>]*>");
            patternCacheMap.put("extractImgSrcPattern", extractImgSrcPattern);
        }

        List<String> imgSrcList = new ArrayList<String>();
        Matcher m = extractImgSrcPattern.matcher(html);
        while (m.find()) {
            imgSrcList.add(m.group(1));
        }
        return imgSrcList;
    }

    public static void main(String[] args) {
        String txt = "asadsadsad<img src=\"xxxx.jpg\" alt=\"\"/>dasdsadadsa\n\r<img src=\"xda.gif\" alt=\"x\" >";
        System.out.println(HtmlUtils.extractImgSrc(txt));
    }
}
