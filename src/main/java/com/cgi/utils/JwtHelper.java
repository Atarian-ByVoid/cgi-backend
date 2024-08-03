package com.cgi.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtHelper {

    // private final static String SECRET = "InfinityVoid";

    public UserDetails getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()
                && authentication.getPrincipal() instanceof UserDetails) {
            return (UserDetails) authentication.getPrincipal();
        }
        return null;
    }

    public String getLoggedInUsername() {
        UserDetails userDetails = getLoggedInUserDetails();
        if (userDetails != null) {
            return userDetails.getUsername();
        }
        return null;
    }

    // public String getAccountIdFromToken(HttpServletRequest request) {
    // String token = extractToken(request);
    // if (token != null) {
    // Claims claims = Jwts.parserBuilder()
    // .setSigningKey(
    // SECRET)
    // .build()
    // .parseClaimsJws(token)
    // .getBody();
    // return claims.get("userId", String.class);
    // }
    // return null;
    // }

    // private String extractToken(HttpServletRequest request) {
    // String header = request.getHeader("Authorization");
    // if (header != null && header.startsWith("Bearer ")) {
    // return header.substring(7);
    // }
    // return null;
    // }
}
