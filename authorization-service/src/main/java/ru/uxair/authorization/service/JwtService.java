package ru.uxair.authorization.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface JwtService {

    String extractUserEmail(String token);
    <T> T extractClaim (String token, Function<Claims, T> claimsResolver);

    String generateToken (UserDetails userDetails);

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);

}