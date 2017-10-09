package org.wildcraft.safevararg;

import java.util.Optional;


public class SafeVarArgTest {

    @SafeVarargs
    public static <T> Optional<T> first(T... args) {
        if (args.length == 0)
            return Optional.empty();
        else
            return Optional.of(args[0]);
    }

    @SafeVarargs
    public final <T> Optional<T> nonStatic(T... args) {
        if (args.length == 0)
            return Optional.empty();
        else
            return Optional.of(args[0]);
    }

    @SafeVarargs
    private <T> Optional<T> privateNonStatic(T... args) {
        if (args.length == 0)
            return Optional.empty();
        else
            return Optional.of(args[0]);
    }
}
