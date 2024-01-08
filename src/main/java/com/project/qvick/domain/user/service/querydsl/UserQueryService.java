package com.project.qvick.domain.user.service.querydsl;

import com.project.qvick.domain.user.dto.User;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface UserQueryService {

    List<User> findUsers(PageRequest request);

}
