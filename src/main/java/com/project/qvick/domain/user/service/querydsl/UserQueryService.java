package com.project.qvick.domain.user.service.querydsl;

import com.project.qvick.domain.user.dto.User;
import com.project.qvick.domain.user.dto.request.UserApprovalPageRequest;

import java.util.List;

public interface UserQueryService {

    List<User> findWaitingUsers(UserApprovalPageRequest request);

}
