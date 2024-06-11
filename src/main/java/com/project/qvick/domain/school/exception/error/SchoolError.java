package com.project.qvick.domain.school.exception.error;

import com.project.qvick.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SchoolError implements ErrorProperty {

    SCHOOL_NOT_FOUND(HttpStatus.NOT_FOUND,"등록되지 않은 학교입니다"),
    SCHOOL_EXIST(HttpStatus.CONFLICT, "이미 등록된 학교입니다");

    private final HttpStatus status;
    private final String message;

}
