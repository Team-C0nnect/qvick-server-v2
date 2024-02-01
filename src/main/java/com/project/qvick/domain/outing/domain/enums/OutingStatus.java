package com.project.qvick.domain.outing.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OutingStatus {

    OUTING_ACCEPTED("ACCEPTED"),
    OUTING_NOT_ACCEPTED("NOT_ACCEPTED");

    private final String key;

}
