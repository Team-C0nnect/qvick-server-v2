package com.project.qvick.domain.outing.client.dto;

import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Outing {

    private Long id;
    private Long userId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String reason;
    private OutingStatus approval;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
