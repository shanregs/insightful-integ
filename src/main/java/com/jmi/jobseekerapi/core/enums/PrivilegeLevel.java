    package com.jmi.jobseekerapi.core.enums;

    import com.fasterxml.jackson.annotation.JsonCreator;
    import com.fasterxml.jackson.annotation.JsonValue;

    public enum PrivilegeLevel {
        NONE,
        READ,
        WRITE;

        @JsonCreator
        public static PrivilegeLevel from(Object val) {
            if (val == null) return NONE;
            if (val instanceof Boolean) return (Boolean) val ? WRITE : NONE;
            if (val instanceof String s) {
                String normalized = s.trim().toUpperCase();
                switch (normalized) {
                    case "READ": return READ;
                    case "WRITE": return WRITE;
                    case "NONE":
                    case "FALSE": return NONE;
                    default:
                        try { return PrivilegeLevel.valueOf(normalized); }
                        catch (Exception e) { return NONE; }
                }
            }
            return NONE;
        }

        @JsonValue
        public String toValue() { return name().toLowerCase(); }
    }
