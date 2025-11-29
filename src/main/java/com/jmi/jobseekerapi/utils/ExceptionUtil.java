package com.jmi.jobseekerapi.utils;


import java.io.PrintWriter;
import java.io.StringWriter;

public final class ExceptionUtil {

    private ExceptionUtil() {}

    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }

    public static String getRootCauseMessage(Throwable t) {
        Throwable root = t;
        while (root.getCause() != null && root.getCause() != root) {
            root = root.getCause();
        }
        return root.getMessage();
    }

    public static boolean causedBy(Throwable t, Class<? extends Throwable> causeType) {
        Throwable current = t;
        while (current != null) {
            if (causeType.isInstance(current)) return true;
            current = current.getCause();
        }
        return false;
    }
}