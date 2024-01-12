package com.project.qvick.domain.student.domain.repository;

import com.project.qvick.domain.student.domain.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
