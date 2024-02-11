package com.project.qvick.domain.room.exception;

import com.project.qvick.domain.room.exception.error.RoomError;
import com.project.qvick.global.exception.BusinessException;

public class RoomNotFoundException extends BusinessException {

    public static final RoomNotFoundException EXCEPTION = new RoomNotFoundException();

    private RoomNotFoundException(){
        super(RoomError.ROOM_NOT_FOUND);
    }

}
