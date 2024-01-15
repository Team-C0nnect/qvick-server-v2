package com.project.qvick.domain.student.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
public class StudentEditRequest {

    @Schema(description = "수정할 학번")
    @NotBlank
    @Length(max = 4, min = 4)
    private String stdId;

}
