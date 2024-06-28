package qvick.post.application.query;

import qvick.common.client.dto.request.PageRequest;
import qvick.post.dto.Post;
import qvick.post.request.PostSearchRequest;

import java.util.List;

public interface PostQueryService {

    List<Post> postList(PageRequest pageRequest);

    List<Post> postSearch(PostSearchRequest postSearchRequest);

}
