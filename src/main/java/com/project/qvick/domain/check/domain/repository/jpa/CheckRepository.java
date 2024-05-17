package com.project.qvick.domain.check.domain.repository.jpa;

import com.project.qvick.domain.check.domain.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface CheckRepository extends JpaRepository<CheckEntity,Long> {

    Optional<CheckEntity> findByUserIdAndCheckedDate(Long userId, LocalDateTime checkDate);

    Optional<CheckEntity>findByUserId(Long userId);

    boolean existsById(Long id);

}
