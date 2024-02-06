package com.project.qvick.domain.user.mapper;

import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.domain.enums.Approval;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.global.infra.google.dto.OAuth2Attribute;
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

    public UserEntity createEntity(OAuth2Attribute oAuth2Attribute) {
        return UserEntity.builder()
                .email(oAuth2Attribute.getEmail())
                .name(oAuth2Attribute.getName())
                .approval(Approval.ACCEPT)
                .userRole(UserRole.USER)
                .build();
    }

}
