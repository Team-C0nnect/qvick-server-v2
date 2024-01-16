package com.project.qvick.domain.leave.service.querydsl;

import com.project.qvick.domain.leave.presentation.dto.response.LeaveResponse;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface LeaveQueryService {

    List<LeaveResponse> findLeaves(PageRequest pageRequest);

}
