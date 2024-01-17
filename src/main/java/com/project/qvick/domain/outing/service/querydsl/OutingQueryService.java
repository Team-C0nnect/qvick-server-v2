package com.project.qvick.domain.outing.service.querydsl;

import com.project.qvick.domain.outing.presentation.dto.Outing;
import com.project.qvick.domain.outing.presentation.dto.request.OutingPageRequest;

import java.util.List;

public interface OutingQueryService {

    List<Outing> findOutStudents(OutingPageRequest request);

}
