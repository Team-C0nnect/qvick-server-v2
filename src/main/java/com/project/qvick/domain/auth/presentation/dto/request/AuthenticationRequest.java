package com.project.qvick.domain.auth.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthenticationRequest {

    @Schema(description = "Google idToken")
    @NotBlank(message = "")
    private String idToken;

//    @Schema(description = "FCM Token")
//    private String fcmToken;

}
