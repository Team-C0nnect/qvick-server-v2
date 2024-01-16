package com.project.qvick.domain.leave.domain.repository.querydsl;

import com.project.qvick.domain.leave.presentation.dto.response.LeaveResponse;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

/*
* 쿼리dsl 리포지토리*/
public interface LeaveQueryRepository {

    List<LeaveResponse> findLeaves(PageRequest request);

}
