package com.example.spring_security_oauth_keycloak.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
public class SecurityConfig {

    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        // si no quisieramos tener sesion
        // return new NullAuthenticatedSessionStrategy();
        // activa para poder tener sesion
        return new RegisterSessionAuthenticationStrategy(
                new SessionRegistryImpl()
        );
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // versiones anteriores a spring security 6
        // http.authorizeRequests().anyRequest().authenticated();
        http.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests.anyRequest().authenticated()
        );
        return http.build();
    }

}
