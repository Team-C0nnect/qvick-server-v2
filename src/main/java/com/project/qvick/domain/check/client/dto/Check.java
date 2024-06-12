package com.project.qvick.domain.check.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Check {
    private String name;
    private String stdId;
    private String room;
    private boolean isChecked;
    private LocalDateTime checkedDate;
}
