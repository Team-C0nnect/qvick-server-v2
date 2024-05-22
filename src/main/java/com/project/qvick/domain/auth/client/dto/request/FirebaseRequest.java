package com.project.qvick.domain.auth.client.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FirebaseRequest {

    @Schema(description = "FCM Token")
    private String fcmToken;

}
