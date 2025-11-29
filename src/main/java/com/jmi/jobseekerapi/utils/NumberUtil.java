package com.jmi.jobseekerapi.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public final class NumberUtil {

    private NumberUtil() {
    }

    public static boolean isZero(Number n) {
        return n != null && n.doubleValue() == 0;
    }

    public static boolean isPositive(Number n) {
        return n != null && n.doubleValue() > 0;
    }

    public static boolean isNegative(Number n) {
        return n != null && n.doubleValue() < 0;
    }

    public static boolean isNonNegative(Number n) {
        return n != null && n.doubleValue() >= 0;
    }

    public static Integer toInt(Object obj) {
        if (obj == null) return null;
        if (obj instanceof Number n) return n.intValue();
        try {
            return Integer.valueOf(obj.toString().trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static Long toLong(Object obj) {
        if (obj == null) return null;
        if (obj instanceof Number n) return n.longValue();
        try {
            return Long.valueOf(obj.toString().trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static Double toDouble(Object obj) {
        if (obj == null) return null;
        if (obj instanceof Number n) return n.doubleValue();
        try {
            return Double.valueOf(obj.toString().trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal toBigDecimal(Object obj) {
        if (obj == null) return null;
        if (obj instanceof BigDecimal bd) return bd;
        if (obj instanceof Number n) return BigDecimal.valueOf(n.doubleValue());
        try {
            return new BigDecimal(obj.toString().trim());
        } catch (Exception e) {
            return null;
        }
    }

    public static BigDecimal round(BigDecimal value, int scale) {
        return value == null ? null : value.setScale(scale, RoundingMode.HALF_UP);
    }

    public static String formatCurrency(BigDecimal amount) {
        if (amount == null) return "";
        return NumberFormat.getCurrencyInstance().format(amount);
    }

    public static BigDecimal safeValue(BigDecimal value, BigDecimal defaultValue) {
        return value != null ? value : defaultValue;
    }
}