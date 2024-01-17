package com.project.qvick.domain.sleepover.service.querydsl;

import com.project.qvick.domain.sleepover.domain.repository.querydsl.SleepoverQueryRepositoryImpl;
import com.project.qvick.domain.sleepover.presentation.dto.Sleepover;
import com.project.qvick.domain.sleepover.presentation.dto.request.SleepoverPageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SleepoverQueryServiceImpl implements SleepoverQueryService {

    private final SleepoverQueryRepositoryImpl queryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Sleepover> findSleepoverStudents(SleepoverPageRequest request) {
        return queryRepository.findStudents(request);
    }

}
