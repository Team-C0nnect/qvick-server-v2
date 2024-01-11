package com.project.qvick.domain.user.service.querydsl;

import com.project.qvick.domain.user.domain.repository.querydsl.UserQueryRepository;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.UserApprovalPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{

    private final UserQueryRepository movieQueryRepository;

    @Override
    public List<User> findWaitingUsers(UserApprovalPageRequest request) {
        return movieQueryRepository.findWaitingUsers(request);
    }

}
