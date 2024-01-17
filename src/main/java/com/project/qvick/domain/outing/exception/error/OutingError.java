package com.project.qvick.domain.outing.exception.error;

import com.google.api.Http;
import com.project.qvick.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum OutingError implements ErrorProperty {

    OUTING_CONFLICT(HttpStatus.CONFLICT,"이미 대기중인 외출 요청이 있습니다."),
    OUTING_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 외출 요청을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

}
