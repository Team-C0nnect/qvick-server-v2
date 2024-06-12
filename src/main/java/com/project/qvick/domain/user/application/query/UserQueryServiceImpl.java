package com.project.qvick.domain.user.application.query;

import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.UserSearchRequest;
import com.project.qvick.domain.user.domain.repository.query.UserQueryRepository;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService{

    private final UserQueryRepository userQueryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> userList(PageRequest pageRequest){
        return userQueryRepository.userList(pageRequest);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> userSearch(UserSearchRequest searchRequest){
        return userQueryRepository.userSearch(searchRequest);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> studentList(PageRequest pageRequest){
        return userQueryRepository.studentList(pageRequest);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> checkUsers(PageRequest pageRequest) {
        return userQueryRepository.checkUsers(pageRequest);
    }

    @Override
    @Transactional
    @Scheduled(cron = "0 30 20 * * *")  // 매일 오후 8시에 실행
    public void updateChecked() {
        userQueryRepository.updateChecked();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> nonCheckUsers(PageRequest pageRequest) {
        return userQueryRepository.nonCheckUsers(pageRequest);
    }

}