package br.ufg.petsadoption.services;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {

    String username(String token);

    String generateToken(String username);

    boolean isValid(String token, UserDetails userDetails);

    boolean isExpired(String token);

    String token(HttpServletRequest request);

    String authorizationHeader(HttpServletRequest request);

}
