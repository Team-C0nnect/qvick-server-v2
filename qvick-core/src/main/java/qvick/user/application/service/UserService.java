package qvick.user.application.service;

import qvick.check.request.CodeRequest;
import qvick.user.dto.User;
import qvick.user.request.AdminPasswordEditRequest;
import qvick.user.request.AdminSetStatusRequest;
import qvick.user.request.PasswordEditRequest;
import qvick.user.request.RoomEditRequest;
import qvick.user.request.StdIdEditRequest;

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
