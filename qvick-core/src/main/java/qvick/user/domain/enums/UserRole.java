package qvick.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {

    ADMIN("ROLE_ADMIN"),
    TEACHER("ROLE_TEACHER"),
    GUEST("ROLE_GUEST"),
    USER("ROLE_USER");

    private final String key;

}
