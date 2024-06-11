package com.project.qvick.domain.user.client.dto;

import com.project.qvick.domain.user.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String stdId;
    private String room;
    private UserRole userRole;
    private boolean isChecked;
    private LocalDateTime checkedDate;

}
