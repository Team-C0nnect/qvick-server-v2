package com.project.qvick.domain.user.domain.repository.query;


import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.UserSearchRequest;
import com.project.qvick.global.common.client.dto.request.PageRequest;

import java.util.List;

public interface UserQueryRepository {

    List<User> userList(PageRequest request);

    List<User>userSearch(UserSearchRequest request);

    List<User>studentList(PageRequest request);

    List<User> checkUsers(PageRequest request);

    List<User> nonCheckUsers(PageRequest request);

    void updateChecked();

}
