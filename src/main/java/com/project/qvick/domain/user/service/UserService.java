package com.project.qvick.domain.user.service;

import com.project.qvick.domain.user.dto.request.UserRequest;
import com.project.qvick.domain.user.dto.request.UserSignUpRequest;

public interface UserService {

    void acceptSignUp(UserSignUpRequest request);

    void register(UserRequest request);

    void rejectSignUp(UserSignUpRequest request);

}
