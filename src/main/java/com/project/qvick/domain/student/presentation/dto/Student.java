package com.project.qvick.domain.student.presentation.dto;

import com.project.qvick.domain.user.domain.UserEntity;
import com.project.qvick.domain.user.presentation.dto.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Schema(description = "학생 학번")
    @NotBlank
    @Length(max = 4, min = 4)
    private String id;

    private UserEntity userId;

}
