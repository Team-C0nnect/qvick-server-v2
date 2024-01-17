package com.project.qvick.domain.sleepover.presentation.dto.response;

import com.project.qvick.domain.sleepover.domain.enums.SleepoverStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SleepoverResponse {

    private Long id;
    private SleepoverStatus approval;
    private String reason;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
