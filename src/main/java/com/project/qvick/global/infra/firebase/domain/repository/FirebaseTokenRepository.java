package com.project.qvick.global.infra.firebase.domain.repository;

public interface FirebaseTokenRepository {

    void saveToken(final String email, final String token);

    String getToken(final String email);

    void deleteToken(final String email);

    boolean hasKey(final String email);

}
