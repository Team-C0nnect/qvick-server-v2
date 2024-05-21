package com.project.qvick.domain.user.application.service;

import com.project.qvick.domain.user.client.dto.request.RoomRequest;
import com.project.qvick.domain.user.client.dto.request.StdIdEditRequest;
import com.project.qvick.domain.user.client.dto.request.UserSignUpRequest;


public interface UserService {

    void acceptSignUp(UserSignUpRequest request);

    void rejectSignUp(UserSignUpRequest request);

    void editUserStdId(StdIdEditRequest request);

    void deleteUser();

    void editRoom(RoomRequest request);

}
