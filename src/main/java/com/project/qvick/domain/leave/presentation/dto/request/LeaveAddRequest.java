package com.project.qvick.domain.leave.presentation.dto.request;

import com.project.qvick.domain.leave.presentation.dto.Leave;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
/*
* 퇴사주 추가 요청 객체*/
public class LeaveAddRequest {

    @NotNull
    private LocalDate leaveDate;

    public Leave toLeave() {
        return Leave.builder()
                .leaveDate(this.leaveDate)
                .build();
    }

}
