package com.project.qvick.global.common.util.user;

import com.project.qvick.domain.user.domain.repository.UserRepository;
import com.project.qvick.domain.user.exception.UserExistException;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtil {

    private final UserRepository userRepository;

    public void userExistCheck(String email){
        if (userRepository.findByEmail(email).isPresent()){
            throw UserExistException.EXCEPTION;
        }
    }

    public void userCheck(String email){
        if (userRepository.findByEmail(email).isEmpty()){
            throw UserNotFoundException.EXCEPTION;
        }
    }

    public void userCheckById(Long id){
        if (userRepository.findById(id).isEmpty()){
            throw UserNotFoundException.EXCEPTION;
        }
    }

}
