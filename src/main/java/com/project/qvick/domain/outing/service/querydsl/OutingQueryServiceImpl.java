package com.project.qvick.domain.outing.service.querydsl;

import com.project.qvick.domain.outing.domain.repository.querydsl.OutingQueryRepositoryImpl;
import com.project.qvick.domain.outing.presentation.dto.Outing;
import com.project.qvick.domain.outing.presentation.dto.request.OutingPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OutingQueryServiceImpl implements OutingQueryService{

    private final OutingQueryRepositoryImpl repository;

    @Override
    @Transactional(readOnly = true)
    public List<Outing> findOutStudents(OutingPageRequest request) {
        return repository.findStudents(request);
    }

}
