package com.project.qvick.global.infra.google.service;

import com.project.qvick.global.infra.google.dto.OAuth2Attribute;

public interface GoogleService {
    OAuth2Attribute getTokenInfo(String idToken);

}
