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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtExceptionFilter jwtExceptionFilter;

    private static final String USER = "ROLE_USER";
    private static final String TEACHER = "ROLE_TEACHER";
    private static final String ADMIN = "ROLE_ADMIN";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(handlingConfigures -> handlingConfigures.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/swagger-ui/**", "/v3/**").permitAll()
                                .requestMatchers("/terms/**").permitAll()
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers(POST,"/attendance/code").permitAll()

                                .requestMatchers("/outing-admin/**").hasAnyAuthority(ADMIN,TEACHER)
                                .requestMatchers(GET,"/attendance/list").hasAnyAuthority(ADMIN,TEACHER)
                                .requestMatchers("/sleepover-admin/**").hasAnyAuthority(ADMIN,TEACHER)
                                .requestMatchers(GET,"/user-admin/find-all").hasAnyAuthority(ADMIN,TEACHER)
                                .requestMatchers(GET,"/user-admin/search").hasAnyAuthority(ADMIN,TEACHER)

                                .requestMatchers(POST,"/attendance").hasAuthority(USER)
                                .requestMatchers(POST,"/outing").hasAuthority(USER)
                                .requestMatchers(POST,"/sleepover").hasAuthority(USER)
                                .requestMatchers(PATCH,"/user/stdId").hasAuthority(USER)
                                .requestMatchers(PATCH,"/user/room").hasAuthority(USER)

                                .requestMatchers("/school/**").hasAuthority(ADMIN)
                                .requestMatchers(PATCH,"/user-admin/approve").hasAuthority(ADMIN)
                                .requestMatchers(PATCH,"/user-admin/reject").hasAuthority(ADMIN)
                                .requestMatchers(GET,"/user-admin/await-user").hasAuthority(ADMIN)

                                .anyRequest().authenticated()
                )
                .addFilterAfter(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtExceptionFilter, JwtAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
