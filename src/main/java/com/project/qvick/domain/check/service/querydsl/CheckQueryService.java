package com.project.qvick.domain.check.service.querydsl;

import com.project.qvick.domain.check.presentation.dto.Check;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface CheckQueryService {

    List<String> findAllNonCheckUser(PageRequest pageRequest);

    List<Check> findCheck(PageRequest pageRequest);

}

