package com.project.qvick.domain.user.mapper;

import com.project.qvick.domain.auth.presentation.dto.request.AdminSignUpRequest;
import com.project.qvick.domain.user.domain.AdminEntity;
import com.project.qvick.domain.user.domain.enums.UserRole;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {

    public AdminEntity toEntity(AdminSignUpRequest request, String password) {
        return AdminEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(password)
                .userRole(UserRole.ADMIN)
                .build();
    }

}
