package com.project.qvick.domain.user.mapper;

import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.domain.enums.Approval;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.dto.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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

    public UserEntity toCreate(User user){
        return UserEntity.builder()
                .name(user.getName())
                .email(user.getEmail())
                .userRole(UserRole.GUEST)
                .approval(Approval.WAIT)
                .build();
    }

}
