package org.wildcraft.string;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;


/**
 * Created by NSR on 2/6/2017.
 */
@Test
public class StringTest {
    Logger LOG = LoggerFactory.getLogger(StringTest.class.getName());

    @Test(enabled=true)
    public void testNoOfCharOfString() throws Exception {
        String a = "abcdefghijk"; // 11 characters
        String b = "????????16?"; // 11 characters

        Assert.assertEquals(getSize(a),11);
        Assert.assertEquals(getSize(b),11);
    }

    private static int getSize(String string) throws Exception {
        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        byte[] bytes = (byte[]) value.get(string);
        return bytes.length;
    }
}
