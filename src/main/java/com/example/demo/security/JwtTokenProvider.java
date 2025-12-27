package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Set;

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
     public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                    new Date(System.currentTimeMillis() + 10 * 60 * 1000)
                )
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
                
    }

}
