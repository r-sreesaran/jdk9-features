package org.wildcraft.depreciation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Test
public class DepreciationTest {

    private static final Logger LOG = LoggerFactory.getLogger(DepreciationTest.class.getName());


    @Test
    public void testAssetDepreciation() {
        Class<Asset> clazz = Asset.class;
        Method[] methods = clazz.getDeclaredMethods();
        Deprecated deprecatedClass = clazz.getAnnotation(Deprecated.class);
        Deprecated deprecatedMethod = methods[0].getAnnotation(Deprecated.class);
        Assert.assertEquals(deprecatedClass.since(), "3.0");
        Assert.assertEquals(deprecatedMethod.since(), "1.0");
        Assert.assertEquals(deprecatedMethod.forRemoval(), true);
    }
}
