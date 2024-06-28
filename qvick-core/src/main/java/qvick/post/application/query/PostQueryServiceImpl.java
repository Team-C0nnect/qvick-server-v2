package qvick.post.application.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qvick.common.client.dto.request.PageRequest;
import qvick.post.domain.repository.query.PostQueryRepository;
import qvick.post.dto.Post;
import qvick.post.request.PostSearchRequest;

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
