package com.project.qvick.domain.user.domain.repository.querydsl;

import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.UserApprovalPageRequest;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface UserQueryRepository {

    List<User> findWaitingUsers(UserApprovalPageRequest request);

    List<User> findAllUsers(PageRequest request);

}
