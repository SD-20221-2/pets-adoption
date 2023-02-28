package br.ufg.petsadoption.config;

import br.ufg.petsadoption.services.JWTService;
import br.ufg.petsadoption.services.UserService;
import br.ufg.petsadoption.services.impl.JWTAuthenticationFilterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final AuthenticationEntryPoint entryPoint;
    private final UserService userService;
    private final JWTService jwtService;

    public SecurityConfiguration(AuthenticationEntryPoint entryPoint, UserService userService, JWTService jwtService) {
        this.entryPoint = entryPoint;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().exceptionHandling()
                .authenticationEntryPoint(entryPoint)
                .and().authorizeHttpRequests(request -> request
                        .requestMatchers(
                                "/h2-console/**",
                                "/api/v1/auth/login",
                                "/api/v1/auth/create"
                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .addFilterBefore(
                        new JWTAuthenticationFilterImpl(userService, jwtService),
                        UsernamePasswordAuthenticationFilter.class
                )
                .csrf().disable().cors().and().headers().frameOptions().disable();

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder)
                .and().build();
    }

}
