package com.project.qvick.domain.auth.presentation.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

    @Schema(name = "이름")
    @NotBlank
    private String name;

    @Schema(name = "이메일")
    @NotBlank
    private String email;

    @Schema(name = "비밀번호")
    @NotBlank
    private String password;

}
