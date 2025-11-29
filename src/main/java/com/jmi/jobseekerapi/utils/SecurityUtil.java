package com.jmi.jobseekerapi.utils;

// ===============================================
// SecurityUtil.java (Spring Security helpers)
// ===============================================
//
//import org.springframework.security.core.*;
//import org.springframework.security.core.context.*;

public final class SecurityUtil {
/*
    private SecurityUtil() {}

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static String getCurrentUsername() {
        Authentication auth = getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal() == null) return null;
        if (auth.getPrincipal() instanceof String s) return s;
        if (auth.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails ud)
            return ud.getUsername();
        return auth.getName();
    }

    public static boolean isAdmin() {
        return hasRole("ADMIN") || hasRole("ROLE_ADMIN");
    }

    public static boolean hasRole(String role) {
        Authentication auth = getAuthentication();
        if (auth == null) return false;
        return auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(r -> r.equals(role) || r.equals("ROLE_" + role));
    }*/
}