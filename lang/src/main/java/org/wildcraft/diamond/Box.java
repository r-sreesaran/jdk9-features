package org.wildcraft.diamond;

import java.util.Arrays;
import java.util.List;

public abstract class Box<T> {

    private final T t;

    public Box(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public abstract String describe();

    public static <T> Box<T> createBox(T content) {
        // we have to put the `T` here :(
        return new Box<T>(content) {
            @Override
            public String describe() {
              return "Before Java 9, T cannot be inferred in Anonymous Class";
            }
        };
    }

    public static <T> Box<T> createBoxWithoutT(T content) {
        // Java 9 can infer `T`
        // because it is a denotable type
        return new Box<>(content) {
            @Override
            public String describe() {
                return "After Java 9, T can be inferred in Anonymous Class";
            }
        };
    }

    public static Box<?> createCrazyBox(Object content) {
        List<?> innerList = Arrays.asList(content);
        // we can't do the following
        // because the inferred type is non-denotable
        return new Box<List<?>>(innerList) {
            @Override
            public String describe() {
                return "After Java 9, T still cannot be inferred if type is non de-notable";
            }
        };
    }
}
