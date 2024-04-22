package com.project.qvick.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherSignUpRequest {

    private String email;
    private String password;
    private String name;
    private String phoneNum;

}
