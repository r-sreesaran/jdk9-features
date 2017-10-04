package org.wildcraft.util.arrays;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
/**
 * Created by NSR on 2/6/2017.
 */
@Test
public class CompareArraysTest {

    Logger LOG = LoggerFactory.getLogger(CompareArraysTest.class.getName());

    @Test
    public void testArraysCompare() {
        byte[] a = new byte[]{1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4}; // Size doesn't matter, only content
        byte[] b = new byte[]{1, 2, 3, 4};

        LOG.info("Difference in Length: "+Arrays.compare(a, b));
    }

    @Test
    public void testArraysCompareWithDifferentArray() {
        byte[] a = new byte[]{1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4};
        byte[] b = new byte[]{5, 6, 7, 8};
        LOG.info("Difference in Length: "+Arrays.compare(a, b));
    }
}
