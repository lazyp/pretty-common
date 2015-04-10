/**
 *Copyright 2012-2013.All Rights Reserved
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.pretty.common.utils.ArrayUtilsTest;
import org.pretty.common.utils.HtmlUtlsTest;
import org.pretty.common.utils.OsUtilsTest;
import org.pretty.common.utils.StrUtilsTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = { StrUtilsTest.class, HtmlUtlsTest.class, ArrayUtilsTest.class, OsUtilsTest.class })
public final class SuiteTest {}
