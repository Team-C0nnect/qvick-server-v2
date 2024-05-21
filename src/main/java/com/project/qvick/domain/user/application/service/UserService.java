package com.project.qvick.domain.user.application.service;

import com.project.qvick.domain.user.client.dto.request.RoomRequest;
import com.project.qvick.domain.user.client.dto.request.StdIdEditRequest;


public interface UserService {

    void editUserStdId(StdIdEditRequest request);

    void deleteUser();

    void editRoom(RoomRequest request);

}
