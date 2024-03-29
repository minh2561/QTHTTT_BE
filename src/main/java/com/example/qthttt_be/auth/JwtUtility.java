package com.example.qthttt_be.auth;

import io.jsonwebtoken.*;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Nguyễn Tuấn Minh
 */
@Component
public class JwtUtility implements Serializable {
    @Resource
    private HttpServletRequest request;
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiresIn}")
    private String expiresIn;

    public String generateToken(String email) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(new Date((new Date()).getTime() + Long.valueOf(expiresIn)))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String authToken) throws ExpiredJwtException {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            throw new SignatureException("Invalid JWT signature: ", ex);
        } catch (MalformedJwtException ex) {
            throw new MalformedJwtException("Invalid JWT token: ", ex);
        } catch (UnsupportedJwtException ex) {
            throw new UnsupportedJwtException("Unsupported JWT token: ", ex);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("JWT claims string is empty: ", ex);
        }
    }

    public String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public UserDetails userDetails() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }
}