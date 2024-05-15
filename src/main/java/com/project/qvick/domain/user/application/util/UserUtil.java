package com.project.qvick.domain.user.application.util;

import com.project.qvick.domain.user.domain.repository.jpa.UserRepository;
import com.project.qvick.domain.user.exception.UserExistException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import com.project.qvick.domain.user.mapper.UserMapper;
import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.global.common.repository.UserSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
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

    public User findUser(){
        return userRepository
                .findById(userSecurity.getUser().getId())
                .map(userMapper::toUser)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

}
