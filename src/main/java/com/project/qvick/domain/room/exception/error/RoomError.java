package com.project.qvick.domain.room.exception.error;

import com.project.qvick.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum RoomError implements ErrorProperty {

    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND,"해당 호실을 찾을 수 없습니다."),
    ROOM_EXIST(HttpStatus.CONFLICT,"이미 배정된 호실입니다.");

    private final HttpStatus status;
    private final String message;

}
