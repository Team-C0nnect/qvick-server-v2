package com.project.qvick.domain.user.service;

import com.project.qvick.domain.user.domain.enums.Approval;
import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.exception.UserForbiddenException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.UserAcceptRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    private final UserMapper mapper;

    /* 승격 승인자의 권한이 관리자거나, 선생님인 경우 승격 요청자의 권한을 유저로 올려줌*/
    @Override
    public void acceptSignUp(UserAcceptRequest request) {
        User user = repository.findById(request.getId()).map(mapper::toUser).orElseThrow(()->UserNotFoundException.EXCEPTION);
        if(request.getUserRole().equals(UserRole.ADMIN) || request.getUserRole().equals(UserRole.TEACHER)){
            User accptedUser = repository.findById(request.getUserId()).map(mapper::toUser).orElseThrow(()->UserNotFoundException.EXCEPTION);
            accptedUser.setUserRole(UserRole.USER);
            accptedUser.setApproval(Approval.ACCEPT);
            repository.save(mapper.toUpdate(accptedUser));
        }
        throw UserForbiddenException.EXCEPTION;
    }

    @Override
    public void rejectSignUp(UserAcceptRequest request) {
        User user = repository.findById(request.getId()).map(mapper::toUser).orElseThrow(()->UserNotFoundException.EXCEPTION);
        User rejectedUser = repository.findById(request.getUserId()).map(mapper::toUser).orElseThrow(()->UserNotFoundException.EXCEPTION);
        if((request.getUserRole().equals(UserRole.ADMIN) || request.getUserRole().equals(UserRole.TEACHER)) && rejectedUser.getUserRole().equals(UserRole.GUEST)){
            rejectedUser.setApproval(Approval.REJECT);
            repository.save(mapper.toUpdate(rejectedUser));
        }
        throw UserForbiddenException.EXCEPTION;
    }

}
