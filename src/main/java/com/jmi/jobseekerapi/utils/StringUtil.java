package com.jmi.jobseekerapi.utils;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;
import java.util.regex.Pattern;

public final class StringUtil {

    private StringUtil() {
    }

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    public static boolean hasText(String str) {
        return StringUtils.hasText(str); // null or whitespace → false
    }

    public static boolean hasLength(String str) {
        return StringUtils.hasLength(str); // null or "" → false
    }

    public static String trimWhitespace(String str) {
        return StringUtils.trimWhitespace(str);
    }

    public static String trimAllWhitespace(String str) {
        return StringUtils.trimAllWhitespace(str);
    }
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String defaultIfBlank(String str, String defaultValue) {
        return isBlank(str) ? defaultValue : str.trim();
    }

    public static String defaultIfEmpty(String str, String defaultValue) {
        return isEmpty(str) ? defaultValue : str;
    }

    public static String truncate(String str, int maxLength) {
        if (str == null) return null;
        return str.length() <= maxLength ? str : str.substring(0, maxLength);
    }

    public static String truncateWithEllipsis(String str, int maxLength) {
        if (str == null || str.length() <= maxLength) return str;
        return str.substring(0, Math.max(0, maxLength - 3)) + "...";
    }

    public static String capitalize(String str) {
        return StringUtils.capitalize(str);
    }

    public static boolean containsIgnoreCase(String str, String search) {
        if (str == null || search == null) return false;
        return str.toLowerCase().contains(search.toLowerCase());
    }

    public static String join(Collection<?> collection, String separator) {
        if (collection == null) return null;
        return String.join(separator, collection.stream()
                .map(Object::toString)
                .toList());
    }

    public static String join(Object[] array, String separator) {
        if (array == null) return null;
        return String.join(separator, Arrays.stream(array)
                .map(Object::toString)
                .toList());
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static String mask(String str, int visibleStart, int visibleEnd) {
        if (isBlank(str) || visibleStart + visibleEnd >= str.length()) return str;
        return str.substring(0, visibleStart) +
                "*".repeat(str.length() - visibleStart - visibleEnd) +
                str.substring(str.length() - visibleEnd);
    }
}