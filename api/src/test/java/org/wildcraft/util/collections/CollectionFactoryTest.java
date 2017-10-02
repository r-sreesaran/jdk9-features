package org.wildcraft.util.collections;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by NSR on 2/5/2017.
 */
@Test
public class CollectionFactoryTest {

    Logger LOG = LoggerFactory.getLogger(CollectionFactoryTest.class.getName());

    /**
     * In Java 8 - Create modifiable list and make it unmodifiable
     */
    @Test(enabled=true)
    public void testCreateCollectionWithoutEnhancement() {
        List<String> emptyList = new ArrayList<>();
        emptyList.add("one");
        emptyList.add("two");
        emptyList.add("three");
        List<String> immutableList = Collections.unmodifiableList(emptyList);
        Assert.assertEquals(emptyList.size(), immutableList.size());
    }

    /**
     * In Java 9 - Create unmodifiable list directly.
     */
    @Test(enabled=true)
    public void testCreateCollectionInJava9() {
        List<String> emptyList = new ArrayList<>();
        emptyList.add("one");
        emptyList.add("two");
        emptyList.add("three");
        List<String> immutableList = List.of("one","two","three");
        Assert.assertEquals(emptyList.size(), immutableList.size());
    }

    /**
     * In Java 8 or 9 - once the list is unmodifiable, no more elements can be added.
     */
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

    @Test(enabled=true)
    public void testImmutableMapOf10Elements() {
        Map<String, String> mapOfString = Map.of("key1", "value1",
                "key2", "value2",
                "key3", "value1",
                "key4", "value2",
                "key5", "value1",
                "key6", "value2",
                "key7", "value1",
                "key8", "value2",
                "key9", "value1",
                "key10", "value2");
        LOG.info(""+mapOfString);
    }

    @Test(enabled=true)
    public void testImmutableMapOf11Elements() {
        Map<String, String> moreMapOfString = Map.ofEntries(
                Map.entry("key1", "value1"),
                Map.entry("key2", "value2"),
                Map.entry("key3", "value3"),
                Map.entry("key4", "value1"),
                Map.entry("key5", "value2"),
                Map.entry("key6", "value3"),
                Map.entry("key7", "value1"),
                Map.entry("key8", "value2"),
                Map.entry("key9", "value3"),
                Map.entry("key10", "value3"),
                Map.entry("key11", "value3")
        );
        LOG.info(""+moreMapOfString);
    }
}
