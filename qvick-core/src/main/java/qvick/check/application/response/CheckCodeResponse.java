package qvick.check.application.response;

import lombok.Builder;

@Builder
public record CheckCodeResponse(
        String code
){}