package com.project.qvick.domain.sleepover.domain.repository.jpa;

import com.project.qvick.domain.sleepover.domain.SleepoverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SleepoverRepository extends JpaRepository<SleepoverEntity,Long> {

    Optional<SleepoverEntity> findById(Long sleepoverId);

    Optional<SleepoverEntity> findByUserId(Long userId);

}