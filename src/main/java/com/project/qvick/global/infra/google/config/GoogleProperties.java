package com.project.qvick.global.infra.google.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**구글 토큰 정보 설정*/
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.security.oauth2.client.provider.google")
public class GoogleProperties {

    private String tokenInfo;

}
