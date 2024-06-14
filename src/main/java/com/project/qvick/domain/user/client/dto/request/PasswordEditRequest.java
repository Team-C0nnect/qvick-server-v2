package com.project.qvick.domain.user.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordEditRequest {

    private String oldPassword;
    private String newPassword;

}
