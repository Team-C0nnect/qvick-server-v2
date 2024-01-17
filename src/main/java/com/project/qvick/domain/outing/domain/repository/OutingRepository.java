package com.project.qvick.domain.outing.domain.repository;

import com.project.qvick.domain.outing.domain.OutingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OutingRepository extends JpaRepository<OutingEntity,Long> {

    Optional<OutingEntity> findById(Long outingId);

    Optional<OutingEntity> findByUserId(Long userId);

}
