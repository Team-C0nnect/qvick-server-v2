package com.project.qvick.domain.outing.domain.repository.query;

import com.project.qvick.domain.outing.client.dto.Outing;
import com.project.qvick.domain.outing.client.dto.request.OutingPageRequest;

import java.util.List;

public interface OutingQueryRepository {

    List<Outing> findStudents(OutingPageRequest request);

}
