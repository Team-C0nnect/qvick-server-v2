package com.project.qvick.domain.user.presentation.dto.request;

import com.project.qvick.domain.user.domain.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAcceptRequest {

    private Long id;
    private Long userId;
    private UserRole userRole;

}
