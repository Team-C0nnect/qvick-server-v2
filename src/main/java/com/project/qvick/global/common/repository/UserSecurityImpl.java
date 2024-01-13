package com.project.qvick.global.common.repository;

import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.global.security.auth.principal.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserSecurityImpl implements UserSecurity {

    @Override
    public User getUser() {
        return ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }

}