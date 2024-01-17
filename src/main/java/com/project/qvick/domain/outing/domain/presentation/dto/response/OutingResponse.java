package com.project.qvick.domain.outing.domain.presentation.dto.response;

import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class OutingResponse {

    private Long id;
    private String reason;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private OutingStatus approval;

}
