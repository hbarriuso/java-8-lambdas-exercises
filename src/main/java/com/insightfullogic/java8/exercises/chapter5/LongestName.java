package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class LongestName {
    private static final Function<Artist, Integer> getNameLength = artist -> artist.getName().length();

    public static Artist byReduce(List<Artist> artists) {
        return artists.stream().reduce(BinaryOperator.maxBy(comparing(getNameLength))).get();
    }

    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream().collect(Collectors.maxBy(comparing(getNameLength))).get();
    }

}
