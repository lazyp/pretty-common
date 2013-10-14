/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 集合处理工具类
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-10-14
 */
public final class CollectionUtils {
    public static boolean isEmptyList(List<?> l) {
        return l == null || l.size() == 0;
    }

    public static boolean isNotEmptyList(List<?> l) {
        return !isEmptyList(l);
    }

    public static boolean isEmptyMap(Map<?, ?> map) {
        return map == null || map.size() == 0;
    }

    public static boolean isNotEmptyMap(Map<?, ?> map) {
        return !isEmptyMap(map);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }
}
