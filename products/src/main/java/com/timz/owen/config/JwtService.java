package com.timz.owen.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    // 3. 0 var to hold the secret Key
    private static final String SECRET_KEY ="eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiVVNFUiIsIklzc3VlciI6Iklzc3VlciIsIlVzZXJuYW1lIjoidGltem93ZW5AZ21haWwuY29tIiwiZXhwIjoxNjg5OTAxNzQ4LCJpYXQiOjE2ODk5MDE3NDh9.uNYLRxfNypfgkHcrDQjAl7BcPhRvpv4r79ACz1wZ1aM";

    // 1.0 --> method to extract UserName from token
    public String extractUserName(String token) {
        return null;
    }

    // 2.0 Method to extract all claims
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }


    // 4.0 Get the base 64 conversion for the secret key
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
