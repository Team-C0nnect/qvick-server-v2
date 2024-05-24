package com.project.qvick.domain.check.application.query;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.check.domain.repository.query.CheckQueryRepository;
import com.project.qvick.domain.user.application.util.UserUtil;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckQueryServiceImpl implements CheckQueryService {

    private final CheckQueryRepository checkQueryRepository;
    private final UserUtil userUtil;

    @Override
    public List<Check> findCheck(PageRequest pageRequest) {
        return checkQueryRepository.findCheck(pageRequest);
    }

    public List<String> findAllNonCheckUser(PageRequest pageRequest) {
        return checkQueryRepository.findAllNonCheckUser(pageRequest);
    }

    @Override
    public Check findCheckById() {
        return checkQueryRepository.findCheckById(userUtil.findUser());
    }

}

