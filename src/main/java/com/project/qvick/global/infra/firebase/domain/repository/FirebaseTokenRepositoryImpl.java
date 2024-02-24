package com.project.qvick.global.infra.firebase.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FirebaseTokenRepositoryImpl implements FirebaseTokenRepository {

    private final StringRedisTemplate redisTemplate;

    public void saveToken(final String email, final String token) {
        redisTemplate.opsForValue().set(email, token);
    }

    public String getToken(final String email) {
        return redisTemplate.opsForValue().get(email);
    }

    public void deleteToken(final String email) {
        redisTemplate.delete(email);
    }

    public boolean hasKey(final String email) {
        return redisTemplate.hasKey(email);
    }

}
