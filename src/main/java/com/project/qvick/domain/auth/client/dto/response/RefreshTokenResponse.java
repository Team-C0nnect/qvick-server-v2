package com.project.qvick.domain.auth.client.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RefreshTokenResponse {

    private String accessToken;

}
