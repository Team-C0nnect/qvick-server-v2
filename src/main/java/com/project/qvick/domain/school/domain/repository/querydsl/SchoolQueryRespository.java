package com.project.qvick.domain.school.domain.repository.querydsl;

import com.project.qvick.domain.school.presentation.dto.School;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface SchoolQueryRespository {
    List<School> schoolList(PageRequest request);
}
