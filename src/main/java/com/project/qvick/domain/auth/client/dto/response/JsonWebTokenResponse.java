package com.project.qvick.domain.auth.client.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.qvick.domain.user.domain.enums.UserRole;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record JsonWebTokenResponse(
        String accessToken,
        String refreshToken,
        UserRole userRole
){}