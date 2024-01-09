package com.project.qvick.domain.user.domain.repository.querydsl;


import com.project.qvick.domain.user.dto.User;
import com.project.qvick.domain.user.dto.request.UserApprovalPageRequest;

import java.util.List;

public interface UserQueryRepository {

    List<User> findWaitingUsers(UserApprovalPageRequest request);

}
