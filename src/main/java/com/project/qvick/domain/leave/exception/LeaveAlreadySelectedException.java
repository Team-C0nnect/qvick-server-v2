package com.project.qvick.domain.leave.exception;

import com.project.qvick.domain.leave.exception.error.LeaveError;
import com.project.qvick.global.exception.BusinessException;

/*
* 이미 퇴사주 설정이 되었을 때*/
public class LeaveAlreadySelectedException extends BusinessException {

    public static final LeaveAlreadySelectedException EXCEPTION = new LeaveAlreadySelectedException();

    private LeaveAlreadySelectedException(){
        super(LeaveError.LEAVE_CONFLICT);
    }

}
