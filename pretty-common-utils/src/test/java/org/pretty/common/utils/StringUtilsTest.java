/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-10-30
 */
public final class StringUtilsTest {
    @Test
    public void test() {
        Assert.assertEquals(StringUtils.trimToNull("  "), null);
        Assert.assertEquals(StringUtils.trim("  "), "");
        Assert.assertEquals(StringUtils.trim(" abc   "), "abc");
        Assert.assertEquals(StringUtils.isBlank(" "), true);
        Assert.assertEquals(StringUtils.isBlank(null), true);
        Assert.assertEquals(StringUtils.isNotBlank(" "), false);
        Assert.assertEquals(StringUtils.isNotBlank("abc"), true);
        Assert.assertEquals(StringUtils.firstCharToUpperCase("hello"), "Hello");
        Assert.assertEquals(StringUtils.firstCharToLowerCase("Hello"), "hello");
    }
}
