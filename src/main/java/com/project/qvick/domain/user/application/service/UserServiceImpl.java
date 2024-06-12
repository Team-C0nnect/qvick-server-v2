package com.project.qvick.domain.user.application.service;

import com.project.qvick.domain.check.client.dto.request.CodeRequest;
import com.project.qvick.domain.check.domain.repository.jpa.CheckCodeRepository;
import com.project.qvick.domain.check.exception.CheckAlreadyExistsException;
import com.project.qvick.domain.check.exception.CheckCodeError;
import com.project.qvick.domain.user.application.util.UserUtil;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.RoomRequest;
import com.project.qvick.domain.user.client.dto.request.StdIdEditRequest;
import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.domain.mapper.UserMapper;
import com.project.qvick.domain.user.domain.repository.jpa.UserRepository;
import com.project.qvick.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserUtil userUtil;
    private final CheckCodeRepository checkCodeRepository;

    @Override
    public void editUserStdId(StdIdEditRequest request) {
        User user = userUtil.findUser();
        user.setStdId(request.getStdId());
        userRepository.save(userMapper.toEdit(user));
    }

    @Override
    public void deleteUser() {
        userRepository.deleteById(userUtil.findUser().getId());
    }

    @Override
    public void editRoom(RoomRequest request){
        User user = userUtil.findUser();
        user.setRoom(request.getRoom());
        userRepository.save(userMapper.toEdit(user));
    }

    @Override
    public User findUser(){
        return userUtil.findUser();
    }

    @Override
    public void check(CodeRequest request) {
        User user = userUtil.findUser();
        if(user.isChecked()){
            throw CheckAlreadyExistsException.EXCEPTION;
        }
        else{
            if (checkCodeRepository.existsByCodeAndValid(request.getCode(), true)) {
                user.setChecked(true);
                userRepository.save(userMapper.toEdit(user));
            } else {
                throw CheckCodeError.EXCEPTION;
            }
        }
    }

    public boolean isChecked(){
        User user = userUtil.findUser();
        if(user.isChecked()){
            return true;
        }
        return false;
    }

}