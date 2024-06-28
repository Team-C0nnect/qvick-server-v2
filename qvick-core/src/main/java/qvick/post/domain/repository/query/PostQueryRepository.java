package qvick.post.domain.repository.query;

import qvick.common.client.dto.request.PageRequest;
import qvick.post.dto.Post;
import qvick.post.request.PostSearchRequest;

import java.util.List;

public interface PostQueryRepository {

    List<Post> postList(PageRequest request);

    List<Post>postSearch(PostSearchRequest request);

}
