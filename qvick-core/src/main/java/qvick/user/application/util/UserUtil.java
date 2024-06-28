package qvick.user.application.util;

import lombok.RequiredArgsConstructor;
import qvick.annotation.Util;
import qvick.common.repository.UserSecurity;
import qvick.user.domain.mapper.UserMapper;
import qvick.user.domain.repository.jpa.UserRepository;
import qvick.user.dto.User;
import qvick.user.exception.UserExistException;
import qvick.user.exception.UserNotFoundException;

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
