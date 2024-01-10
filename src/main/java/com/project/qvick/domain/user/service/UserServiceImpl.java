package com.project.qvick.domain.user.service;

import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.domain.exception.UserForbiddenException;
import com.project.qvick.domain.user.domain.exception.UserNotFoundException;
import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.dto.User;
import com.project.qvick.domain.user.dto.request.UserRequest;
import com.project.qvick.domain.user.dto.request.UserSignUpRequest;
import com.project.qvick.domain.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    /* 승격 승인자의 권한이 관리자거나, 선생님인 경우 승격 요청자의 권한을 유저로 올려줌*/
    @Override
    public void acceptSignUp(UserSignUpRequest request) {
        User user = repository.findById(request.getId()).map(mapper::toUser).orElseThrow(()->UserNotFoundException.EXCEPTION);
        if(user.getUserRole().equals(UserRole.ADMIN) || user.getUserRole().equals(UserRole.TEACHER)){
            user.setUserRole(UserRole.USER);
        }
        throw UserForbiddenException.EXCEPTION;
    }

    @Override
    public void register(UserRequest request) {

    }

    @Override
    public void rejectSignUp(UserSignUpRequest request) {
        User user = repository.findById(request.getId()).map(mapper::toUser).orElseThrow(()->UserNotFoundException.EXCEPTION);
        if(user.getUserRole().equals(UserRole.GUEST)){
            repository.deleteById(request.getId());
        }
        throw UserForbiddenException.EXCEPTION;
    }


}
