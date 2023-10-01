package com.in28minutes.learnspringsecurity.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableMethodSecurity(jsr250Enabled = true,securedEnabled = true)
public class BasicAuthSecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth-> auth
                // this specific url has role of "USER", this is uri based authentication
//                .requestMatchers("/users").hasRole("USER")
                //if any specigic urel start with /admin, this specific url has role of "ADMIN",
//                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated());
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
        return http.build();

    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user = User.withUsername("amil")
//                .password("{noop}amil2003")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}amil2003")
//                .roles("USER","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){

        UserDetails user = User.withUsername("amil")
                .password("amil2003")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("amil2003")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("USER","ADMIN")
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

}
