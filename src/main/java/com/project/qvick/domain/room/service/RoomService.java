package com.project.qvick.domain.room.service;

import com.project.qvick.domain.room.presentation.dto.Room;
import com.project.qvick.domain.room.presentation.dto.request.RoomRequest;

public interface RoomService {
    void roomRegister(RoomRequest request);

    Room findRoom(RoomRequest request);

    void roomEdit(RoomRequest request);

    void roomDelete(RoomRequest request);
}
