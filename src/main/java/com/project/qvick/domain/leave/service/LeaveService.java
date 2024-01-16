package com.project.qvick.domain.leave.service;

import com.project.qvick.domain.leave.presentation.dto.Leave;

public interface LeaveService {

    void registerLeaveWeek(Leave leave);

    void removeLeaveWeek(Long leaveId);

}