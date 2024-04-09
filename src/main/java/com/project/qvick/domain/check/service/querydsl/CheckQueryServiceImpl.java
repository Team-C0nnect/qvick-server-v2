package com.project.qvick.domain.check.service.querydsl;

import com.project.qvick.domain.check.domain.repository.querydsl.CheckQueryRepository;
import com.project.qvick.domain.check.presentation.dto.Check;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckQueryServiceImpl implements CheckQueryService {

    private final CheckQueryRepository checkQueryRepository;


    @Override
    public List<Check> findCheck(PageRequest pageRequest) {
        return checkQueryRepository.findCheck(pageRequest);
    }

}

