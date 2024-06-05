package com.project.qvick.domain.user.application.query;

import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.UserSearchRequest;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface UserQueryService {

    List<User> userList(PageRequest pageRequest);

    List<User> userSearch(UserSearchRequest searchRequest);
}
