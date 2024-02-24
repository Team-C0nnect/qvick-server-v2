package com.project.qvick.global.infra.firebase.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import com.project.qvick.global.infra.firebase.dto.FirebaseNotification;

public interface FirebaseNotificationService {

    void sendNonCheckNotification(List<String> tokens) throws ExecutionException, InterruptedException;

    void sendNotification(FirebaseNotification firebaseNotification) throws ExecutionException, InterruptedException;

    void saveToken(final String email, final String token);

    boolean hasKey(String email);

    String getToken(String email);

}