package com.project.qvick.domain.room.domain.repository;

import com.project.qvick.domain.room.domain.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity,Long> {
}
