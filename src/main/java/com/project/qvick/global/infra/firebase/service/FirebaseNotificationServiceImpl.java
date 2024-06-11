package com.project.qvick.global.infra.firebase.service;

import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.Notification;
import com.project.qvick.global.infra.firebase.config.FirebaseNotificationConfig;
import com.project.qvick.global.infra.firebase.domain.repository.FirebaseTokenRepository;
import com.project.qvick.global.infra.firebase.dto.FirebaseNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class FirebaseNotificationServiceImpl implements FirebaseNotificationService {

    private final FirebaseTokenRepository firebaseTokenRepository;
    private final FirebaseNotificationConfig firebaseNotificationConfig;

    @Async
    public void sendNonCheckNotification(List<String> tokens) throws ExecutionException, InterruptedException {
        if (tokens.size() > 0)
            send(createMessage(tokens, createNotification(firebaseNotificationConfig.getNonCheckTitle(), firebaseNotificationConfig.getNonCheckMessage()), createApnsConfig()));
    }

    @Async
    public void sendNotification(FirebaseNotification firebaseNotification) throws ExecutionException, InterruptedException {
//        List<String> registrationTokens = firebaseNotification.getEmails().stream().filter(email -> hasKey(email)).map(email -> getToken(email)).toList();
//                if (registrationTokens.size() > 0)
//                    send(createMessage(registrationTokens, createNotification(firebaseNotification), createApnsConfig()));
    }

    private void send(MulticastMessage message) throws ExecutionException, InterruptedException {
        FirebaseMessaging.getInstance().sendEachForMulticastAsync(message).get();
    }

    private void send(Message message) throws ExecutionException, InterruptedException {
        FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private MulticastMessage createMessage(List<String> registrationTokens, com.google.firebase.messaging.Notification notification, ApnsConfig apnsConfig) {

        return MulticastMessage.builder()
                .setNotification(notification)
                .setApnsConfig(apnsConfig)
                .addAllTokens(registrationTokens)
                .build();
    }

    private ApnsConfig createApnsConfig() {
        return ApnsConfig.builder().setAps(Aps.builder().setSound("default").build()).build();
    }

    private Notification createNotification(String title, String message) {
        return com.google.firebase.messaging.Notification.builder()
                .setTitle(title)
                .setBody(message).build();
    }

    private Notification createNotification(FirebaseNotification firebaseNotification) {
        return com.google.firebase.messaging.Notification.builder()
                .setTitle(firebaseNotification.getTitle())
                .setBody(firebaseNotification.getMessage()).build();
    }

    public void saveToken(final String email, final String token) {
        if (StringUtils.hasText(token))
            firebaseTokenRepository.saveToken(email, token);
    }

    public void deleteToken(String email) {
        firebaseTokenRepository.deleteToken(email);
    }

    public boolean hasKey(String email) {
        return firebaseTokenRepository.hasKey(email);
    }

    public String getToken(String email) {
        return firebaseTokenRepository.getToken(email);
    }

}

