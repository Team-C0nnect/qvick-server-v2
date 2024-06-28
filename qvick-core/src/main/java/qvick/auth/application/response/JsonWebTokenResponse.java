package qvick.auth.application.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import qvick.user.domain.enums.UserRole;

@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record JsonWebTokenResponse(
        String accessToken,
        String refreshToken,
        UserRole userRole
){}