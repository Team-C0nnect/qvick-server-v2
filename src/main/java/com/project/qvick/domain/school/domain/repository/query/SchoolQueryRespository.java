package com.project.qvick.domain.school.domain.repository.query;

import com.project.qvick.domain.school.client.dto.School;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface SchoolQueryRespository {
    List<School> schoolList(PageRequest request);
}
