package ua.pp.darknsoft.security.provider;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.security.model.Jwt;
import ua.pp.darknsoft.security.model.UserPrincipal;

import java.util.Date;

@Component
public class JwtProvider {
  @Value("${security.jwt.secret}")
  private String jwtSecret;

  @Value("${security.jwt.expiration}")
  private int jwtExpiration;

  public Jwt generateJwtToken(Authentication authentication) {

    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

    String token = Jwts.builder()
                       .setSubject((userPrincipal.getUsername()))
                       .setIssuedAt(new Date())
                       .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
                       .signWith(SignatureAlgorithm.HS512, jwtSecret)
                       .compact();
    return new Jwt(token, userPrincipal.getId());
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
  }
}
