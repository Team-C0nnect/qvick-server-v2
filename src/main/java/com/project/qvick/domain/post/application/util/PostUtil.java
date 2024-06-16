package com.project.qvick.domain.post.application.util;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostRegisterRequest;
import com.project.qvick.domain.post.domain.mapper.PostMapper;
import com.project.qvick.domain.post.domain.repository.jpa.PostRepository;
import com.project.qvick.domain.post.exception.PostNotFoundException;
import com.project.qvick.domain.user.application.util.UserUtil;
import com.project.qvick.global.annotation.Util;
import lombok.RequiredArgsConstructor;

@Util
@RequiredArgsConstructor
public class PostUtil {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserUtil userUtil;

    public Post findPost(Long postId) {
        return postRepository
                .findById(postId)
                .map(postMapper::toPost)
                .orElseThrow(()-> PostNotFoundException.EXCEPTION);
    }

    public void savePost(PostRegisterRequest request){
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(userUtil.getUser().getName())
                .build();
        postRepository.save(postMapper.toEntity(post));
    }

}
