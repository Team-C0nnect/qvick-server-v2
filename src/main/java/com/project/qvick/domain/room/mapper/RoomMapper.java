package com.project.qvick.domain.room.mapper;

import com.project.qvick.domain.room.domain.RoomEntity;
import com.project.qvick.domain.room.presentation.dto.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public Room toRoom(RoomEntity entity){
        return Room
                .builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .roomId(entity.getRoomId())
                .build();
    }

    public RoomEntity toCreate(Long userId, String roomId){
        return RoomEntity.builder()
                .userId(userId)
                .roomId(roomId)
                .build();
    }

}
