package br.ufg.petsadoption.services.impl;

import br.ufg.petsadoption.services.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Component
public class JWTServiceImpl implements JWTService {

    @Value("${jwt.auth.secret-key:1ay$b!++6VLSOg?FRow3}")
    private String secretKey;

    @Value("${jwt.auth.app-name:pets-adoption}")
    private String appName;


    @Value("${jwt.auth.experies-in-seconds:3600}")
    private int expiresIn;

    @Value("${jwt.auth.algorithm:HS256}")
    private String algorithm;

    public String username(String token) {
        Claims claims = allClaims(token);
        return StringUtils.defaultString(claims.getSubject());
    }

    public String generateToken(String username) {
        var instant = Instant.now().plusSeconds(expiresIn);
        return Jwts
                .builder()
                .setIssuer(appName)
                .setSubject(username)
                .setExpiration(Date.from(instant))
                .signWith(SignatureAlgorithm.forName(algorithm), secretKey.getBytes())
                .compact();
    }

    public boolean isValid(String token, UserDetails userDetails) {
        return username(token).equals(userDetails.getUsername()) && !isExpired(token);
    }

    public boolean isExpired(String token) {
        var expireDate = expirationDate(token);
        return expireDate.before(new Date());
    }

    public String token(HttpServletRequest request) {
        return StringUtils.substringAfter(authorizationHeader(request), "Bearer ");
    }

    public String authorizationHeader(HttpServletRequest request) {
        return StringUtils.defaultString(request.getHeader("Authorization"));
    }

    private Date expirationDate(String token) {
        return allClaims(token).getExpiration();
    }

    private Claims allClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

}
