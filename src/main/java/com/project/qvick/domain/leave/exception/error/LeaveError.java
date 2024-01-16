package com.project.qvick.domain.leave.exception.error;

import com.project.qvick.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
/*
 * 퇴사주 도메인 예외처리
 */
public enum LeaveError implements ErrorProperty {

    LEAVE_CONFLICT(HttpStatus.CONFLICT,"이미 설정 되었습니다."),
    LEAVE_NO_CONTENT(HttpStatus.NO_CONTENT,"이미 처리된 삭제 요청입니다.");

    private final HttpStatus status;
    private final String message;

}

