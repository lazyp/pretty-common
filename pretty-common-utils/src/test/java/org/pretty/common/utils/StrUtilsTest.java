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
public final class StrUtilsTest {
    @Test
    public void test() {
        Assert.assertEquals(StrUtils.trimToNull("  "), null);
        Assert.assertEquals(StrUtils.trim("  "), "");
        Assert.assertEquals(StrUtils.trim(" abc   "), "abc");
        Assert.assertEquals(StrUtils.isBlank(" "), true);
        Assert.assertEquals(StrUtils.isBlank(null), true);
        Assert.assertEquals(StrUtils.isNotBlank(" "), false);
        Assert.assertEquals(StrUtils.isNotBlank("abc"), true);
        Assert.assertEquals(StrUtils.firstCharToUpperCase("hello"), "Hello");
        Assert.assertEquals(StrUtils.firstCharToLowerCase("Hello"), "hello");
    }
}
