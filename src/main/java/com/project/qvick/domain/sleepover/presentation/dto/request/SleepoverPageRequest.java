package com.project.qvick.domain.sleepover.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonValue;
import com.project.qvick.domain.sleepover.domain.enums.SleepoverStatus;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SleepoverPageRequest extends PageRequest {

    @JsonValue
    List<SleepoverStatus> sleepoverStatuses;

    public SleepoverPageRequest() {
        sleepoverStatuses = new ArrayList<>();
    }

}