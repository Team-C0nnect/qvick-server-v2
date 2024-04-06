package com.project.qvick.domain.user.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class UserEditRequest {

    @Schema(description = "수정할 학번")
    @NotBlank
    @Length(max = 4, min = 4)
    private String stdId;

}
