package com.project.qvick.domain.user.presentation.dto.request;

import com.project.qvick.domain.user.domain.enums.Approval;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.presentation.dto.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private Long id;
    private String name;
    private String email;
    private Approval approval;
    private UserRole userRole;

    public User toUser(){
        return User.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .approval(this.approval)
                .userRole(this.userRole)
                .build();
    }

}
