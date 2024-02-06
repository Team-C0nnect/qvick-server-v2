package com.project.qvick.domain.room.domain;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.project.qvick.global.entity.BaseTimeEntity;
import io.micrometer.core.annotation.Counted;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.checkerframework.checker.units.qual.C;

@Entity
public class RoomEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column(nullable = false)
    private String roomId;

}
