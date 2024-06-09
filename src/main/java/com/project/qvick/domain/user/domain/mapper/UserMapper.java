package com.project.qvick.domain.user.domain.mapper;

import com.project.qvick.domain.auth.client.dto.request.SignUpRequest;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.global.annotation.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public class UserMapper {

    public User toUser(UserEntity entity){
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .userRole(entity.getUserRole())
                .email(entity.getEmail())
                .stdId(entity.getStdId())
                .room(entity.getRoom())
                .build();
    }

    public UserEntity toCreate(SignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(password)
                .stdId(signUpRequest.getStdId())
                .room(signUpRequest.getRoom())
                .userRole(UserRole.USER)
                .build();
    }

    public UserEntity toCreateAdmin(SignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(password)
                .stdId(signUpRequest.getStdId())
                .room(signUpRequest.getRoom())
                .userRole(UserRole.ADMIN)
                .build();
    }

    public UserEntity toCreateTeacher(SignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(password)
                .stdId(signUpRequest.getStdId())
                .room(signUpRequest.getRoom())
                .userRole(UserRole.TEACHER)
                .build();
    }

    public UserEntity toEdit(User user){
        return UserEntity.builder()
                .stdId(user.getStdId())
                .room(user.getRoom())
                .userRole(UserRole.USER)
                .build();
    }

}
