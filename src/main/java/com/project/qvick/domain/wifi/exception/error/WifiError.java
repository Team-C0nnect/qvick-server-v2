package com.project.qvick.domain.wifi.exception.error;

import com.project.qvick.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum WifiError implements ErrorProperty {

    WIFI_CONFLICT(HttpStatus.CONFLICT,"와이파이가 이미 존재합니다"),
    WIFI_NOT_FOUND(HttpStatus.NOT_FOUND,"와이파이를 찾을 수 없습니다");

    private final HttpStatus status;
    private final String message;

}
