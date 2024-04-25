package com.project.qvick.domain.user.domain.repository;

import com.project.qvick.domain.user.domain.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

    Optional<AdminEntity> findByEmail(String email);

    AdminEntity getByEmail(String email);

}
