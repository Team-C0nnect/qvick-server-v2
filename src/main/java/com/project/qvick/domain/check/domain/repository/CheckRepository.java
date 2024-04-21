package com.project.qvick.domain.check.domain.repository;

import com.project.qvick.domain.check.domain.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CheckRepository extends JpaRepository<CheckEntity,Long> {

    Optional<CheckEntity> findByUserIdAndCheckedDate(Long userId, LocalDate checkDate);

    Optional<CheckEntity>findByUserId(Long userId);

    boolean existsById(Long id);

}
