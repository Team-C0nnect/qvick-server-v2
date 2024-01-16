package com.project.qvick.domain.leave.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/* 기본적인 퇴사주 dto */
public class Leave {

    private Long id;
    private LocalDate leaveDate;

}
