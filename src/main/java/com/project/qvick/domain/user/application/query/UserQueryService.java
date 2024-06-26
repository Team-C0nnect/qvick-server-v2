package com.project.qvick.domain.user.application.query;

import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.UserSearchRequest;
import com.project.qvick.global.common.dto.request.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserQueryService {

    List<User> userList(PageRequest pageRequest);

    List<User> userSearch(UserSearchRequest searchRequest);

    List<User> studentList(PageRequest pageRequest);

    List<User> checkUsers(PageRequest pageRequest);

    @Transactional
    @Scheduled(cron = "0 0 1 * * *")  // 매일 오후 8시에 실행
    void updateChecked();

    List<User> nonCheckUsers(PageRequest pageRequest);

}
