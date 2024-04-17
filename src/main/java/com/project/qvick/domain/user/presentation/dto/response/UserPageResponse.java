package com.project.qvick.domain.user.presentation.dto.response;

import com.project.qvick.domain.user.domain.enums.Approval;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPageResponse {

    private Long id;
    private String name;
    private Approval approval;

}
