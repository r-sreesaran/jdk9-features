package org.wildcraft.util.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Test
public class StreamTest {

    Logger LOG = LoggerFactory.getLogger(StreamTest.class.getName());

    //The takeWhile-operation will return the longest prefix that contains only elements that pass the predicate.
    //Talking of prefixes only makes sense for ordered streams
    //Taking from an ordered parallel stream is not the best idea
    @Test
    public void testTakeWhile() {
        Stream.of("a", "b", "c", "", "e")
                .takeWhile(s -> !s.isEmpty()).forEach(System.out::print);
    }


    @Test
    public void testDropWhile() {
        Stream.of("a", "b", "c", "de", "f")
                .dropWhile(s -> s.length() <= 1).forEach(System.out::print);
    }

    @Test
    public void testIterateUnstoppableInJava8() {
        Stream.iterate(1, i -> 2 * i)
                .filter(i->i<=10)
                .forEach(System.out::println);
    }

    // Last element is always missing
    @Test
    public void testIterateStoppable() {
        Stream.iterate(1, i -> i <= 10, i -> 2 * i)
                .forEach(System.out::println);
    }

    //Helps in Null Check on Streams
    //The method by name means, it is working on a nullable collection.
    @Test
    public void testOfNullableStreamCount() {
        long one = Stream.ofNullable("42").count();
        long zero = Stream.ofNullable(null).count();
        Assert.assertEquals(one, 1);
        Assert.assertEquals(zero, 0);
    }

    @Test
    public void testOfNullable() {
        Stream<String> one = Stream.ofNullable("42");
        Stream<String> zero = Stream.ofNullable(null);

        Assert.assertEquals(one.findFirst().get(), "42");
        Assert.assertEquals(zero.findFirst().isPresent(), false);
    }

    @Test
    public void testOfNullableStream() {
        List<String> names = Arrays.asList(null, null, "gaya");
        String firstNotNullName = names.stream().flatMap(name-> Stream.ofNullable(name)).findFirst().orElseThrow(IllegalStateException::new);
        LOG.info("name: "+firstNotNullName);
        Assert.assertEquals(firstNotNullName, "gaya");
    }

}
