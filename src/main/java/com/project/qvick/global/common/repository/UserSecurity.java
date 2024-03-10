package com.project.qvick.global.common.repository;

import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.presentation.dto.User;

public interface UserSecurity {

    User getUser();

}