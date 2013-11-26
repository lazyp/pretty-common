/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

import org.junit.Test;

import junit.framework.Assert;

public final class OsUtilsTest {
    @Test
    public void test() {
        Assert.assertEquals(OsUtils.getCpuLogicalThreads(), 4);
    }
}
