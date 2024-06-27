package com.project.qvick.domain.post.application.query;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostSearchRequest;
import com.project.qvick.global.common.client.dto.request.PageRequest;

import java.util.List;

public interface PostQueryService {
    List<Post> postList(PageRequest pageRequest);

    List<Post> postSearch(PostSearchRequest postSearchRequest);
}
