package com.project.qvick.domain.user.service;

import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.RoomRequest;
import com.project.qvick.domain.user.presentation.dto.request.StdIdEditRequest;
import com.project.qvick.domain.user.presentation.dto.request.UserSignUpRequest;


public interface UserService {

    void acceptSignUp(UserSignUpRequest request);

    void rejectSignUp(UserSignUpRequest request);

    User findUser();

    void editUserStdId(StdIdEditRequest request);

    void deleteUser();

    void editRoom(RoomRequest request);

}
