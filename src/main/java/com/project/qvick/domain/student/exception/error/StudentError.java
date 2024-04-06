package com.project.qvick.domain.student.exception.error;

import com.project.qvick.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum StudentError implements ErrorProperty {

    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND, "학생을 찾을 수 없습니다."),
    STUDENT_EXIST(HttpStatus.CONFLICT, "이미 존재하는 학생입니다.");

    private final HttpStatus status;
    private final String message;

}