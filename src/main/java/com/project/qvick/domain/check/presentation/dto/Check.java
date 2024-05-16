package com.project.qvick.domain.check.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Check {

    private Long id;
    private Long userId;
    private String stdId;
    private String name;
    private String email;
    private String room;
    private LocalDate checkedDate;

}
