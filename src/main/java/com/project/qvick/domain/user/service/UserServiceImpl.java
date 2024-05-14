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
import com.project.qvick.global.common.repository.UserSecurity;
import com.project.qvick.global.common.util.user.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserSecurity userSecurity;
    private final UserUtil userUtil;

    @Override
    public void acceptSignUp(UserSignUpRequest request) {
        User user = findUser();
        if(user.getUserRole().equals(UserRole.ADMIN) || user.getUserRole().equals(UserRole.TEACHER)){
            user.setUserRole(UserRole.USER);
        }
        throw UserForbiddenException.EXCEPTION;
    }

    @Override
    public void rejectSignUp(UserSignUpRequest request) {
        User user  = findUser();
        if(user.getUserRole().equals(UserRole.GUEST)){
            userRepository.deleteById(request.getId());
        }
        throw UserForbiddenException.EXCEPTION;
    }

    @Override
    public void editUserStdId(StdIdEditRequest request) {
        User user = findUser();
        user.setStdId(request.getStdId());
        userRepository.save(userMapper.toEdit(user));
    }

    @Override
    public void deleteUser() {
        Long userId = userSecurity.getUser().getId();
        userUtil.userCheckById(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public void editRoom(RoomRequest request){
        User user = findUser();
        user.setRoom(request.getRoom());
        userRepository.save(userMapper.toEdit(user));
    }

    @Override
    public User findUser(){
        return userRepository
                .findById(userSecurity.getUser().getId())
                .map(userMapper::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

}
