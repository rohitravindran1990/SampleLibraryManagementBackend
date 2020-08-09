package com.LibraryManagement.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.LibraryManagement.Entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtService {
	private static JwtService jwtService;
	
	@Value("${jwt.secret}")
    private String secret;
	
	@Autowired
	private User user;

    private static final String HS_512_ALGORITHM = "HS512";

    public static JwtService getInstance() {
        if (jwtService == null)
            jwtService = new JwtService();
        return jwtService;

    }

    public User decodeJwtToken(String jwtToken) throws Exception {
          try
          {       	
        	Algorithm algorithm = Algorithm.HMAC512(secret);
            DecodedJWT decodedToken = JWT.decode(jwtToken);
            if (decodedToken.getAlgorithm().equals(HS_512_ALGORITHM) && decodedToken.getClaims() != null) {

                JWTVerifier verifier = getJwtVerifier(algorithm);

                DecodedJWT verifiedJwt = verifier.verify(jwtToken);

                if (verifiedJwt == null) {
                    throw new Exception("Invalid JWT");
                }
                user.setRole(decodedToken.getClaims().get("role").toString());
                user.setUsername(decodedToken.getClaims().get("username").toString());
                return user;

            } else {
                throw new Exception("Invalid JWT");
            }
           }catch (Exception e) {
            throw new Exception("Invalid JWT");
        }
    }


    public String getTokenForUser(User user) throws Exception {

        Algorithm algorithm = Algorithm.HMAC512(secret);
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        //if (user == null || user.getId() == null || StringUtils.isEmpty(user.getEmail())){
        if (user == null || user.getUsername() == null) {
            throw new Exception("Invalid JWT");
        }

        String jwtToken = JWT.create()
            .withClaim("username", user.getUsername())
            .withClaim("role", user.getRole())
            .withClaim("time_stamp", timeFormat.format(new Date()))
            .sign(algorithm);
        return jwtToken;
    }

    private JWTVerifier getJwtVerifier(Algorithm algorithm) {
        return JWT.require(algorithm).
            build();
    }

}
