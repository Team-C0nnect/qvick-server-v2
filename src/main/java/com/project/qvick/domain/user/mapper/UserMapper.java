package com.project.qvick.domain.user.mapper;

import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.domain.enums.Approval;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.presentation.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(UserEntity entity){
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .userRole(entity.getUserRole())
                .email(entity.getEmail())
                .approval(entity.getApproval())
                .build();
    }

    public UserEntity toCreate(String name, String email, String password){
        return UserEntity.builder()
                .name(name)
                .email(email)
                .password(password)
                .approval(Approval.ACCEPT)
                .userRole(UserRole.USER)
                .build();
    }

}
