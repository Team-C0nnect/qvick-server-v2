package com.project.qvick.domain.user.domain.repository.jpa;

import com.project.qvick.domain.user.domain.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/** 유저 Repository */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByStdId(String stdId);

    @Transactional(rollbackOn = Exception.class)
    void deleteByEmail(String email);

}
