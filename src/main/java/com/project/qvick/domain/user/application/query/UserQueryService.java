package com.project.qvick.domain.user.application.query;

import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.SearchRequest;
import com.project.qvick.domain.user.client.dto.request.UserApprovalPageRequest;
import com.project.qvick.domain.user.client.dto.response.UserPageResponse;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface UserQueryService {

    List<UserPageResponse> findWaitingUsers(UserApprovalPageRequest request);

    List<User> userList(PageRequest pageRequest);

    List<User> userSearch(SearchRequest searchRequest);
}
