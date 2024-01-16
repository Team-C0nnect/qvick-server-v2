package com.project.qvick.domain.leave.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
/*페이징 처리 시 리스트로 보내줄 때 사용하는 객체*/
public class LeaveResponse {

    private LocalDate leaveDate;

}