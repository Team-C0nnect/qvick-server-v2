package com.project.qvick.domain.user.domain.repository.querydsl;


import com.project.qvick.domain.user.dto.User;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface UserQueryRepository {

    List<User> findUsers(PageRequest request);

}
