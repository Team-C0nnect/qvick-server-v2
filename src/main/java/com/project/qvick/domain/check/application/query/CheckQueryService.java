package com.project.qvick.domain.check.application.query;

import com.project.qvick.domain.check.client.dto.Check;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface CheckQueryService {

    List<Check> findCheck(PageRequest pageRequest);

    List<String> findAllNonCheckUser(PageRequest pageRequest);

    Check findCheckById();

}

