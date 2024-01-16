package com.project.qvick.domain.leave.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
public class LeaveResponse {

    private Long userId;
    private LocalDate leaveDate;

}