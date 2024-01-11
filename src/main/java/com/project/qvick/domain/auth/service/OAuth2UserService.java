package com.project.qvick.domain.auth.service;

import com.project.qvick.domain.auth.dto.request.AuthenticationRequest;
import com.project.qvick.domain.auth.dto.response.JsonWebTokenResponse;

public interface OAuth2UserService {
    JsonWebTokenResponse auth(AuthenticationRequest request);
    JsonWebTokenResponse refresh(String token);

}
