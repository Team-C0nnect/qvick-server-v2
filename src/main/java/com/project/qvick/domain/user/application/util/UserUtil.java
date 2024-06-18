package com.project.qvick.domain.user.application.util;

import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.domain.mapper.UserMapper;
import com.project.qvick.domain.user.domain.repository.jpa.UserRepository;
import com.project.qvick.domain.user.exception.UserExistException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.global.annotation.Util;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;

@Util
@RequiredArgsConstructor
public class UserUtil {

    private final UserRepository userRepository;
    private final UserSecurity userSecurity;
    private final UserMapper userMapper;

    public void userExistCheck(String email){
        if (userRepository.findByEmail(email).isPresent()){
            throw UserExistException.EXCEPTION;
        }
    }

    public User getUser(){
        return userRepository
                .findById(userSecurity.getUser().getId())
                .map(userMapper::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public User findUserByStdId(String stdId){
        return userRepository
                .findByStdId(stdId)
                .map(userMapper::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public User findUserByEmail(String email){
        return userRepository
                .findByEmail(email)
                .map(userMapper::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

}
