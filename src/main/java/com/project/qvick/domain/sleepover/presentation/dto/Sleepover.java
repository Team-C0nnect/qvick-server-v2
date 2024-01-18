package com.project.qvick.domain.sleepover.presentation.dto;

import com.project.qvick.domain.sleepover.domain.enums.SleepoverStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sleepover {

    private Long id;
    private Long userId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String reason;
    private SleepoverStatus approval;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
