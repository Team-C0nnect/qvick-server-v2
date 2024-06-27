package com.project.qvick.domain.post.client.dto.request;

import com.project.qvick.global.common.client.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSearchRequest extends PageRequest {

    private String title;

}
