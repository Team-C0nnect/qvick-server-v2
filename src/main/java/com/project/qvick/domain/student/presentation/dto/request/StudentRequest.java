package com.project.qvick.domain.student.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {

    @NotBlank
    private String stdId;

}
