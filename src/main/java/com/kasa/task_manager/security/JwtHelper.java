package com.kasa.task_manager.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JwtHelper {
    private static final Key SECRET_KEY = Jwts.SIG.HS256.key().build();
    private static final SecretKey SIGNING_KEY = Keys.hmacShaKeyFor(SECRET_KEY.getEncoded());
    private static final int MINUTES = 60;

    public static String generateToken(String email) {
        Jwts.SIG.HS256.key().build();
        var now = Instant.now();
        return Jwts.builder()
                .subject(email)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(MINUTES, ChronoUnit.MINUTES)))
                .signWith(SIGNING_KEY, Jwts.SIG.HS256)
                .compact();
    }
}
