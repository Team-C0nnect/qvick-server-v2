package com.project.qvick.domain.outing.domain;

import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import com.project.qvick.global.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_Outing")
public class OutingEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column(nullable=false)
    private LocalDateTime startDateTime;

    @Column(nullable=false)
    private LocalDateTime endDateTime;

    @Column(nullable = false)
    private String reason;

    @Column
    private OutingStatus approval;

}
