package com.insightfullogic.java8.exercises.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 2
 */
public class MapUsingReduce {

    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<>(),
                (os, i) -> {
                    ArrayList<O> result = new ArrayList<>(os);
                    result.add(mapper.apply(i));
                    return result;
                }, (os, os2) -> {
                    ArrayList<O> result = new ArrayList<>(os);
                    result.addAll(os2);
                    return result;
                });
    }

}
