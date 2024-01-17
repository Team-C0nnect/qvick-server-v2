package com.project.qvick.domain.sleepover.service.querydsl;

import com.project.qvick.domain.sleepover.presentation.dto.Sleepover;
import com.project.qvick.domain.sleepover.presentation.dto.request.SleepoverPageRequest;

import java.util.List;

public interface SleepoverQueryService {

    List<Sleepover> findSleepoverStudents(SleepoverPageRequest request);

}
