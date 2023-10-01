package com.in28minutes.learnspringsecurity.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collection;
import java.util.stream.Collectors;

//@RestController
public class JwtAuthenticationResource {
//    @Autowired
    JwtEncoder jwtEncoder;
    @PostMapping("/authenticate")
    public JwtResponse authenticate(Authentication authentication){
        return new JwtResponse(createToken(authentication));
    }

    private String createToken(Authentication authentication) {
        var claims = JwtClaimsSet.builder()
                // who has issed it. It is  self issued for the same application
                .issuer("self")
                // when is it issed at.
                .issuedAt(Instant.now())
                // when does it expires at.
                .expiresAt(Instant.now().plusSeconds(60*30))
                // who is the subject, that is name of principles.
                .subject(authentication.getName())
                //we put what athorities this user have in scope of claim
                .claim("scope",createScope(authentication))
                .build();
        JwtEncoderParameters parameters = JwtEncoderParameters.from(claims);
        return jwtEncoder.encode(parameters).getTokenValue();
    }

    private String createScope(Authentication authentication) {
        // get the all the athorities
       return authentication.getAuthorities().stream()
               .map(a -> a.getAuthority())// map each athority to its a.getAuthority()
               .collect(Collectors.joining(" "));//join all athorities all together by seperated by space
    }

}
record JwtResponse(String token){

}
