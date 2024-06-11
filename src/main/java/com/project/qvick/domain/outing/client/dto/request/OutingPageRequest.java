package com.project.qvick.domain.outing.client.dto.request;

import com.fasterxml.jackson.annotation.JsonValue;
import com.project.qvick.domain.outing.domain.enums.OutingStatus;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OutingPageRequest extends PageRequest {

    @JsonValue
    List<OutingStatus> outingStatuses;

    public OutingPageRequest(){
        outingStatuses = new ArrayList<>();
    }

}
