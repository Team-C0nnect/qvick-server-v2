package com.project.qvick.domain.user.presentation.dto;

import com.project.qvick.domain.user.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;

}
