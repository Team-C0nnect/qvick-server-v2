package com.project.qvick.domain.sleepover.client.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SleepoverSettingRequest {

    @Schema(description = "외박거절")
    @NotNull
    private Long sleepoverId;

}