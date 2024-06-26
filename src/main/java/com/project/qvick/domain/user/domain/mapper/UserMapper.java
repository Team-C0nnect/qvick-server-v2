package com.project.qvick.domain.user.domain.mapper;

import com.project.qvick.domain.auth.client.dto.request.SignUpRequest;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.global.annotation.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Mapper
public class UserMapper {

    public User toUser(UserEntity entity){
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .password(entity.getPassword())
                .userRole(entity.getUserRole())
                .email(entity.getEmail())
                .stdId(entity.getStdId())
                .room(entity.getRoom())
                .isChecked(entity.isChecked())
                .checkedDate(entity.getCheckedDate())
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
                .isChecked(false)
                .checkedDate(LocalDateTime.now())
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
                .isChecked(true)
                .checkedDate(null)
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
                .isChecked(true)
                .checkedDate(null)
                .build();
    }

    public UserEntity toEdit(User user){
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .stdId(user.getStdId())
                .room(user.getRoom())
                .userRole(user.getUserRole())
                .isChecked(user.isChecked())
                .checkedDate(user.getCheckedDate())
                .build();
    }

}
