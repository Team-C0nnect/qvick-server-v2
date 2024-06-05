package com.project.qvick.domain.post.application.query;

import com.project.qvick.domain.post.client.dto.Post;
import com.project.qvick.domain.post.client.dto.request.PostSearchRequest;
import com.project.qvick.domain.post.domain.repository.query.PostQueryRepository;
import com.project.qvick.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostQueryServiceImpl implements PostQueryService {

    private final PostQueryRepository postQueryRepository;

    @Override
    public List<Post> postList(PageRequest pageRequest) {
        return postQueryRepository.postList(pageRequest);
    }

    @Override
    public List<Post> postSearch(PostSearchRequest postSearchRequest) {
        return postQueryRepository.postSearch(postSearchRequest);
    }

}
