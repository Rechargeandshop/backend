package com.recharge.shopping.request;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "jhef;jebfkjfjkebffbewfbffywfhb564DHVVVDJKBKB6AFBFHVJHVVSKNSFFSJBBJBJ666FKBBFBHF2656FJHBFJHvJHVAH6266" +
            "FJKBJJBJFBUHJNF66565FJUGdbf366f";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // Token valid for 1 day
                .signWith(SECRET_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
