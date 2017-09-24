package org.wildcraft.stackwalker;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

@Test
public class StackWalkerTest {

    @Test
    public void testStackWalker() {
        walkAndFilterStackframe().forEach(out::println);
    }

    private static List<String> walkAndFilterStackframe() {
        return StackWalker.getInstance().walk(s ->
                s.map( frame -> frame.getClassName()+"/"+frame.getMethodName() )
                        .filter(name -> name.startsWith("org.wildcraft.stackwalker"))
                        .limit(10)
                        .collect(Collectors.toList())
        );
    }
}
