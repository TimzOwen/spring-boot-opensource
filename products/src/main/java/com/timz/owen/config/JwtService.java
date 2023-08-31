package com.timz.owen.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    // 3. 0 var to hold the secret Key
    private static final String SECRET_KEY ="eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiVVNFUiIsIklzc3VlciI6Iklzc3VlciIsIlVzZXJuYW1lIjoidGltem93ZW5AZ21haWwuY29tIiwiZXhwIjoxNjg5OTAxNzQ4LCJpYXQiOjE2ODk5MDE3NDh9.uNYLRxfNypfgkHcrDQjAl7BcPhRvpv4r79ACz1wZ1aM";

    // 1.0 --> method to extract UserName from token
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 5.0 // implement extracting single claims.
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
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

    // 6.0 --> generating token
    public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    // 4.0 Get the base 64 conversion for the secret key
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
