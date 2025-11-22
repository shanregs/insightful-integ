package com.openjobs.insightful.utils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionUtil {

    private CollectionUtil() {
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static <T> Set<T> emptyIfNull(Set<T> set) {
        return set == null ? Collections.emptySet() : set;
    }

    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> map) {
        return map == null ? Collections.emptyMap() : map;
    }

    public static <T> List<T> nullSafeList(List<T> list) {
        return list == null ? new ArrayList<>() : new ArrayList<>(list);
    }

    public static <T> Set<T> nullSafeSet(Set<T> set) {
        return set == null ? new HashSet<>() : new HashSet<>(set);
    }

    public static <T> List<T> toList(Collection<T> collection) {
        return isEmpty(collection) ? new ArrayList<>() : new ArrayList<>(collection);
    }

    public static <T> Set<T> toSet(Collection<T> collection) {
        return isEmpty(collection) ? new HashSet<>() : new HashSet<>(collection);
    }

    public static <T, R> List<R> map(Collection<T> collection, Function<? super T, ? extends R> mapper) {
        if (isEmpty(collection)) return new ArrayList<>();
        return collection.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    public static <T> boolean containsAny(Collection<T> collection, Collection<T> candidates) {
        if (isEmpty(collection) || isEmpty(candidates)) return false;
        return collection.stream().anyMatch(candidates::contains);
    }

    public static <T> T first(Collection<T> collection) {
        if (isEmpty(collection)) return null;
        return collection.stream().findFirst().orElse(null);
    }

    public static <T> T last(List<T> list) {
        if (isEmpty(list)) return null;
        return list.get(list.size() - 1);
    }
}