package com.project.qvick.domain.outing.domain.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutingSettingRequest {

    @Schema(description = "외출 거절")
    @NotNull
    private Long OutingId;

}
