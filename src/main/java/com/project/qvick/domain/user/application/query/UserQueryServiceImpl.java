package com.project.qvick.domain.user.application.query;

import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.UserSearchRequest;
import com.project.qvick.domain.user.domain.repository.query.UserQueryRepository;
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
    public List<User> userList(PageRequest pageRequest){
        return userQueryRepository.userList(pageRequest);
    }

    @Override
    public List<User> userSearch(UserSearchRequest searchRequest){
        return userQueryRepository.userSearch(searchRequest);
    }

}