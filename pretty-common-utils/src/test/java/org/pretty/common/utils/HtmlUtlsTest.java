/**
 *Copyright 2012-2013.All Rights Reserved
 */
package org.pretty.common.utils;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author <a href="mailto:lazy_p@163.com">lazyp</a>
 * @version 2013-10-30
 */
public final class HtmlUtlsTest {
    @Test
    public void extractImgSrcTest() {
        String html = "<span>image Url:<img src=\"http://aaa.bbb.com/a.png\" /></span><img src=\"http://ccc.ddd.com/d.png\" />";
        String[] ret = new String[] { "http://aaa.bbb.com/a.png", "http://ccc.ddd.com/d.png" };
        Assert.assertEquals(HtmlUtils.extractImgSrc(html), Arrays.asList(ret));
    }

    @Test
    public void removeHtmlTagTest() {
        String html = "<span class='class' style=\"color:red;\">你好!</span>";
        String ret = "你好!";
        Assert.assertEquals(HtmlUtils.removeHtmlTag(html), ret);
    }
}
