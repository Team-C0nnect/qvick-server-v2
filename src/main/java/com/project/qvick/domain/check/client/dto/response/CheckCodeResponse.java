package com.project.qvick.domain.check.client.dto.response;

import lombok.Builder;

@Builder
public record CheckCodeResponse(
        String code
){}