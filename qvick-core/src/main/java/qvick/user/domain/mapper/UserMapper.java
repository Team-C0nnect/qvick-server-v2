package qvick.user.domain.mapper;

import org.springframework.stereotype.Component;
import qvick.auth.request.SignUpRequest;
import qvick.user.domain.UserEntity;
import qvick.user.domain.enums.UserRole;
import qvick.user.dto.User;

import java.time.LocalDateTime;

@Component
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
                .name(signUpRequest.name())
                .email(signUpRequest.email())
                .password(password)
                .stdId(signUpRequest.stdId())
                .room(signUpRequest.room())
                .userRole(UserRole.USER)
                .isChecked(false)
                .checkedDate(LocalDateTime.now())
                .build();
    }

    public UserEntity toCreateAdmin(SignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .name(signUpRequest.name())
                .email(signUpRequest.email())
                .password(password)
                .stdId(signUpRequest.stdId())
                .room(signUpRequest.room())
                .userRole(UserRole.ADMIN)
                .isChecked(true)
                .checkedDate(null)
                .build();
    }

    public UserEntity toCreateTeacher(SignUpRequest signUpRequest, String password){
        return UserEntity.builder()
                .name(signUpRequest.name())
                .email(signUpRequest.email())
                .password(password)
                .stdId(signUpRequest.stdId())
                .room(signUpRequest.room())
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
