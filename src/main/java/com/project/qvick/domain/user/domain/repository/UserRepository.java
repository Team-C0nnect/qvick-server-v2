package com.project.qvick.domain.user.domain.repository;

import com.project.qvick.domain.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/** 유저 Repository */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
