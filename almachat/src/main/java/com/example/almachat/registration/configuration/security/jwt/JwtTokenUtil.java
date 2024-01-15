package com.example.almachat.registration.configuration.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtTokenUtil {

    private static final String AUTHORITIES = "authorities";
    private static final String USER_NAME = "username";

    @Getter
    @Setter
    private String secret;

    @Getter
    @Setter
    private long expiration;

    private JwtTokenUtil() {

    }
    public boolean isValid(final String token) {
        try {
            Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(this.getSecret())
                .parseClaimsJws(token)
                .getBody()
                .get(USER_NAME, String.class);
    }

    public String generateAccessToken(UserDetails user) {
        final Date now = new Date();
        final Date expiryDate = new Date(now.getTime() + this.getExpiration());
        final Map<String, Object> claims = new HashMap<>();
        claims.put(AUTHORITIES, user.getAuthorities());
        claims.put(USER_NAME, user.getUsername());

        return "Bearer " + Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, this.getSecret())
                .compact();
    }
}
