package com.instagram.security.jwt;

import com.instagram.security.user.InsUserDetails;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {
    private static final String SECRET_KEY = "abcdefghijklmnopqrstuvxyz1234567890ABCDEFGHIJKLMNOPQRSTUVXYZ";
    private static final long EXPIRATION_TIME = 86400000;

    // create token for user when login success
    public String generateTokenForUser(Authentication authentication) {
        InsUserDetails userPrincipal = (InsUserDetails) authentication.getPrincipal();
        List<String> roles = userPrincipal.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority).toList();
        return Jwts.builder()
                .setSubject(userPrincipal.getEmail())
                .claim("userId", userPrincipal.getUserId())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + EXPIRATION_TIME))
                .signWith(key() ,SignatureAlgorithm.HS512).compact();
    }

    // create key secret for jwt
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
    }

    // decode jwt token and get user's email(username) from token
    public String getUsernameFromToken(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // check jwt token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            throw new JwtException(e.getMessage());
        }
    }
}
