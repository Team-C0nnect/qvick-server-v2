package com.project.qvick.domain.post.application.query;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface PostQueryService {
    List<Post> postList(PageRequest pageRequest);
}
