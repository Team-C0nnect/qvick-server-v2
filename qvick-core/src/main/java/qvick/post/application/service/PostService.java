package qvick.post.application.service;

import qvick.post.dto.Post;
import qvick.post.request.PostDeleteRequest;
import qvick.post.request.PostEditRequest;
import qvick.post.request.PostRegisterRequest;

public interface PostService {

    void postRegister(PostRegisterRequest request);

    Post postFind(Long postId);

    void postEdit(PostEditRequest request);

    void postDelete(PostDeleteRequest request);
}
