package com.project.qvick.global.security.jwt;

import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.global.annotation.Jwt;
import com.project.qvick.global.security.jwt.config.JwtProperties;
import com.project.qvick.global.security.jwt.enums.JwtType;
import com.project.qvick.global.security.jwt.exception.TokenErrorException;
import com.project.qvick.global.security.jwt.exception.TokenExpiredException;
import com.project.qvick.global.security.jwt.exception.TokenNotSupportException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Jwt
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;

    public String generateAccessToken(final String email, final UserRole userRole) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, JwtType.ACCESS)
                .setSubject(email)
                .claim("authority", userRole)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

    public String generateRefreshToken(final String email, final UserRole userRole) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, JwtType.REFRESH)
                .setSubject(email)
                .claim("authority", userRole)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExpiration()))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();
    }

}
