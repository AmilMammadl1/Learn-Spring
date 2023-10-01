package com.in28minutes.learnspringsecurity.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.KeySourceException;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSelector;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.UUID;


//@Configuration
public class JwtSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return http.build();

    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {

        UserDetails user = User.withUsername("amil")
//               .password("{noop}amil2003")
                .password("amil2003")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
//               .password("{noop}amil2003")
                .password("amil2003")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("USER", "ADMIN")
                .build();
        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

        return jdbcUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public KeyPair keyPair() {
        try {
            //get instance for RSA algorithm
            var keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            //set key size: 2048 bit for RSA algorithm
            keyPairGenerator.initialize(2048);

            //generate the keypair
            return keyPairGenerator.generateKeyPair();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Bean
    //Whenever Keypair bean is created, it is autowired in here by spring framework
    public RSAKey rsaKey(KeyPair keyPair) {
        return new RSAKey
                //creates a new RSAKey.Builder instance and initializes it with the public key.
                .Builder((RSAPublicKey) keyPair.getPublic())
                // configures the builder with the private key
                .privateKey(keyPair.getPrivate())
                //sets a key identifier
                .keyID(UUID.randomUUID().toString())
                //finalizes the configuration and creates the RSAKey object based on the settings you've specified.To actually create the RSAKey object, you need to call .build() on the RSAKey.Builder instance.
                .build();
    }
    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
        // It creates a JWKSet, a collection of JSON Web Keys, initialized with the rsaKey provided as an argument. This JWKSet represents the keys used for cryptographic operations.
        var jwkSet = new JWKSet(rsaKey);
        //provide an implementation of JWKSource for the get() Method
        var jwkSource = new JWKSource(){

            @Override
            public List<JWK> get(JWKSelector jwkSelector, SecurityContext context) throws KeySourceException {
                // provide JWKs based on the jwkSelector. In this case, it always returns the jwkSet
                return jwkSelector.select(jwkSet);
            }
            //so whenever we want to use keys, we use keySet(jwkSet), source of key set is jwkSet
        };
        return jwkSource;
    }
    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
        return NimbusJwtDecoder
                .withPublicKey(rsaKey.toRSAPublicKey())
                .build();
    }

    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource) {
        return new NimbusJwtEncoder(jwkSource);
    }

}
