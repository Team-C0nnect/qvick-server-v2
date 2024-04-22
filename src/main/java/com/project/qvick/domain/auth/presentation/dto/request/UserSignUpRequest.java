package com.project.qvick.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpRequest {

    private String name;
    private String email;
    private String phoneNum;
    private String password;
    private String stdId;
    private String room;

}
