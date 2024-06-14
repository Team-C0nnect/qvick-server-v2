package com.project.qvick.domain.user.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminPasswordEditRequest extends PasswordEditRequest {

    private String email;

}
