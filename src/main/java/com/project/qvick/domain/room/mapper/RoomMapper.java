package com.project.qvick.domain.room.mapper;

import com.project.qvick.domain.room.domain.RoomEntity;
import com.project.qvick.domain.room.presentation.dto.Room;
import com.project.qvick.domain.student.domain.StudentEntity;
import com.project.qvick.domain.student.presentation.dto.Student;
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

    public RoomEntity toCreate(String roomId){
        return RoomEntity.builder()
                .roomId(roomId)
                .build();
    }

}
