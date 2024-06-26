package com.project.qvick.domain.user.application.service;

import com.project.qvick.domain.check.client.dto.request.CodeRequest;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.AdminPasswordEditRequest;
import com.project.qvick.domain.user.client.dto.request.AdminSetStatusRequest;
import com.project.qvick.domain.user.client.dto.request.PasswordEditRequest;
import com.project.qvick.domain.user.client.dto.request.RoomEditRequest;
import com.project.qvick.domain.user.client.dto.request.StdIdEditRequest;


public interface UserService {

    void editUserStdId(StdIdEditRequest request);

    void deleteUser();

    void editRoom(RoomEditRequest request);

    User findUser();

    void check(CodeRequest request);

    void editPassword(PasswordEditRequest request);

    void adminEditPassword(AdminPasswordEditRequest request);

    void adminDeleteUser(String email);

    boolean isChecked();

    void fixStatus(AdminSetStatusRequest setStatusRequest);

}
