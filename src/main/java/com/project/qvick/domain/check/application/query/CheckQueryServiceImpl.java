package com.project.qvick.domain.check.application.query;

import com.project.qvick.domain.check.domain.repository.query.CheckQueryRepository;
import com.project.qvick.domain.check.presentation.dto.CheckList;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckQueryServiceImpl implements CheckQueryService {

    private final CheckQueryRepository checkQueryRepository;


    @Override
    public List<CheckList> findCheck(PageRequest pageRequest) {
        return checkQueryRepository.findCheck(pageRequest);
    }

    public List<String> findAllNonCheckUser(PageRequest pageRequest) {
        return checkQueryRepository.findAllNonCheckUser(pageRequest);
    }

}

