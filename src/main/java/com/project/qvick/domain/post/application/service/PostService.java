package com.project.qvick.domain.post.application.service;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostDeleteRequest;
import com.project.qvick.domain.post.client.dto.request.PostEditRequest;
import com.project.qvick.domain.post.client.dto.request.PostRegisterRequest;

public interface PostService {

    void postRegister(PostRegisterRequest request);

    Post postFind(Long postId);

    void postEdit(PostEditRequest request);

    void postDelete(PostDeleteRequest request);
}
