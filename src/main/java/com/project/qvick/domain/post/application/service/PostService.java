package com.project.qvick.domain.post.application.service;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostDeleteRequest;
import com.project.qvick.domain.post.client.dto.request.PostRegisterRequest;

public interface PostService {

    void postRegister(PostRegisterRequest request);

    Post postFind(Long postId);

    void postDelete(PostDeleteRequest request);
}
