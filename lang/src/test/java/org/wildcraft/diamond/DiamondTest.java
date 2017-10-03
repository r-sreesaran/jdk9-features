package org.wildcraft.diamond;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;

@Test
public class DiamondTest {

    private static final Logger LOG = LoggerFactory.getLogger(DiamondTest.class.getName());

    @Test
    public void testDiamondWithoutInference() {
        Box<String> box = Box.createBoxWithoutT("World!!!");
        LOG.info(box.describe());
        Assert.assertEquals(box.getT(), "World!!!");
    }

    @Test
    public void testDiamondWithInference() {
        Box<String> box = Box.createBox("World!!!");
        LOG.info(box.describe());
        Assert.assertEquals(box.getT(), "World!!!");
    }

    @Test
    public void testNonDenotableType() {
        Box<?> box = Box.createCrazyBox("World!!!");
        LOG.info(box.describe());
        Assert.assertEquals(new ArrayList((Collection) box.getT()).get(0), "World!!!");
    }
}
