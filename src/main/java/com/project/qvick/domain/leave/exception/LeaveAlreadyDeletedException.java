package com.project.qvick.domain.leave.exception;

import com.project.qvick.domain.leave.exception.error.LeaveError;
import com.project.qvick.global.exception.BusinessException;
/*
* 이미 삭제 처리 된 퇴사주 일 때*/
public class LeaveAlreadyDeletedException extends BusinessException {

    public static final LeaveAlreadyDeletedException EXCEPTION = new LeaveAlreadyDeletedException();

    private LeaveAlreadyDeletedException(){
        super(LeaveError.LEAVE_NO_CONTENT);
    }

}
