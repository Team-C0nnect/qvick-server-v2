package com.project.qvick.domain.room.exception;

import com.project.qvick.domain.room.exception.error.RoomError;
import com.project.qvick.global.exception.BusinessException;

public class RoomExistException extends BusinessException {

    public static final RoomExistException EXCEPTION = new RoomExistException();

    private RoomExistException(){
        super(RoomError.ROOM_EXIST);
    }

}
