package org.wildcraft.compactstring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

@Test
public class CompactStringTest {

    private static final Logger LOG = LoggerFactory.getLogger(CompactStringTest.class.getName());


    // Set -XX:-CompactStrings JVM Argument to disable Compact String.
    // Check Generated and Created Time post disabling.
    @Test
    public void testStringGenerationFromIntegers() {
        long launchTime = System.currentTimeMillis();
        List<String> strings = IntStream.rangeClosed(1, 10_000_000)
                .mapToObj(Integer::toString)
                .collect(toList());
        long runTime = System.currentTimeMillis() - launchTime;
        LOG.info("Generated " + strings.size() + " strings in " + runTime + " ms.");


        launchTime = System.currentTimeMillis();
        String appended = strings.stream()
                .limit(100_000)
                .reduce("", (left, right) -> left + right);
        runTime = System.currentTimeMillis() - launchTime;
        LOG.info("Created string of length " + appended.length() + " in " + runTime + " ms.");
    }

}
