package com.project.qvick.global.config;

import com.project.qvick.global.security.jwt.filter.JwtAuthenticationFilter;
import com.project.qvick.global.security.jwt.filter.JwtExceptionFilter;
import com.project.qvick.global.security.jwt.handler.JwtAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtExceptionFilter jwtExceptionFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(handlingConfigures -> handlingConfigures.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/swagger-ui/**", "/v3/**").permitAll()
                                .requestMatchers("/auth/sign-up").permitAll()
                                .requestMatchers("/auth/sign-in").permitAll()
                                .requestMatchers("/auth/sign-in/admin").hasAnyAuthority("ADMIN")
                                .requestMatchers("/auth/sign-in/teacher").hasAnyAuthority("TEACHER")
                                .requestMatchers("/terms/**").permitAll()
                                .requestMatchers("/user-admin/**").hasAnyAuthority("ADMIN","TEACHER")
                                .requestMatchers("/outing-admin/**").hasAnyAuthority("ADMIN","TEACHER")
                                .requestMatchers("/attendance/list").hasAnyAuthority("ADMIN","TEACHER")
                                .requestMatchers("/attendance/code").hasAnyAuthority("ADMIN","TEACHER")
                                .requestMatchers("/sleepover-admin/**").hasAnyAuthority("ADMIN","TEACHER")
                                .requestMatchers("/school/**").hasAnyAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtExceptionFilter, JwtAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
