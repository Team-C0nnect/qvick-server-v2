package com.project.qvick.domain.post.application.service;

import com.project.qvick.domain.post.client.dto.request.PostRegisterRequest;
import com.project.qvick.domain.post.domain.mapper.PostMapper;
import com.project.qvick.domain.post.domain.repository.jpa.PostRepository;
import com.project.qvick.domain.user.application.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserUtil userUtil;

    @Override
    public void postRegister(PostRegisterRequest request) {
        postRepository.save(postMapper.toEntity(request,userUtil.findUser().getName()));
    }

}
