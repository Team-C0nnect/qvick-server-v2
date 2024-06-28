package qvick.user.application.service;

import qvick.check.domain.repository.jpa.CheckCodeRepository;
import qvick.check.exception.CheckAlreadyExistsException;
import qvick.check.exception.CheckCodeError;
import qvick.check.request.CodeRequest;
import qvick.user.application.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import qvick.user.domain.mapper.UserMapper;
import qvick.user.domain.repository.jpa.UserRepository;
import qvick.user.dto.User;
import qvick.user.exception.PasswordWrongException;
import qvick.user.exception.UserNotFoundException;
import qvick.user.request.AdminPasswordEditRequest;
import qvick.user.request.AdminSetStatusRequest;
import qvick.user.request.PasswordEditRequest;
import qvick.user.request.RoomEditRequest;
import qvick.user.request.StdIdEditRequest;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserUtil userUtil;
    private final CheckCodeRepository checkCodeRepository;
    private final PasswordEncoder encoder;

    @Override
    public void editUserStdId(StdIdEditRequest request) {
        User user = userUtil.getUser();
        user.setStdId(request.getStdId());
        userRepository.save(userMapper.toEdit(user));
    }

    @Override
    public void deleteUser() {
        userRepository.deleteById(userUtil.getUser().getId());
    }

    @Override
    public void editRoom(RoomEditRequest request){
        User user = userUtil.findUserByStdId(request.getStdId());
        user.setRoom(request.getRoom());
        userRepository.save(userMapper.toEdit(user));
    }

    @Override
    public User findUser(){
        return userUtil.getUser();
    }

    @Override
    public void check(CodeRequest request) {
        User user = userUtil.getUser();
        if(user.isChecked()){
            throw CheckAlreadyExistsException.EXCEPTION;
        } else{
            if (checkCodeRepository.existsByCodeAndValid(request.code(), true)) {
                user.setChecked(true);
                userRepository.save(userMapper.toEdit(user));
            } else {throw CheckCodeError.EXCEPTION;}
        }
    }

    @Override
    public void editPassword(PasswordEditRequest request){
        User user = userUtil.getUser();
        if(!encoder.matches(request.getOldPassword(), user.getPassword()))
            throw PasswordWrongException.EXCEPTION;
        user.setPassword(encoder.encode(request.getNewPassword()));
        userRepository.save(userMapper.toEdit(user));
    }

    @Override
    public void adminEditPassword(AdminPasswordEditRequest request){
        User user = userUtil.findUserByEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getNewPassword()));
        userRepository.save(userMapper.toEdit(user));
    }

    @Override
    public void adminDeleteUser(String email){
        if(userRepository.findByEmail(email).isEmpty())
            throw UserNotFoundException.EXCEPTION;
        userRepository.deleteByEmail(email);
    }

    public boolean isChecked(){
        User user = userUtil.getUser();
        if(user.isChecked()){
            return true;
        }
        return false;
    }

    @Override
    public void fixStatus(AdminSetStatusRequest setStatusRequest) {
        User user = userUtil.findUserByEmail(setStatusRequest.getEmail());
        user.setChecked(setStatusRequest.getStatus() == 1 ? false : true);
        userRepository.save(userMapper.toEdit(user));
    }

}
