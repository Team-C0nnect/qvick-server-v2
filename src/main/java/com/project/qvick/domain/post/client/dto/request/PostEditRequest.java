package com.project.qvick.domain.post.client.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostEditRequest {

    private Long postId;
    private String title;
    private String content;

}
