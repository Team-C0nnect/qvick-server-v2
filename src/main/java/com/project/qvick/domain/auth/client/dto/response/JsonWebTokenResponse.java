package com.project.qvick.domain.auth.client.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.qvick.domain.user.domain.enums.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JsonWebTokenResponse {

    private String accessToken;
    private String refreshToken;
    private UserRole userRole;

}

