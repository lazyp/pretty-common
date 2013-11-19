/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

import org.junit.Test;

import junit.framework.Assert;

public class ArrayUtilsTest {
    @Test
    public void joinTest() {
        String[] ar = new String[] { "a", "b", "c" };
        Assert.assertEquals(ArrayUtils.join(ar, ','), "a,b,c");
    }

    @Test
    public void isContainsTest() {
        String[] ar = new String[] { "abcd", "bd", "ce" };
        String s = "abcd";
        Assert.assertEquals(ArrayUtils.isContains(ar, s), true);
        Assert.assertEquals(ArrayUtils.isContains(ar, "d"), false);
    }
}
