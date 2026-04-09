package com.gestionformation.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expiration}")
    private long expiration;

    private SecretKey getKey() {
        // Key must be at least 256 bits (32 chars) for HS256
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)                   // was .setSubject()
                .issuedAt(new Date())                // was .setIssuedAt()
                .expiration(new Date(System.currentTimeMillis() + expiration)) // was .setExpiration()
                .signWith(getKey())                  // algorithm auto-detected from key type
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()                         // was .parserBuilder()
                .verifyWith(getKey())                // was .setSigningKey()
                .build()
                .parseSignedClaims(token)            // was .parseClaimsJws()
                .getPayload()                        // was .getBody()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}