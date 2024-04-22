package com.project.qvick.domain.auth.presentation.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminSignUpRequest {

    private String email;
    private String password;

}
