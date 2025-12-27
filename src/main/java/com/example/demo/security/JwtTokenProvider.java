package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.util.Set;
import java.util.Date;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String createToken(Long id, String email, Set<String> roles) {
        return "token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public Claims getClaims(String token) {
        return Jwts.claims().setSubject("user");
    }
    private static final String SECRET =
        "sdjhgbwubwwbgwiub8QFQ8qg87G1bfewifbiuwg7iu8wefqhjk";

    private final SecretKey key =
        Keys.hmacShaKeyFor(SECRET.getBytes());




     public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", email)
                .setIssuedAt(new Date())
                .setExpiration(
                    new Date(System.currentTimeMillis() + 10 * 60 * 1000)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
                
    }

}
