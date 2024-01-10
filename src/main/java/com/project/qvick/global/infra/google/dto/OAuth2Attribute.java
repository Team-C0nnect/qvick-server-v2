package com.project.qvick.global.infra.google.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuth2Attribute {

    /**로그인을 시도하는 사용자 요청의 정보*/
    private String email;
    private String email_verified;
    private String name;

}
