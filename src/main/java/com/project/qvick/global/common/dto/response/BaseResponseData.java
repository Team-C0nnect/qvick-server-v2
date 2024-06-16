package com.project.qvick.global.common.dto.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseResponseData<T> extends BaseResponse {

    private final T data;

    private BaseResponseData(HttpStatus status, String message, T data) {
        super(status.value(), message);
        this.data = data;
    }

    public static <T> BaseResponseData<T> of(HttpStatus status, String message, T data) {
        return new BaseResponseData<>(status, message, data);
    }

    public static <T> BaseResponseData<T> ok(String message, T data) {
        return new BaseResponseData<>(HttpStatus.OK, message, data);
    }

    public static <T> BaseResponseData<T> created(String message, T data) {
        return new BaseResponseData<>(HttpStatus.CREATED, message, data);
    }
}
