package com.project.qvick.domain.post.client.dto.request;

public record PostEditRequest(
    Long postId,
    String title,
    String content
){}
