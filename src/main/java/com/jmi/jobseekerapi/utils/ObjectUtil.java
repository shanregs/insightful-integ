package com.jmi.jobseekerapi.utils;

import org.springframework.lang.Nullable;
import java.util.*;
import java.util.function.Supplier;

public final class ObjectUtil {

    private ObjectUtil() {}

    // ===================================================================
    // 1. Null-safe equality (like Objects.equals but with generics)
    // ===================================================================
    public static boolean equals(@Nullable Object a, @Nullable Object b) {
        return Objects.equals(a, b);
    }

    public static boolean notEquals(@Nullable Object a, @Nullable Object b) {
        return !equals(a, b);
    }

    // ===================================================================
    // 2. Null-safe hashCode & hash (varargs)
    // ===================================================================
    public static int hashCode(@Nullable Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    public static int hash(@Nullable Object... values) {
        return Arrays.hashCode(values);
    }

    // ===================================================================
    // 3. Null-safe toString
    // ===================================================================
    public static String toString(@Nullable Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String toString(@Nullable Object obj, String nullDefault) {
        return obj == null ? nullDefault : obj.toString();
    }

    // ===================================================================
    // 4. requireNonNull with custom message (best of Java + Spring)
    // ===================================================================
    public static <T> T requireNonNull(T obj) {
        return Objects.requireNonNull(obj);
    }

    public static <T> T requireNonNull(T obj, String message) {
        return Objects.requireNonNull(obj, message);
    }

    public static <T> T requireNonNull(T obj, Supplier<String> messageSupplier) {
        return Objects.requireNonNull(obj, messageSupplier);
    }

    // ===================================================================
    // 5. Null-safe defaulting (like Guava MoreObjects.firstNonNull)
    // ===================================================================
    public static <T> T firstNonNull(@Nullable T first, @Nullable T second) {
        return first != null ? first : requireNonNull(second, "Both values are null");
    }

    @SafeVarargs
    public static <T> T firstNonNull(T... values) {
        if (values == null) return null;
        for (T value : values) {
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    public static <T> T defaultIfNull(@Nullable T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

    // ===================================================================
    // 6. Identity vs Equality
    // ===================================================================
    public static boolean isSame(@Nullable Object a, @Nullable Object b) {
        return a == b;
    }

    public static boolean isNotSame(@Nullable Object a, @Nullable Object b) {
        return a != b;
    }

    // ===================================================================
    // 7. Type checks & casting
    // ===================================================================
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    public static boolean isNull(@Nullable Object obj) {
        return obj == null;
    }

    public static boolean nonNull(@Nullable Object obj) {
        return obj != null;
    }

    // ===================================================================
    // 8. Compare (null-safe, nulls first or last)
    // ===================================================================
    public static <T extends Comparable<? super T>> int compare(
            @Nullable T a, @Nullable T b, boolean nullsFirst) {
        if (a == b) return 0;
        if (a == null) return nullsFirst ? -1 : 1;
        if (b == null) return nullsFirst ? 1 : -1;
        return a.compareTo(b);
    }

    public static <T extends Comparable<? super T>> int compareNullsLast(@Nullable T a, @Nullable T b) {
        return compare(a, b, false);
    }

    public static <T extends Comparable<? super T>> int compareNullsFirst(@Nullable T a, @Nullable T b) {
        return compare(a, b, true);
    }

    // ===================================================================
    // 9. Coalesce – return first non-null (like Kotlin ?:)
    // ===================================================================
    @SafeVarargs
    public static <T> T coalesce(T... values) {
        return firstNonNull(values);
    }

    // ===================================================================
    // 10. Identity toString (includes class name + hash)
    // ===================================================================
    public static String identityToString(@Nullable Object obj) {
        if (obj == null) return "null";
        return obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
    }
}
