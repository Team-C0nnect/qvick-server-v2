package com.project.qvick.domain.outing.application.query;

import com.project.qvick.domain.outing.client.dto.Outing;
import com.project.qvick.domain.outing.client.dto.request.OutingPageRequest;

import java.util.List;

public interface OutingQueryService {

    List<Outing> findOutStudents(OutingPageRequest request);

}
