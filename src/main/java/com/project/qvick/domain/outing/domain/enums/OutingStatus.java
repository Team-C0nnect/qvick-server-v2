package com.project.qvick.domain.outing.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OutingStatus {

    SLEEPOVER_ACCEPTED("ACCEPTED"),
    SLEEPOVER_REJECTED("REJECTED"),
    SLEEPOVER_WAITING("WAITING");
    private final String key;

}
