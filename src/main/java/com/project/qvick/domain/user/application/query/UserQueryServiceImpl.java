package com.project.qvick.domain.user.application.query;

import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.SearchRequest;
import com.project.qvick.domain.user.presentation.dto.request.UserApprovalPageRequest;
import com.project.qvick.domain.user.domain.repository.query.UserQueryRepository;
import com.project.qvick.domain.user.presentation.dto.response.UserPageResponse;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{

    private final UserQueryRepository userQueryRepository;

    @Override
    public List<UserPageResponse> findWaitingUsers(UserApprovalPageRequest request) {
        return userQueryRepository.findWaitingUsers(request);
    }

    @Override
    public List<User> userList(PageRequest pageRequest){
        return userQueryRepository.userList(pageRequest);
    }

    @Override
    public List<User> userSearch(SearchRequest searchRequest){
        return userQueryRepository.userSearch(searchRequest);
    }

}