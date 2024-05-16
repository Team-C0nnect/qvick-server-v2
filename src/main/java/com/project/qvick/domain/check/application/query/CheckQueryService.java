package com.project.qvick.domain.check.application.query;

import com.project.qvick.domain.check.presentation.dto.CheckList;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface CheckQueryService {

    List<CheckList> findCheck(PageRequest pageRequest);

    List<String> findAllNonCheckUser(PageRequest pageRequest);

}

