package com.project.qvick.domain.school.domain.repository.jpa;

import com.project.qvick.domain.school.domain.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

    Optional<SchoolEntity>findBySchoolName(String schoolName);

}
