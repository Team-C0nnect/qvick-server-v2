package com.project.qvick.domain.sleepover.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SleepoverStatus {

    SLEEPOVER_ACCEPTED("ACCEPTED"),
    SLEEPOVER_NOT_ACCEPTED("NOT_ACCEPTED");
    private final String key;

}