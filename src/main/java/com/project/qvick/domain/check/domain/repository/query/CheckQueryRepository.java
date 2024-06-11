package com.project.qvick.domain.check.domain.repository.query;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface CheckQueryRepository {

    List<Check> findCheck(PageRequest pageRequest);

    List<String> findAllNonCheckUser(PageRequest pageRequest);

    List<Check> findNonCheckUser(PageRequest pageRequest);

    Check findCheckById(User user);

}
