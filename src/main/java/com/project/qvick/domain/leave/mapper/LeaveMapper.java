package com.project.qvick.domain.leave.mapper;

import com.project.qvick.domain.leave.domain.LeaveEntity;
import com.project.qvick.domain.leave.presentation.dto.Leave;
import org.springframework.stereotype.Component;

@Component
/*
* 퇴사주 객체 매퍼*/
public class LeaveMapper {

    public LeaveEntity toCreate(Leave leave){
        return LeaveEntity.builder()
                .id(leave.getId())
                .leaveDate(leave.getLeaveDate())
                .build();
    }

}