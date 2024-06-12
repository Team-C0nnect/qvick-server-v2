package com.project.qvick.domain.check.domain.repository.jpa;

import com.project.qvick.domain.check.domain.CheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<CheckEntity, Long> {
}
