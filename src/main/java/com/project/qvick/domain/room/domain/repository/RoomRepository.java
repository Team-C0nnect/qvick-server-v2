package com.project.qvick.domain.room.domain.repository;

import com.project.qvick.domain.room.domain.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomEntity,Long> {

    Optional<RoomEntity>findByRoomId(String roomId);

    Optional<RoomEntity>findByUserId(Long userId);

}
