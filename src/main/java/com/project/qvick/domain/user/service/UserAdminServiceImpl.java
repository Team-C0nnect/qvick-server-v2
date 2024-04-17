package com.project.qvick.domain.user.service;

import com.project.qvick.domain.user.domain.enums.UserRole;
import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.exception.UserForbiddenException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.RoomRequest;
import com.project.qvick.domain.user.presentation.dto.request.StdIdEditRequest;
import com.project.qvick.domain.user.presentation.dto.request.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAdminServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    /* 승격 승인자의 권한이 관리자거나, 선생님인 경우 승격 요청자의 권한을 유저로 올려줌*/
    @Override
    public void acceptSignUp(UserSignUpRequest request) {
        User user = userRepository.findById(request.getId()).map(userMapper::toUser).orElseThrow(()-> UserNotFoundException.EXCEPTION);
        if(user.getUserRole().equals(UserRole.ADMIN) || user.getUserRole().equals(UserRole.TEACHER)){
            user.setUserRole(UserRole.USER);
        }
        throw UserForbiddenException.EXCEPTION;
    }

    @Override
    public void rejectSignUp(UserSignUpRequest request) {
        User user = userRepository.findById(request.getId()).map(userMapper::toUser).orElseThrow(()->UserNotFoundException.EXCEPTION);
        if(user.getUserRole().equals(UserRole.GUEST)){
            userRepository.deleteById(request.getId());
        }
        throw UserForbiddenException.EXCEPTION;
    }

    @Override
    public void editUserStdId(StdIdEditRequest request) {}

    @Override
    public void deleteUser() {}

    @Override
    public void editRoom(RoomRequest request) {}

}
