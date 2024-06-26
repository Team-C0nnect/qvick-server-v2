package com.project.qvick.domain.user.client.dto.request;

import lombok.Getter;

@Getter
public class AdminSetStatusRequest {
    private String email;
    private Long status;
}
