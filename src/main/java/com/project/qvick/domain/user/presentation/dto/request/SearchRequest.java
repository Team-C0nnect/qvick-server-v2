package com.project.qvick.domain.user.presentation.dto.request;

import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequest extends PageRequest {

    private String name;

}
