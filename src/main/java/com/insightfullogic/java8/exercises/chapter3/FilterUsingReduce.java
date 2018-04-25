package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class FilterUsingReduce {

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        return stream.reduce(new ArrayList<I>(), (acc, i) -> {
            ArrayList<I> result = new ArrayList<>(acc);
            if (predicate.test(i)) {
                result.add(i);
            }
            return result;
        }, (left, right) -> {
            ArrayList<I> result = new ArrayList<>(left);
            result.addAll(right);
            return result;
        });
    }

}
