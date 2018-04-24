package com.insightfullogic.java8.exercises.chapter3;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public class StringExercises {

    // Question 7
    public static int countLowercaseLetters(String string) {
        return (int) string.chars().filter(Character::isLowerCase).count();
    }

    // Question 8
    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream().max(comparing(StringExercises::countLowercaseLetters));
    }

}
