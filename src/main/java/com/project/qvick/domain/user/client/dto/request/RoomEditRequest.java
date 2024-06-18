package com.project.qvick.domain.user.client.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RoomEditRequest {

    @Schema(description = "수정할 호실")
    @NotBlank
    @Length(max = 4, min = 4)
    private String room;
    private String stdId;

}
