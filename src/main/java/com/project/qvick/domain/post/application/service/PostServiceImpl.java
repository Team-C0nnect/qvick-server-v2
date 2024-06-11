package com.project.qvick.domain.post.application.service;

import com.project.qvick.domain.post.application.util.PostUtil;
import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostDeleteRequest;
import com.project.qvick.domain.post.client.dto.request.PostEditRequest;
import com.project.qvick.domain.post.client.dto.request.PostRegisterRequest;
import com.project.qvick.domain.post.domain.mapper.PostMapper;
import com.project.qvick.domain.post.domain.repository.jpa.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final PostUtil postUtil;

    @Override
    public void postRegister(PostRegisterRequest request) {
        postUtil.savePost(request);
    }

    @Override
    public Post postFind(Long postId) {
        return postUtil.findPost(postId);
    }

    @Override
    public void postEdit(PostEditRequest request){
        Post post = postUtil.findPost(request.getPostId());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        postRepository.save(postMapper.toEntity(post));
    }

    @Override
    public void postDelete(PostDeleteRequest request){
        postRepository.deleteById(request.getPostId());
    }

}
