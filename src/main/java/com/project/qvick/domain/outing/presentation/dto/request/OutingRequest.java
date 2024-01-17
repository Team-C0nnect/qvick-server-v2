package com.project.qvick.domain.outing.presentation.dto.request;

import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import com.project.qvick.domain.outing.presentation.dto.Outing;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OutingRequest {

    @NotBlank
    private String reason;
    @NotNull
    private OutingStatus approval;
    @NotNull
    private LocalDateTime startDateTime;
    @NotNull
    private LocalDateTime endDateTime;

    public Outing toOuting(){
        return Outing.builder()
                .reason(this.reason)
                .approval(this.approval)
                .startDateTime(this.startDateTime)
                .endDateTime(this.endDateTime)
                .build();
    }

}
