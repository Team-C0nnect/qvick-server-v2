package com.project.qvick.domain.user.dto.request;

import com.fasterxml.jackson.annotation.JsonValue;
import com.project.qvick.domain.user.domain.enums.Approval;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserApprovalPageRequest extends PageRequest {

    @JsonValue
    List<Approval> approvals;

    public UserApprovalPageRequest() {
        approvals = new ArrayList<>();
    }
}
