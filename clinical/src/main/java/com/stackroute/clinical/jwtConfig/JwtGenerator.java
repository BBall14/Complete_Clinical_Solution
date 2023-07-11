package com.stackroute.clinical.jwtConfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stackroute.clinical.model.ClinicUser;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

// Annotate this class as @Service

@Service
public class JwtGenerator {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${app.jwttoken.message}")
    private String message;

    public Map<String, String> generateToken(ClinicUser user) {
        String jwtToken = "";
        System.out.println("Secret:" + secret);
        jwtToken = Jwts.builder().setSubject(user.getUserName()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret").compact();
        Map<String, String> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("token", jwtToken);
        jwtTokenGen.put("message", message);
        return jwtTokenGen;
    }

}
