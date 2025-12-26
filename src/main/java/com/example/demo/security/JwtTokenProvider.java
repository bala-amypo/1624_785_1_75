package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {

    private String secretKey = "secret";
    private long validityInMilliseconds = 3600000; // 1h

    public String createToken(Long userId, String email, Set<String> roles) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("userId", userId);
        claims.put("roles", roles);

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }
}

// package com.example.demo.security;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;
// import org.springframework.stereotype.Component;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// @Component
// public class JwtTokenProvider {

//     // ✅ Secret key (for test/demo purposes)
//     private final String jwtSecret = "MySecretKeyForJwtGeneration";

//     // ✅ Token validity (e.g., 1 hour)
//     private final long jwtExpirationMs = 3600000;

//     /**
//      * Generates JWT token with email and optional roles
//      */
//     public String generateToken(String email) {
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("email", email);

//         Date now = new Date();
//         Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(email)
//                 .setIssuedAt(now)
//                 .setExpiration(expiryDate)
//                 .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                 .compact();
//     }

//     /**
//      * Parses token and returns Claims
//      */
//     public Claims getClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(jwtSecret)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     /**
//      * Validates token expiry and signature
//      */
//     public boolean validateToken(String token) {
//         try {
//             Claims claims = getClaims(token);
//             return !claims.getExpiration().before(new Date());
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     /**
//      * Extracts email from token
//      */
//     public String getEmailFromToken(String token) {
//         return getClaims(token).getSubject();
//     }
// }
