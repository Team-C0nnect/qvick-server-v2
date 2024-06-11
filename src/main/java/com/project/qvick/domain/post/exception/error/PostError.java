package com.project.qvick.domain.post.exception.error;

import com.project.qvick.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostError implements ErrorProperty {

    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."),
    POST_EXIST(HttpStatus.CONFLICT, "이미 처리된 게시글입니다.");

    private final HttpStatus status;
    private final String message;

}
