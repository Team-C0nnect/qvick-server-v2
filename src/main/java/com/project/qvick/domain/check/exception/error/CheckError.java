package com.project.qvick.domain.check.exception.error;

import com.project.qvick.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CheckError implements ErrorProperty {

    CHECK_CONFLICT(HttpStatus.CONFLICT, "이미 출석 체크가 완료된 회원입니다."),
    CHECK_CODE_EXPIRATION(HttpStatus.BAD_REQUEST,"만료된 QR코드입니다."),
    CHECK_ERROR(HttpStatus.BAD_REQUEST, "잘못된 QR코드입니다");

    private final HttpStatus status;
    private final String message;

}

