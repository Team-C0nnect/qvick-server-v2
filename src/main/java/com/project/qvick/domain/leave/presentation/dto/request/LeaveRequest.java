package com.project.qvick.domain.leave.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaveRequest {

    @NotNull
    private Long id;

}
