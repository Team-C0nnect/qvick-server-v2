package com.project.qvick.domain.check.application.query;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.domain.check.domain.repository.query.CheckQueryRepository;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckQueryServiceImpl implements CheckQueryService {

    private final CheckQueryRepository checkQueryRepository;

    @Override
    public List<Check> findAllCheckUsers(PageRequest request) {
        return checkQueryRepository.findAllCheckUsers(request);
    }

}
