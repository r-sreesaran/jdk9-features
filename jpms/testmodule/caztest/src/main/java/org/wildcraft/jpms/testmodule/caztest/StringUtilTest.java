package org.wildcraft.jpms.testmodule.caztest;


import org.testng.annotations.Test;
import org.wildcraft.jpms.automodule.caz.IStringUtil;
import org.wildcraft.jpms.automodule.caz.impl.StringUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Test
public class StringUtilTest {

    @Test
    public void testStringSplitter() {
        IStringUtil stringUtil = IStringUtil.getInstance();
        System.out.println(stringUtil.split("a, b, c"));
    }

    @Test
    public void testStringUtilDescribe() {
        IStringUtil stringUtil = new StringUtil();
        Method method = null;
        try {
            method = StringUtil.class.getDeclaredMethod("describe", null);
            method.setAccessible(true);
            method.invoke(stringUtil, null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
