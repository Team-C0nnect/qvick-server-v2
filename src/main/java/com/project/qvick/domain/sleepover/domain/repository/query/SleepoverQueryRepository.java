package com.project.qvick.domain.sleepover.domain.repository.query;

import com.project.qvick.domain.sleepover.client.dto.Sleepover;
import com.project.qvick.domain.sleepover.client.dto.request.SleepoverPageRequest;

import java.util.List;

public interface SleepoverQueryRepository {

    List<Sleepover> findStudents(SleepoverPageRequest request);

}
