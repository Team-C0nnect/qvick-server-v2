package com.project.qvick.domain.user.domain;

import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.global.common.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/** 유저 Entity */
@Entity
@Getter
@SuperBuilder
@Table(name = "tb_user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,
            unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,
            unique = true,
            length = 4)
    private String stdId;

    @Column(nullable = false,
            length = 3)
    private String room;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(nullable = false)
    private boolean isChecked;

    @Column(nullable = false)
    private LocalDateTime checkedDate;

    @Scheduled(cron = "0 0 7 * * *")
    public void dailyUpdate() {
        // 매일 업데이트할 값 설정
        isChecked = false;
    }

}
