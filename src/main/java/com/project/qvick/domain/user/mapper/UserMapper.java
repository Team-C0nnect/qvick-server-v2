package com.project.qvick.domain.user.mapper;

import com.project.qvick.domain.auth.presentation.dto.request.AdminSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.request.TeacherSignUpRequest;
import com.project.qvick.domain.auth.presentation.dto.request.UserSignUpRequest;
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
                .stdId(entity.getStdId())
                .approval(entity.getApproval())
                .build();
    }

    public UserEntity toCreateUser(UserSignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(password)
                .stdId(signUpRequest.getStdId())
                .room(signUpRequest.getRoom())
                .approval(Approval.ACCEPT)
                .userRole(UserRole.USER)
                .build();
    }

    public UserEntity toCreateTeacher(TeacherSignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .phoneNum(signUpRequest.getPhoneNum())
                .password(password)
                .approval(Approval.ACCEPT)
                .userRole(UserRole.TEACHER)
                .build();
    }

    public UserEntity toCreateAdmin(AdminSignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .email(signUpRequest.getEmail())
                .password(password)
                .approval(Approval.ACCEPT)
                .userRole(UserRole.ADMIN)
                .build();
    }

    public UserEntity toEdit(User user){
        return UserEntity.builder()
                .stdId(user.getStdId())
                .room(user.getRoom())
                .approval(Approval.ACCEPT)
                .userRole(UserRole.USER)
                .build();
    }

}
