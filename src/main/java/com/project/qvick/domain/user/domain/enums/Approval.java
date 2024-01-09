package com.project.qvick.domain.user.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Approval {

    WAIT("SIGN_WAIT"),
    ACCEPT("SIGN_ACCEPTED"),
    REJECT("SIGN_REJECTED");

    private final String key;

}
