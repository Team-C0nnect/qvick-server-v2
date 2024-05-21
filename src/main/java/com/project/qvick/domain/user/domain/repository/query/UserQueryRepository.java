package com.project.qvick.domain.user.domain.repository.query;


import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.SearchRequest;
import com.project.qvick.domain.user.client.dto.request.UserApprovalPageRequest;
import com.project.qvick.domain.user.client.dto.response.UserPageResponse;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface UserQueryRepository {

    List<UserPageResponse> findWaitingUsers(UserApprovalPageRequest request);

    List<User> userList(PageRequest request);

    List<User>userSearch(SearchRequest request);

}
