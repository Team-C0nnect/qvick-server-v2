package com.project.qvick.domain.user.domain.repository.querydsl;


import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.UserApprovalPageRequest;

import java.util.List;

public interface UserQueryRepository {

    List<User> findWaitingUsers(UserApprovalPageRequest request);

}
