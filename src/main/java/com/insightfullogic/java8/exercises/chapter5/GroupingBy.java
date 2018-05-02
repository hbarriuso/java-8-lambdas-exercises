package com.insightfullogic.java8.exercises.chapter5;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

    private final Function<? super T, ? extends K> classifier;

    public GroupingBy(Function<? super T, ? extends K> classifier) {
        this.classifier = classifier;
    }

    @Override
    public Supplier<Map<K, List<T>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<K, List<T>>, T> accumulator() {
        return (map, t) -> {
            K key = classifier.apply(t);
            List<T> elements = map.computeIfAbsent(key, k -> new ArrayList<>());
            elements.add(t);
        };
    }

    @Override
    public BinaryOperator<Map<K, List<T>>> combiner() {
        return (left, right) -> {
            right.forEach((key, value) -> left.merge(key, value, (ts, ts2) -> {
                ts.addAll(ts2);
                return ts;
            }));
            return left;
        };
    }

    @Override
    public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(Characteristics.IDENTITY_FINISH);
    }

}
