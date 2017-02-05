package org.wildcraft.util.collections;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by NSR on 2/5/2017.
 */
@Test
public class CollectionFactoryTest {

    Logger LOG = LoggerFactory.getLogger(CollectionFactoryTest.class.getName());

    @Test(enabled=true)
    public void testCreateCollectionInJava8() {
        List<String> emptyList = new ArrayList<>();
        emptyList.add("one");
        emptyList.add("two");
        emptyList.add("three");
        List<String> immutableList = Collections.unmodifiableList(emptyList);
        Assert.assertEquals(emptyList.size(), immutableList.size());
    }

    @Test(enabled=true)
    public void testCreateCollectionInJava9() {
        List<String> emptyList = new ArrayList<>();
        emptyList.add("one");
        emptyList.add("two");
        emptyList.add("three");
        List<String> immutableList = List.of("one","two","three");
        Assert.assertEquals(emptyList.size(), immutableList.size());
    }

    @Test(enabled=true, expectedExceptions={UnsupportedOperationException.class})
    public void testCollectionsAreImmutable() {
        List<String> immutableList = List.of("one","two","three");
        immutableList.add("four");
    }

    @Test(enabled=true, invocationCount=5)
    public void testCollectionOrderIsUnstable() {
        LOG.info("Run");
        Stream.of(
                Set.of("a", "b", "c"),
                Set.of("a", "b", "c"),
                Set.of("a", "b", "c"))
                .map(Object::toString)
                .forEach(LOG::info);

    }
}
