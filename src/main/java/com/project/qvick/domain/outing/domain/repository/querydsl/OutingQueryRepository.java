package com.project.qvick.domain.outing.domain.repository.querydsl;

import com.project.qvick.domain.outing.presentation.dto.Outing;
import com.project.qvick.domain.outing.presentation.dto.request.OutingPageRequest;

import java.util.List;

public interface OutingQueryRepository {

    List<Outing> findStudents(OutingPageRequest request);

}
