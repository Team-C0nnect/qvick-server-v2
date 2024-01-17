package com.project.qvick.domain.sleepover.domain.repository.querydsl;

import com.project.qvick.domain.sleepover.presentation.dto.Sleepover;
import com.project.qvick.domain.sleepover.presentation.dto.request.SleepoverPageRequest;

import java.util.List;

public interface SleepoverQueryRepository {

    List<Sleepover> findStudents(SleepoverPageRequest request);

}
